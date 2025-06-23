package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class RewardParam extends BaseBean implements NotConfused {
    private boolean autoQuerySwitch;
    private boolean queryHistoryRewards;
    private boolean rewardVerification;

    public RewardParam() {
        this.autoQuerySwitch = true;
        this.queryHistoryRewards = true;
        this.rewardVerification = true;
    }

    public boolean isAutoQuerySwitch() {
        return this.autoQuerySwitch;
    }

    public boolean isQueryHistoryRewards() {
        return this.queryHistoryRewards;
    }

    public boolean isRewardVerification() {
        return this.rewardVerification;
    }

    public void setAutoQuerySwitch(boolean z) {
        this.autoQuerySwitch = z;
    }

    public void setQueryHistoryRewards(boolean z) {
        this.queryHistoryRewards = z;
    }

    public void setRewardVerification(boolean z) {
        this.rewardVerification = z;
    }

    public RewardParam(boolean z, boolean z2) {
        this.autoQuerySwitch = true;
        this.queryHistoryRewards = z;
        this.rewardVerification = z2;
    }

    public RewardParam(boolean z, boolean z2, boolean z3) {
        this.autoQuerySwitch = z;
        this.queryHistoryRewards = z2;
        this.rewardVerification = z3;
    }
}
