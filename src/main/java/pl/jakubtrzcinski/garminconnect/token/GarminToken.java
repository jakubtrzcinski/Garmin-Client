package pl.jakubtrzcinski.garminconnect.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@ToString
@Getter
@AllArgsConstructor
public class GarminToken {
    private final String sessionId;
    private final String ssoGuid;
}
