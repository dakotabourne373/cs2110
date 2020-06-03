/**
 * Homework 6
 * 
 * Implement the following methods on recursion
 * as defined in the homework 6 document.
 * 
 * @author db2nb
 *
 */
public class Recursion {
	
	public static boolean palindrome(String s) {
		// Implement this method
		return s.equals(reverseString(s));
	}
	
	public static String reverseString(String s) {
		// Implement this method
		if(s.length() <= 1) {
			return s;
		}
		return reverseString(s.substring(1)) + s.charAt(0);
	}
	
	public static int handshakes(int n) {
		// Implement this method
		if (n <= 1) {
			return 0;
		}
		return n-1 + handshakes(n-1);
	}
	
    public static long ackermann(long m, long n) {
		// Implement this method
    	if(m == 0) {
    		return n + 1;
    	} else if (m > 0 && n == 0) {
    		return ackermann(m-1, 1);
    	} else {
    		return ackermann(m-1, ackermann(m,n-1));
    	}
		
	}

	public static void main(String[] args) {
		// write your tests here
		System.out.println(palindrome("abba"));
		System.out.println(palindrome("racecar"));
		System.out.println(palindrome("smith"));
		
		System.out.println(reverseString("racecar"));
		System.out.println(reverseString("CS2110"));
		System.out.println(reverseString("I love CS!"));
		
		System.out.println(handshakes(0));
		System.out.println(handshakes(3));
		System.out.println(handshakes(6));
		
		System.out.println(ackermann(0,0));
		System.out.println(ackermann(2,0));
		System.out.println(ackermann(3,4));
	}
}