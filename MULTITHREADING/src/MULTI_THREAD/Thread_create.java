package MULTI_THREAD;

class Even extends Thread{
	public void run() {
	for(int i=0;i<=10;i++) {
		if(i%2==0) {
			System.out.println(i+"is an even (Thread:"+Thread.currentThread().getName()+")");
			
}
}
}
public class Thread_create {
	public static void main(String args[]) {
	Even t1= new Even();
	t1.setName("Even-Thread");
	t1.start();
		}
	}
}
	

