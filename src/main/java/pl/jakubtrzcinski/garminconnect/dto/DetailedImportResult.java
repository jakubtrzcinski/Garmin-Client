package pl.jakubtrzcinski.garminconnect.dto;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.List;

@Getter
public class DetailedImportResult {
    private Integer uploadId;
    @Delegate
    private UploadUuid uploadUuid;
    private Integer owner;
    private Integer fileSize;
    private Integer processingTime;
    private String creationDate;
    private Object ipAddress;
    private String fileName;
    private Object report;
    private List<Success> successes;
    private List<Object> failures ;

}
