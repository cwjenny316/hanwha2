package lab1;

public class TVUser {

	public static void main(String[] args) {
		//TV tv = new SamsungTV();
		TV tv = TVFactory.makeTV("lg");
		tv.powerOn();
		tv.powerOff();
		

	}

}
