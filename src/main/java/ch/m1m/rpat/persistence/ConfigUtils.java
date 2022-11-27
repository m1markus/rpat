package ch.m1m.rpat.persistence;

import java.time.LocalDateTime;

public class ConfigUtils {

    public static LocalDateTime getMaxTimestamp() {
        return LocalDateTime.of(9999, 12, 31, 23, 59, 59);
    }
}
