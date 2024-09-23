package practice;
import java.util.Scanner;
 abstract class Dimension {
	double length;
	double breadth;
	double height;
	Dimension(double x, double y, double h){
		this.length= x;
		this.breadth= y;
		this.height= h;
	}
    abstract double area();
    abstract double volume();
}
class cube extends Dimension{
	
	cube(double x, double y, double h){
		super(x,y,h);
	}
	@Override
	double area() {
		return 6*length*length;
	}

	@Override
	double volume() {
		return length*length*length;
	}
}
class cuboid extends Dimension{
	
	cuboid(double x, double y, double h){
		super(x,y,h);
	}
	@Override
	double area() {
		return ((2*length*breadth)+height);
	}

	@Override
	double volume() {
		return length*breadth*height;
	}
}

 public class ABSTRACTION{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Dimension value;
		Dimension value2;
		System.out.println("length:");
		double x=sc.nextDouble();
		System.out.println("breadth:");
		double y=sc.nextDouble(); 
		System.out.println("height:");
		double h=sc.nextDouble();
		value= new cube(x,y,h);
		value2= new cuboid(x,y,h);
		System.out.println("Area of cube:"+value.area());
		System.out.println("volume of cube:"+value.volume());
		System.out.println("Area cuboid:"+value2.area());
		System.out.println("volume of cuboid:"+value2.volume());
		sc.close();
	}
}
