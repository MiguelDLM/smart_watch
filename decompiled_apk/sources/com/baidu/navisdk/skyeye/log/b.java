package com.baidu.navisdk.skyeye.log;

import androidx.annotation.NonNull;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f8006a = 3;
    public int b = 10;
    public int c = 10;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    public String[] g = null;
    public int h = -1;
    public int i = 2;
    public boolean j = false;
    public int k = 0;
    public int l = 0;
    public String m = null;
    public String n = null;

    public void a(JSONObject jSONObject) {
        this.f8006a = jSONObject.optInt("ntype", 3);
        this.b = jSONObject.optInt("rpsize_wifi", 10);
        this.c = jSONObject.optInt("rpsize_mobile", 10);
        this.d = jSONObject.optInt("start_t", -1);
        this.e = jSONObject.optInt("end_t", -1);
        this.f = jSONObject.optInt("recent_t", -1);
        this.h = jSONObject.optInt("times_max", 3);
        this.j = jSONObject.optInt("need_fatal", 0) == 1;
        this.k = jSONObject.optInt("enter_pages", 0);
        this.l = jSONObject.optInt("exit_pages", 0);
        this.m = jSONObject.optString("other_event", null);
        this.n = jSONObject.optString("fatal_event", null);
        this.i = jSONObject.optInt("log_type", 2);
        JSONArray optJSONArray = jSONObject.optJSONArray("files");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        if (length > 0) {
            this.g = new String[length];
            for (int i = 0; i < length; i++) {
                this.g[i] = optJSONArray.optString(i);
            }
        }
    }

    public long b() {
        long j;
        if (this.f > 0) {
            j = Math.max((System.currentTimeMillis() / 1000) - this.f, this.d);
        } else {
            j = this.d;
        }
        return j * 1000;
    }

    @NonNull
    public String toString() {
        return "mNetType" + this.f8006a + "mMaxSizeWifi" + this.b + "mMaxSizeMobile" + this.c + "mDefineStartTime" + this.d + "mDefineEndTime" + this.e + "mRecentTime" + this.f + "mDefineFiles" + Arrays.toString(this.g) + "mAutoUploadTimesMax" + this.h + "mAutoUploadNeedFatal" + this.j + "mObserverEnterPages" + this.k + "mObserverExitPages" + this.l + "mObserverOtherEvent" + this.m + "mObserverFatalEvent" + this.n;
    }

    public long a() {
        return this.e * 1000;
    }
}
