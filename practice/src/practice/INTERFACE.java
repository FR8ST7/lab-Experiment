package practice;
 interface Engine{
	static final int Price = 60000;
	void start();
	void stop();
	void acc();
	
}
interface Brake{
	void brake();
	
}
interface Media{
	
	void status();
	
}
class Car implements Engine,Brake,Media{
	@Override
	public void start() {
		System.out.println("engine started");
	}
	@Override
	public void stop() {
		System.out.println("engine has stopped");
	}
	@Override 
	public void brake() { 
		System.out.println("user used braked");
	}
	@Override
	public void acc() {
		System.out.println("engine accelerated");
	}
	@Override
	public void status() {
		System.out.println("engine is in better condition");
	}
	
}
public class INTERFACE {
    public static void main(String args[]) {
    	Car value= new Car();
    	value.start();
    	value.stop();
    	value.status();
    	value.acc();
    	value.brake();
    	
    }
}
