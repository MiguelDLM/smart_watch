package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: classes10.dex */
public class dc extends db {
    private ed Code;

    public dc(Context context) {
        this.Code = ed.Code(context);
    }

    @Override // com.huawei.hms.ads.db
    public boolean Code() {
        if (this.Code.h() >= com.huawei.openalliance.ad.utils.w.Code()) {
            return true;
        }
        return V();
    }
}
