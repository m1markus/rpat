package ch.m1m.rpat.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ConfigId implements Serializable {

    private String application;

    private String key;

    public ConfigId(String application, String key) {
        this.application = application;
        this.key = key;
    }
}




/*
    // equals() and hashCode()
 */