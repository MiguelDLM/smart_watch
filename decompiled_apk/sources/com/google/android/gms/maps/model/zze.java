package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.FeatureLayer;

/* loaded from: classes9.dex */
final class zze extends com.google.android.gms.internal.maps.zzai {
    final /* synthetic */ FeatureLayer.OnFeatureClickListener zza;

    public zze(FeatureLayer featureLayer, FeatureLayer.OnFeatureClickListener onFeatureClickListener) {
        this.zza = onFeatureClickListener;
    }

    @Override // com.google.android.gms.internal.maps.zzaj
    public final void zzb(com.google.android.gms.internal.maps.zzm zzmVar) {
        this.zza.onFeatureClick(new FeatureClickEvent(zzmVar));
    }
}
