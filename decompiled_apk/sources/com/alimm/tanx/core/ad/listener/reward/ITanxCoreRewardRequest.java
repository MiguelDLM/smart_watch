package com.alimm.tanx.core.ad.listener.reward;

import com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;

/* loaded from: classes.dex */
public interface ITanxCoreRewardRequest extends ITanxRewardRequest {
    void queryRewards(RewardRequestBean rewardRequestBean, Integer num, String str, IRewardRequestListener iRewardRequestListener);
}
