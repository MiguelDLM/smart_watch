package com.kwad.sdk.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.service.b;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class SceneImpl extends a implements KsScene, Serializable, Cloneable {
    private static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adStyle;
    public String backUrl;
    public String bidResponse;
    public String bidResponseV2;
    public String comment;
    public long entryScene;
    public int height;
    public AdLabelImpl mKsAdLabel;
    public NativeAdExtraDataImpl nativeAdExtraData;
    public long posId;
    public String promoteId;
    public Map<String, String> rewardCallbackExtraData;
    public SplashExtraDataImpl splashExtraData;
    public URLPackage urlPackage;
    public long userCommRateBuying;
    public long userCommRateSharing;
    public int width;
    public int adNum = 1;
    public int screenOrientation = 0;

    public SceneImpl() {
    }

    public static SceneImpl covert(KsScene ksScene) {
        SceneImpl sceneImpl = new SceneImpl();
        try {
            sceneImpl.parseJson(ksScene.toJson());
        } catch (Throwable unused) {
        }
        return sceneImpl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @InvokeBy(invokerClass = b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        b.b(KsScene.class, SceneImpl.class);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.rewardCallbackExtraData = u.parseJSON2MapString(jSONObject.optString("rewardCallbackExtraData"));
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        u.putValue(jSONObject, "rewardCallbackExtraData", u.parseMap2JSON(this.rewardCallbackExtraData));
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        return this.action;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        return this.adNum;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBackUrl() {
        return this.backUrl;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponse() {
        return this.bidResponse;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponseV2() {
        return this.bidResponseV2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getComment() {
        return this.comment;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        return this.height;
    }

    public int getPageScene() {
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage == null) {
            return 0;
        }
        return uRLPackage.page;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        return this.posId;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getPromoteId() {
        return this.promoteId;
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        return this.rewardCallbackExtraData;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public URLPackage getUrlPackage() {
        return this.urlPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateBuying() {
        return this.userCommRateBuying;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateSharing() {
        return this.userCommRateSharing;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    @Keep
    public void needShowMiniWindow(boolean z) {
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i) {
        this.action = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i) {
        this.adNum = i;
        if (com.kwad.framework.a.a.md.booleanValue() && bk.NZ() != 0) {
            this.adNum = (int) bk.NZ();
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i) {
        this.adStyle = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponse(String str) {
        this.bidResponse = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponseV2(String str) {
        this.bidResponseV2 = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        this.comment = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(IKsAdLabel iKsAdLabel) {
        if (iKsAdLabel == null) {
            return;
        }
        AdLabelImpl adLabelImpl = new AdLabelImpl();
        this.mKsAdLabel = adLabelImpl;
        adLabelImpl.thirdAge = iKsAdLabel.getThirdAge();
        this.mKsAdLabel.thirdGender = iKsAdLabel.getThirdGender();
        this.mKsAdLabel.thirdInterest = iKsAdLabel.getThirdInterest();
        this.mKsAdLabel.prevTitle = iKsAdLabel.getPrevTitle();
        this.mKsAdLabel.postTitle = iKsAdLabel.getPostTitle();
        this.mKsAdLabel.historyTitle = iKsAdLabel.getHistoryTitle();
        this.mKsAdLabel.channel = iKsAdLabel.getChannel();
        this.mKsAdLabel.cpmBidFloor = iKsAdLabel.getCpmBidFloor();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
        if (nativeAdExtraData == null) {
            return;
        }
        NativeAdExtraDataImpl nativeAdExtraDataImpl = new NativeAdExtraDataImpl();
        this.nativeAdExtraData = nativeAdExtraDataImpl;
        try {
            nativeAdExtraDataImpl.enableShake = nativeAdExtraData.isEnableShake();
            this.nativeAdExtraData.showLiveStyle = nativeAdExtraData.getShowLiveStyle();
            this.nativeAdExtraData.showLiveStatus = nativeAdExtraData.getShowLiveStatus();
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        this.posId = j;
        this.entryScene = j;
        if (com.kwad.framework.a.a.md.booleanValue() && bk.getPosId() != 0) {
            this.posId = bk.getPosId();
            this.entryScene = bk.getPosId();
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPromoteId(String str) {
        this.promoteId = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        this.rewardCallbackExtraData = map;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setSplashExtraData(SplashAdExtraData splashAdExtraData) {
        if (splashAdExtraData == null) {
            return;
        }
        SplashExtraDataImpl splashExtraDataImpl = new SplashExtraDataImpl();
        this.splashExtraData = splashExtraDataImpl;
        splashExtraDataImpl.disableShake = splashAdExtraData.getDisableShakeStatus();
        this.splashExtraData.disableSlide = splashAdExtraData.getDisableSlideStatus();
        this.splashExtraData.disableRotate = splashAdExtraData.getDisableRotateStatus();
    }

    public SceneImpl setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
        return this;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateBuying(int i) {
        this.userCommRateBuying = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i) {
        this.userCommRateSharing = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i) {
        this.width = i;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SceneImpl m279clone() {
        return covert(this);
    }

    public SceneImpl(long j) {
        this.posId = j;
        this.entryScene = j;
    }
}
