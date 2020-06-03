import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInData {
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine()); // Read in Val for # values
			for(int i = 0; i < numOfValues; i++) { // for-loop to get that many values
				sum += scan.nextDouble(); // add the values together (doubles)
			}
			scan.close();
			return sum; // return the sum of all the values in the file 
		}catch (NumberFormatException e) {
			//add catch statements here		
			System.out.println("A number was formatted incorrectly");
		}catch(InputMismatchException e) {
			System.out.println("The input doesnt match any correct");
		}catch(FileNotFoundException e) {
			System.out.println("The file name you inputted does not match any files");
		}catch(RuntimeException e) {
			System.out.println("An error has occured during the runtime");
		}finally {
			System.out.println("An unknown exception has occured");
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt")); // notice spelling of the file name! 
		System.out.println(readData("Test4.txt"));
	}

}