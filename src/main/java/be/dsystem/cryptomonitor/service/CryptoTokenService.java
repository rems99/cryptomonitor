package be.dsystem.cryptomonitor.service;

import be.dsystem.cryptomonitor.model.CryptoToken;
import be.dsystem.cryptomonitor.repository.CryptoTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoTokenService {
    @Autowired
    private CryptoTokenRepository cryptotokenRepository;

    public Page<CryptoToken> findAllWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return cryptotokenRepository.findAll(pageable);
    }



}
