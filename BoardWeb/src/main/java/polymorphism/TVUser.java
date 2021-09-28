package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
 		// 1. �ֳ����̼� ��� 		
//		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//		TV tv = factory.getBean("samsungTV",TV.class);
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		factory.close();
	
		// 2. XML ���
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
//		TV tv = (TV)factory.getBean("tv");	// 1. ���̵�� �˻�
		TV tv = factory.getBean(TV.class); 	// 2. Ÿ������ �˻�
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}
}
