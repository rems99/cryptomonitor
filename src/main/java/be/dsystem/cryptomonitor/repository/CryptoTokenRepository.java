package be.dsystem.cryptomonitor.repository;

import be.dsystem.cryptomonitor.model.CryptoToken;
import be.dsystem.cryptomonitor.service.CryptoTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CryptoTokenRepository extends JpaRepository<CryptoToken, UUID> {
}

