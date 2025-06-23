package com.google.android.gms.internal.fitness;

import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
final class zzgb extends zzgm {
    private final Object zza;
    private boolean zzb;

    public zzgb(Object obj) {
        this.zza = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzb) {
            this.zzb = true;
            return this.zza;
        }
        throw new NoSuchElementException();
    }
}
