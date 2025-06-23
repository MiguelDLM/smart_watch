package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class ConfirmResultRsp {
    private int retcode = -1;

    @AllApi
    public int getRetcode() {
        return this.retcode;
    }

    @AllApi
    public void setRetcode(int i) {
        this.retcode = i;
    }
}
