package be.dsystem.cryptomonitor.CMCApi;

import be.dsystem.cryptomonitor.backgroundservice.CryptoWatchApiCrawler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CMCApi {
    @Value("${cmc.api.key}")
    private static final String API_KEY = "";

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(CryptoWatchApiCrawler.class);
    public Cryptocurrency[] getCryptocurrencies() {
        try {
            URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("X-CMC_PRO_API_KEY", API_KEY);

            int responseCode = conn.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON response using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            //logger.info(response.toString());
            CryptocurrencyMapResponse cryptocurrencyMapResponse = objectMapper.readValue(response.toString(), CryptocurrencyMapResponse.class);

            conn.disconnect();

            return cryptocurrencyMapResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
