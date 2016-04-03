package decisiontree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
    public static final String DATA_PATH = "trainProdIntro.binary.arff";

    static ArrayList<Record> buildRecords() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(FileReader.class.getResourceAsStream
                (DATA_PATH)))) {
            ArrayList<Record> records = new ArrayList<>();
            String input = null;
            while (!(input = br.readLine()).equals("@data")) {
                continue;
            }
            while ((input = br.readLine()) != null) {
                String[] tokens = input.split(",");
                Record record = new Record()
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
