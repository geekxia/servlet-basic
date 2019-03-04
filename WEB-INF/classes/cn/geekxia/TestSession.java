package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestSession extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		// ��ȡ�û���¼���û���������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// ����һ�� Session ����
		HttpSession session = req.getSession();
		// ���� Session ����Ĺ���ʱ��
		session.setMaxInactiveInterval(2 * 60);
		// �ֶ����� Session ����
		// session.invalidate();
		
		// �� Session �����ж�ȡ�û���Ϣ������ǵ�һ�η��ʣ�Session ����û���û���Ϣ��
		String name = (String)session.getAttribute("username");
		PrintWriter out = res.getWriter();
		if (name != null) {	// �ٴη���ʱ
			out.println("<h1>"+name+" �ٴη��ʣ��Զ���¼</h1>");
			out.close();
		} else {	// ��һ�η���ʱ
			out.println("<h1>"+name+" ��һ�η���</h1>");
			out.close();
		}
		// ���û���Ϣ���浽 Session ������ȥ�������ڷ����
		session.setAttribute("username", username);
		// ���ͻ��˵�һ�η���ʱ������ Cookie�ķ�ʽ��ͻ���д��һ����Ϊ JSESSIONID �� Cookie��
		// �ͻ����ٴη���ʱ�������Щ����ȡ������� Session ���������洢���û���Ϣ�ˡ�
	}
}
