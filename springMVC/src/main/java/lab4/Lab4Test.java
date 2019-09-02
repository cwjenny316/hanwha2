package lab4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab3.Car;
import lab3.People;

public class Lab4Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("lab4.xml");
		
		lab4.Car c = context.getBean("car",lab4.Car.class);
		System.out.println(c);
		
		lab4.People p = context.getBean("people", lab4.People.class);
		System.out.println(p);
		
	}

}
