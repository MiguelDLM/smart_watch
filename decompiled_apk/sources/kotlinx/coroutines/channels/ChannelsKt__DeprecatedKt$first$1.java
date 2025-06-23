package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {65}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$first$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$first$1(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$first$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object xoXoI2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        xoXoI2 = ChannelsKt__DeprecatedKt.xoXoI(null, this);
        return xoXoI2;
    }
}
