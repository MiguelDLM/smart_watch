package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "MapValueCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class MapValue extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<MapValue> CREATOR = new zzx();

    @SafeParcelable.Field(getter = "getFormat", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getValue", id = 2)
    private final float zzb;

    @SafeParcelable.Constructor
    public MapValue(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) float f) {
        this.zza = i;
        this.zzb = f;
    }

    @NonNull
    public static MapValue zzb(float f) {
        return new MapValue(2, f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        int i = this.zza;
        if (i == mapValue.zza) {
            if (i != 2) {
                if (this.zzb == mapValue.zzb) {
                    return true;
                }
                return false;
            }
            if (zza() == mapValue.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zzb;
    }

    @NonNull
    public final String toString() {
        if (this.zza != 2) {
            return "unknown";
        }
        return Float.toString(zza());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        boolean z;
        if (this.zza == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in float format");
        return this.zzb;
    }
}
