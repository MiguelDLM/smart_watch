package androidx.work.impl.utils;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.O00XxXI;

public final class WorkForegroundKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkForegroundRunnable\")");
        TAG = tagWithPrefix;
    }

    @oOoXoXO
    public static final Object workForeground(@OOXIXo Context context, @OOXIXo WorkSpec workSpec, @OOXIXo ListenableWorker listenableWorker, @OOXIXo ForegroundUpdater foregroundUpdater, @OOXIXo TaskExecutor taskExecutor, @OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
        if (!workSpec.expedited || Build.VERSION.SDK_INT >= 31) {
            return oXIO0o0XI.f19155oIX0oI;
        }
        Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
        IIX0o.oO(mainThreadExecutor, "taskExecutor.mainThreadExecutor");
        Object II0XooXoX2 = II0XooXoX.II0XooXoX(O00XxXI.I0Io(mainThreadExecutor), new WorkForegroundKt$workForeground$2(listenableWorker, workSpec, foregroundUpdater, context, (I0Io<? super WorkForegroundKt$workForeground$2>) null), i0Io);
        if (II0XooXoX2 == II0xO0.oOoXoXO()) {
            return II0XooXoX2;
        }
        return oXIO0o0XI.f19155oIX0oI;
    }
}
