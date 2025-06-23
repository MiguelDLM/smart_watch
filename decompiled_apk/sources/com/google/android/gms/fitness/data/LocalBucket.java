package com.google.android.gms.fitness.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class LocalBucket {
    public static final int TYPE_TIME = 1;
    private final long zza;
    private final long zzb;
    private final List zzc;
    private final int zzd;

    public LocalBucket(long j, long j2, List list, int i) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = list;
        this.zzd = i;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalBucket)) {
            return false;
        }
        LocalBucket localBucket = (LocalBucket) obj;
        if (this.zza == localBucket.zza && this.zzb == localBucket.zzb && Objects.equal(this.zzc, localBucket.zzc) && this.zzd == localBucket.zzd) {
            return true;
        }
        return false;
    }

    public int getBucketType() {
        return this.zzd;
    }

    @Nullable
    public LocalDataSet getDataSet(@NonNull LocalDataType localDataType) {
        for (LocalDataSet localDataSet : this.zzc) {
            if (localDataSet.getDataType().equals(localDataType)) {
                return localDataSet;
            }
        }
        return null;
    }

    @NonNull
    public List<LocalDataSet> getDataSets() {
        return this.zzc;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zza, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzd));
    }

    @NonNull
    public String toString() {
        String str;
        Objects.ToStringHelper add = Objects.toStringHelper(this).add(bn.f.g, Long.valueOf(this.zza)).add("endTime", Long.valueOf(this.zzb)).add("dataSets", this.zzc);
        int i = this.zzd;
        if (i != 0) {
            if (i != 1) {
                str = "bug";
            } else {
                str = "time";
            }
        } else {
            str = "none";
        }
        return add.add("bucketType", str).toString();
    }
}
