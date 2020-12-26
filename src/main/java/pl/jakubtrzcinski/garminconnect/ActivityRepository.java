package pl.jakubtrzcinski.garminconnect;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import pl.jakubtrzcinski.garminconnect.dto.Activity;
import pl.jakubtrzcinski.garminconnect.token.TokenSupplier;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
class ActivityRepository {

    private final Gson gson = new Gson();
    private final TokenSupplier tokenSupplier;
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();



    @SneakyThrows
    public List<Activity> getActivities(int limit, int start) {
        var token = tokenSupplier.get();
        Request request = new Request.Builder()
                .url("https://connect.garmin.com/modern/proxy/activitylist-service/activities/search/activities?limit="+limit+"&start="+start)
                .header("cookie", "__cflb=a;GARMIN-SSO-GUID="+token.getSsoGuid()+";SESSIONID="+token.getSessionId()+";")
                .build();

        var rawJson = client.newCall(request).execute().body().string();

        return asList(gson.fromJson(rawJson, Activity[].class));
    }

    @SneakyThrows
    public String getRawTcx(long activityId) {
        var token = tokenSupplier.get();
        Request request = new Request.Builder()
                .url("https://connect.garmin.com/modern/proxy/download-service/export/tcx/activity/"+activityId)
                .header("cookie", "__cflb=a;GARMIN-SSO-GUID="+token.getSsoGuid()+";SESSIONID="+token.getSessionId()+";")
                .build();

        return client.newCall(request).execute().body().string();
    }

    @SneakyThrows
    public String getRawGpx(long activityId) {
        var token = tokenSupplier.get();
        Request request = new Request.Builder()
                .url("https://connect.garmin.com/modern/proxy/download-service/export/gpx/activity/"+activityId)
                .header("cookie", "__cflb=a;GARMIN-SSO-GUID="+token.getSsoGuid()+";SESSIONID="+token.getSessionId()+";")
                .build();

        return client.newCall(request).execute().body().string();
    }
}
