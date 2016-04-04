package decisiontree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Siqi Wang siqiw1 on 4/3/16.
 */
public class InfoRatio {
    private static final String FILE_PATH = "trainProdIntro.binary.arff";
    private static DataSet dataSet = Main.readData(FILE_PATH);
    private static ArrayList<Attribute> attributeList = dataSet.attributes;

    // For numeric attribute, use SplitValue to encapsulate and compare.
    static class SplitValue implements Comparable<SplitValue> {
        private double splitValue;
        private String attribute;
        private double infoGain;

        public SplitValue(double splitValue, String attribute, double infoGain) {
            this.splitValue = splitValue;
            this.setAttribute(attribute);
            this.infoGain = infoGain;
        }

        public double getSplitValue() {
            return splitValue;
        }

        public void setSplitValue(double splitValue) {
            this.splitValue = splitValue;
        }

        public double getInfoGain() {
            return infoGain;
        }

        public void setInfoGain(double infoGain) {
            this.infoGain = infoGain;
        }

        @Override
        public int compareTo(SplitValue o) {
            if (o.getInfoGain() - this.getInfoGain() > 0) {
                return 1;
            } else if (o.getInfoGain() - this.getInfoGain() < 0) {
                return -1;
            }
            return 0;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }
    }

//    private static final ArrayList<String> discreteAttribute = new ArrayList<String>() {{
//        discreteAttribute.add("Service_type");
//        discreteAttribute.add("Customer");
//        discreteAttribute.add("Size");
//        discreteAttribute.add("Promotion");
//    }};
//    private static final ArrayList<String> continuousAttribute = new ArrayList<String>() {{
//        continuousAttribute.add("Monthly_fee");
//        continuousAttribute.add("Advertisement_budget");
//        continuousAttribute.add("Interest_rate");
//        continuousAttribute.add("Period");
//    }};

    private static double getEntropy(int label0, int label1) {
        double p0 = label0 / (label0 + label1);
        double p1 = label1 / (label0 + label1);
        return -p0 * Math.log(p0) - p1 * Math.log(p1);
    }

    private static double getDiscreteInfoGain(ArrayList<Instance> instances, String attribute) {
        //Count of instance with label 0 for each attribute splitValue.
        Map<String, Integer> label0CountMap = new HashMap<>();
        //Count of instance with label 1 for each attribute splitValue.
        Map<String, Integer> label1CountMap = new HashMap<>();

        int totalLabel0 = 0;
        int totalLabel1 = 0;

        for (Instance instance : instances) {
            if (instance.label.equals("0")) {
                ++totalLabel0;
                String attributeValue = instance.attributeMap.get(attribute);
                if (label0CountMap.containsKey(attributeValue)) {
                    label0CountMap.put(attributeValue, label0CountMap.get(attributeValue) + 1);
                } else {
                    label0CountMap.put(attributeValue, 1);
                }
                // else if to avoid null label.
            } else if (instance.label.equals("1")) {
                ++totalLabel1;
                String attributeValue = instance.attributeMap.get(attribute);
                if (label1CountMap.containsKey(attributeValue)) {
                    label1CountMap.put(attributeValue, label1CountMap.get(attributeValue) + 1);
                } else {
                    label1CountMap.put(attributeValue, 1);
                }
            }
        }
        // Gain(S,A) = Entropy(S) - Sigma (Sv/S)Entropy(Sv)
        int accumEntropySi = 0;

        for (Attribute theAttribute : attributeList) {
            int sLabel0 = label0CountMap.get(theAttribute);
            int sLabel1 = label1CountMap.get(theAttribute);
            accumEntropySi += (sLabel0 + sLabel1) / (totalLabel0 + totalLabel1) * getEntropy(sLabel0, sLabel1);
        }
        double entropyS = getEntropy(totalLabel0, totalLabel1);
        return entropyS - accumEntropySi;
    }

    /**
     * Get the information gain for continuous attribute.
     * @param instances
     * @param attribute
     * @return
     */
    private static SplitValue getContinuousInfoGain(ArrayList<Instance> instances, String attribute) {
        ArrayList<SplitValue> splitValueList = new ArrayList<>();
        for (Instance instance : instances) {
            double value = Double.valueOf(instance.attributeMap.get(attribute));
            for (Instance theInstance : instances) {
                double theValue = Double.valueOf(theInstance.attributeMap.get(attribute));
                if (theValue < value) {
                    instance.attributeMap.put(attribute, "0");
                } else {
                    instance.attributeMap.put(attribute, "1");
                }
            }
            for (int i = 0; i < instances.size(); i++) {
                SplitValue splitValue = new SplitValue(value, attribute, getDiscreteInfoGain(dataSet, attribute));
                splitValueList.add(splitValue);
            }
        }
        Collections.sort(splitValueList);
        return splitValueList.get(0);
    }


    static Attribute getBestAttribute(ArrayList<Instance> instances) {
        TreeMap<Double, Attribute> infoGainMap = new TreeMap<>();

        for (Attribute theAttribute : attributeList) {
            if (!theAttribute.numeric) {
                infoGainMap.put(getDiscreteInfoGain(dataSet, theAttribute.name), theAttribute);
            } else {
                infoGainMap.put(getContinuousInfoGain(dataSet, theAttribute.name), theAttribute);
            }
        }
        return infoGainMap.firstEntry().getValue();
    }

    /**
     * Get hashmap for splited instances lists, attribute value as key, instances of the same kind as value.
     * @param instances
     * @param attribute
     * @return
     */
    static HashMap<String, ArrayList<Instance>> getSplitedInstances(ArrayList<Instance> instances, String attribute) {

    }

//    enum ServiceType {
//        FUND, LOAN, CD, BANK_ACCOUNT, MORTGAGE
//    }
//
//    enum Customer {
//        STUDENT, BUSINESS, OTHER, DOCTOR, PROFESSIONAL
//    }
//
//    enum Size {
//        SMALL, LARGE, MEDIUM
//    }
//
//    enum Promotion {
//        WEB_EMAIL, FULL, WEB, NONE
//    }
}
