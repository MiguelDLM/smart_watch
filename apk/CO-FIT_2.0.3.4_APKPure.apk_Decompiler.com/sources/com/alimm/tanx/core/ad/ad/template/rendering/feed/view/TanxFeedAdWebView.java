package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.utils.LogUtils;

public class TanxFeedAdWebView extends TanxFeedAdView {
    private static final String TAG = "TanxFeedAdNativeView";
    private TanxWebFrameLayout tanxWebFrameLayout;

    public TanxFeedAdWebView(Context context) {
        this(context, (AttributeSet) null);
        this.tanxWebFrameLayout = new TanxWebFrameLayout(getContext());
    }

    public void loadAdContent(String str) {
        this.flAdContentRoot.removeAllViews();
        this.flAdContentRoot.addView(this.tanxWebFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.tanxWebFrameLayout.loadAd(this.iTanxFeedAd, true, this);
    }

    public void onMeasure(int i, int i2) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (!(iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || this.iTanxFeedAd.getBidInfo().getTemplateConf() == null)) {
            this.tanxWebFrameLayout.setViewSize(((float) this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebHeight2Int()) / ((float) this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebWidth2Int()));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i), 1073741824), i2);
        LogUtils.d(TAG, "onMeasure-> w:" + View.MeasureSpec.getSize(i) + " h:" + View.MeasureSpec.getSize(i2));
    }

    public TanxFeedAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
