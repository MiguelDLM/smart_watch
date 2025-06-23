package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.camera.CameraManager;

/* loaded from: classes7.dex */
public class hb extends di {
    private static final String TAG = "hb";
    private ha vO;
    private he vP;
    private a vQ;
    private HandlerThread vR;

    /* loaded from: classes7.dex */
    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
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

    public hb() {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.oW.setOutputHeight(CameraManager.DEFAULTHEIGHT);
    }

    private gz eU() {
        return new gz() { // from class: com.baidu.ar.hb.1
            @Override // com.baidu.ar.gz
            public void a(hd hdVar) {
                if (hb.this.ou == null || hdVar == null) {
                    return;
                }
                hb.this.ou.a(new hf(hb.this.getName(), hdVar));
            }

            @Override // com.baidu.ar.gz
            public void onRelease(boolean z) {
                if (hb.this.ou != null) {
                    hb.this.ou.b(new dk(hb.this.getName(), z));
                }
            }

            @Override // com.baidu.ar.gz
            public void onSetup(boolean z) {
                if (hb.this.ou != null) {
                    hb.this.ou.a(new dk(hb.this.getName(), z));
                }
            }
        };
    }

    @Override // com.baidu.ar.di
    public void cB() {
        if (this.oW == null) {
            kf.b(TAG, "setupFrameDetector mRecgParams is NULLLL");
            return;
        }
        if (this.vO == null) {
            this.vO = ha.eS();
        }
        this.vO.a(this.vP, eU());
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.vR = handlerThread;
        handlerThread.start();
        this.vQ = new a(this.vR.getLooper());
    }

    @Override // com.baidu.ar.di
    public void cC() {
        ha haVar = this.vO;
        if (haVar != null) {
            haVar.release();
            this.vO = null;
        }
        this.vP = null;
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return TAG;
    }

    private void b(FramePixels framePixels) {
        if (this.vO != null) {
            hc hcVar = new hc(framePixels.getPixelsAddress(), framePixels.getTimestamp());
            PixelReadParams pixelReadParams = this.oW;
            if (pixelReadParams != null) {
                hcVar.setWidth(pixelReadParams.getAlgoWidth());
                hcVar.setHeight(this.oW.getAlgoHeight());
            }
            this.vO.a(hcVar);
        }
    }

    @Override // com.baidu.ar.di
    public boolean a(FramePixels framePixels) {
        b(framePixels);
        return true;
    }

    public void b(he heVar) {
        this.vP = heVar;
    }
}
