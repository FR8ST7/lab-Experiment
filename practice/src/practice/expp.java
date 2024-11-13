package practice;
import java.util.Scanner;
class Airport{
	public boolean available=true;
	public synchronized boolean request(String airplane) {
		if(available) {
		System.out.println(airplane + "clear to use..");
		available=true;
		return true;
		}
		else {
			System.out.println(airplane + "waiting to clear");
			return false;
		}
	}
	public synchronized  void release(String airplane) {
		System.out.println(airplane + "has evacuated");
		available=true;
		notifyAll();
	}
}
class Airplane extends Thread{
	Airport airport;
	String name;
	public Airplane(Airport airport,String name) {
		this.name=name;
		this.airport=airport;
	}
	public void run() {
		while(true) {
			synchronized(airport) {
				if(airport.request(name)) {
					System.out.println(name + "is taking off/landing");
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
					airport.release(name);
					break;
				}
				else {
					try {
						airport.wait();
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	}
}
public class expp {
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        Airport airport= new Airport();
	        System.out.println("enter the no. of planes:");
	        int n= sc.nextInt();
	        sc.nextLine();
	        Thread airplanes[]= new Thread[n];
	        for(int i=0;i<n;i++) {
	        	System.out.println("enter the name of planes"+(i+1)+":");
	        	String name= sc.nextLine();
	        	airplanes[i]=new Airplane(airport,name);
	        }
	        System.out.println("simulation..\n");
	        for(Thread airplane: airplanes) {
	        	airplane.start();
	        }
	}
}


