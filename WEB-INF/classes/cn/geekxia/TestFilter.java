package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
		// 获取在部署描述符中配置的初始化参数
		String filterValue = config.getInitParameter("filterKey");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 把过滤器的请求响应对象强制转化成 HTTP的请求响应对象
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		// 获取 Session 对象，判断是否保存有客户端用户的用户信息
		HttpSession session = req.getSession();
		if (session.getAttribute("username") == null) {
			// 没有登录，重定向到的首页
			res.sendRedirect("/servlet-lesson/index.html");
		} else {
			// 已有登录，把过滤器传递至下一个过滤器或者Servlet去处理
			chain.doFilter(request, response);
		}
	}
	public void destroy() {}
}
