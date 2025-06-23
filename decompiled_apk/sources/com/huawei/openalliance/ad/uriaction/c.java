package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class c extends p {
    private static final String Code = "AppEnterAction";

    public c(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        boolean z;
        ApkInfo e;
        fb.V(Code, "handle app enter action");
        MetaData S = this.Z.S();
        if (S == null || (e = S.e()) == null) {
            z = false;
        } else {
            String Code2 = e.Code();
            jn.a aVar = new jn.a();
            aVar.Code(e).Code(this.Z);
            z = com.huawei.openalliance.ad.utils.g.Code(this.I, Code2, aVar.Code());
        }
        if (!z) {
            return V();
        }
        Code("app");
        jc.Code(this.I, this.Z, (Integer) 1);
        return true;
    }
}
