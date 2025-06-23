package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
@SafeParcelable.Class(creator = "RawBucketCreator")
@SafeParcelable.Reserved({7, 1000})
/* loaded from: classes9.dex */
public final class RawBucket extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RawBucket> CREATOR = new zzz();

    @SafeParcelable.Field(id = 1)
    public final long zza;

    @SafeParcelable.Field(id = 2)
    public final long zzb;

    @Nullable
    @SafeParcelable.Field(id = 3)
    public final Session zzc;

    @SafeParcelable.Field(id = 4)
    public final int zzd;

    @NonNull
    @SafeParcelable.Field(id = 5)
    public final List zze;

    @SafeParcelable.Field(id = 6)
    public final int zzf;

    @SafeParcelable.Constructor
    public RawBucket(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @Nullable @SafeParcelable.Param(id = 3) Session session, @SafeParcelable.Param(id = 4) int i, @NonNull @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) int i2) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = session;
        this.zzd = i;
        this.zze = list;
        this.zzf = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawBucket)) {
            return false;
        }
        RawBucket rawBucket = (RawBucket) obj;
        if (this.zza == rawBucket.zza && this.zzb == rawBucket.zzb && this.zzd == rawBucket.zzd && Objects.equal(this.zze, rawBucket.zze) && this.zzf == rawBucket.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzf));
    }

    @NonNull
    public final String toString() {
        return Objects.toStringHelper(this).add(bn.f.g, Long.valueOf(this.zza)).add("endTime", Long.valueOf(this.zzb)).add(TTDownloadField.TT_ACTIVITY, Integer.valueOf(this.zzd)).add("dataSets", this.zze).add("bucketType", Integer.valueOf(this.zzf)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        long j = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RawBucket(@NonNull Bucket bucket, @NonNull List list) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.zza = bucket.getStartTime(timeUnit);
        this.zzb = bucket.getEndTime(timeUnit);
        this.zzc = bucket.getSession();
        this.zzd = bucket.zza();
        this.zzf = bucket.getBucketType();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zze = new ArrayList(dataSets.size());
        Iterator<DataSet> it = dataSets.iterator();
        while (it.hasNext()) {
            this.zze.add(new RawDataSet(it.next(), list));
        }
    }
}
