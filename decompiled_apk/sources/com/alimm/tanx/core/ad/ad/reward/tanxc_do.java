package com.alimm.tanx.core.ad.ad.reward;

import android.content.Context;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_int;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements ITanxRewardVideoAd {
    TanxAdView tanxc_do;
    private int tanxc_if;

    public tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.tanxc_if = 0;
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void bindRewardVideoAdView(TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener) {
        String str;
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindRewardVideoAdView", AdUtConstants.INTO_METHOD);
        this.tanxc_do = tanxAdView;
        this.tanxInteractionListener = iTanxInteractionListener;
        if (tanxAdView != null) {
            try {
                str = getBidInfo().getTemplateConf().getPidStyleId();
            } catch (Exception e) {
                LogUtils.e(e);
                str = "";
            }
            tanxAdView.setAdMonitor(new tanxc_int(tanxAdView, new ITanxExposureCallback() { // from class: com.alimm.tanx.core.ad.ad.reward.tanxc_do.1
                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                    ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).isReadyExposure = true;
                    tanxc_do.this.doImpExposure();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                }
            }, this.adSlot.getAdType(), str));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void click(String str, String str2) {
        tanxc_do(this.tanxc_do.getContext(), str, str2);
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd
    public void clickUpload() {
        ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public AdUtConstants getAdClickUtKey() {
        return AdUtConstants.REWARD_VIDEO_NAVIGATE;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    public void tanxc_do(Context context, String str, String str2) {
        try {
            this.tanxc_if = 1;
            this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey(), str, str2);
            this.adClickInfo.setUtArgs(new HashMap());
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            ITanxInteractionListener iTanxInteractionListener = this.tanxInteractionListener;
            if (iTanxInteractionListener != null) {
                iTanxInteractionListener.onAdClicked(this.tanxc_do, this);
            }
            clickUpload();
        } catch (Exception e) {
            LogUtils.e(e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "TanxRewardVideoAd", LogUtils.getStackTraceMessage(e), "");
        }
    }
}
