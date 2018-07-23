package com.zzz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class PathListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("监听器被销毁了");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("path", arg0.getServletContext().getContextPath());
		System.out.println("监听器初始化"+arg0.getServletContext().getContextPath());
	}
}
