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
public class lg extends di {
    private static final String TAG = "lg";
    private a Eb;
    private ld Ec;
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

    public lg(lb lbVar, ld ldVar) {
        this.Ec = ldVar;
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.oW.setOutputHeight(CameraManager.DEFAULTHEIGHT);
    }

    @Override // com.baidu.ar.di
    public void cB() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.vR = handlerThread;
        handlerThread.start();
        a aVar = new a(this.vR.getLooper());
        this.Eb = aVar;
        aVar.a(1001, new Runnable() { // from class: com.baidu.ar.lg.1
            @Override // java.lang.Runnable
            public void run() {
                lg.this.Ec.init();
            }
        });
    }

    @Override // com.baidu.ar.di
    public void cC() {
        a aVar = this.Eb;
        if (aVar != null) {
            aVar.release();
            this.Eb = null;
        }
        if (this.Ec != null) {
            this.Ec = null;
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
        ld ldVar = this.Ec;
        if (ldVar != null) {
            ldVar.a(framePixels, new ICallbackWith<lh>() { // from class: com.baidu.ar.lg.3
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void run(lh lhVar) {
                    if (lg.this.ou == null || lg.this.Ec == null) {
                        return;
                    }
                    if (lhVar != null) {
                        lhVar.Z(lg.this.getName());
                    }
                    lg.this.ou.a(lhVar);
                }
            });
        }
    }

    @Override // com.baidu.ar.di
    public boolean a(final FramePixels framePixels) {
        if (this.Ec == null) {
            return true;
        }
        this.Eb.a(1002, new Runnable() { // from class: com.baidu.ar.lg.2
            @Override // java.lang.Runnable
            public void run() {
                lg.this.b(framePixels);
            }
        });
        return true;
    }
}
