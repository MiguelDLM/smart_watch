package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

@SafeParcelable.Class(creator = "DailyTotalResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class DailyTotalResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zza;

    @Nullable
    @SafeParcelable.Field(getter = "getTotal", id = 2)
    private final DataSet zzb;

    @SafeParcelable.Constructor
    public DailyTotalResult(@NonNull @SafeParcelable.Param(id = 1) Status status, @Nullable @SafeParcelable.Param(id = 2) DataSet dataSet) {
        this.zza = status;
        this.zzb = dataSet;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyTotalResult)) {
            return false;
        }
        DailyTotalResult dailyTotalResult = (DailyTotalResult) obj;
        if (this.zza.equals(dailyTotalResult.zza) && Objects.equal(this.zzb, dailyTotalResult.zzb)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zza;
    }

    @Nullable
    public DataSet getTotal() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zza).add("dataPoint", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getTotal(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
