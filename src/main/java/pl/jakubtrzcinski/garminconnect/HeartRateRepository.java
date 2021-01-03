package pl.jakubtrzcinski.garminconnect;

import com.garmin.xmlschemas.trainingcenterdatabase.v2.TrainingCenterDatabaseT;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;
import me.himanshusoni.gpxparser.GPXParser;
import me.himanshusoni.gpxparser.modal.GPX;
import okhttp3.Request;
import pl.jakubtrzcinski.garminconnect.dto.Activity;
import pl.jakubtrzcinski.garminconnect.dto.HeartRateDay;
import pl.jakubtrzcinski.garminconnect.exception.ActivityNotFoundGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.RateLimitGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.SessionExpiredGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.UnknownGarminConnectException;
import pl.jakubtrzcinski.garminconnect.token.TokenSupplier;
import pl.jakubtrzcinski.gson.LocalDateAdapter;
import pl.jakubtrzcinski.gson.LocalDateTimeAdapter;
import pl.jakubtrzcinski.tcxparser.TcxParser;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
class HeartRateRepository extends BaseRepository {
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public HeartRateRepository(TokenSupplier tokenSupplier) {
        super(tokenSupplier);

    }

    /**
     * @throws SessionExpiredGarminConnectException if token is expired
     * @throws RateLimitGarminConnectException if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public HeartRateDay getHeartRate(LocalDate date) {
        Request request = get("https://connect.garmin.com/modern/proxy/wellness-service/wellness/dailyHeartRate?date=" + date.toString());

        var rawJson = send(request);

        return gson.fromJson(rawJson.getRawResponse(), HeartRateDay.class);
    }
}
