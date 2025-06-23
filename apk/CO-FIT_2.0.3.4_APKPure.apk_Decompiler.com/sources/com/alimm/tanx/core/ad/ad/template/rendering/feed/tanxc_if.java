package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;

public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxFeedAd> implements ITanxFeedExpressAd, ITanxFeedCacheContext {
    ITanxFeedExpressAd.OnFeedAdListener tanxc_do;
    tanxc_for tanxc_if;
    private final Context tanxc_int;
    /* access modifiers changed from: private */
    public TanxFeedAdView tanxc_new;

    public tanxc_if(Context context, ITanxFeedAd iTanxFeedAd, tanxc_for tanxc_for) {
        super(iTanxFeedAd);
        this.tanxc_int = context;
        this.tanxc_if = tanxc_for;
    }

    private boolean tanxc_for() {
        T t = this.tanxc_for;
        if (t == null || ((ITanxFeedAd) t).getBidInfo() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId())) {
            return false;
        }
        return AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID.equals(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId());
    }

    private boolean tanxc_int() {
        T t = this.tanxc_for;
        if (t == null || ((ITanxFeedAd) t).getBidInfo() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getWebType2Int() != 2) {
            return false;
        }
        return true;
    }

    public void destroy() {
        LogUtils.d("TanxFeedExpressAd", "媒体调用destroy（）");
        super.destroy();
        this.tanxc_do = null;
    }

    public BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    public void refresh() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        if (tanxFeedAdView != null) {
            tanxFeedAdView.loadAdStyle();
        }
    }

    public View remove() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        this.tanxc_new = null;
        return tanxFeedAdView;
    }

    public void setOnFeedAdListener(ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.tanxc_do = onFeedAdListener;
    }

    private boolean tanxc_if() {
        T t = this.tanxc_for;
        if (t == null || ((ITanxFeedAd) t).getBidInfo() == null) {
            return false;
        }
        return ((ITanxFeedAd) this.tanxc_for).getBidInfo().getInteractType2FeedSlide();
    }

    /* renamed from: tanxc_do */
    public TanxAdView getAdView(final Activity activity) {
        if (tanxc_for() && tanxc_int()) {
            this.tanxc_new = this.tanxc_if.tanxc_for(this, activity);
        } else if (tanxc_if()) {
            this.tanxc_new = this.tanxc_if.tanxc_if(this, activity);
        } else {
            this.tanxc_new = this.tanxc_if.tanxc_do(this, activity);
        }
        this.tanxc_new.setTanxFeedAd((ITanxFeedAd) this.tanxc_for, this.tanxc_do);
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        ((ITanxFeedAd) this.tanxc_for).bindFeedAdView((TanxAdView) tanxFeedAdView, (View) tanxFeedAdView, tanxFeedAdView.getCloseView(), (ITanxFeedInteractionListener) new ITanxFeedInteractionListener() {
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
                tanxc_do((ITanxFeedAd) iTanxAd);
            }

            public void onAdClose() {
                tanxc_if tanxc_if2 = tanxc_if.this;
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if2.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdClose(tanxc_if2.tanxc_for);
                }
            }

            public void onAdDislike() {
                tanxc_if.this.tanxc_new.showDislikeView(activity, tanxc_if.this.tanxc_do);
            }

            public void tanxc_do(ITanxFeedAd iTanxFeedAd) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onClick(iTanxFeedAd);
                }
            }

            /* renamed from: tanxc_if */
            public void onAdShow(ITanxFeedAd iTanxFeedAd) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdShow(iTanxFeedAd);
                }
            }
        });
        return this.tanxc_new;
    }

    /* renamed from: tanxc_do */
    public TanxAdView getAdView() {
        return getAdView((Activity) this.tanxc_int);
    }
}
