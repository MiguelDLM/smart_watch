package okhttp3.internal.concurrent;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.jvm.internal.xxX;

/* loaded from: classes6.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    @OOXIXo
    public static final String formatDuration(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - 500000000) / 1000000000) + " s ";
        } else if (j <= -999500) {
            str = ((j - 500000) / 1000000) + " ms";
        } else if (j <= 0) {
            str = ((j - 500) / 1000) + " µs";
        } else if (j < 999500) {
            str = ((j + 500) / 1000) + " µs";
        } else if (j < 999500000) {
            str = ((j + 500000) / 1000000) + " ms";
        } else {
            str = ((j + 500000000) / 1000000000) + " s ";
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        IIX0o.oO(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(TokenParser.SP);
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        IIX0o.oO(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(@OOXIXo Task task, @OOXIXo TaskQueue queue, @OOXIXo oIX0oI<? extends T> block) {
        long j;
        IIX0o.x0xO0oo(task, "task");
        IIX0o.x0xO0oo(queue, "queue");
        IIX0o.x0xO0oo(block, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, queue, "starting");
        } else {
            j = -1;
        }
        try {
            T invoke = block.invoke();
            xxX.oxoX(1);
            if (isLoggable) {
                log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j));
            }
            xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            xxX.oxoX(1);
            if (isLoggable) {
                log(task, queue, "failed a run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j));
            }
            xxX.I0Io(1);
            throw th;
        }
    }

    public static final void taskLog(@OOXIXo Task task, @OOXIXo TaskQueue queue, @OOXIXo oIX0oI<String> messageBlock) {
        IIX0o.x0xO0oo(task, "task");
        IIX0o.x0xO0oo(queue, "queue");
        IIX0o.x0xO0oo(messageBlock, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, messageBlock.invoke());
        }
    }
}
