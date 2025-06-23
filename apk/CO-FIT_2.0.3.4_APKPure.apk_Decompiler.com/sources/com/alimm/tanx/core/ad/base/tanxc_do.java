package com.alimm.tanx.core.ad.base;

import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeCallback;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.expose.tanxc_if;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.loader.NewTanxAdLoader;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdLoadType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class tanxc_do implements ITanxAd {
    protected AdClickInfo adClickInfo;
    /* access modifiers changed from: protected */
    public TanxAdSlot adSlot;
    /* access modifiers changed from: protected */
    public BidInfo bidInfo;
    protected ExposeCallback clickExposeCallback;
    private List<tanxc_if> clickList;
    protected boolean hasExposure;
    protected ExposeCallback impExposeCallback;
    private List<tanxc_if> impList;
    /* access modifiers changed from: protected */
    public boolean isReadyExposure;
    protected boolean isResourceLoadSuccess = true;
    protected Boolean lastIsReadyExposure = null;
    protected Boolean lastIsResourceLoadSuccess = null;
    private TanxBiddingInfo mBiddingInfo;
    /* access modifiers changed from: protected */
    public String reqId;
    public String scene;
    protected ITanxInteractionListener tanxInteractionListener;

    public tanxc_do(final TanxAdSlot tanxAdSlot, BidInfo bidInfo2, final String str, String str2) {
        this.scene = str2;
        this.adSlot = tanxAdSlot;
        this.bidInfo = bidInfo2;
        this.reqId = str;
        if (tanxAdSlot.isExpressRender()) {
            this.isResourceLoadSuccess = false;
        }
        this.impExposeCallback = new ExposeCallback() {
            public void onFail(int i, String str, String str2) {
                TanxCommonUt.sendExposureFail(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str2, i, str);
            }

            public void onSucceed(int i, String str) {
                TanxCommonUt.sendExposureSuc(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str);
            }

            public void send(String str) {
            }
        };
        this.clickExposeCallback = new ExposeCallback() {
            public void onFail(int i, String str, String str2) {
                TanxCommonUt.sendClickExposureFail(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str2, i, str);
            }

            public void onSucceed(int i, String str) {
                TanxCommonUt.sendClickExposureSuc(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str);
            }

            public void send(String str) {
            }
        };
    }

    private void adExposeDeleteAndPreLoad() {
        if (this.adSlot != null) {
            com.alimm.tanx.core.common.tanxc_do.tanxc_do(new oIX0oI(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adExposeDeleteAndPreLoad$3() {
        try {
            if (this.adSlot.getAdType() == 1 && !TextUtils.isEmpty(this.adSlot.getPid())) {
                FileUtils.delete(SplashAdCacheManager.getSplashAdResponseFile(TanxCoreSdk.getApplication(), this.adSlot.getPid()));
            }
            if (this.adSlot.getLoadType() != null && this.adSlot.getLoadType().equals(TanxAdLoadType.PRELOAD)) {
                if (this.adSlot.getAdType() == 1) {
                    new NewTanxAdLoader(TanxCoreSdk.getApplication()).preloadSplashAd(this.adSlot);
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), e);
        }
    }

    public void bindAdView(TanxAdView tanxAdView, List<View> list) {
        bindAdView(tanxAdView, list, (ITanxInteractionListener) null);
    }

    public void destroy() {
        this.tanxInteractionListener = null;
        this.impExposeCallback = null;
        this.clickExposeCallback = null;
    }

    public void doClickExposure(TanxAdView tanxAdView) {
        if (this.adClickInfo == null) {
            this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey());
        }
        com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(tanxAdView.getContext(), this.adClickInfo, true);
        if (this.tanxInteractionListener != null) {
            LogUtils.d("TanxSDK-DoClick", "媒体侧点击回调 reqId:" + this.reqId);
            this.tanxInteractionListener.onAdClicked(tanxAdView, this);
        }
        ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
    }

    public void doImpExposure() {
        int adType = getAdSlot().getAdType();
        LogUtils.d("doImpExposure", "fromType:" + TanxAdType.getAdTypeStr(adType) + " isReadyExposure:" + this.isReadyExposure + " isResourceLoadSuccess:" + this.isResourceLoadSuccess);
        if (!this.hasExposure) {
            Boolean bool = this.lastIsReadyExposure;
            if (bool == null || this.lastIsResourceLoadSuccess == null || bool.booleanValue() != this.isReadyExposure || this.lastIsResourceLoadSuccess.booleanValue() != this.isResourceLoadSuccess) {
                HashMap hashMap = new HashMap();
                hashMap.put("isReadyExposure", this.isReadyExposure + "");
                hashMap.put("isResourceLoadSuccess", this.isResourceLoadSuccess + "");
                TanxAdSlot tanxAdSlot = this.adSlot;
                String str = this.reqId;
                BidInfo bidInfo2 = this.bidInfo;
                TanxCommonUt.sendIntoMethod(tanxAdSlot, str, bidInfo2, TanxAdType.getAdTypeStr(adType) + " - doImpExposure", AdUtConstants.INTO_METHOD, hashMap);
                this.lastIsReadyExposure = Boolean.valueOf(this.isReadyExposure);
                this.lastIsResourceLoadSuccess = Boolean.valueOf(this.isResourceLoadSuccess);
            } else {
                LogUtils.d("doImpExposure", "防止重复埋点");
            }
        }
        if (this.isReadyExposure && this.isResourceLoadSuccess) {
            if (!this.hasExposure) {
                LogUtils.d("TanxSDK-DoImpExposure", "达到曝光条件埋点..  reqId：" + getRequestId());
                TanxCommonUt.sendStartImp(this.adSlot, this.reqId, this.bidInfo, adType);
            }
            if (this.tanxInteractionListener != null && !this.hasExposure) {
                LogUtils.d("TanxSDK-DoImpExposure", "媒体侧曝光回调  reqId：" + getRequestId());
                this.tanxInteractionListener.onAdShow(this);
                adExposeDeleteAndPreLoad();
            }
            if (!this.hasExposure) {
                ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.EXPOSE, getMonitorList("imp"), this.impExposeCallback);
                this.hasExposure = true;
            }
        }
    }

    public abstract AdUtConstants getAdClickUtKey();

    public TanxAdSlot getAdSlot() {
        return this.adSlot;
    }

    public int getAdType() {
        return com.alimm.tanx.core.utils.tanxc_if.tanxc_do(this.bidInfo);
    }

    public BidInfo getBidInfo() {
        return this.bidInfo;
    }

    public TanxBiddingInfo getBiddingInfo() {
        if (this.mBiddingInfo == null) {
            TanxBiddingInfo tanxBiddingInfo = new TanxBiddingInfo();
            this.mBiddingInfo = tanxBiddingInfo;
            tanxBiddingInfo.setAdPrice(this.bidInfo.getBidPrice());
        }
        return this.mBiddingInfo;
    }

    public List<tanxc_if> getMonitorList(String str) {
        if ("click".equals(str)) {
            if (this.clickList == null) {
                this.clickList = new ArrayList();
                BidInfo bidInfo2 = this.bidInfo;
                if (!(bidInfo2 == null || bidInfo2.getMonitorBean() == null || this.bidInfo.getMonitorBean().getClickTrackUrl() == null)) {
                    for (String tanxc_if : this.bidInfo.getMonitorBean().getClickTrackUrl()) {
                        this.clickList.add(new tanxc_if(tanxc_if, str, false));
                    }
                }
            }
            return this.clickList;
        } else if (!"imp".equals(str)) {
            return null;
        } else {
            if (this.impList == null) {
                this.impList = new ArrayList();
                BidInfo bidInfo3 = this.bidInfo;
                if (!(bidInfo3 == null || bidInfo3.getMonitorBean() == null || this.bidInfo.getMonitorBean().getImpTrackUrl() == null)) {
                    for (String tanxc_if2 : this.bidInfo.getMonitorBean().getImpTrackUrl()) {
                        this.impList.add(new tanxc_if(tanxc_if2, str, true));
                    }
                }
            }
            return this.impList;
        }
    }

    public String getRequestId() {
        return this.reqId;
    }

    public String getScene() {
        return this.scene;
    }

    public void onResourceLoadSuccess() {
        this.isResourceLoadSuccess = true;
        doImpExposure();
    }

    public void setBidInfo(BidInfo bidInfo2) {
        this.bidInfo = bidInfo2;
    }

    public void setBiddingResult(TanxBiddingInfo tanxBiddingInfo) {
        this.mBiddingInfo = tanxBiddingInfo;
    }

    public void bindAdView(TanxAdView tanxAdView, List<View> list, ITanxInteractionListener iTanxInteractionListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("bindAdView->adView:");
        String str = "不为空";
        sb.append(tanxAdView == null ? "null" : str);
        sb.append("interactionListener:");
        if (iTanxInteractionListener == null) {
            str = "null";
        }
        sb.append(str);
        LogUtils.d("bindView", sb.toString());
        if (tanxAdView != null) {
            this.tanxInteractionListener = iTanxInteractionListener;
            if (list == null || list.size() <= 0) {
                tanxAdView.setOnClickListener(new BaseTanxAd$3(this, tanxAdView));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOnClickListener(new BaseTanxAd$4(this, tanxAdView));
            }
        }
    }
}
