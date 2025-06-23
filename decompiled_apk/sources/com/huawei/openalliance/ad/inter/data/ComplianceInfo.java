package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class ComplianceInfo {
    private String key;
    private Integer seq;
    private String value;

    public String Code() {
        return this.value;
    }
}
