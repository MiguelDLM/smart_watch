package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit) {
        IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        IIX0o.x0xO0oo(duration, "repeatInterval");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
        IIX0o.x0xO0oo(timeUnit2, "flexTimeIntervalUnit");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, timeUnit, j2, timeUnit2);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        IIX0o.x0xO0oo(duration, "repeatInterval");
        IIX0o.x0xO0oo(duration2, "flexTimeInterval");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, duration, duration2);
    }
}
