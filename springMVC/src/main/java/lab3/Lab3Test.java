package lab3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab3Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("lab3.xml");
		
		Car c = context.getBean("car", Car.class);
		System.out.println(c.model);
		System.out.println(c.price);
		System.out.println(c);
		People p = context.getBean("people", People.class);
		System.out.println(p);
		People p2 = context.getBean("people", People.class);
		System.out.println(p);
		
		//bean은 default가 singleton이기 때문에 같은 객체로나온다.
		//xml에서 빈 생성시 scope="prototype"으로 해놓으면 싱글톤 해제된다.
		System.out.println(p==p2);
		System.out.println(System.identityHashCode(p));
		System.out.println(System.identityHashCode(p2));
		
	}

}
