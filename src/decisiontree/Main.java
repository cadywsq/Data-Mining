package decisiontree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by wangxinlei on 4/3/16.
 */
public class Main {
    public static void main(String[] args) {
        // train or build tree
    }

    private static DataSet read(String filename) {
        DataSet data = new DataSet();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException exception) {
            System.out.println("Error: could not find file");
            System.exit(1);
        }
        String line;
        scanner.nextLine(); // Skip first line
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("@data"))
                break;
            data.addAttribute(line);
        }
        while (scanner.hasNextLine())
            data.addInstance(scanner.nextLine());
        return data;
    }
}
