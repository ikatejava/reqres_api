package in.reqres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResourceDataModel {
    int id, year;
    String name, color;
    @JsonProperty("pantone_value")
    String pantoneValue;
}
