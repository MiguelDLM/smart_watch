package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "FitnessDataSourcesRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public final class zzfg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfg> CREATOR = new zzfh();

    @SafeParcelable.Field(getter = "getDataTypes", id = 1)
    private final List zza;

    @SafeParcelable.Constructor
    public zzfg(@SafeParcelable.Param(id = 1) List list) {
        this.zza = list;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.zza), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List zza() {
        return Collections.unmodifiableList(this.zza);
    }
}
