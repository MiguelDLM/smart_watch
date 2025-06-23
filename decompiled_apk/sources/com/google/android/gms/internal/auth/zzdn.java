package com.google.android.gms.internal.auth;

import XXO0.oIX0oI;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
final class zzdn implements Serializable, zzdj {
    final Object zza;

    public zzdn(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzdn)) {
            return false;
        }
        Object obj2 = this.zza;
        Object obj3 = ((zzdn) obj).zza;
        if (obj2 != obj3 && !obj2.equals(obj3)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.zza.toString() + oIX0oI.I0Io.f4095I0Io;
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        return this.zza;
    }
}
