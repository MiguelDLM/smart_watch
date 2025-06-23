package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.core.widget.a.b {
    public d(@NonNull View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean dX() {
        com.kwad.sdk.core.c.b.En();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.En();
            if (com.kwad.sdk.core.c.b.isAppOnForeground() && super.dX()) {
                return true;
            }
            return false;
        }
        return super.dX();
    }
}
