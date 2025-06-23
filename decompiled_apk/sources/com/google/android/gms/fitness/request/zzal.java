package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
@SafeParcelable.Class(creator = "SensorRegistrationRequestCreator")
@SafeParcelable.Reserved({4, 5, 11, 14, 1000})
/* loaded from: classes9.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();

    @Nullable
    @SafeParcelable.Field(getter = "getDataSource", id = 1)
    private final DataSource zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDataType", id = 2)
    private final DataType zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getListenerBinder", id = 3, type = "android.os.IBinder")
    private final com.google.android.gms.fitness.data.zzv zzc;

    @SafeParcelable.Field(getter = "getSamplingRateMicros", id = 6)
    private final long zzd;

    @SafeParcelable.Field(getter = "getMaxDeliveryLatencyMicros", id = 7)
    private final long zze;

    @Nullable
    @SafeParcelable.Field(getter = "getIntent", id = 8)
    private final PendingIntent zzf;

    @SafeParcelable.Field(getter = "getFastestRateMicros", id = 9)
    private final long zzg;

    @SafeParcelable.Field(getter = "getAccuracyMode", id = 10)
    private final int zzh;

    @SafeParcelable.Field(getter = "getRegistrationTimeOutMicros", id = 12)
    private final long zzi;
    private final List zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 13, type = "android.os.IBinder")
    private final zzcw zzk;

    @SafeParcelable.Constructor
    public zzal(@Nullable @SafeParcelable.Param(id = 1) DataSource dataSource, @Nullable @SafeParcelable.Param(id = 2) DataType dataType, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 6) long j, @SafeParcelable.Param(id = 7) long j2, @Nullable @SafeParcelable.Param(id = 8) PendingIntent pendingIntent, @SafeParcelable.Param(id = 9) long j3, @SafeParcelable.Param(id = 10) int i, @SafeParcelable.Param(id = 12) long j4, @Nullable @SafeParcelable.Param(id = 13) IBinder iBinder2) {
        this.zza = dataSource;
        this.zzb = dataType;
        this.zzc = iBinder == null ? null : com.google.android.gms.fitness.data.zzu.zzb(iBinder);
        this.zzd = j;
        this.zzg = j3;
        this.zze = j2;
        this.zzf = pendingIntent;
        this.zzh = i;
        this.zzj = Collections.emptyList();
        this.zzi = j4;
        this.zzk = iBinder2 != null ? zzcv.zzc(iBinder2) : null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzal)) {
            return false;
        }
        zzal zzalVar = (zzal) obj;
        if (Objects.equal(this.zza, zzalVar.zza) && Objects.equal(this.zzb, zzalVar.zzb) && Objects.equal(this.zzc, zzalVar.zzc) && this.zzd == zzalVar.zzd && this.zzg == zzalVar.zzg && this.zze == zzalVar.zze && this.zzh == zzalVar.zzh) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Long.valueOf(this.zzg), Long.valueOf(this.zze), Integer.valueOf(this.zzh));
    }

    public final String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzb, this.zza, Long.valueOf(this.zzd), Long.valueOf(this.zzg), Long.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.fitness.data.zzv zzvVar = this.zzc;
        IBinder iBinder = null;
        if (zzvVar == null) {
            asBinder = null;
        } else {
            asBinder = zzvVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzd);
        SafeParcelWriter.writeLong(parcel, 7, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzf, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzg);
        SafeParcelWriter.writeInt(parcel, 10, this.zzh);
        SafeParcelWriter.writeLong(parcel, 12, this.zzi);
        zzcw zzcwVar = this.zzk;
        if (zzcwVar != null) {
            iBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 13, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzal(SensorRequest sensorRequest, @Nullable com.google.android.gms.fitness.data.zzv zzvVar, @Nullable PendingIntent pendingIntent, zzcw zzcwVar) {
        DataSource dataSource = sensorRequest.getDataSource();
        DataType dataType = sensorRequest.getDataType();
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        long samplingRate = sensorRequest.getSamplingRate(timeUnit);
        long fastestRate = sensorRequest.getFastestRate(timeUnit);
        long maxDeliveryLatency = sensorRequest.getMaxDeliveryLatency(timeUnit);
        int accuracyMode = sensorRequest.getAccuracyMode();
        List emptyList = Collections.emptyList();
        long zza = sensorRequest.zza();
        this.zza = dataSource;
        this.zzb = dataType;
        this.zzc = zzvVar;
        this.zzf = pendingIntent;
        this.zzd = samplingRate;
        this.zzg = fastestRate;
        this.zze = maxDeliveryLatency;
        this.zzh = accuracyMode;
        this.zzj = emptyList;
        this.zzi = zza;
        this.zzk = zzcwVar;
    }
}
