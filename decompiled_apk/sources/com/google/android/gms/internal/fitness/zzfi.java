package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

@SafeParcelable.Class(creator = "FitnessUnregistrationRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public final class zzfi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfi> CREATOR = new zzfj();

    @SafeParcelable.Field(getter = "getDataSource", id = 1)
    private final DataSource zza;

    @SafeParcelable.Constructor
    public zzfi(@SafeParcelable.Param(id = 1) DataSource dataSource) {
        this.zza = dataSource;
    }

    public final String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataSource zza() {
        return this.zza;
    }
}
