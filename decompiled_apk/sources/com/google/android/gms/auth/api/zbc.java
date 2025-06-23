package com.google.android.gms.auth.api;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;

@Deprecated
/* loaded from: classes9.dex */
public final class zbc {
    protected Boolean zba;

    @Nullable
    protected String zbb;

    public zbc() {
        this.zba = Boolean.FALSE;
    }

    @ShowFirstParty
    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }

    @ShowFirstParty
    public zbc(zbd zbdVar) {
        boolean z;
        String str;
        this.zba = Boolean.FALSE;
        zbd.zbb(zbdVar);
        z = zbdVar.zbc;
        this.zba = Boolean.valueOf(z);
        str = zbdVar.zbd;
        this.zbb = str;
    }
}
