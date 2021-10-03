package domain.member;

public class Member {
	
	private Long id;
	private String username;
	private int age;
	
	public Member() {}

	public Member(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
