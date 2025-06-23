package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.O00XxXI;

/* loaded from: classes.dex */
public final class WorkForegroundKt {

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkForegroundRunnable\")");
        TAG = tagWithPrefix;
    }

    @OXOo.oOoXoXO
    public static final Object workForeground(@OXOo.OOXIXo Context context, @OXOo.OOXIXo WorkSpec workSpec, @OXOo.OOXIXo ListenableWorker listenableWorker, @OXOo.OOXIXo ForegroundUpdater foregroundUpdater, @OXOo.OOXIXo TaskExecutor taskExecutor, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (workSpec.expedited && Build.VERSION.SDK_INT < 31) {
            Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
            IIX0o.oO(mainThreadExecutor, "taskExecutor.mainThreadExecutor");
            Object II0XooXoX2 = kotlinx.coroutines.II0XooXoX.II0XooXoX(O00XxXI.I0Io(mainThreadExecutor), new WorkForegroundKt$workForeground$2(listenableWorker, workSpec, foregroundUpdater, context, null), i0Io);
            if (II0XooXoX2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return II0XooXoX2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
