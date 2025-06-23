package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import java.util.List;

public class tanxc_if<T extends ITanxAd> implements ITanxAd {
    /* access modifiers changed from: protected */
    public T tanxc_for;

    public tanxc_if(T t) {
        this.tanxc_for = t;
    }

    public void bindAdView(TanxAdView tanxAdView, List<View> list) {
        this.tanxc_for.bindAdView(tanxAdView, list);
    }

    public void destroy() {
    }

    public TanxAdSlot getAdSlot() {
        return this.tanxc_for.getAdSlot();
    }

    public int getAdType() {
        return com.alimm.tanx.core.utils.tanxc_if.tanxc_do(getBidInfo());
    }

    public BidInfo getBidInfo() {
        return this.tanxc_for.getBidInfo();
    }

    public TanxBiddingInfo getBiddingInfo() {
        return this.tanxc_for.getBiddingInfo();
    }

    public String getRequestId() {
        return this.tanxc_for.getRequestId();
    }

    public String getScene() {
        return "";
    }

    public void onResourceLoadSuccess() {
        this.tanxc_for.onResourceLoadSuccess();
    }

    public void setBiddingResult(TanxBiddingInfo tanxBiddingInfo) {
        this.tanxc_for.setBiddingResult(tanxBiddingInfo);
    }

    public void bindAdView(TanxAdView tanxAdView, List<View> list, ITanxInteractionListener iTanxInteractionListener) {
        this.tanxc_for.bindAdView(tanxAdView, list, iTanxInteractionListener);
    }
}
