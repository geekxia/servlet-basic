package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class TestServletConfig extends HttpServlet {
	public void init() throws ServletException {
		ServletConfig config = this.getServletConfig();
		String v1 = config.getInitParameter("k1");
		String v2 = config.getInitParameter("k2");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		ServletConfig config = this.getServletConfig();
		String v1 = config.getInitParameter("k1");
		String v2 = config.getInitParameter("k2");
		out.println("<h1>"+v1+"</h1>");
		out.println("<h1>"+v2+"</h1>");
		out.close();
	}
}
