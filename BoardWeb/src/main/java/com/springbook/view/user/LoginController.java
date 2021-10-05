package com.springbook.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController { 

	// 클라이언트에서 /login.do 요청이 오면 login() 메소드가 실행됨
	// 실행되고 난 뒤 조건에 따라서 지정된 곳으로 포워딩됨
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(UserVO vo , UserDAO userDAO, HttpSession session) {
		
		System.out.println("로그인 인증 처리 ..");
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다!");
		}
		
		if(userDAO.getUser(vo) != null) {
			session.setAttribute("userName",userDAO.getUser(vo).getName());
			return "redirect:getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
}
