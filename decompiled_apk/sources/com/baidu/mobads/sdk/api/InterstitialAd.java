package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.dt;
import com.baidu.mobads.sdk.internal.z;

/* loaded from: classes7.dex */
public class InterstitialAd {
    public static final String TAG = "InterstitialAd";
    private boolean initialized;
    private InterstitialAdListener listener;
    private final bv mAdLogger;
    private z mXInterstitial;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    private boolean isInterstitial(AdSize adSize) {
        if (adSize.getValue() <= AdSize.InterstitialOther.getValue() && adSize.getValue() >= AdSize.InterstitialGame.getValue()) {
            return true;
        }
        return false;
    }

    private boolean isInterstitialPause(AdSize adSize) {
        if (adSize.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && adSize.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue()) {
            return true;
        }
        return false;
    }

    public void destroy() {
        this.mXInterstitial.e();
    }

    public boolean isAdReady() {
        return this.mXInterstitial.c();
    }

    public void loadAd() {
        if (!this.initialized) {
            this.mXInterstitial.f();
            this.initialized = true;
        }
        this.mXInterstitial.b();
    }

    public void loadAdForVideoApp(int i, int i2) {
        if (!this.initialized) {
            this.mXInterstitial.f();
            this.initialized = true;
        }
        this.mXInterstitial.a(i, i2);
    }

    public void setAppSid(String str) {
        this.mXInterstitial.a(str);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener != null) {
            this.listener = interstitialAdListener;
            this.mXInterstitial.a(interstitialAdListener);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void showAd() {
        this.mXInterstitial.a_();
    }

    public void showAdInParentForVideoApp(RelativeLayout relativeLayout) {
        this.mXInterstitial.a(relativeLayout);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.initialized = false;
        this.mAdLogger = bv.a();
        this.listener = new InterstitialAdListener() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.1
            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdClick(InterstitialAd interstitialAd) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdReady() {
            }
        };
        ct ctVar = new ct(context);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.2
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return InterstitialAd.this.mXInterstitial.a(i, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i, int i2) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i) {
            }
        });
        if (isInterstitial(adSize)) {
            this.mXInterstitial = new dt(context, ctVar, this, str);
        } else if (isInterstitialPause(adSize)) {
            this.mXInterstitial = new dt(context, ctVar, this, adSize, str);
        }
        this.mXInterstitial.a(this.listener);
    }

    @Deprecated
    public void showAd(Activity activity) {
        this.mXInterstitial.a_();
    }

    @Deprecated
    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            this.mXInterstitial.a(relativeLayout);
            return;
        }
        throw new IllegalArgumentException();
    }
}
