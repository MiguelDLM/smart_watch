package com.alimm.tanx.core.ad.ad.feed;

import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;

public interface ITanxFeedInteractionListener extends ITanxInteractionListener<ITanxFeedAd> {
    void onAdClose();

    void onAdDislike();
}
