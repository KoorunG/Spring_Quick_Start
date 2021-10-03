package web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.member.Member;
import domain.member.MemberRepository;
import web.frontcontroller.MyView;
import web.frontcontroller.v2.ControllerV2;

public class MemberListControllerV2 implements ControllerV2 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Member> members = memberRepository.findAll(); 
		request.setAttribute("members", members);

		return new MyView("/WEB-INF/views/members.jsp");
	}

	
}
