package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")	
// Model에 "board"라는 이름으로 저장되는 데이터가 있다면 그 데이터를 세션에도 저장하라는 애노테이션
public class BoardController {

	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insert(BoardVO vo) throws IllegalStateException, IOException {

		System.out.println("글 등록 처리");
		
		// 파일 업로드
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		System.out.println("글 목록 검색 처리");
		
		// Null Check
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());

		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "/WEB-INF/board/getBoardList.jsp";
		
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		System.out.println("글 상세 조회 처리");

		boardService.updateCnt(vo);
		
		// 데이터를 DAO에서 받아서 옮겨야 하기 때문에 @ModelAttribute로 쓸 수 없으며 Model에서 어트리뷰트를 설정해야 한다!
		model.addAttribute("board", boardService.getBoard(vo));	
		return "/WEB-INF/board/getBoard.jsp";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String update(@ModelAttribute("board") BoardVO vo) {

		System.out.println("글 수정 처리");
		
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";

	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String delete(BoardVO vo) {

		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";

	}
	
	// JSON 데이터 변환
	// @ResponseBody 로 인해 뷰 경로가 아닌 객체를 직접 리턴할 수 있다
	// (즉, 리턴타입을 랜더링 처리하지 않음을 명시하는 애노테이션)

	@RequestMapping("/dataTransform.do")	
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	@RequestMapping("/dataTransformXml.do")	
	@ResponseBody
	public BoardListVO dataTransformXml(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}
}
