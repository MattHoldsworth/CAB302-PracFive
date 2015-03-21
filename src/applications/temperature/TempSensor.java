package applications.temperature;

import java.util.Random;
import java.util.Observable;


/**
 * A simple simulation of a temperature sensor class as a
 * Concrete Subject class of the JDK Observer Pattern skeleton. 
 * 
 * @author Richard Thomas
 * @version 1.0
 *
 */
public class TempSensor extends Observable {
	private double temp; 
	private double low; 
	private double high;
	private Random rng;
	
	
	/**
	 * Set up the temperature sensor simulation details.
	 * 
	 * @param seed Seed value for the random number generator used to generate temperature changes.
	 * @param high The maximum temperature that can be read by this sensor.
	 * @param low  The minimum temperature that can be read by this sensor.
	 */
	public TempSensor(long seed, double high, double low) {
		this.rng = new Random(seed); 
		this.high = high;
		this.low = low;
	}
	
	/**
	 * Gets the new temperature reading for this sensor.
	 * Implemented as a random number between low and high temperature limits. 
	 */
	public void setState() {
		double range = high - low;
		temp = Math.round(rng.nextDouble()*range + low);
		setChanged();			// This temperature sensor's state is now marked as changed
	}
	
	/**
	 * @return The current temperature value.
	 */
	public double getState() {
		return temp;
	}

}
