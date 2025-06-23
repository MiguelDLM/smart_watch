package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;

@ShowFirstParty
@SafeParcelable.Class(creator = "SensorUnregistrationRequestCreator")
@SafeParcelable.Reserved({4, 1000})
/* loaded from: classes9.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();

    @Nullable
    @SafeParcelable.Field(getter = "getListenerBinder", id = 1, type = "android.os.IBinder")
    private final com.google.android.gms.fitness.data.zzv zza;

    @Nullable
    @SafeParcelable.Field(getter = "getIntent", id = 2)
    private final PendingIntent zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzcw zzc;

    @SafeParcelable.Constructor
    public zzao(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        this.zza = iBinder == null ? null : com.google.android.gms.fitness.data.zzu.zzb(iBinder);
        this.zzb = pendingIntent;
        this.zzc = iBinder2 != null ? zzcv.zzc(iBinder2) : null;
    }

    public final String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        com.google.android.gms.fitness.data.zzv zzvVar = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        IBinder iBinder = null;
        if (zzvVar == null) {
            asBinder = null;
        } else {
            asBinder = zzvVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzcw zzcwVar = this.zzc;
        if (zzcwVar != null) {
            iBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzao(@Nullable com.google.android.gms.fitness.data.zzv zzvVar, @Nullable PendingIntent pendingIntent, @Nullable zzcw zzcwVar) {
        this.zza = zzvVar;
        this.zzb = pendingIntent;
        this.zzc = zzcwVar;
    }
}
