package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
       
	// 수정된 DispatcherServlet 클래스에는 init 메소드가 오버라이드 되어있음
	// 서블릿의 init() 메소드는 서블릿 객체가 생성된 후 실행되어 멤버변수를 초기화하는 역할
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);	// 뷰 리졸버를 통해 .jsp 파일을 연결함
		} else {
			view = viewName;						// xx.do 경로이므로 그냥 넣으면 됨
		}
		
		// 5. 검색된 화면으로 이동한다
		response.sendRedirect(view);
	}
}
