
package patterns.mystery; 

import patterns.mystery.Mystery;


public class MysteryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mystery m1 = Mystery.getInstance(); 
		m1.HereIAm();
		Mystery m2 = Mystery.getInstance();
		m2.HereIAm();
	}

}
