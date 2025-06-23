package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

@SafeParcelable.Class(creator = "DataTypeResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes9.dex */
public class DataTypeResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zze();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDataType", id = 3)
    private final DataType zzb;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public DataTypeResult(@NonNull @SafeParcelable.Param(id = 1) Status status, @Nullable @SafeParcelable.Param(id = 3) DataType dataType) {
        this.zza = status;
        this.zzb = dataType;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataTypeResult)) {
            return false;
        }
        DataTypeResult dataTypeResult = (DataTypeResult) obj;
        if (this.zza.equals(dataTypeResult.zza) && Objects.equal(this.zzb, dataTypeResult.zzb)) {
            return true;
        }
        return false;
    }

    @Nullable
    public DataType getDataType() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zza).add("dataType", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
