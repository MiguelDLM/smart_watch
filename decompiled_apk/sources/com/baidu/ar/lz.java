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
public class lz extends di {
    private a Fg;
    private lx Fh;
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
    }

    public lz(lx lxVar) {
        this.Fh = lxVar;
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.oW.setOutputHeight(CameraManager.DEFAULTHEIGHT);
    }

    @Override // com.baidu.ar.di
    public void cB() {
        HandlerThread handlerThread = new HandlerThread("VpasDetector");
        this.vR = handlerThread;
        handlerThread.start();
        a aVar = new a(this.vR.getLooper());
        this.Fg = aVar;
        aVar.a(1001, new Runnable() { // from class: com.baidu.ar.lz.1
            @Override // java.lang.Runnable
            public void run() {
                lz.this.Fh.init();
            }
        });
    }

    @Override // com.baidu.ar.di
    public void cC() {
    }

    @Override // com.baidu.ar.di
    public PixelReadParams cT() {
        return super.cT();
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return "VpasDetector";
    }

    @Override // com.baidu.ar.di
    public boolean a(FramePixels framePixels) {
        this.Fh.a(framePixels, new ICallbackWith<ma>() { // from class: com.baidu.ar.lz.2
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void run(ma maVar) {
                maVar.Z(lz.this.getName());
                lz.this.ou.a(maVar);
            }
        });
        return false;
    }
}
