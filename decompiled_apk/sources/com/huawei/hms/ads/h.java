package com.huawei.hms.ads;

import android.content.Context;
import java.util.List;

/* loaded from: classes10.dex */
public class h {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.l V;

    public h(Context context, com.huawei.openalliance.ad.inter.data.l lVar) {
        this.V = lVar;
        this.I = context;
    }

    public void Code() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n());
        }
    }

    public void V(List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n(), 0, 0, list);
        }
    }

    public void Code(long j, int i) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n(), j, i);
        }
    }

    public void Code(jb jbVar) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n(), jbVar);
        }
    }

    public void Code(String str) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            fb.V("AdEventProcessor", " native ad is empty");
        } else {
            jc.Code(this.I, lVar.n(), 0, 0, (String) null, str);
        }
    }

    public void Code(String str, String str2) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n(), 0, 0, str, str2);
        }
    }

    public void Code(List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            jc.Code(this.I, lVar.n(), 0, 0, list);
        }
    }
}
