package com.kwad.components.ad.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: classes11.dex */
public final class c implements Runnable {
    private static final Handler nO = new Handler(Looper.getMainLooper());
    private static volatile boolean nS;
    private final long nP;
    private final AdTemplate nQ;
    private boolean nR = false;

    @Nullable
    private d nT;

    public c(@NonNull com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.nQ = adTemplate;
        long cW = com.kwad.sdk.core.response.b.a.cW(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        this.nP = cW;
        com.kwad.sdk.core.e.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + cW);
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        nS = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void eO() {
        d dVar;
        if (!b.eJ().eL()) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        nS = false;
        if (!this.nR && (dVar = this.nT) != null && dVar.eT()) {
            this.nR = true;
            this.nT.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.i.c.3
                @Override // com.kwad.components.ad.b.a.b
                public final void T() {
                    y.aM(System.currentTimeMillis());
                    e.eW().eS();
                }

                @Override // com.kwad.components.ad.b.a.b
                public final void U() {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onAdClose: ");
                    e.eW().eU();
                    b.eJ().a(c.this);
                }
            });
        }
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.nQ)) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.nP + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.ag()) {
            a(1000001, this, this.nP);
        }
    }

    public final void eN() {
        com.kwad.sdk.core.e.c.w("PushAdManager", "startRequestPushAd processingPush: " + nS);
        if (!nS && this.nQ.mAdScene != null) {
            nS = true;
            com.kwad.components.core.i.a.b(this.nQ.mAdScene, new a.InterfaceC0793a() { // from class: com.kwad.components.ad.i.c.1
                @Override // com.kwad.components.core.i.a.InterfaceC0793a
                public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onInnerAdLoad: " + list);
                    if (list != null && list.size() > 0) {
                        AdTemplate adTemplate = list.get(0).getAdTemplate();
                        if (com.kwad.sdk.core.response.b.a.cU(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
                            com.kwad.sdk.core.e.c.d("PushAdManager", "loadPushTK");
                            c.this.nT = new d(ServiceProvider.getContext(), adTemplate);
                            return;
                        }
                        c.access$002(false);
                        com.kwad.sdk.core.e.c.d("PushAdManager", "pushAdInfo templateId invalid");
                        return;
                    }
                    c.access$002(false);
                }

                @Override // com.kwad.components.core.i.a.InterfaceC0793a
                public final void onError(int i, String str) {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onError: " + str);
                    c.access$002(false);
                }

                @Override // com.kwad.components.core.i.a.InterfaceC0793a
                public final void onRequestResult(int i) {
                }
            });
        }
    }

    public final void eP() {
        com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: ");
        if (!nO.hasMessages(1000001)) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
            a(1000002, this, 500L);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.nE().isShowing()) {
            com.kwad.components.core.e.a.e.nE().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.i.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void eQ() {
                    com.kwad.components.core.e.a.e.nE().b(this);
                    c.this.eO();
                }
            });
        } else {
            eO();
        }
    }

    private static void a(int i, Runnable runnable, long j) {
        Handler handler = nO;
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i;
        handler.sendMessageDelayed(obtain, j);
    }
}
