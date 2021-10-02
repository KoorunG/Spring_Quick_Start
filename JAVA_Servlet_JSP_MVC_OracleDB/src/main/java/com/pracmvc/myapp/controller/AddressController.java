package com.pracmvc.myapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pracmvc.myapp.address.AddressDAO;
import com.pracmvc.myapp.address.AddressVO;

// 			/update.do 로 매핑함
@WebServlet("/update.do")

// 서블릿 생성
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			// 인코딩 타입 설정
			request.setCharacterEncoding("utf-8");
			
			// 기본주소와 상세주소를 파라미터로 받은 뒤 변수에 담음
			String mainAddress = request.getParameter("mainAddress");
			String subAddress = request.getParameter("subAddress");
			
			// vo 객체 생성 후 위에서 받은 변수로 값을 set함
			AddressVO vo = new AddressVO();
			vo.setMainAddress(mainAddress);
			vo.setSubAddress(subAddress);
		
			// error에 관한 해쉬맵 생성 & Attribute 설정
			Map<String, Boolean> errors = new HashMap<>();
			request.setAttribute("errors", errors);
			
			// 검증 메소드 호출
			vo.validateMain(errors);
			vo.validateSub(errors);
			
			// DAO 객체 생성 후 insert 메소드 실행
			AddressDAO addressDAO = new AddressDAO();
			addressDAO.insertAddress(vo);
			
			// 만약 errors에 값이 존재한다면?
			if(!errors.isEmpty()) {
				
				// 포워딩을 통해 초기화면으로 되돌림
				// 교재 248페이지에 포워드와 리다이렉트의 차이점이 있습니다
				
				// 포워드는 RequestDispatcher을 이용하여 응답으로 사용할 jsp 방식으로 넘기는 방식으로 
				// 실행속도가 빠르나 브라우저 입장에서는 URL이 바뀌지 않는 단점이 있습니다
				
				// 리다이렉트는 두번의 요청과 응답으로 처리되서 실행속도가 느리지만 클라이언트가 URL을 확인할 수 있는 장점이 있습니다
				
				// 1. 에러가 존재하여 초기화면을 돌리는 작업은 같은 페이지 내에서 일어나므로 포워드로 처리하고
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			// 2. 에러가 존재하지 않아 성공화면을 보여주는 작업은 URL이 바뀔 필요가 있으므로 리다이렉트로 처리했습니다
			response.sendRedirect("success.jsp");
			
	}
}
