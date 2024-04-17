package be.dsystem.cryptomonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import javax.naming.Name;
import java.time.LocalDate;

@Entity
@Data
public class CryptoToken {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String ticker;
    @Column
    private String lastPrice;
    @Column
    private LocalDate lastDate;
    @Column
    private LocalDate addedDate;
}
