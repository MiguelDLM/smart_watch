package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class b {
    private static volatile b CW;

    private static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dt(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k != null) {
            styleTemplate.templateId = k.templateId;
            styleTemplate.templateMd5 = k.templateMd5;
            styleTemplate.templateUrl = k.templateUrl;
            styleTemplate.templateVersionCode = (int) k.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CS) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aY(e.dS(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void aa(@NonNull AdTemplate adTemplate) {
        long j;
        boolean bc = com.kwad.sdk.core.response.b.a.bc(e.dS(adTemplate));
        int i = 1;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(1);
        if (bc) {
            i = 2;
        }
        SplashMonitorInfo type = status.setType(i);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CS)) {
            j = 1;
        } else {
            j = 2;
        }
        com.kwad.sdk.commercial.b.k(type.setLoadProcessType(j).setAdTemplate(adTemplate));
    }

    public static void ab(@NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        boolean bc = com.kwad.sdk.core.response.b.a.bc(dS);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setStatus(4).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS));
        if (bc) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.k(creativeId.setType(i).setAdTemplate(adTemplate));
    }

    public static void ac(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo df = com.kwad.sdk.core.response.b.b.df(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(df.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (df.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i = df.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (!z2) {
            return;
        }
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public static void ad(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3001).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setUrl(com.kwad.sdk.core.response.b.a.aT(dS).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ae(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3002).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setUrl(com.kwad.sdk.core.response.b.a.aT(dS).materialUrl).setAdTemplate(adTemplate));
    }

    public static void af(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3003).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setUrl(com.kwad.sdk.core.response.b.a.aT(dS).materialUrl).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, long j, long j2) {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            str = com.kwad.sdk.core.response.b.a.K(dS);
        } else {
            str = com.kwad.sdk.core.response.b.a.aT(dS).materialUrl;
        }
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void c(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void d(@NonNull AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CS) ? 1L : 2L).setPreloadId(com.kwad.sdk.core.response.b.a.aY(e.dS(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.b.a.bc(dS) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setAdTemplate(adTemplate));
    }

    public static void f(long j, long j2) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CS) ? 1L : 2L).setPosId(j));
    }

    public static void h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(e.dS(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.aY(e.dS(adTemplate)));
        }
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setPosId(adResultData.getPosId()));
    }

    public static b kW() {
        if (CW == null) {
            synchronized (b.class) {
                try {
                    if (CW == null) {
                        CW = new b();
                    }
                } finally {
                }
            }
        }
        return CW;
    }

    public static void p(long j) {
        long j2;
        SplashMonitorInfo status = new SplashMonitorInfo().setStatus(1);
        if (d.a(com.kwad.components.ad.splashscreen.b.a.CS)) {
            j2 = 1;
        } else {
            j2 = 2;
        }
        com.kwad.sdk.commercial.b.h(status.setLoadProcessType(j2).setPosId(j));
    }

    public static void q(long j) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(2).setType(com.kwad.sdk.core.response.b.a.bc(dS) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CS) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long ds;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate)).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode);
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(ds).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i, String str) {
        String K;
        AdInfo dS = e.dS(adTemplate);
        boolean bc = com.kwad.sdk.core.response.b.a.bc(dS);
        SplashMonitorInfo type = new SplashMonitorInfo().setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setType(bc ? 2 : 1);
        if (bc) {
            K = com.kwad.sdk.core.response.b.a.aT(dS).materialUrl;
        } else {
            K = com.kwad.sdk.core.response.b.a.K(dS);
        }
        com.kwad.sdk.commercial.b.k(type.setUrl(K).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i, String str) {
        String str2;
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            str2 = com.kwad.sdk.core.response.b.a.K(dS);
        } else {
            str2 = com.kwad.sdk.core.response.b.a.aT(dS).materialUrl;
        }
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setUrl(str2).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bb(dS) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aY(e.dS(it.next())));
        }
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long ds;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(ds).setAdTemplate(adTemplate));
    }

    public static void b(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, int i) {
        String str;
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            str = com.kwad.sdk.core.response.b.a.K(dS);
        } else {
            str = com.kwad.sdk.core.response.b.a.aT(dS).materialUrl;
        }
        File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(com.kwad.sdk.core.response.b.a.aY(dS));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aY(dS)).setCostTime(j).setCacheValidTime(dS.adPreloadInfo.validityPeriod * 1000).setSize((bZ == null || !bZ.exists()) ? 0L : bZ.length()).setUrl(str).setMaterialType(com.kwad.sdk.core.response.b.a.bb(dS) ? 1 : 2).setType(i).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long ds;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate)).setErrorMsg(str);
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(errorMsg.setTkDefaultTimeout(ds).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long ds;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(ds).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setViewSource(z ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bc(dS) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dS(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long ds;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate));
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(tkRenderType.setTkDefaultTimeout(ds).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long ds;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dh(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dS(adTemplate);
        if (h.U(adTemplate)) {
            ds = com.kwad.sdk.core.response.b.b.dg(adTemplate);
        } else {
            ds = com.kwad.sdk.core.response.b.b.ds(e.dS(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(ds).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }
}
