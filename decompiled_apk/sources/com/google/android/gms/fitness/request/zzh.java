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
import com.google.android.gms.internal.fitness.zzbp;
import com.google.android.gms.internal.fitness.zzbq;

@ShowFirstParty
@SafeParcelable.Class(creator = "DailyTotalRequestCreator")
@SafeParcelable.Reserved({3, 1000})
/* loaded from: classes9.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    @SafeParcelable.Field(getter = "getCallbackBinder", id = 1, type = "android.os.IBinder")
    private final zzbq zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDataType", id = 2)
    private final DataType zzb;

    @SafeParcelable.Field(getter = "getLocalDataOnly", id = 4)
    private final boolean zzc;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) DataType dataType, @SafeParcelable.Param(id = 4) boolean z) {
        this.zza = zzbp.zzb(iBinder);
        this.zzb = dataType;
        this.zzc = z;
    }

    public final String toString() {
        String zzc;
        DataType dataType = this.zzb;
        if (dataType == null) {
            zzc = "null";
        } else {
            zzc = dataType.zzc();
        }
        return String.format("DailyTotalRequest{%s}", zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzbq zzbqVar = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, zzbqVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzh(zzbq zzbqVar, @Nullable DataType dataType, boolean z) {
        this.zza = zzbqVar;
        this.zzb = dataType;
        this.zzc = z;
    }
}
