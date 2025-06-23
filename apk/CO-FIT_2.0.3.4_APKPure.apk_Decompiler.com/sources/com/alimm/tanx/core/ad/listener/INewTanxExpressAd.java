package com.alimm.tanx.core.ad.listener;

import android.app.Activity;
import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;

public interface INewTanxExpressAd extends ITanxAd {
    View getAdView();

    View getAdView(Activity activity);

    void refresh();
}
