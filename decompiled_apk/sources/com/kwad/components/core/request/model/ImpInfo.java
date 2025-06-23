package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;
import java.util.Map;

@KsJson
/* loaded from: classes11.dex */
public class ImpInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 6229807370051396781L;
    public int action;
    public int adNum;
    public SceneImpl adScene;
    public int adStyle;
    public String backUrl;
    public String comment;
    public long cpmBidFloor;
    public long entryScene;
    public String extraData;
    public int height;
    public long posId;
    public String promoteId;
    public int screenOrientation;
    public String sdkExtraData;
    public URLPackage urlPackage;
    public long userCommRateBuying;
    public long userCommRateSharing;
    public int width;
    public long pageScene = 0;
    public long subPageScene = 0;

    public ImpInfo(SceneImpl sceneImpl) {
        this.adScene = sceneImpl;
        this.posId = sceneImpl.posId;
        this.entryScene = sceneImpl.entryScene;
        this.adNum = sceneImpl.adNum;
        this.action = sceneImpl.action;
        this.width = sceneImpl.width;
        this.height = sceneImpl.height;
        AdLabelImpl adLabelImpl = sceneImpl.mKsAdLabel;
        if (adLabelImpl != null) {
            long j = adLabelImpl.cpmBidFloor;
            if (j != 0) {
                this.cpmBidFloor = j;
            }
        }
        this.adStyle = sceneImpl.adStyle;
        URLPackage uRLPackage = sceneImpl.urlPackage;
        if (uRLPackage != null) {
            this.urlPackage = uRLPackage;
        }
        this.promoteId = sceneImpl.promoteId;
        this.comment = sceneImpl.comment;
        this.backUrl = sceneImpl.backUrl;
        this.userCommRateBuying = sceneImpl.userCommRateBuying;
        this.userCommRateSharing = sceneImpl.userCommRateSharing;
        this.screenOrientation = sceneImpl.screenOrientation;
        String rewardCallbackExtraByKey = getRewardCallbackExtraByKey("extraData");
        if (rewardCallbackExtraByKey != null) {
            this.extraData = rewardCallbackExtraByKey;
        }
    }

    @Nullable
    public AdLabelImpl getAdLabelFromAdScene() {
        SceneImpl sceneImpl = this.adScene;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }

    @Nullable
    public String getRewardCallbackExtraByKey(String str) {
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        if (str == null || (sceneImpl = this.adScene) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }
}
