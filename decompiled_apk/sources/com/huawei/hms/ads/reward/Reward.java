package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;

@GlobalApi
/* loaded from: classes10.dex */
public interface Reward {
    public static final Reward DEFAULT = new cd();

    int getAmount();

    String getName();
}
