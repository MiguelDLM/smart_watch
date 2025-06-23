package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

@SafeParcelable.Class(creator = "PinConfigCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes9.dex */
public class PinConfig extends AbstractSafeParcelable {
    public static final int BITMAP_LENGTH_DP = 37;
    public static final int BITMAP_WIDTH_DP = 26;

    @NonNull
    public static final Parcelable.Creator<PinConfig> CREATOR = new zzr();
    public static final int DEFAULT_PIN_BACKGROUND_COLOR = -1424587;
    public static final int DEFAULT_PIN_BORDER_COLOR = -3857889;
    public static final int DEFAULT_PIN_GLYPH_COLOR = -5041134;

    @SafeParcelable.Field(getter = "getBackgroundColor", id = 2)
    private final int zza;

    @SafeParcelable.Field(getter = "getBorderColor", id = 3)
    private final int zzb;

    @SafeParcelable.Field(getter = "getGlyph", id = 4)
    private final Glyph zzc;

    /* loaded from: classes9.dex */
    public static class Builder {
        private int zza = PinConfig.DEFAULT_PIN_BACKGROUND_COLOR;
        private int zzb = PinConfig.DEFAULT_PIN_BORDER_COLOR;
        private Glyph zzc = new Glyph(PinConfig.DEFAULT_PIN_GLYPH_COLOR);

        @NonNull
        public PinConfig build() {
            return new PinConfig(this.zza, this.zzb, this.zzc);
        }

        @NonNull
        public Builder setBackgroundColor(@ColorInt int i) {
            this.zza = i;
            return this;
        }

        @NonNull
        public Builder setBorderColor(@ColorInt int i) {
            this.zzb = i;
            return this;
        }

        @NonNull
        public Builder setGlyph(@NonNull Glyph glyph) {
            this.zzc = glyph;
            return this;
        }
    }

    @SafeParcelable.Class(creator = "GlyphCreator")
    @SafeParcelable.Reserved({1})
    /* loaded from: classes9.dex */
    public static class Glyph extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<Glyph> CREATOR = new zzj();
        public static final float DEFAULT_CIRCLE_RADIUS_DP = 5.0f;
        public static final float X_COORDINATE_DP = 13.0f;
        public static final float Y_COORDINATE_DP = 13.0f;

        @Nullable
        @SafeParcelable.Field(getter = "getText", id = 2)
        private String zza;

        @Nullable
        @SafeParcelable.Field(getter = "getWrappedBitmapDescriptorBinder", id = 3, type = "android.os.IBinder")
        private BitmapDescriptor zzb;

        @SafeParcelable.Field(getter = "getGlyphColor", id = 4)
        private int zzc;

        @ColorInt
        @SafeParcelable.Field(getter = "getTextColor", id = 5)
        private int zzd;

        public Glyph(@ColorInt int i) {
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzc = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Glyph)) {
                return false;
            }
            Glyph glyph = (Glyph) obj;
            if (this.zzc != glyph.zzc || !Objects.equals(this.zza, glyph.zza) || this.zzd != glyph.zzd) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor = this.zzb;
            if ((bitmapDescriptor == null && glyph.zzb != null) || (bitmapDescriptor != null && glyph.zzb == null)) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor2 = glyph.zzb;
            if (bitmapDescriptor == null || bitmapDescriptor2 == null) {
                return true;
            }
            return Objects.equals(ObjectWrapper.unwrap(bitmapDescriptor.zza()), ObjectWrapper.unwrap(bitmapDescriptor2.zza()));
        }

        @Nullable
        public BitmapDescriptor getBitmapDescriptor() {
            return this.zzb;
        }

        public int getGlyphColor() {
            return this.zzc;
        }

        @Nullable
        public String getText() {
            return this.zza;
        }

        public int getTextColor() {
            return this.zzd;
        }

        public int hashCode() {
            return Objects.hash(this.zza, this.zzb, Integer.valueOf(this.zzc));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            IBinder asBinder;
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, getText(), false);
            BitmapDescriptor bitmapDescriptor = this.zzb;
            if (bitmapDescriptor == null) {
                asBinder = null;
            } else {
                asBinder = bitmapDescriptor.zza().asBinder();
            }
            SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
            SafeParcelWriter.writeInt(parcel, 4, getGlyphColor());
            SafeParcelWriter.writeInt(parcel, 5, getTextColor());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        public Glyph(@Nullable BitmapDescriptor bitmapDescriptor) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzb = bitmapDescriptor;
        }

        public Glyph(@NonNull String str) {
            this(str, ViewCompat.MEASURED_STATE_MASK);
        }

        public Glyph(@NonNull String str, @ColorInt int i) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zza = str;
            this.zzd = i;
        }

        @SafeParcelable.Constructor
        public Glyph(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) int i2) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zza = str;
            this.zzb = iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
            this.zzc = i;
            this.zzd = i2;
        }
    }

    @SafeParcelable.Constructor
    public PinConfig(@SafeParcelable.Param(id = 2) @ColorInt int i, @SafeParcelable.Param(id = 3) @ColorInt int i2, @SafeParcelable.Param(id = 4) Glyph glyph) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = glyph;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public int getBackgroundColor() {
        return this.zza;
    }

    public int getBorderColor() {
        return this.zzb;
    }

    @NonNull
    public Glyph getGlyph() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 3, getBorderColor());
        SafeParcelWriter.writeParcelable(parcel, 4, getGlyph(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
