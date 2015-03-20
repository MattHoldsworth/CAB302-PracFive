package applications.temperature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observer;
import java.util.Observable;


/**
 * A simple monitor that observes and reports changes in the temperature sensor.
 * 
 * @author Richard Thomas
 * @version 1.0
 * 
 */
public class TempMonitor implements Observer {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private double observedTemp;
	private String serviceName; 
	
	/**
	 * Create a temperature monitor object with the provided service name.
	 * @param sn Service name for this temperature monitor object.
	 */
	public TempMonitor(String sn) {
		serviceName = sn;
	}

	@Override
	/**
	 * Update the observed temperature from the temperature sensor.
	 * This method is called by the Observable object.
	 * 
	 * @param subject The Observable subject that has changed state.
	 * @param o Ignored in this implementation.
	 */
	public void update(Observable subject, Object o) {
		observedTemp = ((TempSensor) subject).getState(); 
	}
	
	/**
	 * @return A string containing this monitor's name, time stamp and current temperature.
	 */
	public String generateReport() {
		String str = serviceName + ": " + "Temperature Report at :" + now() +
					 " :: " + observedTemp + " Celsius";
		return str; 
	}

	
	/**
	 * @return The current date and time.
	 */
	private String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
    }

}
