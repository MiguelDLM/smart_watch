package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class ImpEX implements Serializable {
    private static final long serialVersionUID = 6214247551210205893L;
    private String key;
    private String value;

    public ImpEX() {
    }

    public String Code() {
        return this.key;
    }

    public String V() {
        return this.value;
    }

    public ImpEX(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public void Code(String str) {
        this.key = str;
    }

    public void V(String str) {
        this.value = str;
    }
}
