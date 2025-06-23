package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.Goal;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;
import com.google.android.gms.internal.fitness.zzab;
import com.google.android.gms.internal.fitness.zzdo;
import com.google.android.gms.tasks.Task;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public class GoalsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final GoalsApi zza = new zzdo();

    public GoalsClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzab.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<List<Goal>> readCurrentGoals(@NonNull GoalsReadRequest goalsReadRequest) {
        return PendingResultUtil.toTask(zza.readCurrentGoals(asGoogleApiClient(), goalsReadRequest), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zzk
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((GoalsResult) result).getGoals();
            }
        });
    }

    @ShowFirstParty
    public GoalsClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzab.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
