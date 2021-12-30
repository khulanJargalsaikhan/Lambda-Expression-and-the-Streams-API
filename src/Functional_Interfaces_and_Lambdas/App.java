package Functional_Interfaces_and_Lambdas;

public class App {

	public static void main(String[] args) {
		
		Human human = new Human();
		walker(human);
		
		Robot robot = new Robot();
		walker(robot);
		
		
		// convert to Lambda Expression
		walker( () -> System.out.println("Custom object walking... "));
		
		
		
		
		

	}
	
	
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

}
