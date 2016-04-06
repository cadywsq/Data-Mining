package decisiontreeV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for decision tree learner
public class Main {

	// Extracts data set from ARFF file
	@SuppressWarnings("resource")
	private static DataSet read(String filename) {
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
			if (line.equals("@data"))
				break;
			if (line != null && !line.equals(""))
			    data.addAttribute(line);
		}
		data.attributes.remove(data.attributes.size() - 1);
		while (scanner.hasNextLine())
			data.addInstance(scanner.nextLine());
		return data;
	}

	public static void main(String[] args) {
	    String train = "/Users/wangxinlei/Documents/workspace/DecisionTreeSimple/src/trainProdIntro.binary.arff";
	    String test = "/Users/wangxinlei/Documents/workspace/DecisionTreeSimple/src/testProdIntro.binary.arff";
		DataSet trainingSet = read(train);

		DataSet testingSet = read(test);
		int stopValue = Integer.parseInt("1");

		DecisionTree ID3 = new DecisionTree(stopValue);
		ID3.train(trainingSet);
		ID3.test(trainingSet.instances);
	}

	private static void crossValidate(DataSet trainingSet) {
	    for (int i = 0; i < 10; i++) {
            //Cut samples to k sets
            List<List<Instance>> kSets = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                kSets.add(new ArrayList<>());
            }

            //k-1 sets as training, ith set as testing
            ArrayList<Instance> training = new ArrayList<>();
            ArrayList<Instance> testing = new ArrayList<>();
            testing.addAll(kSets.get(i));
            for (int j = 0; j < 10; j++) {
                if (j != i) {
                    training.addAll(kSets.get(j));
                }
            }

            //Train and predict
            DecisionTree root = new DecisionTree(1);
//            root.train(training);
            root.test(testing);
        }

//        System.out.println("average accuracy" + accuracySum / K);

	}
}
