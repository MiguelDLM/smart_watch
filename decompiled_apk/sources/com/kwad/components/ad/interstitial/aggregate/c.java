package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class c {
    private volatile boolean iI;
    private l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 extends j {
        final /* synthetic */ SceneImpl em;
        final /* synthetic */ b iK;
        final /* synthetic */ long ij;

        public AnonymousClass1(SceneImpl sceneImpl, b bVar, long j) {
            this.em = sceneImpl;
            this.iK = bVar;
            this.ij = j;
        }

        @Override // com.kwad.components.core.request.k
        public final void a(@NonNull final AdResultData adResultData) {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.em;
                            }
                            arrayList.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                        }
                    }
                    bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            AnonymousClass1.this.iK.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.ij);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(final int i, final String str) {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    com.kwad.sdk.core.e.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static c iQ = new c(0);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c cx() {
        return a.iQ;
    }

    public final void release() {
        l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private c() {
        this.iI = false;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.iI = false;
        return false;
    }

    public final void a(int i, int i2, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.iI) {
            return;
        }
        SceneImpl m279clone = sceneImpl.m279clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m279clone.setAdStyle(16);
        m279clone.setAdNum(i2);
        a(new ImpInfo(m279clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    private void a(ImpInfo impInfo, @NonNull final j jVar) {
        com.kwad.components.core.m.a aVar = new com.kwad.components.core.m.a(impInfo);
        this.iJ = aVar;
        aVar.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void c(@NonNull AdResultData adResultData) {
                String str;
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    j jVar2 = jVar;
                    int i = e.awK.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = e.awK.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    jVar2.onError(i, str);
                    return;
                }
                jVar.a(adResultData);
            }

            private void h(int i, String str) {
                c.a(c.this, false);
                jVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                h(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.qI().g(adTemplate, elapsedRealtime - j);
    }
}
