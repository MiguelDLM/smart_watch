package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean RV = true;
    ImpInfo MX;
    private int RU;

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            gVar.thirdAge = i;
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            gVar.thirdGender = i2;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (RV && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) s.f(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                RV = false;
            }
        }
        return "";
    }

    public final void aF(int i) {
        this.RU = i;
    }

    public final int getAdNum() {
        return this.MX.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.MX;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return com.kwad.sdk.h.yB();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        o.bR(true);
        b.qN().qO();
        super.onCreate();
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.MX, aVar.Sd, aVar.Se, aVar.Sg);
        this.RU = aVar.Sf ? 1 : 0;
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.MX = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.FI(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i = this.RU;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String BG = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).BG() : "";
        if (!TextUtils.isEmpty(BG)) {
            putBody("universeDebugParam", BG);
        }
        String d = d(impInfo);
        if (!TextUtils.isEmpty(d)) {
            putBody("sdkDebugReqInfo", d);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", y.Ms());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.MX.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g FP = com.kwad.sdk.core.request.model.g.FP();
        if (rewardCallbackExtraByKey != null) {
            FP.ey(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(FP, adLabelFromAdScene);
        }
        putBody("userInfo", FP);
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            t.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            t.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            t.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            t.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        t.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
