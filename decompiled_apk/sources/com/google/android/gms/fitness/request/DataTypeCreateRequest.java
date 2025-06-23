package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DataTypeCreateRequestCreator")
@SafeParcelable.Reserved({4, 1000})
@Deprecated
/* loaded from: classes9.dex */
public class DataTypeCreateRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzo();

    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getFields", id = 2)
    private final List zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getCallbackBinder", id = 3, type = "android.os.IBinder")
    private final zzbz zzc;

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzbz zzbzVar) {
        this(dataTypeCreateRequest.zza, dataTypeCreateRequest.zzb, zzbzVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataTypeCreateRequest)) {
            return false;
        }
        DataTypeCreateRequest dataTypeCreateRequest = (DataTypeCreateRequest) obj;
        if (Objects.equal(this.zza, dataTypeCreateRequest.zza) && Objects.equal(this.zzb, dataTypeCreateRequest.zzb)) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<Field> getFields() {
        return this.zzb;
    }

    @NonNull
    public String getName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add(GraphRequest.FIELDS_PARAM, this.zzb).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getFields(), false);
        zzbz zzbzVar = this.zzc;
        if (zzbzVar == null) {
            asBinder = null;
        } else {
            asBinder = zzbzVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private String zza;
        private final List zzb = new ArrayList();

        @NonNull
        public Builder addField(@NonNull Field field) {
            if (!this.zzb.contains(field)) {
                this.zzb.add(field);
            }
            return this;
        }

        @NonNull
        public DataTypeCreateRequest build() {
            boolean z;
            if (this.zza != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Must set the name");
            Preconditions.checkState(!this.zzb.isEmpty(), "Must specify the data fields");
            return new DataTypeCreateRequest(this.zza, this.zzb, (zzbz) null);
        }

        @NonNull
        public Builder setName(@NonNull String str) {
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder addField(@NonNull String str, int i) {
            boolean z = false;
            if (str != null && !str.isEmpty()) {
                z = true;
            }
            Preconditions.checkArgument(z, "Invalid name specified");
            return addField(new Field(str, i, null));
        }
    }

    @SafeParcelable.Constructor
    public DataTypeCreateRequest(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) List list, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder) {
        this.zza = str;
        this.zzb = Collections.unmodifiableList(list);
        this.zzc = iBinder == null ? null : zzby.zzb(iBinder);
    }

    public DataTypeCreateRequest(String str, List list, @Nullable zzbz zzbzVar) {
        this.zza = str;
        this.zzb = Collections.unmodifiableList(list);
        this.zzc = zzbzVar;
    }
}
