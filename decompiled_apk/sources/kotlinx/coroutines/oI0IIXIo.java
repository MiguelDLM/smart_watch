package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes6.dex */
public final class oI0IIXIo extends xxX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30337I0Io = AtomicIntegerFieldUpdater.newUpdater(oI0IIXIo.class, "_resumed");

    @XO0OX.o00
    private volatile int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public oI0IIXIo(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> r3, @OXOo.oOoXoXO java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L1d
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L1d:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.oI0IIXIo.<init>(kotlin.coroutines.I0Io, java.lang.Throwable, boolean):void");
    }

    public final boolean I0Io() {
        return f30337I0Io.compareAndSet(this, 0, 1);
    }
}
