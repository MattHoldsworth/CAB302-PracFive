package guiSkeleton.pseudoGUI;

import guiSkeleton.guiEvents.GUIEvent;
import guiSkeleton.guiEvents.GUIEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GUIDisplay implements GUIEventListener {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private String regionName;
	
	
	public GUIDisplay(String rn) {
		regionName = rn;
	}

	@Override
	public void guiActionPerformed(GUIEvent ge) {
		GUIButton guiB = ((GUIButton) (ge.getSource()));
		guiB.setName(guiB.getName()+"K");
		String str = regionName + ":" + ge.toString() + 
					 ":" + ge.getSource().toString() + ":" + now();
		System.out.println(str);
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
