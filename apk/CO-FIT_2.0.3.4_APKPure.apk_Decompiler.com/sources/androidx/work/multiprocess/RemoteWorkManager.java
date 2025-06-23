package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class RemoteWorkManager {
    @NonNull
    public static RemoteWorkManager getInstance(@NonNull Context context) {
        RemoteWorkManager remoteWorkManager = WorkManagerImpl.getInstance(context).getRemoteWorkManager();
        if (remoteWorkManager != null) {
            return remoteWorkManager;
        }
        throw new IllegalStateException("Unable to initialize RemoteWorkManager");
    }

    @NonNull
    public final RemoteWorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull OneTimeWorkRequest oneTimeWorkRequest) {
        return beginUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    @NonNull
    public abstract RemoteWorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list);

    @NonNull
    public final RemoteWorkContinuation beginWith(@NonNull OneTimeWorkRequest oneTimeWorkRequest) {
        return beginWith((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    @NonNull
    public abstract RemoteWorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> list);

    @NonNull
    public abstract ListenableFuture<Void> cancelAllWork();

    @NonNull
    public abstract ListenableFuture<Void> cancelAllWorkByTag(@NonNull String str);

    @NonNull
    public abstract ListenableFuture<Void> cancelUniqueWork(@NonNull String str);

    @NonNull
    public abstract ListenableFuture<Void> cancelWorkById(@NonNull UUID uuid);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NonNull
    public abstract ListenableFuture<Void> enqueue(@NonNull WorkContinuation workContinuation);

    @NonNull
    public abstract ListenableFuture<Void> enqueue(@NonNull WorkRequest workRequest);

    @NonNull
    public abstract ListenableFuture<Void> enqueue(@NonNull List<WorkRequest> list);

    @NonNull
    public abstract ListenableFuture<Void> enqueueUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest);

    @NonNull
    public final ListenableFuture<Void> enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull OneTimeWorkRequest oneTimeWorkRequest) {
        return enqueueUniqueWork(str, existingWorkPolicy, (List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    @NonNull
    public abstract ListenableFuture<Void> enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list);

    @NonNull
    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery workQuery);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NonNull
    public abstract ListenableFuture<Void> setForegroundAsync(@NonNull String str, @NonNull ForegroundInfo foregroundInfo);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NonNull
    public abstract ListenableFuture<Void> setProgress(@NonNull UUID uuid, @NonNull Data data);
}
