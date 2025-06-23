package com.baidu.ar;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.photo.PhotoCallback;
import java.io.File;

/* loaded from: classes7.dex */
public class gq implements com.baidu.ar.arplay.core.renderer.TakePictureCallback {
    private String vh;

    /* renamed from: vi, reason: collision with root package name */
    private PhotoCallback f5570vi;

    public void a(IARRenderer iARRenderer, String str, PhotoCallback photoCallback) {
        if (iARRenderer == null || TextUtils.isEmpty(str) || photoCallback == null) {
            return;
        }
        this.vh = str;
        this.f5570vi = photoCallback;
        iARRenderer.getSnapShot(this);
    }

    @Override // com.baidu.ar.arplay.core.renderer.TakePictureCallback
    public void onPictureTake(boolean z, Bitmap bitmap, long j) {
        if (this.f5570vi == null || TextUtils.isEmpty(this.vh)) {
            return;
        }
        km.f(new File(this.vh));
        km.a(this.vh, bitmap, 100);
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f5570vi.onPictureTake(z, this.vh);
    }
}
