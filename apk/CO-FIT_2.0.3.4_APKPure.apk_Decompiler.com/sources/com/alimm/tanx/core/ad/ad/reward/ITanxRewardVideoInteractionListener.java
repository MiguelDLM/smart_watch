package com.alimm.tanx.core.ad.ad.reward;

import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import java.util.Map;

public interface ITanxRewardVideoInteractionListener extends ITanxInteractionListener<ITanxRewardVideoAd> {
    void onAdClose();

    void onError(TanxError tanxError);

    void onRewardArrived(boolean z, int i, Map<String, Object> map);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError(TanxPlayerError tanxPlayerError);
}
