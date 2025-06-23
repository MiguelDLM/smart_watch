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
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;

@ShowFirstParty
@SafeParcelable.Class(creator = "SubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
/* loaded from: classes9.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();

    @Nullable
    @SafeParcelable.Field(getter = "getSubscription", id = 1)
    private final Subscription zza;

    @SafeParcelable.Field(getter = "isServerOnly", id = 2)
    private final boolean zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzcw zzc;

    @SafeParcelable.Constructor
    public zzbe(@Nullable @SafeParcelable.Param(id = 1) Subscription subscription, @SafeParcelable.Param(id = 2) boolean z, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder) {
        this.zza = subscription;
        this.zzb = z;
        this.zzc = iBinder == null ? null : zzcv.zzc(iBinder);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("subscription", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        zzcw zzcwVar = this.zzc;
        if (zzcwVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbe(@Nullable Subscription subscription, boolean z, @Nullable zzcw zzcwVar) {
        this.zza = subscription;
        this.zzb = false;
        this.zzc = zzcwVar;
    }
}
