package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class JsbCallBackData<T> {
    private String callBackName;
    private boolean complete;
    private T data;

    public JsbCallBackData(T t, boolean z, String str) {
        this.complete = z;
        this.data = t;
        this.callBackName = str;
    }

    public boolean Code() {
        return this.complete;
    }

    public String I() {
        return this.callBackName;
    }

    public T V() {
        return this.data;
    }
}
