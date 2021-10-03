package domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	// ========= 싱글톤 패턴 시작
	
	private static final MemberRepository instance = new MemberRepository();	// 1. private인 유일한 객체인 instance 생성
		
	public static MemberRepository getInstance() {								// 2. getInstance() 메소드로 instance 객체에 접근
		return instance;
	}
	
	private MemberRepository() {}												// 3. 기본 생성자는 private로 막아둬서 싱글톤 구현 
	
	// ========== 싱글톤 패턴 끝 
	
	
	
	
	
	// 1. Member를 저장하는 로직 
	public Member save(Member member) {
		member.setId(++sequence);				// 저장할 때 마다 아이디는 sequence에서 1씩 늘어나게 함 ( mySql의 auto_increment와 같은 것 )
		store.put(member.getId(), member);		// HashMap인 store에 아이디를 키 값으로 member를 저장함
		return member;							// member를 리턴
	}
	
	// 2. Member를 id로 찾는 로직
	public Member findById(Long id) {
		return store.get(id);					// .get(key)이고 id가 키값이므로 이렇게 꺼내오면 됨
	}
	
	// 3. Member 목록을 조회하는 로직
	public List<Member> findAll() {
		return new ArrayList<>(store.values());	// store.values() => store에 있는 모든 Member를 배열로 반환하므로
												
	}
}