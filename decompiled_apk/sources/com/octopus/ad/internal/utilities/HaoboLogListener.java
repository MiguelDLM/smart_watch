package com.octopus.ad.internal.utilities;

/* loaded from: classes11.dex */
public abstract class HaoboLogListener {

    /* loaded from: classes11.dex */
    public enum LOG_LEVEL {
        V,
        D,
        I,
        W,
        E
    }

    public abstract void I0Io(LOG_LEVEL log_level, String str, String str2, Throwable th);

    public abstract void II0xO0(LOG_LEVEL log_level, String str, String str2);

    public abstract LOG_LEVEL oIX0oI();
}
