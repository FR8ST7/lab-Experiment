package practice;
import java.util.Scanner;
class Department{
	String dn;
	String hn;
	int nof;
	int nos;
	int nop;
	Department(String dn,String hn,int nof,int nos,int nop){
		this.dn=dn;
		this.hn=hn;
		this.nof=nof;
		this.nos=nos;
		this.nop=nop;
	}
	void display() {
		System.out.println("Department:"+dn);
		System.out.println("Department:"+hn);
		System.out.println("Department:"+nof);
		System.out.println("Department:"+nos);
		System.out.println("Department:"+nop);
	}
	 String getdn() {
			return dn;
		}
	 String gethn() {
			return hn;
		}
	 int getnof() {
			return nof;
		}
	 int getnos() {
			return nos;
		}
	 int getnop() {
			return nop;
		}
	
}
class cse extends Department{
	cse(String dn,String hn,int nof,int nos,int nop){
		super(dn,hn,nof,nos,nop);
	}
}
class aids extends Department{
	aids(String dn,String hn,int nof,int nos,int nop){
		super(dn,hn,nof,nos,nop);
	}
}class ce extends Department{
	ce(String dn,String hn,int nof,int nos,int nop){
		super(dn,hn,nof,nos,nop);
	}
}

 public class exp123{
public static void main(String args[]) {
	Scanner sc= new Scanner(System.in);
	Department d=null;

	int choice;
	do {
		System.out.println("enter your choice:");
		choice= sc.nextInt();
		switch(choice){
		case 1:
			d=inputDetails(sc,"cse");
			break;
		case 2:
			d=inputDetails(sc,"aids");
			break;
		case 3:
			d=inputDetails(sc,"ce");
			break;
		case 4:
			d.display();
			break;
		case 5:
			sc.close();
			System.exit(0);
			break;
		 default:
		    	System.out.println("invalid");
		    	break;
		}
		
		
	}while(true);
	
}
 

 public static Department inputDetails(Scanner sc, String deptName) {
     System.out.println("Enter details for " + deptName + " Department:");

     System.out.print("Enter Head of Department Name: ");
     String hn = sc.nextLine();

     System.out.print("Enter Number of Faculty: ");
     int nof = sc.nextInt();

     System.out.print("Enter Number of Students: ");
     int nos = sc.nextInt();

     System.out.print("Enter Number of Programs: ");
     int nop = sc.nextInt();
     sc.nextLine(); // Consume newline

     switch (deptName) {
         case "CSE":
             return new cse(deptName, hn, nof, nos, nop);
         case "AI&DS":
             return new aids(deptName, hn, nof, nos, nop);
         case "CE":
             return new ce(deptName, hn, nof, nos, nop);
         default:
             return null;
     }
 }
}
 
	
