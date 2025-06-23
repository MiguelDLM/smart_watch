package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class q extends x {
    private long vA;
    private WeakReference<com.kwad.components.ad.reward.g> xq;

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.components.ad.reward.g gVar, long j, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.vA = j;
        if (gVar != null) {
            this.xq = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    public final a.C0788a a(a.C0788a c0788a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long j;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.xq;
        if (weakReference != null && weakReference.get() != null) {
            j = this.xq.get().oK.getPlayDuration();
        } else {
            j = this.vA;
            if (j <= 0) {
                j = 0;
            }
        }
        return super.a(c0788a, aVar, adTemplate).w(j);
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    public final void ji() {
        super.ji();
        if (this.WQ != null) {
            com.kwad.components.ad.reward.c.a.gM().c(this.WQ.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}
