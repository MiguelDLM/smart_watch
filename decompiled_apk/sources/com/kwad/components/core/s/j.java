package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class j {
    public static boolean d(@NonNull AdTemplate adTemplate, boolean z) {
        if (z || !com.kwad.sdk.core.response.b.b.dq(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            return false;
        }
        return com.kwad.sdk.core.config.d.Dn();
    }

    public static void e(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0788a(context).am(true).ar(adTemplate));
    }
}
