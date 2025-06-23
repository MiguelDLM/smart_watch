package com.facebook.bolts;

/* loaded from: classes8.dex */
public class TaskCompletionSource<TResult> {

    @OXOo.OOXIXo
    private final Task<TResult> task = new Task<>();

    @OXOo.OOXIXo
    public final Task<TResult> getTask() {
        return this.task;
    }

    public final void setCancelled() {
        if (trySetCancelled()) {
        } else {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void setError(@OXOo.oOoXoXO Exception exc) {
        if (trySetError(exc)) {
        } else {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public final void setResult(@OXOo.oOoXoXO TResult tresult) {
        if (trySetResult(tresult)) {
        } else {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public final boolean trySetError(@OXOo.oOoXoXO Exception exc) {
        return this.task.trySetError(exc);
    }

    public final boolean trySetResult(@OXOo.oOoXoXO TResult tresult) {
        return this.task.trySetResult(tresult);
    }
}
