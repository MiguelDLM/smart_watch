package org.reactivestreams;

/* loaded from: classes6.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
