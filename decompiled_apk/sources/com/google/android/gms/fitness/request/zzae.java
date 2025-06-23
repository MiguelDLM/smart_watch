package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator = "ListSubscriptionsRequestCreator")
@SafeParcelable.Reserved({3, 1000})
/* loaded from: classes9.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();

    @Nullable
    @SafeParcelable.Field(getter = "getDataType", id = 1)
    private final DataType zza;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 2, type = "android.os.IBinder")
    private final zzcn zzb;

    @SafeParcelable.Constructor
    public zzae(@Nullable @SafeParcelable.Param(id = 1) DataType dataType, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.zza = dataType;
        this.zzb = iBinder == null ? null : zzcm.zzb(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        DataType dataType = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, dataType, i, false);
        zzcn zzcnVar = this.zzb;
        if (zzcnVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcnVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzae(@Nullable DataType dataType, zzcn zzcnVar) {
        this.zza = dataType;
        this.zzb = zzcnVar;
    }
}
