package decisiontree;

import java.util.ArrayList;

public class Entropy {
    public static double calculateEntropy(ArrayList<Record> data) {

    }

    public static double calculateGain(double rootEntropy, ArrayList<Double> subEntropies, ArrayList<Integer> setSizes, int data) {
        double gain = rootEntropy;

        for (int i = 0; i < subEntropies.size(); i++) {
            gain += -((setSizes.get(i) / (double) data) * subEntropies.get(i));
        }

        return gain;
    }
}
