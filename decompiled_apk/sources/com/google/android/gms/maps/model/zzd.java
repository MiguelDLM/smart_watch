package com.google.android.gms.maps.model;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.maps.zzaq;
import com.google.android.gms.maps.model.FeatureLayer;

/* loaded from: classes9.dex */
final class zzd extends zzaq {
    final /* synthetic */ FeatureLayer.StyleFactory zza;

    public zzd(FeatureLayer featureLayer, FeatureLayer.StyleFactory styleFactory) {
        this.zza = styleFactory;
    }

    @Override // com.google.android.gms.internal.maps.zzar
    @Nullable
    public final FeatureStyle zzb(com.google.android.gms.internal.maps.zzp zzpVar) {
        Feature zza = Feature.zza(zzpVar);
        if (zza == null) {
            return null;
        }
        return this.zza.getStyle(zza);
    }
}
