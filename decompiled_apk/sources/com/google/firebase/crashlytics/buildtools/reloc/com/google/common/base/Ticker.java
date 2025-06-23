package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new Ticker() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Ticker.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Ticker
        public long read() {
            return Platform.systemNanoTime();
        }
    };

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    @CanIgnoreReturnValue
    public abstract long read();
}
