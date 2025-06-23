package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit repeatIntervalTimeUnit) {
        IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, repeatIntervalTimeUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval) {
        IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, repeatInterval);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j, TimeUnit repeatIntervalTimeUnit, long j2, TimeUnit flexTimeIntervalUnit) {
        IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
        IIX0o.x0xO0oo(flexTimeIntervalUnit, "flexTimeIntervalUnit");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, j, repeatIntervalTimeUnit, j2, flexTimeIntervalUnit);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration repeatInterval, Duration flexTimeInterval) {
        IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
        IIX0o.x0xO0oo(flexTimeInterval, "flexTimeInterval");
        IIX0o.OxI(4, "W");
        return new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ListenableWorker.class, repeatInterval, flexTimeInterval);
    }
}
