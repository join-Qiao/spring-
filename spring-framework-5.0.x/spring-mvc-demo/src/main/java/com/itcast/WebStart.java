package com.itcast;

import com.itcast.config.WebAppConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebStart {

	public static void main(String[] args) {


		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();

		DispatcherServlet dispatcherServlet = new DispatcherServlet();

	}
}
