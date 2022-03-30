package Built_In_Functional_Interfaces;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Introducing_Functional_Interfaces {

	public static void main(String[] args) {
		//Predicate functional interface
		//boolean test(T t);
		
		
		//Consumer functional interface - used for printing msg
		//void accept(T t)
		Consumer<String> consumer = x -> System.out.println(x);
		consumer.accept("Hello World!");
		
		
		//Supplier - good use case is generating values
		//T get();
		Supplier<Integer> random = () -> new Random().nextInt(15);
		System.out.println(random.get());
		
		//Comparator 
		//int compare(T o1, T o2);
		//A negative number means the first value is smaller, 
		//zero means they they are equal, and
		//positive number means the first value is bigger.
		Comparator<Integer> ints = (i1,i2) -> i1 - i2;
		System.out.println(ints.compare(5,3));
		
		Comparator<String> strings = (s1, s2) -> s1.compareTo(s2);
		System.out.println(strings.compare("hello", "hello"));
		
		
		

	}

}
