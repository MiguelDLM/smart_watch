package com.alimm.tanx.core.ad.ad.table.screen;

import android.content.Context;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_try;
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
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements ITanxTableScreenAd {
    TanxAdView tanxc_do;
    private int tanxc_if;

    public tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.tanxc_if = 0;
    }

    @Override // com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd
    public void bindTableScreenAdView(TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindRewardVideoAdView", AdUtConstants.INTO_METHOD);
        this.tanxc_do = tanxAdView;
        this.tanxInteractionListener = iTanxInteractionListener;
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new tanxc_try(tanxAdView, new ITanxExposureCallback() { // from class: com.alimm.tanx.core.ad.ad.table.screen.tanxc_do.1
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
            }, this.adSlot.getAdType()));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd
    public void click(String str, String str2) {
        tanxc_do(this.tanxc_do.getContext(), str, str2, false);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public AdUtConstants getAdClickUtKey() {
        return AdUtConstants.TABLE_SCREEN_CLICK;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        if (super.getBidInfo() != null) {
            return super.getBidInfo().removeSensitiveData();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd
    public void shake() {
        tanxc_do(this.tanxc_do.getContext(), null, null, true);
    }

    public void tanxc_do(Context context, String str, String str2, boolean z) {
        try {
            if (this.adClickInfo == null) {
                this.tanxc_if = 1;
                this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, z ? AdUtConstants.SHAKE_NAVIGATE : getAdClickUtKey(), str, str2);
            }
            this.adClickInfo.setAdUtConstants(z ? AdUtConstants.SHAKE_NAVIGATE : getAdClickUtKey());
            this.adClickInfo.setUtArgs(new HashMap());
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            ITanxInteractionListener iTanxInteractionListener = this.tanxInteractionListener;
            if (iTanxInteractionListener != null) {
                iTanxInteractionListener.onAdClicked(this.tanxc_do, this);
            }
            ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
        } catch (Exception e) {
            LogUtils.e(e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "TanxTableScreenAd", LogUtils.getStackTraceMessage(e), "");
        }
    }
}
