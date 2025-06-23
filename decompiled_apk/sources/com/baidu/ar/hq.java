package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hq {
    private static final String TAG = "hq";
    private volatile boolean wF = false;
    private hv wS;
    private HandlerThread xg;
    private Handler xh;
    private hs xi;

    /* loaded from: classes7.dex */
    public class a {
        ByteBuffer xj;
        int xk;
        long xl;

        public a(ByteBuffer byteBuffer, int i, long j) {
            this.xj = byteBuffer;
            this.xk = i;
            this.xl = j;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    hq.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    hq.this.fy();
                    return;
                case 1003:
                    a aVar = (a) message.obj;
                    hq.this.b(aVar.xj, aVar.xk, aVar.xl);
                    return;
                case 1004:
                    hq.this.fz();
                    return;
                case 1005:
                    hq.this.fA();
                    return;
                case 1006:
                    hq.this.fB();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA() {
        this.xi.fG();
        this.xi.fF();
        this.xi = null;
        this.wS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        Handler handler = this.xh;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.xh = null;
        }
        HandlerThread handlerThread = this.xg;
        if (handlerThread != null) {
            handlerThread.quit();
            this.xg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy() {
        this.xi.fH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz() {
        this.xi.a(true, (ByteBuffer) null, 0, 0L);
    }

    public void fx() {
        Handler handler = this.xh;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.xh;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.xh;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.xg;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void startRecording() {
        Handler handler = this.xh;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.xh == null || !this.wF) {
            return;
        }
        this.wF = false;
        Handler handler = this.xh;
        handler.sendMessage(handler.obtainMessage(1004));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i, long j) {
        this.xi.a(false, byteBuffer, i, j);
    }

    private void a(hv hvVar, hu huVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.xg = handlerThread;
        handlerThread.start();
        this.xh = new b(this.xg.getLooper());
        hs hsVar = new hs();
        this.xi = hsVar;
        this.wS = hvVar;
        hsVar.a(huVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        this.xi.a(encoderParams, this.wS);
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        a aVar = new a(byteBuffer, i, j);
        if (this.xh == null || !this.wF) {
            return;
        }
        Handler handler = this.xh;
        handler.sendMessage(handler.obtainMessage(1003, aVar));
    }

    public boolean a(EncoderParams encoderParams, hv hvVar, hu huVar) {
        if (isRunning()) {
            kf.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(hvVar, huVar);
        Handler handler = this.xh;
        handler.sendMessage(handler.obtainMessage(1001, encoderParams));
        this.wF = true;
        return true;
    }
}
