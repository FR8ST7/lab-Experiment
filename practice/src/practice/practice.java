package practice;
import java.util.Scanner;
 class practice {
         double length;
         double height;
         double breadth;

       practice(double l,double h,double b){
    	   this.length=l;
    	   this.height=h;
    	   this.breadth=b;
    	   
       }
       double volume() {
    	   return length*height*breadth;
       }
       double square() {
    	   return length*length;
       }
}
 class exp extends practice{
	 
	 exp(double l,double h,double b){
		 super(l,h,b);
	 }
		 
		 double area() {
			 return length*breadth;
		 }
	 
	 String display(double a,double z,double y) {
		 return"volume:"+a+"\nsquare:"+z+"\narea:"+y;
	 }
 }
 class Main{
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		double l=0,h=0,b=0;
		double a,z,y;
		exp p1= null;
		exp p2= null;
		int choice;
		do {
			System.out.println("1.enter length,height,breadth"+"2.display result"+"3.exit");
			System.out.println( "enter the choice:");
			choice= sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("length:");
				l= sc.nextDouble();
				System.out.println("height:");
				h= sc.nextDouble();
				System.out.println("breadth:");
				b= sc.nextDouble();
				p1= new exp(l,h,b);
				p2= new exp(l,h,b);
				a= p1.volume();
				z= p1.square();
				y= p2.area();
				break;
			case 2:
				System.out.println(p1.display(p1.volume(),p1.square(),p1.area()));
				
				break;
			case 3:
				System.out.println("exiting....");
				sc.close();
				break;
				default:
					System.out.println("invalid input");
				
			}
		}while(true);
	}
}
