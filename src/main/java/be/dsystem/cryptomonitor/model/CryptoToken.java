package be.dsystem.cryptomonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoToken {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String ticker;
    @Column
    private String lastPrice;
    @Column
    private LocalDateTime lastDate;
    @Column
    private LocalDateTime addedDate;
    @Column(unique = true)
    private long CMCId;
}
