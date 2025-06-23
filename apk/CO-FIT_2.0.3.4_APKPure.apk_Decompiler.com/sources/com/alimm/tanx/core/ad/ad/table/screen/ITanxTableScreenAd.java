package com.alimm.tanx.core.ad.ad.table.screen;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;

public interface ITanxTableScreenAd extends ITanxAd {
    void bindTableScreenAdView(TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener);

    void click(String str, String str2);

    void shake();
}
