package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: ox, reason: collision with root package name */
    private final AdGlobalConfigInfo f18439ox;
    private com.kwad.components.ad.reward.e.h oy;
    private com.kwad.components.core.i.d oz;
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(n);
        this.f18439ox = adResultData.adGlobalConfigInfo;
        fi();
    }

    private void fi() {
        boolean z;
        com.kwad.components.ad.i.b.eJ().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.f18439ox;
        boolean z2 = false;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan()) {
            z = true;
        } else {
            z = false;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.bY(this.mAdInfo) && !z) {
            z2 = true;
        }
        adTemplate.isNativeRewardPreview = z2;
    }

    private void fj() {
        AdInfo adInfo;
        if (!com.kwad.components.ad.reward.c.c.a(this.oy) && (adInfo = this.mAdInfo) != null) {
            adInfo.adBaseInfo.extraClickReward = false;
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aP(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aug) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            Iterator<AdTemplate> it = this.mAdResultData.getAdTemplateList().iterator();
            while (it.hasNext()) {
                arrayList.add(com.kwad.sdk.core.response.b.a.dc(com.kwad.sdk.core.response.b.e.dS(it.next())));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bd(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.CH()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.ei(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.j.ay(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.oz = new com.kwad.components.core.i.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.oy == null) {
            this.oy = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bZ.i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bZ.h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.oy.b(rewardAdInteractionListener);
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            com.kwad.components.ad.reward.monitor.c.h(true, this.mAdTemplate);
            com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
            if (!com.kwad.sdk.core.config.d.Dp() && !isAdEnable()) {
                com.kwad.sdk.core.e.c.i("KsRewardVideoAdControl", "isAdEnable is false");
                com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "cache_not_ready");
                return;
            } else {
                if (ksVideoPlayConfig == null) {
                    ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
                }
                a(activity, ksVideoPlayConfig);
                return;
            }
        }
        com.kwad.sdk.core.e.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
        com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j2);
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        fj();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, com.kwad.sdk.core.response.b.a.aR(this.mAdInfo), this.oy);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.oy, this.oz, this.rewardType);
        }
    }
}
