package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes8.dex */
public class g {
    private static final String d = "com.baidu.navisdk.util.statistic.g";
    private static g e = null;
    private static boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    private long f9372a = 0;
    private StringBuffer b = new StringBuffer();
    private Bundle c = null;

    private g() {
        e();
    }

    public static g d() {
        if (e == null) {
            e = new g();
        }
        return e;
    }

    private void e() {
        this.f9372a = 0L;
        this.c = null;
    }

    public void a() {
        StringBuffer stringBuffer;
        if (f && (stringBuffer = this.b) != null && stringBuffer.length() > 0) {
            this.c = new Bundle();
            LogUtil.e(d, "end():" + this.b.toString());
            JNIStatisticsControl.sInstance.getStatisticsResult(this.b.toString(), this.c);
            this.f9372a = 0L;
        }
    }

    public String b() {
        StringBuffer stringBuffer;
        Bundle bundle;
        if (!f || (stringBuffer = this.b) == null || stringBuffer.length() <= 0 || (bundle = this.c) == null || !bundle.containsKey("part_statics")) {
            return null;
        }
        String str = d;
        LogUtil.e(str, "getGuideStatString() PART_STATICS_KEY:" + this.c.getString("part_statics"));
        LogUtil.e(str, "getGuideStatString() ALL_STATICS_KEY:" + this.c.getString("all_statics"));
        return this.c.getString("all_statics");
    }

    public void c() {
        if (this.f9372a <= 0) {
            this.f9372a = SystemClock.elapsedRealtime();
        }
    }

    public void a(String str, String str2) {
        if (f) {
            long j = 0;
            if (this.f9372a <= 0) {
                this.f9372a = SystemClock.elapsedRealtime();
            } else {
                j = 1 + ((SystemClock.elapsedRealtime() - this.f9372a) / 1000);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            stringBuffer.append(String.valueOf(j));
            if (str2 != null) {
                stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuffer.append(str2);
            }
            if (this.b.length() >= 1) {
                this.b.append(":");
            }
            this.b.append(stringBuffer.toString());
            LogUtil.e(d, "add:" + stringBuffer.toString());
        }
    }
}
