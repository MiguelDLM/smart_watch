package com.kwad.components.core.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class b {
    private static volatile b TJ;

    private b() {
    }

    @NonNull
    public static b rC() {
        if (TJ == null) {
            synchronized (b.class) {
                try {
                    if (TJ == null) {
                        TJ = new b();
                    }
                } finally {
                }
            }
        }
        return TJ;
    }

    public final boolean a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean z = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.e.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean b = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z = true;
            }
            int i = adTemplate.adStyle;
            if (i == 3 || i == 2 || i == 13 || z) {
                com.kwad.sdk.core.response.b.e.dS(adTemplate);
                if (b && com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.core.s.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.components.core.c.a mU = com.kwad.components.core.c.a.mU();
                if (mU != null) {
                    mU.r(com.kwad.sdk.core.response.b.e.ec(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.nf().al(adTemplate);
        return b;
    }
}
