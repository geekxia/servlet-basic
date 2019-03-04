package cn.geekxia;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestListener implements HttpSessionAttributeListener, ServletContextListener, ServletRequestListener  {
	public void requestInitialized(ServletRequestEvent e) {
		// 当客户端请求初始化时触发该事件
	}
	public void requestDestroyed(ServletRequestEvent e) {
		// 当请求被销毁时触发该事件
	}
	public void contextInitialized(ServletContextEvent e) {
		// 当应用初始化时触发
	}
	public void contextDestroyed(ServletContextEvent e) {
		// 当应用被销毁时触发
	}
	public void attributeAdded(HttpSessionBindingEvent e) {
		// 当 session对象中有属性增加进触发
	}	
	public void attributeRemoved(HttpSessionBindingEvent e) {
		// 当 session对象中有属性被移除时触发
	}
	public void attributeReplaced(HttpSessionBindingEvent e) {
		// 当 session对象中有属性被替换时触发
	}
}
