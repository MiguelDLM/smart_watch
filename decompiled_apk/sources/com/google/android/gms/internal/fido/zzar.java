package com.google.android.gms.internal.fido;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzar extends zzao {
    private final zzat zza;

    public zzar(zzat zzatVar, int i) {
        super(zzatVar.size(), i);
        this.zza = zzatVar;
    }

    @Override // com.google.android.gms.internal.fido.zzao
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
