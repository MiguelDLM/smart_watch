package com.facebook.bolts;

import androidx.annotation.VisibleForTesting;
import com.facebook.bolts.Task;

/* loaded from: classes8.dex */
public final class UnobservedErrorNotifier {

    @OXOo.oOoXoXO
    private Task<?> task;

    public UnobservedErrorNotifier(@OXOo.oOoXoXO Task<?> task) {
        this.task = task;
    }

    @VisibleForTesting(otherwise = 4)
    public final void finalize() {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        Task<?> task = this.task;
        if (task != null && (unobservedExceptionHandler = Task.Companion.getUnobservedExceptionHandler()) != null) {
            unobservedExceptionHandler.unobservedException(task, new UnobservedTaskException(task.getError()));
        }
    }

    public final void setObserved() {
        this.task = null;
    }
}
