package pl.jakubtrzcinski.garminconnect;

import lombok.RequiredArgsConstructor;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
@RequiredArgsConstructor
class HardcodedCookieJar implements CookieJar {

    private final Map<String, String> cookies;

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookies.keySet().stream().map(key->{
            return new Cookie.Builder().name(key).value(cookies.get(key)).domain("garmin.com").build();
        }).collect(Collectors.toUnmodifiableList());
    }
}
