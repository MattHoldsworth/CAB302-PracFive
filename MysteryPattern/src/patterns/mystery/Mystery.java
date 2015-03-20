package patterns.mystery;

public class Mystery {
	private String name; 
	protected Mystery (String s) {
		this.name=s; 
	}
	 
	private static class MysteryHolder { 
	   private final static Mystery INSTANCE = new Mystery("MysteryHolder Call");
	}
	
	public static Mystery getInstance() {
	   return MysteryHolder.INSTANCE;
	}
	
	public void HereIAm() {
		System.out.println("This is a mystery class");
		System.out.println("My name is: "+this.name); 
	}
}
