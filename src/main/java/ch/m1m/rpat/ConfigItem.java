package ch.m1m.rpat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConfigItem {

    private String application;

    private String key;

    private String value;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    public ConfigItem(String application, String key, String value) {
        this.application = application;
        this.key = key;
        this.value = value;
    }

    public ConfigItem(String application, String key, String value,
                      LocalDateTime validFrom, LocalDateTime validUntil) {
        this.application = application;
        this.key = key;
        this.value = value;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }
}
