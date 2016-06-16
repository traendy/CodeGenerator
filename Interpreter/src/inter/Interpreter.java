package inter;

import java.util.Scanner;

public class Interpreter {

	
	
	private static Scanner s;
	
	// print an integer and a newline in standard output
	static void   printInt(int x){
		 System.out.println(x);
	 }
	
	static void   printDouble(double x) {
	    	// print a double and a newline in standard output
		 System.out.println(x);
	    }
	static void   printString(String x) {
	    	// print a string and a newline in standard output
		 System.out.println(x);
	    }
	
	static int    readInt()  {
	    s = new Scanner(System.in);
	   
		return s.nextInt();
	    }
	static double readDouble() {
		 s = new Scanner(System.in);
		   
			return s.nextDouble();
	    }
	static  String readString() {
		 s = new Scanner(System.in);
		 return s.nextLine();
	    }

}
