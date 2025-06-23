package com.alimm.tanx.core.ad.ad.feed;

import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;

/* loaded from: classes.dex */
public interface ITanxFeedInteractionListener extends ITanxInteractionListener<ITanxFeedAd> {
    void onAdClose();

    void onAdDislike();
}
