package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class BaseAdReqParam {
    private long adLoadStartTime;

    public long Code() {
        return this.adLoadStartTime;
    }

    public void Code(long j) {
        this.adLoadStartTime = j;
    }
}
