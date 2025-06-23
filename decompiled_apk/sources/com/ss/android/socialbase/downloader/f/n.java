package com.ss.android.socialbase.downloader.f;

import XIXIX.OOXIXo;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f26298a;
    private int b;

    private n(JSONObject jSONObject) {
        this.f26298a = jSONObject;
    }

    private int p() {
        return this.f26298a.optInt("url_balance", 2);
    }

    public void a(int i) {
        this.b = b(i);
    }

    public boolean b() {
        return p() > 0;
    }

    public boolean c() {
        if (p() == 1) {
            return true;
        }
        return false;
    }

    public int d() {
        return this.f26298a.optInt("buffer_count", 512);
    }

    public int e() {
        return this.f26298a.optInt("buffer_size", 8192);
    }

    public boolean f() {
        if (this.f26298a.optInt("segment_mode", 1) == 0) {
            return true;
        }
        return false;
    }

    public long g() {
        long optInt = this.f26298a.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public long h() {
        long optInt = this.f26298a.optInt("segment_min_init_mb", 10) * 1048576;
        if (optInt < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        }
        return optInt;
    }

    public long i() {
        long optInt = this.f26298a.optInt("segment_max_kb", 0) * 1048576;
        if (optInt < g()) {
            return -1L;
        }
        return optInt;
    }

    public long j() {
        long optInt = this.f26298a.optInt("connect_timeout", -1);
        if (optInt >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return optInt;
        }
        return -1L;
    }

    public long k() {
        long optInt = this.f26298a.optInt("read_timeout", -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1L;
    }

    public int l() {
        return this.f26298a.optInt("ip_strategy", 0);
    }

    public float m() {
        return (float) this.f26298a.optDouble("main_ratio", OOXIXo.f3760XO);
    }

    public int n() {
        return this.f26298a.optInt("ratio_segment", 0);
    }

    public float o() {
        return Math.min(Math.max(0.0f, (float) this.f26298a.optDouble("poor_speed_ratio", OOXIXo.f3760XO)), 1.0f);
    }

    private int b(int i) {
        int optInt = this.f26298a.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return p() == 1 ? Math.min(optInt, i) : optInt;
        }
        if (p() > 0) {
            return i;
        }
        return 1;
    }

    public int a() {
        return this.b;
    }

    @NonNull
    public static n a(@NonNull JSONObject jSONObject) {
        return new n(jSONObject);
    }
}
