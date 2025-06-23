package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.o0;
import kotlin.oxxXoxO;

@o0
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class II0XooXoX<T> implements I0Io<T>, IXIxx0.I0Io {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final I0Io<T> f29191XO;

    @oOoXoXO
    private volatile Object result;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f29190Oo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<II0XooXoX<?>, Object> f29189IXxxXO = AtomicReferenceFieldUpdater.newUpdater(II0XooXoX.class, Object.class, "result");

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ void oIX0oI() {
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX(@OOXIXo I0Io<? super T> delegate, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.f29191XO = delegate;
        this.result = obj;
    }

    @o0
    @oOoXoXO
    public final Object II0xO0() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29189IXxxXO, this, coroutineSingletons, kotlin.coroutines.intrinsics.II0xO0.oOoXoXO())) {
                return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).exception;
    }

    @Override // IXIxx0.I0Io
    @oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        I0Io<T> i0Io = this.f29191XO;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    @OOXIXo
    public CoroutineContext getContext() {
        return this.f29191XO.getContext();
    }

    @Override // IXIxx0.I0Io
    @oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OOXIXo Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29189IXxxXO, this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29189IXxxXO, this, kotlin.coroutines.intrinsics.II0xO0.oOoXoXO(), CoroutineSingletons.RESUMED)) {
                    this.f29191XO.resumeWith(obj);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @OOXIXo
    public String toString() {
        return "SafeContinuation for " + this.f29191XO;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @o0
    public II0XooXoX(@OOXIXo I0Io<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        IIX0o.x0xO0oo(delegate, "delegate");
    }
}
