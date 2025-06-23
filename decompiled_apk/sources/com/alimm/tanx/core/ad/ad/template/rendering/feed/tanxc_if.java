package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
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

/* loaded from: classes.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxFeedAd> implements ITanxFeedExpressAd, ITanxFeedCacheContext {
    ITanxFeedExpressAd.OnFeedAdListener tanxc_do;
    tanxc_for tanxc_if;
    private final Context tanxc_int;
    private TanxFeedAdView tanxc_new;

    public tanxc_if(Context context, ITanxFeedAd iTanxFeedAd, tanxc_for tanxc_forVar) {
        super(iTanxFeedAd);
        this.tanxc_int = context;
        this.tanxc_if = tanxc_forVar;
    }

    private boolean tanxc_for() {
        T t = this.tanxc_for;
        if (t != 0 && ((ITanxFeedAd) t).getBidInfo() != null && ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId())) {
            return AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID.equals(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId());
        }
        return false;
    }

    private boolean tanxc_int() {
        T t = this.tanxc_for;
        if (t == 0 || ((ITanxFeedAd) t).getBidInfo() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getWebType2Int() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        LogUtils.d("TanxFeedExpressAd", "媒体调用destroy（）");
        super.destroy();
        this.tanxc_do = null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        if (tanxFeedAdView != null) {
            tanxFeedAdView.loadAdStyle();
        }
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public View remove() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        this.tanxc_new = null;
        return tanxFeedAdView;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd
    public void setOnFeedAdListener(ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.tanxc_do = onFeedAdListener;
    }

    private boolean tanxc_if() {
        T t = this.tanxc_for;
        if (t == 0 || ((ITanxFeedAd) t).getBidInfo() == null) {
            return false;
        }
        return ((ITanxFeedAd) this.tanxc_for).getBidInfo().getInteractType2FeedSlide();
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView(final Activity activity) {
        if (tanxc_for() && tanxc_int()) {
            this.tanxc_new = this.tanxc_if.tanxc_for(this, activity);
        } else if (tanxc_if()) {
            this.tanxc_new = this.tanxc_if.tanxc_if(this, activity);
        } else {
            this.tanxc_new = this.tanxc_if.tanxc_do(this, activity);
        }
        this.tanxc_new.setTanxFeedAd((ITanxFeedAd) this.tanxc_for, this.tanxc_do);
        ITanxFeedAd iTanxFeedAd = (ITanxFeedAd) this.tanxc_for;
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        iTanxFeedAd.bindFeedAdView(tanxFeedAdView, tanxFeedAdView, tanxFeedAdView.getCloseView(), new ITanxFeedInteractionListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.1
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxFeedAd iTanxFeedAd2) {
                tanxc_do(iTanxFeedAd2);
            }

            @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
            public void onAdClose() {
                tanxc_if tanxc_ifVar = tanxc_if.this;
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_ifVar.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdClose(((com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if) tanxc_ifVar).tanxc_for);
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
            public void onAdDislike() {
                tanxc_if.this.tanxc_new.showDislikeView(activity, tanxc_if.this.tanxc_do);
            }

            public void tanxc_do(ITanxFeedAd iTanxFeedAd2) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onClick(iTanxFeedAd2);
                }
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxFeedAd iTanxFeedAd2) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdShow(iTanxFeedAd2);
                }
            }
        });
        return this.tanxc_new;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        return getAdView((Activity) this.tanxc_int);
    }
}
