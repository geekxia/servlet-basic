package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletC extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.equals("1")) {
			// 将当前 Servlet 重定向到 ServletB
			res.sendRedirect("ServletB");	// 参数是 Servlet 名称
		} else {
			// 将当前 Servlet 重定向到 根路径
			res.sendRedirect("/servlet-lesson/index.html");	// 参数是 URL 路径
		}
	}
}