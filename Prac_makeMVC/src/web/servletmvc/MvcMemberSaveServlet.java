package web.servletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.member.Member;
import domain.member.MemberRepository;

@WebServlet("/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();		// 싱글톤 객체인 memberRepository 불러옴

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// new-form.jsp 로부터 전송된 request에서 getParameter 메소드를 이용하여 username과 age를 전송받음
		
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));	// request.getParameter()은 자료형이 String이므로
																														// Integer.parseInt()를 이용하여 int형으로 변환한 것
		
		// member 생성 후 저장
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		// Model에 데이터를 보관 (여기서 Model 역할을 request 객체가 하므로)
		// 뷰에서는 request.getAttribute() 또는 EL 문법을 이용하여 데이터를 꺼낼 수 있음
		request.setAttribute("member", member);
		
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);

	}

}