package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.user.DeleteBoardController;
import com.springbook.view.user.GetBoardController;
import com.springbook.view.user.GetBoardListController;
import com.springbook.view.user.InsertBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;
import com.springbook.view.user.UpdateBoardController;

public class HandlerMapping {
	
	// 게시판 프로그램에 필요한 모든 Controller 객체를 등록하고 관리함
	private Map<String, Controller> mappings;
	
	// 생성자에서 mappings에 컨트롤러에 대한 정보를 넣음
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	// 인자로 받은 path에 해당하는 Controller 객체를 검색하여 리턴함
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
