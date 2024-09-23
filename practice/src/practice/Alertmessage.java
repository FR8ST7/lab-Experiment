package practice;

public enum Alertmessage {
   low("no immediate action needed"),
   Medium("look after the problem"),
   High("action required"),
   Critical("immediate action required");
	
	String message;
	
	Alertmessage(String message){
		this.message= message;
	}
	public String getAlertmessage() {
		return message;
	}
	public class Main {
		public static void main(String args[]) {
			Alertmessage m= Alertmessage.low;
			System.out.println("Alert:"+m+"message:"+m.getAlertmessage());
			for(Alertmessage x: Alertmessage.values()) {
				System.out.println(x.getAlertmessage());
			}
		}
	}
}
