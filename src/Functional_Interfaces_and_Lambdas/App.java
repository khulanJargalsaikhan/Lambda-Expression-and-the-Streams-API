package Functional_Interfaces_and_Lambdas;

public class App {

	public static void main(String[] args) {
		
		Human human = new Human();
		walker(human);
		
		Robot robot = new Robot();
		walker(robot);
		
		
		// Functional Programming
		// This Walkable is Functional Interface with just one Abstract method
		Walkable aBlockOfCode = () -> {
			System.out.println("Custom object walking... ");
			System.out.println("The object is tripped... ");
		};
		
		walker(aBlockOfCode);

	}
	
	
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

}
