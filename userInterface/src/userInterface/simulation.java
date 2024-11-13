package userInterface;
import java.util.Scanner;

class Airport{
	public boolean available=true;
	public synchronized boolean request(String airplane) {
		if(available) {
			System.out.println(airplane + "clear to use runway");
			available=true;
			return true;
		}
		else {
			System.out.println(airplane + "waiting...");
			return false;
		}
	}
	public synchronized void release(String airplane) {
		System.out.println(airplane + "has evacuated...");
		available=true;
		notifyAll();
	}
}
class Airplane extends Thread{
	public Airport airport;
	public String name;
	
	public Airplane(Airport airport,String name) {
		this.airport=airport;
		this.name=name;
	}
	@Override
	public void run() {
		while(true) {
			synchronized(airport) {
				if(airport.request(name)) {
					System.out.println(name + "taking off");
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
public class simulation {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		Airport airport= new Airport();
		System.out.println("enter no of planes:");
		int n = sc.nextInt();
		sc.nextLine();
		
		Thread airplanes[]= new Thread[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter name of plane"+(i+1)+":");
			String name= sc.nextLine();
			airplanes[i]= new Airplane(airport,name);
		}
		System.out.println("simulstion...\n");
		for(Thread airplane:airplanes) {
			airplane.start();
		}
	
	}
}

