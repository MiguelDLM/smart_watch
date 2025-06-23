package com.sma.smartv3.biz.ad;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.view.ViewGroup;
import com.adp.sdk.ADPSplashAdLoader;
import com.adp.sdk.dto.AdpError;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ADPCAppOpenAdManager {

    @OOXIXo
    public static final ADPCAppOpenAdManager INSTANCE = new ADPCAppOpenAdManager();

    @OOXIXo
    private static final String TAG = "ADPCAppOpenAdManager";
    private static boolean isAdDismiss;
    private static boolean isClicked;
    private static boolean isLeftActivity;
    private static boolean isLoadingAd;
    private static boolean isShowingAd;

    @oOoXoXO
    private static OnShowADPCAdCompleteListener showAdCompleteListener;

    @oOoXoXO
    private static ADPSplashAdLoader splashAd;

    private ADPCAppOpenAdManager() {
    }

    private final boolean isAdAvailable() {
        if (splashAd != null) {
            return true;
        }
        return false;
    }

    public final void destroy() {
        isAdDismiss = false;
        isClicked = false;
        isLoadingAd = false;
        showAdCompleteListener = null;
        ADPSplashAdLoader aDPSplashAdLoader = splashAd;
        if (aDPSplashAdLoader != null) {
            if (aDPSplashAdLoader != null) {
                aDPSplashAdLoader.destroy();
            }
            splashAd = null;
        }
    }

    @oOoXoXO
    public final OnShowADPCAdCompleteListener getShowAdCompleteListener() {
        return showAdCompleteListener;
    }

    public final boolean isAdDismiss() {
        return isAdDismiss;
    }

    public final boolean isClicked() {
        return isClicked;
    }

    public final boolean isLeftActivity() {
        return isLeftActivity;
    }

    public final boolean isShowingAd() {
        return isShowingAd;
    }

    public final void loadAd(@OOXIXo final Activity context, @OOXIXo final ViewGroup adContainer, @OOXIXo String unitId) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(adContainer, "adContainer");
        IIX0o.x0xO0oo(unitId, "unitId");
        if (!isLoadingAd && !isAdAvailable()) {
            oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager loadAd -> id: " + unitId);
            isLoadingAd = true;
            isShowingAd = false;
            ADPSplashAdLoader aDPSplashAdLoader = new ADPSplashAdLoader(context, unitId, adContainer, 0, false, 0, 0, new ADPSplashAdLoader.ADPSplashADListener() { // from class: com.sma.smartv3.biz.ad.ADPCAppOpenAdManager$loadAd$1
                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADClicked() {
                    oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager -> Ad State : Clicked");
                    ADPCAppOpenAdManager.INSTANCE.setClicked(true);
                }

                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADDismissed() {
                    oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
                    oix0oi.oIX0oI("ADPCAppOpenAdManager -> Ad State : Closed");
                    ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
                    aDPCAppOpenAdManager.setAdDismiss(true);
                    if (aDPCAppOpenAdManager.isLeftActivity()) {
                        oix0oi.oIX0oI("ADPCAppOpenAdManager -> Ad State : onAdClosed. 广告被点击跳转到其它界面或按HOME键压入后台时，忽略此回调");
                        return;
                    }
                    aDPCAppOpenAdManager.setShowingAd(false);
                    OnShowADPCAdCompleteListener showAdCompleteListener2 = aDPCAppOpenAdManager.getShowAdCompleteListener();
                    if (showAdCompleteListener2 != null) {
                        showAdCompleteListener2.onShowAdComplete();
                    }
                }

                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADError(@oOoXoXO AdpError adpError) {
                    String str;
                    ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
                    ADPCAppOpenAdManager.isLoadingAd = false;
                    aDPCAppOpenAdManager.setAdDismiss(true);
                    oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ADPCAppOpenAdManager -> Ad State : Error, Info: ");
                    if (adpError != null) {
                        str = adpError.getMessage();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    oix0oi.oIX0oI(sb.toString());
                    if (aDPCAppOpenAdManager.isLeftActivity()) {
                        oix0oi.oIX0oI("ADPCAppOpenAdManager -> Ad State : onAdFailed. 广告失败了，忽略此回调");
                        return;
                    }
                    aDPCAppOpenAdManager.setShowingAd(false);
                    OnShowADPCAdCompleteListener showAdCompleteListener2 = aDPCAppOpenAdManager.getShowAdCompleteListener();
                    if (showAdCompleteListener2 != null) {
                        showAdCompleteListener2.onShowAdComplete();
                    }
                }

                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADPresent() {
                    oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager -> Ad State : Exposure");
                }

                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADReceive(long j) {
                    ADPCAppOpenAdManager aDPCAppOpenAdManager = ADPCAppOpenAdManager.INSTANCE;
                    ADPCAppOpenAdManager.isLoadingAd = false;
                    oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager -> Ad State : Loaded");
                    aDPCAppOpenAdManager.showAdIfAvailable(context, adContainer);
                }

                @Override // com.adp.sdk.ADPSplashAdLoader.ADPSplashADListener
                public void onADTick(long j) {
                }
            });
            splashAd = aDPSplashAdLoader;
            aDPSplashAdLoader.loadAD();
        }
    }

    public final void setAdDismiss(boolean z) {
        isAdDismiss = z;
    }

    public final void setClicked(boolean z) {
        isClicked = z;
    }

    public final void setLeftActivity(boolean z) {
        isLeftActivity = z;
    }

    public final void setShowAdCompleteListener(@oOoXoXO OnShowADPCAdCompleteListener onShowADPCAdCompleteListener) {
        showAdCompleteListener = onShowADPCAdCompleteListener;
    }

    public final void setShowingAd(boolean z) {
        isShowingAd = z;
    }

    public final void showAdIfAvailable(@OOXIXo Activity activity, @OOXIXo ViewGroup adContainer) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(adContainer, "adContainer");
        if (isShowingAd) {
            oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager The app open ad is already showing.");
            return;
        }
        if (!isAdAvailable()) {
            oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager The app open ad is not ready yet.");
            OnShowADPCAdCompleteListener onShowADPCAdCompleteListener = showAdCompleteListener;
            if (onShowADPCAdCompleteListener != null) {
                onShowADPCAdCompleteListener.onShowAdComplete();
                return;
            }
            return;
        }
        oIX0oI.f1507oIX0oI.oIX0oI("ADPCAppOpenAdManager Will show ad.");
        isShowingAd = true;
        ADPSplashAdLoader aDPSplashAdLoader = splashAd;
        if (aDPSplashAdLoader != null) {
            aDPSplashAdLoader.showAD();
        }
    }
}
