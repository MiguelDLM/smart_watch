package com.alimm.tanx.core.ad.listener.reward;

import com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener;
import com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.tanxc_for;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxRewardRequest implements ITanxCoreRewardRequest, NotConfused {
    @Override // com.alimm.tanx.core.ad.listener.reward.ITanxCoreRewardRequest
    public void queryRewards(RewardRequestBean rewardRequestBean, Integer num, String str, IRewardRequestListener iRewardRequestListener) {
        RewardVideoAdModel rewardVideoAdModel = new RewardVideoAdModel();
        if (rewardRequestBean != null) {
            rewardRequestBean.buildSessionId(num, str);
        }
        rewardVideoAdModel.sendRewardRequest(rewardRequestBean, iRewardRequestListener);
    }

    @Override // com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest
    public void queryRewards(RewardRequestBean rewardRequestBean, IRewardRequestListener iRewardRequestListener) {
        if (System.currentTimeMillis() - tanxc_for.tanxc_if > tanxc_for.tanxc_do.longValue()) {
            queryRewards(rewardRequestBean, 3, null, iRewardRequestListener);
        } else {
            if (iRewardRequestListener != null) {
                UtErrorCode utErrorCode = UtErrorCode.REWARD_QUERY_FREQUENCY_OVERRUN;
                iRewardRequestListener.onError(new TanxError("", utErrorCode.getIntCode(), utErrorCode.getMsg()));
            }
            LogUtils.d("TanxRewardRequest", "主动查奖频控限制，放弃请求");
        }
        tanxc_for.tanxc_if = System.currentTimeMillis();
    }
}
