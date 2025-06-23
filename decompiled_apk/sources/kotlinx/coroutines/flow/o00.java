package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
/* loaded from: classes6.dex */
public final class o00 extends kotlinx.coroutines.flow.internal.I0Io<StateFlowImpl<?>> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30204oIX0oI = AtomicReferenceFieldUpdater.newUpdater(o00.class, Object.class, "_state");

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _state;

    public final void II0XooXoX() {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30204oIX0oI;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                x0oVar = xoXoI.f30212II0xO0;
                if (obj != x0oVar) {
                    x0oVar2 = xoXoI.f30213oIX0oI;
                    if (obj == x0oVar2) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f30204oIX0oI;
                        x0oVar3 = xoXoI.f30212II0xO0;
                        if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater2, this, obj, x0oVar3)) {
                            return;
                        }
                    } else {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f30204oIX0oI;
                        x0oVar4 = xoXoI.f30213oIX0oI;
                        if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater3, this, obj, x0oVar4)) {
                            Result.oIX0oI oix0oi = Result.Companion;
                            ((kotlinx.coroutines.x0xO0oo) obj).resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void Oxx0IOOO(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @OXOo.oOoXoXO
    public final Object X0o0xo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        x0o x0oVar;
        kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30204oIX0oI;
        x0oVar = xoXoI.f30213oIX0oI;
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x0oVar, x0xo0oo)) {
            Result.oIX0oI oix0oi = Result.Companion;
            x0xo0oo.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.I0Io<oXIO0o0XI>[] II0xO0(@OXOo.OOXIXo StateFlowImpl<?> stateFlowImpl) {
        f30204oIX0oI.set(this, null);
        return kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.I0Io
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public boolean oIX0oI(@OXOo.OOXIXo StateFlowImpl<?> stateFlowImpl) {
        x0o x0oVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30204oIX0oI;
        if (atomicReferenceFieldUpdater.get(this) == null) {
            x0oVar = xoXoI.f30213oIX0oI;
            atomicReferenceFieldUpdater.set(this, x0oVar);
            return true;
        }
        return false;
    }

    public final boolean xxIXOIIO() {
        x0o x0oVar;
        x0o x0oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30204oIX0oI;
        x0oVar = xoXoI.f30213oIX0oI;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, x0oVar);
        IIX0o.ooOOo0oXI(andSet);
        x0oVar2 = xoXoI.f30212II0xO0;
        if (andSet == x0oVar2) {
            return true;
        }
        return false;
    }
}
