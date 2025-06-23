package com.sma.androidnetworklib;

import OXOo.OOXIXo;
import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.sma.androidnetworklib.HttpLoggingInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import okhttp3.OkHttpClient;

/* loaded from: classes11.dex */
public final class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static OkHttpClient f19696II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f19697oIX0oI = new oIX0oI();

    public static /* synthetic */ void I0Io(oIX0oI oix0oi, Application application, boolean z, HttpLoggingInterceptor.Level level, HttpLoggingInterceptor.oIX0oI DEFAULT, int i, Object obj) {
        if ((i & 8) != 0) {
            DEFAULT = HttpLoggingInterceptor.oIX0oI.f19681oIX0oI;
            IIX0o.oO(DEFAULT, "DEFAULT");
        }
        oix0oi.II0xO0(application, z, level, DEFAULT);
    }

    public final void II0xO0(@OOXIXo Application app, boolean z, @OOXIXo HttpLoggingInterceptor.Level level, @OOXIXo HttpLoggingInterceptor.oIX0oI logger) {
        IIX0o.x0xO0oo(app, "app");
        IIX0o.x0xO0oo(level, "level");
        IIX0o.x0xO0oo(logger, "logger");
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder writeTimeout = newBuilder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit);
        if (z) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
            httpLoggingInterceptor.X0o0xo(level);
            writeTimeout.addInterceptor(httpLoggingInterceptor);
        }
        oxoX(writeTimeout.build());
        AndroidNetworking.initialize(app, oIX0oI());
    }

    @OOXIXo
    public final OkHttpClient oIX0oI() {
        OkHttpClient okHttpClient = f19696II0xO0;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        IIX0o.XOxIOxOx("okHttpClient");
        return null;
    }

    public final void oxoX(@OOXIXo OkHttpClient okHttpClient) {
        IIX0o.x0xO0oo(okHttpClient, "<set-?>");
        f19696II0xO0 = okHttpClient;
    }
}
