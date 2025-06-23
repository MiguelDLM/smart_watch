package o0IXXIx;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public class oOoXoXO implements ThreadFactory {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final AtomicInteger f31086oI0IIXIo = new AtomicInteger(1);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final String f31087IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final AtomicInteger f31088Oo = new AtomicInteger(1);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final int f31089Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final ThreadGroup f31090XO;

    public oOoXoXO(int i, String str) {
        ThreadGroup threadGroup;
        this.f31089Oxx0xo = i;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f31090XO = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f31087IXxxXO = "Octopus-adsdk-background-" + f31086oI0IIXIo.getAndIncrement() + "-thread-";
            return;
        }
        this.f31087IXxxXO = str + f31086oI0IIXIo.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f31090XO, runnable, this.f31087IXxxXO + this.f31088Oo.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f31089Oxx0xo == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
