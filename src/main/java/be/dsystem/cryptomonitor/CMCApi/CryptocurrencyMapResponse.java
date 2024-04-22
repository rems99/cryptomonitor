package be.dsystem.cryptomonitor.CMCApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptocurrencyMapResponse {
    @JsonProperty("data")
    private Cryptocurrency[] data;

    public Cryptocurrency[] getData() {
        return data;
    }

    public void setData(Cryptocurrency[] data) {
        this.data = data;
    }
}
