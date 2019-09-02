package lab2;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("SamsungTV생성자");
	}
	
	public void powerOn() {
		//class 이름을 동적으로 읽어온다
		System.out.println(this.getClass().getSimpleName()+"전원을 켭니다");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+"전원을 끕니다");
	}
	
	
	

}
