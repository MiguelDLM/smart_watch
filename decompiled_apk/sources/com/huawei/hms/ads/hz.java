package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class hz extends fu<ki> implements im<ki> {
    private static final String V = "hz";
    private PPSNativeView.e B;
    private Context I;
    private com.huawei.openalliance.ad.inter.data.l Z;

    public hz(Context context, ki kiVar) {
        this.I = context;
        Code((hz) kiVar);
    }

    @Override // com.huawei.hms.ads.im
    public void Code() {
        jc.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.im
    public void I(String str) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.C(str);
    }

    @Override // com.huawei.hms.ads.im
    public void V() {
        jc.V(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.im
    public void Code(long j, int i) {
        jc.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.im
    public void V(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.c(str);
    }

    @Override // com.huawei.hms.ads.im
    public void Code(VideoInfo videoInfo) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.Code(videoInfo);
    }

    @Override // com.huawei.hms.ads.im
    public void V(List<String> list) {
        jc.Code(this.I, this.Code, 0, 0, list);
    }

    @Override // com.huawei.hms.ads.im
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Z = lVar;
        this.Code = lVar != null ? lVar.n() : null;
    }

    private void Code(com.huawei.openalliance.ad.uriaction.p pVar, MaterialClickInfo materialClickInfo, Integer num, jb jbVar) {
        jc.Code(this.I, this.Code, 0, 0, pVar.I(), num.intValue(), materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bc.V(I()), jbVar);
    }

    @Override // com.huawei.hms.ads.im
    public void Code(PPSNativeView.e eVar) {
        this.B = eVar;
    }

    @Override // com.huawei.hms.ads.im
    public void Code(Long l, Integer num, Integer num2, boolean z, String str) {
        String B = B();
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar != null) {
            fb.Code(V, "slotId: %s, contentId: %s, slot pos: %s", lVar.o(), this.Z.a(), B);
        }
        jb.a aVar = new jb.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        }
        aVar.Code(l).Code(num).V(num2).B(B).Code(C()).V(str).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jc.Code(this.I, this.Code, aVar.Code());
    }

    private void Code(HashMap<String, String> hashMap) {
        MetaData S;
        if (hashMap == null || (S = this.Code.S()) == null) {
            return;
        }
        ApkInfo e = S.e();
        if (e != null) {
            String S2 = com.huawei.openalliance.ad.utils.ay.S(hashMap.get(com.huawei.openalliance.ad.constant.bb.aM));
            if (!TextUtils.isEmpty(S2)) {
                e.i(S2);
            }
            String S3 = com.huawei.openalliance.ad.utils.ay.S(hashMap.get(com.huawei.openalliance.ad.constant.bb.aN));
            if (!TextUtils.isEmpty(S3)) {
                e.j(S3);
            }
        }
        this.Code.V(com.huawei.openalliance.ad.utils.aa.V(S));
    }

    @Override // com.huawei.hms.ads.im
    public void Code(List<ImageInfo> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.V(list);
    }

    @Override // com.huawei.hms.ads.im
    public boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z) {
        return Code(materialClickInfo, num, str, z, (HashMap<String, String>) null);
    }

    @Override // com.huawei.hms.ads.im
    public boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z, HashMap<String, String> hashMap) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return false;
        }
        lVar.Code(true);
        fb.Code(V, "deal click");
        Map<String, String> ar = this.Z.ar();
        Code(hashMap);
        jb jbVar = new jb();
        jbVar.B(str);
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(this.I, this.Code, ar);
        if (!z) {
            Code(Code, materialClickInfo, num, jbVar);
            return true;
        }
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, materialClickInfo, num, jbVar);
            PPSNativeView.e eVar = this.B;
            if (eVar != null) {
                eVar.V();
                this.B.I();
            }
        }
        return Code2;
    }
}
