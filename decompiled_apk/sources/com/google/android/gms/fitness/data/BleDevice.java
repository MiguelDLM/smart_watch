package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@SafeParcelable.Class(creator = "BleDeviceCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes9.dex */
public class BleDevice extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzd();

    @SafeParcelable.Field(getter = "getAddress", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getSupportedProfiles", id = 3)
    private final List zzc;

    @SafeParcelable.Field(getter = "getDataTypes", id = 4)
    private final List zzd;

    @SafeParcelable.Constructor
    public BleDevice(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) List list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        if (this.zzb.equals(bleDevice.zzb) && this.zza.equals(bleDevice.zza) && new HashSet(this.zzc).equals(new HashSet(bleDevice.zzc)) && new HashSet(this.zzd).equals(new HashSet(bleDevice.zzd))) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getAddress() {
        return this.zza;
    }

    @NonNull
    public List<DataType> getDataTypes() {
        return this.zzd;
    }

    @NonNull
    public String getName() {
        return this.zzb;
    }

    @NonNull
    public List<String> getSupportedProfiles() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza, this.zzc, this.zzd);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zzb).add("address", this.zza).add("dataTypes", this.zzd).add("supportedProfiles", this.zzc).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAddress(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedProfiles(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
