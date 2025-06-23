package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.IO0XoXxO;
import kotlinx.coroutines.Oxx;
import kotlinx.coroutines.x0xO;

@kotlin.jvm.internal.XX({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public final class oOoXoXO<T> extends kotlinx.coroutines.XX0<T> implements IXIxx0.I0Io, kotlin.coroutines.I0Io<T> {

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30298xoXoI = AtomicReferenceFieldUpdater.newUpdater(oOoXoXO.class, Object.class, "_reusableCancellableContinuation");

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Object f30299IIXOooo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final CoroutineDispatcher f30300Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public Object f30301OxxIIOOXO;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final kotlin.coroutines.I0Io<T> f30302oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public oOoXoXO(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        super(-1);
        this.f30300Oxx0xo = coroutineDispatcher;
        this.f30302oI0IIXIo = i0Io;
        this.f30301OxxIIOOXO = ooOOo0oXI.oIX0oI();
        this.f30299IIXOooo = ThreadContextKt.II0xO0(getContext());
    }

    private final void Oo(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static /* synthetic */ void oO() {
    }

    public final boolean IIXOooo(@OXOo.oOoXoXO Object obj) {
        kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) getContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null && !oxio0o0xi.isActive()) {
            CancellationException xI2 = oxio0o0xi.xI();
            oxoX(obj, xI2);
            Result.oIX0oI oix0oi = Result.Companion;
            resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(xI2)));
            return true;
        }
        return false;
    }

    public final boolean IXxxXO(@OXOo.OOXIXo Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30298xoXoI;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            x0o x0oVar = ooOOo0oXI.f30303II0xO0;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, x0oVar)) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30298xoXoI, this, x0oVar, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30298xoXoI, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void OOXIXo() {
        do {
        } while (f30298xoXoI.get(this) == ooOOo0oXI.f30303II0xO0);
    }

    public final void Oxx0xo() {
        OOXIXo();
        kotlinx.coroutines.x0xO0oo<?> x0XOIxOo2 = x0XOIxOo();
        if (x0XOIxOo2 != null) {
            x0XOIxOo2.IXxxXO();
        }
    }

    @Override // kotlinx.coroutines.XX0
    @OXOo.OOXIXo
    public kotlin.coroutines.I0Io<T> X0o0xo() {
        return this;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        kotlin.coroutines.I0Io<T> i0Io = this.f30302oI0IIXIo;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return this.f30302oI0IIXIo.getContext();
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @OXOo.oOoXoXO
    public final Throwable o00(@OXOo.OOXIXo kotlinx.coroutines.oO<?> oOVar) {
        x0o x0oVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30298xoXoI;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            x0oVar = ooOOo0oXI.f30303II0xO0;
            if (obj != x0oVar) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30298xoXoI, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30298xoXoI, this, x0oVar, oOVar));
        return null;
    }

    public final void oI0IIXIo(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        Oxx<?> oxx;
        Object II0xO02 = kotlinx.coroutines.xI.II0xO0(obj, oooxoxo);
        if (this.f30300Oxx0xo.isDispatchNeeded(getContext())) {
            this.f30301OxxIIOOXO = II0xO02;
            this.f29778IXxxXO = 1;
            this.f30300Oxx0xo.dispatch(getContext(), this);
            return;
        }
        x0xO II0xO03 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (II0xO03.oo0xXOI0I()) {
            this.f30301OxxIIOOXO = II0xO02;
            this.f29778IXxxXO = 1;
            II0xO03.X0IIOO(this);
            return;
        }
        II0xO03.xxX(true);
        try {
            kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) getContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO);
            if (oxio0o0xi != null && !oxio0o0xi.isActive()) {
                CancellationException xI2 = oxio0o0xi.xI();
                oxoX(II0xO02, xI2);
                Result.oIX0oI oix0oi = Result.Companion;
                resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(xI2)));
            } else {
                kotlin.coroutines.I0Io<T> i0Io = this.f30302oI0IIXIo;
                Object obj2 = this.f30299IIXOooo;
                CoroutineContext context = i0Io.getContext();
                Object I0Io2 = ThreadContextKt.I0Io(context, obj2);
                if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
                    oxx = CoroutineContextKt.Oxx0IOOO(i0Io, context, I0Io2);
                } else {
                    oxx = null;
                }
                try {
                    this.f30302oI0IIXIo.resumeWith(obj);
                    oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                } finally {
                    kotlin.jvm.internal.xxX.oxoX(1);
                    if (oxx == null || oxx.OooI()) {
                        ThreadContextKt.oIX0oI(context, I0Io2);
                    }
                    kotlin.jvm.internal.xxX.I0Io(1);
                }
            }
            do {
            } while (II0xO03.IO());
            kotlin.jvm.internal.xxX.oxoX(1);
        } catch (Throwable th) {
            try {
                xxIXOIIO(th, null);
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                II0xO03.IIXOooo(true);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
        II0xO03.IIXOooo(true);
        kotlin.jvm.internal.xxX.I0Io(1);
    }

    @OXOo.oOoXoXO
    public final kotlinx.coroutines.x0xO0oo<T> oOoXoXO() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30298xoXoI;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f30298xoXoI.set(this, ooOOo0oXI.f30303II0xO0);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.x0xO0oo) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30298xoXoI, this, obj, ooOOo0oXI.f30303II0xO0)) {
                    return (kotlinx.coroutines.x0xO0oo) obj;
                }
            } else if (obj != ooOOo0oXI.f30303II0xO0 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void ooOOo0oXI(@OXOo.OOXIXo CoroutineContext coroutineContext, T t) {
        this.f30301OxxIIOOXO = t;
        this.f29778IXxxXO = 1;
        this.f30300Oxx0xo.dispatchYield(coroutineContext, this);
    }

    @Override // kotlinx.coroutines.XX0
    public void oxoX(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Throwable th) {
        if (obj instanceof kotlinx.coroutines.XxX0x0xxx) {
            ((kotlinx.coroutines.XxX0x0xxx) obj).f29788II0xO0.invoke(th);
        }
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OXOo.OOXIXo Object obj) {
        CoroutineContext context = this.f30302oI0IIXIo.getContext();
        Object oxoX2 = kotlinx.coroutines.xI.oxoX(obj, null, 1, null);
        if (this.f30300Oxx0xo.isDispatchNeeded(context)) {
            this.f30301OxxIIOOXO = oxoX2;
            this.f29778IXxxXO = 0;
            this.f30300Oxx0xo.dispatch(context, this);
            return;
        }
        x0xO II0xO02 = IO0XoXxO.f29694oIX0oI.II0xO0();
        if (II0xO02.oo0xXOI0I()) {
            this.f30301OxxIIOOXO = oxoX2;
            this.f29778IXxxXO = 0;
            II0xO02.X0IIOO(this);
            return;
        }
        II0xO02.xxX(true);
        try {
            CoroutineContext context2 = getContext();
            Object I0Io2 = ThreadContextKt.I0Io(context2, this.f30299IIXOooo);
            try {
                this.f30302oI0IIXIo.resumeWith(obj);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                do {
                } while (II0xO02.IO());
            } finally {
                ThreadContextKt.oIX0oI(context2, I0Io2);
            }
        } catch (Throwable th) {
            try {
                xxIXOIIO(th, null);
            } finally {
                II0xO02.IIXOooo(true);
            }
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        return "DispatchedContinuation[" + this.f30300Oxx0xo + ", " + kotlinx.coroutines.OI0.I0Io(this.f30302oI0IIXIo) + ']';
    }

    public final kotlinx.coroutines.x0xO0oo<?> x0XOIxOo() {
        Object obj = f30298xoXoI.get(this);
        if (obj instanceof kotlinx.coroutines.x0xO0oo) {
            return (kotlinx.coroutines.x0xO0oo) obj;
        }
        return null;
    }

    public final boolean x0xO0oo() {
        if (f30298xoXoI.get(this) != null) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.XX0
    @OXOo.oOoXoXO
    public Object xoIox() {
        Object obj = this.f30301OxxIIOOXO;
        this.f30301OxxIIOOXO = ooOOo0oXI.oIX0oI();
        return obj;
    }

    public final void xoXoI(@OXOo.OOXIXo Object obj) {
        Oxx<?> oxx;
        kotlin.coroutines.I0Io<T> i0Io = this.f30302oI0IIXIo;
        Object obj2 = this.f30299IIXOooo;
        CoroutineContext context = i0Io.getContext();
        Object I0Io2 = ThreadContextKt.I0Io(context, obj2);
        if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
            oxx = CoroutineContextKt.Oxx0IOOO(i0Io, context, I0Io2);
        } else {
            oxx = null;
        }
        try {
            this.f30302oI0IIXIo.resumeWith(obj);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } finally {
            kotlin.jvm.internal.xxX.oxoX(1);
            if (oxx == null || oxx.OooI()) {
                ThreadContextKt.oIX0oI(context, I0Io2);
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        }
    }
}
