package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.eclipse.paho.android.service.MqttServiceConstants;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {230}, m = MqttServiceConstants.SEND_ACTION, n = {"this", "element"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class BroadcastChannelImpl$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$send$1(BroadcastChannelImpl<E> broadcastChannelImpl, kotlin.coroutines.I0Io<? super BroadcastChannelImpl$send$1> i0Io) {
        super(i0Io);
        this.this$0 = broadcastChannelImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.XOxIOxOx(null, this);
    }
}
