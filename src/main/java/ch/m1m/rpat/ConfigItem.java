package ch.m1m.rpat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfigItem {

    private String key;
    private String value;

    public ConfigItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
