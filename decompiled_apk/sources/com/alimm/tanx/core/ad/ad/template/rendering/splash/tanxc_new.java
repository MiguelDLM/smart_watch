package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.app.Activity;
import android.content.Context;
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

/* loaded from: classes.dex */
public class tanxc_new extends tanxc_if<ITanxSplashAd> implements ITanxSplashExpressAd {
    private final Context tanxc_do;
    private TanxSplashAdView tanxc_if;
    private ITanxSplashExpressAd.OnSplashAdListener tanxc_int;
    private ITanxSplashInteractionListener tanxc_new;

    public tanxc_new(Context context, ITanxSplashAd iTanxSplashAd) {
        super(iTanxSplashAd);
        this.tanxc_do = context;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        LogUtils.d("TanxSplashExpressAd", "媒体调用destroy（）");
        this.tanxc_int = null;
        this.tanxc_new = null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public int getFromType() {
        if (tanxc_if() != null) {
            return tanxc_if().fromType;
        }
        return -1;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public ITanxSplashExpressAd.OnSplashAdListener getOnSplashAdListener() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.SPLASH_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public void setOnSplashAdListener(ITanxSplashExpressAd.OnSplashAdListener onSplashAdListener) {
        this.tanxc_int = onSplashAdListener;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView(Activity activity) {
        TanxCommonUt.sendIntoMethod(getAdSlot(), getRequestId(), getBidInfo(), "TanxSplashExpressAd-getAdView", AdUtConstants.INTO_METHOD);
        if (this.tanxc_if == null) {
            TanxSplashAdView tanxSplashAdView = new TanxSplashAdView(activity);
            this.tanxc_if = tanxSplashAdView;
            tanxSplashAdView.setTanxSplashExpressAd(this);
            this.tanxc_if.setRenderCallback(new IRenderCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.1
                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdClicked(boolean z, BidInfo bidInfo, long j, Context context, boolean z2, int i) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClicked();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdClosed(boolean z, BidInfo bidInfo, long j) {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdFinished(boolean z, BidInfo bidInfo, long j) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdFinish();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdShowError(int i) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onShowError(new TanxError("错误码:" + i));
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdShowException(boolean z, String str) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onShowError(new TanxError(str));
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdStarted(boolean z, BidInfo bidInfo) {
                    if (tanxc_new.this.tanxc_int != null) {
                        try {
                            tanxc_new.this.tanxc_int.onAdRender((ITanxSplashExpressAd) tanxc_new.this.tanxc_for);
                        } catch (Exception unused) {
                            tanxc_new.this.tanxc_int.onAdRender(null);
                        }
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void requestCloseAd(boolean z, int i) {
                }
            });
            this.tanxc_if.startShow(getBidInfo());
            ITanxSplashInteractionListener iTanxSplashInteractionListener = new ITanxSplashInteractionListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.2
                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxSplashAd iTanxSplashAd) {
                    tanxc_do();
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
                public void onAdClose() {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
                public void onAdShake() {
                    if (tanxc_new.this.tanxc_if != null) {
                        tanxc_new.this.tanxc_if.pauseTimer();
                    }
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdShake();
                    }
                    tanxc_new.this.tanxc_do(null, null, true);
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public /* synthetic */ void onAdShow(ITanxSplashAd iTanxSplashAd) {
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
            this.tanxc_new = iTanxSplashInteractionListener;
            this.tanxc_if.setITanxSplashInteractionListener(iTanxSplashInteractionListener);
            ITanxSplashAd iTanxSplashAd = (ITanxSplashAd) this.tanxc_for;
            TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
            iTanxSplashAd.bindSplashAdView(tanxSplashAdView2, tanxSplashAdView2.getClickView(), this.tanxc_if.getCloseView(), this.tanxc_new);
        }
        return this.tanxc_if;
    }

    public TanxSplashAd tanxc_if() {
        T t = this.tanxc_for;
        if (t == 0 || !(t instanceof TanxSplashAd)) {
            return null;
        }
        return (TanxSplashAd) t;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        return getAdView((Activity) this.tanxc_do);
    }

    public void tanxc_do(String str, String str2, boolean z) {
        T t = this.tanxc_for;
        if (t instanceof TanxSplashAd) {
            TanxSplashAdView tanxSplashAdView = this.tanxc_if;
            if (tanxSplashAdView != null) {
                ((TanxSplashAd) t).navigateAndUt(null, tanxSplashAdView.getContext(), z, str, str2);
            } else {
                LogUtils.e("TanxSplashExpressAd", "摇一摇时，mAdView为空");
            }
        }
    }
}
