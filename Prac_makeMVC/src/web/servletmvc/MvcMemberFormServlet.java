package web.servletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// viewPath : 포워딩할 jsp 파일의 주소
		String viewPath = "/WEB-INF/views/new-form.jsp";
		
		// request.getRequestDispatcher(viewPath)로 서블릿의 RequestDispatcher 객체를 만듦
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		
		// forward(request, response)로  포워딩
		dispatcher.forward(request, response);

	}
	
}