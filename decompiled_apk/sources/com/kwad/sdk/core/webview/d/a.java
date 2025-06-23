package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0861a extends com.kwad.sdk.core.response.a.a {
        public int XA;
        public String XB;
        public int XC;
        public String XD;
        public String XE;
        public String XF;
        public int XG;
        public String XH;

        /* renamed from: XI, reason: collision with root package name */
        public int f18473XI;
        public String XJ;
        public String XK;
        public int XL;
        public int XM;
        public int XN;

        /* renamed from: XO, reason: collision with root package name */
        public int f18474XO;
        public String Xz;
        public String aAB;
        public String aAG;
        public String aAH;
        public String aAS;
        public String aFT;
        public String aFU;
        public boolean aFV;
        public String aFW;
        public String appId;
        public String appName;
        public String appVersion;
        public String aux;
        public String auy;
        public String azQ;
        public String model;
        public int sdkType;

        public static C0861a HL() {
            C0861a c0861a = new C0861a();
            c0861a.Xz = BuildConfig.VERSION_NAME;
            c0861a.XA = BuildConfig.VERSION_CODE;
            c0861a.azQ = "6.0.7";
            c0861a.aFW = "1.3";
            c0861a.XB = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0861a.XC = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0861a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0861a.appVersion = k.cd(context);
            c0861a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0861a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0861a.aFT = "";
            c0861a.aAH = y.Mt();
            g gVar = (g) c.f(g.class);
            if (gVar != null) {
                c0861a.aAG = gVar.oV();
            }
            c0861a.XD = String.valueOf(ah.cx(context));
            c0861a.XE = bj.NR();
            c0861a.model = bj.NI();
            c0861a.XF = bj.NK();
            c0861a.XG = 1;
            c0861a.XH = bj.getOsVersion();
            c0861a.f18473XI = bj.NU();
            c0861a.XJ = bj.getLanguage();
            c0861a.XK = bj.getLocale();
            c0861a.aFV = ((f) ServiceProvider.get(f.class)).yV();
            c0861a.aFU = aw.getDeviceId();
            c0861a.XL = bj.getScreenWidth(context);
            c0861a.XM = bj.getScreenHeight(context);
            c0861a.aux = aw.cI(context);
            c0861a.auy = aw.getOaid();
            c0861a.aAB = aw.cJ(context);
            c0861a.aAS = aw.cK(context);
            c0861a.XN = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0861a.f18474XO = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0861a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(C0861a.HL());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
