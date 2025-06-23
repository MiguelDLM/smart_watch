package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import java.util.List;

public interface ITanxFeedAd extends ITanxAd {

    public interface DislikeOnClickListener {
        void onClick(View view);
    }

    void bindDislikeView(List<View> list, DislikeOnClickListener dislikeOnClickListener);

    void bindFeedAdView(TanxAdView tanxAdView, View view, View view2, ITanxFeedInteractionListener iTanxFeedInteractionListener);

    void bindFeedAdView(TanxAdView tanxAdView, List<View> list, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener);

    void click(TanxAdView tanxAdView);

    ITanxVideoView getITanxVideoView(Context context);
}
