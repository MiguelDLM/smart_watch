package com.google.android.gms.internal.maps;

/* loaded from: classes9.dex */
final class zzbg extends zzbc {
    private final zzbi zza;

    public zzbg(zzbi zzbiVar, int i) {
        super(zzbiVar.size(), i);
        this.zza = zzbiVar;
    }

    @Override // com.google.android.gms.internal.maps.zzbc
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
