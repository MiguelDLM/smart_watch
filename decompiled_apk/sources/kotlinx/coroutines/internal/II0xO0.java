package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.OX00O0xII;

@kotlin.jvm.internal.XX({"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
@OX00O0xII
/* loaded from: classes6.dex */
public abstract class II0xO0<T> extends xI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30223oIX0oI = AtomicReferenceFieldUpdater.newUpdater(II0xO0.class, Object.class, "_consensus");

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _consensus = oIX0oI.f30296oIX0oI;

    public abstract void I0Io(T t, @OXOo.oOoXoXO Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.xI
    @OXOo.oOoXoXO
    public final Object II0xO0(@OXOo.oOoXoXO Object obj) {
        Object obj2 = f30223oIX0oI.get(this);
        if (obj2 == oIX0oI.f30296oIX0oI) {
            obj2 = oxoX(X0o0xo(obj));
        }
        I0Io(obj, obj2);
        return obj2;
    }

    @OXOo.oOoXoXO
    public abstract Object X0o0xo(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.xI
    @OXOo.OOXIXo
    public II0xO0<?> oIX0oI() {
        return this;
    }

    public final Object oxoX(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30223oIX0oI;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = oIX0oI.f30296oIX0oI;
        if (obj2 != obj3) {
            return obj2;
        }
        if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }
}
