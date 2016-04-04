package decisiontree;

import java.util.List;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class Attribute {
    public final String name;
    public final List<String> values;
    public final boolean numeric;
    public final boolean label;

    public Attribute(List<String> values, String name) {
        this.name = name;
        this.values = values;
        if (values.size() == 1 && values.get(0).equals("real"))
            numeric = true;
        else
            numeric = false;
        if (name.equals("Label"))
            label = true;
        else
            label = false;
    }
}
