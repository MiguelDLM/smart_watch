package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxTableScreenAd, ITanxTableScreenExpressAd> {
    public tanxc_do(Context context, IModel iModel) {
        super(context, iModel);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxTableScreenExpressAd tanxc_do(ITanxTableScreenAd iTanxTableScreenAd) {
        return new tanxc_if(iTanxTableScreenAd);
    }

    public void tanxc_do(List<ITanxTableScreenExpressAd> list, ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    ITanxTableScreenExpressAd iTanxTableScreenExpressAd = list.get(0);
                    if (iTanxTableScreenExpressAd != null && iTanxTableScreenExpressAd.getBidInfo() != null && iTanxTableScreenExpressAd.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(iTanxTableScreenExpressAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                        return;
                    }
                    onAdLoadListener.onError(new TanxError("RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"));
                    return;
                }
            } catch (Exception e) {
                if (onAdLoadListener != null) {
                    onAdLoadListener.onError(new TanxError("缓存try - catch异常: " + LogUtils.getStackTraceMessage(e)));
                    return;
                }
                return;
            }
        }
        onAdLoadListener.onError(new TanxError("RewardPresenter返回广告list为空"));
    }
}
