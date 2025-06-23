package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.fitness.zzdl;
import com.google.android.gms.tasks.Task;

@Deprecated
/* loaded from: classes9.dex */
public class ConfigClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    public static final /* synthetic */ int zza = 0;
    private static final ConfigApi zzb = new zzdl();

    public ConfigClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) com.google.android.gms.internal.fitness.zzu.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    @Deprecated
    public Task<DataType> createCustomDataType(@NonNull DataTypeCreateRequest dataTypeCreateRequest) {
        return PendingResultUtil.toTask(zzb.createCustomDataType(asGoogleApiClient(), dataTypeCreateRequest), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zzd
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                int i = ConfigClient.zza;
                return (DataType) Preconditions.checkNotNull(((DataTypeResult) result).getDataType());
            }
        });
    }

    @NonNull
    public Task<Void> disableFit() {
        return PendingResultUtil.toVoidTask(zzb.disableFit(asGoogleApiClient()));
    }

    @NonNull
    @Deprecated
    public Task<DataType> readDataType(@NonNull String str) {
        return PendingResultUtil.toTask(zzb.readDataType(asGoogleApiClient(), str), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.fitness.zze
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                int i = ConfigClient.zza;
                return (DataType) Preconditions.checkNotNull(((DataTypeResult) result).getDataType());
            }
        });
    }

    @ShowFirstParty
    public ConfigClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) com.google.android.gms.internal.fitness.zzu.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
