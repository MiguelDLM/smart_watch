package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class n extends e {
    public String Jd;
    public String Je;
    public long Jg;
    public String Lh;
    public String RH;
    public long RO;
    public long RP;
    public long RQ;
    public long SK;
    public long WF;
    public String XB;
    public int Ye;
    public long aAb;
    public long aAc;
    public String aAd;
    public long actionType;
    public transient SceneImpl adScene;
    public long avo;
    public long ayV;
    public JSONObject ayW;
    public JSONObject ayX;
    public long ayY;
    public long ayZ;
    public String azA;
    public long azD;
    public int azE;
    public String azF;
    public long azG;
    public long azH;
    public long azI;
    public long azJ;
    public String azK;
    public int azL;
    public JSONArray azM;
    public long azN;
    public long azO;
    public JSONArray azP;
    public String azQ;
    public String azR;
    public String azS;
    public String azT;
    public String azU;
    public String azW;
    public String azX;
    public int azY;
    public long aza;
    public long azb;
    public long azc;
    public long aze;
    public URLPackage azf;
    public String azg;
    public JSONArray azh;
    public JSONArray azi;
    public a azj;
    public int azk;
    public int azl;
    public int azm;
    public int azn;
    public String azo;
    public int azp;
    public int azq;
    public String azr;
    public JSONObject azs;
    public JSONArray azt;
    public int azu;
    public int azv;
    public int azw;
    public JSONArray azy;
    public boolean azz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long azd = -1;
    public int are = 0;
    public long azx = 0;
    public int azB = 0;
    public int azC = -1;
    public int azV = 0;
    public int azZ = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aAa = BuildConfig.VERSION_NAME;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aAe;
        public int aAf;

        public static a Fy() {
            a aVar = new a();
            aVar.aAe = b.aAe;
            aVar.aAf = b.aAf;
            return aVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static int aAe;
        public static int aAf;
    }

    public n(long j) {
        this.XB = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aAd = "";
        this.actionType = j;
    }

    private void bZ(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.azl = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.azB = sVar.ue();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.FD();
            try {
                this.Jg = t.FE();
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            this.ayV = t.FF();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.ayY = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.dP(adTemplate);
                String dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                if (!TextUtils.isEmpty(dQ)) {
                    try {
                        this.ayW = new JSONObject(dQ);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                    }
                }
                String dR = com.kwad.sdk.core.response.b.e.dR(adTemplate);
                if (!TextUtils.isEmpty(dR)) {
                    try {
                        this.ayX = new JSONObject(dR);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.dL(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.dO(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.dY(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
                    this.creativeId = dS.adBaseInfo.creativeId;
                    this.ayZ = com.kwad.sdk.core.response.b.a.L(dS) * 1000;
                    this.SK = dS.advertiserInfo.userId;
                }
                this.azk = adTemplate.mMediaPlayerType;
                this.azm = adTemplate.mIsLeftSlipStatus;
                this.azn = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
            }
            this.azj = a.Fy();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    public final n Fw() {
        bZ(this.mAdTemplate);
        return this;
    }

    public final void Fx() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.azu = jVar.rd() ? 1 : 0;
        this.azv = jVar.re();
        this.azw = jVar.rf();
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.azl = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.azq = jSONObject.optInt("num");
        this.azp = jSONObject.optInt("state");
        this.azx = jSONObject.optLong("timeSpend");
        this.azN = jSONObject.optLong("loadingDuration");
        this.azO = jSONObject.optLong("loadingDurationLimt");
        this.azC = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.azq;
        if (i2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "num", i2);
        }
        int i3 = this.azp;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i3);
        }
        long j = this.azx;
        if (j > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.azN;
        if (j2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.azO;
        if (j3 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "playerTypeInfo", this.azC);
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.aAd)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aAd + '}';
    }

    public n(long j, @Nullable AdTemplate adTemplate) {
        this.XB = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aAd = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public n(long j, @Nullable AdTemplate adTemplate, String str) {
        this.XB = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aAd = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.Lh = str;
    }

    public n(String str, String str2, boolean z) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null) {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        } else {
            apiVersion = "";
        }
        this.XB = apiVersion;
        this.sdkType = 1;
        this.actionId = str;
        this.aAd = str2;
    }
}
