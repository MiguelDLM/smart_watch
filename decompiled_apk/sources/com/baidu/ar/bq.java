package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.VolumeListener;

/* loaded from: classes7.dex */
public class bq {
    private static final String TAG = "bq";
    private static volatile bq kH;
    private br kE;
    private HandlerThread kF;
    private Handler kG;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    bq.this.a((AudioParams) message.obj);
                    return;
                case 1002:
                    bq.this.bY();
                    return;
                case 1003:
                    bq.this.bZ();
                    return;
                case 1004:
                    bq.this.ca();
                    return;
                case 1005:
                    bq.this.cb();
                    return;
                default:
                    return;
            }
        }
    }

    private bq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioParams audioParams) {
        br brVar = this.kE;
        if (brVar != null) {
            brVar.b(audioParams);
        }
    }

    public static bq bT() {
        if (kH == null) {
            synchronized (bq.class) {
                try {
                    if (kH == null) {
                        kH = new bq();
                    }
                } finally {
                }
            }
        }
        return kH;
    }

    private void bU() {
        HandlerThread handlerThread = new HandlerThread("AudioHandlerThread");
        this.kF = handlerThread;
        handlerThread.start();
        this.kG = new a(this.kF.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY() {
        br brVar = this.kE;
        if (brVar != null) {
            brVar.cc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ() {
        br brVar = this.kE;
        if (brVar != null) {
            brVar.cd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        br brVar = this.kE;
        if (brVar != null) {
            brVar.ce();
        }
        this.kE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        releaseInstance();
        Handler handler = this.kG;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.kG = null;
        }
        HandlerThread handlerThread = this.kF;
        if (handlerThread != null) {
            handlerThread.quit();
            this.kF = null;
        }
    }

    private static void releaseInstance() {
        kH = null;
    }

    public void bV() {
        bZ();
    }

    public void bW() {
        Handler handler = this.kG;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.kG;
            handler2.sendMessage(handler2.obtainMessage(1004));
            Handler handler3 = this.kG;
            handler3.sendMessage(handler3.obtainMessage(1005));
        }
    }

    public AudioParams bX() {
        br brVar = this.kE;
        if (brVar != null) {
            return brVar.bX();
        }
        return null;
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.kF;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.kE == null) {
                this.kE = new br();
            }
            this.kE.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        Handler handler = this.kG;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public boolean a(AudioParams audioParams, bp bpVar) {
        if (isRunning()) {
            kf.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.kE == null) {
            this.kE = new br();
        }
        this.kE.a(bpVar);
        bU();
        Handler handler = this.kG;
        handler.sendMessage(handler.obtainMessage(1001, audioParams));
        return true;
    }
}
