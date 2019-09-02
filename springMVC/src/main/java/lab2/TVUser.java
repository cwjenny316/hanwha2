package lab2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {

	public static void main(String[] args) {
		//lab2.xml의 bean을 가져온다.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab2.xml");
		
		TV tv = context.getBean("stv", TV.class);
		//TV tv = (TV)context.getBean("ltv");
		tv.powerOn();
		tv.powerOff();
		

	}

}
