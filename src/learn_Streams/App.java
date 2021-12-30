package learn_Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {
		// Lambda expressions with Streams'
		
		
		//Integer Stream
		IntStream 
			.range(1, 10)   //source
			.forEach((x) -> System.out.print(x));   // terminal operator
		
		System.out.println();
		
		
		// Integer Stream with Skip
		IntStream 
		.range(1, 10)
		.skip(5)    //skip 1-5 elements of the stream - intermediate operator
		.forEach((x) -> System.out.print(x));
		
		System.out.println();
		

		// Integer Stream with Sum
		int val = IntStream      // source
				.range(1, 5)   
				.sum();  //terminal operation
		System.out.println(val);
		

		// Stream.of, sorted and findFirst
		Stream.of("Hello", "bottle", "Africa")    // source
			.sorted()		//intermediate operation
			.findFirst()    //terminal operation
			.ifPresent((x) -> System.out.println(x));    //ifPresent prevents NullPointerExecption
		
		
		// Stream from Array, sort, filter and print
		String[] items = {"car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy"};
		Stream.of(items)
			.filter((x) -> x.startsWith("t"))			//intermediate operation
			.sorted()									//intermediate operation
			.forEach(x -> System.out.print(x + ", "));  //terminal operation
		
		System.out.println();
		
		
		// Average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})   // source stream arrays
			.map((x) -> x * x)
			.average()   //terminal operation
			.ifPresent(n -> System.out.println(n));
		
		
		// Stream from a list, filter and print
		List<String> listOfItems = Arrays.asList("Computer", "Tootpaste", "Box", "Pencil", "Car");   //creating list
		listOfItems.stream()
			.map(x -> x.toLowerCase())
			.filter(x -> x.startsWith("c"))
			.sorted()
			.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		
		// Streaming with files
		Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
		lines.sorted()
			.filter(l -> l.length() > 6)
			.forEach(x -> System.out.print(x + ", "));
		lines.close();  //this prevents memory leaks
		System.out.println();
		
		
		List<String> words = Files.lines(Paths.get("files/wordFile.txt"))
				.filter(x -> x.contains("th"))
				.collect(Collectors.toList());
		words.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
				
		Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
		int rowCount = (int) rows.map(x -> x.split(","))
								.filter(x -> x.length > 3)
								.count();   //terminal operation
		System.out.println(rowCount);
		rows.close();
		
		
		Stream<String> rows2 = Files.lines(Paths.get("files/stockDataCsv.txt"));
		rows2.map(x -> x.split(","))
			.filter(x -> x.length > 3)
			.filter(x -> Integer.parseInt(x[1].trim()) > 110)
			.forEach(x -> System.out.println(x[0].trim() + " " + x[1].trim() + " " + x[2].trim() + " " + x[3].trim()));
		rows2.close();
		
		
		
		
		
	}

}
