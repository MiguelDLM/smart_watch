package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class zzey implements SessionsApi {
    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.enqueue(new zzeq(this, googleApiClient, sessionInsertRequest));
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        return googleApiClient.enqueue(new zzer(this, googleApiClient, sessionReadRequest));
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzes(this, googleApiClient, pendingIntent));
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session) {
        boolean z;
        Preconditions.checkNotNull(session, "Session cannot be null");
        if (session.getEndTime(TimeUnit.MILLISECONDS) == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot start a session which has already ended");
        return googleApiClient.execute(new zzeo(this, googleApiClient, session));
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, @Nullable String str) {
        return googleApiClient.execute(new zzep(this, googleApiClient, null, str));
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public final PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzet(this, googleApiClient, pendingIntent));
    }
}
