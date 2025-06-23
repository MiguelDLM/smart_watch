package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* loaded from: classes10.dex */
public class cb implements ca<View> {
    private static final String Code = "cb";
    private com.huawei.openalliance.ad.inter.data.l B;
    private PPSNativeView.e C;
    private View I;
    private Context V;
    private AdContentData Z;

    public cb(Context context, View view) {
        this.V = context;
        Code(view);
    }

    @Override // com.huawei.hms.ads.ca
    public void Code() {
        jc.Code(this.V, this.Z);
    }

    public View I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.ca
    public boolean V() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar == null) {
            return false;
        }
        lVar.Code(true);
        fb.Code(Code, "deal click");
        com.huawei.openalliance.ad.uriaction.p Code2 = com.huawei.openalliance.ad.uriaction.q.Code(this.V, this.Z, this.B.ar());
        boolean Code3 = Code2.Code();
        if (Code3) {
            Code(Code2);
            PPSNativeView.e eVar = this.C;
            if (eVar != null) {
                eVar.V();
                this.C.I();
            }
        }
        return Code3;
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(long j, int i) {
        jc.Code(this.V, this.Z, j, i);
    }

    public final void Code(View view) {
        this.I = view;
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.B = lVar;
        this.Z = lVar != null ? lVar.n() : null;
    }

    private void Code(com.huawei.openalliance.ad.uriaction.p pVar) {
        jc.Code(this.V, this.Z, 0, 0, pVar.I(), com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bc.V(I()));
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(PPSNativeView.e eVar) {
        this.C = eVar;
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        jb.a aVar = new jb.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        }
        String Code2 = com.huawei.openalliance.ad.utils.bc.Code(I());
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar != null) {
            fb.Code(Code, "slotId: %s, contentId: %s, slot pos: %s", lVar.o(), this.B.a(), Code2);
        }
        aVar.Code(l).Code(num).V(num2).B(Code2).Code(jp.Code(I())).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jc.Code(this.V, this.Z, aVar.Code());
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(String str) {
        AdContentData adContentData = this.Z;
        if (adContentData == null) {
            return;
        }
        adContentData.I(str);
    }

    @Override // com.huawei.hms.ads.ca
    public void Code(List<String> list) {
        jc.Code(this.V, this.Z, 0, 0, list);
    }
}
