package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* loaded from: classes9.dex */
final class zzdw extends zzdy {
    final /* synthetic */ zzef zza;
    private int zzb = 0;
    private final int zzc;

    public zzdw(zzef zzefVar) {
        this.zza = zzefVar;
        this.zzc = zzefVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzea
    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
