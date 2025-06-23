package kotlinx.coroutines.channels;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "r"}, s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes6.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, kotlin.coroutines.I0Io<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> i0Io) {
        super(i0Io);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object IXO2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        IXO2 = this.this$0.IXO(null, 0, 0L, this);
        return IXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO() ? IXO2 : xoIox.II0xO0(IXO2);
    }
}
