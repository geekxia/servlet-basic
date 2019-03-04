package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletC extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.equals("1")) {
			// ����ǰ Servlet �ض��� ServletB
			res.sendRedirect("ServletB");	// ������ Servlet ����
		} else {
			// ����ǰ Servlet �ض��� ��·��
			res.sendRedirect("/servlet-lesson/index.html");	// ������ URL ·��
		}
	}
}