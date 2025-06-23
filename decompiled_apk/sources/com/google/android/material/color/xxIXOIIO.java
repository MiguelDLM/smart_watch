package com.google.android.material.color;

import android.os.Build;
import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public final /* synthetic */ class xxIXOIIO {
    @Nullable
    public static ColorResourcesOverride oIX0oI() {
        int i = Build.VERSION.SDK_INT;
        if (30 <= i && i <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
