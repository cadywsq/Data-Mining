package decisiontree;

import java.util.HashMap;

// Holds data for a training instance
public class Instance {
	
	public final String label;
	public final HashMap<Attribute, String> attributeMap;
	
	public Instance(HashMap<Attribute, String> attributeMap, String label) {
		this.label = label;
		this.attributeMap = attributeMap;
	}
	
	// Developer tool: print instance
	public void print() {
		System.out.println(label + ": " + attributeMap);
	}
	

}
