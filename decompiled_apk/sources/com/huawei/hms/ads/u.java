package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class u extends Image {
    private static final String Code = "u";
    private double B;
    private int C;
    private String D;
    private boolean F;
    private ImageInfo I;
    private String L;
    private int S;
    private WeakReference<Drawable> V;
    private Uri Z;

    public u() {
    }

    public void Code(Drawable drawable) {
        this.V = new WeakReference<>(drawable);
    }

    public void V(String str) {
        this.L = str;
    }

    @Override // com.huawei.hms.ads.Image
    public Drawable getDrawable() {
        if (this.F) {
            return null;
        }
        WeakReference<Drawable> weakReference = this.V;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        n nVar = new n(this.I);
        nVar.Code(this.D);
        nVar.V(this.L);
        return nVar;
    }

    @Override // com.huawei.hms.ads.Image
    public int getHeight() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.Image
    public double getScale() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.Image
    public Uri getUri() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.Image
    public int getWidth() {
        return this.C;
    }

    public u(ImageInfo imageInfo, boolean z) {
        this.I = imageInfo;
        this.F = z;
        if (imageInfo != null) {
            if (!TextUtils.isEmpty(imageInfo.Z())) {
                this.Z = Uri.parse(imageInfo.Z());
            }
            this.C = imageInfo.C();
            int B = imageInfo.B();
            this.S = B;
            if (B > 0) {
                this.B = (this.C * 1.0d) / B;
            }
        }
    }

    public void Code(String str) {
        this.D = str;
    }
}
