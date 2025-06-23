package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class e {
    private final List<b> Kl;
    private final Stack<AdTemplate> Km;
    private final AtomicBoolean Kn;
    private final Set<String> Ko;
    private final String TAG;
    private final AtomicBoolean oe;

    /* loaded from: classes11.dex */
    public static class a {
        private static final e Ks = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    private void ao(final AdTemplate adTemplate) {
        if (!this.Kn.get() && !this.oe.get()) {
            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showInstalledActivate");
            this.Kn.set(true);
            bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                public void nG() {
                    com.kwad.sdk.core.c.b.En();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.Kn.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.En();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.En();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            nH();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.En();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.En();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            nH();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void nH() {
                    com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow");
                    e.this.ap(adTemplate);
                    e.this.Kn.set(false);
                    e.this.Ko.remove(com.kwad.sdk.core.response.b.a.ax(com.kwad.sdk.core.response.b.e.dS(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar != null && aVar.S()) {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void U() {
                                aVar.b(this);
                                nG();
                                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    } else {
                        nG();
                    }
                }
            }, com.kwad.sdk.core.response.b.b.dm(adTemplate));
        } else {
            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "mLoadDisable: " + this.oe.get() + ", mLoadDisable: " + this.Kn.get());
            this.Km.add(adTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(AdTemplate adTemplate) {
        if (!a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void eQ() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewClose");
                e.this.dK();
                e.this.nF();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void nC() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewShow");
                e.this.ea();
            }
        })) {
            nF();
        }
    }

    public static e nE() {
        return a.Ks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void nF() {
        if (this.Km.isEmpty()) {
            return;
        }
        ao(this.Km.pop());
    }

    public final synchronized void an(AdTemplate adTemplate) {
        String ax = com.kwad.sdk.core.response.b.a.ax(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        if (com.kwad.sdk.core.response.b.b.dl(adTemplate) && !this.Ko.contains(ax)) {
            this.Ko.add(ax);
            ao(adTemplate);
        }
    }

    public final void dK() {
        this.oe.set(false);
        Iterator<b> it = this.Kl.iterator();
        while (it.hasNext()) {
            it.next().eQ();
        }
    }

    public final void ea() {
        this.oe.set(true);
        Iterator<b> it = this.Kl.iterator();
        while (it.hasNext()) {
            it.next().nC();
        }
    }

    public final boolean isShowing() {
        return this.oe.get();
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.Kl = new CopyOnWriteArrayList();
        this.Km = new Stack<>();
        this.oe = new AtomicBoolean();
        this.Kn = new AtomicBoolean();
        this.Ko = new HashSet();
    }

    public final void b(b bVar) {
        this.Kl.remove(bVar);
    }

    public final void a(b bVar) {
        this.Kl.add(bVar);
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }
}
