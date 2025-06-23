package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FeatureStyleCreator")
/* loaded from: classes9.dex */
public final class FeatureStyle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<FeatureStyle> CREATOR = new zzi();

    @Nullable
    @SafeParcelable.Field(getter = "getFillColor", id = 1)
    private final Integer zza;

    @Nullable
    @SafeParcelable.Field(getter = "getStrokeColor", id = 2)
    private final Integer zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getStrokeWidth", id = 3)
    private final Float zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getPointRadius", id = 4)
    private final Float zzd;

    /* loaded from: classes9.dex */
    public static final class Builder {
        private Integer zza;
        private Integer zzb;
        private Float zzc;
        private Float zzd;

        @NonNull
        public FeatureStyle build() {
            return new FeatureStyle(this, null);
        }

        @NonNull
        public Builder fillColor(int i) {
            this.zza = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder pointRadius(float f) {
            boolean z;
            boolean z2 = false;
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Point radius cannot be negative.");
            if (f <= 128.0f) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "The max allowed pointRadius value is 128px.");
            this.zzd = Float.valueOf(f);
            return this;
        }

        @NonNull
        public Builder strokeColor(int i) {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder strokeWidth(float f) {
            boolean z;
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Stroke width cannot be negative.");
            this.zzc = Float.valueOf(f);
            return this;
        }
    }

    public /* synthetic */ FeatureStyle(Builder builder, zzh zzhVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public Integer getFillColor() {
        return this.zza;
    }

    @Nullable
    public Float getPointRadius() {
        return this.zzd;
    }

    @Nullable
    public Integer getStrokeColor() {
        return this.zzb;
    }

    @Nullable
    public Float getStrokeWidth() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 1, getFillColor(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 2, getStrokeColor(), false);
        SafeParcelWriter.writeFloatObject(parcel, 3, getStrokeWidth(), false);
        SafeParcelWriter.writeFloatObject(parcel, 4, getPointRadius(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public FeatureStyle(@Nullable @SafeParcelable.Param(id = 1) Integer num, @Nullable @SafeParcelable.Param(id = 2) Integer num2, @Nullable @SafeParcelable.Param(id = 3) Float f, @Nullable @SafeParcelable.Param(id = 4) Float f2) {
        this.zza = num;
        this.zzb = num2;
        this.zzc = f;
        this.zzd = f2;
    }
}
