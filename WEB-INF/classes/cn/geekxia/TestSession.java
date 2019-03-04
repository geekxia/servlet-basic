package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestSession extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		// 获取用户登录的用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 创建一个 Session 对象
		HttpSession session = req.getSession();
		// 设置 Session 对象的过期时间
		session.setMaxInactiveInterval(2 * 60);
		// 手动设置 Session 过期
		// session.invalidate();
		
		// 从 Session 对象中读取用户信息。如果是第一次访问，Session 中是没有用户信息的
		String name = (String)session.getAttribute("username");
		PrintWriter out = res.getWriter();
		if (name != null) {	// 再次访问时
			out.println("<h1>"+name+" 再次访问，自动登录</h1>");
			out.close();
		} else {	// 第一次访问时
			out.println("<h1>"+name+" 第一次访问</h1>");
			out.close();
		}
		// 把用户信息保存到 Session 对象中去，保存在服务端
		session.setAttribute("username", username);
		// 当客户端第一次访问时，会以 Cookie的方式向客户端写入一个名为 JSESSIONID 的 Cookie。
		// 客户端再次访问时，便可以些来读取服务端中 Session 对象中所存储的用户信息了。
	}
}
