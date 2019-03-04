package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestConcurrent extends HttpServlet {
	// ʵ������
	String username;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");		
		// Servlet�У���������ʹ��ʵ����������Ϊ�����̲߳���ȫ�ġ�
		// ���һ��Ҫʹ��ʵ������������ͬ������м���������˲��ܱ�֤ Servlet ���̰߳�ȫ��
		synchronized(this) {
			username = req.getParameter("username");
			PrintWriter out = res.getWriter();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.println("<h1>"+username+"</h1>");
			out.close();
		}
	}
}
