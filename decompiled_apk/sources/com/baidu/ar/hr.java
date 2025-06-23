package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.record.EncoderParams;
import com.szabh.smable3.entity.BleWatchFaceId;

/* loaded from: classes7.dex */
public class hr {
    private static final String TAG = "hr";
    private volatile boolean wF = false;
    private hv wS;
    private HandlerThread xn;

    /* renamed from: xo, reason: collision with root package name */
    private Handler f5571xo;
    private hx xp;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    hr.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    hr.this.fy();
                    return;
                case 1003:
                    hr.this.k((message.arg1 << 32) | (message.arg2 & BleWatchFaceId.WATCHFACE_ID_INVALID));
                    return;
                case 1004:
                    hr.this.fC();
                    return;
                case 1005:
                    hr.this.fD();
                    return;
                case 1006:
                    hr.this.cb();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        Handler handler = this.f5571xo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f5571xo = null;
        }
        HandlerThread handlerThread = this.xn;
        if (handlerThread != null) {
            handlerThread.quit();
            this.xn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC() {
        this.xp.N(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        this.xp.fG();
        this.xp.fF();
        this.xp = null;
        this.wS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy() {
        this.xp.fH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        this.xp.N(false);
    }

    public void fx() {
        Handler handler = this.f5571xo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f5571xo;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f5571xo;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.xn;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void j(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.f5571xo == null || !this.wF) {
            return;
        }
        Handler handler = this.f5571xo;
        handler.sendMessage(handler.obtainMessage(1003, i, i2));
    }

    public void startRecording() {
        Handler handler = this.f5571xo;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.f5571xo == null || !this.wF) {
            return;
        }
        this.wF = false;
        Handler handler = this.f5571xo;
        handler.sendMessage(handler.obtainMessage(1004));
    }

    private void a(hv hvVar, hu huVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.xn = handlerThread;
        handlerThread.start();
        this.f5571xo = new a(this.xn.getLooper());
        hx hxVar = new hx();
        this.xp = hxVar;
        hxVar.a(huVar);
        this.wS = hvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        this.xp.a(encoderParams, this.wS);
    }

    public boolean a(EncoderParams encoderParams, hv hvVar, hu huVar) {
        if (isRunning()) {
            kf.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(hvVar, huVar);
        Handler handler = this.f5571xo;
        handler.sendMessage(handler.obtainMessage(1001, encoderParams));
        this.wF = true;
        return true;
    }
}
