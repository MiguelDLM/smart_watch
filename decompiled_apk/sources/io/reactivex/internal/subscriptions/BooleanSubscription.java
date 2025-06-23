package io.reactivex.internal.subscriptions;

import XXO0.oIX0oI;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + oIX0oI.I0Io.f4095I0Io;
    }
}
