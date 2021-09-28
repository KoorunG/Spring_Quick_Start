package polymorphism;

//import org.springframework.stereotype.Component;
//@Component
public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("Samsung TV --- ��ü ����");
	}
//
//	public SamsungTV(Speaker speaker) {
//		System.out.println("Samsung TV(2) --- ��ü ����");
//		this.speaker = speaker;
//	}
//
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("Samsung TV(3) --- ��ü ����");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	public void powerOn() {
		System.out.println("Samsung TV --- ���� �Ҵ�. (���� : " + price +"��)");
	}

	public void powerOff() {
		System.out.println("Samsung TV --- ���� ����");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}
	
	
}
