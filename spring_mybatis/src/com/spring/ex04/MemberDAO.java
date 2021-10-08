package com.spring.ex04;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	// SqlMapConfig.xml 파일을 이용하여 SqlMapper 객체를 생성
	// selectAllMemberList() 메소드를 호출하며, 인자로 mapper.member.selectAllMemberList를 전달
	
	private static SqlSessionFactory sqlMapper = null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			String resource = "mybatis/SqlMapConfig.xml";
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
				return sqlMapper;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	private static SqlSession getMybatis() {
		sqlMapper = getInstance();
		return sqlMapper.openSession();
	}
	
	// 1. 멤버 목록 조회
	public List<MemberVO> selectAllMemberList() {
		SqlSession mybatis = getMybatis();
		List<MemberVO> membersList = null;
		membersList = mybatis.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	// 2. 멤버 이름 조회
	public String selectName() {
		SqlSession mybatis = getMybatis();
		return mybatis.selectOne("mapper.member.selectName");
	}
	
	// 3. 멤버 비밀번호 조회
	public int selectPwd() {
		SqlSession mybatis = getMybatis();
		return mybatis.selectOne("mapper.member.selectPwd");
	}
	
	// 4. 아이디로 멤버 조회
	// => id는 "selectMemberById" SQL문의 #{id}에 해당한다
	public MemberVO selectMemberById(String id) {
		SqlSession mybatis = getMybatis();
		return mybatis.selectOne("mapper.member.selectMemberById", id);
	}
	
	// 5. 비밀번호로 멤버 조회(?) => 같은 비밀번호를 가진 회원은 여러명이 있을 수 있기 때문에 selectList를 사용했다
	// pwd => #{pwd}
	public List<MemberVO> selectMemberByPwd(int pwd) {
		SqlSession mybatis = getMybatis();
		return mybatis.selectList("mapper.member.selectMemberByPwd", pwd);
	}
	
	// 6. 멤버 삽입
	// 첫 번째 인자에는 실행하고자 하는 SQL 문의 id를 입력하고 
	// 두 번째 인자에는 SQL문으로 전달할 데이터를 지정
	// SQL문으로 전달할 데이터는 parameterType인 MemberVO와 일치해야 한다
	
	// commit();을 반드시 해야함
	public int insertMember(MemberVO vo) {
		SqlSession mybatis = getMybatis();
		int result = mybatis.insert("mapper.member.insertMember", vo);
		mybatis.commit();
		return result;
	}
	
	// 7. 멤버 갱신
	
	// commit();을 반드시 해야함
	public int updateMember(MemberVO vo) {
		SqlSession mybatis = getMybatis();
		int result = mybatis.insert("mapper.member.updateMember", vo);
		mybatis.commit();
		return result;
	}
	
	// 8. 멤버 삭제
	public int deleteMember(String id) {
		SqlSession mybatis = getMybatis();
		int result = mybatis.insert("mapper.member.deleteMember", id);
		mybatis.commit();
		return result;
	}
	
	// memberMap 매개변수는 insertMember2() 메소드로 전달된 HashMap을 다시 SQL문으로 전달함
	// 즉 여기서 SqlSession 클래스의 insert() 메소드 호출 시 두번째 인자로 HashMap을 전달함
//	public int insertMember2(Map<String,String> memberMap) {
//		SqlSession mybatis = getMybatis();
//		int result = mybatis.insert("mapper.member.insertMember", memberMap);
//		mybatis.commit();
//		return result;
//	}
}
