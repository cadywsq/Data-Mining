package decisiontree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Stores a set of instances
public class DataSet {

    // Ordered list of instances
    public ArrayList<Attribute> attributes;
    public ArrayList<Instance> instances;

    public DataSet() {
        attributes = new ArrayList<>();
        instances = new ArrayList<>();
    }

    // Add attribute to data set
    public void addAttribute(String line) {
        // Break line into attribute name and attributeMap
        String[] tokens = line.split(" ");
        ArrayList<String> values = new ArrayList<>(Arrays.asList(tokens[2].split(",")));
        values.get(0).replace("{", "");
        values.get(values.size() - 1).replace("}", "");
        attributes.add(new Attribute(values, tokens[1]));
    }

    // Add instance to data set (add all attributes before doing this)
    public void addInstance(String line) {
        String[] values = line.split(",");
        HashMap<String, String> attributeValues = new HashMap<>();
        for (int i = 0; i < values.length - 1; i++) {
            attributeValues.put(attributes.get(i).name, values[i]);
        }
        instances.add(new Instance(attributeValues, values[values.length - 1]));
    }

}
