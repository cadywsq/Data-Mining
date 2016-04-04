package decisiontree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class TreeNode {
    boolean isLeaf;
    // @attribute: Service_type, Customer, Monthly_fee, Advertisement_budget
    // Size, Promotion, Interest_rate, Period
    Attribute splitByAttribute;
    // @attribute Label {0,1}
    String label;

    List<TreeNode> children;

    // common attribute value
    String commonValue;

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
                if (splitValue != null) {
                    System.out.print(splitValue);
                    child.print(depth + 1);
                } else {
                    System.out.print(child.splitNum);
                    child.print(depth + 1);
                }

            }


        }
    }
}
