package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class TestMethod extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>调用了 GET 方法</h1>");
		// 获取 GET请求的参数
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		out.println("<h1>"+user+"</h1>");
		out.println("<h1>"+pass+"</h1>");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>调用了 POST 方法</h1>");
		// 获取 POST请求的参数
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		out.println("<h1>"+user+"</h1>");
		out.println("<h1>"+pass+"</h1>");
	}
}

