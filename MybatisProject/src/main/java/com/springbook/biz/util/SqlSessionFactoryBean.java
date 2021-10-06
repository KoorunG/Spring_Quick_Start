package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			if(sessionFactory == null) {
				// 마이바티스 설정 파일을 InputStream으로 만든 뒤
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				
				// SqlSessionFactoryBuilder().build(reader)을 이용하여 설정정보를 읽어들여 sessionFactory를 만든다
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// sessionFactory.openSession()으로 SqlSession을 만든다 (DAO에서는 이 메소드를 이용하여 mybatis 세션을 생성)
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
}
