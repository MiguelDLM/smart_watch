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

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static OkHttpClient f4736a;

    /* loaded from: classes.dex */
    public static class a implements CookieJar {

        /* renamed from: a, reason: collision with root package name */
        private final HashMap<String, List<Cookie>> f4737a = new HashMap<>();

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = this.f4737a.get(httpUrl.host());
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            this.f4737a.put(httpUrl.host(), list);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f4738a;

        public b(f fVar) {
            this.f4738a = fVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f4738a.a(call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                this.f4738a.a(call, response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
                this.f4738a.a(call, e);
            }
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f4736a = builder.connectTimeout(20L, timeUnit).readTimeout(30L, timeUnit).cookieJar(new a()).build();
    }

    public static void a(String str, Map<String, String> map, f fVar) {
        f4736a.newCall(new Request.Builder().url(str).get().build()).enqueue(new b(fVar));
    }
}
