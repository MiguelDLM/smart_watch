package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;

@ShowFirstParty
@SafeParcelable.Class(creator = "DataInsertRequestCreator")
@SafeParcelable.Reserved({3, 1000})
/* loaded from: classes9.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    @SafeParcelable.Field(getter = "getDataSet", id = 1)
    private final DataSet zza;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 2, type = "android.os.IBinder")
    private final zzcw zzb;

    @SafeParcelable.Field(getter = "shouldSkipSync", id = 4)
    private final boolean zzc;

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 1) DataSet dataSet, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 4) boolean z) {
        this.zza = dataSet;
        this.zzb = iBinder == null ? null : zzcv.zzc(iBinder);
        this.zzc = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzk) && Objects.equal(this.zza, ((zzk) obj).zza)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("dataSet", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        DataSet dataSet = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, dataSet, i, false);
        zzcw zzcwVar = this.zzb;
        if (zzcwVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzk(DataSet dataSet, zzcw zzcwVar, boolean z) {
        this.zza = dataSet;
        this.zzb = zzcwVar;
        this.zzc = false;
    }
}
