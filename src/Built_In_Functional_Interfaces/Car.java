package Built_In_Functional_Interfaces;

public class Car {
	
	String model, mark, color;
	int price;
	
	public Car(String model, String mark, String color, int price) {
		super();
		this.model = model;
		this.mark = mark;
		this.color = color;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", mark=" + mark + ", color=" + color + ", price=" + price + "]";
	}
	
	public void printCar() {
		System.out.println(this);
	}
	

}
