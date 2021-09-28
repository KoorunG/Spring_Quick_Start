package polymorphism;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

	public SamsungTV samsungTV() {
		return new SamsungTV();
	}
		
	public LgTV lgTV() {
		return new LgTV();
	}
}
