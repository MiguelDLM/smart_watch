package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class h {
    private static volatile h RD;
    private final List<i> mListeners = new CopyOnWriteArrayList();

    private void c(final com.kwad.sdk.f.a<i> aVar) {
        bo.postOnUiThread(new az() { // from class: com.kwad.components.core.proxy.h.5
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                for (i iVar : h.this.mListeners) {
                    if (iVar != null) {
                        try {
                            aVar.accept(iVar);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                }
            }
        });
    }

    public static h qG() {
        if (RD == null) {
            synchronized (h.class) {
                try {
                    if (RD == null) {
                        RD = new h();
                    }
                } finally {
                }
            }
        }
        return RD;
    }

    public final void e(final c cVar) {
        c(new com.kwad.sdk.f.a<i>() { // from class: com.kwad.components.core.proxy.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(i iVar) {
                iVar.d(cVar);
            }
        });
    }

    public final void f(final c cVar) {
        c(new com.kwad.sdk.f.a<i>() { // from class: com.kwad.components.core.proxy.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(i iVar) {
                iVar.c(cVar);
            }
        });
    }

    public final void g(final c cVar) {
        c(new com.kwad.sdk.f.a<i>() { // from class: com.kwad.components.core.proxy.h.4
            @Override // com.kwad.sdk.f.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(final c cVar, final Bundle bundle) {
        c(new com.kwad.sdk.f.a<i>() { // from class: com.kwad.components.core.proxy.h.1
            @Override // com.kwad.sdk.f.a
            public final /* bridge */ /* synthetic */ void accept(i iVar) {
            }
        });
    }

    public final void a(i iVar) {
        this.mListeners.add(iVar);
    }
}
