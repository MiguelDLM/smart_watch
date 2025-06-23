package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "SubscriptionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public class Subscription extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Subscription> CREATOR = new zzah();

    @SafeParcelable.Field(getter = "getDataSource", id = 1)
    private final DataSource zza;

    @SafeParcelable.Field(getter = "getDataType", id = 2)
    private final DataType zzb;

    @SafeParcelable.Field(getter = "getSamplingRateMicros", id = 3)
    private final long zzc;

    @SafeParcelable.Field(getter = "getAccuracyMode", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "getSubscriptionType", id = 5)
    private final int zze;

    @SafeParcelable.Constructor
    public Subscription(@SafeParcelable.Param(id = 1) DataSource dataSource, @SafeParcelable.Param(id = 2) DataType dataType, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) int i2) {
        this.zza = dataSource;
        this.zzb = dataType;
        this.zzc = j;
        this.zzd = i;
        this.zze = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (Objects.equal(this.zza, subscription.zza) && Objects.equal(this.zzb, subscription.zzb) && this.zzc == subscription.zzc && this.zzd == subscription.zzd && this.zze == subscription.zze) {
            return true;
        }
        return false;
    }

    @Nullable
    public DataSource getDataSource() {
        return this.zza;
    }

    @Nullable
    public DataType getDataType() {
        return this.zzb;
    }

    public int hashCode() {
        DataSource dataSource = this.zza;
        return Objects.hashCode(dataSource, dataSource, Long.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @NonNull
    public String toDebugString() {
        String zzb;
        DataSource dataSource = this.zza;
        Locale locale = Locale.US;
        if (dataSource == null) {
            zzb = this.zzb.getName();
        } else {
            zzb = dataSource.zzb();
        }
        return String.format(locale, "Subscription{%s}, subscriptionType{%d}", zzb, Integer.valueOf(this.zze));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zza).add("dataType", this.zzb).add("samplingIntervalMicros", Long.valueOf(this.zzc)).add("accuracyMode", Integer.valueOf(this.zzd)).add("subscriptionType", Integer.valueOf(this.zze)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getDataType(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    @ShowFirstParty
    public final DataType zza() {
        DataType dataType = this.zzb;
        if (dataType == null) {
            return this.zza.getDataType();
        }
        return dataType;
    }
}
