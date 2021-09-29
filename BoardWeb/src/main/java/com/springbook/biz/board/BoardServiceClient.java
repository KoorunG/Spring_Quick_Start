package com.springbook.biz.board;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너 구동
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너에서 BoardServiceImpl 객체를 LookUp
		
		BoardService boardService = container.getBean("boardService",BoardService.class);
		
		// 3. 글 등록 가능 테스트
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용............");
		boardService.insertBoard(vo);
		
		// 3.1 글 삭제 테스트
//		Scanner sc = new Scanner(System.in);
//			System.out.println("=========== deleteBoard =============");
//			System.out.print("startPoint를 입력하시오 : ");
//			int start = sc.nextInt();
//			System.out.print("endPoint를 입력하시오 : ");
//			int end = sc.nextInt();
//		for(int i = start ; i <= end ; i++) {
//			vo.setSeq(i);
//			boardService.deleteBoard(vo);
//		}
//		sc.close();
		
		// 4. 글 목록 검색 테스트
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}
}
