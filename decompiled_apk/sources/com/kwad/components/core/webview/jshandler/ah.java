package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ah implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private final Handler Xl = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int XR;
        public String XS;
        public String XT;

        @Deprecated
        public boolean XU;
        public boolean XV;
        public boolean XW;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String qc;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public ah(com.kwad.sdk.core.webview.b bVar) {
        this.WQ = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Xl.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.as(2);
        } else {
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
            a(dS, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.as(1);
        }
        this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ah.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new a.C0788a(ah.this.WQ.Ph.getContext()).ar(ah.this.mAdTemplate).b(ah.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ah.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.XS;
        adConversionInfo.marketUrl = aVar.XT;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.pkgName;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.XR;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.qc;
        if (com.kwad.sdk.core.response.b.a.aE(adInfo)) {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.ae.bx(str);
            return;
        }
        adInfo.adConversionInfo.h5Url = aVar.url;
    }
}
