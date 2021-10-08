package test.di.service;

import org.springframework.stereotype.Service;

import test.di.vo.BreadVo3;

@Service
public class HomeService {
	
	public void backHome() {
		System.out.println("반가워요!");
	}
	
	public static void main(String[] args) {
		BreadVo3 vo3 = BreadVo3.builder().age(30).name("쿠렁").build();
		System.out.println(vo3.getName());
	}
}
