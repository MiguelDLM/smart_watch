package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bj;

/* loaded from: classes11.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int XA;
        public String XB;
        public int XC;
        public String XD;
        public String XE;
        public String XF;
        public int XG;
        public String XH;

        /* renamed from: XI, reason: collision with root package name */
        public int f18465XI;
        public String XJ;
        public String XK;
        public int XL;
        public int XM;
        public int XN;

        /* renamed from: XO, reason: collision with root package name */
        public int f18466XO;
        public String Xz;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public int sdkType;

        public static a sS() {
            a aVar = new a();
            aVar.Xz = BuildConfig.VERSION_NAME;
            aVar.XA = BuildConfig.VERSION_CODE;
            aVar.XB = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.XC = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.k.cd(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.XD = String.valueOf(com.kwad.sdk.utils.ah.cx(context));
            aVar.XE = bj.NR();
            aVar.model = bj.NI();
            aVar.XF = bj.NK();
            aVar.XG = 1;
            aVar.XH = bj.getOsVersion();
            aVar.f18465XI = bj.NU();
            aVar.XJ = bj.getLanguage();
            aVar.XK = bj.getLocale();
            aVar.XL = bj.getScreenWidth(context);
            aVar.XM = bj.getScreenHeight(context);
            aVar.XN = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            aVar.f18466XO = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.sS());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
