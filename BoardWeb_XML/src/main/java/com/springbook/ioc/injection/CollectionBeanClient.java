package com.springbook.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContextCollection.xml");
		CollectionBean bean = factory.getBean("collectionBean", CollectionBean.class);
		List<String> addressList = bean.getAddressList();
		
		for(String address : addressList) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
