package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestConcurrent extends HttpServlet {
	// 实例变量
	String username;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");		
		// Servlet中，尽量避免使用实例变量，因为这是线程不安全的。
		// 如果一定要使用实例变量，就用同步块进行加锁处理，如此才能保证 Servlet 的线程安全。
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
