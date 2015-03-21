package applications.temperature;

import java.util.Random;

/**
 * Main class for the temperature application. 
 * @author hogan
 *
 */
public class Temperature {

	/**
	 * @param args Ignored in this implementation
	 */
	public static void main(String[] args) {
		TempSensor ts = new TempSensor(100,40.0,0.0); 
		TempMonitor bureauNews = new TempMonitor("The Bureau");
		TempMonitor wolfNews = new TempMonitor("Wolf News");
		
		//Observers 
		ts.addObserver(bureauNews);
		ts.addObserver(wolfNews); 
		
		Random rng = new Random(); 
		
		for (int i=0; i<=100; i++) {
			updateNotifyAndReport(ts, bureauNews, wolfNews); 
			
			// Pause for up to 4 seconds.
			long wait = rng.nextInt(4000);
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	private static void updateNotifyAndReport(TempSensor ts,
			TempMonitor bureauNews, TempMonitor wolfNews) {
		ts.setState();
		ts.notifyObservers();
		System.out.println(bureauNews.generateReport());
		System.out.println(wolfNews.generateReport());
		System.out.println();
	}

}
