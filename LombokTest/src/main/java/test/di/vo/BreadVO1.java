package test.di.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreadVO1 {
	
	private String name;
	private int age;
	
	
	public void test(String name) {
		System.out.println(name);
	}
}
