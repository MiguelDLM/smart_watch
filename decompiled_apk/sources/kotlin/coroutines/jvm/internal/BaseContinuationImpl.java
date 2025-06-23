package kotlin.coroutines.jvm.internal;

import IXIxx0.X0o0xo;
import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.Serializable;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class BaseContinuationImpl implements I0Io<Object>, IXIxx0.I0Io, Serializable {

    @oOoXoXO
    private final I0Io<Object> completion;

    public BaseContinuationImpl(@oOoXoXO I0Io<Object> i0Io) {
        this.completion = i0Io;
    }

    @OOXIXo
    public I0Io<oXIO0o0XI> create(@OOXIXo I0Io<?> completion) {
        IIX0o.x0xO0oo(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // IXIxx0.I0Io
    @oOoXoXO
    public IXIxx0.I0Io getCallerFrame() {
        I0Io<Object> i0Io = this.completion;
        if (i0Io instanceof IXIxx0.I0Io) {
            return (IXIxx0.I0Io) i0Io;
        }
        return null;
    }

    @oOoXoXO
    public final I0Io<Object> getCompletion() {
        return this.completion;
    }

    @Override // IXIxx0.I0Io
    @oOoXoXO
    public StackTraceElement getStackTraceElement() {
        return X0o0xo.X0o0xo(this);
    }

    @oOoXoXO
    public abstract Object invokeSuspend(@OOXIXo Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.I0Io
    public final void resumeWith(@OOXIXo Object obj) {
        Object invokeSuspend;
        I0Io i0Io = this;
        while (true) {
            XO.II0xO0(i0Io);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) i0Io;
            I0Io i0Io2 = baseContinuationImpl.completion;
            IIX0o.ooOOo0oXI(i0Io2);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.oIX0oI oix0oi = Result.Companion;
                obj = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
            }
            if (invokeSuspend == II0xO0.oOoXoXO()) {
                return;
            }
            Result.oIX0oI oix0oi2 = Result.Companion;
            obj = Result.m287constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (i0Io2 instanceof BaseContinuationImpl) {
                i0Io = i0Io2;
            } else {
                i0Io2.resumeWith(obj);
                return;
            }
        }
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @OOXIXo
    public I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> completion) {
        IIX0o.x0xO0oo(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
