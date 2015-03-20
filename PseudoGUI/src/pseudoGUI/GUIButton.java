package pseudoGUI;

import guiEvents.GUIEvent;
import guiEvents.GUIEventListener;
import guiEvents.GUIEventSource;

import java.util.ListIterator;
import java.util.ArrayList;


/**
 * The Concrete Subject class for the Observer Pattern example 
 * @author hogan
 *
 */
public class GUIButton implements GUIEventSource {
	private String name; 
	private boolean clicked;
	private ArrayList<GUIEventListener> guiEventListeners; 
	
	public GUIButton(String nm) {
		name = nm;
		clicked = false; 
		guiEventListeners = new ArrayList<GUIEventListener>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void doClick() {
		clicked = true; 
		fireGUIEvent();
		clicked = false;
	}

	@Override
	public void fireGUIEvent() {
		ListIterator<GUIEventListener> iter = guiEventListeners.listIterator();
		while (iter.hasNext()) {
			iter.next().guiActionPerformed(new GUIEvent(this));
		}
	}

	@Override
	public void addGUIEventListener(GUIEventListener gel) {
		this.guiEventListeners.add(gel);
	}

	@Override
	public void removeGUIEventListener(GUIEventListener gel) {
		this.guiEventListeners.remove(gel);
	}
	
	@Override
	public String toString() { 
		return "guiButton:" + this.name; 
	}
	
	
}
