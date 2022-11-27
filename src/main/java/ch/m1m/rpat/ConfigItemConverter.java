package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigRow;

public class ConfigItemConverter {

    public static ConfigItem of(ConfigRow row) {
        return new ConfigItem(
                row.getApplication(),
                row.getKey(),
                row.getValue(),
                row.getValidFrom(),
                row.getValidUntil());
    }
}
