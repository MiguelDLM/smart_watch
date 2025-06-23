package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.StampStyle;

/* loaded from: classes9.dex */
public class SpriteStyle extends StampStyle {

    /* loaded from: classes9.dex */
    public static final class Builder extends StampStyle.Builder<Builder> {
        private Builder() {
            throw null;
        }

        @NonNull
        public SpriteStyle build() {
            return new SpriteStyle(this.zza);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.gms.maps.model.StampStyle.Builder
        @NonNull
        public Builder self() {
            return this;
        }

        public /* synthetic */ Builder(zzv zzvVar) {
        }

        @Override // com.google.android.gms.maps.model.StampStyle.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Builder self() {
            return this;
        }
    }

    public SpriteStyle(@NonNull BitmapDescriptor bitmapDescriptor) {
        super(bitmapDescriptor);
    }

    @NonNull
    public static Builder newBuilder(@NonNull BitmapDescriptor bitmapDescriptor) {
        return new Builder(null).stamp(bitmapDescriptor);
    }
}
