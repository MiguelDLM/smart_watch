package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class id extends fu<kh> implements ip {
    private com.huawei.openalliance.ad.inter.data.k B;
    private com.huawei.openalliance.ad.inter.listeners.a C;
    private Context Z;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    public id(Context context, kh khVar) {
        this.Z = context.getApplicationContext();
        Code((id) khVar);
    }

    private void Z(boolean z) {
        this.S = z;
    }

    private boolean b() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.ip
    public void Code(long j, int i) {
        jc.Code(this.Z, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.ip
    public void D() {
        jc.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ai.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ip
    public void L() {
        jc.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ai.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ip
    public void S() {
        jc.Code(this.Z, this.Code);
    }

    @Override // com.huawei.hms.ads.fu, com.huawei.hms.ads.fv
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public kh I() {
        return (kh) super.I();
    }

    @Override // com.huawei.hms.ads.ip
    public void Code(long j, long j2, long j3, long j4) {
        jc.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ai.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.ip
    public void V(long j, long j2, long j3, long j4) {
        jc.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ai.C, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.ip
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.C = aVar;
    }

    @Override // com.huawei.hms.ads.ip
    public void V(boolean z) {
        jc.Code(this.Z, this.Code, z);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.p pVar, int i, MaterialClickInfo materialClickInfo) {
        jc.Code(this.Z, this.Code, 0, 0, pVar.I(), i, materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bc.V(I()));
    }

    @Override // com.huawei.hms.ads.ip
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        String str;
        com.huawei.openalliance.ad.inter.data.k kVar = this.B;
        boolean Code = c.Code(kVar != null ? kVar.F() : null, num2);
        if (b() && (!Code || Code())) {
            fb.I("PPSLinkedVideoViewPresenter", "show event already reported before, ignore this");
            return;
        }
        jb.a aVar = new jb.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        }
        kh I = I();
        if (I != null) {
            str = I.getSplashViewSlotPosition();
            com.huawei.openalliance.ad.inter.data.k kVar2 = this.B;
            if (kVar2 != null) {
                fb.Code("PPSLinkedVideoViewPresenter", "slotId: %s, contentId: %s, slot pos: %s", kVar2.o(), this.B.a(), str);
            }
        } else {
            str = "";
        }
        if (!com.huawei.openalliance.ad.utils.ay.Code(str)) {
            aVar.B(str);
        }
        aVar.Code(l).Code(num).V(num2).Code(C()).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jc.Code(this.Z, this.Code, aVar.Code());
        if (Code) {
            Code(true);
        }
        if (b()) {
            return;
        }
        Z(true);
        com.huawei.openalliance.ad.inter.listeners.a aVar2 = this.C;
        if (aVar2 != null) {
            aVar2.Code();
        }
    }

    @Override // com.huawei.hms.ads.fu, com.huawei.hms.ads.ip
    public void Code(String str) {
        super.Code(str);
        Z(false);
        Code(false);
    }

    private void Code(Map<String, String> map) {
        com.huawei.openalliance.ad.inter.data.k kVar;
        if (map == null || map.isEmpty() || (kVar = this.B) == null || kVar.C() == null) {
            return;
        }
        int L = this.B.C().L();
        if (Math.abs(this.B.C().I() - L) < 1000) {
            L = 0;
        }
        fb.V("PPSLinkedVideoViewPresenter", "buildLinkedAdConfig, duration: %s, set progress from LinkedSplash view:%s ", Integer.valueOf(this.B.C().I()), Integer.valueOf(L));
        map.put(com.huawei.openalliance.ad.constant.bb.s, this.B.C().h() ? "true" : "false");
        map.put(com.huawei.openalliance.ad.constant.bb.r, this.B.C().a());
        map.put(com.huawei.openalliance.ad.constant.bb.q, String.valueOf(L));
        map.put(com.huawei.openalliance.ad.constant.bb.t, this.B.ah());
        map.put(com.huawei.openalliance.ad.constant.bb.m, this.B.r());
        map.put(com.huawei.openalliance.ad.constant.bb.p, String.valueOf(10));
    }

    public void Code(boolean z) {
        this.F = z;
    }

    public boolean Code() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.ip
    public boolean Code(int i, MaterialClickInfo materialClickInfo) {
        com.huawei.openalliance.ad.inter.data.k kVar = this.B;
        if (kVar == null) {
            return false;
        }
        kVar.V(true);
        fb.V("PPSLinkedVideoViewPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.Code, this.B.as());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.B.ar());
        Code(hashMap);
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(I() instanceof View ? ((View) I()).getContext() : this.Z, this.Code, hashMap);
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, i, materialClickInfo);
        }
        d.Code(this.Z).Code(false);
        return Code2;
    }
}
