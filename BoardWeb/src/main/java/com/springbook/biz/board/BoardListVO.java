package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 루트 엘리먼트용 객체 생성 : BoardListVO


@XmlRootElement(name = "boardList")		// 이 객체가 루트 엘리먼트에 해당하는 객체이고 이 이름을 boardList로 설정하겠다는 의미
@XmlAccessorType(XmlAccessType.FIELD)	// 엑세스 타입 설정
public class BoardListVO {
	
	@XmlElement(name = "board")
	private List<BoardVO> boardList;

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
	
}
