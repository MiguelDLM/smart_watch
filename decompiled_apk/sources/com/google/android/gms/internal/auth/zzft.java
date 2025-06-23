package com.google.android.gms.internal.auth;

/* loaded from: classes9.dex */
final class zzft {
    private static final zzfs zza;
    private static final zzfs zzb;

    static {
        zzfs zzfsVar = null;
        try {
            zzfsVar = (zzfs) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzfsVar;
        zzb = new zzfs();
    }

    public static zzfs zza() {
        return zza;
    }

    public static zzfs zzb() {
        return zzb;
    }
}
