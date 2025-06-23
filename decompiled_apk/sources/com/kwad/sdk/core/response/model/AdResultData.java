package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.request.TanxError;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public AdGlobalConfigInfo adGlobalConfigInfo;
    public boolean hasMore;
    private String mAdSource;
    private List<AdTemplate> mAdTemplateList;

    @Nullable
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    private SceneImpl mScene;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i) {
        AdVideoPreCacheConfig adVideoPreCacheConfig;
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        if (adGlobalConfigInfo != null && (adVideoPreCacheConfig = adGlobalConfigInfo.adVideoPreCacheConfig) != null) {
            return adVideoPreCacheConfig;
        }
        return new AdVideoPreCacheConfig(i, false);
    }

    public SceneImpl getAdScene(long j) {
        SceneImpl sceneImpl;
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        if (map != null) {
            sceneImpl = map.get(Long.valueOf(j));
        } else {
            sceneImpl = null;
        }
        if (sceneImpl == null) {
            return new SceneImpl(j);
        }
        return sceneImpl;
    }

    public String getAdSource() {
        String str = this.mAdSource;
        if (str != null) {
            return str;
        }
        return "network";
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList != null && adTemplateList.size() != 0) {
            return adTemplateList.get(0);
        }
        return null;
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    @NonNull
    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null) {
            return arrayList;
        }
        int size = adTemplateList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(adTemplateList.get(i));
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.a(json, "pageInfo", this.pageInfo);
        t.putValue(json, "impAdInfo", ((e) c.f(e.class)).am(t.O(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            com.kwad.sdk.core.e.c.w(TAG, "adTemplateList is empty");
            return true;
        }
        com.kwad.sdk.core.e.c.d(TAG, "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            com.kwad.sdk.core.e.c.w(TAG, "adInfoList is empty");
            return true;
        }
        if (list.get(0) != null) {
            return false;
        }
        com.kwad.sdk.core.e.c.w(TAG, TanxError.ERROR_ADINFO_NULL);
        return true;
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0 || com.kwad.sdk.core.response.b.e.eg(proceedTemplateList.get(0)) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i;
        int i2;
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String optString = jSONObject.optString("adGlobalConfigInfo");
            e eVar = (e) c.f(e.class);
            if (!bh.isNullString(optString)) {
                String responseData = eVar.getResponseData(optString);
                AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                this.adGlobalConfigInfo = adGlobalConfigInfo;
                adGlobalConfigInfo.parseJson(new JSONObject(responseData));
            }
            try {
                String optString2 = jSONObject.optString("pageInfo");
                if (!bh.isNullString(optString2)) {
                    this.pageInfo.parseJson(new JSONObject(eVar.getResponseData(optString2)));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.d("json bug", e.toString());
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
            String optString3 = jSONObject.optString("impAdInfo");
            if (!TextUtils.isEmpty(optString3)) {
                String responseData2 = eVar.getResponseData(optString3);
                if (!bh.isNullString(responseData2)) {
                    try {
                        try {
                            jSONArray = new JSONArray(responseData2);
                        } catch (Throwable unused) {
                            com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3, responseData2);
                            jSONArray = null;
                        }
                        if (jSONArray != null && jSONArray.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                                if (optJSONObject != null) {
                                    AdTemplate adTemplate = new AdTemplate();
                                    adTemplate.parseJson(optJSONObject);
                                    adTemplate.llsid = this.llsid;
                                    adTemplate.extra = this.extra;
                                    adTemplate.mAdScene = getAdScene(adTemplate.posId);
                                    adTemplate.mPageInfo = this.pageInfo;
                                    this.mAdTemplateList.add(adTemplate);
                                    com.kwad.sdk.commercial.e.a.bB(adTemplate);
                                    SceneImpl sceneImpl = this.mScene;
                                    if (sceneImpl != null && (i = adTemplate.adStyle) != (i2 = sceneImpl.adStyle)) {
                                        adTemplate.adStyle = i2;
                                        com.kwad.sdk.commercial.e.a.c(adTemplate, MapBundleKey.MapObjKey.OBJ_AD_STYLE, String.valueOf(i));
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public void setAdSource(String str) {
        this.mAdSource = str;
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "pcursor", this.pcursor);
        t.putValue(json, "hasMore", this.hasMore);
        t.a(json, "pageInfo", this.pageInfo);
        t.putValue(json, "impAdInfo", getAdTemplateList());
        t.a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        return json;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdResultData m277clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return adResultData;
        }
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        if (sceneImpl != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        if (baseResultData == null) {
            return;
        }
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }
}
