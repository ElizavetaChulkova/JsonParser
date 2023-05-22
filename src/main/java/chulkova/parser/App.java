package chulkova.parser;

import chulkova.parser.models.Value;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter path to tests.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine(); //reading paths to JSON files
        System.out.println("Please, enter path to values.json");
        String file2 = br.readLine();
//получила список объектов tests.json
        String dataFromFile1 = FileDataReader.read(file1);
//        List<TestItem> testItem = new ObjectMapper().readValue(dataFromFile1, TestItem.class).getTests();

//получила список объектов values.json
        String dataFromFile2 = FileDataReader.read(file2);
        List<Value> value = new ObjectMapper().readValue(dataFromFile2, Value.class).getValues();
        Map<Integer, String> valuesMap = convertListToMap(value);

        //получить ноды объектов tests.json
        JsonNode root = mapper.readTree(new File(file1));
        List<JsonNode> array = root.findParents("id");

        List<JsonNode> valuesArray = mapper.readTree(new File(file2)).findParents("id");

        JsonNode rootNode = mapper.readValue(dataFromFile1, JsonNode.class);
        rootNode = rootNode.findParent("value");

        for (JsonNode j : array) {
            int jId = j.path("id").asInt();
            for (JsonNode v : valuesArray) {
                System.out.println(jId);
                int vId = v.path("id").asInt();
                System.out.println(vId);
                if (jId == vId) {
                    String updatedValue = v.path("value").asText();
                    System.out.println(updatedValue);
                    ((ObjectNode) j).put("value", updatedValue);
                    System.out.println(j);
                }
            }
        }
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(array);
        FileDataWriter.write(result);
        System.out.println(result);
    }

    public static Map<Integer, String> convertListToMap(List<Value> values) {
        return values.stream().collect(Collectors.toMap(Value::getId, Value::getValue));
    }
}