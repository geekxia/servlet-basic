package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class TestCookie extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = null;
		// 获取用户登录的用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 创建两个 Cookie 对象
		Cookie userCookie = new Cookie("username", username);
		Cookie passCookie = new Cookie("password", password);
		// 设置 Cookie 过期时间
		userCookie.setMaxAge(2 * 60);	// 两分钟后过期
		passCookie.setMaxAge(2 * 60);

		// 把 Cookie 添加到响应体中云
		res.addCookie(userCookie);
		res.addCookie(passCookie);

		// 从请求对象中取出 Cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {		// 不是第一次访问（登录）时
			for (Cookie cookie: cookies) {
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}

		try {
			PrintWriter out = res.getWriter();
			if (username.equals("admin") && password.equals("123456")) {
				out.println("<h1>admin 用户登录成功</h1>");
				out.close();
			} else {
				out.println("<h1>登录错误</h1>");
				out.close();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}