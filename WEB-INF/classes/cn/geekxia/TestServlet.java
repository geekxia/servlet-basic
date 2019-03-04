package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	public void init() throws ServletException {
		System.out.print("init");
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.print("service");
	}
	// 在 Servlet实例销毁前 被调用 
	public void destroy() {
		System.out.print("destroy");
	}
}
