package web.frontcontroller.v3;

import java.util.Map;

import web.frontcontroller.ModelView;

public interface ControllerV3 {
	ModelView process(Map<String, String> paramMap);	// 파라미터에 대한 정보를 갖고 있는 paramMap을 인자로 받고 ModelView를 반환한다
}
