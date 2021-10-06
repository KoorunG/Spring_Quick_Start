package com.springbook.biz.board;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

// VO(Value Object)

@XmlAccessorType(XmlAccessType.FIELD)	// BoardVO 객체를 XML로 변환할 수 있다는 의미
										// => 이 객체가 가진 필드는 자동으로 자식 엘리먼트로 표현됨
public class BoardVO {

	@XmlAttribute						// @XmlAttribute => seq를 속성으로 표현하라는 의미
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	@XmlTransient						// @XmlTransient => XML 변환에서 제외하라는 의미 ( @JsonIgnore와 비슷함 )
	private String searchCondition;
	
	@XmlTransient
	private String searchKeyword;
	
	@XmlTransient
	private MultipartFile uploadFile;

	public int getSeq() {
		return seq;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}

	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	// 스프링 컨테이너가 MultipartFile 객체를 생성하여 전달함
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
	
	
}
