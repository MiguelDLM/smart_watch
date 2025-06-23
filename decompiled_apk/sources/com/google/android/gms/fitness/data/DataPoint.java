package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.util.SystemInfoUtil;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzgo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataPointCreator")
@SafeParcelable.Reserved({1000, 8})
/* loaded from: classes9.dex */
public final class DataPoint extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @ShowFirstParty
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzg();

    @SafeParcelable.Field(getter = "getDataSource", id = 1)
    private final DataSource zza;

    @SafeParcelable.Field(getter = "getTimestampNanos", id = 3)
    private long zzb;

    @SafeParcelable.Field(getter = "getStartTimeNanos", id = 4)
    private long zzc;

    @SafeParcelable.Field(getter = "getValues", id = 5)
    private final Value[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getOriginalDataSourceIfSet", id = 6)
    private DataSource zze;

    @SafeParcelable.Field(getter = "getRawTimestamp", id = 7)
    private final long zzf;

    private DataPoint(DataSource dataSource) {
        this.zza = (DataSource) Preconditions.checkNotNull(dataSource, "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzd = new Value[fields.size()];
        Iterator<Field> it = fields.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.zzd[i] = new Value(it.next().getFormat(), false, 0.0f, null, null, null, null, null);
            i++;
        }
        this.zzf = 0L;
    }

    @NonNull
    public static Builder builder(@NonNull DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource, null);
    }

    @NonNull
    @Deprecated
    public static DataPoint create(@NonNull DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    @Nullable
    public static DataPoint extract(@NonNull Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataPoint) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    @Nullable
    private static DataSource zzh(List list, int i) {
        if (i >= 0 && i < list.size()) {
            return (DataSource) list.get(i);
        }
        return null;
    }

    private final void zzi(int i) {
        List<Field> fields = getDataType().getFields();
        int size = fields.size();
        boolean z = false;
        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(size), fields};
        if (i == size) {
            z = true;
        }
        Preconditions.checkArgument(z, "Attempting to insert %s values, but needed %s: %s", objArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        if (Objects.equal(this.zza, dataPoint.zza) && this.zzb == dataPoint.zzb && this.zzc == dataPoint.zzc && Arrays.equals(this.zzd, dataPoint.zzd) && Objects.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource())) {
            return true;
        }
        return false;
    }

    @NonNull
    public DataSource getDataSource() {
        return this.zza;
    }

    @NonNull
    public DataType getDataType() {
        return this.zza.getDataType();
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public DataSource getOriginalDataSource() {
        DataSource dataSource = this.zze;
        return dataSource != null ? dataSource : this.zza;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzc, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Value getValue(@NonNull Field field) {
        return this.zzd[getDataType().indexOf(field)];
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    @NonNull
    @Deprecated
    public DataPoint setFloatValues(@NonNull float... fArr) {
        zzi(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.zzd[i].setFloat(fArr[i]);
        }
        return this;
    }

    @NonNull
    @Deprecated
    public DataPoint setIntValues(@NonNull int... iArr) {
        zzi(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.zzd[i].setInt(iArr[i]);
        }
        return this;
    }

    @NonNull
    @Deprecated
    public DataPoint setTimeInterval(long j, long j2, @NonNull TimeUnit timeUnit) {
        this.zzc = timeUnit.toNanos(j);
        this.zzb = timeUnit.toNanos(j2);
        return this;
    }

    @NonNull
    @Deprecated
    public DataPoint setTimestamp(long j, @NonNull TimeUnit timeUnit) {
        this.zzb = timeUnit.toNanos(j);
        return this;
    }

    @NonNull
    public String toString() {
        String str;
        String arrays = Arrays.toString(this.zzd);
        Long valueOf = Long.valueOf(this.zzc);
        Long valueOf2 = Long.valueOf(this.zzb);
        Long valueOf3 = Long.valueOf(this.zzf);
        String zzb = this.zza.zzb();
        DataSource dataSource = this.zze;
        if (dataSource != null) {
            str = dataSource.zzb();
        } else {
            str = SystemInfoUtil.NA;
        }
        return String.format("DataPoint{%s@[%s, %s,raw=%s](%s %s)}", arrays, valueOf, valueOf2, valueOf3, zzb, str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final long zza() {
        return this.zzf;
    }

    @ShowFirstParty
    public final long zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzb;
    }

    @Nullable
    @ShowFirstParty
    public final DataSource zzd() {
        return this.zze;
    }

    @NonNull
    public final Value zze(int i) {
        boolean z;
        DataType dataType = getDataType();
        if (i >= 0 && i < dataType.getFields().size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "fieldIndex %s is out of range for %s", Integer.valueOf(i), dataType);
        return this.zzd[i];
    }

    public final void zzf() {
        boolean z;
        boolean z2 = false;
        Preconditions.checkArgument(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        Object[] objArr = {this};
        if (this.zzb > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Data point does not have the timestamp set: %s", objArr);
        Object[] objArr2 = {this};
        if (this.zzc <= this.zzb) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Data point with start time greater than end time found: %s", objArr2);
    }

    @NonNull
    @ShowFirstParty
    public final Value[] zzg() {
        return this.zzd;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private final DataPoint zza;
        private boolean zzb = false;

        public /* synthetic */ Builder(DataSource dataSource, zzf zzfVar) {
            this.zza = DataPoint.create(dataSource);
        }

        @NonNull
        public DataPoint build() {
            Preconditions.checkState(!this.zzb, "DataPoint#build should not be called multiple times.");
            this.zzb = true;
            return this.zza;
        }

        @NonNull
        public Builder setActivityField(@NonNull Field field, @NonNull String str) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setInt(zzgo.zza(str));
            return this;
        }

        @NonNull
        public Builder setField(@NonNull Field field, float f) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setFloat(f);
            return this;
        }

        @NonNull
        public Builder setFloatValues(@NonNull float... fArr) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.setFloatValues(fArr);
            return this;
        }

        @NonNull
        public Builder setIntValues(@NonNull int... iArr) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.setIntValues(iArr);
            return this;
        }

        @NonNull
        public Builder setTimeInterval(long j, long j2, @NonNull TimeUnit timeUnit) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.setTimeInterval(j, j2, timeUnit);
            return this;
        }

        @NonNull
        public Builder setTimestamp(long j, @NonNull TimeUnit timeUnit) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.setTimestamp(j, timeUnit);
            return this;
        }

        @NonNull
        public Builder setField(@NonNull Field field, int i) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setInt(i);
            return this;
        }

        @NonNull
        public Builder setField(@NonNull Field field, @NonNull String str) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setString(str);
            return this;
        }

        @NonNull
        public Builder setField(@NonNull Field field, @NonNull Map<String, Float> map) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).zzb(map);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public DataPoint(@NonNull @SafeParcelable.Param(id = 1) DataSource dataSource, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) long j2, @NonNull @SafeParcelable.Param(id = 5) Value[] valueArr, @Nullable @SafeParcelable.Param(id = 6) DataSource dataSource2, @SafeParcelable.Param(id = 7) long j3) {
        this.zza = dataSource;
        this.zze = dataSource2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = valueArr;
        this.zzf = j3;
    }

    public DataPoint(List list, RawDataPoint rawDataPoint) {
        this((DataSource) Preconditions.checkNotNull(zzh(list, rawDataPoint.zza())), rawDataPoint.zzc(), rawDataPoint.zze(), rawDataPoint.zzf(), zzh(list, rawDataPoint.zzb()), rawDataPoint.zzd());
    }
}
