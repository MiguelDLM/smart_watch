package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.listener.model.IModel;

public class tanxc_do extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxFeedAd, ITanxFeedExpressAd> {
    private final tanxc_for tanxc_for = new tanxc_for();

    public tanxc_do(Context context, IModel iModel) {
        super(context, iModel);
    }

    public ITanxFeedExpressAd tanxc_do(ITanxFeedAd iTanxFeedAd) {
        return new tanxc_if(this.tanxc_do, iTanxFeedAd, this.tanxc_for);
    }
}
