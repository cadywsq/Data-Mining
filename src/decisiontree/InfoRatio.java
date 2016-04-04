package decisiontree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Siqi Wang siqiw1 on 4/3/16.
 */
public class InfoRatio {
    private static double getEntropy(int label0, int label1) {
        double p0 = label0 / (label0 + label1);
        double p1 = label1 / (label0 + label1);
        return -p0 * Math.log(p0) - p1 * Math.log(p1);
    }

    static double getInfoGain(DataSet dataSet, String attribute) {
        ArrayList<Attribute> attributes = dataSet.attributes;
        Map<String, Integer> label0CountMap = new HashMap<>();
        Map<String, Integer> label1CountMap = new HashMap<>();
        ArrayList<Instance> instances = dataSet.instances;
        int totalLabel0 = 0;
        int totalLabel1 = 0;
        for (Instance instance : instances) {
            // else if to avoid null label.
            if (instance.label.equals("0")) {
                ++totalLabel0;
                String attributeValue = instance.attributeValues.get(attribute);
                if (label0CountMap.containsKey(attributeValue)) {
                    label0CountMap.put(attributeValue, label0CountMap.get(attributeValue) + 1);
                }
                label0CountMap.put(attributeValue, 1);
            } else if (instance.label.equals("1")) {
                ++totalLabel1;
                String attributeValue = instance.attributeValues.get(attribute);
                if (label1CountMap.containsKey(attributeValue)) {
                    label1CountMap.put(attributeValue, label1CountMap.get(attributeValue) + 1);
                }
                label1CountMap.put(attributeValue, 1);
            }
        }
        for (int i = 0; i < label0CountMap.size(); i++) {

        }


    }

    static Attribute getBestAttribute() {

    }

    enum ServiceType {
        FUND, LOAN, CD, BANK_ACCOUNT, MORTGAGE
    }

    enum Customer {
        STUDENT, BUSINESS, OTHER, DOCTOR, PROFESSIONAL
    }

    enum Size {
        SMALL, LARGE, MEDIUM
    }

    enum Promotion {
        WEB_EMAIL, FULL, WEB, NONE
    }
}
