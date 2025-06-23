package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes11.dex */
public final class m implements c {

    /* renamed from: com.kwad.components.core.c.m$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 extends j {
        final /* synthetic */ com.kwad.components.core.request.model.a bB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.bB = aVar2;
        }

        @Override // com.kwad.components.core.c.j
        public final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
            AdResultData d;
            final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.Gr().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                            @Override // com.kwad.components.core.c.k
                            public final void nn() {
                                RunnableC07801 runnableC07801 = RunnableC07801.this;
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (d = l.d(aVar)) != null && !d.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(d.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> l = m.l(arrayList);
                List<AdTemplate> subList = l.subList(0, Math.min(adNum, l.size()));
                if (subList != null && subList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.j, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(@NonNull final com.kwad.components.core.request.a aVar, final int i, final String str) {
            GlobalThreadPools.Gr().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                        @Override // com.kwad.components.core.c.k
                        public final void nn() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bB, i, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, k kVar) {
            AdResultData d = l.d(this.bB);
            if (d == null || d.isAdResultDataEmpty()) {
                if (kVar != null) {
                    kVar.nn();
                    return;
                }
                return;
            }
            List<AdTemplate> l = m.l(d.getProceedTemplateList());
            List<AdTemplate> subList = l.subList(0, Math.min(i, l.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.bB, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements Comparator<AdTemplate> {
        private a() {
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int eg = com.kwad.sdk.core.response.b.e.eg(adTemplate2) - com.kwad.sdk.core.response.b.e.eg(adTemplate);
            if (eg != 0) {
                return eg;
            }
            boolean z = adTemplate.fromCache;
            if (z && adTemplate2.fromCache) {
                return 0;
            }
            if (z) {
                return 1;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static List<AdTemplate> l(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long ec = com.kwad.sdk.core.response.b.e.ec(adTemplate);
            if (!hashSet.contains(Long.valueOf(ec))) {
                hashSet.add(Long.valueOf(ec));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.c.c
    public final void c(com.kwad.components.core.request.model.a aVar) {
        n.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
