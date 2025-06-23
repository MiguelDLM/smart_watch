package com.huawei.hms.ads;

import java.util.concurrent.Callable;

/* loaded from: classes10.dex */
public class hy extends ij {
    public hy(ed edVar, ky kyVar) {
        super(edVar, kyVar);
    }

    @Override // com.huawei.hms.ads.ij
    public void V() {
        long longValue = ((Long) com.huawei.openalliance.ad.utils.ba.Code(new Callable<Long>() { // from class: com.huawei.hms.ads.hy.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Long call() {
                return Long.valueOf(hy.this.Code.b());
            }
        }, 300L)).longValue();
        int intValue = ((Integer) com.huawei.openalliance.ad.utils.ba.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.hy.2
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(hy.this.Code.a());
            }
        }, 2000)).intValue();
        V(longValue);
        Code(intValue);
    }
}
