package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.IIX0;

@XX({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
/* loaded from: classes6.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.XO<T>, IXIxx0.I0Io {

    @OXOo.OOXIXo
    @XO0OX.XO
    public final CoroutineContext collectContext;

    @XO0OX.XO
    public final int collectContextSize;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final kotlinx.coroutines.flow.XO<T> collector;

    @OXOo.oOoXoXO
    private kotlin.coroutines.I0Io<? super oXIO0o0XI> completion;

    @OXOo.oOoXoXO
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        super(xoIox.f30203XO, EmptyCoroutineContext.INSTANCE);
        this.collector = xo2;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new x0xO0oo<Integer, CoroutineContext.oIX0oI, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            @OXOo.OOXIXo
            public final Integer invoke(int i, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                return Integer.valueOf(i + 1);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.oIX0oI oix0oi) {
                return invoke(num.intValue(), oix0oi);
            }
        })).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof XO) {
            exceptionTransparencyViolated((XO) coroutineContext2, t);
        }
        SafeCollector_commonKt.oIX0oI(this, coroutineContext);
    }

    private final void exceptionTransparencyViolated(XO xo2, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.x0xO0oo("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + xo2.f30191XO + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        try {
            Object emit = emit(i0Io, (kotlin.coroutines.I0Io<? super oXIO0o0XI>) t);
            if (emit == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return emit == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO() ? emit : oXIO0o0XI.f29392oIX0oI;
        } catch (Throwable th) {
            this.lastEmissionContext = new XO(th, i0Io.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, IXIxx0.I0Io
    @OXOo.oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io = this.completion;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, IXIxx0.I0Io
    @OXOo.oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            this.lastEmissionContext = new XO(m290exceptionOrNullimpl, getContext());
        }
        kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io = this.completion;
        if (i0Io != null) {
            i0Io.resumeWith(obj);
        }
        return kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io, T t) {
        CoroutineContext context = i0Io.getContext();
        IIX0.O0xOxO(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t);
            this.lastEmissionContext = context;
        }
        this.completion = i0Io;
        IXxxXO oIX0oI2 = SafeCollectorKt.oIX0oI();
        kotlinx.coroutines.flow.XO<T> xo2 = this.collector;
        IIX0o.x0XOIxOo(xo2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = oIX0oI2.invoke(xo2, t, this);
        if (!IIX0o.Oxx0IOOO(invoke, kotlin.coroutines.intrinsics.II0xO0.oOoXoXO())) {
            this.completion = null;
        }
        return invoke;
    }
}
