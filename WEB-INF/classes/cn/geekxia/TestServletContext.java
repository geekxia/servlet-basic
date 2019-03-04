package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestServletContext extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		ServletContext context = this.getServletContext();
		String v1 = context.getInitParameter("global-k1");
		String v2 = context.getInitParameter("global-k2");
		// 动态设置全局的 配置参数
		context.setAttribute("global-k3", "geekxia-3");
		String v3 = (String)context.getAttribute("global-k3");
		// 动态删除、获取全局的配置参数
		context.removeAttribute("global-k1");
		String v4 = (String)context.getAttribute("global-k1");
		out.println("<h1>"+v1+"</h1>");
		out.println("<h1>"+v2+"</h1>");
		out.println("<h1>"+v3+"</h1>");
		out.println("<h1>"+v4+"</h1>");
		out.close();
	}
}