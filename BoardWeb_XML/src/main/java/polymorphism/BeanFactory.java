package polymorphism;

public class BeanFactory {

	
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV(); 
		}
		return null;
	}
	
	// 제어권이 개발자에서 유저로 이동하였다(IOC)
}
