package guiSkeleton.pseudoGUI;

import guiSkeleton.guiEvents.GUIEventSource;

import java.util.Random;

/**
 * Main class for simulating a GUI. 
 * @author hogan
 *
 */
public class GUISimulator {
	public static final int MAX_DELAY = 4000;
	private int maxTrials;
	private int numTrials; 
	private GUIEventSource guiSource; 
	private Random rng;
	
	
	public GUISimulator(GUIEventSource ges, int maxTrials) {
		this.guiSource = ges;
		this.maxTrials = maxTrials;
		this.numTrials = 0; 
		this.rng = new Random(); 
	}
	
	public boolean simulationComplete() {
		return numTrials == maxTrials;
	}
	
	public void nextTrial() {
		guiSource.doClick();
		waitRandomTime(); 
		numTrials++; 
	}
	
	
	private void waitRandomTime() {
		long wait = rng.nextInt(MAX_DELAY);
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	/**
	 * Main programme for the simulation code 
	 * @param args
	 */
	public static void main(String[] args) {
		final int MAX = 20; 
		GUIButton gUIButton = new GUIButton("OK"); 
		GUIDisplay left = new GUIDisplay("Left Hand Panel");
		GUIDisplay right = new GUIDisplay("Right Hand Panel");
		
		addListeners(gUIButton, left, right); 
		GUISimulator guiSim = new GUISimulator(gUIButton, MAX);
		
		while (!guiSim.simulationComplete()) {
			guiSim.nextTrial();
			System.out.println();
		}
	}

	
	private static void addListeners(GUIButton psb, GUIDisplay left,
									 GUIDisplay right) {
		psb.addGUIEventListener(left);
		psb.addGUIEventListener(right);
	}

}
