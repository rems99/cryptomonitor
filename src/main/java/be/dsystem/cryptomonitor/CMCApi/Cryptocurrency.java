package be.dsystem.cryptomonitor.CMCApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Cryptocurrency {
        @JsonProperty("id")
        private long id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("symbol")
        private String symbol;
        @JsonProperty("slug")
        private String slug;

}
