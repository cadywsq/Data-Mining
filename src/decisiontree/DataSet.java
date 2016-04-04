package decisiontree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Stores a set of instances
public class DataSet {
//    private static final String FILE_PATH = "trainProdIntro.binary.arff";

    // Ordered list of instances
    public ArrayList<Attribute> attributes;
    public ArrayList<Instance> instances;

//    public DataSet() {
//        attributes = readData(FILE_PATH).attributes;
//        instances = readData(FILE_PATH).instances;
//    }

    // Add attribute to data set
    public void addAttribute(String line) {
        // Break line into attribute name and attributeMap
        String[] tokens = line.split(" ");
        ArrayList<String> values = new ArrayList<>(Arrays.asList(tokens[2].split(",")));
        if (values.size() != 1) {
            values.get(0).replace("{", "");
            values.get(values.size() - 1).replace("}", "");
        }
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

    static DataSet readData(String filename) {
        DataSet data = new DataSet();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException exception) {
            System.out.println("Error: could not find file");
            System.exit(1);
        }
        String line;
        scanner.nextLine(); // Skip first line
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("@data")) {
                break;
            }
            data.addAttribute(line);
        }
        while (scanner.hasNextLine()) {
            data.addInstance(scanner.nextLine());
        }
        return data;
    }

}
