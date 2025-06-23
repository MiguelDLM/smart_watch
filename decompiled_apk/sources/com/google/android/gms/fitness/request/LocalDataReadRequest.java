package com.google.android.gms.fitness.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.LocalDataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class LocalDataReadRequest {
    public static final int NO_LIMIT = 0;
    private final DataReadRequest zza;

    /* loaded from: classes9.dex */
    public static class Builder {
        private long zzc;
        private long zzd;
        private TimeUnit zze;
        private TimeUnit zzg;
        private final List zza = new ArrayList();
        private final List zzb = new ArrayList();
        private int zzf = 0;
        private int zzh = 0;
        private int zzi = 0;

        @NonNull
        public Builder aggregate(@NonNull LocalDataType localDataType) {
            Preconditions.checkNotNull(localDataType, "Attempting to use a null data type");
            boolean z = true;
            Preconditions.checkState(!this.zza.contains(localDataType), "Cannot add the same data type as aggregated and detailed");
            Object[] objArr = {localDataType};
            if (localDataType.zza().getAggregateType() == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Unsupported input data type specified for aggregation: %s", objArr);
            if (!this.zzb.contains(localDataType)) {
                this.zzb.add(localDataType);
            }
            return this;
        }

        @NonNull
        public Builder bucketByTime(int i, @NonNull TimeUnit timeUnit) {
            boolean z;
            int i2 = this.zzf;
            boolean z2 = false;
            if (1 != (i2 ^ 1)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Object[] objArr = {Integer.valueOf(i)};
            if (i > 0) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Must specify a valid minimum duration: %d", objArr);
            this.zzf = 1;
            this.zzh = i;
            this.zzg = timeUnit;
            return this;
        }

        @NonNull
        public LocalDataReadRequest build() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = false;
            if (!this.zza.isEmpty() || !this.zzb.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must add at least one data type (aggregated or detailed)");
            long j = this.zzc;
            if (j > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "Invalid start time: %s", Long.valueOf(j));
            long j2 = this.zzd;
            if (j2 > 0 && j2 > this.zzc) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Invalid end time: %s", Long.valueOf(j2));
            TimeUnit timeUnit = this.zze;
            if (timeUnit != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkState(z4, "Invalid time unit: %s", timeUnit);
            boolean isEmpty = this.zzb.isEmpty();
            if (this.zzf == 0) {
                Preconditions.checkState(isEmpty, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            if (!isEmpty) {
                if (1 == this.zzf) {
                    z5 = true;
                }
                Preconditions.checkState(z5, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            return new LocalDataReadRequest(this, null);
        }

        @NonNull
        public Builder read(@NonNull LocalDataType localDataType) {
            Preconditions.checkNotNull(localDataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zzb.contains(localDataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.zza.contains(localDataType)) {
                this.zza.add(localDataType);
            }
            return this;
        }

        @NonNull
        public Builder setLimit(int i) {
            boolean z = true;
            Object[] objArr = {Integer.valueOf(i)};
            if (i <= 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "Invalid limit %d is specified", objArr);
            this.zzi = i;
            return this;
        }

        @NonNull
        public Builder setTimeRange(long j, long j2, @NonNull TimeUnit timeUnit) {
            this.zzc = j;
            this.zzd = j2;
            this.zze = timeUnit;
            return this;
        }
    }

    public /* synthetic */ LocalDataReadRequest(Builder builder, zzak zzakVar) {
        DataReadRequest.Builder builder2 = new DataReadRequest.Builder();
        Iterator it = builder.zza.iterator();
        while (it.hasNext()) {
            builder2.read(((LocalDataType) it.next()).zza());
        }
        Iterator it2 = builder.zzb.iterator();
        while (it2.hasNext()) {
            builder2.aggregate(((LocalDataType) it2.next()).zza());
        }
        builder2.setTimeRange(builder.zzc, builder.zzd, builder.zze);
        if (builder.zzh > 0) {
            builder2.bucketByTime(builder.zzh, builder.zzg);
        }
        if (builder.zzi > 0) {
            builder2.setLimit(builder.zzi);
        }
        this.zza = builder2.build();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LocalDataReadRequest) && this.zza.equals(((LocalDataReadRequest) obj).zza)) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<LocalDataType> getAggregatedDataTypes() {
        return LocalDataType.zzc(this.zza.getAggregatedDataTypes());
    }

    public long getBucketDuration(@NonNull TimeUnit timeUnit) {
        return this.zza.getBucketDuration(timeUnit);
    }

    public int getBucketType() {
        return this.zza.getBucketType();
    }

    @NonNull
    public List<LocalDataType> getDataTypes() {
        return LocalDataType.zzc(this.zza.getDataTypes());
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return this.zza.getEndTime(timeUnit);
    }

    public int getLimit() {
        return this.zza.getLimit();
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return this.zza.getStartTime(timeUnit);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public String toString() {
        return "Local".concat(this.zza.toString());
    }

    @NonNull
    public final DataReadRequest zza() {
        return this.zza;
    }
}
