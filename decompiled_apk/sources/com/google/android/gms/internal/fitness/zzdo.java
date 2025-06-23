package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.GoalsApi;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;

/* loaded from: classes9.dex */
public final class zzdo implements GoalsApi {
    @Override // com.google.android.gms.fitness.GoalsApi
    public final PendingResult<GoalsResult> readCurrentGoals(GoogleApiClient googleApiClient, GoalsReadRequest goalsReadRequest) {
        return googleApiClient.enqueue(new zzdn(this, googleApiClient, goalsReadRequest));
    }
}
