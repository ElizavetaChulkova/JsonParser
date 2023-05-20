package chulkova.parser.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestItem {

    private Integer id;

    private String title;
    private String value;
    private List<TestItem> values;
    @JsonProperty(value = "tests")
    private List<TestItem> tests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TestItem> getValues() {
        return values;
    }

    public void setValues(List<TestItem> values) {
        this.values = values;
    }

    public List<TestItem> getTests() {
        return tests;
    }

    public void setTests(List<TestItem> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "TestItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
