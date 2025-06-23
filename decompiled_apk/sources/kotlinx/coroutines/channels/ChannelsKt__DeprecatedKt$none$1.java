package kotlinx.coroutines.channels;

import com.goodix.ble.libcomx.task.TaskPipe;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {TaskPipe.EVT_TASK_ADDED}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$none$1(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$none$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object X00IoxXI2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        X00IoxXI2 = ChannelsKt__DeprecatedKt.X00IoxXI(null, this);
        return X00IoxXI2;
    }
}
