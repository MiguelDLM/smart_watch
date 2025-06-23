package com.baidu.ar;

import com.baidu.ar.algotrack2d.AR2DJniClient;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class jr {
    private static final String TAG = "jr";
    private jt Bm;
    private float[][] Bo;
    private jw Bq;
    private boolean Bn = false;
    private long Bp = 0;

    private float a(int i, int i2, float f) {
        if (Float.isNaN(f)) {
            return f;
        }
        return (f * 500.0f) / ((float) Math.sqrt((i * i) + (i2 * i2)));
    }

    private float[] m(int i, int i2) {
        float f = i;
        float f2 = f / 2.0f;
        float f3 = (f * 600.0f) / 640.0f;
        return new float[]{f3, 0.0f, f2, 0.0f, f3, i2 / 2.0f, 0.0f, 0.0f, 1.0f};
    }

    public void release() {
        if (this.Bn) {
            AR2DJniClient.arRelease();
            this.Bn = false;
        }
        jw jwVar = this.Bq;
        if (jwVar != null) {
            jwVar.reset();
        }
    }

    private float a(boolean z, float[] fArr) {
        if (!z || fArr == null) {
            return Float.NaN;
        }
        float f = fArr[9];
        float f2 = fArr[10];
        float f3 = fArr[11];
        return a(this.Bm.getTargetWidth(), this.Bm.getTargetHeight(), (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
    }

    public void a(FramePixels framePixels, ICallbackWith<ju> iCallbackWith) {
        jt jtVar;
        if (framePixels == null || !this.Bn || (jtVar = this.Bm) == null) {
            return;
        }
        float[] fArr = this.Bo[(int) (this.Bp % jtVar.getCacheSize())];
        this.Bp = r0 + 1;
        ByteBuffer pixelsAddress = framePixels.getPixelsAddress();
        long currentTimeMillis = System.currentTimeMillis();
        int arTracking = AR2DJniClient.arTracking(pixelsAddress, fArr);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        boolean z = arTracking == 1;
        int[] iArr = new int[2];
        if (AR2DJniClient.arGetMarkerSize(iArr)) {
            this.Bm.setTargetWidth(iArr[0]);
            this.Bm.setTargetHeight(iArr[1]);
        } else {
            kf.c(TAG, "arGetMarkerSize fail");
        }
        float a2 = a(z, fArr);
        js jsVar = new js();
        jsVar.C(z);
        jsVar.setMatrix(fArr);
        jsVar.D(z);
        jsVar.T(this.Bq.X(z));
        jsVar.U(this.Bq.gC());
        jsVar.V(this.Bq.gD());
        jsVar.d(a2);
        jsVar.f(currentTimeMillis2);
        jsVar.setTimestamp(framePixels.getTimestamp());
        if (iCallbackWith != null) {
            iCallbackWith.run(new ju(jsVar));
        }
    }

    public void a(jt jtVar) {
        try {
            fn.require("dumixar");
            this.Bm = jtVar;
            boolean z = AR2DJniClient.arInit(jtVar.gz(), jtVar.gA(), m(jtVar.gz(), jtVar.gA()), jtVar.gp()) == 1;
            this.Bn = z;
            if (z) {
                this.Bo = (float[][]) Array.newInstance((Class<?>) Float.TYPE, jtVar.getCacheSize(), 12);
            } else {
                AR2DJniClient.arRelease();
            }
            this.Bq = new jw();
        } catch (UnsatisfiedLinkError e) {
            kf.b(TAG, "track2d algo UnsatisfiedLinkError " + e.getMessage());
        }
    }
}
