package web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import domain.member.Member;
import domain.member.MemberRepository;
import web.frontcontroller.ModelView;
import web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		
		// findAll() 메소드로 회원 목록을 꺼낸다
		List<Member> members = memberRepository.findAll();
		
		// ModelView 객체를 만든다
		ModelView mv = new ModelView("members");
		
		// 모델에 member에 관한 데이터를 저장하고 
		mv.getModel().put("members", members);
		
		// ModelView를 반환한다
		return mv;
	}

	
}
