package Functional_Interfaces_and_Lambdas;

public class App {

	public static void main(String[] args) {
		
		Human human = new Human();
		walker(human);
		
		Robot robot = new Robot();
		walker(robot);
		
		
		// Functional Programming
		// This Walkable is Functional Interface with just one Abstract method
		// Lambda Expression - its type must be a functional interface.
		Walkable aBlockOfCode = () -> {
			System.out.println("Custom object walking... ");
			System.out.println("The object is tripped... ");
		};
		
		walker(aBlockOfCode);
		
		// How to convert methods to Lambda Expression
		Calculate sumVar = (a,b) -> a+b;
		System.out.println(sumVar.compute(4, 6));
		
		
		Walkable helloVar = () -> System.out.println("hello there");
		helloVar.walk();

		Calculate nonZeroDividerVar = (a,b) -> {
			if(a == 0) return 0;
			return a/b;
		};
		System.out.println(nonZeroDividerVar.compute(10,2));
		
		ReverseString reverseVar = (s) -> {
			String result = "";
			for(int i=s.length()-1; i>=0; i--) {
				result = result + s.charAt(i);
			}
			return result;
		};
		System.out.println(reverseVar.printReverse("Hello"));
		
		
		MyGenericInterface<Integer> computedNum = (n) -> {
			int result = 1;
			for (int i=1; i<= n; i++) {
				result = i*result;
			}
			return result;
		};
		System.out.println(computedNum.resultFactorial(5));
		
	}
	
	
	
	
	// methods
	public int sum(int arg1, int arg2) {
		return arg1+arg2;
	}
	
	public void sayHello() {

	}
	
	public int nonZeroDivide(int arg1, int arg2) {
		if(arg1 == 0) return 0;
		return arg1/arg2;
	}
	
	public String reverse(String str) {
		String result = "";
		for(int i=str.length()-1; i>=0; i--) {
			result = result + str.charAt(i);
		}
		return result;
	}
	
	public int factorial(int num) {
		int result = 1;
		for (int i=1; i<= num; i++) {
			result = i*result;
		}
		return result;
	}
	

	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

}







// creating functional interfaces
interface Calculate{
	public int compute(int a, int b); 
}


interface ReverseString{
	public String printReverse(String str);
}

// How to make generic functional interface
interface MyGenericInterface<T>{
	public T resultFactorial(T t);
}

