package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class p extends ak {
    private WeakReference<com.kwad.components.ad.reward.g> qi;
    private long xn;

    /* renamed from: xo, reason: collision with root package name */
    private String f18445xo;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.f18445xo = str;
        this.xn = j;
        if (gVar != null) {
            this.qi = new WeakReference<>(gVar);
        }
    }

    private static boolean R(String str) {
        try {
            if (new JSONObject(str).optInt("elementType") == 18) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z, adTemplate, null, bVar);
    }

    private boolean b(ak.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() != 140 || !com.kwad.sdk.core.config.d.zz() || !R(bVar.sT()) || (weakReference = this.qi) == null || weakReference.get() == null) {
            return false;
        }
        final com.kwad.components.ad.reward.g gVar = this.qi.get();
        bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.reward.k.p.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                gVar.y(p.this.f18445xo);
            }
        }, 1500L);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(@NonNull ak.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.qi;
        if (weakReference != null && weakReference.get() != null) {
            bVar.ao(this.qi.get().oK.getPlayDuration());
            return;
        }
        long j = this.xn;
        if (j > 0) {
            bVar.ao(j);
        }
    }
}
