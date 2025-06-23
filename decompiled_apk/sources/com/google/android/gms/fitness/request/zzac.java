package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzfe;
import com.google.android.gms.internal.fitness.zzff;

@SafeParcelable.Class(creator = "ListClaimedBleDevicesRequestCreator")
@SafeParcelable.Reserved({2, 1000})
@Deprecated
@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();

    @SafeParcelable.Field(getter = "getCallbackBinder", id = 1, type = "android.os.IBinder")
    private final zzff zza;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 1) IBinder iBinder) {
        this.zza = zzfe.zzc(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzff zzffVar = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, zzffVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzac(zzff zzffVar) {
        this.zza = zzffVar;
    }
}
