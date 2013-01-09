import java.util.Random;


public abstract class Employee extends Thread {

	private boolean idle;
	private boolean eatenLunch;
	
	private Random randomNum = new Random();
	private int arrivalTime;
	private int lunchTime;
	private long simulationTime;

	private void goToWork() {
		
		idle = false;
		
		arrivalTime = randomNum.nextInt(30); 	// generate a time between 0 and 30 minutes
		simulationTime = arrivalTime * 10;		// convert arrival time to simulation time
		
		try {
			sleep(simulationTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		returnToWork();
	}
	
	private void goHome() {
	}
	
	private void goToLunch() {
		
		idle = false;
		eatenLunch = true;
		
		lunchTime = randomNum.nextInt(60-arrivalTime);	// generate a time between 0 and 60 - time arrived to work
		simulationTime = lunchTime * 10;	// convert lunch time to simulation time
		
		try {
			sleep(simulationTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnToWork();
	}
	
	// set employee to an idle work state
	private void returnToWork() {
		idle = true;
	}
}


