package com.huawei.hms.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;

/* loaded from: classes10.dex */
public class n extends Drawable implements m {
    private static final String Code = "DrawableWrapper";
    private String B;
    private String C;
    private String I;
    private Drawable V;
    private ImageInfo Z;
    private volatile boolean S = false;
    private Drawable.Callback F = new Drawable.Callback() { // from class: com.huawei.hms.ads.n.1
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            n.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            n.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            n.this.unscheduleSelf(runnable);
        }
    };

    public n(ImageInfo imageInfo) {
        this.Z = imageInfo;
    }

    private SourceParam Code(ImageInfo imageInfo) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        return sourceParam;
    }

    private void V() {
        Context Z = k.Code().Z();
        if (Z == null) {
            fb.I(Code, "context is null");
        } else {
            this.S = true;
            com.huawei.openalliance.ad.utils.z.Code(Z, Code(this.Z), this.B, this.C, new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.n.2
                @Override // com.huawei.openalliance.ad.utils.an
                public void Code() {
                    fb.I(n.Code, "image load fail");
                    n.this.S = false;
                }

                @Override // com.huawei.openalliance.ad.utils.an
                public void Code(String str, final Drawable drawable) {
                    if (n.this.Z == null || !TextUtils.equals(str, n.this.Z.Z())) {
                        return;
                    }
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.n.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.S = false;
                            n.this.Code(drawable);
                        }
                    });
                }
            });
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return 255;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.V;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.getOutline(outline);
        } else {
            super.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.V;
        return drawable != null && drawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.V;
        return drawable != null && drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        boolean layoutDirection;
        Drawable drawable = this.V;
        if (drawable != null) {
            layoutDirection = drawable.setLayoutDirection(i);
            if (layoutDirection) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.V;
        return drawable != null && drawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.V;
        if (drawable == null || !drawable.isStateful()) {
            return false;
        }
        boolean state = this.V.setState(iArr);
        if (state) {
            onBoundsChange(getBounds());
        }
        return state;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.V == null && !this.S) {
            V();
        }
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.V;
        return (drawable != null && drawable.setVisible(z, z2)) | visible;
    }

    public n(String str) {
        this.I = str;
    }

    public void V(String str) {
        this.C = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        Drawable drawable = this.V;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public String Code() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.m
    public void Code(Drawable drawable) {
        int layoutDirection;
        fb.Code(Code, "setDrawable %s for %s", drawable, com.huawei.openalliance.ad.utils.bh.Code(this.I));
        Drawable drawable2 = this.V;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.V = drawable;
        if (drawable != null) {
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (drawable instanceof ds) {
                ((ds) drawable).Code(this.F);
            } else {
                drawable.setCallback(this.F);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                layoutDirection = getLayoutDirection();
                drawable.setLayoutDirection(layoutDirection);
            }
        }
        invalidateSelf();
    }

    public void Code(String str) {
        this.B = str;
    }
}
