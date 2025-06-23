package kotlin.coroutines.jvm.internal;

import IXIxx0.xoIox;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XIxXXX0x0;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class SuspendLambda extends ContinuationImpl implements XIxXXX0x0<Object>, xoIox {
    private final int arity;

    public SuspendLambda(int i, @oOoXoXO I0Io<Object> i0Io) {
        super(i0Io);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.XIxXXX0x0
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public String toString() {
        if (getCompletion() == null) {
            String xoXoI2 = IO.xoXoI(this);
            IIX0o.oO(xoXoI2, "renderLambdaToString(...)");
            return xoXoI2;
        }
        return super.toString();
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
