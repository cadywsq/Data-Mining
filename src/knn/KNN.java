package knn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuheng Li
 * @version 1.0
 * @since Mar 28, 2016
 */
public class KNN {
    List<Element> trainData = new ArrayList<Element>();
    private double[] weights;

    /**
     * constructor
     * Initialize a task11.knn.KNN instance
     * task11.knn.KNN k = new task11.knn.KNN();
     * set training set
     * k.setTrain("URL");
     * predict the test set
     * k.predict("URL");
     * return a predict result instance, with all predictions and a accuracy
     */
    public KNN() {
    }

    /**
     * train the task11.knn.KNN model using given training set
     *
     * @param path       training set file
     * @param isWeighted false: use even weight, otherwise, using 10 fold CV to calculate the best weight
     * @return return model
     */
    public void train(String path, boolean isWeighted) {
    }

    public Result predict(String path) {
        return new Result();
    }

    private void crossValidation(int fold) {

    }

    private double calculateSim() {
        return 2;
    }

    private List<Element> loadData(String path) {
        return trainData;
    }
}
