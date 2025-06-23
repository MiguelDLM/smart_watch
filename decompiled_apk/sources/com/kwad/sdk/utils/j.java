package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes11.dex */
public abstract class j<T> {
    protected boolean JE;
    protected boolean aPE = false;

    public j(boolean z) {
        this.JE = z;
    }

    public final void bQ(boolean z) {
        this.JE = z;
    }

    @Nullable
    public final T cb(Context context) {
        if (!this.JE || this.aPE) {
            return null;
        }
        try {
            return cc(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    public abstract T cc(Context context);
}
