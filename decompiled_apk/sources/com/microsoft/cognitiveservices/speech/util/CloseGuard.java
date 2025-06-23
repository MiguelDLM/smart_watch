package com.microsoft.cognitiveservices.speech.util;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class CloseGuard {
    private AtomicBoolean isClosed = new AtomicBoolean();
    private AtomicInteger inUseCount = new AtomicInteger();

    public CloseGuard() {
        this.isClosed.set(false);
        this.inUseCount.set(0);
    }

    public void closeObject() {
        this.isClosed.set(true);
        while (true) {
            int i = 0;
            while (!this.inUseCount.compareAndSet(0, -1) && this.inUseCount.get() != -1) {
                int i2 = i + 1;
                if (i == 100) {
                    break;
                } else {
                    i = i2;
                }
            }
            return;
            Thread.yield();
        }
    }

    public void enterUseObject() {
        if (this.isClosed.get()) {
            throw new IllegalStateException("Attempt to use closed object rejected.");
        }
        int i = 0;
        int i2 = 0;
        while (!this.inUseCount.compareAndSet(i, i + 1)) {
            int i3 = i2 + 1;
            if (i2 == 100) {
                Thread.yield();
                i2 = 0;
            } else {
                i2 = i3;
            }
            i = this.inUseCount.get();
            if (i == -1) {
                throw new IllegalStateException("Attempt to use closed object rejected.");
            }
        }
    }

    public void exitUseObject() {
        this.inUseCount.decrementAndGet();
    }
}
