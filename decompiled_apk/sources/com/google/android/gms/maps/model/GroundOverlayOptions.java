package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator = "GroundOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes9.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzk();
    public static final float NO_DIMENSION = -1.0f;

    @SafeParcelable.Field(getter = "getWrappedImageDescriptorImplBinder", id = 2, type = "android.os.IBinder")
    private BitmapDescriptor zza;

    @Nullable
    @SafeParcelable.Field(getter = "getLocation", id = 3)
    private LatLng zzb;

    @SafeParcelable.Field(getter = "getWidth", id = 4)
    private float zzc;

    @SafeParcelable.Field(getter = "getHeight", id = 5)
    private float zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getBounds", id = 6)
    private LatLngBounds zze;

    @SafeParcelable.Field(getter = "getBearing", id = 7)
    private float zzf;

    @SafeParcelable.Field(getter = "getZIndex", id = 8)
    private float zzg;

    @SafeParcelable.Field(getter = "isVisible", id = 9)
    private boolean zzh;

    @SafeParcelable.Field(getter = "getTransparency", id = 10)
    private float zzi;

    @SafeParcelable.Field(getter = "getAnchorU", id = 11)
    private float zzj;

    @SafeParcelable.Field(getter = "getAnchorV", id = 12)
    private float zzk;

    @SafeParcelable.Field(getter = "isClickable", id = 13)
    private boolean zzl;

    public GroundOverlayOptions() {
        this.zzh = true;
        this.zzi = 0.0f;
        this.zzj = 0.5f;
        this.zzk = 0.5f;
        this.zzl = false;
    }

    private final GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzb = latLng;
        this.zzc = f;
        this.zzd = f2;
        return this;
    }

    @NonNull
    public GroundOverlayOptions anchor(float f, float f2) {
        this.zzj = f;
        this.zzk = f2;
        return this;
    }

    @NonNull
    public GroundOverlayOptions bearing(float f) {
        this.zzf = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    @NonNull
    public GroundOverlayOptions clickable(boolean z) {
        this.zzl = z;
        return this;
    }

    public float getAnchorU() {
        return this.zzj;
    }

    public float getAnchorV() {
        return this.zzk;
    }

    public float getBearing() {
        return this.zzf;
    }

    @Nullable
    public LatLngBounds getBounds() {
        return this.zze;
    }

    public float getHeight() {
        return this.zzd;
    }

    @NonNull
    public BitmapDescriptor getImage() {
        return this.zza;
    }

    @Nullable
    public LatLng getLocation() {
        return this.zzb;
    }

    public float getTransparency() {
        return this.zzi;
    }

    public float getWidth() {
        return this.zzc;
    }

    public float getZIndex() {
        return this.zzg;
    }

    @NonNull
    public GroundOverlayOptions image(@NonNull BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        this.zza = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.zzl;
    }

    public boolean isVisible() {
        return this.zzh;
    }

    @NonNull
    public GroundOverlayOptions position(@NonNull LatLng latLng, float f) {
        Preconditions.checkState(this.zze == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f >= 0.0f, "Width must be non-negative");
        zza(latLng, f, -1.0f);
        return this;
    }

    @NonNull
    public GroundOverlayOptions positionFromBounds(@NonNull LatLngBounds latLngBounds) {
        boolean z;
        LatLng latLng = this.zzb;
        String valueOf = String.valueOf(latLng);
        if (latLng == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Position has already been set using position: ".concat(valueOf));
        this.zze = latLngBounds;
        return this;
    }

    @NonNull
    public GroundOverlayOptions transparency(float f) {
        boolean z = false;
        if (f >= 0.0f && f <= 1.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Transparency must be in the range [0..1]");
        this.zzi = f;
        return this;
    }

    @NonNull
    public GroundOverlayOptions visible(boolean z) {
        this.zzh = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.zza().asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getLocation(), i, false);
        SafeParcelWriter.writeFloat(parcel, 4, getWidth());
        SafeParcelWriter.writeFloat(parcel, 5, getHeight());
        SafeParcelWriter.writeParcelable(parcel, 6, getBounds(), i, false);
        SafeParcelWriter.writeFloat(parcel, 7, getBearing());
        SafeParcelWriter.writeFloat(parcel, 8, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeFloat(parcel, 10, getTransparency());
        SafeParcelWriter.writeFloat(parcel, 11, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 12, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 13, isClickable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public GroundOverlayOptions zIndex(float f) {
        this.zzg = f;
        return this;
    }

    @SafeParcelable.Constructor
    public GroundOverlayOptions(@SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) LatLng latLng, @SafeParcelable.Param(id = 4) float f, @SafeParcelable.Param(id = 5) float f2, @SafeParcelable.Param(id = 6) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 7) float f3, @SafeParcelable.Param(id = 8) float f4, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) float f5, @SafeParcelable.Param(id = 11) float f6, @SafeParcelable.Param(id = 12) float f7, @SafeParcelable.Param(id = 13) boolean z2) {
        this.zzh = true;
        this.zzi = 0.0f;
        this.zzj = 0.5f;
        this.zzk = 0.5f;
        this.zzl = false;
        this.zza = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzb = latLng;
        this.zzc = f;
        this.zzd = f2;
        this.zze = latLngBounds;
        this.zzf = f3;
        this.zzg = f4;
        this.zzh = z;
        this.zzi = f5;
        this.zzj = f6;
        this.zzk = f7;
        this.zzl = z2;
    }

    @NonNull
    public GroundOverlayOptions position(@NonNull LatLng latLng, float f, float f2) {
        Preconditions.checkState(this.zze == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f >= 0.0f, "Width must be non-negative");
        Preconditions.checkArgument(f2 >= 0.0f, "Height must be non-negative");
        zza(latLng, f, f2);
        return this;
    }
}
