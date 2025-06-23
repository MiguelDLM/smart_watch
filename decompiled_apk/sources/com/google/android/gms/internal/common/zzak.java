package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.DoNotCall;
import java.util.ListIterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: classes9.dex */
public abstract class zzak extends zzaj implements ListIterator {
    @Override // java.util.ListIterator
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
