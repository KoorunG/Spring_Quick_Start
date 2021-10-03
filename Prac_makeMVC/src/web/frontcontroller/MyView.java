package web.frontcontroller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {

	private String viewPath;
	
	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	// V2에서 사용하는 render 
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	// V3에서 사용하는 render (오버로딩)
	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modelToRequestAttribute(model, request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	// JSP에서는 요청의 attribute를 바탕으로 값을 저장하는 과정이 필요하기 때문에
	// model의 String key, Object value를 바탕으로 request.setAttribute(key, value)를 하는 메소드를 만들어줬다
	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
		model.forEach((key, value) -> request.setAttribute(key, value));
	}
}