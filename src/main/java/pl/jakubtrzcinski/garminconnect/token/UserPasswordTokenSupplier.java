package pl.jakubtrzcinski.garminconnect.token;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.*;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
public class UserPasswordTokenSupplier implements TokenSupplier {
    private final String baseUrl = "https://connect.garmin.com";

    private final PersistentCookieJar cookies = new PersistentCookieJar();

    private final OkHttpClient client = new OkHttpClient().newBuilder()
            .cookieJar(cookies)
            .build();

    private final String login;

    private final String password;


    @Override
    @SneakyThrows
    public GarminToken get() {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("username", login)
                .addFormDataPart("password", password)
                .addFormDataPart("_eventId", "submit")
                .addFormDataPart("embed", "true")
                .build();
        Request request = new Request.Builder()
                .url("https://sso.garmin.com/sso/signin?service=https://connect.garmin.com/modern&clientId=GarminConnect&gauthHost=https://sso.garmin.com/sso&consumeServiceTicket=false")
                .header("origin", "https://sso.garmin.com")
                .method("POST", body)
                .build();
        client.newCall(request).execute();


        var redeemResponse = client.newCall(new Request.Builder()
                .url(baseUrl+"/modern")
                .get()
                .build()).execute().networkResponse();

        //https://github.com/cpfair/tapiriik/blob/master/tapiriik/services/GarminConnect/garminconnect.py#L253
        int maxRedirectCount = 7;
        int currentRedirectCount = 1;

        while (true) {
            var url = redeemResponse.header("location");
            if(url == null){
                break;
            }
            if(url.startsWith("/")) {
                url = baseUrl + url;
            }
            redeemResponse = client.newCall(new Request.Builder()
                    .url(url).get()
                    .build()
            ).execute().networkResponse();
            if(redeemResponse.isSuccessful()){
                break;
            }
            currentRedirectCount++;
            if(currentRedirectCount > maxRedirectCount) {
                break;
            }
        }

        return new GarminToken(
            cookies.getCookies().stream().filter(e->e.name().equals("SESSIONID")).findFirst().get().value(),
            cookies.getCookies().stream().filter(e->e.name().equals("GARMIN-SSO-GUID")).findFirst().get().value()
        );
    }
}
