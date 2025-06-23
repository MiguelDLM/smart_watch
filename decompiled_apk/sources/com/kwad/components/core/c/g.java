package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public class g {
    private static volatile g JJ;
    private ConcurrentHashMap<String, WeakReference<Object>> JI = new ConcurrentHashMap<>();

    private static String am(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.dL(adTemplate) + HelpFormatter.DEFAULT_OPT_PREFIX + com.kwad.sdk.core.response.b.e.ec(adTemplate);
    }

    private static String b(h hVar) {
        return hVar.ng() + HelpFormatter.DEFAULT_OPT_PREFIX + hVar.nm();
    }

    @NonNull
    public static g nf() {
        if (JJ == null) {
            synchronized (g.class) {
                try {
                    if (JJ == null) {
                        JJ = new g();
                    }
                } finally {
                }
            }
        }
        return JJ;
    }

    public final boolean a(h hVar) {
        String b = b(hVar);
        com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains key: " + b);
        boolean z = false;
        if (!this.JI.containsKey(b)) {
            return false;
        }
        WeakReference<Object> weakReference = this.JI.get(b);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.JI.put(am(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void al(AdTemplate adTemplate) {
        this.JI.remove(am(adTemplate));
    }
}
