package lab4;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

//<bean id="car" class="lab4.Car"> 로 등록한 것과 같은 효과.
@Component //나를 bean으로 만들어주세요!
public class Car {
	String model;
	int price;
	public Car() {
		
	}
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	
	
	public String getModel() {
		return model;
	}
	
	//@Required
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
	
	
	
}