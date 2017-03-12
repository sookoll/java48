package ee.itcollege.practicum1;

import java.util.Scanner;

public class SumOfDigits {

	
	public static void main(String[] args) {
		
		System.out.println("Insert a number");
		
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		scanner.close();
		
		int sum = 0;
		
		for (int i = 0; i < number.length(); i++) {
//			char c = number.charAt(i);
//			sum += Character.digit(c, 10);
			Character c = number.charAt(i);
			try {
				int digit = Integer.parseInt(c.toString());
				sum += digit;
			}
			catch (NumberFormatException e) {}
		}
		
		System.out.println(sum);
		
	}
}
