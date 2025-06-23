package com.alimm.tanx.core.ad.ad.template.rendering.presenter;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.request.TanxAdSlot;

public interface IPresenter<F extends ITanxAd> {
    IPresenter destroy();

    IPresenter request(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener);

    IPresenter request(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j);
}
