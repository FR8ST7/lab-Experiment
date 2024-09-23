package practice;

enum alert{
	low,Medium,High,Critical;
	//alert(){
		//System.out.println("alert message:"+this);
	//}
}

public class Message{
 public static void main(String args[]) {
	 alert get= alert.low;
	 for(alert a:alert.values()) {
	 System.out.println(a);
	 }
 }
}

