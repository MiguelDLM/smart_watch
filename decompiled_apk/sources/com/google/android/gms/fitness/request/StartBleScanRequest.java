package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcv;
import com.google.android.gms.internal.fitness.zzcw;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "StartBleScanRequestCreator")
@SafeParcelable.Reserved({5, 1000})
@Deprecated
/* loaded from: classes9.dex */
public class StartBleScanRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzbb();

    @SafeParcelable.Field(getter = "getDataTypes", id = 1)
    private final List zza;

    @Nullable
    @SafeParcelable.Field(getter = "getBleScanCallbackBinder", id = 2, type = "android.os.IBinder")
    private final zzab zzb;

    @SafeParcelable.Field(getter = "getTimeoutSecs", id = 3)
    private final int zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 4, type = "android.os.IBinder")
    private final zzcw zzd;

    @Nullable
    private final BleScanCallback zze;

    /* loaded from: classes9.dex */
    public static class Builder {
        private BleScanCallback zzb;
        private DataType[] zza = new DataType[0];
        private int zzc = 10;

        @NonNull
        public StartBleScanRequest build() {
            boolean z;
            if (this.zzb != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must set BleScanCallback");
            return new StartBleScanRequest(ArrayUtils.toArrayList(this.zza), this.zzb, this.zzc, (zzba) null);
        }

        @NonNull
        public Builder setBleScanCallback(@NonNull BleScanCallback bleScanCallback) {
            this.zzb = bleScanCallback;
            return this;
        }

        @NonNull
        public Builder setDataTypes(@NonNull DataType... dataTypeArr) {
            this.zza = dataTypeArr;
            return this;
        }

        @NonNull
        public Builder setTimeoutSecs(int i) {
            boolean z;
            boolean z2 = false;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Stop time must be greater than zero");
            if (i <= 60) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Stop time must be less than 1 minute");
            this.zzc = i;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public StartBleScanRequest(@SafeParcelable.Param(id = 1) List list, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) int i, @Nullable @SafeParcelable.Param(id = 4) IBinder iBinder2) {
        zzab zzzVar;
        this.zza = list;
        if (iBinder == null) {
            zzzVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            zzzVar = queryLocalInterface instanceof zzab ? (zzab) queryLocalInterface : new zzz(iBinder);
        }
        this.zzb = zzzVar;
        this.zzc = i;
        this.zzd = iBinder2 == null ? null : zzcv.zzc(iBinder2);
        this.zze = null;
    }

    @NonNull
    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zza);
    }

    public int getTimeoutSecs() {
        return this.zzc;
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zza).add("timeoutSecs", Integer.valueOf(this.zzc)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        zzab zzabVar = this.zzb;
        IBinder iBinder = null;
        if (zzabVar == null) {
            asBinder = null;
        } else {
            asBinder = zzabVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.writeInt(parcel, 3, getTimeoutSecs());
        zzcw zzcwVar = this.zzd;
        if (zzcwVar != null) {
            iBinder = zzcwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final BleScanCallback zza() {
        return this.zze;
    }

    public /* synthetic */ StartBleScanRequest(List list, BleScanCallback bleScanCallback, int i, zzba zzbaVar) {
        this.zza = list;
        this.zzb = null;
        this.zzc = i;
        this.zzd = null;
        this.zze = bleScanCallback;
    }

    public StartBleScanRequest(List list, @Nullable zzab zzabVar, int i, @Nullable zzcw zzcwVar) {
        this.zza = list;
        this.zzb = zzabVar;
        this.zzc = i;
        this.zzd = zzcwVar;
        this.zze = null;
    }
}
