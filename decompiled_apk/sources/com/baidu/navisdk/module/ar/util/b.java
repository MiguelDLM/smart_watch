package com.baidu.navisdk.module.ar.util;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b implements ThreadFactory {
    private static final AtomicInteger d;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f7004a;
    private final AtomicInteger b;
    private final String c;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
        d = new AtomicInteger(1);
    }

    public b(@OOXIXo String name) {
        ThreadGroup threadGroup;
        String str;
        IIX0o.x0xO0oo(name, "name");
        this.b = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
            str = "s.threadGroup";
        } else {
            Thread currentThread = Thread.currentThread();
            IIX0o.oO(currentThread, "Thread.currentThread()");
            threadGroup = currentThread.getThreadGroup();
            str = "Thread.currentThread().threadGroup";
        }
        IIX0o.oO(threadGroup, str);
        this.f7004a = threadGroup;
        this.c = name + HelpFormatter.DEFAULT_OPT_PREFIX + d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    @OOXIXo
    public Thread newThread(@OOXIXo Runnable r) {
        IIX0o.x0xO0oo(r, "r");
        Thread thread = new Thread(this.f7004a, r, this.c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
