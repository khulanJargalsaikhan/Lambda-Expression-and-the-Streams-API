package Functional_Interfaces_and_Lambdas;

public class App {

	public static void main(String[] args) {
		
		Human human = new Human();
		walker(human);
		
		Robot robot = new Robot();
		walker(robot);
		
		
		// This was the only way to segregate certain functionality from class definition Before java 8
		walker(new Walkable() {

			@Override
			public void walk() {
				System.out.println("Custom object walking... ");
				
			}
			
		});

	}
	
	
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

}
