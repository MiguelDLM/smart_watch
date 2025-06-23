package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.fw;

/* loaded from: classes10.dex */
public abstract class hw<V extends fw> extends fu<V> implements ix<V> {
    protected Context V;

    @Override // com.huawei.hms.ads.ix
    public void Code() {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    public abstract String S();

    @Override // com.huawei.hms.ads.ix
    public void V() {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(long j, long j2, long j3) {
        long j4 = 0;
        if (j == 0 || j >= j3) {
            return;
        }
        long j5 = j3 - j;
        if (j2 != 0 && j2 < j3) {
            j4 = j3 - j2;
        }
        cy.Code(this.V, this.Code, j5, j4);
    }

    @Override // com.huawei.hms.ads.ix
    public void V(long j, long j2, long j3, long j4) {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.C, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(long j, long j2, long j3, long j4) {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }
}
