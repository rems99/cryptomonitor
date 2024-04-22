package be.dsystem.cryptomonitor;

import be.dsystem.cryptomonitor.model.CryptoToken;
import be.dsystem.cryptomonitor.repository.CryptoTokenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CryptomonitorApplicationTests {

	@Autowired
	CryptoTokenRepository cryptoTokenRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void cryptoTokenTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		CryptoToken cryptoToken = new CryptoToken();
		cryptoToken.setName("Bitcoin");
		cryptoToken.setTicker("BTC");
		cryptoToken.setLastPrice("10000");
		cryptoToken.setLastDate(LocalDateTime.parse(LocalDateTime.now().format(formatter)));
		cryptoToken.setAddedDate(LocalDateTime.parse(LocalDateTime.now().format(formatter)));
		cryptoTokenRepository.save(cryptoToken);
		assertEquals("Bitcoin", cryptoToken.getName());
		assertEquals("BTC", cryptoToken.getTicker());
		assertEquals("10000", cryptoToken.getLastPrice());
		//get token from db and assert that it is the same
		CryptoToken dbToken = cryptoTokenRepository.findById(cryptoToken.getId()).get();
		assertEquals(cryptoToken, dbToken);
	}

}
