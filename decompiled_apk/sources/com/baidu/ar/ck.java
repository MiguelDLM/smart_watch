package com.baidu.ar;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICapture;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ck extends e implements ICapture {
    private WeakReference<ICapture> nl;
    private ICaptureAbilityListener nm;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.e
    public void a(d dVar) {
        if (dVar == 0) {
            WeakReference<ICapture> weakReference = this.nl;
            if (weakReference != null) {
                weakReference.clear();
                this.nl = null;
                return;
            }
            return;
        }
        if (dVar instanceof ICapture) {
            WeakReference<ICapture> weakReference2 = new WeakReference<>((ICapture) dVar);
            this.nl = weakReference2;
            if (this.nm != null) {
                weakReference2.get().setAbilityListener(this.nm);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.nl.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.e
    public void release() {
        this.nm = null;
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference != null) {
            weakReference.clear();
            this.nl = null;
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference == null || weakReference.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.nl.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference == null || weakReference.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.nl.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference == null || weakReference.get() == null) {
            this.nm = iCaptureAbilityListener;
        } else {
            this.nl.get().setAbilityListener(iCaptureAbilityListener);
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference = this.nl;
        if (weakReference == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.nl.get().setCaptureCallback(iCallbackWith);
    }
}
