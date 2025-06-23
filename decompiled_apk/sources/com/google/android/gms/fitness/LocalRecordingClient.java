package com.google.android.gms.fitness;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fitness.data.LocalDataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.zzag;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.LocalDataReadRequest;
import com.google.android.gms.fitness.request.zzbe;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.fitness.result.LocalDataReadResponse;
import com.google.android.gms.internal.fitness.zzaj;
import com.google.android.gms.internal.fitness.zzax;
import com.google.android.gms.internal.fitness.zzcg;
import com.google.android.gms.internal.fitness.zzci;
import com.google.android.gms.internal.fitness.zzcw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Optional;

/* loaded from: classes9.dex */
public class LocalRecordingClient {
    public static final int LOCAL_RECORDING_CLIENT_MIN_VERSION_CODE = 241500000;
    private final RecordingClient zza;
    private final HistoryClient zzb;
    private final Context zzc;

    public LocalRecordingClient(Activity activity) {
        GoogleSignInAccount googleSignInAccount = zzg.zzb;
        this.zza = Fitness.getRecordingClient(activity, googleSignInAccount);
        this.zzb = Fitness.getHistoryClient(activity, googleSignInAccount);
        this.zzc = activity;
    }

    private final Optional zza() {
        Optional empty;
        Optional of;
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzc) < 241500000) {
            of = Optional.of(new ApiException(new Status(2, "Google Play services requires an update to use these APIs")));
            return of;
        }
        empty = Optional.empty();
        return empty;
    }

    @NonNull
    public Task<LocalDataReadResponse> readData(@NonNull final LocalDataReadRequest localDataReadRequest) {
        boolean isPresent;
        Object obj;
        isPresent = zza().isPresent();
        if (isPresent) {
            obj = zza().get();
            return Tasks.forException((Exception) obj);
        }
        return this.zzb.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.fitness.zzn
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj2, Object obj3) {
                ((zzcg) ((zzaj) obj2).getService()).zzg(new DataReadRequest(localDataReadRequest.zza(), new zzs(LocalRecordingClient.this, (TaskCompletionSource) obj3)));
            }
        }).setFeatures(zzf.zzd).build());
    }

    @NonNull
    @RequiresPermission("android.permission.ACTIVITY_RECOGNITION")
    @TargetApi(29)
    public Task<Void> subscribe(@NonNull LocalDataType localDataType) {
        boolean isPresent;
        Object obj;
        isPresent = zza().isPresent();
        if (isPresent) {
            obj = zza().get();
            return Tasks.forException((Exception) obj);
        }
        zzag zzagVar = new zzag();
        zzagVar.zzb(localDataType.zza());
        zzagVar.zzc(1);
        final Subscription zzd = zzagVar.zzd();
        return this.zza.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.fitness.zzo
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj2, Object obj3) {
                ((zzci) ((zzax) obj2).getService()).zze(new zzbe(zzd, false, (zzcw) new zzq(LocalRecordingClient.this, (TaskCompletionSource) obj3)));
            }
        }).setFeatures(zzf.zzd).build());
    }

    @NonNull
    public Task<Void> unsubscribe(@NonNull final LocalDataType localDataType) {
        boolean isPresent;
        Object obj;
        isPresent = zza().isPresent();
        if (isPresent) {
            obj = zza().get();
            return Tasks.forException((Exception) obj);
        }
        return this.zza.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.fitness.zzp
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj2, Object obj3) {
                ((zzci) ((zzax) obj2).getService()).zzf(new zzbi(localDataType.zza(), null, new zzr(LocalRecordingClient.this, (TaskCompletionSource) obj3)));
            }
        }).setFeatures(zzf.zzd).build());
    }

    public LocalRecordingClient(Context context) {
        GoogleSignInAccount googleSignInAccount = zzg.zzb;
        this.zza = Fitness.getRecordingClient(context, googleSignInAccount);
        this.zzb = Fitness.getHistoryClient(context, googleSignInAccount);
        this.zzc = context;
    }
}
