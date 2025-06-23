package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {706}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<R> selectImplementation, kotlin.coroutines.I0Io<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> i0Io) {
        super(i0Io);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object xXxxox0I2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        xXxxox0I2 = this.this$0.xXxxox0I(null, null, this);
        return xXxxox0I2;
    }
}
