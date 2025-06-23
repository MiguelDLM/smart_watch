package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
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
public final class f {
    public static void a(KsScene ksScene, @NonNull final e eVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(false, covert.getPosId());
        boolean a2 = m.rI().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0806a().e(new ImpInfo(covert)).aJ(a2).a(new i() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List list;
                String str;
                String str2;
                com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
                List<AdTemplate> a3 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                String str3 = "onFullScreenVideoAdCacheFailed";
                if (a3.isEmpty()) {
                    int i = com.kwad.sdk.core.network.e.awK.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str2 = com.kwad.sdk.core.network.e.awK.msg;
                    } else {
                        str2 = adResultData.testErrorMsg;
                    }
                    onError(i, str2);
                    com.kwad.sdk.utils.i.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.zA());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a3) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) a3.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, a3.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a3.size());
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate2);
                final boolean Dp = com.kwad.sdk.core.config.d.Dp();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate3);
                    if (com.kwad.sdk.core.response.b.a.bc(dS) || com.kwad.sdk.core.response.b.a.cM(dS)) {
                        list = a3;
                        str = str3;
                        arrayList2.add(ksFullScreenVideoAd);
                        f.a(adTemplate2, eVar, arrayList2);
                    } else {
                        list = a3;
                        str = str3;
                        com.kwad.components.ad.c.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.c.a
                            public final void V() {
                                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.c.a
                            public final void W() {
                                if (Dp) {
                                    f.a(adTemplate2, eVar, arrayList);
                                }
                            }
                        });
                    }
                    a3 = list;
                    str3 = str;
                }
                List list2 = a3;
                String str4 = str3;
                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!Dp && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.awL;
                    onError(eVar2.errorCode, eVar2.msg);
                    com.kwad.sdk.utils.i.ao("fullAd_", str4);
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(false, i, str, SceneImpl.this.getPosId());
                if (i != com.kwad.sdk.core.network.e.awK.errorCode && i != com.kwad.sdk.core.network.e.awF.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i);
                }
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        eVar.onError(i, str);
                    }
                });
            }
        }).ra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.utils.i.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(list);
                eVar.b(adTemplate, list);
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
                if (1 == com.kwad.sdk.core.response.b.a.bd(dS) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dS))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bc(dS)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cM(dS)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
