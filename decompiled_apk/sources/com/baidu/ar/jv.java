package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.camera.CameraManager;

/* loaded from: classes7.dex */
public class jv extends di {
    private static final String TAG = "jv";
    private jt Bm;
    private a Bv;
    private jr Bw;
    private volatile boolean Bx = false;
    private HandlerThread vR;

    /* loaded from: classes7.dex */
    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(int i, Runnable runnable) {
            removeMessages(i);
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }

        public void release() {
            removeMessages(1001);
            removeMessages(1002);
            Thread.currentThread().interrupt();
        }
    }

    public jv(jt jtVar) {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.oW.setOutputHeight(CameraManager.DEFAULTHEIGHT);
        this.Bm = jtVar;
    }

    public void W(boolean z) {
        this.Bx = z;
    }

    @Override // com.baidu.ar.di
    public void cB() {
        if (this.Bm != null) {
            kf.c(TAG, "setupFrameDetector modelPath: " + this.Bm.gp());
        }
        this.Bw = new jr();
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.vR = handlerThread;
        handlerThread.start();
        a aVar = new a(this.vR.getLooper());
        this.Bv = aVar;
        aVar.a(1001, new Runnable() { // from class: com.baidu.ar.jv.1
            @Override // java.lang.Runnable
            public void run() {
                jv.this.Bw.a(jv.this.Bm);
            }
        });
    }

    @Override // com.baidu.ar.di
    public void cC() {
        a aVar = this.Bv;
        if (aVar != null) {
            aVar.release();
            this.Bv = null;
        }
        jr jrVar = this.Bw;
        if (jrVar != null) {
            jrVar.release();
            this.Bw = null;
        }
        HandlerThread handlerThread = this.vR;
        if (handlerThread != null) {
            handlerThread.quit();
            this.vR = null;
        }
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FramePixels framePixels) {
        if (this.Bw == null || this.Bx) {
            return;
        }
        this.Bw.a(framePixels, new ICallbackWith<ju>() { // from class: com.baidu.ar.jv.3
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void run(ju juVar) {
                if (jv.this.ou == null || jv.this.Bw == null) {
                    return;
                }
                if (juVar != null) {
                    juVar.Z(jv.this.getName());
                }
                jv.this.ou.a(juVar);
            }
        });
    }

    @Override // com.baidu.ar.di
    public boolean a(final FramePixels framePixels) {
        if (this.Bw == null || this.Bx) {
            return true;
        }
        this.Bv.a(1002, new Runnable() { // from class: com.baidu.ar.jv.2
            @Override // java.lang.Runnable
            public void run() {
                jv.this.b(framePixels);
            }
        });
        return true;
    }
}
