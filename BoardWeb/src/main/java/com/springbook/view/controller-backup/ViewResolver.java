package com.springbook.view.controller;


//HandlerMapping은 모든 Controller 객체들을 저장하고 있다가,
//클라이언트의 요청이 들어오면 요청을 처리할 특정 Controller를 검색하는 기능을 제공함
//HandlerMapping 객체는 DispatcherServlet이 사용하는 객체이다.
//따라서, DispatcherServlet이 생성되고 init() 메서드가 호출될 때 단 한 번 생성된다.

public class ViewResolver {
	
	// 접두사
	public String prefix;
	
	// 접미사
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// prefix와 suffix를 이용하여 view의 전체 경로를 얻는 메소드
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
