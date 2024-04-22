package be.dsystem.cryptomonitor.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Wallet {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany
    List<Position> positions;
}
