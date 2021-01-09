package pl.jakubtrzcinski.garminconnect;

import com.garmin.xmlschemas.trainingcenterdatabase.v2.TrainingCenterDatabaseT;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.himanshusoni.gpxparser.GPXParser;
import me.himanshusoni.gpxparser.GPXWriter;
import me.himanshusoni.gpxparser.modal.GPX;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import pl.jakubtrzcinski.garminconnect.dto.Activity;
import pl.jakubtrzcinski.garminconnect.dto.ActivityUploadResult;
import pl.jakubtrzcinski.garminconnect.exception.ActivityNotFoundGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.RateLimitGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.SessionExpiredGarminConnectException;
import pl.jakubtrzcinski.garminconnect.exception.UnknownGarminConnectException;
import pl.jakubtrzcinski.garminconnect.token.TokenSupplier;
import pl.jakubtrzcinski.tcxparser.TcxParser;
import pl.jakubtrzcinski.tcxparser.TcxWritter;

import java.io.*;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
class ActivityRepository extends BaseRepository {
    private final GPXParser gpxParser = new GPXParser();
    private final GPXWriter gpxWriter = new GPXWriter();
    private final TcxParser tcxParser = new TcxParser();
    private final TcxWritter tcxWritter = new TcxWritter();
    private final Gson gson = new Gson();

    public ActivityRepository(TokenSupplier tokenSupplier) {
        super(tokenSupplier);
    }


    /**
     * @throws SessionExpiredGarminConnectException   if token is expired
     * @throws ActivityNotFoundGarminConnectException if activity with given id is not found
     * @throws RateLimitGarminConnectException        if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException          if something wrong went :(
     */
    public List<Activity> getActivities(int limit, int start) {
        Request request = get("https://connect.garmin.com/modern/proxy/activitylist-service/activities/search/activities?limit=" + limit + "&start=" + start);

        var rawJson = send(request);

        return asList(gson.fromJson(rawJson.getRawResponse(), Activity[].class));
    }

    /**
     * @throws SessionExpiredGarminConnectException   if token is expired
     * @throws ActivityNotFoundGarminConnectException if activity with given id is not found
     * @throws RateLimitGarminConnectException        if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException          if something wrong went :(
     */
    public String getRawTcx(long activityId) {
        Request request = get("https://connect.garmin.com/modern/proxy/download-service/export/tcx/activity/" + activityId);

        var response = send(request);
        var body = response.getRawResponse();
        if (response.getStatuscode() == 404 || body == null) {
            throw new ActivityNotFoundGarminConnectException("Activity with id " + activityId + " not found");
        }
        return body;
    }

    /**
     * @throws SessionExpiredGarminConnectException   if token is expired
     * @throws ActivityNotFoundGarminConnectException if activity with given id is not found
     * @throws RateLimitGarminConnectException        if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException          if something wrong went :(
     */
    public String getRawGpx(long activityId) {
        Request request = get("https://connect.garmin.com/modern/proxy/download-service/export/gpx/activity/" + activityId);

        var response = send(request);
        var body = response.getRawResponse();
        if (response.getStatuscode() == 404 || body == null) {
            throw new ActivityNotFoundGarminConnectException("Activity with id " + activityId + " not found");
        }
        return body;
    }

    /**
     * @throws SessionExpiredGarminConnectException   if token is expired
     * @throws ActivityNotFoundGarminConnectException if activity with given id is not found
     * @throws RateLimitGarminConnectException        if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException          if something wrong went :(
     */
    public GPX getGpx(long activityId) {
        try {
            return gpxParser.parseGPX(new ByteArrayInputStream(getRawGpx(activityId).getBytes()));
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    /**
     * @throws SessionExpiredGarminConnectException   if token is expired
     * @throws ActivityNotFoundGarminConnectException if activity with given id is not found
     * @throws RateLimitGarminConnectException        if you're sending tooo much requests :)
     * @throws UnknownGarminConnectException          if something wrong went :(
     */
    public TrainingCenterDatabaseT getTcx(long activityId) {
        try {
            return tcxParser.parseTCX(new ByteArrayInputStream(getRawGpx(activityId).getBytes()));
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadTcx(String tcx) {
        return uploadTcx(tcx.getBytes());
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadGpx(String gpx) {
        return uploadGpx(gpx.getBytes());
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadTcx(byte[] tcx) {
        return uploadTcx(new ByteArrayInputStream(tcx));
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadGpx(byte[] gpx) {
        return uploadGpx(new ByteArrayInputStream(gpx));
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadGpx(GPX gpx) {
        try {
            var out = new ByteArrayOutputStream();
            gpxWriter.writeGPX(gpx, out);
            return uploadGpx(out.toByteArray());
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadTcx(TrainingCenterDatabaseT gpx) {
        try {
            var out = tcxWritter.writeToTCX(gpx);
            return uploadGpx(out.toByteArray());
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadTcx(InputStream tcx) {
        try {
            var request = this.uploadFile("https://connect.garmin.com/modern/proxy/upload-service/upload/.tcx", tcx);

            var response = send(request);
            return gson.fromJson(response.getRawResponse(), ActivityUploadResult.class);
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

    /**
     * @throws UnknownGarminConnectException if something wrong went :(
     */
    public ActivityUploadResult uploadGpx(InputStream gpx) {
        try {
            var request = this.uploadFile("https://connect.garmin.com/modern/proxy/upload-service/upload/.gpx", gpx);

            var response = send(request);
            return gson.fromJson(response.getRawResponse(), ActivityUploadResult.class);
        } catch (Exception ex) {
            throw new UnknownGarminConnectException(ex);
        }
    }

}
