package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return ExceptionHelper.addThrowable(this, th);
    }

    public boolean isTerminated() {
        if (get() == ExceptionHelper.TERMINATED) {
            return true;
        }
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }
}
