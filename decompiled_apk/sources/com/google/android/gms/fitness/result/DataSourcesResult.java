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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DataSourcesResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class DataSourcesResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zzd();

    @SafeParcelable.Field(getter = "getDataSources", id = 1)
    private final List zza;

    @SafeParcelable.Field(getter = "getStatus", id = 2)
    private final Status zzb;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public DataSourcesResult(@NonNull @SafeParcelable.Param(id = 1) List list, @NonNull @SafeParcelable.Param(id = 2) Status status) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = status;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataSourcesResult) {
            DataSourcesResult dataSourcesResult = (DataSourcesResult) obj;
            if (this.zzb.equals(dataSourcesResult.zzb) && Objects.equal(this.zza, dataSourcesResult.zza)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @NonNull
    public List<DataSource> getDataSources() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzb).add("dataSources", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataSources(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public List<DataSource> getDataSources(@NonNull DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (DataSource dataSource : this.zza) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
