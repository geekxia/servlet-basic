package cn.geekxia;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestListener implements HttpSessionAttributeListener, ServletContextListener, ServletRequestListener  {
	public void requestInitialized(ServletRequestEvent e) {
		// ���ͻ��������ʼ��ʱ�������¼�
	}
	public void requestDestroyed(ServletRequestEvent e) {
		// ����������ʱ�������¼�
	}
	public void contextInitialized(ServletContextEvent e) {
		// ��Ӧ�ó�ʼ��ʱ����
	}
	public void contextDestroyed(ServletContextEvent e) {
		// ��Ӧ�ñ�����ʱ����
	}
	public void attributeAdded(HttpSessionBindingEvent e) {
		// �� session���������������ӽ�����
	}	
	public void attributeRemoved(HttpSessionBindingEvent e) {
		// �� session�����������Ա��Ƴ�ʱ����
	}
	public void attributeReplaced(HttpSessionBindingEvent e) {
		// �� session�����������Ա��滻ʱ����
	}
}
