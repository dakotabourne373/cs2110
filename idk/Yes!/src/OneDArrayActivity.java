import java.util.Scanner;

public class OneDArrayActivity {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many values do you want in the array?");
		int x = keyboard.nextInt();
		int[] values = new int[x];
		for(int i = 0; i < x; i++){
			System.out.println("Enter the " + i + " value in the array");
			values[i] = keyboard.nextInt();
		}
		
		
		
		for(int j = 0; j < values.length; j++){
			System.out.print(values[j] + " ");
			if (j != 0 && values[j] > values[j-1]) {
				System.out.println("Yes the value " + values[j] + "is greater than the previous value.");
			} else {
				System.out.println("No the value " + values[j] + " is not greater than the previous value.");
			}
		}
		
		//Input your code here.
		
		keyboard.close();
		
	}

}
