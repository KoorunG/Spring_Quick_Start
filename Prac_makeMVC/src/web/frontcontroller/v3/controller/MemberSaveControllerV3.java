package web.frontcontroller.v3.controller;

import java.util.Map;

import domain.member.Member;
import domain.member.MemberRepository;
import web.frontcontroller.ModelView;
import web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		
		// 인자로 받은 paramMap에서 username과 age에 대한 정보를 꺼낸 뒤
		String username = paramMap.get("username");
		int age = Integer.parseInt(paramMap.get("age"));
		
		// 멤버 객체를 만들어 값을 세팅하고
		Member member = new Member(username,age);
		
		// 저장한다
		memberRepository.save(member);
		
		// ModelView 객체를 생성한 뒤
		ModelView mv = new ModelView("save-result");
		
		// ModelView에서 model을 꺼낸 뒤 member에 관한 정보를 입력한다 (Model의 자료형이 Map<String, Object> 이므로)
		mv.getModel().put("member", member);
		
		// 그 뒤 ModelView 반환
		return mv;
	}
	
}
