package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "RawDataPointCreator")
@SafeParcelable.Reserved({1000, 7})
@ShowFirstParty
@KeepName
/* loaded from: classes9.dex */
public final class RawDataPoint extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzaa();

    @SafeParcelable.Field(getter = "getEndTimeNanos", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getStartTimeNanos", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getValues", id = 3)
    private final Value[] zzc;

    @SafeParcelable.Field(getter = "getDataSourceIndex", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "getOriginalDataSourceIndex", id = 5)
    private final int zze;

    @SafeParcelable.Field(getter = "getRawTimestamp", id = 6)
    private final long zzf;

    @SafeParcelable.Constructor
    public RawDataPoint(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @NonNull @SafeParcelable.Param(id = 3) Value[] valueArr, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzd = i;
        this.zze = i2;
        this.zzf = j3;
        this.zzc = valueArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        if (this.zza == rawDataPoint.zza && this.zzb == rawDataPoint.zzb && Arrays.equals(this.zzc, rawDataPoint.zzc) && this.zzd == rawDataPoint.zzd && this.zze == rawDataPoint.zze && this.zzf == rawDataPoint.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }

    @NonNull
    public final String toString() {
        return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zzc), Long.valueOf(this.zzb), Long.valueOf(this.zza), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zza;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze() {
        return this.zzb;
    }

    @NonNull
    public final Value[] zzf() {
        return this.zzc;
    }

    public RawDataPoint(DataPoint dataPoint, List list) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.zza = dataPoint.getTimestamp(timeUnit);
        this.zzb = dataPoint.getStartTime(timeUnit);
        this.zzc = dataPoint.zzg();
        this.zzd = com.google.android.gms.internal.fitness.zzd.zza(dataPoint.getDataSource(), list);
        this.zze = com.google.android.gms.internal.fitness.zzd.zza(dataPoint.zzd(), list);
        this.zzf = dataPoint.zza();
    }
}
