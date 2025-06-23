package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

/* loaded from: classes6.dex */
public interface HasUpstreamPublisher<T> {
    Publisher<T> source();
}
