package decisiontree;

import java.util.List;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class TreeNode {
    boolean isLeaf;
    String attributeName;
    List<TreeNode> children;
    String splitValue;
    double splitNum;
}
