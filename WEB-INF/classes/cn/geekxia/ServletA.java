package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletA extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ��ȡת����������ַ�ʽ����ѡһ����
		RequestDispatcher rd = null;
		// ��ʽ1
		rd = req.getRequestDispatcher("/ServletB");
		// ��ʽ2
		rd = this.getServletContext().getNamedDispatcher("ServletB");
		// ��ʽ3
		rd = this.getServletContext().getRequestDispatcher("/ServletB");
		
		// ת��
		rd.forward(req, res);
	}
}
