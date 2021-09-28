package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
 		// 1. 애노테이션 기반 		
//		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//		TV tv = factory.getBean("samsungTV",TV.class);
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		factory.close();
	
		// 2. XML 기반
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
//		TV tv = (TV)factory.getBean("tv");	// 1. 아이디로 검색
		TV tv = factory.getBean(TV.class); 	// 2. 타입으로 검색
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}
}
