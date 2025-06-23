package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    private final Clock mClock;
    final Scheduler mImmediateScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(@NonNull Scheduler scheduler, @NonNull RunnableScheduler runnableScheduler, @NonNull Clock clock) {
        this.mImmediateScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mClock = clock;
    }

    public void schedule(@NonNull final WorkSpec workSpec, long j) {
        Runnable remove = this.mRunnables.remove(workSpec.id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                Logger logger = Logger.get();
                String str = DelayedWorkTracker.TAG;
                logger.debug(str, "Scheduling work " + workSpec.id);
                DelayedWorkTracker.this.mImmediateScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, r0);
        this.mRunnableScheduler.scheduleWithDelay(j - this.mClock.currentTimeMillis(), r0);
    }

    public void unschedule(@NonNull String str) {
        Runnable remove = this.mRunnables.remove(str);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }
}
