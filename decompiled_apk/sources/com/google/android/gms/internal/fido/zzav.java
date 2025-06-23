package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
final class zzav extends zzaz {
    boolean zza;
    final /* synthetic */ Object zzb;

    public zzav(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
