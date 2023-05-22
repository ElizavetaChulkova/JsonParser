package chulkova.parser.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Value {

    private Integer id;
    private String value;
    private List<Value> values;
}
