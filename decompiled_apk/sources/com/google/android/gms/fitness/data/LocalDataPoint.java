package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.util.SystemInfoUtil;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class LocalDataPoint {
    private final DataPoint zza;

    public LocalDataPoint(@NonNull DataPoint dataPoint) {
        this.zza = dataPoint;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDataPoint)) {
            return false;
        }
        return Objects.equal(this.zza, ((LocalDataPoint) obj).zza);
    }

    @NonNull
    public LocalDataType getDataType() {
        return LocalDataType.zzb(this.zza.getDataType());
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return this.zza.getEndTime(timeUnit);
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return this.zza.getStartTime(timeUnit);
    }

    @NonNull
    public LocalValue getValue(@NonNull LocalField localField) {
        return new LocalValue(this.zza.getValue(localField.zza()));
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public String toString() {
        String str;
        String arrays = Arrays.toString(this.zza.zzg());
        Long valueOf = Long.valueOf(this.zza.zzb());
        Long valueOf2 = Long.valueOf(this.zza.zzc());
        Long valueOf3 = Long.valueOf(this.zza.zza());
        String zzb = this.zza.getDataSource().zzb();
        if (this.zza.getOriginalDataSource() != null) {
            str = this.zza.getOriginalDataSource().zzb();
        } else {
            str = SystemInfoUtil.NA;
        }
        return String.format("LocalDataPoint{%s@[%s, %s,raw=%s](%s %s)}", arrays, valueOf, valueOf2, valueOf3, zzb, str);
    }
}
