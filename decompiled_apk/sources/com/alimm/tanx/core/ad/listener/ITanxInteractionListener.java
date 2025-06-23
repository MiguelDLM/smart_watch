package com.alimm.tanx.core.ad.listener;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: classes.dex */
public interface ITanxInteractionListener<T extends ITanxAd> {
    void onAdClicked(TanxAdView tanxAdView, T t);

    void onAdShow(T t);
}
