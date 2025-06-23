package com.baidu.vi;

import android.annotation.SuppressLint;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* loaded from: classes8.dex */
public class VCompass {

    @SuppressLint({"HandlerLeak"})
    private static final Handler e = new c();
    private float b;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f10213a = null;
    private float c = 2.0f;
    private int d = 0;
    private SensorEventListener f = new d(this);

    private float a(float f, float f2, float f3) {
        float f4 = f - f2;
        return (f4 > 180.0f || f4 < -180.0f) ? f2 : (f4 < (-f3) || f3 < f4) ? (f + f2) / 2.0f : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void updateCompass(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f) {
        float a2 = a(this.b, f, this.c);
        this.b = a2;
        return a2;
    }
}
