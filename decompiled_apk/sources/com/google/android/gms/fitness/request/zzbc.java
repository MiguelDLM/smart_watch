package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;

@SafeParcelable.Class(creator = "StopBleScanRequestCreator")
@SafeParcelable.Reserved({3, 1000})
@Deprecated
@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();

    @SafeParcelable.Field(getter = "getBleScanCallbackBinder", id = 1, type = "android.os.IBinder")
    private final zzab zza;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 2, type = "android.os.IBinder")
    private final zzcw zzb;

    @SafeParcelable.Constructor
    public zzbc(@SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder2) {
        zzab zzzVar;
        if (iBinder == null) {
            zzzVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            zzzVar = queryLocalInterface instanceof zzab ? (zzab) queryLocalInterface : new zzz(iBinder);
        }
        this.zza = zzzVar;
        this.zzb = iBinder2 != null ? zzcv.zzc(iBinder2) : null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        zzab zzabVar = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, zzabVar.asBinder(), false);
        zzcw zzcwVar = this.zzb;
        if (zzcwVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbc(zzab zzabVar, @Nullable zzcw zzcwVar) {
        this.zza = zzabVar;
        this.zzb = zzcwVar;
    }
}
