package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class bj {
    private Handler bs;
    private List<String> kn;
    private LuaMsgListener ko;
    private fu kp;
    private IARPRenderer kq;
    private PixelReadParams kr;
    private PixelReadListener ks;

    public bj(Looper looper, fu fuVar, IARPRenderer iARPRenderer) {
        if (looper == null || fuVar == null || iARPRenderer == null) {
            kf.b("FrameCapture", "create FrameCapture error!!! As params NULLLLL!!!");
        }
        this.bs = new Handler(looper);
        this.kp = fuVar;
        this.kq = iARPRenderer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO() {
        Handler handler = this.bs;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.bj.2
                @Override // java.lang.Runnable
                public void run() {
                    bj.this.bM();
                }
            });
        }
    }

    private void j(int i, int i2) {
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.RGBA);
        this.kr = pixelReadParams;
        pixelReadParams.setOutputWidth(i);
        this.kr.setOutputHeight(i2);
        this.kr.setFrameType(PixelReadParams.FrameType.SINGLE_FRAME);
        this.ks = new PixelReadListener() { // from class: com.baidu.ar.bj.1
            @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
            public boolean onPixelRead(FramePixels framePixels) {
                if (framePixels == null || bj.this.kq == null) {
                    return false;
                }
                kf.c("FrameCapture", "onPixelRead textureID = " + framePixels.getTextureID());
                bj.this.kq.setCaptureData(framePixels.getTextureID());
                bj.this.bO();
                return true;
            }
        };
    }

    public void bM() {
        PixelReadParams pixelReadParams;
        PixelReadListener pixelReadListener;
        IARPRenderer iARPRenderer = this.kq;
        if (iARPRenderer == null || (pixelReadParams = this.kr) == null || (pixelReadListener = this.ks) == null) {
            return;
        }
        iARPRenderer.destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void bN() {
        IARPRenderer iARPRenderer = this.kq;
        if (iARPRenderer != null) {
            iARPRenderer.clearCaptureData();
        }
    }

    public void i(int i, int i2) {
        j(i, i2);
        a(this.kp);
    }

    public void release() {
        LuaMsgListener luaMsgListener;
        Handler handler = this.bs;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.bs = null;
        }
        fu fuVar = this.kp;
        if (fuVar != null && (luaMsgListener = this.ko) != null) {
            fuVar.removeLuaMsgListener(luaMsgListener);
        }
        this.kp = null;
        this.ko = null;
        this.kn = null;
        this.kr = null;
        this.ks = null;
        this.kq = null;
    }

    private void a(fu fuVar) {
        this.kn = Arrays.asList("event_name");
        LuaMsgListener luaMsgListener = new LuaMsgListener() { // from class: com.baidu.ar.bj.3
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return bj.this.kn;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                PixelReadParams pixelReadParams;
                PixelRotation pixelRotation;
                if (bj.this.kq == null || bj.this.kr == null || bj.this.ks == null) {
                    return;
                }
                String str = (String) hashMap.get("event_name");
                kf.c("FrameCapture", "createLuaCaptureListener eventName = " + str);
                if (!"capture_frame".equals(str)) {
                    if ("clear_capture".equals(str)) {
                        bj.this.kq.clearCaptureData();
                        return;
                    }
                    return;
                }
                bj.this.kr.setPreFilterID((String) hashMap.get("filter_id"));
                if (bj.this.kr.getPreFilterID().equals(PixelReadParams.DEFAULT_FILTER_ID) || TextUtils.isEmpty(bj.this.kr.getPreFilterID())) {
                    if (bj.this.kq.isFrontCamera()) {
                        pixelReadParams = bj.this.kr;
                        pixelRotation = PixelRotation.RotateRightFlipHorizontal;
                    } else {
                        pixelReadParams = bj.this.kr;
                        pixelRotation = PixelRotation.RotateRight;
                    }
                    pixelReadParams.setPixelRotate(pixelRotation);
                }
                bj.this.kq.createPixelReaderByPreFilterID(bj.this.kr, bj.this.ks);
            }
        };
        this.ko = luaMsgListener;
        fuVar.addLuaMsgListener(luaMsgListener);
    }
}
