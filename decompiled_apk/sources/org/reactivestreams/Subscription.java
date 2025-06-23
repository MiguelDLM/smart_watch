package org.reactivestreams;

/* loaded from: classes6.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
