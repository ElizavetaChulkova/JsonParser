package chulkova.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDataReader {

    public static String read(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (sc.hasNext()) {
            builder.append(sc.next());
        }
        return builder.toString();
    }
}
