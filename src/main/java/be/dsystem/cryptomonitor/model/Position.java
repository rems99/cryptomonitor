package be.dsystem.cryptomonitor.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private LocalDateTime date;
    @OneToOne
    private CryptoToken token;
    @OneToOne
    private  Position position;
}
