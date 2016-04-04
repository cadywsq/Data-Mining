package decisiontree;

import java.util.Map;

// Holds data for a training instance
public class Instance {
	
	public final String label;
	public final Map<String, String> attributeValues;
	
	public Instance(Map<String, String> attributeValues, String label) {
		this.label = label;
		this.attributeValues = attributeValues;
	}
	
	// Developer tool: print instance
	public void print() {
		System.out.println(label + ": " + attributeValues);
	}
	

}
