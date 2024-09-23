package practice;

public class Handling {
public static void main(String args[]) {
	int d,a,b;
	a=10;
	b=2;
	d=0;
	
	try {
    divide(a,d);//int c=a/d;
	//System.out.println("result:"+c);
	}
	catch(ArithmeticException e) {
		System.out.println(e.getMessage());
	}
	try {
		int f[]= new int[1];
	    f[42]=99;
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {
		int m= a/b;
		System.out.println("result:"+m);
	}
}
     static int divide(int a, int d)throws ArithmeticException {//throws declare exception 
    	 if(d==0) {
    		 throw new ArithmeticException("please do not divide by 0");//throw new exception
    	 }
    	 return a/d;
     }
}
