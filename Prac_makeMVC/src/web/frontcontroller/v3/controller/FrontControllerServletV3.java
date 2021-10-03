package web.frontcontroller.v3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.frontcontroller.ModelView;
import web.frontcontroller.MyView;
import web.frontcontroller.v3.ControllerV3;

@WebServlet("/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

	// 컨트롤러 맵
	private Map<String, ControllerV3> controllerMap = new HashMap<>();

	// 생성자에서 컨트롤러 정보 입력
	public FrontControllerServletV3(Map<String, ControllerV3> controllerMap) {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URI 정보로 컨트롤러 맵에서 controller 얻음
		String requestURI = request.getRequestURI();
		ControllerV3 controller = controllerMap.get(requestURI);
		
		// 해당하는 컨트롤러가 없으면
		if(controller == null) {
			// 404 NOT FOUND 응답코드 전송
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// request를 기반으로 paramMap을 제작하는 메소드 createParamMap 호출
		Map<String, String> paramMap = createParamMap(request);
		
		// 컨트롤러의 process()로 ModelView 객체 생성
		ModelView mv = controller.process(paramMap);
		
		// ModelView 객체에서 viewName을 얻어올 수 있으며
		String viewName = mv.getViewName();
		
		// viewResolver을 통해 뷰 이름을 기반으로 view를 생성하여
		MyView view = viewResolver(viewName);
		
		// render() 으로 뷰에 포워딩함! (여기서 mv.getModel()으로 model을 꺼내 같이 넘겨주는 것이 포인트)
		view.render(mv.getModel(), request, response);
	}

	private MyView viewResolver(String viewName) {
		
		// 인자로 받은 viewName으로 viewPath를 만들 수 있고
		MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
		// 만든 뷰를 반환함
		return view;
	}

	
	// HttpServletRequest 요청 정보를 바탕으로 paramMap을 만드는 메소드
	private Map<String, String> createParamMap(HttpServletRequest request) {
		
		// 파라미터 맵 객체를 만든 뒤
		Map<String, String> paramMap = new HashMap<>();
		
		// request.getParameterNames().hasMoreElements() => 파라미터의 이름이 있는지를 검사하는 메소드
		while(request.getParameterNames().hasMoreElements()) {
			
			// request.getParameterNames().nextElement()으로 파라미터의 이름을 추출할 수 있다!
			String paramName = (String)(request.getParameterNames().nextElement());
			// 추출한 파라미터의 이름을 키값으로, value는 request.getParameter(paramName)을 넣는다
			paramMap.put(paramName, request.getParameter(paramName));
		}
		
		// 완성한 파라미터 맵을 리턴
		return paramMap;
		
	}
	
	
	
	
}
