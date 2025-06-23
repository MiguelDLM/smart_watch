package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.ad.bean.RewardParam;

/* loaded from: classes.dex */
public class tanxc_try {
    public String tanxc_do;
    public String tanxc_for;
    public String tanxc_if;
    public RewardParam tanxc_int;

    public tanxc_try(String str, String str2, String str3, RewardParam rewardParam) {
        this.tanxc_do = str;
        this.tanxc_if = str2;
        this.tanxc_for = str3;
        this.tanxc_int = rewardParam;
    }

    public String toString() {
        return "WaitQueryReward{pid='" + this.tanxc_do + "', mediaUid='" + this.tanxc_if + "', sessionId='" + this.tanxc_for + "', rewardParam=" + this.tanxc_int + '}';
    }

    public tanxc_try() {
    }
}
