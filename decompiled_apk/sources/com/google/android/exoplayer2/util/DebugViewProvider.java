package com.google.android.exoplayer2.util;

import android.view.SurfaceView;
import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new DebugViewProvider() { // from class: com.google.android.exoplayer2.util.oIX0oI
        @Override // com.google.android.exoplayer2.util.DebugViewProvider
        public final SurfaceView getDebugPreviewSurfaceView(int i, int i2) {
            return II0xO0.oIX0oI(i, i2);
        }
    };

    @Nullable
    SurfaceView getDebugPreviewSurfaceView(int i, int i2);
}
