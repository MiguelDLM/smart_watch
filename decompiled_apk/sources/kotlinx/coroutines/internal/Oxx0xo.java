package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.XI0oooXX;

@kotlin.jvm.internal.XX({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
/* loaded from: classes6.dex */
public final class Oxx0xo extends CoroutineDispatcher implements kotlinx.coroutines.XoX {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30263OxxIIOOXO = AtomicIntegerFieldUpdater.newUpdater(Oxx0xo.class, "runningWorkers");

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.XoX f30264IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f30265Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final OxI<Runnable> f30266Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineDispatcher f30267XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object f30268oI0IIXIo;

    @XO0OX.o00
    private volatile int runningWorkers;

    /* loaded from: classes6.dex */
    public final class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public Runnable f30270XO;

        public oIX0oI(@OXOo.OOXIXo Runnable runnable) {
            this.f30270XO = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.f30270XO.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.Xx000oIo.II0xO0(EmptyCoroutineContext.INSTANCE, th);
                }
                Runnable X0IIOO2 = Oxx0xo.this.X0IIOO();
                if (X0IIOO2 == null) {
                    return;
                }
                this.f30270XO = X0IIOO2;
                i++;
                if (i >= 16 && Oxx0xo.this.f30267XO.isDispatchNeeded(Oxx0xo.this)) {
                    Oxx0xo.this.f30267XO.dispatch(Oxx0xo.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0xo(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, int i) {
        kotlinx.coroutines.XoX xoX2;
        this.f30267XO = coroutineDispatcher;
        this.f30265Oo = i;
        if (coroutineDispatcher instanceof kotlinx.coroutines.XoX) {
            xoX2 = (kotlinx.coroutines.XoX) coroutineDispatcher;
        } else {
            xoX2 = null;
        }
        this.f30264IXxxXO = xoX2 == null ? kotlinx.coroutines.XX.oIX0oI() : xoX2;
        this.f30266Oxx0xo = new OxI<>(false);
        this.f30268oI0IIXIo = new Object();
    }

    @Override // kotlinx.coroutines.XoX
    public void OOXIXo(long j, @OXOo.OOXIXo kotlinx.coroutines.oO<? super oXIO0o0XI> oOVar) {
        this.f30264IXxxXO.OOXIXo(j, oOVar);
    }

    @Override // kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    public I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return this.f30264IXxxXO.Oxx0xo(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.XoX
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @OXOo.oOoXoXO
    public Object OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return this.f30264IXxxXO.OxxIIOOXO(j, i0Io);
    }

    public final Runnable X0IIOO() {
        while (true) {
            Runnable II0XooXoX2 = this.f30266Oxx0xo.II0XooXoX();
            if (II0XooXoX2 == null) {
                synchronized (this.f30268oI0IIXIo) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30263OxxIIOOXO;
                    atomicIntegerFieldUpdater.decrementAndGet(this);
                    if (this.f30266Oxx0xo.I0Io() == 0) {
                        return null;
                    }
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                }
            } else {
                return II0XooXoX2;
            }
        }
    }

    public final boolean XIxXXX0x0() {
        synchronized (this.f30268oI0IIXIo) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30263OxxIIOOXO;
            if (atomicIntegerFieldUpdater.get(this) >= this.f30265Oo) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        Runnable X0IIOO2;
        this.f30266Oxx0xo.oIX0oI(runnable);
        if (f30263OxxIIOOXO.get(this) < this.f30265Oo && XIxXXX0x0() && (X0IIOO2 = X0IIOO()) != null) {
            this.f30267XO.dispatch(this, new oIX0oI(X0IIOO2));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OX00O0xII
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        Runnable X0IIOO2;
        this.f30266Oxx0xo.oIX0oI(runnable);
        if (f30263OxxIIOOXO.get(this) < this.f30265Oo && XIxXXX0x0() && (X0IIOO2 = X0IIOO()) != null) {
            this.f30267XO.dispatchYield(this, new oIX0oI(X0IIOO2));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        oI0IIXIo.oIX0oI(i);
        if (i >= this.f30265Oo) {
            return this;
        }
        return super.limitedParallelism(i);
    }

    public final void o00(Runnable runnable, Oox.oOoXoXO<? super oIX0oI, oXIO0o0XI> oooxoxo) {
        Runnable X0IIOO2;
        this.f30266Oxx0xo.oIX0oI(runnable);
        if (f30263OxxIIOOXO.get(this) >= this.f30265Oo || !XIxXXX0x0() || (X0IIOO2 = X0IIOO()) == null) {
            return;
        }
        oooxoxo.invoke(new oIX0oI(X0IIOO2));
    }
}
