package kotlin.coroutines.jvm.internal;

import IXIxx0.II0xO0;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {

    @oOoXoXO
    private final CoroutineContext _context;

    @oOoXoXO
    private transient I0Io<Object> intercepted;

    public ContinuationImpl(@oOoXoXO I0Io<Object> i0Io, @oOoXoXO CoroutineContext coroutineContext) {
        super(i0Io);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.I0Io
    @OOXIXo
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        IIX0o.ooOOo0oXI(coroutineContext);
        return coroutineContext;
    }

    @OOXIXo
    public final I0Io<Object> intercepted() {
        I0Io<Object> i0Io = this.intercepted;
        if (i0Io == null) {
            oxoX oxox = (oxoX) getContext().get(oxoX.f29196Oxx0IOOO);
            if (oxox == null || (i0Io = oxox.interceptContinuation(this)) == null) {
                i0Io = this;
            }
            this.intercepted = i0Io;
        }
        return i0Io;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        I0Io<?> i0Io = this.intercepted;
        if (i0Io != null && i0Io != this) {
            CoroutineContext.oIX0oI oix0oi = getContext().get(oxoX.f29196Oxx0IOOO);
            IIX0o.ooOOo0oXI(oix0oi);
            ((oxoX) oix0oi).releaseInterceptedContinuation(i0Io);
        }
        this.intercepted = II0xO0.f724XO;
    }

    public ContinuationImpl(@oOoXoXO I0Io<Object> i0Io) {
        this(i0Io, i0Io != null ? i0Io.getContext() : null);
    }
}
