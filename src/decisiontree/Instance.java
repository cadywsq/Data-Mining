package decisiontree;

import java.util.HashMap;

// Holds data for a training instance
public class Instance {
	
	public final String label;
	public final HashMap<String, String> attributeValues;
	
	public Instance(HashMap<String, String> attributeValues, String label) {
		this.label = label;
		this.attributeValues = attributeValues;
	}
	
	// Developer tool: print instance
	public void print() {
		System.out.println(label + ": " + attributeValues);
	}
	

}
