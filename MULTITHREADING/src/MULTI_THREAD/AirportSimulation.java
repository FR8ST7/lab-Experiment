package MULTI_THREAD;

import java.util.Scanner;

class Airport {
    private boolean isRunwayAvailable = true;

    public synchronized boolean requestRunway(String airplane) {
        if (isRunwayAvailable) {
            System.out.println(airplane + " is cleared to use the runway.");
            isRunwayAvailable = false;
            return true;
        } else {
            System.out.println(airplane + " is waiting for the runway to be free.");
            return false;
        }
    }

    public synchronized void releaseRunway(String airplane) {
        System.out.println(airplane + " has vacated the runway.");
        isRunwayAvailable = true;
        notifyAll();
    }
}

class Airplane extends Thread {
    private Airport airport;
    private String airplaneName;

    public Airplane(Airport airport, String airplaneName) {
        this.airport = airport;
        this.airplaneName = airplaneName;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (airport) {
                if (airport.requestRunway(airplaneName)) {
                    System.out.println(airplaneName + " is taking off/landing...");
                    try {
                        Thread.sleep(2000); // Simulate time spent on the runway
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    airport.releaseRunway(airplaneName);
                    break;
                } else {
                    try {
                        airport.wait(); // Wait for the runway to be free
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class AirportSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airport airport = new Airport();

        System.out.print("Enter the number of airplanes: ");
        int numberOfAirplanes = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Thread[] airplanes = new Thread[numberOfAirplanes];

        for (int i = 0; i < numberOfAirplanes; i++) {
            System.out.print("Enter the name for Airplane " + (i + 1) + ": ");
            String airplaneName = scanner.nextLine();
            airplanes[i] = new Airplane(airport, airplaneName);
        }

        System.out.println("Starting simulation...\n");

        for (Thread airplane : airplanes) {
            airplane.start();
        }
        
        scanner.close();
    }
}
