package androidx.work.impl.utils;

import OXOo.OOXIXo;
import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.WorkerExceptionInfo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkerExceptionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerExceptionUtils.kt\nandroidx/work/impl/utils/WorkerExceptionUtilsKt\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,37:1\n32#2:38\n*S KotlinDebug\n*F\n+ 1 WorkerExceptionUtils.kt\nandroidx/work/impl/utils/WorkerExceptionUtilsKt\n*L\n34#1:38\n*E\n"})
public final class WorkerExceptionUtilsKt {
    public static final void safeAccept(@OOXIXo Consumer<WorkerExceptionInfo> consumer, @OOXIXo WorkerExceptionInfo workerExceptionInfo, @OOXIXo String str) {
        IIX0o.x0xO0oo(consumer, "<this>");
        IIX0o.x0xO0oo(workerExceptionInfo, "info");
        IIX0o.x0xO0oo(str, "tag");
        try {
            consumer.accept(workerExceptionInfo);
        } catch (Throwable th) {
            Logger.get().error(str, "Exception handler threw an exception", th);
        }
    }
}
