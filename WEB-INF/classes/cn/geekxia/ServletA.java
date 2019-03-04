package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletA extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取转发对象的三种方式，三选一即可
		RequestDispatcher rd = null;
		// 方式1
		rd = req.getRequestDispatcher("/ServletB");
		// 方式2
		rd = this.getServletContext().getNamedDispatcher("ServletB");
		// 方式3
		rd = this.getServletContext().getRequestDispatcher("/ServletB");
		
		// 转发
		rd.forward(req, res);
	}
}
