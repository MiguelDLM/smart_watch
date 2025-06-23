package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ku;
import com.huawei.hms.ads.splash.R;

/* loaded from: classes10.dex */
public class SplashLinkedVideoView extends AutoScaleSizeRelativeLayout implements ku {
    private ViewStub B;
    private PPSSplashProView C;
    private LinkedSurfaceView Code;
    private PPSSplashSwipeClickView D;
    private PPSSplashTwistView F;
    private PPSSplashAdSourceView I;
    private PPSSplashTwistClickView L;
    private PPSSplashSwipeView S;
    private PPSWLSView V;

    public SplashLinkedVideoView(Context context) {
        super(context);
        Code(context);
    }

    private void Code(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(R.layout.hiad_splash_linked_video_view, this)).setBackgroundColor(0);
        this.Code = (LinkedSurfaceView) findViewById(R.id.hiad_linked_video_view);
        PPSWLSView pPSWLSView = (PPSWLSView) findViewById(R.id.splash_wls_view);
        this.V = pPSWLSView;
        pPSWLSView.setVisibility(8);
        PPSSplashAdSourceView pPSSplashAdSourceView = (PPSSplashAdSourceView) findViewById(R.id.splash_ad_source_view);
        this.I = pPSSplashAdSourceView;
        pPSSplashAdSourceView.setVisibility(8);
        this.B = (ViewStub) findViewById(R.id.hiad_logo_stub);
        this.C = (PPSSplashProView) findViewById(R.id.hiad_splash_pro_view);
        this.S = (PPSSplashSwipeView) findViewById(R.id.hiad_splash_swipe_view);
        this.F = (PPSSplashTwistView) findViewById(R.id.hiad_splash_twist_view);
        this.L = (PPSSplashTwistClickView) findViewById(R.id.hiad_splash_twist_click_view);
        this.D = (PPSSplashSwipeClickView) findViewById(R.id.hiad_splash_swipe_click_view);
        this.Code.setNeedPauseOnSurfaceDestory(false);
        this.Code.setScreenOnWhilePlaying(true);
        this.Code.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.Code.setVideoScaleMode(2);
    }

    public void I() {
        removeAllViews();
        this.Code = null;
        this.V = null;
        this.I = null;
        this.B = null;
        this.C = null;
        this.S = null;
        this.F = null;
        this.D = null;
        this.L = null;
    }

    public void V() {
        if (this.Code.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.Code.getParent()).removeView(this.Code);
        }
    }

    public LinkedSurfaceView getLinkedVideoView() {
        return this.Code;
    }

    public PPSSplashAdSourceView getPpsSplashAdSourceView() {
        return this.I;
    }

    public PPSWLSView getPpswlsView() {
        return this.V;
    }

    public PPSSplashProView getProView() {
        return this.C;
    }

    public int getStatusBarHeight() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr[1];
    }

    public PPSSplashSwipeClickView getSwipeClickView() {
        return this.D;
    }

    public PPSSplashSwipeView getSwipeView() {
        return this.S;
    }

    public PPSSplashTwistClickView getTwistClickView() {
        return this.L;
    }

    public PPSSplashTwistView getTwistView() {
        return this.F;
    }

    public ViewStub getViewStub() {
        return this.B;
    }

    public SplashLinkedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public SplashLinkedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }
}
