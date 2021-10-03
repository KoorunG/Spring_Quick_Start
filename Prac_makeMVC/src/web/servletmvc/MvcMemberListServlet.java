package web.servletmvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.member.Member;
import domain.member.MemberRepository;

@WebServlet("/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> members = memberRepository.findAll();	// findAll() 메소드로 멤버 목록을 꺼내올 수 있음
		request.setAttribute("members", members);
		
		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
}