package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class ApiStatisticsRsp {
    private int retcode = -1;

    public int Code() {
        return this.retcode;
    }

    public void Code(int i) {
        this.retcode = i;
    }
}
