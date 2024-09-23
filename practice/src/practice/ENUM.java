package practice;

public class ENUM {
enum Week{
	Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;
	Week(){
		System.out.println("the days are:"+this);
	}
}
public static void main(String args[]) {
	Week week;
	week = Week.Tuesday;
	
	for(Week day : Week.values()) {
		System.out.println(day);
	}
	System.out.println(week.ordinal());
}
}
