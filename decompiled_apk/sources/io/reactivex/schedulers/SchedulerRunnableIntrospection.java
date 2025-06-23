package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;

/* loaded from: classes6.dex */
public interface SchedulerRunnableIntrospection {
    @NonNull
    Runnable getWrappedRunnable();
}
