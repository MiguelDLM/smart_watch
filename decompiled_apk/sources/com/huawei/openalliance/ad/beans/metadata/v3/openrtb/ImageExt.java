package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class ImageExt implements Serializable {
    private static final long serialVersionUID = 9185694573603472901L;
    private int checkSHA256Flag;
    private String format;
    private String sha256;
    private long size;

    public long Code() {
        return this.size;
    }

    public String I() {
        return this.format;
    }

    public String V() {
        return this.sha256;
    }

    public int Z() {
        return this.checkSHA256Flag;
    }

    public void Code(int i) {
        this.checkSHA256Flag = i;
    }

    public void V(String str) {
        this.format = str;
    }

    public void Code(long j) {
        this.size = j;
    }

    public void Code(String str) {
        this.sha256 = str;
    }
}
