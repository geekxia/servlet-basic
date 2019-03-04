package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class TestCookie extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = null;
		// ��ȡ�û���¼���û���������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// �������� Cookie ����
		Cookie userCookie = new Cookie("username", username);
		Cookie passCookie = new Cookie("password", password);
		// ���� Cookie ����ʱ��
		userCookie.setMaxAge(2 * 60);	// �����Ӻ����
		passCookie.setMaxAge(2 * 60);

		// �� Cookie ��ӵ���Ӧ������
		res.addCookie(userCookie);
		res.addCookie(passCookie);

		// �����������ȡ�� Cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {		// ���ǵ�һ�η��ʣ���¼��ʱ
			for (Cookie cookie: cookies) {
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}

		try {
			PrintWriter out = res.getWriter();
			if (username.equals("admin") && password.equals("123456")) {
				out.println("<h1>admin �û���¼�ɹ�</h1>");
				out.close();
			} else {
				out.println("<h1>��¼����</h1>");
				out.close();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}