package com.kwad.components.ad.reward.g;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.core.s.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes11.dex */
public final class c {
    private long gv;
    private KsLoadManager.RewardVideoAdListener rM;

    public c(long j, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.gv = j;
        this.rM = rewardVideoAdListener;
    }

    public final void c(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.gv, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.gv, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final void d(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.gv, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.gv, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final void onError(int i, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.rM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i, str);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.gv, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }
}
