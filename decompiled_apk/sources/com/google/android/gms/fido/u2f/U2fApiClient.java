package com.google.android.gms.fido.u2f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;
import com.google.android.gms.internal.fido.zzw;
import com.google.android.gms.internal.fido.zzx;
import com.google.android.gms.internal.fido.zzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@Deprecated
/* loaded from: classes9.dex */
public class U2fApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey zza;
    private static final Api zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzb = new Api("Fido.U2F_API", new zzx(), clientKey);
    }

    public U2fApiClient(@NonNull Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @NonNull
    public Task<U2fPendingIntent> getRegisterIntent(@NonNull final RegisterRequestParams registerRequestParams) {
        return doRead(TaskApiCall.builder().setMethodKey(5424).run(new RemoteCall() { // from class: com.google.android.gms.fido.u2f.zzb
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                U2fApiClient u2fApiClient = U2fApiClient.this;
                RegisterRequestParams registerRequestParams2 = registerRequestParams;
                ((zzw) ((zzy) obj).getService()).zzc(new zzc(u2fApiClient, (TaskCompletionSource) obj2), registerRequestParams2);
            }
        }).build());
    }

    @NonNull
    public Task<U2fPendingIntent> getSignIntent(@NonNull final SignRequestParams signRequestParams) {
        return doRead(TaskApiCall.builder().setMethodKey(5425).run(new RemoteCall() { // from class: com.google.android.gms.fido.u2f.zza
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                U2fApiClient u2fApiClient = U2fApiClient.this;
                SignRequestParams signRequestParams2 = signRequestParams;
                ((zzw) ((zzy) obj).getService()).zzd(new zzd(u2fApiClient, (TaskCompletionSource) obj2), signRequestParams2);
            }
        }).build());
    }

    public U2fApiClient(@NonNull Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzb, Api.ApiOptions.NO_OPTIONS, new ApiExceptionMapper());
    }
}
