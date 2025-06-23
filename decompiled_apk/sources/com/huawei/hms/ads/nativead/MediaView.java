package com.huawei.hms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

@GlobalApi
/* loaded from: classes10.dex */
public class MediaView extends RelativeLayout {
    private ImageView.ScaleType B;
    private NativeVideoView Code;
    private b I;
    private NativeWindowImageView V;

    @GlobalApi
    public MediaView(Context context) {
        super(context);
        Code(context);
    }

    public void Code() {
        this.Code.destroyView();
    }

    public b getMediaViewAdapter() {
        return this.I;
    }

    public NativeWindowImageView getNativeWindowImageView() {
        return this.V;
    }

    public NativeVideoView getVideoView() {
        return this.Code;
    }

    @GlobalApi
    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.B = scaleType;
    }

    @GlobalApi
    public void setMediaContent(MediaContent mediaContent) {
        this.Code.setMediaContent(mediaContent);
    }

    @GlobalApi
    public void setRectCornerRadius(float f) {
        this.V.setRectCornerRadius(f);
        this.Code.setRectCornerRadius(f);
    }

    @GlobalApi
    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    private void Code(Context context) {
        setGravity(17);
        NativeVideoView nativeVideoView = new NativeVideoView(context);
        this.Code = nativeVideoView;
        nativeVideoView.setAudioFocusType(1);
        this.Code.setVisibility(4);
        addView(this.Code);
        this.V = new NativeWindowImageView(context);
        this.V.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.V.setVisibility(4);
        addView(this.V);
        this.I = new b(this.Code, this.V);
    }

    @GlobalApi
    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    @GlobalApi
    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Code(context);
    }
}
