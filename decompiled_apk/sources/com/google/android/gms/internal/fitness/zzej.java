package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

/* loaded from: classes9.dex */
public final class zzej implements RecordingApi {
    private final PendingResult zza(GoogleApiClient googleApiClient, Subscription subscription) {
        return googleApiClient.enqueue(new zzee(this, googleApiClient, subscription));
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzec(this, googleApiClient));
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        com.google.android.gms.fitness.data.zzag zzagVar = new com.google.android.gms.fitness.data.zzag();
        zzagVar.zza(dataSource);
        return zza(googleApiClient, zzagVar.zzd());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return googleApiClient.execute(new zzeg(this, googleApiClient, dataSource));
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.enqueue(new zzed(this, googleApiClient, dataType));
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        com.google.android.gms.fitness.data.zzag zzagVar = new com.google.android.gms.fitness.data.zzag();
        zzagVar.zzb(dataType);
        return zza(googleApiClient, zzagVar.zzd());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return googleApiClient.execute(new zzef(this, googleApiClient, dataType));
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        if (subscription.getDataType() == null) {
            return unsubscribe(googleApiClient, (DataSource) Preconditions.checkNotNull(subscription.getDataSource()));
        }
        return unsubscribe(googleApiClient, (DataType) Preconditions.checkNotNull(subscription.getDataType()));
    }
}
