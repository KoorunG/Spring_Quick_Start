package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그인 처리");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 1. 로그인에 성공했을 때
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			HttpSession session = request.getSession();	
			session.setAttribute("id", id);
			
			mav.setViewName("redirect:getBoardList.do");
		// 2. 로그인에 실패했을 때
		// "login"을 리턴하는 이유 => 나중에 뷰 리졸버가 viewPath를 만들어 처리해주므로
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
}
