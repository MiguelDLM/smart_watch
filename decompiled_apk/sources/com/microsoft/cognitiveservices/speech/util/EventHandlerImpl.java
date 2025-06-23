package com.microsoft.cognitiveservices.speech.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class EventHandlerImpl<T> {
    private Runnable notifyConnectedOnce;
    private AtomicInteger runCounter;
    private ArrayList<EventHandler<T>> eventHandlerClients = new ArrayList<>();
    private boolean notifyConnectedOnceFired = false;

    public EventHandlerImpl(AtomicInteger atomicInteger) {
        this.runCounter = atomicInteger;
    }

    public void addEventListener(EventHandler<T> eventHandler) {
        synchronized (this) {
            try {
                if (!this.notifyConnectedOnceFired) {
                    this.notifyConnectedOnceFired = true;
                    Runnable runnable = this.notifyConnectedOnce;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.eventHandlerClients.add(eventHandler);
    }

    public void fireEvent(Object obj, T t) {
        Iterator<EventHandler<T>> it = this.eventHandlerClients.iterator();
        while (it.hasNext()) {
            EventHandler<T> next = it.next();
            AtomicInteger atomicInteger = this.runCounter;
            if (atomicInteger != null) {
                atomicInteger.incrementAndGet();
            }
            next.onEvent(obj, t);
            AtomicInteger atomicInteger2 = this.runCounter;
            if (atomicInteger2 != null) {
                atomicInteger2.decrementAndGet();
            }
        }
    }

    public boolean isUpdateNotificationOnConnectedFired() {
        return this.notifyConnectedOnceFired;
    }

    public void removeEventListener(EventHandler<T> eventHandler) {
        this.eventHandlerClients.remove(eventHandler);
    }

    public void updateNotificationOnConnected(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.notifyConnectedOnceFired) {
                    runnable.run();
                }
                this.notifyConnectedOnce = runnable;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
