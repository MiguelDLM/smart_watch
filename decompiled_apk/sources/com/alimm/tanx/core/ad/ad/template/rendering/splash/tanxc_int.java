package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.UIThreadUtils;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<ISplashModel, ITanxSplashAd, ITanxSplashExpressAd> {
    private final String tanxc_for;
    private final boolean tanxc_int;
    private final boolean tanxc_new;

    public tanxc_int(Context context, ISplashModel iSplashModel) {
        super(context, iSplashModel);
        this.tanxc_for = "SplashAdPresenter";
        this.tanxc_int = false;
        this.tanxc_new = false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do, com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter destroy() {
        return super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxSplashExpressAd tanxc_do(ITanxSplashAd iTanxSplashAd) {
        return new tanxc_new(this.tanxc_do, iTanxSplashAd);
    }

    public IPresenter tanxc_do(final boolean z, TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        ((ISplashModel) this.tanxc_if).sendRequest(z, tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxSplashAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(final TanxError tanxError) {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("开屏请求错误 syncReq= ");
                        sb.append(z);
                        sb.append("--reason= ");
                        TanxError tanxError2 = tanxError;
                        if (tanxError2 == null) {
                            str = "";
                        } else {
                            str = tanxError2.toString();
                        }
                        sb.append(str);
                        LogUtils.e("SplashAdPresenter", sb.toString());
                        int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("开屏请求错误 syncReq= ");
                        sb2.append(z);
                        sb2.append("--reason= ");
                        TanxError tanxError3 = tanxError;
                        if (tanxError3 == null) {
                            str2 = "";
                        } else {
                            str2 = tanxError3.getMessage();
                        }
                        sb2.append(str2);
                        TanxBaseUt.utError(intCode, "SplashAdPresenter", sb2.toString(), "");
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                        if (onAdLoadListener2 != null) {
                            onAdLoadListener2.onError(tanxError);
                        }
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(final List<ITanxSplashAd> list) {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2;
                        LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (z && (onAdLoadListener2 = onAdLoadListener) != null) {
                            onAdLoadListener2.onLoaded(tanxc_int.this.tanxc_do(list));
                        }
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                UIThreadUtils.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z);
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                        if (onAdLoadListener2 != null) {
                            onAdLoadListener2.onTimeOut();
                        }
                    }
                });
            }
        }, j);
        return this;
    }

    public void tanxc_do(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        tanxc_do(true, tanxAdSlot, onAdLoadListener, j);
    }

    public void tanxc_do(TanxAdSlot tanxAdSlot) {
        tanxc_do(false, tanxAdSlot, null, 0L);
    }
}
