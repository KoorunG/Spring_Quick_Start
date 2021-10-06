package article.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

// 웹 요청을 처리할 WriteArticleHandler를 구현하려고 한다.
// 게시글 작성 폼을 보여주고 폼 전송을 처리하므로,
// 앞서 구현했던 핸들러 클래스들 처럼,
// GET 방식 요청과 POST 방식 요청을 별도의 메서드에서 처리한다.
public class SearchHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/addressAPIPopup.jsp";
//	private WriteArticleService writeService = new WriteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return processForm(req,res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

//	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
//
//		Map<String, Boolean> errors = new HashMap<String, Boolean>();
//
//		// user와 HttpServletRequest를 이용해서 WriteRequest 객체를 생성한다.
//		WriteRequest writeReq = createWriteRequest(req);
//
//		// writeReq 객체가 유효한지 validate() 메서드로 검사한다.
//		writeReq.validate(errors);
//
//		// 에러가 존재하면 FORM_VIEW 폼을 다시 보여준다.
//		if (!errors.isEmpty()) {
//			return FORM_VIEW;
//		}
//		
//		writeService.write(writeReq);
//
//		// WriteArticleService를 이용해서 게시글을 등록하고,
//		// 등록된 게시글의 /WEB-INF/view/newArticleSuccess.jsp
//		// 처리 값을 리턴 받는다.
//
////		return "/WEB-INF/view/SuccessForm.jsp";
//		return FORM_VIEW;
//	}

//	private WriteRequest createWriteRequest(HttpServletRequest req) {
//		return new WriteRequest(req.getParameter("basicAddress"), req.getParameter("detailAddress"));
//	}
}
