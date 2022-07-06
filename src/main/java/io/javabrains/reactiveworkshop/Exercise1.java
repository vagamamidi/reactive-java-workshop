package io.javabrains.reactiveworkshop;

public class Exercise1 {

	public static void main(String[] args) {

		// Use StreamSources.intNumbersStream() and StreamSources.userStream()

		System.out.println("// Print all numbers in the intNumbersStream stream"); 
		StreamSources.intNumbersStream() 
			.forEach(System.out::println);
		 

		System.out.println("\n// Print numbers from intNumbersStream that are less than 5");
		StreamSources.intNumbersStream()
			.filter(n -> n < 5)
			.forEach(System.out::println);

		System.out.println("\n// Print the second and third numbers in intNumbersStream that's greater than 5");
		StreamSources.intNumbersStream()
			.filter(n -> n > 5)
			.limit(3)
			.skip(1)
			.forEach(System.out::println);

		System.out.println("\n// Print the first number in intNumbersStream that's greater than 5.");
		System.out.println("// If nothing is found, print -1");
		System.out.println(
			StreamSources.intNumbersStream()
				.filter(n -> n > 5)
				.findFirst()
				.orElse(-1));

		System.out.println("\n// Print first names of all users in userStream");
		StreamSources.userStream()
			.map(User::getFirstName)
			.forEach(System.out::println);

		System.out.println("\n// Print first names in userStream for users that have IDs from number stream");
		StreamSources.userStream()
			.filter(u -> StreamSources.intNumbersStream().anyMatch(n -> n == u.getId()))
			.map(User::getFirstName)
			.forEach(System.out::println);
	}

}
