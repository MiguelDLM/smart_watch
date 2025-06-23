package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.recg.RecognitionResult;

/* loaded from: classes7.dex */
public class ha {
    private static final String TAG = "ha";
    private static volatile ha vM;
    private gv vI = gv.eQ();
    private gz vJ;
    private HandlerThread vK;
    private Handler vL;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    ha.this.a((he) message.obj);
                    break;
                case 1002:
                    ha.this.b((hc) message.obj);
                    break;
                case 1003:
                    ha.this.U();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private ha() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        gv gvVar = this.vI;
        boolean release = gvVar != null ? gvVar.release() : false;
        kf.c(TAG, "handleRelease result = " + release);
        gz gzVar = this.vJ;
        if (gzVar != null) {
            gzVar.onRelease(release);
            this.vJ = null;
        }
        HandlerThread handlerThread = this.vK;
        if (handlerThread != null) {
            handlerThread.quit();
            this.vK = null;
        }
        this.vL = null;
        releaseInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(hc hcVar) {
        hd hdVar;
        gv gvVar = this.vI;
        if (gvVar == null || hcVar == null) {
            hdVar = null;
        } else {
            RecognitionResult a2 = gvVar.a(hcVar.getData(), hcVar.getWidth(), hcVar.getHeight());
            hdVar = new hd(hcVar.getTimestamp());
            hdVar.setFileName(a2.fileName);
            hdVar.D(a2.errCode == 1);
            hdVar.C(a2.errCode == 1);
            hdVar.f(a2.time);
            hdVar.setTimestamp(hcVar.getTimestamp());
        }
        gz gzVar = this.vJ;
        if (gzVar == null || hdVar == null) {
            return;
        }
        gzVar.a(hdVar);
    }

    public static synchronized ha eS() {
        ha haVar;
        synchronized (ha.class) {
            try {
                if (vM == null) {
                    vM = new ha();
                }
                haVar = vM;
            } catch (Throwable th) {
                throw th;
            }
        }
        return haVar;
    }

    private void eT() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.vK = handlerThread;
        handlerThread.start();
        this.vL = new a(this.vK.getLooper());
    }

    private static void releaseInstance() {
        vM = null;
    }

    public void release() {
        Handler handler = this.vL;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003));
        } else {
            kf.b(TAG, "track mRecgHandler is NULLLL!!!");
        }
    }

    public void a(hc hcVar) {
        Handler handler = this.vL;
        if (handler == null) {
            kf.b(TAG, "track mRecgHandler is NULLLL!!!");
            return;
        }
        handler.removeMessages(1002);
        Handler handler2 = this.vL;
        handler2.sendMessage(handler2.obtainMessage(1002, hcVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(he heVar) {
        boolean init = this.vI.init(heVar.eV());
        kf.c(TAG, "handleSetup result = " + init);
        gz gzVar = this.vJ;
        if (gzVar != null) {
            gzVar.onSetup(init);
        }
    }

    public void a(he heVar, gz gzVar) {
        if (heVar == null) {
            kf.b(TAG, "setup RecgParams is NULLLL!!!");
            return;
        }
        this.vJ = gzVar;
        eT();
        Handler handler = this.vL;
        handler.sendMessage(handler.obtainMessage(1001, heVar));
    }
}
