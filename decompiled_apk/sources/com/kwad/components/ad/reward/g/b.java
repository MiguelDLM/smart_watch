package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class b {
    public static void a(KsScene ksScene, @NonNull final c cVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(true, covert.getPosId());
        boolean a2 = m.rI().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0806a().e(new ImpInfo(covert)).aJ(a2).a(new i() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List list;
                ArrayList arrayList;
                String str;
                com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
                List a3 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a3.isEmpty()) {
                    int i = e.awK.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = e.awK.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i, str);
                    com.kwad.sdk.utils.i.ao("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.zA());
                final ArrayList<KsRewardVideoAd> arrayList2 = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) a3.get(0);
                arrayList2.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a3.get(0), a3.size(), elapsedRealtime);
                d.a(SceneImpl.this, a3.size());
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        try {
                            KsAdLoadManager.M().b(arrayList2);
                            cVar.c(adTemplate, arrayList2);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        a3.get(0);
                        com.kwad.sdk.core.response.b.e.dS((AdTemplate) a3.get(0));
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList3 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate);
                final boolean Dp = com.kwad.sdk.core.config.d.Dp();
                boolean z2 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList2) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate2);
                    if (!adTemplate2.isNativeRewardPreview && !com.kwad.sdk.core.response.b.a.cM(dS)) {
                        if (com.kwad.sdk.core.response.b.a.bc(dS)) {
                            arrayList = arrayList3;
                            list = a3;
                        } else {
                            final ArrayList arrayList4 = arrayList3;
                            com.kwad.components.ad.c.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                                @Override // com.kwad.components.ad.c.a
                                public final void V() {
                                    com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                    arrayList4.add(ksRewardVideoAd);
                                    b.a(adTemplate, cVar, arrayList4);
                                }

                                @Override // com.kwad.components.ad.c.a
                                public final void W() {
                                    if (Dp) {
                                        b.a(adTemplate, cVar, arrayList2);
                                    }
                                }
                            });
                            a3 = a3;
                            arrayList3 = arrayList3;
                        }
                    } else {
                        list = a3;
                        arrayList = arrayList3;
                    }
                    arrayList.add(ksRewardVideoAd);
                    b.a(adTemplate, cVar, arrayList);
                    arrayList3 = arrayList;
                    a3 = list;
                    z2 = true;
                }
                ArrayList arrayList5 = arrayList3;
                List list2 = a3;
                com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!Dp && !z2 && arrayList5.isEmpty()) {
                    e eVar = e.awL;
                    onError(eVar.errorCode, eVar.msg);
                    com.kwad.sdk.utils.i.ao("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(true, i, str, SceneImpl.this.getPosId());
                if (i != e.awK.errorCode && i != e.awF.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i);
                }
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        cVar.onError(i, str);
                    }
                });
            }
        }).ra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.utils.i.ao("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
                int bd = com.kwad.sdk.core.response.b.a.bd(dS);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cM(dS)) {
                    arrayList.add(adTemplate);
                } else if (1 == bd && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dS))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bc(dS)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
