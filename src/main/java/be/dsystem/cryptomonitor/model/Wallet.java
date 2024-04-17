package be.dsystem.cryptomonitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Wallet {
    @Id
    private Long id;
    @OneToMany
    List<Position> positions;
}
