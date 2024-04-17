package be.dsystem.cryptomonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
public class Position {
    @Id
    private Long id;
    @Column
    private LocalDate date;
    @OneToOne
    private CryptoToken token;
    @OneToOne
    private  Position position;
}
