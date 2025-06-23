package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.kv;

/* loaded from: classes10.dex */
public class LinkedSurfaceView extends RelativeLayout implements kv {
    private int B;
    private int I;
    private BaseGlVideoView V;

    public LinkedSurfaceView(Context context) {
        super(context);
        Code(context);
    }

    public void Code(float f, float f2, float f3, int i, int i2) {
        super.setScaleY(f);
        super.setTranslationY(f2);
        super.setScaleX(f3);
        this.B = i2;
        this.I = i;
        if (this.V.getVideoHeight() == 0 || i2 == 0) {
            return;
        }
        this.V.Code(i, i2);
        this.V.Code((r2.getVideoWidth() * 1.0f) / this.V.getVideoHeight(), (i * 1.0f) / i2, i, i2);
    }

    public void Z() {
        this.V.destroyView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fb.V("LinkedSurfaceView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.V("LinkedSurfaceView", "onDetachedFromWindow");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if (this.B == 0 && this.I == 0) {
            this.I = i3 - i;
            this.B = i4 - i2;
        }
        if (this.V.getVideoHeight() == 0 || (i5 = this.B) == 0) {
            return;
        }
        this.V.Code(this.I, i5);
        int i6 = this.I;
        int i7 = this.B;
        this.V.Code((r2.getVideoWidth() * 1.0f) / this.V.getVideoHeight(), (i6 * 1.0f) / i7, i6, i7);
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z) {
        this.V.setAutoScaleResizeLayoutOnVideoSizeChange(z);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z) {
        this.V.setNeedPauseOnSurfaceDestory(z);
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.V.setScreenOnWhilePlaying(z);
    }

    public void setVideoRatio(Float f) {
        this.V.setVideoRatio(f);
    }

    public void setVideoScaleMode(int i) {
        this.V.setVideoScaleMode(i);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public void Code(float f, float f2, int i, int i2) {
        this.V.Code(f, f2, i, i2);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.V = Build.VERSION.SDK_INT >= 26 ? new SurfaceVideoView(context) : new TextureGlVideoView(context);
        addView(this.V, new RelativeLayout.LayoutParams(-1, -1));
    }
}
