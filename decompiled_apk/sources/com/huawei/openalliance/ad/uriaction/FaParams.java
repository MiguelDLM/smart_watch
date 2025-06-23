package com.huawei.openalliance.ad.uriaction;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.aa;

@DataKeep
/* loaded from: classes10.dex */
public class FaParams {
    private String hwChannelId;
    private String prdPkgName;

    public FaParams(String str, String str2) {
        this.prdPkgName = str;
        this.hwChannelId = str2;
    }

    public String Code() {
        return this.hwChannelId;
    }

    public String I() {
        return aa.V(this);
    }

    public String V() {
        return this.prdPkgName;
    }
}
