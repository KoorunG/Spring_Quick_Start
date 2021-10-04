package web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.frontcontroller.ModelView;
import web.frontcontroller.MyView;
import web.frontcontroller.v3.controller.MemberFormControllerV3;
import web.frontcontroller.v3.controller.MemberListControllerV3;
import web.frontcontroller.v3.controller.MemberSaveControllerV3;

@WebServlet(name = "frontControllerServletV3" , urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

	// 컨트롤러 맵
	private Map<String, ControllerV3> controllerMap = new HashMap<>();

	// 생성자에서 컨트롤러 정보 입력
	public FrontControllerServletV3() {
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
	
	// HttpServletRequest 요청 정보를 바탕으로 paramMap을 만드는 메소드
	private Map<String, String> createParamMap(HttpServletRequest request) {
		
		// 파라미터 맵 객체를 만든 뒤
		Map<String, String> paramMap = new HashMap<>();
		
		// 요청 파라미터의 키값이 존재하는 동안
		while(request.getParameterNames().hasMoreElements()) {
			
			// whill문을 이용하여 paramName과 value를 얻고
			String paramName = request.getParameterNames().nextElement();
			String value = request.getParameter(paramName);
			
			// 위에서 만든 paramMap에 저장한 뒤
			paramMap.put(paramName, value);
		}
		
		// paramMap을 반환한다
		return paramMap;
	}
	
	private MyView viewResolver(String viewName) {
		
		// 인자로 받은 viewName으로 viewPath를 만들 수 있고
		return new MyView("/WEB-INF/views/"+viewName+".jsp");
		// 만든 뷰를 반환함
		
	}
}
