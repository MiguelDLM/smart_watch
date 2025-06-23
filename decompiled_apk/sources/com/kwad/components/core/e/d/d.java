package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bo;
import com.szabh.smable3.entity.BleNotification;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d {
    private static boolean LC = false;
    private static final b LD = new b() { // from class: com.kwad.components.core.e.d.d.3
        long LJ;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.LJ = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.LJ != 0) {
                com.kwad.sdk.core.adlog.c.m(getAdTemplate(), System.currentTimeMillis() - this.LJ);
            }
            com.kwad.sdk.core.c.b.En();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.LD);
            setAdTemplate(null);
            this.LJ = 0L;
        }
    };

    public static int a(final a.C0788a c0788a, int i) {
        Context context = c0788a.getContext();
        final AdTemplate adTemplate = c0788a.getAdTemplate();
        String a2 = a(c0788a, adTemplate);
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        Activity dB = l.dB(context);
        final int i2 = 1;
        if (dB != null && com.kwad.sdk.core.response.b.a.T(dS) && !c0788a.nZ()) {
            c0788a.ak(1);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            return 2;
        }
        final String a3 = a(a2, c0788a, dS);
        return com.kwad.sdk.core.download.a.b.a(context, a3, new b.a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void oN() {
                com.kwad.sdk.commercial.f.a.g(AdTemplate.this, a3);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.core.adlog.c.b(AdTemplate.this, "", i2, null);
                com.kwad.sdk.commercial.f.a.d(AdTemplate.this, a3, bo.t(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.f.a.f(AdTemplate.this, a3);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                d.LD.setAdTemplate(AdTemplate.this);
                com.kwad.sdk.core.c.b.En();
                com.kwad.sdk.core.c.b.a(d.LD);
                com.kwad.sdk.core.adlog.c.aqt = d.ai(a3);
                com.kwad.sdk.commercial.f.a.h(AdTemplate.this, a3);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.commercial.f.a.i(AdTemplate.this, a3);
                com.kwad.sdk.core.adlog.c.a(AdTemplate.this, "", i2, c0788a.ok());
                d.a(AdTemplate.this, a3, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ai(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ax(boolean z) {
        com.kwad.sdk.core.adlog.c.aqu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ay(boolean z) {
        LC = z;
    }

    private static String l(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean oL() {
        return LC;
    }

    private static String b(a.C0788a c0788a, AdInfo adInfo, String str) {
        long j = c0788a.getAdTemplate().getmCurPlayTime();
        if (j > 0) {
            j = Math.max(j - com.kwad.sdk.core.response.b.a.bl(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j)).toString();
    }

    private static String a(String str, a.C0788a c0788a, AdInfo adInfo) {
        AdTemplate adTemplate = c0788a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bk(adInfo)) {
            str = b(c0788a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cM(adInfo)) {
            str = a(c0788a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.b.a.cE(adInfo) || com.kwad.sdk.core.response.b.a.cK(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0788a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String a(a.C0788a c0788a, AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : dS.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0788a.cY()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0788a.od()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + dS.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cO(dS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i) {
        if (oL()) {
            return;
        }
        ay(true);
        int CC = com.kwad.sdk.core.config.d.CC();
        com.kwad.sdk.core.config.d.CD();
        int abs = Math.abs(CC);
        if (abs > 0) {
            bo.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.ay(false);
                    com.kwad.sdk.core.c.b.En();
                    if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "", i);
                        com.kwad.sdk.commercial.f.a.j(AdTemplate.this, str);
                    }
                }
            }, null, abs * 1000);
        } else {
            ay(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(com.kwad.components.core.e.d.a.C0788a r3, com.kwad.sdk.core.response.model.AdInfo r4, java.lang.String r5) {
        /*
            boolean r0 = com.kwad.sdk.core.response.b.a.bh(r4)
            if (r0 != 0) goto L7
            return r5
        L7:
            java.util.concurrent.Callable r0 = r3.nY()
            if (r0 == 0) goto L14
            java.lang.Object r0 = r0.call()     // Catch: java.lang.Exception -> L14
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L14
            goto L15
        L14:
            r0 = 0
        L15:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L1f
            java.lang.String r0 = r3.nX()
        L1f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "__simpleItemId__"
            java.lang.String r2 = "__itemId__"
            if (r3 == 0) goto L3c
            boolean r3 = r5.contains(r2)
            if (r3 != 0) goto L37
            boolean r3 = r5.contains(r1)
            if (r3 == 0) goto L36
            goto L37
        L36:
            return r5
        L37:
            java.lang.String r3 = com.kwad.sdk.core.response.b.a.cO(r4)
            return r3
        L3c:
            long r3 = com.kwad.components.core.e.b.a.ad(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L45
            goto L46
        L45:
            r3 = r0
        L46:
            java.lang.String r4 = r5.replaceAll(r2, r0)
            java.lang.String r3 = r4.replaceAll(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.e.d.d.a(com.kwad.components.core.e.d.a$a, com.kwad.sdk.core.response.model.AdInfo, java.lang.String):java.lang.String");
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!al.an(context, BleNotification.GIF_MAKER) && al.an(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? l(str, str2) : str;
    }
}
