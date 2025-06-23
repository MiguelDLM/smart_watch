package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class j extends com.kwad.components.ad.l.b {

    @Nullable
    private com.kwad.components.ad.reward.c.d qh;
    private WeakReference<g> qi;

    public j(g gVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.qi = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void fn() {
        g gVar;
        boolean z;
        WeakReference<g> weakReference = this.qi;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.components.ad.reward.monitor.c.a(z, "end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void fo() {
        g gVar;
        boolean z;
        WeakReference<g> weakReference = this.qi;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            z = true;
        } else {
            z = false;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, z, "end_card", B(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void fp() {
        g gVar;
        boolean z;
        WeakReference<g> weakReference = this.qi;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.components.ad.reward.monitor.c.a(z, "end_card", B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    public final void a(@Nullable com.kwad.components.ad.reward.c.d dVar) {
        this.qh = dVar;
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.cL.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.qh != null) {
                    j.this.qh.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.h(new com.kwad.components.core.webview.jshandler.n() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(com.kwad.components.core.webview.jshandler.h hVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    hVar.a(com.kwad.components.ad.reward.c.a.gM().gN());
                }
            }
        }));
        WeakReference<g> weakReference = this.qi;
        aVar.b(new p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.cO));
    }
}
