package kotlinx.coroutines.sync;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oOoXoXO;
import XO0OX.XO;
import XO0OX.o00;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.OI0;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.Oxx0xo;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.internal.X00IoxXI;
import kotlinx.coroutines.internal.x0o;
import kotlinx.coroutines.o0IXXIx;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.selects.II0XooXoX;
import kotlinx.coroutines.selects.Oxx0IOOO;
import kotlinx.coroutines.selects.xoIox;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
/* loaded from: classes6.dex */
public class MutexImpl extends SemaphoreImpl implements kotlinx.coroutines.sync.oIX0oI {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public static final AtomicReferenceFieldUpdater f30433xxIXOIIO = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final IXxxXO<xoIox<?>, Object, Object, oOoXoXO<Throwable, oXIO0o0XI>> f30434II0XooXoX;

    @OXOo.oOoXoXO
    @o00
    private volatile Object owner;

    @XX({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    /* loaded from: classes6.dex */
    public final class CancellableContinuationWithOwner implements oO<oXIO0o0XI>, o0IXXIx {

        /* renamed from: Oo, reason: collision with root package name */
        @XO
        @OXOo.oOoXoXO
        public final Object f30436Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        @XO
        public final x0xO0oo<oXIO0o0XI> f30437XO;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(@OOXIXo x0xO0oo<? super oXIO0o0XI> x0xo0oo, @OXOo.oOoXoXO Object obj) {
            this.f30437XO = x0xo0oo;
            this.f30436Oo = obj;
        }

        @Override // kotlinx.coroutines.oO
        /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
        public void OxxIIOOXO(@OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
            MutexImpl.f30433xxIXOIIO.set(MutexImpl.this, this.f30436Oo);
            x0xO0oo<oXIO0o0XI> x0xo0oo = this.f30437XO;
            final MutexImpl mutexImpl = MutexImpl.this;
            x0xo0oo.OxxIIOOXO(oxio0o0xi, new oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.this.xxIXOIIO(this.f30436Oo);
                }
            });
        }

        @Override // kotlinx.coroutines.oO
        @XI0oooXX
        public void II0XooXoX(@OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo Throwable th) {
            this.f30437XO.II0XooXoX(coroutineDispatcher, th);
        }

        @Override // kotlinx.coroutines.o0IXXIx
        public void II0xO0(@OOXIXo X00IoxXI<?> x00IoxXI, int i) {
            this.f30437XO.II0xO0(x00IoxXI, i);
        }

        @Override // kotlinx.coroutines.oO
        @OX00O0xII
        public void IO() {
            this.f30437XO.IO();
        }

        @Override // kotlinx.coroutines.oO
        @OX00O0xII
        @OXOo.oOoXoXO
        /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
        public Object xxX(@OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO Object obj) {
            return this.f30437XO.xxX(oxio0o0xi, obj);
        }

        @Override // kotlinx.coroutines.oO
        @OX00O0xII
        public void XIxXXX0x0(@OOXIXo Object obj) {
            this.f30437XO.XIxXXX0x0(obj);
        }

        @Override // kotlinx.coroutines.oO
        @OXOo.oOoXoXO
        /* renamed from: XO, reason: merged with bridge method [inline-methods] */
        public Object OI0(@OOXIXo oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object OI02 = this.f30437XO.OI0(oxio0o0xi, obj, new oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.f30433xxIXOIIO.set(MutexImpl.this, this.f30436Oo);
                    MutexImpl.this.xxIXOIIO(this.f30436Oo);
                }
            });
            if (OI02 != null) {
                MutexImpl.f30433xxIXOIIO.set(MutexImpl.this, this.f30436Oo);
            }
            return OI02;
        }

        @Override // kotlin.coroutines.I0Io
        @OOXIXo
        public CoroutineContext getContext() {
            return this.f30437XO.getContext();
        }

        @Override // kotlinx.coroutines.oO
        public boolean isActive() {
            return this.f30437XO.isActive();
        }

        @Override // kotlinx.coroutines.oO
        public boolean isCancelled() {
            return this.f30437XO.isCancelled();
        }

        @Override // kotlinx.coroutines.oO
        public boolean isCompleted() {
            return this.f30437XO.isCompleted();
        }

        @Override // kotlinx.coroutines.oO
        public boolean oIX0oI(@OXOo.oOoXoXO Throwable th) {
            return this.f30437XO.oIX0oI(th);
        }

        @Override // kotlinx.coroutines.oO
        @OX00O0xII
        @OXOo.oOoXoXO
        public Object oo0xXOI0I(@OOXIXo Throwable th) {
            return this.f30437XO.oo0xXOI0I(th);
        }

        @Override // kotlinx.coroutines.oO
        public void ooXIXxIX(@OOXIXo oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
            this.f30437XO.ooXIXxIX(oooxoxo);
        }

        @Override // kotlinx.coroutines.oO
        @XI0oooXX
        /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
        public void X00IoxXI(@OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo oXIO0o0XI oxio0o0xi) {
            this.f30437XO.X00IoxXI(coroutineDispatcher, oxio0o0xi);
        }

        @Override // kotlin.coroutines.I0Io
        public void resumeWith(@OOXIXo Object obj) {
            this.f30437XO.resumeWith(obj);
        }
    }

    @XX({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI<Q> implements kotlinx.coroutines.selects.OOXIXo<Q> {

        /* renamed from: Oo, reason: collision with root package name */
        @XO
        @OXOo.oOoXoXO
        public final Object f30439Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        @XO
        public final kotlinx.coroutines.selects.OOXIXo<Q> f30440XO;

        public oIX0oI(@OOXIXo kotlinx.coroutines.selects.OOXIXo<Q> oOXIXo, @OXOo.oOoXoXO Object obj) {
            this.f30440XO = oOXIXo;
            this.f30439Oo = obj;
        }

        @Override // kotlinx.coroutines.o0IXXIx
        public void II0xO0(@OOXIXo X00IoxXI<?> x00IoxXI, int i) {
            this.f30440XO.II0xO0(x00IoxXI, i);
        }

        @Override // kotlinx.coroutines.selects.xoIox
        public void Oxx0IOOO(@OOXIXo I0oOIX i0oOIX) {
            this.f30440XO.Oxx0IOOO(i0oOIX);
        }

        @Override // kotlinx.coroutines.selects.xoIox
        public void XO(@OXOo.oOoXoXO Object obj) {
            MutexImpl.f30433xxIXOIIO.set(MutexImpl.this, this.f30439Oo);
            this.f30440XO.XO(obj);
        }

        @Override // kotlinx.coroutines.selects.xoIox
        @OOXIXo
        public CoroutineContext getContext() {
            return this.f30440XO.getContext();
        }

        @Override // kotlinx.coroutines.selects.xoIox
        public boolean xxIXOIIO(@OOXIXo Object obj, @OXOo.oOoXoXO Object obj2) {
            boolean xxIXOIIO2 = this.f30440XO.xxIXOIIO(obj, obj2);
            MutexImpl mutexImpl = MutexImpl.this;
            if (xxIXOIIO2) {
                MutexImpl.f30433xxIXOIIO.set(mutexImpl, this.f30439Oo);
            }
            return xxIXOIIO2;
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        x0o x0oVar;
        if (!z) {
            x0oVar = MutexKt.f30447oIX0oI;
        } else {
            x0oVar = null;
        }
        this.owner = x0oVar;
        this.f30434II0XooXoX = new IXxxXO<xoIox<?>, Object, Object, oOoXoXO<? super Throwable, ? extends oXIO0o0XI>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            @OOXIXo
            public final oOoXoXO<Throwable, oXIO0o0XI> invoke(@OOXIXo xoIox<?> xoiox, @OXOo.oOoXoXO final Object obj, @OXOo.oOoXoXO Object obj2) {
                final MutexImpl mutexImpl = MutexImpl.this;
                return new oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        MutexImpl.this.xxIXOIIO(obj);
                    }
                };
            }
        };
    }

    public static /* synthetic */ Object O0xOxO(MutexImpl mutexImpl, Object obj, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (mutexImpl.X0o0xo(obj)) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        Object X0IIOO2 = mutexImpl.X0IIOO(obj, i0Io);
        if (X0IIOO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return X0IIOO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public static /* synthetic */ void o00() {
    }

    @Override // kotlinx.coroutines.sync.oIX0oI
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.oOoXoXO Object obj, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return O0xOxO(this, obj, i0Io);
    }

    public final int OxI(Object obj) {
        x0o x0oVar;
        while (oxoX()) {
            Object obj2 = f30433xxIXOIIO.get(this);
            x0oVar = MutexKt.f30447oIX0oI;
            if (obj2 != x0oVar) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    @Override // kotlinx.coroutines.sync.oIX0oI
    @OOXIXo
    public Oxx0IOOO<Object, kotlinx.coroutines.sync.oIX0oI> Oxx0IOOO() {
        MutexImpl$onLock$1 mutexImpl$onLock$1 = MutexImpl$onLock$1.INSTANCE;
        IIX0o.x0XOIxOo(mutexImpl$onLock$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        IXxxXO iXxxXO = (IXxxXO) XoX.Oo(mutexImpl$onLock$1, 3);
        MutexImpl$onLock$2 mutexImpl$onLock$2 = MutexImpl$onLock$2.INSTANCE;
        IIX0o.x0XOIxOo(mutexImpl$onLock$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new II0XooXoX(this, iXxxXO, (IXxxXO) XoX.Oo(mutexImpl$onLock$2, 3), this.f30434II0XooXoX);
    }

    public final Object X0IIOO(Object obj, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        x0xO0oo II0xO02 = Oxx0xo.II0xO0(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io));
        try {
            ooOOo0oXI(new CancellableContinuationWithOwner(II0xO02, obj));
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

    @Override // kotlinx.coroutines.sync.oIX0oI
    public boolean X0o0xo(@OXOo.oOoXoXO Object obj) {
        int xxX2 = xxX(obj);
        if (xxX2 == 0) {
            return true;
        }
        if (xxX2 != 1) {
            if (xxX2 != 2) {
                throw new IllegalStateException("unexpected");
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
        }
        return false;
    }

    @OXOo.oOoXoXO
    public Object XI0IXoo(@OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Object obj2) {
        x0o x0oVar;
        x0oVar = MutexKt.f30443II0xO0;
        if (!IIX0o.Oxx0IOOO(obj2, x0oVar)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void XIxXXX0x0(@OOXIXo xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        x0o x0oVar;
        if (obj != null && XO(obj)) {
            x0oVar = MutexKt.f30443II0xO0;
            xoiox.XO(x0oVar);
        } else {
            IIX0o.x0XOIxOo(xoiox, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            Oxx0xo(new oIX0oI((kotlinx.coroutines.selects.OOXIXo) xoiox, obj), obj);
        }
    }

    @Override // kotlinx.coroutines.sync.oIX0oI
    public boolean XO(@OOXIXo Object obj) {
        if (OxI(obj) == 1) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.oIX0oI
    public boolean oxoX() {
        if (II0xO0() == 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return "Mutex@" + OI0.II0xO0(this) + "[isLocked=" + oxoX() + ",owner=" + f30433xxIXOIIO.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.oIX0oI
    public void xxIXOIIO(@OXOo.oOoXoXO Object obj) {
        x0o x0oVar;
        x0o x0oVar2;
        while (oxoX()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30433xxIXOIIO;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            x0oVar = MutexKt.f30447oIX0oI;
            if (obj2 != x0oVar) {
                if (obj2 == obj || obj == null) {
                    x0oVar2 = MutexKt.f30447oIX0oI;
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj2, x0oVar2)) {
                        release();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final int xxX(Object obj) {
        while (!oIX0oI()) {
            if (obj == null) {
                return 1;
            }
            int OxI2 = OxI(obj);
            if (OxI2 == 1) {
                return 2;
            }
            if (OxI2 == 2) {
                return 1;
            }
        }
        f30433xxIXOIIO.set(this, obj);
        return 0;
    }
}
