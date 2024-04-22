package be.dsystem.cryptomonitor.backgroundservice;

import be.dsystem.cryptomonitor.CMCApi.CMCApi;
import be.dsystem.cryptomonitor.CMCApi.Cryptocurrency;
import be.dsystem.cryptomonitor.model.CryptoToken;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import be.dsystem.cryptomonitor.repository.CryptoTokenRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoWatchApiCrawler {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(CryptoWatchApiCrawler.class);
    @Autowired
    private CryptoTokenRepository cryptoTokenRepository;
    @Scheduled(fixedRate = 60000)
    public void crawlApi() {
        CMCApi api = new CMCApi();
        Cryptocurrency[] cryptos = api.getCryptocurrencies();
        List<CryptoToken> tokens = new ArrayList<CryptoToken>();
        for (Cryptocurrency crypto : cryptos) {
            //logger.info(crypto.getName());
            CryptoToken token = CryptoToken.builder()
                    .name(crypto.getName())
                    .ticker(crypto.getSymbol())
                    .CMCId(crypto.getId())
                    .build();
            tokens.add(token);
        }
        saveEntities(tokens);
    }

    @Transactional
    public void saveEntities(List<CryptoToken> entities) {
        for (CryptoToken entity : entities) {
            try {
                cryptoTokenRepository.save(entity);
            } catch (DataIntegrityViolationException e) {
                // Handle constraint violation for this entity
                System.out.println("Constraint violation occurred for entity with ID " + entity.getId() + ". Entity not saved.");
            } catch (Exception e) {
                // Handle other types of exceptions
                e.printStackTrace();
            }
        }
    }
}