package androidx.work;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import androidx.work.impl.utils.EnqueueUtilsKt;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkerParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerParameters.kt\nandroidx/work/WorkerParametersExtensions\n+ 2 Data_.kt\nandroidx/work/Data\n*L\n1#1,100:1\n229#2:101\n229#2:102\n229#2:103\n*S KotlinDebug\n*F\n+ 1 WorkerParameters.kt\nandroidx/work/WorkerParametersExtensions\n*L\n96#1:101\n97#1:102\n98#1:103\n*E\n"})
@xxIXOIIO(name = "WorkerParametersExtensions")
public final class WorkerParametersExtensions {
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Data buildDelegatedRemoteRequestData(@OOXIXo String str, @OOXIXo ComponentName componentName, @OOXIXo Data data) {
        IIX0o.x0xO0oo(str, "delegatedWorkerName");
        IIX0o.x0xO0oo(componentName, "componentName");
        IIX0o.x0xO0oo(data, "inputData");
        Data.Builder builder = new Data.Builder();
        builder.putAll(data).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, componentName.getPackageName()).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, componentName.getClassName()).putString(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, str);
        return builder.build();
    }

    public static final boolean isRemoteWorkRequest(@OOXIXo WorkerParameters workerParameters) {
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
    public static final boolean isRemoteWorkRequest(@OOXIXo Data data) {
        IIX0o.x0xO0oo(data, "<this>");
        Class<String> cls = String.class;
        return data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, cls) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, cls) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, cls);
    }

    @OOXIXo
    public static final WorkerParameters usingRemoteService(@OOXIXo WorkerParameters workerParameters, @OOXIXo String str, @OOXIXo ComponentName componentName) {
        String str2 = str;
        ComponentName componentName2 = componentName;
        IIX0o.x0xO0oo(workerParameters, "<this>");
        IIX0o.x0xO0oo(str2, "workerClassName");
        IIX0o.x0xO0oo(componentName2, "componentName");
        UUID id = workerParameters.getId();
        Data inputData = workerParameters.getInputData();
        IIX0o.oO(inputData, "inputData");
        return new WorkerParameters(id, buildDelegatedRemoteRequestData(str2, componentName2, inputData), workerParameters.getTags(), workerParameters.getRuntimeExtras(), workerParameters.getRunAttemptCount(), workerParameters.getGeneration(), workerParameters.getBackgroundExecutor(), workerParameters.getWorkerContext(), workerParameters.getTaskExecutor(), workerParameters.getWorkerFactory(), workerParameters.getProgressUpdater(), workerParameters.getForegroundUpdater());
    }
}
