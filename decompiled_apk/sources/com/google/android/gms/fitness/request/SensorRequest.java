package com.google.android.gms.fitness.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;

    @Nullable
    private final DataSource zza;

    @Nullable
    private final DataType zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final int zzf;
    private final long zzg;

    /* loaded from: classes9.dex */
    public static class Builder {
        private DataSource zza;
        private DataType zzb;
        private long zzc = -1;
        private long zzd = 0;
        private long zze = 0;
        private boolean zzf = false;
        private int zzg = 2;
        private long zzh = Long.MAX_VALUE;

        @NonNull
        public SensorRequest build() {
            boolean z;
            DataSource dataSource;
            boolean z2 = false;
            if (this.zza != null || this.zzb != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must call setDataSource() or setDataType()");
            DataType dataType = this.zzb;
            if (dataType == null || (dataSource = this.zza) == null || dataType.equals(dataSource.getDataType())) {
                z2 = true;
            }
            Preconditions.checkState(z2, "Specified data type is incompatible with specified data source");
            return new SensorRequest(this, null);
        }

        @NonNull
        public Builder setAccuracyMode(int i) {
            if (i != 1 && i != 3) {
                i = 2;
            }
            this.zzg = i;
            return this;
        }

        @NonNull
        public Builder setDataSource(@NonNull DataSource dataSource) {
            this.zza = dataSource;
            return this;
        }

        @NonNull
        public Builder setDataType(@NonNull DataType dataType) {
            this.zzb = dataType;
            return this;
        }

        @NonNull
        public Builder setFastestRate(int i, @NonNull TimeUnit timeUnit) {
            boolean z;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot use a negative interval");
            this.zzf = true;
            this.zzd = timeUnit.toMicros(i);
            return this;
        }

        @NonNull
        public Builder setMaxDeliveryLatency(int i, @NonNull TimeUnit timeUnit) {
            boolean z;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot use a negative delivery interval");
            this.zze = timeUnit.toMicros(i);
            return this;
        }

        @NonNull
        public Builder setSamplingRate(long j, @NonNull TimeUnit timeUnit) {
            boolean z;
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot use a negative sampling interval");
            long micros = timeUnit.toMicros(j);
            this.zzc = micros;
            if (!this.zzf) {
                this.zzd = micros / 2;
            }
            return this;
        }

        @NonNull
        public Builder setTimeout(long j, @NonNull TimeUnit timeUnit) {
            boolean z;
            boolean z2 = true;
            Object[] objArr = {Long.valueOf(j)};
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Invalid time out value specified: %d", objArr);
            if (timeUnit == null) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Invalid time unit specified");
            this.zzh = timeUnit.toMicros(j);
            return this;
        }
    }

    public /* synthetic */ SensorRequest(Builder builder, zzan zzanVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zze;
        this.zzf = builder.zzg;
        this.zzg = builder.zzh;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SensorRequest)) {
            return false;
        }
        SensorRequest sensorRequest = (SensorRequest) obj;
        if (Objects.equal(this.zza, sensorRequest.zza) && Objects.equal(this.zzb, sensorRequest.zzb) && this.zzc == sensorRequest.zzc && this.zzd == sensorRequest.zzd && this.zze == sensorRequest.zze && this.zzf == sensorRequest.zzf && this.zzg == sensorRequest.zzg) {
            return true;
        }
        return false;
    }

    public int getAccuracyMode() {
        return this.zzf;
    }

    @Nullable
    public DataSource getDataSource() {
        return this.zza;
    }

    @Nullable
    public DataType getDataType() {
        return this.zzb;
    }

    public long getFastestRate(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzd, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zze, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzc, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), Long.valueOf(this.zzd), Long.valueOf(this.zze), Integer.valueOf(this.zzf), Long.valueOf(this.zzg));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zza).add("dataType", this.zzb).add("samplingRateMicros", Long.valueOf(this.zzc)).add("deliveryLatencyMicros", Long.valueOf(this.zze)).add("timeOutMicros", Long.valueOf(this.zzg)).toString();
    }

    public final long zza() {
        return this.zzg;
    }
}
