package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public class i extends c {
    private AdTemplate mAdTemplate;
    private String ry;

    private KsRewardVideoAd.RewardAdInteractionListener gT() {
        return f.H(getUniqueId());
    }

    private String getUniqueId() {
        return this.ry;
    }

    public final void L(String str) {
        this.ry = str;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void bJ() {
        super.bJ();
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final boolean gS() {
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        if (gT != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void h(boolean z) {
        super.h(z);
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i, int i2) {
        super.onVideoPlayError(i, i2);
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onVideoPlayError(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j) {
        super.onVideoSkipToEnd(j);
        try {
            KsRewardVideoAd.RewardAdInteractionListener gT = gT();
            if (gT != null) {
                gT.onVideoSkipToEnd(j);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final boolean h(final int i, final int i2) {
        KsRewardVideoAd.RewardAdInteractionListener gT = gT();
        if (gT != null) {
            gT.onRewardStepVerify(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.f.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i).setTaskStep(i2);
            }
        });
        return gT != null;
    }
}
