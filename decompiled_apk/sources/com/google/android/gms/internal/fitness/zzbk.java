package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* loaded from: classes9.dex */
final class zzbk extends Api.AbstractClientBuilder {
    private zzbk() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzbn(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, null);
    }

    public /* synthetic */ zzbk(zzbj zzbjVar) {
    }
}
