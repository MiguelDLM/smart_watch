package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* loaded from: classes10.dex */
public class jd {
    public static com.huawei.openalliance.ad.inter.data.k Code(AdContentData adContentData) {
        com.huawei.openalliance.ad.inter.data.k kVar = new com.huawei.openalliance.ad.inter.data.k(adContentData);
        kVar.Code(adContentData);
        kVar.S(1);
        kVar.Code(adContentData.y());
        kVar.Z(adContentData.q());
        kVar.V(adContentData.o());
        kVar.F(adContentData.l());
        kVar.n(adContentData.a());
        kVar.I(adContentData.W());
        kVar.a(adContentData.i());
        kVar.i(adContentData.L());
        kVar.m(adContentData.D());
        kVar.j(adContentData.w());
        kVar.Z(adContentData.j());
        kVar.Code(adContentData.S());
        kVar.C(adContentData.X());
        kVar.e(adContentData.Y());
        kVar.f(adContentData.v());
        kVar.Code(new VideoInfo(adContentData.t()));
        MetaData S = adContentData.S();
        if (S != null) {
            kVar.D(com.huawei.openalliance.ad.utils.ay.V(S.Z()));
            kVar.L(com.huawei.openalliance.ad.utils.ay.V(S.B()));
            kVar.V(S.F());
            kVar.B(S.D());
            kVar.p(com.huawei.openalliance.ad.utils.ay.V(adContentData.S().L()));
            kVar.b(S.a());
            kVar.c(S.b());
            kVar.o(com.huawei.openalliance.ad.utils.ay.V(S.Code()));
            ApkInfo e = S.e();
            if (e != null) {
                com.huawei.openalliance.ad.inter.data.AppInfo appInfo = new com.huawei.openalliance.ad.inter.data.AppInfo(e);
                appInfo.Code(kVar.l());
                appInfo.V(kVar.x());
                appInfo.a(S.I());
                kVar.Code(appInfo);
            }
        }
        kVar.Code(adContentData.c());
        kVar.Z(adContentData.s());
        kVar.I(adContentData.r());
        kVar.C(adContentData.B());
        kVar.S(adContentData.p());
        kVar.V(adContentData.ag());
        kVar.I(adContentData.ah());
        kVar.B(adContentData.h());
        kVar.q(adContentData.av());
        return kVar;
    }
}
