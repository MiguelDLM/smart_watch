package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Xo0;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

@kotlin.jvm.internal.XX({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
/* loaded from: classes6.dex */
public final class xII {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final StackTraceElement f30315I0Io = new oIX0oI.oIX0oI().oIX0oI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30316II0xO0 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f30317X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30318oIX0oI = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f30319oxoX;

    static {
        Object m287constructorimpl;
        Object m287constructorimpl2;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
        }
        if (Result.m290exceptionOrNullimpl(m287constructorimpl) != null) {
            m287constructorimpl = f30318oIX0oI;
        }
        f30319oxoX = (String) m287constructorimpl;
        try {
            Result.oIX0oI oix0oi3 = Result.Companion;
            m287constructorimpl2 = Result.m287constructorimpl(xII.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.oIX0oI oix0oi4 = Result.Companion;
            m287constructorimpl2 = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th2));
        }
        if (Result.m290exceptionOrNullimpl(m287constructorimpl2) != null) {
            m287constructorimpl2 = f30316II0xO0;
        }
        f30317X0o0xo = (String) m287constructorimpl2;
    }

    public static final int II0XooXoX(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ void II0xO0() {
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public static final <E extends Throwable> E IXxxXO(@OXOo.OOXIXo E e) {
        return e;
    }

    public static final void OOXIXo(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (xoIox(stackTraceElementArr[i])) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 > length2) {
            return;
        }
        while (true) {
            if (Oxx0IOOO(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 != i2) {
                length2--;
            } else {
                return;
            }
        }
    }

    public static final <E extends Throwable> E Oo(E e) {
        int i;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(f30317X0o0xo, stackTrace[length2].getClassName())) {
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        length2 = -1;
        int i3 = length2 + 1;
        int II0XooXoX2 = II0XooXoX(stackTrace, f30319oxoX);
        if (II0XooXoX2 == -1) {
            i = 0;
        } else {
            i = length - II0XooXoX2;
        }
        int i4 = (length - length2) - i;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 == 0) {
                stackTraceElement = f30315I0Io;
            } else {
                stackTraceElement = stackTrace[(i3 + i5) - 1];
            }
            stackTraceElementArr[i5] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final boolean Oxx0IOOO(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.IIX0o.Oxx0IOOO(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(stackTraceElement.getClassName(), stackTraceElement2.getClassName())) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public static final <E extends Throwable> E Oxx0xo(@OXOo.OOXIXo E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && kotlin.jvm.internal.IIX0o.Oxx0IOOO(e2.getClass(), e.getClass())) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (xoIox(stackTraceElement)) {
                    return e2;
                }
            }
        }
        return e;
    }

    public static final <E extends Throwable> E X0o0xo(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(f30315I0Io);
        StackTraceElement[] stackTrace = e.getStackTrace();
        int II0XooXoX2 = II0XooXoX(stackTrace, f30319oxoX);
        int i = 0;
        if (II0XooXoX2 == -1) {
            e2.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + II0XooXoX2];
        for (int i2 = 0; i2 < II0XooXoX2; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i3 = i + 1;
            stackTraceElementArr[i + II0XooXoX2] = it.next();
            i = i3;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final ArrayDeque<StackTraceElement> XO(IXIxx0.I0Io i0Io) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = i0Io.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            i0Io = i0Io.getCallerFrame();
            if (i0Io == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = i0Io.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    public static /* synthetic */ void oIX0oI() {
    }

    @OXOo.OOXIXo
    public static final <E extends Throwable> E oO(@OXOo.OOXIXo E e) {
        return e;
    }

    public static final <E extends Throwable> Pair<E, StackTraceElement[]> oxoX(E e) {
        Throwable cause = e.getCause();
        if (cause != null && kotlin.jvm.internal.IIX0o.Oxx0IOOO(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (xoIox(stackTraceElement)) {
                    return Xo0.oIX0oI(cause, stackTrace);
                }
            }
            return Xo0.oIX0oI(e, new StackTraceElement[0]);
        }
        return Xo0.oIX0oI(e, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E x0XOIxOo(E e, IXIxx0.I0Io i0Io) {
        Pair oxoX2 = oxoX(e);
        Throwable th = (Throwable) oxoX2.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) oxoX2.component2();
        Throwable Oxx0IOOO2 = ExceptionsConstructorKt.Oxx0IOOO(th);
        if (Oxx0IOOO2 == null) {
            return e;
        }
        ArrayDeque<StackTraceElement> XO2 = XO(i0Io);
        if (XO2.isEmpty()) {
            return e;
        }
        if (th != e) {
            OOXIXo(stackTraceElementArr, XO2);
        }
        return (E) X0o0xo(th, Oxx0IOOO2, XO2);
    }

    @OXOo.OOXIXo
    public static final <E extends Throwable> E x0xO0oo(@OXOo.OOXIXo E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return e;
    }

    public static final boolean xoIox(@OXOo.OOXIXo StackTraceElement stackTraceElement) {
        return kotlin.text.OxI.IOOoXo0Ix(stackTraceElement.getClassName(), oIX0oI.II0xO0.I0Io(), false, 2, null);
    }

    public static final void xxIXOIIO(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo Throwable th2) {
        th.initCause(th2);
    }

    @OXOo.oOoXoXO
    public static final Object oOoXoXO(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        throw th;
    }

    public static final Object ooOOo0oXI(Throwable th, kotlin.coroutines.I0Io<?> i0Io) {
        throw th;
    }
}
