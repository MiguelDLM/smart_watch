package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.huawei.hms.ads.if, reason: invalid class name */
/* loaded from: classes10.dex */
public class Cif extends fu<kj> implements is<kj> {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n Z;

    public Cif(Context context, kj kjVar) {
        this.I = context;
        Code((Cif) kjVar);
    }

    @Override // com.huawei.hms.ads.is
    public void Code() {
        jc.Code(this.I, this.Code, 0, 0, (List<String>) null);
    }

    @Override // com.huawei.hms.ads.is
    public void V() {
        jc.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(long j, int i, int i2) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.V(Integer.valueOf(i2));
        }
        jc.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(long j, int i, Integer num) {
        String B = B();
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar != null) {
            fb.Code("PlacementAdPresenter", "slotId: %s, contentId: %s, slot pos: %s", nVar.o(), this.Z.a(), B);
        }
        jb.a aVar = new jb.a();
        if (num != null) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        }
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i)).V(num).B(B).Code(C()).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jc.Code(this.I, this.Code, aVar.Code());
    }

    @Override // com.huawei.hms.ads.is
    public void Code(MaterialClickInfo materialClickInfo) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar == null) {
            return;
        }
        nVar.Code(true);
        fb.Code("PlacementAdPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.Code, this.Z.w());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.Z.Code());
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(this.I, this.Code, hashMap);
        if (Code.Code()) {
            Code(Code, materialClickInfo);
        }
    }

    @Override // com.huawei.hms.ads.is
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Z = nVar;
        this.Code = nVar != null ? nVar.n() : null;
    }

    private void Code(com.huawei.openalliance.ad.uriaction.p pVar, MaterialClickInfo materialClickInfo) {
        jc.Code(this.I, this.Code, 0, 0, pVar.I(), materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bc.V(I()));
    }

    @Override // com.huawei.hms.ads.is
    public void Code(String str, int i, int i2, com.huawei.openalliance.ad.inter.data.n nVar) {
        AdContentData n = nVar.n();
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(str);
        analysisEventReport.Code(i);
        analysisEventReport.V(i2);
        analysisEventReport.Code(n);
        if (n != null) {
            analysisEventReport.D(n.aE());
            analysisEventReport.L(n.L());
            analysisEventReport.F(n.a());
            analysisEventReport.I(n.aF());
        }
        com.huawei.openalliance.ad.ipc.g.V(this.I).Code("rptPlacePlayErr", com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(boolean z) {
        jc.Code(this.I, this.Code, z);
    }
}
