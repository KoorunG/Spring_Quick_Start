package web.frontcontroller.v4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.frontcontroller.MyView;
import web.frontcontroller.v4.controller.MemberFormControllerV4;
import web.frontcontroller.v4.controller.MemberListControllerV4;
import web.frontcontroller.v4.controller.MemberSaveControllerV4;

@WebServlet("/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

	private Map<String, ControllerV4> controllerMap = new HashMap<>();

	public FrontControllerServletV4() {
		controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
		controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
		controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();

		ControllerV4 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();

		String viewName = controller.process(paramMap, model);

		MyView view = viewResolver(viewName);
		view.render(model, request, response);
	}

	
	// HttpServletRequest 요청 정보를 바탕으로 paramMap을 만드는 메소드
	private Map<String, String> createParamMap(HttpServletRequest request) {

		// 파라미터 맵 객체를 만든 뒤
		Map<String, String> paramMap = new HashMap<>();

		// 요청 파라미터의 키값이 존재하는 동안
		while (request.getParameterNames().hasMoreElements()) {

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
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
		// 만든 뷰를 반환함

	}

}
