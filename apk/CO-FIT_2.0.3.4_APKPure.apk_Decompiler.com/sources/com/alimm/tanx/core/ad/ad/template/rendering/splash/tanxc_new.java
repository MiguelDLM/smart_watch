package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.app.Activity;
import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.ad.splash.TanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;

public class tanxc_new extends tanxc_if<ITanxSplashAd> implements ITanxSplashExpressAd {
    private final Context tanxc_do;
    /* access modifiers changed from: private */
    public TanxSplashAdView tanxc_if;
    /* access modifiers changed from: private */
    public ITanxSplashExpressAd.OnSplashAdListener tanxc_int;
    private ITanxSplashInteractionListener tanxc_new;

    public tanxc_new(Context context, ITanxSplashAd iTanxSplashAd) {
        super(iTanxSplashAd);
        this.tanxc_do = context;
    }

    public void destroy() {
        LogUtils.d("TanxSplashExpressAd", "媒体调用destroy（）");
        this.tanxc_int = null;
        this.tanxc_new = null;
    }

    public int getFromType() {
        if (tanxc_if() != null) {
            return tanxc_if().fromType;
        }
        return -1;
    }

    public ITanxSplashExpressAd.OnSplashAdListener getOnSplashAdListener() {
        return this.tanxc_int;
    }

    public String getScene() {
        return TanxAdType.SPLASH_STRING;
    }

    public void refresh() {
    }

    public void setOnSplashAdListener(ITanxSplashExpressAd.OnSplashAdListener onSplashAdListener) {
        this.tanxc_int = onSplashAdListener;
    }

    /* renamed from: tanxc_do */
    public TanxAdView getAdView(Activity activity) {
        TanxCommonUt.sendIntoMethod(getAdSlot(), getRequestId(), getBidInfo(), "TanxSplashExpressAd-getAdView", AdUtConstants.INTO_METHOD);
        if (this.tanxc_if == null) {
            TanxSplashAdView tanxSplashAdView = new TanxSplashAdView(activity);
            this.tanxc_if = tanxSplashAdView;
            tanxSplashAdView.setTanxSplashExpressAd(this);
            this.tanxc_if.setRenderCallback(new IRenderCallback() {
                public void onAdClicked(boolean z, BidInfo bidInfo, long j, Context context, boolean z2, int i) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClicked();
                    }
                }

                public void onAdClosed(boolean z, BidInfo bidInfo, long j) {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                public void onAdFinished(boolean z, BidInfo bidInfo, long j) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdFinish();
                    }
                }

                public void onAdShowError(int i) {
                    if (tanxc_new.this.tanxc_int != null) {
                        ITanxSplashExpressAd.OnSplashAdListener tanxc_do2 = tanxc_new.this.tanxc_int;
                        tanxc_do2.onShowError(new TanxError("错误码:" + i));
                    }
                }

                public void onAdShowException(boolean z, String str) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onShowError(new TanxError(str));
                    }
                }

                public void onAdStarted(boolean z, BidInfo bidInfo) {
                    if (tanxc_new.this.tanxc_int != null) {
                        try {
                            tanxc_new.this.tanxc_int.onAdRender((ITanxSplashExpressAd) tanxc_new.this.tanxc_for);
                        } catch (Exception unused) {
                            tanxc_new.this.tanxc_int.onAdRender((ITanxSplashExpressAd) null);
                        }
                    }
                }

                public void requestCloseAd(boolean z, int i) {
                }
            });
            this.tanxc_if.startShow(getBidInfo());
            AnonymousClass2 r6 = new ITanxSplashInteractionListener() {
                public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
                    tanxc_do();
                }

                public void onAdClose() {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                public void onAdShake() {
                    if (tanxc_new.this.tanxc_if != null) {
                        tanxc_new.this.tanxc_if.pauseTimer();
                    }
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdShake();
                    }
                    tanxc_new.this.tanxc_do((String) null, (String) null, true);
                }

                public /* synthetic */ void onAdShow(ITanxAd iTanxAd) {
                    tanxc_if();
                }

                public void tanxc_do() {
                    tanxc_new.this.tanxc_if.pauseTimer();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClicked();
                    }
                    if (tanxc_new.this.tanxc_if != null && tanxc_new.this.tanxc_if.getClickView() != null) {
                        tanxc_new.this.tanxc_if.notifyViewClick();
                    }
                }

                public void tanxc_if() {
                    TanxCommonUt.sendIntoMethod(tanxc_new.this.getAdSlot(), tanxc_new.this.getRequestId(), tanxc_new.this.getBidInfo(), "ITanxSplashInteractionListener-onAdShow", AdUtConstants.INTO_METHOD);
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdShow();
                    }
                }
            };
            this.tanxc_new = r6;
            this.tanxc_if.setITanxSplashInteractionListener(r6);
            TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
            ((ITanxSplashAd) this.tanxc_for).bindSplashAdView(tanxSplashAdView2, tanxSplashAdView2.getClickView(), this.tanxc_if.getCloseView(), this.tanxc_new);
        }
        return this.tanxc_if;
    }

    public TanxSplashAd tanxc_if() {
        T t = this.tanxc_for;
        if (t == null || !(t instanceof TanxSplashAd)) {
            return null;
        }
        return (TanxSplashAd) t;
    }

    /* renamed from: tanxc_do */
    public TanxAdView getAdView() {
        return getAdView((Activity) this.tanxc_do);
    }

    public void tanxc_do(String str, String str2, boolean z) {
        T t = this.tanxc_for;
        if (t instanceof TanxSplashAd) {
            TanxSplashAdView tanxSplashAdView = this.tanxc_if;
            if (tanxSplashAdView != null) {
                ((TanxSplashAd) t).navigateAndUt((TanxAdView) null, tanxSplashAdView.getContext(), z, str, str2);
            } else {
                LogUtils.e("TanxSplashExpressAd", "摇一摇时，mAdView为空");
            }
        }
    }
}
