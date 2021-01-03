package pl.jakubtrzcinski.garminconnect;

import com.garmin.xmlschemas.trainingcenterdatabase.v2.TrainingCenterDatabaseT;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.himanshusoni.gpxparser.GPXParser;
import me.himanshusoni.gpxparser.modal.GPX;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import pl.jakubtrzcinski.garminconnect.dto.Activity;
import pl.jakubtrzcinski.garminconnect.exception.ActivityNotFoundGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.RateLimitGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.SessionExpiredGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.UnknownGarminConnectException;
import pl.jakubtrzcinski.garminconnect.token.TokenSupplier;
import pl.jakubtrzcinski.tcxparser.TcxParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
class BaseRepository {
    private final Gson gson = new Gson();
    private final TokenSupplier tokenSupplier;
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();


    protected Request get(String url){
        var token = tokenSupplier.get();
        return new Request.Builder()
                .url(url)
                .header("cookie", "__cflb=a;GARMIN-SSO-GUID=" + token.getSsoGuid() + ";SESSIONID=" + token.getSessionId() + ";")
                .build();

    }

    protected ApiResponse send(Request request) {
        try {
            var response = client.newCall(request).execute();
            var body = response.body();
            if (response.code() == 401 || response.code() == 403) {
                throw new SessionExpiredGarminConnectException();
            }
            if(response.code() == 429) {
                throw new RateLimitGarminConnectException();
            }
            return new ApiResponse(
                    response.code(),
                    body.string()
            );

        } catch (IOException ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    @Getter
    @RequiredArgsConstructor
    protected static class ApiResponse {
        private final int statuscode;
        private final String rawResponse;
    }
}
