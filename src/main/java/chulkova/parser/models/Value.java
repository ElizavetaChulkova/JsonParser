package chulkova.parser.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Value {
    private Integer id;
    private String value;
    @JsonProperty(value = "values")
    List<Value> values;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
