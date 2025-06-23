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
import com.google.android.gms.internal.fitness.zzcs;
import com.google.android.gms.internal.fitness.zzct;

@ShowFirstParty
@SafeParcelable.Class(creator = "SessionStopRequestCreator")
@SafeParcelable.Reserved({4, 1000})
/* loaded from: classes9.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();

    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getIdentifier", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzct zzc;

    @SafeParcelable.Constructor
    public zzaw(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = iBinder == null ? null : zzcs.zzb(iBinder);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzawVar = (zzaw) obj;
        if (Objects.equal(this.zza, zzawVar.zza) && Objects.equal(this.zzb, zzawVar.zzb)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add("identifier", this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        zzct zzctVar = this.zzc;
        if (zzctVar == null) {
            asBinder = null;
        } else {
            asBinder = zzctVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzaw(@Nullable String str, @Nullable String str2, @Nullable zzct zzctVar) {
        this.zza = null;
        this.zzb = str2;
        this.zzc = zzctVar;
    }
}
