package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;

@ShowFirstParty
@SafeParcelable.Class(creator = "ClaimBleDeviceRequestCreator")
@SafeParcelable.Reserved({4, 1000})
/* loaded from: classes9.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    @SafeParcelable.Field(getter = "getDeviceAddress", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getBleDevice", id = 2)
    private final BleDevice zzb;

    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzcw zzc;

    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) BleDevice bleDevice, @SafeParcelable.Param(id = 3) IBinder iBinder) {
        this.zza = str;
        this.zzb = bleDevice;
        this.zzc = zzcv.zzc(iBinder);
    }

    public final String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzcw zzcwVar = this.zzc;
        if (zzcwVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzf(String str, @Nullable BleDevice bleDevice, zzcw zzcwVar) {
        this.zza = str;
        this.zzb = bleDevice;
        this.zzc = zzcwVar;
    }
}
