package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.jl;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public abstract class p {
    protected jl B;
    private String Code = null;
    protected Context I;
    private p V;
    protected AdContentData Z;

    public p() {
    }

    public void Code(jl jlVar) {
        this.B = jlVar;
    }

    public abstract boolean Code();

    public String I() {
        p pVar;
        String str = this.Code;
        return (str != null || (pVar = this.V) == null) ? str : pVar.I();
    }

    public boolean V() {
        p pVar = this.V;
        if (pVar != null) {
            return pVar.Code();
        }
        return false;
    }

    public p(Context context, AdContentData adContentData) {
        this.I = context;
        this.Z = adContentData;
    }

    public void Code(p pVar) {
        this.V = pVar;
    }

    public void Code(String str) {
        this.Code = str;
    }
}
