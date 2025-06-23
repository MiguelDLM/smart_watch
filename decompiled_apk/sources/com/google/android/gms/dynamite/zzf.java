package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes9.dex */
final class zzf implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        if (zzb != 0) {
            selectionResult.selection = 1;
        } else {
            int zza = iVersions.zza(context, str);
            selectionResult.localVersion = zza;
            if (zza != 0) {
                selectionResult.selection = -1;
            }
        }
        return selectionResult;
    }
}
