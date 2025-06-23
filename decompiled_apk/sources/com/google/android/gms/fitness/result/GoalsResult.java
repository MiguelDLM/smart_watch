package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Goal;
import java.util.List;

@SafeParcelable.Class(creator = "GoalsResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes9.dex */
public class GoalsResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<GoalsResult> CREATOR = new zzf();

    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zza;

    @SafeParcelable.Field(getter = "getGoals", id = 2)
    private final List zzb;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public GoalsResult(@NonNull @SafeParcelable.Param(id = 1) Status status, @NonNull @SafeParcelable.Param(id = 2) List list) {
        this.zza = status;
        this.zzb = list;
    }

    @NonNull
    public List<Goal> getGoals() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, getGoals(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
