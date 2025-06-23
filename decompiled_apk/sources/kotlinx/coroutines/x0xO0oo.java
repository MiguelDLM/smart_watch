package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public class x0xO0oo<T> extends XX0<T> implements oO<T>, IXIxx0.I0Io, o0IXXIx {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<T> f30469Oxx0xo;

    @XO0OX.o00
    private volatile int _decisionAndIndex;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _parentHandle;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _state;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30470oI0IIXIo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30467OxxIIOOXO = AtomicIntegerFieldUpdater.newUpdater(x0xO0oo.class, "_decisionAndIndex");

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30466IIXOooo = AtomicReferenceFieldUpdater.newUpdater(x0xO0oo.class, Object.class, "_state");

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30468xoXoI = AtomicReferenceFieldUpdater.newUpdater(x0xO0oo.class, Object.class, "_parentHandle");

    /* JADX WARN: Multi-variable type inference failed */
    public x0xO0oo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, int i) {
        super(i);
        this.f30469Oxx0xo = i0Io;
        this.f30470oI0IIXIo = i0Io.getContext();
        this._decisionAndIndex = 536870911;
        this._state = oxoX.f30351XO;
    }

    private final boolean I0oOoX() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30467OxxIIOOXO;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f30467OxxIIOOXO.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XOxIOxOx(x0xO0oo x0xo0oo, Object obj, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                oooxoxo = null;
            }
            x0xo0oo.x0o(obj, i, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final boolean o0() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30467OxxIIOOXO;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f30467OxxIIOOXO.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    private final void xXxxox0I(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @Override // kotlinx.coroutines.oO
    public void II0XooXoX(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo Throwable th) {
        kotlinx.coroutines.internal.oOoXoXO oooxoxo;
        int i;
        kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (i0Io instanceof kotlinx.coroutines.internal.oOoXoXO) {
            oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) i0Io;
        } else {
            oooxoxo = null;
        }
        xxX xxx2 = new xxX(th, false, 2, null);
        if (oooxoxo != null) {
            coroutineDispatcher2 = oooxoxo.f30300Oxx0xo;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i = 4;
        } else {
            i = this.f29778IXxxXO;
        }
        XOxIOxOx(this, xxx2, i, null, 4, null);
    }

    @Override // kotlinx.coroutines.o0IXXIx
    public void II0xO0(@OXOo.OOXIXo kotlinx.coroutines.internal.X00IoxXI<?> x00IoxXI, int i) {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30467OxxIIOOXO;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        XI0IXoo(x00IoxXI);
    }

    public final void IIX0o(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @OXOo.OOXIXo
    public Throwable IIXOooo(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        return oxio0o0xi.xI();
    }

    @Override // kotlinx.coroutines.oO
    public void IO() {
        I0oOIX X0IIOO2 = X0IIOO();
        if (X0IIOO2 != null && isCompleted()) {
            X0IIOO2.dispose();
            f30468xoXoI.set(this, x0OIX00oO.f30462XO);
        }
    }

    public final void IXxxXO() {
        I0oOIX xoXoI2 = xoXoI();
        if (xoXoI2 == null) {
            return;
        }
        xoXoI2.dispose();
        f30468xoXoI.set(this, x0OIX00oO.f30462XO);
    }

    public final Object Io(XXoOx0 xXoOx0, Object obj, int i, Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, Object obj2) {
        ooOOo0oXI ooooo0oxi;
        if (!(obj instanceof xxX)) {
            if (I0X0x0oIo.I0Io(i) || obj2 != null) {
                if (oooxoxo != null || (xXoOx0 instanceof ooOOo0oXI) || obj2 != null) {
                    if (xXoOx0 instanceof ooOOo0oXI) {
                        ooooo0oxi = (ooOOo0oXI) xXoOx0;
                    } else {
                        ooooo0oxi = null;
                    }
                    return new XIxXXX0x0(obj, ooooo0oxi, oooxoxo, obj2, null, 16, null);
                }
                return obj;
            }
            return obj;
        }
        return obj;
    }

    @OXOo.OOXIXo
    public String IoOoX() {
        return "CancellableContinuation";
    }

    public final String O0xOxO() {
        Object OxI2 = OxI();
        if (OxI2 instanceof XXoOx0) {
            return "Active";
        }
        if (OxI2 instanceof oI0IIXIo) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    @Override // kotlinx.coroutines.oO
    @OXOo.oOoXoXO
    public Object OI0(T t, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        return XX(t, obj, oooxoxo);
    }

    public final Void OOXIXo(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final boolean Oo(Throwable th) {
        if (!XxX0x0xxx()) {
            return false;
        }
        kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.oOoXoXO) i0Io).IXxxXO(th);
    }

    @OXOo.oOoXoXO
    public final Object OxI() {
        return f30466IIXOooo.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.XX0
    public <T> T Oxx0IOOO(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof XIxXXX0x0) {
            return (T) ((XIxXXX0x0) obj).f29763oIX0oI;
        }
        return obj;
    }

    public final void Oxx0xo() {
        if (!XxX0x0xxx()) {
            IXxxXO();
        }
    }

    @Override // kotlinx.coroutines.oO
    public void OxxIIOOXO(T t, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        x0o(t, this.f29778IXxxXO, oooxoxo);
    }

    @Override // kotlinx.coroutines.oO
    public void X00IoxXI(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, T t) {
        kotlinx.coroutines.internal.oOoXoXO oooxoxo;
        int i;
        kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (i0Io instanceof kotlinx.coroutines.internal.oOoXoXO) {
            oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) i0Io;
        } else {
            oooxoxo = null;
        }
        if (oooxoxo != null) {
            coroutineDispatcher2 = oooxoxo.f30300Oxx0xo;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i = 4;
        } else {
            i = this.f29778IXxxXO;
        }
        XOxIOxOx(this, t, i, null, 4, null);
    }

    public final I0oOIX X0IIOO() {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) getContext().get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi == null) {
            return null;
        }
        I0oOIX Oxx0IOOO2 = oXIO0o0XI.oIX0oI.Oxx0IOOO(oxio0o0xi, true, false, new OxxIIOOXO(this), 2, null);
        androidx.concurrent.futures.oIX0oI.oIX0oI(f30468xoXoI, this, null, Oxx0IOOO2);
        return Oxx0IOOO2;
    }

    @Override // kotlinx.coroutines.XX0
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<T> X0o0xo() {
        return this.f30469Oxx0xo;
    }

    public final void XI0IXoo(Object obj) {
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof oxoX) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, obj)) {
                    return;
                }
            } else {
                if (obj2 instanceof ooOOo0oXI) {
                    z = true;
                } else {
                    z = obj2 instanceof kotlinx.coroutines.internal.X00IoxXI;
                }
                if (z) {
                    oo(obj, obj2);
                } else {
                    if (obj2 instanceof xxX) {
                        xxX xxx2 = (xxX) obj2;
                        if (!xxx2.II0xO0()) {
                            oo(obj, obj2);
                        }
                        if (obj2 instanceof oI0IIXIo) {
                            Throwable th = null;
                            if (!(obj2 instanceof xxX)) {
                                xxx2 = null;
                            }
                            if (xxx2 != null) {
                                th = xxx2.f30502oIX0oI;
                            }
                            if (obj instanceof ooOOo0oXI) {
                                ooOOo0oXI((ooOOo0oXI) obj, th);
                                return;
                            } else {
                                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                x0xO0oo((kotlinx.coroutines.internal.X00IoxXI) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof XIxXXX0x0) {
                        XIxXXX0x0 xIxXXX0x0 = (XIxXXX0x0) obj2;
                        if (xIxXXX0x0.f29761II0xO0 != null) {
                            oo(obj, obj2);
                        }
                        if (obj instanceof kotlinx.coroutines.internal.X00IoxXI) {
                            return;
                        }
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        ooOOo0oXI ooooo0oxi = (ooOOo0oXI) obj;
                        if (xIxXXX0x0.II0XooXoX()) {
                            ooOOo0oXI(ooooo0oxi, xIxXXX0x0.f29762X0o0xo);
                            return;
                        } else {
                            if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, XIxXXX0x0.Oxx0IOOO(xIxXXX0x0, null, ooooo0oxi, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof kotlinx.coroutines.internal.X00IoxXI) {
                            return;
                        }
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, new XIxXXX0x0(obj2, (ooOOo0oXI) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.oO
    public void XIxXXX0x0(@OXOo.OOXIXo Object obj) {
        oI0IIXIo(this.f29778IXxxXO);
    }

    @Override // kotlinx.coroutines.XX0
    @OXOo.oOoXoXO
    public Throwable XO(@OXOo.oOoXoXO Object obj) {
        Throwable XO2 = super.XO(obj);
        if (XO2 == null) {
            return null;
        }
        return XO2;
    }

    public final kotlinx.coroutines.internal.x0o XX(Object obj, Object obj2, Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof XXoOx0) {
            } else {
                if (!(obj3 instanceof XIxXXX0x0) || obj2 == null || ((XIxXXX0x0) obj3).f29764oxoX != obj2) {
                    return null;
                }
                return IXxxXO.f29701Oxx0IOOO;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj3, Io((XXoOx0) obj3, obj, this.f29778IXxxXO, oooxoxo, obj2)));
        Oxx0xo();
        return IXxxXO.f29701Oxx0IOOO;
    }

    public final void Xx000oIo() {
        kotlinx.coroutines.internal.oOoXoXO oooxoxo;
        Throwable o002;
        kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
        if (i0Io instanceof kotlinx.coroutines.internal.oOoXoXO) {
            oooxoxo = (kotlinx.coroutines.internal.oOoXoXO) i0Io;
        } else {
            oooxoxo = null;
        }
        if (oooxoxo != null && (o002 = oooxoxo.o00(this)) != null) {
            IXxxXO();
            oIX0oI(o002);
        }
    }

    public final boolean XxX0x0xxx() {
        if (I0X0x0oIo.oxoX(this.f29778IXxxXO)) {
            kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
            kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((kotlinx.coroutines.internal.oOoXoXO) i0Io).x0xO0oo()) {
                return true;
            }
        }
        return false;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        kotlin.coroutines.I0Io<T> i0Io = this.f30469Oxx0xo;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return this.f30470oI0IIXIo;
    }

    @Override // IXIxx0.I0Io
    @OXOo.oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.oO
    public boolean isActive() {
        return OxI() instanceof XXoOx0;
    }

    @Override // kotlinx.coroutines.oO
    public boolean isCancelled() {
        return OxI() instanceof oI0IIXIo;
    }

    @Override // kotlinx.coroutines.oO
    public boolean isCompleted() {
        return !(OxI() instanceof XXoOx0);
    }

    @kotlin.o0
    @OXOo.oOoXoXO
    public final Object o00() {
        oXIO0o0XI oxio0o0xi;
        boolean XxX0x0xxx2 = XxX0x0xxx();
        if (I0oOoX()) {
            if (xoXoI() == null) {
                X0IIOO();
            }
            if (XxX0x0xxx2) {
                Xx000oIo();
            }
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (XxX0x0xxx2) {
            Xx000oIo();
        }
        Object OxI2 = OxI();
        if (!(OxI2 instanceof xxX)) {
            if (I0X0x0oIo.I0Io(this.f29778IXxxXO) && (oxio0o0xi = (oXIO0o0XI) getContext().get(oXIO0o0XI.f30343xxIXOIIO)) != null && !oxio0o0xi.isActive()) {
                CancellationException xI2 = oxio0o0xi.xI();
                oxoX(OxI2, xI2);
                throw xI2;
            }
            return Oxx0IOOO(OxI2);
        }
        throw ((xxX) OxI2).f30502oIX0oI;
    }

    public final void oI0IIXIo(int i) {
        if (o0()) {
            return;
        }
        I0X0x0oIo.oIX0oI(this, i);
    }

    @Override // kotlinx.coroutines.oO
    public boolean oIX0oI(@OXOo.oOoXoXO Throwable th) {
        Object obj;
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (!(obj instanceof XXoOx0)) {
                return false;
            }
            if ((obj instanceof ooOOo0oXI) || (obj instanceof kotlinx.coroutines.internal.X00IoxXI)) {
                z = true;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj, new oI0IIXIo(this, th, z)));
        XXoOx0 xXoOx0 = (XXoOx0) obj;
        if (xXoOx0 instanceof ooOOo0oXI) {
            ooOOo0oXI((ooOOo0oXI) obj, th);
        } else if (xXoOx0 instanceof kotlinx.coroutines.internal.X00IoxXI) {
            x0xO0oo((kotlinx.coroutines.internal.X00IoxXI) obj, th);
        }
        Oxx0xo();
        oI0IIXIo(this.f29778IXxxXO);
        return true;
    }

    public final void oO(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, @OXOo.OOXIXo Throwable th) {
        try {
            oooxoxo.invoke(th);
        } catch (Throwable th2) {
            Xx000oIo.II0xO0(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void oOXoIIIo(@OXOo.OOXIXo Throwable th) {
        if (Oo(th)) {
            return;
        }
        oIX0oI(th);
        Oxx0xo();
    }

    public final void oOoXoXO(Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, Throwable th) {
        try {
            oooxoxo.invoke(th);
        } catch (Throwable th2) {
            Xx000oIo.II0xO0(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void oo(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    @Override // kotlinx.coroutines.oO
    @OXOo.oOoXoXO
    public Object oo0xXOI0I(@OXOo.OOXIXo Throwable th) {
        return XX(new xxX(th, false, 2, null), null, null);
    }

    public final void ooOOo0oXI(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi, @OXOo.oOoXoXO Throwable th) {
        try {
            ooooo0oxi.xoIox(th);
        } catch (Throwable th2) {
            Xx000oIo.II0xO0(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.oO
    public void ooXIXxIX(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        XI0IXoo(xI(oooxoxo));
    }

    @Override // kotlinx.coroutines.XX0
    public void oxoX(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof XXoOx0)) {
                if (obj2 instanceof xxX) {
                    return;
                }
                if (obj2 instanceof XIxXXX0x0) {
                    XIxXXX0x0 xIxXXX0x0 = (XIxXXX0x0) obj2;
                    if (!xIxXXX0x0.II0XooXoX()) {
                        if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, XIxXXX0x0.Oxx0IOOO(xIxXXX0x0, null, null, null, null, th, 15, null))) {
                            xIxXXX0x0.xxIXOIIO(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once");
                    }
                } else if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, new XIxXXX0x0(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed");
            }
        }
    }

    public final void oxxXoxO(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, Integer> oooxoxo, Object obj) {
        int i;
        do {
            i = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, oooxoxo.invoke(Integer.valueOf(i)).intValue()));
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OXOo.OOXIXo Object obj) {
        XOxIOxOx(this, xI.I0Io(obj, this), this.f29778IXxxXO, null, 4, null);
    }

    @OXOo.OOXIXo
    public String toString() {
        return IoOoX() + HexStringBuilder.COMMENT_BEGIN_CHAR + OI0.I0Io(this.f30469Oxx0xo) + "){" + O0xOxO() + "}@" + OI0.II0xO0(this);
    }

    public final void x0XOIxOo(Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        try {
            oix0oi.invoke();
        } catch (Throwable th) {
            Xx000oIo.II0xO0(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    public final void x0o(Object obj, int i, Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof XXoOx0) {
            } else {
                if (obj2 instanceof oI0IIXIo) {
                    oI0IIXIo oi0iixio = (oI0IIXIo) obj2;
                    if (oi0iixio.I0Io()) {
                        if (oooxoxo != null) {
                            oO(oooxoxo, oi0iixio.f30502oIX0oI);
                            return;
                        }
                        return;
                    }
                }
                OOXIXo(obj);
                throw new KotlinNothingValueException();
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30466IIXOooo, this, obj2, Io((XXoOx0) obj2, obj, i, oooxoxo, null)));
        Oxx0xo();
        oI0IIXIo(i);
    }

    public final void x0xO0oo(kotlinx.coroutines.internal.X00IoxXI<?> x00IoxXI, Throwable th) {
        int i = f30467OxxIIOOXO.get(this) & 536870911;
        if (i != 536870911) {
            try {
                x00IoxXI.Oo(i, th, getContext());
                return;
            } catch (Throwable th2) {
                Xx000oIo.II0xO0(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
                return;
            }
        }
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final ooOOo0oXI xI(Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        if (oooxoxo instanceof ooOOo0oXI) {
            return (ooOOo0oXI) oooxoxo;
        }
        return new xX0IIXIx0(oooxoxo);
    }

    @XO0OX.xxIXOIIO(name = "resetStateReusable")
    public final boolean xII() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30466IIXOooo;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof XIxXXX0x0) && ((XIxXXX0x0) obj).f29764oxoX != null) {
            IXxxXO();
            return false;
        }
        f30467OxxIIOOXO.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, oxoX.f30351XO);
        return true;
    }

    @Override // kotlinx.coroutines.XX0
    @OXOo.oOoXoXO
    public Object xoIox() {
        return OxI();
    }

    public final I0oOIX xoXoI() {
        return (I0oOIX) f30468xoXoI.get(this);
    }

    @Override // kotlinx.coroutines.oO
    @OXOo.oOoXoXO
    public Object xxX(T t, @OXOo.oOoXoXO Object obj) {
        return XX(t, obj, null);
    }
}
