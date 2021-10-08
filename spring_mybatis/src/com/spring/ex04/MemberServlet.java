package com.spring.ex04;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저에서 요청 시 MemeberDAO 객체를 생성 후 selectAllMemberList()를 호출하는 서블릿

//브라우저에서 전송된 action 값이 insertMember면
//함께 전송된 회원 정보를 가져와 MemberVO 객체에 설정합니다.
//그런 다음 MemberDAO의 insertMember() 메서드를 호출하면서 인자로 전달합니다.

@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4780109909995950323L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private static void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();

		String action = request.getParameter("action");
		String nextPage = "";

		if (action == null || action.equals("listMembers")) {
			List<MemberVO> membersList = memberDAO.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
			
		} else if (action.equals("insertMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
//			Map<String, String> memberMap = new HashMap<>();
//			memberMap.put("id", id);
//			memberMap.put("pwd", pwd);
//			memberMap.put("name", name);
//			memberMap.put("email", email);
			memberDAO.insertMember(memberVO);
			nextPage = "/mem4.do?action=listMembers";
		} else if (action.equals("updateMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			memberDAO.updateMember(memberVO);
			nextPage = "/mem4.do?action=listMembers";
		} else if (action.equals("deleteMember")) {
			String id = request.getParameter("id");
			memberDAO.deleteMember(id);
			nextPage = "/mem4.do?action=listMembers";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}
}
