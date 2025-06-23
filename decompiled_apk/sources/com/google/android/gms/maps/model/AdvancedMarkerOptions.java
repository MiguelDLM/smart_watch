package com.google.android.gms.maps.model;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes9.dex */
public class AdvancedMarkerOptions extends MarkerOptions {

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes9.dex */
    public @interface CollisionBehavior {
        public static final int OPTIONAL_AND_HIDES_LOWER_PRIORITY = 2;
        public static final int REQUIRED = 0;
        public static final int REQUIRED_AND_HIDES_OPTIONAL = 1;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions alpha(float f) {
        super.alpha(f);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions anchor(float f, float f2) {
        super.anchor(f, f2);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions collisionBehavior(@CollisionBehavior int i) {
        super.zzd(i);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions contentDescription(@Nullable String str) {
        super.contentDescription(str);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions draggable(boolean z) {
        super.draggable(z);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions flat(boolean z) {
        super.flat(z);
        return this;
    }

    public int getCollisionBehavior() {
        return super.zza();
    }

    @Nullable
    public View getIconView() {
        return super.zzc();
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor) {
        super.icon(bitmapDescriptor);
        return this;
    }

    @NonNull
    public AdvancedMarkerOptions iconView(@Nullable View view) {
        zze(view);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions infoWindowAnchor(float f, float f2) {
        super.infoWindowAnchor(f, f2);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions position(@NonNull LatLng latLng) {
        super.position(latLng);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions rotation(float f) {
        super.rotation(f);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions snippet(@Nullable String str) {
        super.snippet(str);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions title(@Nullable String str) {
        super.title(str);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions visible(boolean z) {
        super.visible(z);
        return this;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    @NonNull
    public AdvancedMarkerOptions zIndex(float f) {
        super.zIndex(f);
        return this;
    }
}
