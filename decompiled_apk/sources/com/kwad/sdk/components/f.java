package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: classes11.dex */
public final class f {
    public static boolean cZ(String str) {
        DevelopMangerComponents.DevelopValue cY = c.cY(str);
        if (cY != null && ((Boolean) cY.getValue()).booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean encryptDisable() {
        return cZ("KEY_HOST_ENCRYPT_DISABLE");
    }
}
