import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab1Scanner {

	public static void main(String[] args) {
		int value = 0;
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		int num4 = input.nextInt();
		int num5 = input.nextInt();
		value = (num1 + num2 + num3 + num4 + num5) / 5;
		System.out.println("The average of " + num1 + ", " + num2 + ", " +num3 + ", " + num4 + ", and " + num5 + " is " + value + ".");
		File file = new File("data1.txt");
		try {
			Scanner fileScnr = new Scanner(file);
			while (fileScnr.hasNextLine()) {
				System.out.println(fileScnr.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("The file size is: " + file.length() + " bytes.");
		System.out.println("The file path is: " + file.getAbsolutePath() + ".");
		
	}
}
