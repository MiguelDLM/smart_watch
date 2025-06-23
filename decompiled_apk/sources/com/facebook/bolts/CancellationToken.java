package com.facebook.bolts;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class CancellationToken {

    @OXOo.OOXIXo
    private final CancellationTokenSource tokenSource;

    public CancellationToken(@OXOo.OOXIXo CancellationTokenSource tokenSource) {
        IIX0o.x0xO0oo(tokenSource, "tokenSource");
        this.tokenSource = tokenSource;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    @OXOo.OOXIXo
    public final CancellationTokenRegistration register(@OXOo.oOoXoXO Runnable runnable) {
        return this.tokenSource.register$facebook_bolts_release(runnable);
    }

    public final void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested$facebook_bolts_release();
    }

    @OXOo.OOXIXo
    public String toString() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationToken.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
        IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }
}
