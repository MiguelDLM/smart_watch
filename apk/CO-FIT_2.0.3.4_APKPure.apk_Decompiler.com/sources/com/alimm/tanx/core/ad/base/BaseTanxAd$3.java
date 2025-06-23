package com.alimm.tanx.core.ad.base;

import android.view.View;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.view.TanxAdView;

public class BaseTanxAd$3 extends ViewClickListener {
    final /* synthetic */ tanxc_do this$0;
    final /* synthetic */ TanxAdView val$adView;

    public BaseTanxAd$3(tanxc_do tanxc_do, TanxAdView tanxAdView) {
        this.this$0 = tanxc_do;
        this.val$adView = tanxAdView;
    }

    public void viewClick(View view) {
        this.this$0.doClickExposure(this.val$adView);
    }
}
