package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_if;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.PlayerListManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements ITanxFeedAd {
    /* access modifiers changed from: private */
    public ITanxFeedInteractionListener tanxc_do;
    private FeedVideoManager tanxc_for;
    private com.alimm.tanx.core.view.feed.tanxc_do tanxc_if;

    public tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
    }

    public void bindDislikeView(List<View> list, ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        if (list != null) {
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(new TanxFeedAd$3(this, list, dislikeOnClickListener));
            }
        }
    }

    public void bindFeedAdView(TanxAdView tanxAdView, List<View> list, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, getAdSlot().isExpressRender() ? "bindTemplateFeedAdView" : "bindFeedAdView", AdUtConstants.INTO_METHOD, (Map<String, String>) null);
        tanxc_do(tanxAdView, list, view, iTanxFeedInteractionListener);
    }

    public void click(TanxAdView tanxAdView) {
        super.doClickExposure(tanxAdView);
    }

    public void destroy() {
        LogUtils.d("TanxFeedAd", "媒体调用destroy（）");
        PlayerListManager.getInstance().clearThis((ITanxAd) this);
        super.destroy();
        FeedVideoManager feedVideoManager = this.tanxc_for;
        if (feedVideoManager != null) {
            feedVideoManager.destroy();
        }
    }

    public AdUtConstants getAdClickUtKey() {
        if (getBidInfo().getInteractType2FeedSlide()) {
            return AdUtConstants.FLOW_VIEW_INTERACTION_CLICK;
        }
        return AdUtConstants.FLOW_VIEW_CLICK;
    }

    public int getAdType() {
        return super.getAdType();
    }

    public BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    public ITanxVideoView getITanxVideoView(Context context) {
        if (this.tanxc_if == null) {
            this.tanxc_if = new com.alimm.tanx.core.view.feed.tanxc_do();
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new FeedVideoManager(this, this.tanxc_if, context);
            PlayerListManager.getInstance().putFeedVideoManager(this, this.tanxc_for);
        }
        return this.tanxc_for;
    }

    private void tanxc_do(TanxAdView tanxAdView, List<View> list, View view, final ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("adView:");
        String str = "不为空";
        sb.append(tanxAdView == null ? "null" : str);
        sb.append("iTanxFeedInteractionListener:");
        if (iTanxFeedInteractionListener == null) {
            str = "null";
        }
        sb.append(str);
        LogUtils.d("bindView", sb.toString());
        super.bindAdView(tanxAdView, list, iTanxFeedInteractionListener);
        this.tanxc_do = iTanxFeedInteractionListener;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (iTanxFeedInteractionListener == null) {
                        return;
                    }
                    if (tanxc_do.this.getAdSlot() == null || tanxc_do.this.getAdSlot().isFeedBackDialog()) {
                        iTanxFeedInteractionListener.onAdDislike();
                        return;
                    }
                    iTanxFeedInteractionListener.onAdClose();
                    InteractionUpload instance = InteractionUpload.getInstance();
                    List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                    InteractionUpload.getInstance();
                    instance.uploadInteraction(eventTrack, 3);
                    TanxFeedUt.utClose(tanxc_do.this, 2);
                }
            });
        }
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new tanxc_if(tanxAdView, new ITanxExposureCallback() {
                public void exposure() {
                    boolean unused = tanxc_do.this.isReadyExposure = true;
                    tanxc_do.this.doImpExposure();
                }

                public void exposureTime(long j) {
                }

                public void onMonitor(Map<String, Object> map) {
                    TanxMonitorUt.sendFeedMonitor(tanxc_do.this.adSlot, tanxc_do.this.reqId, tanxc_do.this.bidInfo.getTemplateId(), tanxc_do.this.bidInfo.getCreativeId(), map, tanxc_do.this.bidInfo.getSessionId());
                }
            }));
        }
    }

    public void bindFeedAdView(TanxAdView tanxAdView, View view, View view2, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        ArrayList arrayList = new ArrayList();
        if (view != null) {
            arrayList.add(view);
        }
        bindFeedAdView(tanxAdView, (List<View>) arrayList, view2, iTanxFeedInteractionListener);
    }
}
