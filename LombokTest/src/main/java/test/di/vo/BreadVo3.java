package test.di.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreadVo3 {
	
	private String name;
	private int age;
	
	@Builder
	public BreadVo3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
}
