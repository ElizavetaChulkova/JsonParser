package chulkova.parser.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TestItem {

    private Integer id;
    private String title;
    private String value;
    private List<TestItem> values;
}
