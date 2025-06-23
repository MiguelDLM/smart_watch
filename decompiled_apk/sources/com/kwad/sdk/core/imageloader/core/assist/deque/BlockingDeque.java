package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addFirst(E e);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addLast(E e);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E element();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E peek();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit);

    E pollFirst(long j, TimeUnit timeUnit);

    E pollLast(long j, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e);

    void putFirst(E e);

    void putLast(E e);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E remove();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take();

    E takeFirst();

    E takeLast();
}
