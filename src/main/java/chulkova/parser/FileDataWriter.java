package chulkova.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataWriter {

    public static void write(String tests) throws IOException {
        File report = new File("report.json");
        report.createNewFile();
        try (FileWriter writer = new FileWriter("report.json")) {
            writer.write(String.valueOf(tests));
        }
    }
}
