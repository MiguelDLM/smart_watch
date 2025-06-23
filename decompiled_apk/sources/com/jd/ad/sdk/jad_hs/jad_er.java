package com.jd.ad.sdk.jad_hs;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes10.dex */
public final class jad_er extends IOException {
    public jad_er(String str, int i, @Nullable Throwable th) {
        super(str + ", status code: " + i, th);
    }
}
