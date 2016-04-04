package decisiontree;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class Tree {

    public TreeNode buildDecisionTree(List<Instance> instances, List<Attribute> attributes,
                                      List<Instance> parentInstances) {
        if (instances.isEmpty())
            return new TreeNode(getLabel(parentInstances), true);

        // Returns null if no more features / positive gain features
        Attribute bestAttribute = InfoRatio.getBestAttribute(instances, attributes);
        if (bestAttribute == null)
            return new TreeNode(getLabel(instances), true);

        TreeNode root = new TreeNode(bestAttribute.name, false);

        HashMap<String, List<Instance>> subsets = new HashMap<String, List<Instance>>();



        return root;
    }

    private String getLabel(List<Instance> instances) {
        int countOne = 0;
        for (Instance instance : instances)
            if (instance.label.equals("1"))
                countOne++;
        if (countOne >= instances.size()/2)
            return "1";
        else return "0";
    }

}
