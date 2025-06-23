package androidx.work.impl.utils;

import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.WorkerExceptionInfo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkerExceptionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerExceptionUtils.kt\nandroidx/work/impl/utils/WorkerExceptionUtilsKt\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n*L\n1#1,37:1\n32#2:38\n*S KotlinDebug\n*F\n+ 1 WorkerExceptionUtils.kt\nandroidx/work/impl/utils/WorkerExceptionUtilsKt\n*L\n34#1:38\n*E\n"})
/* loaded from: classes.dex */
public final class WorkerExceptionUtilsKt {
    public static final void safeAccept(@OXOo.OOXIXo Consumer<WorkerExceptionInfo> consumer, @OXOo.OOXIXo WorkerExceptionInfo info, @OXOo.OOXIXo String tag) {
        IIX0o.x0xO0oo(consumer, "<this>");
        IIX0o.x0xO0oo(info, "info");
        IIX0o.x0xO0oo(tag, "tag");
        try {
            consumer.accept(info);
        } catch (Throwable th) {
            Logger.get().error(tag, "Exception handler threw an exception", th);
        }
    }
}
