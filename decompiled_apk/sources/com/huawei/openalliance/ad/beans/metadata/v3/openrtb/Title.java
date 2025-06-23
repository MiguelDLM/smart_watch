package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class Title implements Serializable {
    private static final long serialVersionUID = 3724114949683086810L;
    private int len;
    private String text;

    public String Code() {
        return this.text;
    }

    public int V() {
        return this.len;
    }

    public void Code(int i) {
        this.len = i;
    }

    public void Code(String str) {
        this.text = str;
    }
}
