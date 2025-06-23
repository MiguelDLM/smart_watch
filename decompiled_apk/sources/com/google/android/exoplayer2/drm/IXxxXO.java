package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;

/* loaded from: classes9.dex */
public final /* synthetic */ class IXxxXO {
    static {
        DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static DrmSessionManager.DrmSessionReference oIX0oI(DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionManager.DrmSessionReference.EMPTY;
    }

    @Deprecated
    public static DrmSessionManager oxoX() {
        return DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static void I0Io(DrmSessionManager drmSessionManager) {
    }

    public static void II0xO0(DrmSessionManager drmSessionManager) {
    }
}
