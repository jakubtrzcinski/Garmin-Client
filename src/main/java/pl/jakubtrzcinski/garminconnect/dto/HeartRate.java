package pl.jakubtrzcinski.garminconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 03-01-2021
 */
class HeartRate {
    @Getter
    private long timestamp;
    @Getter
    private short value;

    private LocalDateTime cachedDateTime;

    public HeartRate(long timestamp, short value) {
        this.timestamp = timestamp;
        this.value = value;
    }


    public LocalDateTime getDate() {
        if(cachedDateTime == null) {
            cachedDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        }
        return cachedDateTime;
    }
}
