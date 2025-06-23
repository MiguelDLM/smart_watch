package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceCreator")
@SafeParcelable.Reserved({3, 1000})
/* loaded from: classes9.dex */
public final class Device extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Device> CREATOR = new zzn();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_HEAD_MOUNTED = 6;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;

    @SafeParcelable.Field(getter = "getManufacturer", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getModel", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getUid", id = 4)
    private final String zzc;

    @SafeParcelable.Field(getter = "getType", id = 5)
    private final int zzd;

    @SafeParcelable.Field(getter = "getPlatformType", id = 6)
    private final int zze;

    public Device(@NonNull String str, @NonNull String str2, @NonNull String str3, int i) {
        this(str, str2, str3, i, 0);
    }

    @NonNull
    public static Device getLocalDevice(@NonNull Context context) {
        int zza = zzo.zza(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, zzo.zzb(context), zza, 2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        if (Objects.equal(this.zza, device.zza) && Objects.equal(this.zzb, device.zzb) && Objects.equal(this.zzc, device.zzc) && this.zzd == device.zzd && this.zze == device.zze) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getManufacturer() {
        return this.zza;
    }

    @NonNull
    public String getModel() {
        return this.zzb;
    }

    public int getType() {
        return this.zzd;
    }

    @NonNull
    public String getUid() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd));
    }

    @NonNull
    public String toString() {
        return String.format("Device{%s:%s:%s}", zza(), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getManufacturer(), false);
        SafeParcelWriter.writeString(parcel, 2, getModel(), false);
        SafeParcelWriter.writeString(parcel, 4, getUid(), false);
        SafeParcelWriter.writeInt(parcel, 5, getType());
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return String.format("%s:%s:%s", this.zza, this.zzb, this.zzc);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    public Device(@NonNull @SafeParcelable.Param(id = 1) String str, @NonNull @SafeParcelable.Param(id = 2) String str2, @NonNull @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 6) int i2) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        if (str3 != null) {
            this.zzc = str3;
            this.zzd = i;
            this.zze = i2;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }
}
