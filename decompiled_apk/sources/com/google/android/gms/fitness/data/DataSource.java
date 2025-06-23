package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Locale;
import org.apache.commons.text.ooOOo0oXI;
import org.apache.log4j.spi.LocationInfo;

@SafeParcelable.Class(creator = "DataSourceCreator")
@SafeParcelable.Reserved({2, 7, 8, 1000})
/* loaded from: classes9.dex */
public class DataSource extends AbstractSafeParcelable {

    @NonNull
    @ShowFirstParty
    public static final Parcelable.Creator<DataSource> CREATOR;

    @NonNull
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private static final String zza;
    private static final String zzb;

    @SafeParcelable.Field(getter = "getDataType", id = 1)
    private final DataType zzc;

    @SafeParcelable.Field(getter = "getType", id = 3)
    private final int zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getDevice", id = 4)
    private final Device zze;

    @Nullable
    @SafeParcelable.Field(getter = "getApplication", id = 5)
    private final zzb zzf;

    @SafeParcelable.Field(getter = "getStreamName", id = 6)
    private final String zzg;
    private final String zzh;

    /* loaded from: classes9.dex */
    public static final class Builder {
        private DataType zza;
        private Device zzc;
        private zzb zzd;
        private int zzb = -1;
        private String zze = "";

        @NonNull
        public DataSource build() {
            boolean z;
            boolean z2 = false;
            if (this.zza != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must set data type");
            if (this.zzb >= 0) {
                z2 = true;
            }
            Preconditions.checkState(z2, "Must set data source type");
            return new DataSource(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder setAppPackageName(@NonNull Context context) {
            setAppPackageName(context.getPackageName());
            return this;
        }

        @NonNull
        public Builder setDataType(@NonNull DataType dataType) {
            this.zza = dataType;
            return this;
        }

        @NonNull
        public Builder setDevice(@NonNull Device device) {
            this.zzc = device;
            return this;
        }

        @NonNull
        public Builder setStreamName(@NonNull String str) {
            boolean z;
            if (str != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid stream name");
            this.zze = str;
            return this;
        }

        @NonNull
        public Builder setType(int i) {
            this.zzb = i;
            return this;
        }

        @NonNull
        public Builder setAppPackageName(@NonNull String str) {
            zzb zzbVar = zzb.zza;
            if (!"com.google.android.gms".equals(str)) {
                zzbVar = new zzb(str);
            }
            this.zzd = zzbVar;
            return this;
        }
    }

    static {
        Locale locale = Locale.ROOT;
        zza = "RAW".toLowerCase(locale);
        zzb = "DERIVED".toLowerCase(locale);
        CREATOR = new zzj();
    }

    @SafeParcelable.Constructor
    public DataSource(@SafeParcelable.Param(id = 1) DataType dataType, @SafeParcelable.Param(id = 3) int i, @Nullable @SafeParcelable.Param(id = 4) Device device, @Nullable @SafeParcelable.Param(id = 5) zzb zzbVar, @SafeParcelable.Param(id = 6) String str) {
        this.zzc = dataType;
        this.zzd = i;
        this.zze = device;
        this.zzf = zzbVar;
        this.zzg = str;
        StringBuilder sb = new StringBuilder();
        sb.append(zzc(i));
        sb.append(":");
        sb.append(dataType.getName());
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar.zza());
        }
        if (device != null) {
            sb.append(":");
            sb.append(device.zza());
        }
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
        this.zzh = sb.toString();
    }

    @Nullable
    public static DataSource extract(@NonNull Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private static String zzc(int i) {
        return i != 0 ? zzb : zza;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSource)) {
            return false;
        }
        return this.zzh.equals(((DataSource) obj).zzh);
    }

    @Nullable
    public String getAppPackageName() {
        zzb zzbVar = this.zzf;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.zza();
    }

    @NonNull
    public DataType getDataType() {
        return this.zzc;
    }

    @Nullable
    public Device getDevice() {
        return this.zze;
    }

    @NonNull
    public String getStreamIdentifier() {
        return this.zzh;
    }

    @NonNull
    public String getStreamName() {
        return this.zzg;
    }

    public int getType() {
        return this.zzd;
    }

    public int hashCode() {
        return this.zzh.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(zzc(this.zzd));
        if (this.zzf != null) {
            sb.append(":");
            sb.append(this.zzf);
        }
        if (this.zze != null) {
            sb.append(":");
            sb.append(this.zze);
        }
        if (this.zzg != null) {
            sb.append(":");
            sb.append(this.zzg);
        }
        sb.append(":");
        sb.append(this.zzc);
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataType(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDevice(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzf, i, false);
        SafeParcelWriter.writeString(parcel, 6, getStreamName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    @ShowFirstParty
    public final zzb zza() {
        return this.zzf;
    }

    @NonNull
    @ShowFirstParty
    public final String zzb() {
        String str;
        String concat;
        String str2;
        int i = this.zzd;
        if (i != 0) {
            if (i != 1) {
                str = LocationInfo.NA;
            } else {
                str = "d";
            }
        } else {
            str = "r";
        }
        DataType dataType = this.zzc;
        zzb zzbVar = this.zzf;
        String zzc = dataType.zzc();
        String str3 = "";
        if (zzbVar == null) {
            concat = "";
        } else if (this.zzf.equals(zzb.zza)) {
            concat = ":gms";
        } else {
            concat = ":".concat(String.valueOf(this.zzf.zza()));
        }
        Device device = this.zze;
        if (device == null) {
            str2 = "";
        } else {
            str2 = ":" + device.getModel() + ":" + device.getUid();
        }
        String str4 = this.zzg;
        if (str4 != null) {
            str3 = ":".concat(str4);
        }
        return str + ":" + zzc + concat + str2 + str3;
    }
}
