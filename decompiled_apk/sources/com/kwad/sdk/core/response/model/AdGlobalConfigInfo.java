package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes11.dex */
public class AdGlobalConfigInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -2622260965144406821L;

    @Nullable
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;

    @KsJson
    /* loaded from: classes11.dex */
    public static class NeoScanAggregationSceneInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -4381505798843439175L;
        public boolean guidSwipezShowMore;
        public boolean mute;
        public boolean neoCountDownNeedSwipeTrigger;
        public int neoCountDownTime;
        public boolean noActionStopCountDown;
        public int noActionTime;
    }

    public boolean isNeoScan() {
        if (this.neoPageType == 1) {
            return true;
        }
        return false;
    }
}
