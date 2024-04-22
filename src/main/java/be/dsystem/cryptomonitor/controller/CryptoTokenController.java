package be.dsystem.cryptomonitor.controller;

import be.dsystem.cryptomonitor.model.CryptoToken;
import be.dsystem.cryptomonitor.service.CryptoTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoTokenController {

    @Autowired
    private CryptoTokenService cryptotokenService;

    @GetMapping("/cryptotokens")
    public ResponseEntity<Page<CryptoToken>> getPagesOfCryptoTokens(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<CryptoToken> page =cryptotokenService.findAllWithPagination(pageNumber, pageSize);
        return ResponseEntity.ok(page);
    }

}
