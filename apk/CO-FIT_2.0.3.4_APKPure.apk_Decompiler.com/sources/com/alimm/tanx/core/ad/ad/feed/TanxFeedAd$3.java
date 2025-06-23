package com.alimm.tanx.core.ad.ad.feed;

import android.view.View;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import java.util.List;

public class TanxFeedAd$3 extends ViewClickListener {
    final /* synthetic */ tanxc_do this$0;
    final /* synthetic */ List val$dislikeList;
    final /* synthetic */ ITanxFeedAd.DislikeOnClickListener val$dislikeOnClickListener;

    public TanxFeedAd$3(tanxc_do tanxc_do, List list, ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        this.this$0 = tanxc_do;
        this.val$dislikeList = list;
        this.val$dislikeOnClickListener = dislikeOnClickListener;
    }

    public void viewClick(View view) {
        if (this.this$0.tanxc_do != null) {
            this.this$0.tanxc_do.onAdClose();
            if (this.val$dislikeList.size() > 1) {
                if (this.val$dislikeList.get(0) == view) {
                    InteractionUpload instance = InteractionUpload.getInstance();
                    List<NewTrackItem> eventTrack = this.this$0.getBidInfo().getEventTrack();
                    InteractionUpload.getInstance();
                    instance.uploadInteraction(eventTrack, 4);
                    TanxFeedUt.utClose(this.this$0, 0);
                } else {
                    InteractionUpload instance2 = InteractionUpload.getInstance();
                    List<NewTrackItem> eventTrack2 = this.this$0.getBidInfo().getEventTrack();
                    InteractionUpload.getInstance();
                    instance2.uploadInteraction(eventTrack2, 5);
                    TanxFeedUt.utClose(this.this$0, 1);
                }
            }
        }
        ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener = this.val$dislikeOnClickListener;
        if (dislikeOnClickListener != null) {
            dislikeOnClickListener.onClick(view);
        }
    }
}
