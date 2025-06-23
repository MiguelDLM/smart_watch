package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.base.tanxc_do;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_new;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TanxSplashAd extends tanxc_do implements ITanxSplashAd, NotConfused {
    /* access modifiers changed from: private */
    public int closeType = 0;
    public int fromType;

    public TanxSplashAd(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, int i, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.fromType = i;
    }

    public void bindSplashAdView(final TanxAdView tanxAdView, View view, View view2, final ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindSplashAdView", AdUtConstants.INTO_METHOD);
        this.tanxInteractionListener = iTanxSplashInteractionListener;
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new tanxc_new(tanxAdView, new ITanxExposureCallback() {
                public void exposure() {
                    boolean unused = TanxSplashAd.this.isReadyExposure = true;
                    TanxSplashAd.this.doImpExposure();
                }

                public void exposureTime(long j) {
                }

                public void onMonitor(Map<String, Object> map) {
                    TanxAdSlot access$200 = TanxSplashAd.this.adSlot;
                    String access$300 = TanxSplashAd.this.reqId;
                    String templateId = TanxSplashAd.this.bidInfo.getTemplateId();
                    String creativeId = TanxSplashAd.this.bidInfo.getCreativeId();
                    TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                    TanxMonitorUt.sendSplashMonitor(access$200, access$300, templateId, creativeId, tanxSplashAd.fromType, tanxSplashAd.closeType, map, TanxSplashAd.this.bidInfo.getSessionId());
                }
            }));
        }
        if (view != null) {
            view.setOnClickListener(new ViewClickListener() {
                public void viewClick(View view) {
                    TanxSplashAd.this.click(tanxAdView, (String) null, (String) null);
                }
            });
        }
        if (view2 != null) {
            view2.setOnClickListener(new ViewClickListener() {
                public void viewClick(View view) {
                    ITanxSplashInteractionListener iTanxSplashInteractionListener = iTanxSplashInteractionListener;
                    if (iTanxSplashInteractionListener != null) {
                        iTanxSplashInteractionListener.onAdClose();
                    }
                    int unused = TanxSplashAd.this.closeType = 2;
                    InteractionUpload instance = InteractionUpload.getInstance();
                    List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
                    InteractionUpload.getInstance();
                    instance.uploadInteraction(eventTrack, 3);
                    TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                    TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
                }
            });
        }
    }

    public void click(TanxAdView tanxAdView, String str, String str2) {
        if (tanxAdView != null) {
            navigateAndUt(tanxAdView, tanxAdView.getContext(), false, str, str2);
            return;
        }
        LogUtils.e("TanxSplashAd", "adView点击时为空");
    }

    public void clickUpload() {
        ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
    }

    public void destroy() {
        super.destroy();
    }

    public AdUtConstants getAdClickUtKey() {
        return AdUtConstants.SCREEN_VIEW_CLICK;
    }

    public AdUtConstants getAdShakeUtKey() {
        return AdUtConstants.SHAKE_NAVIGATE;
    }

    public BidInfo getBidInfo() {
        if (super.getBidInfo() != null) {
            return super.getBidInfo().removeSensitiveData();
        }
        return null;
    }

    public void navigateAndUt(TanxAdView tanxAdView, Context context, boolean z, String str, String str2) {
        ITanxInteractionListener iTanxInteractionListener;
        try {
            if (this.adClickInfo == null) {
                if (z) {
                    this.closeType = 3;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdShakeUtKey(), str, str2);
                } else {
                    this.closeType = 1;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey(), str, str2);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TanxSplashUt.FROM_TYPE, String.valueOf(this.fromType));
            this.adClickInfo.setUtArgs(hashMap);
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            if (!z && (iTanxInteractionListener = this.tanxInteractionListener) != null) {
                iTanxInteractionListener.onAdClicked(tanxAdView, this);
            }
            clickUpload();
        } catch (Exception e) {
            LogUtils.e(e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "TanxSplashAd", LogUtils.getStackTraceMessage(e), "");
        }
    }
}
