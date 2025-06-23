package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter;
import com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do;
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

public class tanxc_int extends tanxc_do<ISplashModel, ITanxSplashAd, ITanxSplashExpressAd> {
    private final String tanxc_for = "SplashAdPresenter";
    private final boolean tanxc_int = false;
    private final boolean tanxc_new = false;

    public tanxc_int(Context context, ISplashModel iSplashModel) {
        super(context, iSplashModel);
    }

    public IPresenter destroy() {
        return super.destroy();
    }

    public ITanxSplashExpressAd tanxc_do(ITanxSplashAd iTanxSplashAd) {
        return new tanxc_new(this.tanxc_do, iTanxSplashAd);
    }

    public IPresenter tanxc_do(final boolean z, TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j) {
        ((ISplashModel) this.tanxc_if).sendRequest(z, tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxSplashAd>() {
            public void onError(final TanxError tanxError) {
                UIThreadUtils.post(new Runnable() {
                    public void run() {
                        String str;
                        String str2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("开屏请求错误 syncReq= ");
                        sb.append(z);
                        sb.append("--reason= ");
                        TanxError tanxError = tanxError;
                        if (tanxError != null) {
                            str = tanxError.toString();
                        } else {
                            str = "";
                        }
                        sb.append(str);
                        LogUtils.e("SplashAdPresenter", sb.toString());
                        int intCode = UtErrorCode.ERROR_AD_LISTENER.getIntCode();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("开屏请求错误 syncReq= ");
                        sb2.append(z);
                        sb2.append("--reason= ");
                        TanxError tanxError2 = tanxError;
                        if (tanxError2 != null) {
                            str2 = tanxError2.getMessage();
                        } else {
                            str2 = "";
                        }
                        sb2.append(str2);
                        TanxBaseUt.utError(intCode, "SplashAdPresenter", sb2.toString(), "");
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                        if (onAdLoadListener != null) {
                            onAdLoadListener.onError(tanxError);
                        }
                    }
                });
            }

            public void onSuccess(final List<ITanxSplashAd> list) {
                UIThreadUtils.post(new Runnable() {
                    public void run() {
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener;
                        LogUtils.d("SplashAdPresenter", "开屏请求成功 syncReq= " + z);
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        if (z && (onAdLoadListener = onAdLoadListener) != null) {
                            onAdLoadListener.onLoaded(tanxc_int.this.tanxc_do(list));
                        }
                    }
                });
            }

            public void onTimeOut() {
                UIThreadUtils.post(new Runnable() {
                    public void run() {
                        LogUtils.d("SplashAdPresenter", "开屏请求超时 syncReq= " + z);
                        ITanxAdLoader.OnAdLoadListener onAdLoadListener = onAdLoadListener;
                        if (onAdLoadListener != null) {
                            onAdLoadListener.onTimeOut();
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
        tanxc_do(false, tanxAdSlot, (ITanxAdLoader.OnAdLoadListener) null, 0);
    }
}
