package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class Data implements Serializable {
    private static final long serialVersionUID = 4120218934780835998L;
    private int len;
    private int type;
    private String value;

    public int Code() {
        return this.type;
    }

    public int I() {
        return this.len;
    }

    public String V() {
        return this.value;
    }

    public void Code(int i) {
        this.type = i;
    }

    public void V(int i) {
        this.len = i;
    }

    public void Code(String str) {
        this.value = str;
    }
}
