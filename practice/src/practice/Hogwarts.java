package practice;
import java.util.Scanner;
 class Hogwarts {
	 String spell1= null;
	 String spell2= null;
	 String spell3= null;
	 
	 Hogwarts(String s1,String s2,String s3){
		 this.spell1= s1;
		 this.spell2= s2;
		 this.spell3= s3;
	 }
	 String getspell() {
		 return "Spells: " + spell1 + ", " + spell2 + ", " + spell3;
		}
}
class Gryffindor extends Hogwarts{
	
	 Gryffindor(String s1,String s2,String s3){
		super(s1,s2,s3);
	}
	 @Override
	String getspell() {
		return "Harry Potter casted:"+spell1;
	}
}
class Slytherien extends Hogwarts{
	
	Slytherien(String s1,String s2,String s3){
		super(s1,s2,s3);
	}
	@Override
	String getspell() {
		return "Draco Malfoy casted:"+spell2;
	}
}
class Ravenclaw extends Hogwarts{
	Ravenclaw(String s1,String s2,String s3){
		super(s1,s2,s3);
	}
	@Override
	String getspell() {
		return "Luna casted:"+spell3;
	}
}

class Power{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Hogwarts H= null;
		String s1="",s2="",s3="";
		int choice;
		do {
			System.out.println("1.enter spell1 2.enter spell2 3.enter spell3 4.display 5.exit");
			System.out.println("enter choice:");
		    choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter spell1:");
				s1= sc.next();
			    break;
			case 2:
				System.out.println("enter spell2:");
				s2= sc.next();
				break;
			case 3:
				System.out.println("enter spell3:");
				s3= sc.next();
				break;
			case 4:
			Gryffindor g = new Gryffindor(s1, s2, s3);
            Slytherien s = new Slytherien(s1, s2, s3);
            Ravenclaw r = new Ravenclaw(s1, s2, s3);
            System.out.println(g.getspell());
            System.out.println(s.getspell());
            System.out.println(r.getspell());
            break;
			case 5:
				System.out.println();
				sc.close();
				System.exit(0);
				break;	
		    default:
		    	System.out.println("invalid");
		    	break;
			}
		}while(true);
	}
}