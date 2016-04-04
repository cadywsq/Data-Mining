package decisiontree;

import java.util.ArrayList;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class TreeNode {
    boolean isLeaf;
    // @attribute: Service_type, Customer, Monthly_fee, Advertisement_budget
    // Size, Promotion, Interest_rate, Period
    String attributeName;
    // @attribute Label {0,1}
    String label;

    ArrayList<TreeNode> children;

    // common attribute value
    String commonValue;

    ArrayList<Instance> instanceList;
    ArrayList<Attribute> remainingAttribute;

    public TreeNode(String attributeOrLabel, boolean isLeaf) {
        this.isLeaf = isLeaf;
        if (isLeaf) {
            children = null;
            label = attributeOrLabel;
        } else {
            children = new ArrayList<>();
            attributeName = attributeOrLabel;
        }
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    // Prints the entire subtree  of the node
    public void print(int depth) {
        if (isLeaf) {
            System.out.print(": " + label);
        } else {
            for (TreeNode child : children) {
                System.out.print("\n");
                for (int i = 0; i < depth; i++)
                    System.out.print("|\t");
                System.out.print(attributeName);
                System.out.print(commonValue);
                child.print(depth + 1);

            }


        }
    }
}
