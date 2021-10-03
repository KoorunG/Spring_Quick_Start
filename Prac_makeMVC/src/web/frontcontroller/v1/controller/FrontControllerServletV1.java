package web.frontcontroller.v1.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.frontcontroller.v1.ControllerV1;

@WebServlet("/front-controller/v1/*")		// /front-controller/v1/ 의 경로로 오는 모든 것을 여기에 매핑한 것! 
public class FrontControllerServletV1 extends HttpServlet {		// 프론트 컨트롤러만 서블릿을 상속받으면 됨
	
	private Map<String, ControllerV1> controllerMap = new HashMap<>();	// String 타입의 url 경로로 컨트롤러를 꺼낼 것임
	
	public FrontControllerServletV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
	}
	// 생성자에서 위에 만들어놓은 contorllerMap에 각 컨트롤러를 저장함 

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		
		ControllerV1 controller = controllerMap.get(requestURI);	
		// 위에서 URI 주소로 각 컨트롤러를 매핑했으므로, requestURI를 키로 컨트롤러를 꺼내올 수 있다
		
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); 
		}
		// 컨트롤러가 비어있다면 => 404 NOT FOUND 응답코드를 전송한다!
		
		controller.process(request, response);
		// 컨트롤러가 비어있지 않다면 process한다
	}
	
	
}
