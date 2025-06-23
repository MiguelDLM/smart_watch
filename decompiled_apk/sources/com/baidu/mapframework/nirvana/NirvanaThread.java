package com.baidu.mapframework.nirvana;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class NirvanaThread extends Thread {

    /* renamed from: a, reason: collision with root package name */
    static final AtomicInteger f6076a = new AtomicInteger();
    static final AtomicInteger b = new AtomicInteger();
    private static volatile boolean c = false;

    public NirvanaThread(String str) {
        this(null, str);
    }

    public static boolean getDebug() {
        return c;
    }

    public static int getThreadsAlive() {
        return b.get();
    }

    public static int getThreadsCreated() {
        return f6076a.get();
    }

    public static void setDebug(boolean z) {
        c = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z = c;
        long nanoTime = System.nanoTime();
        if (z) {
            Utils.logi("NirvanaThread", "Created NirvanaThread " + getName() + " isDaemon:" + isDaemon());
        }
        try {
            AtomicInteger atomicInteger = b;
            atomicInteger.incrementAndGet();
            super.run();
            atomicInteger.decrementAndGet();
            if (z) {
                Utils.logi("NirvanaThread", String.format(Locale.getDefault(), "Exiting NirvanaThread %s, duration %d ms, Created Thread Num:%d , Alive Thread Num: %d", getName(), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime)), Integer.valueOf(getThreadsCreated()), Integer.valueOf(getThreadsAlive())));
            }
        } catch (Throwable th) {
            b.decrementAndGet();
            if (z) {
                Utils.logi("NirvanaThread", String.format(Locale.getDefault(), "Exiting NirvanaThread %s, duration %d ms, Created Thread Num:%d , Alive Thread Num: %d", getName(), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime)), Integer.valueOf(getThreadsCreated()), Integer.valueOf(getThreadsAlive())));
            }
            throw th;
        }
    }

    public NirvanaThread(Runnable runnable) {
        this(runnable, "NirvanaThread");
    }

    public NirvanaThread(Runnable runnable, String str) {
        super(runnable, str + HelpFormatter.DEFAULT_OPT_PREFIX + f6076a.incrementAndGet());
    }
}
