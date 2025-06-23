package com.kwad.components.core.s;

import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.api.loader.Loader;

/* loaded from: classes11.dex */
public final class l {
    public static void c(Intent intent) {
        if (intent == null) {
            return;
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        Bundle extras = intent.getExtras();
        if (externalClassLoader != null && extras != null) {
            extras.setClassLoader(externalClassLoader);
        }
    }
}
