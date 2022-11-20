package ch.m1m.rpat.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
@Getter
@Setter
@NoArgsConstructor
public class ConfigRow {

    @Id
    private String key;
    private String value;

    public ConfigRow(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
