package cn.geekxia;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
		// ��ȡ�ڲ��������������õĳ�ʼ������
		String filterValue = config.getInitParameter("filterKey");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// �ѹ�������������Ӧ����ǿ��ת���� HTTP��������Ӧ����
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		// ��ȡ Session �����ж��Ƿ񱣴��пͻ����û����û���Ϣ
		HttpSession session = req.getSession();
		if (session.getAttribute("username") == null) {
			// û�е�¼���ض��򵽵���ҳ
			res.sendRedirect("/servlet-lesson/index.html");
		} else {
			// ���е�¼���ѹ�������������һ������������Servletȥ����
			chain.doFilter(request, response);
		}
	}
	public void destroy() {}
}
