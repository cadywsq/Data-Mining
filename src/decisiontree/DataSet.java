package decisiontree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Stores a set of instances
public class DataSet {

    // Ordered list of instances
    public ArrayList<Instance> instances;
    public ArrayList<Attribute> attributes;

    public DataSet() {
        instances = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    // Add instance to data set (add all attributes before doing this)
    public void addInstance(String line) {
        String[] values = line.split(",");
        Map<String, String> attributeValues = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            attributeValues.put(attributes.get(i).name, values[i]);
        }
        instances.add(attributeValues);
//        ArrayList<String> features = new ArrayList<String>(Arrays.asList(line.split(",")));
//        String label = features.remove(features.size() - 1);
//        LinkedHashMap<String, String> attributeValues = new LinkedHashMap<String, String>();
//        for (int i = 0; i < features.size(); i++) {
//            attributeValues.put(attributes.get(i).name, features.get(i));
//        }
//        instances.add(new Instance(attributeValues, label));
    }

    // Add attribute to data set
    public void addAttribute(String line) {
        // Break line into attribute name and attributeValues
        String[] tokens = line.split(" ");
        ArrayList<String> values = new ArrayList<>(Arrays.asList(tokens[2].split("\\W+")));
        attributes.add(new Attribute(values, tokens[1]));
    }

}
