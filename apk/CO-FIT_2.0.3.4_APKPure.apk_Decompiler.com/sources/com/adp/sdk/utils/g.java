package com.adp.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static OkHttpClient f742a;

    public static class a implements CookieJar {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, List<Cookie>> f743a = new HashMap<>();

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = this.f743a.get(httpUrl.host());
            if (list != null) {
                return list;
            }
            return new ArrayList();
        }

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            this.f743a.put(httpUrl.host(), list);
        }
    }

    public static class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f744a;

        public b(f fVar) {
            this.f744a = fVar;
        }

        public void onFailure(Call call, IOException iOException) {
            this.f744a.a(call, (Exception) iOException);
        }

        public void onResponse(Call call, Response response) throws IOException {
            try {
                this.f744a.a(call, response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
                this.f744a.a(call, e);
            }
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f742a = builder.connectTimeout(20, timeUnit).readTimeout(30, timeUnit).cookieJar(new a()).build();
    }

    public static void a(String str, Map<String, String> map, f fVar) {
        f742a.newCall(new Request.Builder().url(str).get().build()).enqueue(new b(fVar));
    }
}
