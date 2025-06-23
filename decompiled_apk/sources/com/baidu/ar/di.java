package com.baidu.ar;

import android.os.Handler;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;

/* loaded from: classes7.dex */
public abstract class di extends db implements PixelReadListener {

    /* renamed from: oX, reason: collision with root package name */
    private static volatile boolean f5569oX = true;
    private boolean ap = false;
    private Handler mHandler;
    protected PixelReadParams oW;

    public static void t(boolean z) {
        f5569oX = z;
    }

    public final void a(Handler handler) {
        this.mHandler = handler;
    }

    public abstract boolean a(FramePixels framePixels);

    public abstract void cB();

    public abstract void cC();

    public boolean cR() {
        return true;
    }

    public PixelReadParams cT() {
        return this.oW;
    }

    public boolean cU() {
        return this.ap;
    }

    @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
    public boolean onPixelRead(final FramePixels framePixels) {
        if (this.ap && !f5569oX) {
            return false;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.di.1
                @Override // java.lang.Runnable
                public void run() {
                    di.this.a(framePixels);
                }
            });
            return true;
        }
        a(framePixels);
        return true;
    }

    @Override // com.baidu.ar.db, com.baidu.ar.dj
    public final void release() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        cC();
        super.release();
    }

    public void s(boolean z) {
        this.ap = z;
    }

    @Override // com.baidu.ar.db, com.baidu.ar.dj
    public final void a(df dfVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("setup callback is ");
        sb.append(dfVar != null);
        kf.c("FrameDetector", sb.toString());
        super.a(dfVar);
        cB();
    }
}
