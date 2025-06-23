package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.DislikeAdReason;

/* loaded from: classes10.dex */
public class bw implements DislikeAdReason {
    private String Code;

    public bw(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.nativead.DislikeAdReason
    public String getDescription() {
        return this.Code;
    }
}
