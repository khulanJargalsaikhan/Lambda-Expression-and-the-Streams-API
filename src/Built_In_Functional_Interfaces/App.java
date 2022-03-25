package Built_In_Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {
		
		List<Car> cars = Arrays.asList(
				new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700),
				new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200),
				new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300),
				new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500)
				);

		// bc they are using same resource(cars list)
		// once we have lambda down below, we don't need these two methods
		printCarsPriceRange(cars, 18000, 22000);
		printCarByColor(cars, "Red");


		//we can do 2 methods in one place using lambda
		System.out.println("Printing cars between price 18000 and 22000");
		//anonymous class definition
		printCars(cars, new CarCondition() {

			@Override
			public boolean test(Car c) {
				//here we can define own condition
				return c.getPrice() >= 18000 && c.getPrice() <= 22000;
			}
		});
	
		//lambda expression for printing CarByColor
		//this is also polymorphism
		System.out.println("Printing cars that are blue");
		printCars(cars, new CarCondition() {

			@Override
			public boolean test(Car c) {
				return c.getColor().equals("Blue");
			}

		});

		// this used CarCondition functional interface that we created down below
		System.out.println("Printing cars between price 18000 and 22000");
		printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);

		System.out.println("Print blue cars");
		printCars(cars, (c) -> c.getColor().equals("Blue"));
		
		
		
		// this used built-in functional interface
		Function<Car, String> priceAndColor = c -> " price = " + c.getPrice() + " color = "+ c.getColor();			
		String stringCar = priceAndColor.apply(cars.get(0));
		System.out.println(stringCar);
		
		

	}


	
	
	//creating just one method that able to use lambda and pass their own condition instead of method 1 and 2
	//CarCondition is up to the user what condition would be
	public static void printCars(List<Car> cars, CarCondition condition) {
		for(Car c: cars) {
			//print only if the value of condition is true
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}


	//method 1
	public static void printCarsPriceRange(List<Car> cars, int low, int high) {
		for(Car c: cars) {
			if(low <= c.getPrice() && c.getPrice() <= high) {
				c.printCar();
			}
		}
	}

	//method 2
	public static void printCarByColor(List<Car> cars, String color) {
		for(Car c: cars) {
			if(c.getColor().equals(color)) {
				c.printCar();
			}
		}
	}

	




	// Using built-in functional interface
	// check out java.util.function library in oracle for built-in functional interfaces
	public static void printCars(List<Car> cars, Predicate<Car> predicate) {
		for(Car c: cars) {
			if(predicate.test(c)) {
				c.printCar();
			}
		}
	}

}

//Creating own functional interface
@FunctionalInterface
interface CarCondition {
	public boolean test(Car c);
}
