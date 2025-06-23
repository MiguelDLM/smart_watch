package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResponse;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.fitness.zzbn;
import com.google.android.gms.internal.fitness.zzey;
import com.google.android.gms.tasks.Task;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public class SessionsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final SessionsApi zza = new zzey();

    public SessionsClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzbn.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<Void> insertSession(@NonNull SessionInsertRequest sessionInsertRequest) {
        return PendingResultUtil.toVoidTask(zza.insertSession(asGoogleApiClient(), sessionInsertRequest));
    }

    @NonNull
    public Task<SessionReadResponse> readSession(@NonNull SessionReadRequest sessionReadRequest) {
        return PendingResultUtil.toResponseTask(zza.readSession(asGoogleApiClient(), sessionReadRequest), new SessionReadResponse());
    }

    @NonNull
    public Task<Void> registerForSessions(@NonNull PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zza.registerForSessions(asGoogleApiClient(), pendingIntent));
    }

    @NonNull
    public Task<Void> startSession(@NonNull Session session) {
        return PendingResultUtil.toVoidTask(zza.startSession(asGoogleApiClient(), session));
    }

    @NonNull
    public Task<List<Session>> stopSession(@Nullable String str) {
        return PendingResultUtil.toTask(zza.stopSession(asGoogleApiClient(), str), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zzx
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((SessionStopResult) result).getSessions();
            }
        });
    }

    @NonNull
    public Task<Void> unregisterForSessions(@NonNull PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zza.unregisterForSessions(asGoogleApiClient(), pendingIntent));
    }

    @ShowFirstParty
    public SessionsClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzbn.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
