package decisiontree;

import java.util.ArrayList;

public class LearningSet {
	private ArrayList<AttributeSet> attributes;
	
	public LearningSet() {
		attributes = new ArrayList<AttributeSet>();
	}

	public void setAttributes(ArrayList<AttributeSet> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<AttributeSet> getAttributes() {
		return attributes;
	}
}
