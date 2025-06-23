package com.kwad.components.offline.api.explore.model;

import com.google.android.exoplayer2.ExoPlayer;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ExploreConfig extends BaseOfflineCompoJsonParse<ExploreConfig> implements Serializable {
    private static final long serialVersionUID = -5149616231567033423L;
    public String downgradeKey;
    public long funcSwitch;
    public String injectConfigStr;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;
    public long posIdInvalidInSecs = 300;
    public long maxClusterInterval = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    public long maxElementInterval = 1000;
    public String testReportUrlV2 = "";
    public int reportCountLimit = 5;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(ExploreConfig exploreConfig, JSONObject jSONObject) {
    }

    /* loaded from: classes11.dex */
    public static class TTInjectConfig extends BaseOfflineCompoJsonParse<TTInjectConfig> implements Serializable {
        private static final long serialVersionUID = -5149616231567033422L;
        public String adAppNameKey;
        public String adIdKey;
        public String adNativeName;
        public String adPkgNameKey;
        public String adSdkName;
        public String adSlotKey;
        public String adSourceKey;
        public String bidTypeKey;
        public String callbackDrawFeedAdLoad;
        public String callbackError;
        public String callbackFeedAdLoad;
        public String callbackFullAdLoad;
        public String callbackRewardAdLoad;
        public String callbackSplashAdLoad;
        public String cpKey;
        public String createAdMethod;
        public String endCardUrlKey;
        public String feedInterfaceName;
        public String fullScreenVideoAdInteractionListenerName;
        public String getManagerMethod;
        public String getMediaExtraInfoMethod;
        public String getSdkVersionMethod;
        public String imageUrlKey;
        public String initName;
        public String key;
        public String landUrlKey1;
        public String landUrlKey2;
        public String landUrlObPrefix;
        public String loadDrawFeedMethod;
        public String loadFeedMethod;
        public String loadFullMethod;
        public String loadRewardMethod;
        public String loadSplashMethod;
        public String managerName;
        public int maxSize;
        public String maxVersion;
        public String minVersion;
        public String onAdShowMethod;
        public String onSplashAdShowMethod;
        public String pangleKeyWord;
        public String pkgNameKey;
        public String registerViewForInteraction;
        public String rewardAdInteractionListenerName;
        public String setFullScreenVideoAdInteractionListenerMethod;
        public String setRewardAdInteractionListenerMethod;
        public String setSplashListenerMethod;
        public String splashAdInteractionListenerName;
        public String targetName;
        public String targetTypeName;
        public String videoUrlKey;
        public long llsIdValidInterval = 1000;
        public List<String> passList = new ArrayList();

        @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
        public void parseJson(TTInjectConfig tTInjectConfig, JSONObject jSONObject) {
        }

        @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
        public JSONObject toJson(TTInjectConfig tTInjectConfig, JSONObject jSONObject) {
            return jSONObject == null ? new JSONObject() : jSONObject;
        }

        @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
        public JSONObject toJson(TTInjectConfig tTInjectConfig) {
            return toJson(tTInjectConfig, (JSONObject) null);
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(ExploreConfig exploreConfig, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(ExploreConfig exploreConfig) {
        return toJson(exploreConfig, (JSONObject) null);
    }
}
