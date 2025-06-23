package androidx.work;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import androidx.work.impl.utils.EnqueueUtilsKt;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XO0OX.xxIXOIIO(name = "WorkerParametersExtensions")
@XX({"SMAP\nWorkerParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerParameters.kt\nandroidx/work/WorkerParametersExtensions\n+ 2 Data_.kt\nandroidx/work/Data\n*L\n1#1,100:1\n229#2:101\n229#2:102\n229#2:103\n*S KotlinDebug\n*F\n+ 1 WorkerParameters.kt\nandroidx/work/WorkerParametersExtensions\n*L\n96#1:101\n97#1:102\n98#1:103\n*E\n"})
/* loaded from: classes.dex */
public final class WorkerParametersExtensions {
    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Data buildDelegatedRemoteRequestData(@OXOo.OOXIXo String delegatedWorkerName, @OXOo.OOXIXo ComponentName componentName, @OXOo.OOXIXo Data inputData) {
        IIX0o.x0xO0oo(delegatedWorkerName, "delegatedWorkerName");
        IIX0o.x0xO0oo(componentName, "componentName");
        IIX0o.x0xO0oo(inputData, "inputData");
        Data.Builder builder = new Data.Builder();
        builder.putAll(inputData).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, componentName.getPackageName()).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, componentName.getClassName()).putString(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, delegatedWorkerName);
        return builder.build();
    }

    public static final boolean isRemoteWorkRequest(@OXOo.OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(workerParameters, "<this>");
        Data inputData = workerParameters.getInputData();
        IIX0o.oO(inputData, "inputData");
        return isRemoteWorkRequest(inputData);
    }

    public static final /* synthetic */ <T extends ListenableWorker> WorkerParameters usingRemoteService(WorkerParameters workerParameters, ComponentName componentName) {
        IIX0o.x0xO0oo(workerParameters, "<this>");
        IIX0o.x0xO0oo(componentName, "componentName");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        String name = ListenableWorker.class.getName();
        IIX0o.oO(name, "T::class.java.name");
        return usingRemoteService(workerParameters, name, componentName);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isRemoteWorkRequest(@OXOo.OOXIXo Data data) {
        IIX0o.x0xO0oo(data, "<this>");
        return data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, String.class) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, String.class) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, String.class);
    }

    @OXOo.OOXIXo
    public static final WorkerParameters usingRemoteService(@OXOo.OOXIXo WorkerParameters workerParameters, @OXOo.OOXIXo String workerClassName, @OXOo.OOXIXo ComponentName componentName) {
        IIX0o.x0xO0oo(workerParameters, "<this>");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(componentName, "componentName");
        UUID id = workerParameters.getId();
        Data inputData = workerParameters.getInputData();
        IIX0o.oO(inputData, "inputData");
        return new WorkerParameters(id, buildDelegatedRemoteRequestData(workerClassName, componentName, inputData), workerParameters.getTags(), workerParameters.getRuntimeExtras(), workerParameters.getRunAttemptCount(), workerParameters.getGeneration(), workerParameters.getBackgroundExecutor(), workerParameters.getWorkerContext(), workerParameters.getTaskExecutor(), workerParameters.getWorkerFactory(), workerParameters.getProgressUpdater(), workerParameters.getForegroundUpdater());
    }
}
