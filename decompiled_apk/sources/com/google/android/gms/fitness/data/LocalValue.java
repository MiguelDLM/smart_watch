package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes9.dex */
public final class LocalValue {
    private final Value zza;

    public LocalValue(@NonNull Value value) {
        this.zza = value;
    }

    public float asFloat() {
        boolean z;
        if (this.zza.getFormat() == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in float format");
        return this.zza.zza();
    }

    public int asInt() {
        boolean z = true;
        if (this.zza.getFormat() != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.zza.zza());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalValue)) {
            return false;
        }
        return this.zza.equals(((LocalValue) obj).zza);
    }

    public int getFormat() {
        return this.zza.getFormat();
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public String toString() {
        return this.zza.toString();
    }
}
