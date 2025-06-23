package com.kwad.sdk.core.webview.b.b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.m;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0860a {
        void c(com.kwad.sdk.g.a.b bVar);

        void d(com.kwad.sdk.g.a.b bVar);

        void e(com.kwad.sdk.g.a.b bVar);
    }

    public static void a(final com.kwad.sdk.g.a.b bVar, @NonNull final InterfaceC0860a interfaceC0860a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0860a.c(bVar);
        bVar.aG(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.aw(l.ON());
        r.vy();
        r.bf(bVar.packageUrl).e(bVar).bc(bVar.aJo).bb(true).a(new m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0860a.this.e((com.kwad.sdk.g.a.b) aVar.getTag());
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.uz() == -3) {
                    InterfaceC0860a.this.d(bVar);
                    return;
                }
                InterfaceC0860a.this.e(bVar);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.uz()));
            }
        }).start();
    }
}
