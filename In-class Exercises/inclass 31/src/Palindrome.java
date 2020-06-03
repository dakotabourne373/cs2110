
public class Palindrome {

	public static boolean testForPalindrome(String s) {
		System.out.println(s);
		return s.equals(reverseString(s));
		
	}
	public static String reverseString(String yup) {
		if(yup.length() <= 1) {
			return yup;
		}
		return reverseString(yup.substring(1)) + yup.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(testForPalindrome("racecar"));
	}
}
