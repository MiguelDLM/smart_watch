package com.google.android.gms.fitness;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;

@Deprecated
/* loaded from: classes9.dex */
public interface GoalsApi {
    @NonNull
    PendingResult<GoalsResult> readCurrentGoals(@NonNull GoogleApiClient googleApiClient, @NonNull GoalsReadRequest goalsReadRequest);
}
