package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_if<T extends ITanxAd> implements ITanxAd {
    protected T tanxc_for;

    public tanxc_if(T t) {
        this.tanxc_for = t;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(TanxAdView tanxAdView, List<View> list) {
        this.tanxc_for.bindAdView(tanxAdView, list);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public TanxAdSlot getAdSlot() {
        return this.tanxc_for.getAdSlot();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return com.alimm.tanx.core.utils.tanxc_if.tanxc_do(getBidInfo());
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return this.tanxc_for.getBidInfo();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public TanxBiddingInfo getBiddingInfo() {
        return this.tanxc_for.getBiddingInfo();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public String getRequestId() {
        return this.tanxc_for.getRequestId();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return "";
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void onResourceLoadSuccess() {
        this.tanxc_for.onResourceLoadSuccess();
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public void setBiddingResult(TanxBiddingInfo tanxBiddingInfo) {
        this.tanxc_for.setBiddingResult(tanxBiddingInfo);
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(TanxAdView tanxAdView, List<View> list, ITanxInteractionListener iTanxInteractionListener) {
        this.tanxc_for.bindAdView(tanxAdView, list, iTanxInteractionListener);
    }
}
