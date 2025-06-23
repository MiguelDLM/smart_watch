package com.kwad.components.core.i;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private static int Mw = 12;
    private static int Mx = 4;
    private static int My = 1;

    /* renamed from: com.kwad.components.core.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0793a {
        void e(@Nullable List<c> list);

        void onError(int i, String str);

        void onRequestResult(int i);
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0793a interfaceC0793a) {
        a(15, Mx, sceneImpl, e.AGGREGATION, interfaceC0793a);
    }

    private static void a(int i, int i2, @NonNull SceneImpl sceneImpl, final int i3, final InterfaceC0793a interfaceC0793a) {
        SceneImpl m279clone = sceneImpl.m279clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m279clone.setAdStyle(i);
        m279clone.setAdNum(i2);
        a(new ImpInfo(m279clone), null, false, true, new j() { // from class: com.kwad.components.core.i.a.1
            @Override // com.kwad.components.core.request.k
            public final void a(@NonNull final AdResultData adResultData) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.core.i.a.1.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        try {
                            InterfaceC0793a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                bo.runOnUiThread(new az() { // from class: com.kwad.components.core.i.a.1.3
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        InterfaceC0793a.this.e(a.b(adResultData.getAdTemplateList(), i3));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.k
            public final void onError(final int i4, final String str) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.core.i.a.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        InterfaceC0793a.this.onError(i4, str);
                    }
                });
            }
        }, false);
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0793a interfaceC0793a) {
        a(17, My, sceneImpl, e.MI, interfaceC0793a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i));
        }
        return arrayList;
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

    private static void a(final ImpInfo impInfo, List<String> list, boolean z, boolean z2, @NonNull final j jVar, boolean z3) {
        final boolean z4 = false;
        final boolean z5 = true;
        final List list2 = null;
        final boolean z6 = false;
        new com.kwad.components.core.m.a(impInfo) { // from class: com.kwad.components.core.i.a.2
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: no, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z4, null);
                aVar.aF(z5 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.i.a.3
            private void c(@NonNull AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty() && !z6) {
                    j jVar2 = jVar;
                    int i = com.kwad.sdk.core.network.e.awK.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.awK.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    jVar2.onError(i, str);
                    return;
                }
                jVar.a(adResultData);
            }

            private void h(int i, String str) {
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
}
