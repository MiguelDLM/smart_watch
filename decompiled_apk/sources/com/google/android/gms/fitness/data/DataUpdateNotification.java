package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataUpdateNotificationCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class DataUpdateNotification extends AbstractSafeParcelable {

    @NonNull
    public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";

    @NonNull
    public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new zzm();

    @NonNull
    public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 3;

    @SafeParcelable.Field(getter = "getUpdateStartTimeNanos", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getUpdateEndTimeNanos", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getOperationType", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getDataSource", id = 4)
    private final DataSource zzd;

    @SafeParcelable.Field(getter = "getDataType", id = 5)
    private final DataType zze;

    @SafeParcelable.Constructor
    public DataUpdateNotification(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) int i, @NonNull @SafeParcelable.Param(id = 4) DataSource dataSource, @NonNull @SafeParcelable.Param(id = 5) DataType dataType) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = i;
        this.zzd = dataSource;
        this.zze = dataType;
    }

    @Nullable
    public static DataUpdateNotification getDataUpdateNotification(@NonNull Intent intent) {
        return (DataUpdateNotification) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_UPDATE_NOTIFICATION, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUpdateNotification)) {
            return false;
        }
        DataUpdateNotification dataUpdateNotification = (DataUpdateNotification) obj;
        if (this.zza == dataUpdateNotification.zza && this.zzb == dataUpdateNotification.zzb && this.zzc == dataUpdateNotification.zzc && Objects.equal(this.zzd, dataUpdateNotification.zzd) && Objects.equal(this.zze, dataUpdateNotification.zze)) {
            return true;
        }
        return false;
    }

    @NonNull
    public DataSource getDataSource() {
        return this.zzd;
    }

    @NonNull
    public DataType getDataType() {
        return this.zze;
    }

    public int getOperationType() {
        return this.zzc;
    }

    public long getUpdateEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.NANOSECONDS);
    }

    public long getUpdateStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zza, TimeUnit.NANOSECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("updateStartTimeNanos", Long.valueOf(this.zza)).add("updateEndTimeNanos", Long.valueOf(this.zzb)).add("operationType", Integer.valueOf(this.zzc)).add("dataSource", this.zzd).add("dataType", this.zze).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        long j = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, getOperationType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
