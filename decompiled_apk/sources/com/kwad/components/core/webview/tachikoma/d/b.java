package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes11.dex */
public final class b {
    private final Set<e> abI;

    /* loaded from: classes11.dex */
    public static class a {
        private static final b abO = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        if (this.abI.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.abI).iterator();
        while (it.hasNext()) {
            ((e) it.next()).q(str2);
        }
    }

    public static b tG() {
        return a.abO;
    }

    public final void b(e eVar) {
        this.abI.remove(eVar);
    }

    public final void c(final String str, final long j, final long j2, final long j3) {
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.d.b.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.this.b(str, j, j2, j3);
            }
        });
    }

    public final void s(final String str, final String str2) {
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.d.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.this.r(str, str2);
            }
        });
    }

    public final void tH() {
        this.abI.clear();
    }

    private b() {
        this.abI = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, long j2, long j3) {
        if (this.abI.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.abI).iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(str, j, j2, j3);
        }
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.abI.add(eVar);
        }
    }
}
