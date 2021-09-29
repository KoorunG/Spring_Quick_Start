package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		

	
//		// 1. XML ���
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
////		TV tv = (TV)factory.getBean("tv");	// 1. ���̵�� �˻�
//		TV tv = factory.getBean(TV.class); 	// 2. Ÿ������ �˻�
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		factory.close();
		
		// 2. Annotation ���
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextAnnotation.xml");
		TV tv = factory.getBean("samsung",TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}
}
