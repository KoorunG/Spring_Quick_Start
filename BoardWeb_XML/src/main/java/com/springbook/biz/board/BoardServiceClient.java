package com.springbook.biz.board;

import java.util.List;
//import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService boardService = container.getBean("boardService",BoardService.class);
		
		
		BoardVO vo = new BoardVO();
//		vo.setSeq(100);							// BoardDAOSpring.java에서 쿼리문을 수동입력 하도록 수정했기 때문에 시퀀스를 새로 입력해줌
		vo.setTitle("안녕하세요");
		vo.setWriter("쿠렁");
		vo.setContent("반갑습니다...");
		boardService.insertBoard(vo);			// 이제는 AOP로 트랜잭션 처리하기 때문에 주석처리함
		
//		Scanner sc = new Scanner(System.in);
//			System.out.println("=========== deleteBoard =============");
//			System.out.print("startPoint 를 입력하시오 : ");
//			int start = sc.nextInt();
//			System.out.print("endPoint 를 입력하시오: ");
//			int end = sc.nextInt();
//		for(int i = start ; i <= end ; i++) {
//			vo.setSeq(i);
//			boardService.deleteBoard(vo);
//		}
//		sc.close();
		
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}
}
