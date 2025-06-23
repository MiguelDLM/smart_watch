package o0IXXIx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f31102I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static volatile xoIox f31103II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f31104X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f31105XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final AtomicBoolean f31106oIX0oI = new AtomicBoolean();

    /* renamed from: oxoX, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f31107oxoX;

    public xoIox() {
        if (!f31106oIX0oI.get()) {
            oIX0oI();
        }
    }

    public static xoIox II0xO0() {
        if (f31103II0xO0 == null) {
            synchronized (xoIox.class) {
                try {
                    if (f31103II0xO0 == null) {
                        f31103II0xO0 = new xoIox();
                    }
                } finally {
                }
            }
        }
        return f31103II0xO0;
    }

    public static void oIX0oI() {
        AtomicBoolean atomicBoolean = f31106oIX0oI;
        if (!atomicBoolean.get()) {
            f31102I0Io = ooOOo0oXI.oIX0oI();
            f31107oxoX = ooOOo0oXI.II0xO0();
            f31104X0o0xo = ooOOo0oXI.I0Io();
            f31105XO = ooOOo0oXI.oxoX();
            atomicBoolean.set(true);
        }
    }

    public ExecutorService I0Io() {
        if (f31102I0Io == null) {
            f31102I0Io = ooOOo0oXI.oIX0oI();
        }
        return f31102I0Io;
    }

    public ExecutorService oxoX() {
        if (f31105XO == null) {
            f31105XO = ooOOo0oXI.oxoX();
        }
        return f31105XO;
    }
}
