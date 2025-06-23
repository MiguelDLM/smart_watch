package com.huawei.hms.ads;

import com.huawei.hms.ads.reward.Reward;
import com.huawei.openalliance.ad.inter.data.RewardItem;

/* loaded from: classes10.dex */
public class cd implements Reward {
    private String Code;
    private int V;

    public cd() {
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public int getAmount() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public String getName() {
        return this.Code;
    }

    public cd(RewardItem rewardItem) {
        if (rewardItem != null) {
            this.Code = rewardItem.Code();
            this.V = rewardItem.V();
        }
    }
}
