package pl.jakubtrzcinski.garminconnect.dto;

import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 03-01-2021
 */
@Getter
public
class HeartRateDay {
    private long userProfilePK;
    private LocalDate calendarDate;
    private LocalDateTime startTimestampGMT;
    private LocalDateTime endTimestampGMT;
    private LocalDateTime startTimestampLocal;
    private LocalDateTime endTimestampLocal;
    private short maxHeartRate;
    private short minHeartRate;
    private short restingHeartRate;
    private short lastSevenDaysAvgRestingHeartRate;
    private List<ValueDescriptor> heartRateValueDescriptors;
    private List<List<Long>> heartRateValues;

    public List<HeartRate> getHeartRate(){
        final var timestampIndex = heartRateValueDescriptors.stream().filter(e->e.getKey().equals("timestamp")).findFirst().map(ValueDescriptor::getIndex).get();
        final var heartRateIndex = heartRateValueDescriptors.stream().filter(e->e.getKey().equals("heartrate")).map(ValueDescriptor::getIndex).findFirst().get();
        return heartRateValues.stream().map(e->{
            return new HeartRate(e.get(timestampIndex), (short)e.get(heartRateIndex).intValue());
        }).collect(Collectors.toUnmodifiableList());
    }

    @Getter
    static class ValueDescriptor {
        private String key;
        private int index;
    }
}
