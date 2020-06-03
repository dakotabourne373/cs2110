/**
 * CS2110 - Day 4-5 Examples
 * 
 * This file provides examples used in days 4 and 5
 * of CS2110.  It includes Control Structures and
 * Array examples.
 * 
 * @author Robbie Hott
 */
public class ControlArraysExamples {

	public static void main(String[] args) {
		// Grades to Letter Examples (if - then - else)
		int grade = 84;
		
		if (grade >= 90) {
			System.out.println("Letter Grade: A");
		} else if (grade >= 80) {
			System.out.println("Letter Grade: B");
		} else if (grade >= 70 && grade >= 60) {
			System.out.println("Letter Grade: C");
		} else {
			System.out.println("Fail");
		}
		// Letters to Grades Examples (switch)
		char letterGrade = 'B';
		
		switch(letterGrade) {
			case 'A':
				System.out.println("Score >= 90");
				break; 
			case 'B':
				System.out.println("Score >= 80");
				break;
			case 'C':
				System.out.println("Score >= 70");
				break;
			default:
				System.out.println("Fail");
		}
		
		// Arrays
		int[] intArray;
		String[] restaurants;
		
		// While Loop

		
		// For Loop
		
		
		// Foreach Loop
		
		
	}
	
	/**
	 * This method pretty prints an array by using a foreach
	 * loop iterate through the array elements and prints each
	 * element on its own line.
	 * 
	 * @param arr The array to print
	 */
	public static void prettyPrintArray(String[] arr) {
		
	}

}
