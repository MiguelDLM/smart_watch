package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public final /* synthetic */ class xxIXOIIO {
    public static void II0xO0(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }

    public static boolean oIX0oI(DrmSession drmSession) {
        return false;
    }
}
