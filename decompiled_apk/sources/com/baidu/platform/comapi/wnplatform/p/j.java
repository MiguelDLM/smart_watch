package com.baidu.platform.comapi.wnplatform.p;

import android.annotation.SuppressLint;
import android.os.Vibrator;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Vibrator f9960a;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static j f9961a = new j();
    }

    public static j a() {
        return a.f9961a;
    }

    @SuppressLint({"NewApi"})
    private boolean c() {
        Vibrator vibrator = this.f9960a;
        if (vibrator == null || !vibrator.hasVibrator()) {
            return false;
        }
        return true;
    }

    public void b() {
        Vibrator vibrator;
        try {
            this.f9960a = (Vibrator) com.baidu.platform.comapi.wnplatform.p.b.a.a().getSystemService("vibrator");
            if (c() && (vibrator = this.f9960a) != null) {
                vibrator.vibrate(500L);
            }
        } catch (Exception unused) {
        }
    }

    private j() {
    }
}
