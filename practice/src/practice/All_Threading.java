package practice;

class aloo extends Thread {
	 public void run() {
		 try {
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				System.out.println(i+"even no."+"thread:"+Thread.currentThread().getName());
				Thread.sleep(2000);
			}
		}
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
       
	}
}
class gobi implements Runnable {
	 public void run() {
		 try {
		for(int i=0;i<10;i++) {
			if(i%2!=0) {
				System.out.println(i+"odd no."+"thread:"+Thread.currentThread().getName());
				Thread.sleep(2000);
			}
			}
		}
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
       
	}
}

public class All_Threading{
public static void main(String args[]) {
	aloo t1= new aloo(); 
	t1.setName("even thread");
	Thread t2= new Thread(new gobi(),"odd thread");
	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	}
	catch(InterruptedException e) {
		 System.out.println(e.getMessage());
	}
	 System.out.println("operation completed");
}
}
	

