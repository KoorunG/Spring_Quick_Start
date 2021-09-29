package com.springbook.biz.board;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		// 1. ������ �����̳� ����
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ �����̳ʿ��� BoardServiceImpl ��ü�� LookUp
		
		BoardService boardService = container.getBean("boardService",BoardService.class);
		
		// 3. �� ��� ���� �׽�Ʈ
		
		BoardVO vo = new BoardVO();
		vo.setTitle("�ӽ� ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽ� ����............");
		boardService.insertBoard(vo);
		
		// 3.1 �� ���� �׽�Ʈ
//		Scanner sc = new Scanner(System.in);
//			System.out.println("=========== deleteBoard =============");
//			System.out.print("startPoint�� �Է��Ͻÿ� : ");
//			int start = sc.nextInt();
//			System.out.print("endPoint�� �Է��Ͻÿ� : ");
//			int end = sc.nextInt();
//		for(int i = start ; i <= end ; i++) {
//			vo.setSeq(i);
//			boardService.deleteBoard(vo);
//		}
//		sc.close();
		
		// 4. �� ��� �˻� �׽�Ʈ
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}
}
