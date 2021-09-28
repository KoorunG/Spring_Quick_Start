package polymorphism;

//import org.springframework.stereotype.Component;
//@Component
public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("Samsung TV --- 객체 생성");
	}
//
//	public SamsungTV(Speaker speaker) {
//		System.out.println("Samsung TV(2) --- 객체 생성");
//		this.speaker = speaker;
//	}
//
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("Samsung TV(3) --- 객체 생성");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	public void powerOn() {
		System.out.println("Samsung TV --- 전원 켠다. (가격 : " + price +"원)");
	}

	public void powerOff() {
		System.out.println("Samsung TV --- 전원 끈다");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	
}
