package androidx.work;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@oxoX(c = "androidx.work.OperationKt", f = "Operation.kt", i = {}, l = {36}, m = "await", n = {}, s = {})
public final class OperationKt$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public OperationKt$await$1(I0Io<? super OperationKt$await$1> i0Io) {
        super(i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await((Operation) null, this);
    }
}
