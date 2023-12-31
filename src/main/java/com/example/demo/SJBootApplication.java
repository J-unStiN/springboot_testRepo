package com.example.demo;


import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SJBootApplication {

	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(HelloController.class); // bin등록방법을 클래스 정보만 넘겨줌.
		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.addServlet("hello", new HttpServlet() {
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						// 프론트 컨트롤러를 통해 인증, 보안, 다국어, 공통기능을 처리
						if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
							String name = req.getParameter("name");

							HelloController helloController = applicationContext.getBean(HelloController.class);// 클래스타입을 적어서 해당빈이 있으면 반환
							String ret = helloController.hello(name);

							resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
							resp.getWriter().println(ret);
						}
						else {
							resp.setStatus(HttpStatus.NOT_FOUND.value());
						}

					}
				}).addMapping("/*"); // 프론트컨트롤러 - /아래로 들어오는 모든 요청을 처리함
			}
		});
		webServer.start();
	}

}
