package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzgo;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "BucketCreator")
@SafeParcelable.Reserved({7, 1000})
/* loaded from: classes9.dex */
public class Bucket extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Bucket> CREATOR = new zze();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;

    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 2)
    private final long zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getSession", id = 3)
    private final Session zzc;

    @SafeParcelable.Field(getter = "getActivityType", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "getDataSets", id = 5)
    private final List zze;

    @SafeParcelable.Field(getter = "getBucketType", id = 6)
    private final int zzf;

    @SafeParcelable.Constructor
    public Bucket(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2, @Nullable @SafeParcelable.Param(id = 3) Session session, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) int i2) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = session;
        this.zzd = i;
        this.zze = list;
        this.zzf = i2;
    }

    @NonNull
    @ShowFirstParty
    public static String zzd(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "bug" : "intervals" : "segment" : "type" : "session" : "time" : "none";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bucket)) {
            return false;
        }
        Bucket bucket = (Bucket) obj;
        if (this.zza == bucket.zza && this.zzb == bucket.zzb && this.zzd == bucket.zzd && Objects.equal(this.zze, bucket.zze) && this.zzf == bucket.zzf) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getActivity() {
        return zzgo.zzb(this.zzd);
    }

    public int getBucketType() {
        return this.zzf;
    }

    @Nullable
    public DataSet getDataSet(@NonNull DataType dataType) {
        for (DataSet dataSet : this.zze) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    @NonNull
    public List<DataSet> getDataSets() {
        return this.zze;
    }

    public long getEndTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public Session getSession() {
        return this.zzc;
    }

    public long getStartTime(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.zza, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzd), Integer.valueOf(this.zzf));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add(bn.f.g, Long.valueOf(this.zza)).add("endTime", Long.valueOf(this.zzb)).add(TTDownloadField.TT_ACTIVITY, Integer.valueOf(this.zzd)).add("dataSets", this.zze).add("bucketType", zzd(this.zzf)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, getSession(), i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, getDataSets(), false);
        SafeParcelWriter.writeInt(parcel, 6, getBucketType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final int zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final long zzc() {
        return this.zza;
    }

    public final boolean zze(@NonNull Bucket bucket) {
        if (this.zza == bucket.zza && this.zzb == bucket.zzb && this.zzd == bucket.zzd && this.zzf == bucket.zzf) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Bucket(@androidx.annotation.NonNull com.google.android.gms.fitness.data.RawBucket r11, @androidx.annotation.NonNull java.util.List r12) {
        /*
            r10 = this;
            long r1 = r11.zza
            long r3 = r11.zzb
            com.google.android.gms.fitness.data.Session r5 = r11.zzc
            int r6 = r11.zzd
            java.util.List r0 = r11.zze
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = r0.size()
            r7.<init>(r8)
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L2c
            java.lang.Object r8 = r0.next()
            com.google.android.gms.fitness.data.RawDataSet r8 = (com.google.android.gms.fitness.data.RawDataSet) r8
            com.google.android.gms.fitness.data.DataSet r9 = new com.google.android.gms.fitness.data.DataSet
            r9.<init>(r8, r12)
            r7.add(r9)
            goto L17
        L2c:
            int r8 = r11.zzf
            r0 = r10
            r0.<init>(r1, r3, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.Bucket.<init>(com.google.android.gms.fitness.data.RawBucket, java.util.List):void");
    }
}
