package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbs;
import com.google.android.gms.internal.fitness.zzbt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.text.ooOOo0oXI;

@SafeParcelable.Class(creator = "DataReadRequestCreator")
@SafeParcelable.Reserved({11, 15, 16, 17, 1000})
/* loaded from: classes9.dex */
public class DataReadRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzm();
    public static final int NO_LIMIT = 0;

    @SafeParcelable.Field(getter = "getDataTypes", id = 1)
    private final List zza;

    @SafeParcelable.Field(getter = "getDataSources", id = 2)
    private final List zzb;

    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 3)
    private final long zzc;

    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 4)
    private final long zzd;

    @SafeParcelable.Field(getter = "getAggregatedDataTypes", id = 5)
    private final List zze;

    @SafeParcelable.Field(getter = "getAggregatedDataSources", id = 6)
    private final List zzf;

    @SafeParcelable.Field(getter = "getBucketType", id = 7)
    private final int zzg;

    @SafeParcelable.Field(getter = "getBucketDurationMillis", id = 8)
    private final long zzh;

    @SafeParcelable.Field(getter = "getActivityDataSource", id = 9)
    private final DataSource zzi;

    @SafeParcelable.Field(getter = "getLimit", id = 10)
    private final int zzj;

    @SafeParcelable.Field(getter = "flushBufferBeforeRead", id = 12)
    private final boolean zzk;

    @SafeParcelable.Field(getter = "areServerQueriesEnabled", id = 13)
    private final boolean zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 14, type = "android.os.IBinder")
    private final zzbt zzm;

    @SafeParcelable.Field(getter = "getIntervalStartTimesNanos", id = 18)
    private final List zzn;

    @SafeParcelable.Field(getter = "getIntervalEndTimesNanos", id = 19)
    private final List zzo;

    public DataReadRequest(DataReadRequest dataReadRequest, zzbt zzbtVar) {
        this(dataReadRequest.zza, dataReadRequest.zzb, dataReadRequest.zzc, dataReadRequest.zzd, dataReadRequest.zze, dataReadRequest.zzf, dataReadRequest.zzg, dataReadRequest.zzh, dataReadRequest.zzi, dataReadRequest.zzj, dataReadRequest.zzk, dataReadRequest.zzl, zzbtVar, dataReadRequest.zzn, dataReadRequest.zzo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataReadRequest) {
            DataReadRequest dataReadRequest = (DataReadRequest) obj;
            if (this.zza.equals(dataReadRequest.zza) && this.zzb.equals(dataReadRequest.zzb) && this.zzc == dataReadRequest.zzc && this.zzd == dataReadRequest.zzd && this.zzg == dataReadRequest.zzg && this.zzf.equals(dataReadRequest.zzf) && this.zze.equals(dataReadRequest.zze) && Objects.equal(this.zzi, dataReadRequest.zzi) && this.zzh == dataReadRequest.zzh && this.zzl == dataReadRequest.zzl && this.zzj == dataReadRequest.zzj && this.zzk == dataReadRequest.zzk && Objects.equal(this.zzm, dataReadRequest.zzm)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public DataSource getActivityDataSource() {
        return this.zzi;
    }

    @NonNull
    public List<DataSource> getAggregatedDataSources() {
        return this.zzf;
    }

    @NonNull
    public List<DataType> getAggregatedDataTypes() {
        return this.zze;
    }

    public long getBucketDuration(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzh, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzg;
    }

    @NonNull
    public List<DataSource> getDataSources() {
        return this.zzb;
    }

    @NonNull
    public List<DataType> getDataTypes() {
        return this.zza;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzd, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzj;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzc, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzg), Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.zza.isEmpty()) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                sb.append(((DataType) it.next()).zzc());
                sb.append(" ");
            }
        }
        if (!this.zzb.isEmpty()) {
            Iterator it2 = this.zzb.iterator();
            while (it2.hasNext()) {
                sb.append(((DataSource) it2.next()).zzb());
                sb.append(" ");
            }
        }
        if (this.zzg != 0) {
            sb.append("bucket by ");
            sb.append(Bucket.zzd(this.zzg));
            if (this.zzh > 0) {
                sb.append(" >");
                sb.append(this.zzh);
                sb.append("ms");
            }
            sb.append(": ");
        }
        if (!this.zze.isEmpty()) {
            Iterator it3 = this.zze.iterator();
            while (it3.hasNext()) {
                sb.append(((DataType) it3.next()).zzc());
                sb.append(" ");
            }
        }
        if (!this.zzf.isEmpty()) {
            Iterator it4 = this.zzf.iterator();
            while (it4.hasNext()) {
                sb.append(((DataSource) it4.next()).zzb());
                sb.append(" ");
            }
        }
        sb.append(String.format(Locale.US, "(%tF %tT - %tF %tT)", Long.valueOf(this.zzc), Long.valueOf(this.zzc), Long.valueOf(this.zzd), Long.valueOf(this.zzd)));
        if (this.zzi != null) {
            sb.append("activities: ");
            sb.append(this.zzi.zzb());
        }
        if (this.zzl) {
            sb.append(" +server");
        }
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getDataSources(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, getAggregatedDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getAggregatedDataSources(), false);
        SafeParcelWriter.writeInt(parcel, 7, getBucketType());
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 9, getActivityDataSource(), i, false);
        SafeParcelWriter.writeInt(parcel, 10, getLimit());
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        zzbt zzbtVar = this.zzm;
        if (zzbtVar == null) {
            asBinder = null;
        } else {
            asBinder = zzbtVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 14, asBinder, false);
        SafeParcelWriter.writeLongList(parcel, 18, this.zzn, false);
        SafeParcelWriter.writeLongList(parcel, 19, this.zzo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public DataReadRequest(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) List list2, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) long j2, @SafeParcelable.Param(id = 5) List list3, @SafeParcelable.Param(id = 6) List list4, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 9) DataSource dataSource, @SafeParcelable.Param(id = 10) int i2, @SafeParcelable.Param(id = 12) boolean z, @SafeParcelable.Param(id = 13) boolean z2, @Nullable @SafeParcelable.Param(id = 14) IBinder iBinder, @SafeParcelable.Param(id = 18) List list5, @SafeParcelable.Param(id = 19) List list6) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = list3;
        this.zzf = list4;
        this.zzg = i;
        this.zzh = j3;
        this.zzi = dataSource;
        this.zzj = i2;
        this.zzk = z;
        this.zzl = z2;
        this.zzm = iBinder == null ? null : zzbs.zzc(iBinder);
        List emptyList = list5 == null ? Collections.emptyList() : list5;
        this.zzn = emptyList;
        List emptyList2 = list6 == null ? Collections.emptyList() : list6;
        this.zzo = emptyList2;
        Preconditions.checkArgument(emptyList.size() == emptyList2.size(), "Unequal number of interval start and end times.");
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private DataSource zze;
        private long zzf;
        private long zzg;
        private final List zza = new ArrayList();
        private final List zzb = new ArrayList();
        private final List zzc = new ArrayList();
        private final List zzd = new ArrayList();
        private final List zzh = new ArrayList();
        private final List zzi = new ArrayList();
        private int zzj = 0;
        private long zzk = 0;
        private int zzl = 0;
        private boolean zzm = false;

        @NonNull
        public Builder aggregate(@NonNull DataSource dataSource) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            Preconditions.checkState(!this.zzb.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            Preconditions.checkArgument(dataType.getAggregateType() != null, "Unsupported input data type specified for aggregation: %s", dataType);
            if (!this.zzd.contains(dataSource)) {
                this.zzd.add(dataSource);
            }
            return this;
        }

        @NonNull
        public Builder bucketByActivitySegment(int i, @NonNull TimeUnit timeUnit) {
            int i2 = this.zzj;
            Preconditions.checkArgument(i2 == 0, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzj = 4;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public Builder bucketByActivityType(int i, @NonNull TimeUnit timeUnit) {
            int i2 = this.zzj;
            Preconditions.checkArgument(i2 == 0, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzj = 3;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public Builder bucketBySession(int i, @NonNull TimeUnit timeUnit) {
            boolean z;
            int i2 = this.zzj;
            boolean z2 = true;
            Object[] objArr = {Integer.valueOf(i2)};
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Bucketing strategy already set to %s", objArr);
            Object[] objArr2 = {Integer.valueOf(i)};
            if (i <= 0) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Must specify a valid minimum duration for a session: %d", objArr2);
            this.zzj = 2;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public Builder bucketByTime(int i, @NonNull TimeUnit timeUnit) {
            boolean z;
            int i2 = this.zzj;
            boolean z2 = false;
            Object[] objArr = {Integer.valueOf(i2)};
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Bucketing strategy already set to %s", objArr);
            Object[] objArr2 = {Integer.valueOf(i)};
            if (i > 0) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Must specify a valid minimum duration: %d", objArr2);
            this.zzj = 1;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public DataReadRequest build() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = false;
            if (!this.zzb.isEmpty() || !this.zza.isEmpty() || !this.zzd.isEmpty() || !this.zzc.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must add at least one data source (aggregated or detailed)");
            long j = this.zzf;
            if (j > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "Invalid start time: %s", Long.valueOf(j));
            long j2 = this.zzg;
            if (j2 > 0 && j2 > this.zzf) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Invalid end time: %s", Long.valueOf(j2));
            if (this.zzd.isEmpty() && this.zzc.isEmpty()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (this.zzj == 0) {
                Preconditions.checkState(z4, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            if (!z4) {
                if (this.zzj != 0) {
                    z5 = true;
                }
                Preconditions.checkState(z5, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            return new DataReadRequest(this.zza, this.zzb, this.zzf, this.zzg, this.zzc, this.zzd, this.zzj, this.zzk, this.zze, this.zzl, false, this.zzm, (zzbt) null, this.zzh, this.zzi);
        }

        @NonNull
        public Builder enableServerQueries() {
            this.zzm = true;
            return this;
        }

        @NonNull
        public Builder read(@NonNull DataSource dataSource) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            Preconditions.checkArgument(!this.zzd.contains(dataSource), "Cannot add the same data source as aggregated and detailed");
            if (!this.zzb.contains(dataSource)) {
                this.zzb.add(dataSource);
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
            this.zzl = i;
            return this;
        }

        @NonNull
        public Builder setTimeRange(long j, long j2, @NonNull TimeUnit timeUnit) {
            this.zzf = timeUnit.toMillis(j);
            this.zzg = timeUnit.toMillis(j2);
            return this;
        }

        @NonNull
        public Builder bucketByActivitySegment(int i, @NonNull TimeUnit timeUnit, @NonNull DataSource dataSource) {
            int i2 = this.zzj;
            Preconditions.checkArgument(i2 == 0, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            Preconditions.checkArgument(dataSource != null, "Invalid activity data source specified");
            Preconditions.checkArgument(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zze = dataSource;
            this.zzj = 4;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public Builder bucketByActivityType(int i, @NonNull TimeUnit timeUnit, @NonNull DataSource dataSource) {
            int i2 = this.zzj;
            Preconditions.checkArgument(i2 == 0, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            Preconditions.checkArgument(dataSource != null, "Invalid activity data source specified");
            Preconditions.checkArgument(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zze = dataSource;
            this.zzj = 3;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        @NonNull
        public Builder read(@NonNull DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zzc.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.zza.contains(dataType)) {
                this.zza.add(dataType);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder aggregate(@NonNull DataSource dataSource, @NonNull DataType dataType) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            Preconditions.checkState(!this.zzb.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            DataType aggregateType = dataType2.getAggregateType();
            if (aggregateType != null) {
                Preconditions.checkArgument(aggregateType.equals(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
                if (!this.zzd.contains(dataSource)) {
                    this.zzd.add(dataSource);
                }
                return this;
            }
            throw new IllegalArgumentException("Unsupported input data type specified for aggregation: ".concat(String.valueOf(dataType2)));
        }

        @NonNull
        public Builder aggregate(@NonNull DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zza.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            Preconditions.checkArgument(dataType.getAggregateType() != null, "Unsupported input data type specified for aggregation: %s", dataType);
            if (!this.zzc.contains(dataType)) {
                this.zzc.add(dataType);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder aggregate(@NonNull DataType dataType, @NonNull DataType dataType2) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zza.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            DataType aggregateType = dataType.getAggregateType();
            if (aggregateType != null) {
                Preconditions.checkArgument(aggregateType.equals(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
                if (!this.zzc.contains(dataType)) {
                    this.zzc.add(dataType);
                }
                return this;
            }
            throw new IllegalArgumentException("Unsupported input data type specified for aggregation: ".concat(String.valueOf(dataType)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r17v2 */
    public DataReadRequest(List list, List list2, long j, long j2, List list3, List list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, @Nullable zzbt zzbtVar, List list5, List list6) {
        this(list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, (IBinder) (zzbtVar == null ? 0 : zzbtVar), list5, list6);
    }
}
