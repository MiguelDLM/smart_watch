package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.maps.zzax;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzai implements TileProvider {
    final /* synthetic */ TileOverlayOptions zza;
    private final zzax zzb;

    public zzai(TileOverlayOptions tileOverlayOptions) {
        zzax zzaxVar;
        this.zza = tileOverlayOptions;
        zzaxVar = tileOverlayOptions.zza;
        this.zzb = zzaxVar;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    @Nullable
    public final Tile getTile(int i, int i2, int i3) {
        try {
            return this.zzb.zzb(i, i2, i3);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
