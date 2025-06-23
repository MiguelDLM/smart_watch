package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class b {
    private final List<a> RW;

    /* loaded from: classes11.dex */
    public interface a {
        void qP();
    }

    /* renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0805b {
        private static final b RX = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b qN() {
        return C0805b.RX;
    }

    public final void a(a aVar) {
        this.RW.add(aVar);
    }

    public final void b(a aVar) {
        this.RW.remove(aVar);
    }

    public final void qO() {
        for (a aVar : this.RW) {
            if (aVar != null) {
                try {
                    aVar.qP();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private b() {
        this.RW = new CopyOnWriteArrayList();
    }
}
