package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ListSubscriptionsResultCreator")
@SafeParcelable.Reserved({3, 1000})
@Deprecated
/* loaded from: classes9.dex */
public class ListSubscriptionsResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzg();

    @SafeParcelable.Field(getter = "getSubscriptions", id = 1)
    private final List zza;

    @SafeParcelable.Field(getter = "getStatus", id = 2)
    private final Status zzb;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public ListSubscriptionsResult(@NonNull @SafeParcelable.Param(id = 1) List list, @NonNull @SafeParcelable.Param(id = 2) Status status) {
        this.zza = list;
        this.zzb = status;
    }

    @NonNull
    @ShowFirstParty
    public static ListSubscriptionsResult zza(@NonNull Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListSubscriptionsResult)) {
            return false;
        }
        ListSubscriptionsResult listSubscriptionsResult = (ListSubscriptionsResult) obj;
        if (this.zzb.equals(listSubscriptionsResult.zzb) && Objects.equal(this.zza, listSubscriptionsResult.zza)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zzb;
    }

    @NonNull
    public List<Subscription> getSubscriptions() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzb).add("subscriptions", this.zza).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSubscriptions(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public List<Subscription> getSubscriptions(@NonNull DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (Subscription subscription : this.zza) {
            if (dataType.equals(subscription.zza())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
