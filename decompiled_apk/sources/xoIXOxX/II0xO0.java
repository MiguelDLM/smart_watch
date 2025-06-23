package xoIXOxX;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import xx0o0O.XO;

@xxIXOIIO(name = "ThreadsKt")
@XX({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0 {

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends Thread {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<oXIO0o0XI> f34943XO;

        public oIX0oI(Oox.oIX0oI<oXIO0o0XI> oix0oi) {
            this.f34943XO = oix0oi;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f34943XO.invoke();
        }
    }

    public static /* synthetic */ Thread I0Io(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Oox.oIX0oI oix0oi, int i2, Object obj) {
        boolean z3;
        boolean z4;
        ClassLoader classLoader2;
        String str2;
        int i3;
        if ((i2 & 1) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i2 & 2) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i2 & 4) != 0) {
            classLoader2 = null;
        } else {
            classLoader2 = classLoader;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        return II0xO0(z3, z4, classLoader2, str2, i3, oix0oi);
    }

    @OOXIXo
    public static final Thread II0xO0(boolean z, boolean z2, @oOoXoXO ClassLoader classLoader, @oOoXoXO String str, int i, @OOXIXo Oox.oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        oIX0oI oix0oi = new oIX0oI(block);
        if (z2) {
            oix0oi.setDaemon(true);
        }
        if (i > 0) {
            oix0oi.setPriority(i);
        }
        if (str != null) {
            oix0oi.setName(str);
        }
        if (classLoader != null) {
            oix0oi.setContextClassLoader(classLoader);
        }
        if (z) {
            oix0oi.start();
        }
        return oix0oi;
    }

    @XO
    public static final <T> T oIX0oI(ThreadLocal<T> threadLocal, Oox.oIX0oI<? extends T> oix0oi) {
        IIX0o.x0xO0oo(threadLocal, "<this>");
        IIX0o.x0xO0oo(oix0oi, "default");
        T t = threadLocal.get();
        if (t == null) {
            T invoke = oix0oi.invoke();
            threadLocal.set(invoke);
            return invoke;
        }
        return t;
    }
}
