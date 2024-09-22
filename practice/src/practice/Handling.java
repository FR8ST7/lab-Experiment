package practice;

public class Handling {
public static void main(String args[]) {
	int d,a,c;
	a=10;
	d=0;
	try {
	c= a/d;
	System.out.println("result:"+c);
	}
	catch(ArithmeticException e) {
		System.out.println("divide by zero");
	}
}
}
