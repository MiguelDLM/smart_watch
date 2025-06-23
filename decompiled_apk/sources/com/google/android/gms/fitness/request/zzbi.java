package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcw;

@ShowFirstParty
@SafeParcelable.Class(creator = "UnsubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
/* loaded from: classes9.dex */
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbj();

    @Nullable
    @SafeParcelable.Field(getter = "getDataType", id = 1)
    private final DataType zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDataSource", id = 2)
    private final DataSource zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzcw zzc;

    public zzbi(@Nullable DataType dataType, @Nullable DataSource dataSource, @Nullable zzcw zzcwVar) {
        boolean z;
        boolean z2;
        if (dataType != null) {
            z = false;
        } else {
            z = true;
        }
        if (dataSource != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z != z2, "Must specify exactly one of dataType and dataSource.");
        this.zza = dataType;
        this.zzb = dataSource;
        this.zzc = zzcwVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return false;
        }
        zzbi zzbiVar = (zzbi) obj;
        if (Objects.equal(this.zzb, zzbiVar.zzb) && Objects.equal(this.zza, zzbiVar.zza)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        DataType dataType = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, dataType, i, false);
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
}
