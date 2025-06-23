package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
final class zzgm implements Iterator {
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
