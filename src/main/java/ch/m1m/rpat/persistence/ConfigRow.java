package ch.m1m.rpat.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "config")
@Getter
@Setter
@NoArgsConstructor
@IdClass(ConfigId.class)
public class ConfigRow {

    @Id
    private String application;

    @Id
    private String key;

    private String value;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    public ConfigRow(String application, String key, String value) {
        this.application = application;
        this.key = key;
        this.value = value;
    }

    public ConfigRow(String application, String key, String value,
                     LocalDateTime validFrom, LocalDateTime validUntil) {
        this.application = application;
        this.key = key;
        this.value = value;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }
}
