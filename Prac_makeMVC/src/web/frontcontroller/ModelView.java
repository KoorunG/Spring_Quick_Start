package web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {					// 모델과 뷰의 이름을 같이 넘기는 객체 ModelView

	private String viewName;
	private Map<String, Object> model = new HashMap<>();
	
	public ModelView(String viewName) {		// 뷰의 '이름'을 인자로 받음 => viewResolver에서 이걸 이용하여 전체 경로를 만들어줌
		this.viewName = viewName;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
}
