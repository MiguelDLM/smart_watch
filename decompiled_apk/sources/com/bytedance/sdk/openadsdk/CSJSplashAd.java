package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* loaded from: classes8.dex */
public interface CSJSplashAd extends TTClientBidding {

    /* loaded from: classes8.dex */
    public interface SplashAdListener {
        void onSplashAdClick(CSJSplashAd cSJSplashAd);

        void onSplashAdClose(CSJSplashAd cSJSplashAd, int i);

        void onSplashAdShow(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: classes8.dex */
    public interface SplashCardListener {
        void onSplashCardClick();

        void onSplashCardClose();

        void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: classes8.dex */
    public interface SplashClickEyeListener {
        void onSplashClickEyeClick();

        void onSplashClickEyeClose();

        void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd);
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationSplashManager getMediationManager();

    View getSplashCardView();

    int[] getSplashClickEyeSizeToDp();

    View getSplashClickEyeView();

    View getSplashView();

    void hideSkipButton();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setSplashAdListener(SplashAdListener splashAdListener);

    void setSplashCardListener(SplashCardListener splashCardListener);

    void setSplashClickEyeListener(SplashClickEyeListener splashClickEyeListener);

    void showSplashCardView(ViewGroup viewGroup, Activity activity);

    void showSplashClickEyeView(ViewGroup viewGroup);

    void showSplashView(ViewGroup viewGroup);

    void startClickEye();
}
