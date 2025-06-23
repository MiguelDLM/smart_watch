package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class f {
    public static String c(@NonNull AdTemplate adTemplate) {
        String str;
        String at = com.kwad.sdk.core.response.b.a.at(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        if (com.kwad.components.core.c.b.mW()) {
            if (adTemplate.fromCache) {
                str = "【cache】";
            } else {
                str = "";
            }
            return str + at;
        }
        return at;
    }
}
