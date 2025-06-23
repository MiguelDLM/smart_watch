package kotlinx.coroutines.sync;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.o00;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.util.concurrent.oxoX;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.Oxx0xo;
import kotlinx.coroutines.internal.IO;
import kotlinx.coroutines.internal.X00IoxXI;
import kotlinx.coroutines.internal.XO;
import kotlinx.coroutines.internal.x0o;
import kotlinx.coroutines.o0IXXIx;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.selects.xoIox;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
/* loaded from: classes6.dex */
public class SemaphoreImpl implements II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final oOoXoXO<Throwable, oXIO0o0XI> f30454II0xO0;

    @o00
    private volatile int _availablePermits;

    @o00
    private volatile long deqIdx;

    @o00
    private volatile long enqIdx;

    @OXOo.oOoXoXO
    @o00
    private volatile Object head;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f30455oIX0oI;

    @OXOo.oOoXoXO
    @o00
    private volatile Object tail;

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final AtomicReferenceFieldUpdater f30449I0Io = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, TtmlNode.TAG_HEAD);

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final AtomicLongFieldUpdater f30453oxoX = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public static final AtomicReferenceFieldUpdater f30451X0o0xo = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public static final AtomicLongFieldUpdater f30452XO = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public static final AtomicIntegerFieldUpdater f30450Oxx0IOOO = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i2) {
        this.f30455oIX0oI = i;
        if (i > 0) {
            if (i2 >= 0 && i2 <= i) {
                I0Io i0Io = new I0Io(0L, null, 2);
                this.head = i0Io;
                this.tail = i0Io;
                this._availablePermits = i - i2;
                this.f30454II0xO0 = new oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                        invoke2(th);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo Throwable th) {
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
    }

    public static /* synthetic */ Object x0XOIxOo(SemaphoreImpl semaphoreImpl, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (semaphoreImpl.IXxxXO() > 0) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        Object oO2 = semaphoreImpl.oO(i0Io);
        if (oO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.sync.II0xO0
    @OXOo.oOoXoXO
    public Object I0Io(@OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return x0XOIxOo(this, i0Io);
    }

    @Override // kotlinx.coroutines.sync.II0xO0
    public int II0xO0() {
        return Math.max(f30450Oxx0IOOO.get(this), 0);
    }

    public final int IXxxXO() {
        int andDecrement;
        do {
            andDecrement = f30450Oxx0IOOO.getAndDecrement(this);
        } while (andDecrement > this.f30455oIX0oI);
        return andDecrement;
    }

    public final void Oo() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        int i2;
        do {
            atomicIntegerFieldUpdater = f30450Oxx0IOOO;
            i = atomicIntegerFieldUpdater.get(this);
            i2 = this.f30455oIX0oI;
            if (i <= i2) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i2));
    }

    public final void Oxx0xo(@OOXIXo xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        while (IXxxXO() <= 0) {
            IIX0o.x0XOIxOo(xoiox, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (x0xO0oo((o0IXXIx) xoiox)) {
                return;
            }
        }
        xoiox.XO(oXIO0o0XI.f29392oIX0oI);
    }

    public final boolean OxxIIOOXO() {
        int i;
        Object Oxx0IOOO2;
        int i2;
        x0o x0oVar;
        x0o x0oVar2;
        int i3;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30449I0Io;
        I0Io i0Io = (I0Io) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f30453oxoX.getAndIncrement(this);
        i = SemaphoreKt.f30459XO;
        long j = andIncrement / i;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        loop0: while (true) {
            Oxx0IOOO2 = XO.Oxx0IOOO(i0Io, j, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (IO.II0XooXoX(Oxx0IOOO2)) {
                break;
            }
            X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
            while (true) {
                X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(this);
                if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                    break loop0;
                }
                if (!XO2.Oxx0xo()) {
                    break;
                }
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x00IoxXI, XO2)) {
                    if (x00IoxXI.oO()) {
                        x00IoxXI.oOoXoXO();
                    }
                } else if (XO2.oO()) {
                    XO2.oOoXoXO();
                }
            }
        }
        I0Io i0Io2 = (I0Io) IO.XO(Oxx0IOOO2);
        i0Io2.II0xO0();
        if (i0Io2.f30276IXxxXO <= j) {
            i2 = SemaphoreKt.f30459XO;
            int i4 = (int) (andIncrement % i2);
            x0oVar = SemaphoreKt.f30457II0xO0;
            Object andSet = i0Io2.IIXOooo().getAndSet(i4, x0oVar);
            if (andSet == null) {
                i3 = SemaphoreKt.f30460oIX0oI;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = i0Io2.IIXOooo().get(i4);
                    x0oVar5 = SemaphoreKt.f30456I0Io;
                    if (obj == x0oVar5) {
                        return true;
                    }
                }
                x0oVar3 = SemaphoreKt.f30457II0xO0;
                x0oVar4 = SemaphoreKt.f30461oxoX;
                return !oxoX.oIX0oI(i0Io2.IIXOooo(), i4, x0oVar3, x0oVar4);
            }
            x0oVar2 = SemaphoreKt.f30458X0o0xo;
            if (andSet == x0oVar2) {
                return false;
            }
            return oI0IIXIo(andSet);
        }
        return false;
    }

    public final boolean oI0IIXIo(Object obj) {
        if (obj instanceof oO) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            oO oOVar = (oO) obj;
            Object OI02 = oOVar.OI0(oXIO0o0XI.f29392oIX0oI, null, this.f30454II0xO0);
            if (OI02 != null) {
                oOVar.XIxXXX0x0(OI02);
                return true;
            }
            return false;
        }
        if (obj instanceof xoIox) {
            return ((xoIox) obj).xxIXOIIO(this, oXIO0o0XI.f29392oIX0oI);
        }
        throw new IllegalStateException(("unexpected: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.II0xO0
    public boolean oIX0oI() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30450Oxx0IOOO;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i > this.f30455oIX0oI) {
                Oo();
            } else {
                if (i <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }

    public final Object oO(kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        x0xO0oo II0xO02 = Oxx0xo.II0xO0(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io));
        try {
            if (!x0xO0oo(II0xO02)) {
                ooOOo0oXI(II0xO02);
            }
            Object o002 = II0xO02.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return o002;
            }
            return oXIO0o0XI.f29392oIX0oI;
        } catch (Throwable th) {
            II0xO02.Xx000oIo();
            throw th;
        }
    }

    public final <W> void oOoXoXO(W w, oOoXoXO<? super W, Boolean> oooxoxo, oOoXoXO<? super W, oXIO0o0XI> oooxoxo2) {
        while (IXxxXO() <= 0) {
            if (oooxoxo.invoke(w).booleanValue()) {
                return;
            }
        }
        oooxoxo2.invoke(w);
    }

    public final void ooOOo0oXI(@OOXIXo oO<? super oXIO0o0XI> oOVar) {
        while (IXxxXO() <= 0) {
            IIX0o.x0XOIxOo(oOVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (x0xO0oo((o0IXXIx) oOVar)) {
                return;
            }
        }
        oOVar.OxxIIOOXO(oXIO0o0XI.f29392oIX0oI, this.f30454II0xO0);
    }

    @Override // kotlinx.coroutines.sync.II0xO0
    public void release() {
        do {
            int andIncrement = f30450Oxx0IOOO.getAndIncrement(this);
            if (andIncrement < this.f30455oIX0oI) {
                if (andIncrement >= 0) {
                    return;
                }
            } else {
                Oo();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f30455oIX0oI).toString());
            }
        } while (!OxxIIOOXO());
    }

    public final boolean x0xO0oo(o0IXXIx o0ixxix) {
        int i;
        Object Oxx0IOOO2;
        int i2;
        x0o x0oVar;
        x0o x0oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30451X0o0xo;
        I0Io i0Io = (I0Io) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f30452XO.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        i = SemaphoreKt.f30459XO;
        long j = andIncrement / i;
        loop0: while (true) {
            Oxx0IOOO2 = XO.Oxx0IOOO(i0Io, j, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(this);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        I0Io i0Io2 = (I0Io) IO.XO(Oxx0IOOO2);
        i2 = SemaphoreKt.f30459XO;
        int i3 = (int) (andIncrement % i2);
        if (!oxoX.oIX0oI(i0Io2.IIXOooo(), i3, null, o0ixxix)) {
            x0oVar = SemaphoreKt.f30457II0xO0;
            x0oVar2 = SemaphoreKt.f30456I0Io;
            if (oxoX.oIX0oI(i0Io2.IIXOooo(), i3, x0oVar, x0oVar2)) {
                if (o0ixxix instanceof oO) {
                    IIX0o.x0XOIxOo(o0ixxix, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((oO) o0ixxix).OxxIIOOXO(oXIO0o0XI.f29392oIX0oI, this.f30454II0xO0);
                } else if (o0ixxix instanceof xoIox) {
                    ((xoIox) o0ixxix).XO(oXIO0o0XI.f29392oIX0oI);
                } else {
                    throw new IllegalStateException(("unexpected: " + o0ixxix).toString());
                }
                return true;
            }
            return false;
        }
        o0ixxix.II0xO0(i0Io2, i3);
        return true;
    }
}
