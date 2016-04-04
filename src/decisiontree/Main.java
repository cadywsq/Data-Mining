package decisiontree;

import java.util.ArrayList;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class Main {
    public static void main(String[] arg) {
        // train or build tree
        DataSet dataSet = DataSet.readData(InfoRatio.FILE_PATH);
        ArrayList<Attribute> attributes = dataSet.attributes;
        ArrayList<Instance> instances = dataSet.instances;
    }

}
