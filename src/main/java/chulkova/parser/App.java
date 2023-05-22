package chulkova.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter path to tests.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileTests = br.readLine();
        System.out.println("Please, enter path to values.json");
        String fileValues = br.readLine();

        List<JsonNode> testsArray = mapper.readTree(new File(fileTests))
                .findParents("id");
        List<JsonNode> valuesArray = mapper.readTree(new File(fileValues))
                .findParents("id");

        inputValues(testsArray, valuesArray);
        String result = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(testsArray);
        FileDataWriter.write(result);
        System.out.println(result);
    }

    private static void inputValues(List<JsonNode> testsArray,
                                    List<JsonNode> valuesArray) throws JsonProcessingException {
        for (JsonNode j : testsArray) {
            int jId = j.path("id").asInt();
            for (JsonNode v : valuesArray) {
                int vId = v.path("id").asInt();
                if (jId == vId) {
                    String updatedValue = v.path("value").asText();
                    ((ObjectNode) j).put("value", updatedValue);
                }
            }
        }
    }
}