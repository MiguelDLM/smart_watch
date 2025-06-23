package com.alimm.tanx.core.ad.ad.feed;

import android.view.View;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;

/* loaded from: classes.dex */
public interface ITanxFeedVideoAdListener<T extends ITanxFeedAd> {
    View onCustomLoadingIcon();

    View onCustomPlayIcon();

    void onError(TanxError tanxError);

    void onProgressUpdate(long j, long j2);

    void onVideoAdPaused(ITanxFeedAd iTanxFeedAd);

    void onVideoAdStartPlay(ITanxFeedAd iTanxFeedAd);

    void onVideoComplete();

    void onVideoError(TanxPlayerError tanxPlayerError);

    void onVideoLoad(ITanxFeedAd iTanxFeedAd);
}
