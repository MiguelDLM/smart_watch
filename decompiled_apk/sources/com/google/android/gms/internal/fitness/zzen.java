package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* loaded from: classes9.dex */
public final class zzen implements SensorsApi {
    private final PendingResult zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, @Nullable com.google.android.gms.fitness.data.zzv zzvVar, @Nullable PendingIntent pendingIntent) {
        return googleApiClient.enqueue(new zzel(this, googleApiClient, sensorRequest, zzvVar, pendingIntent));
    }

    private final PendingResult zzb(GoogleApiClient googleApiClient, @Nullable com.google.android.gms.fitness.data.zzv zzvVar, @Nullable PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzem(this, googleApiClient, zzvVar, pendingIntent));
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public final PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, null, pendingIntent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public final PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.enqueue(new zzek(this, googleApiClient, dataSourcesRequest));
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public final PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zzb(googleApiClient, null, pendingIntent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public final PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, com.google.android.gms.fitness.request.zzah.zza().zzc(onDataPointListener, googleApiClient.getLooper()), null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public final PendingResult<Status> remove(GoogleApiClient googleApiClient, OnDataPointListener onDataPointListener) {
        com.google.android.gms.fitness.request.zzaj zze = com.google.android.gms.fitness.request.zzah.zza().zze(onDataPointListener, googleApiClient.getLooper());
        if (zze == null) {
            return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient);
        }
        return zzb(googleApiClient, zze, null);
    }
}
