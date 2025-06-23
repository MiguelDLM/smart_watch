package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes11.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> op;

    /* loaded from: classes11.dex */
    public static class a {
        private static final c os = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c ff() {
        return a.os;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.op.remove(mVar);
    }

    public final void c(@Nullable final q qVar) {
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                c.this.b(qVar);
            }
        });
    }

    private c() {
        this.op = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable q qVar) {
        if (this.op.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.op.iterator();
        while (it.hasNext()) {
            it.next().a(qVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.op.add(mVar);
        }
    }
}
