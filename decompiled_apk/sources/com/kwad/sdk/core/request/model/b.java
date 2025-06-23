package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.components.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.y;
import com.szabh.smable3.entity.BleNotification;
import org.json.JSONArray;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aAr;
    private static JSONArray aAs;
    public String Su;
    public String XF;
    public int XG;

    /* renamed from: XI, reason: collision with root package name */
    public int f18472XI;
    public String XJ;
    public int XL;
    public int XM;
    public int aAA;
    public String aAB;
    public String aAC;
    public String aAD;
    public int aAE;
    public String aAF;
    public String aAG;
    public String aAH;
    public JSONArray aAI;
    public String aAJ;
    public String aAL;
    public String aAM;
    public String aAN;
    public String aAP;
    public String aAQ;
    public String aAt;
    public String aAu;
    public String aAv;
    public String aAw;
    public String aAx;
    public String aAy;
    public int aAz;
    public String aux;
    public String auy;
    public int aAK = 0;
    public long aAO = 0;

    public static b FK() {
        b bVar = new b();
        try {
            bVar.auy = aw.getOaid();
            bVar.aAC = aw.getDeviceId();
            bVar.aAF = bj.NI();
            bVar.XG = 1;
            bVar.f18472XI = bj.NU();
            bVar.aAy = bj.getOsVersion();
            bVar.aAH = y.Mt();
            com.kwad.sdk.components.g gVar = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
            if (gVar != null) {
                bVar.aAG = gVar.oV();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.aux = aw.cI(ServiceProvider.Lw());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static synchronized JSONArray bu(Context context) {
        synchronized (b.class) {
            try {
                if (!aAr) {
                    aAr = true;
                    n nVar = (n) com.kwad.sdk.components.c.f(n.class);
                    com.kwad.sdk.core.e.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + nVar);
                    if (nVar != null && o.LU()) {
                        nVar.a(context, new com.kwad.sdk.f.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                            private static void g(JSONArray jSONArray) {
                                JSONArray unused = b.aAs = jSONArray;
                            }

                            @Override // com.kwad.sdk.f.a
                            public final /* synthetic */ void accept(JSONArray jSONArray) {
                                g(jSONArray);
                            }
                        });
                    }
                }
                JSONArray jSONArray = aAs;
                if (jSONArray == null) {
                    return null;
                }
                aAs = null;
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b h(boolean z, int i) {
        Object obj;
        b bVar = new b();
        try {
            Context Lw = ServiceProvider.Lw();
            bVar.aux = aw.cI(Lw);
            bVar.aAt = aw.cL(Lw);
            bVar.aAu = aw.cM(Lw);
            bVar.aAv = bj.dn(Lw);
            bVar.auy = aw.getOaid();
            bVar.aAF = bj.NI();
            bVar.XF = bj.NK();
            bVar.XG = 1;
            bVar.f18472XI = bj.NU();
            bVar.aAy = bj.getOsVersion();
            bVar.XJ = k.getLanguage();
            bVar.XM = k.getScreenHeight(Lw);
            bVar.XL = k.getScreenWidth(Lw);
            bVar.aAz = k.cg(Lw);
            bVar.aAA = k.ch(Lw);
            bVar.aAB = aw.cJ(Lw);
            if (z) {
                bVar.aAI = bu(Lw);
            }
            bVar.aAC = aw.getDeviceId();
            bVar.aAO = bj.NJ();
            bVar.aAD = bj.NR();
            bVar.aAH = y.Mt();
            com.kwad.sdk.components.g gVar = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
            if (gVar != null) {
                bVar.aAG = gVar.oV();
            }
            bVar.aAE = bj.NS();
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            try {
                StringBuilder sb = new StringBuilder("i=");
                sb.append(fVar.getAppId());
                sb.append(",n=");
                sb.append(fVar.getAppName());
                sb.append(",external:");
                sb.append(fVar.yV());
                sb.append(",v1:");
                sb.append(fVar.getApiVersion());
                sb.append(",v2:3.3.63");
                sb.append(",d:");
                sb.append(bVar.aAC);
                sb.append(",dh:");
                String str = bVar.aAC;
                if (str != null) {
                    obj = Integer.valueOf(str.hashCode());
                } else {
                    obj = "";
                }
                sb.append(obj);
                sb.append(",o:");
                sb.append(bVar.auy);
                sb.append(",b:665");
                sb.append(",p:");
                sb.append(ar.isInMainProcess(Lw));
                sb.append(",dy:");
                sb.append(com.kwad.framework.a.a.aew);
                com.kwad.sdk.core.e.c.T("DeviceInfo", sb.toString());
            } catch (Exception unused) {
            }
            bVar.aAJ = bj.NT();
            bVar.aAK = i;
            if (zn()) {
                bVar.aAL = com.kwad.sdk.app.b.AW().getVersion(Lw, BleNotification.GIF_MAKER);
                bVar.aAM = com.kwad.sdk.app.b.AW().getVersion(Lw, "com.kuaishou.nebula");
                bVar.aAN = com.kwad.sdk.app.b.AW().getVersion(Lw, "com.tencent.mm");
            }
            bVar.Su = bj.NP();
            bVar.aAx = af.cu(Lw);
            bVar.aAP = bj.NY();
            bVar.aAQ = bj.hj("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static boolean zn() {
        return ((h) ServiceProvider.get(h.class)).zn();
    }
}
