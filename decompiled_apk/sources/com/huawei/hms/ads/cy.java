package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class cy {
    private static <T> void I(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        d.Code(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int V(DelayInfo delayInfo) {
        Integer l;
        int f = delayInfo.f();
        if (f == -2) {
            Integer F = com.huawei.openalliance.ad.utils.ay.F(delayInfo.b());
            f = delayInfo.i() + (F != null ? 10000 + F.intValue() : 10000);
        } else if (f == 494 && (l = delayInfo.l()) != null) {
            f = l.intValue();
        }
        delayInfo.I(f);
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiStatisticsReq V(long j, String str, String str2, int i, int i2, DelayInfo delayInfo) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.V(j);
        apiStatisticsReq.V(str);
        apiStatisticsReq.S(str2);
        apiStatisticsReq.I(i);
        apiStatisticsReq.V(i2);
        apiStatisticsReq.Code(delayInfo);
        return apiStatisticsReq;
    }

    public static void Code(Context context) {
        V(context, cx.F, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void V(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.g.V(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    public static void Code(final Context context, final int i, final Integer num, final Integer num2) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.10
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.V(com.huawei.openalliance.ad.constant.x.dD);
                analysisEventReport.I(String.valueOf(i));
                analysisEventReport.Z(String.valueOf(num));
                analysisEventReport.B(String.valueOf(num2));
                analysisEventReport.I(System.currentTimeMillis());
                cy.V(context, cx.c, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final long j2, final long j3) {
        if (j <= 0 || j > j2) {
            return;
        }
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                DelayInfo delayInfo;
                if (com.huawei.openalliance.ad.utils.ai.Code(map)) {
                    arrayList = null;
                    arrayList2 = null;
                    delayInfo = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    delayInfo = null;
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    if (dVar instanceof c) {
                                        c cVar = (c) dVar;
                                        if (cVar.H() != null) {
                                            delayInfo = cVar.H();
                                        }
                                    }
                                    arrayList2.add(dVar.a());
                                }
                            }
                        }
                    }
                }
                if (delayInfo == null) {
                    delayInfo = new DelayInfo();
                }
                DelayInfo delayInfo2 = delayInfo;
                delayInfo2.Code(arrayList);
                delayInfo2.V(arrayList2);
                delayInfo2.j().Code(j);
                delayInfo2.j().V(j2);
                delayInfo2.j().c(j3);
                cy.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.aa.V(cy.V(j2 - j, com.huawei.openalliance.ad.constant.h.Code, str, i2, i, delayInfo2)), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final DelayInfo delayInfo) {
        if (fb.Code()) {
            fb.Code("AnalysisReport", "reportE2ECostTime,  duration = %s delayInfo: %s", Long.valueOf(j), Boolean.valueOf(delayInfo != null));
        }
        if (context == null || delayInfo == null || j <= 0) {
            return;
        }
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.5
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                DelayInfo H;
                if (com.huawei.openalliance.ad.utils.ai.Code(map)) {
                    arrayList = null;
                    arrayList2 = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    arrayList2.add(dVar.a());
                                    if (dVar instanceof c) {
                                        c cVar = (c) dVar;
                                        if (cVar.H() != null && (H = cVar.H()) != null && H.p() > 0) {
                                            delayInfo.a(H.p());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                delayInfo.Code(arrayList);
                delayInfo.V(arrayList2);
                cy.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.aa.V(cy.V(j, com.huawei.openalliance.ad.constant.h.Code, str, i2, i, delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, int i, String str, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.F(adContentData.a());
        analysisEventReport.D(adContentData.aE());
        analysisEventReport.L(adContentData.L());
        analysisEventReport.I(adContentData.aF());
        V(context, com.huawei.openalliance.ad.constant.s.q, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, int i, String str, String str2, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(i);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        analysisEventReport.B(str3);
        V(context, com.huawei.openalliance.ad.download.app.a.Code.equals(str3) ? cx.I : cx.Z, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final Bundle bundle, final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.9
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                AdContentData adContentData2 = AdContentData.this;
                if (adContentData2 != null) {
                    analysisEventReport.F(adContentData2.a());
                    analysisEventReport.D(AdContentData.this.aE());
                    analysisEventReport.L(AdContentData.this.L());
                    analysisEventReport.I(AdContentData.this.aF());
                }
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    ef efVar = new ef(bundle2);
                    analysisEventReport.V(efVar.w(bn.f.H));
                    analysisEventReport.I(efVar.w(bn.f.J));
                    analysisEventReport.Z(efVar.w(bn.f.K));
                    analysisEventReport.B(efVar.w(bn.f.M));
                    analysisEventReport.C(efVar.w(bn.f.N));
                    analysisEventReport.S(efVar.w(bn.f.O));
                }
                cy.V(context, cx.b, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final jn jnVar, final String str) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.2
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData = new AdContentData();
                adContentData.B(jn.this.Code());
                adContentData.C(jn.this.V());
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(adContentData);
                analysisEventReport.I(jn.this.I());
                analysisEventReport.Z(jn.this.Z());
                analysisEventReport.B(str);
                cy.V(context, com.huawei.openalliance.ad.constant.s.N, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        if (adContentData != null) {
            analysisEventReport.F(adContentData.a());
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.I(adContentData.aF());
            analysisEventReport.I(adContentData.at());
        } else {
            analysisEventReport.F("");
        }
        V(context, cx.L, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, long j, long j2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(j);
        analysisEventReport.I(j2);
        if (adContentData != null) {
            analysisEventReport.F(adContentData.a());
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        } else {
            analysisEventReport.F("");
        }
        V(context, cx.V, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.I(str);
        if (adContentData != null) {
            analysisEventReport.F(adContentData.a());
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        V(context, com.huawei.openalliance.ad.constant.s.v, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final int i, final AdContentData adContentData, final DelayInfo delayInfo) {
        if (delayInfo == null || delayInfo.Code() == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.3
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData2 = AdContentData.this;
                if (adContentData2 != null) {
                    delayInfo.V(adContentData2.ak());
                    delayInfo.V(Collections.singletonList(AdContentData.this.a()));
                    delayInfo.Code(AdContentData.this.aq());
                    delayInfo.Code(Integer.valueOf(AdContentData.this.l()));
                    DelayInfo an = AdContentData.this.an();
                    if (an != null) {
                        delayInfo.C(an.c());
                        delayInfo.Code(an.V());
                        delayInfo.I(an.Z());
                        delayInfo.B(an.C());
                        delayInfo.V(an.I());
                        delayInfo.F(an.g().longValue());
                        delayInfo.I(an.m());
                        AdTimeStatistics j = an.j();
                        if (j != null) {
                            AdTimeStatistics j2 = delayInfo.j();
                            j.Code(j2.Code());
                            j.V(j2.V());
                            j.c(j2.c());
                            j.d(j2.d());
                            j.e(j2.e());
                            delayInfo.Code(j);
                        }
                    }
                }
                cy.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.aa.V(cy.V(delayInfo.Code().longValue(), com.huawei.openalliance.ad.constant.h.Code, str, i, cy.V(delayInfo), delayInfo)), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.8
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                AdContentData adContentData2 = adContentData;
                if (adContentData2 != null) {
                    analysisEventReport.F(adContentData2.a());
                    analysisEventReport.D(adContentData.aE());
                    analysisEventReport.L(adContentData.L());
                    analysisEventReport.I(adContentData.aF());
                }
                cy.V(context, cx.f17258a, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, AdContentData adContentData, String str2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.F(str);
        analysisEventReport.I(str2);
        if (adContentData != null) {
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        V(context, cx.C, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final int i2, final String str3) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.1
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(i2);
                analysisEventReport.V(i);
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.B(str3);
                cy.V(context, cx.Code, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final String str3) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.7
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.Code(i);
                analysisEventReport.B(str3);
                cy.V(context, cx.D, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final long j) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cy.6
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.V(j);
                analysisEventReport.Code(0);
                cy.V(context, cx.D, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, String str2, long j, AdContentData adContentData, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.F(str2);
        analysisEventReport.I(str);
        analysisEventReport.I(j);
        analysisEventReport.V(str3);
        if (adContentData != null) {
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        I(context, cx.B, com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }
}
