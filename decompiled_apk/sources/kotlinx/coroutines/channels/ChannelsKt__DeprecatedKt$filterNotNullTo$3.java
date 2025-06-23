package kotlinx.coroutines.channels;

import com.jieli.jl_rcsp.constant.Command;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.oI0IIXIo;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends oI0IIXIo<? super E>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$filterNotNullTo$3(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$filterNotNullTo$3> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object IIXOooo2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        IIXOooo2 = ChannelsKt__DeprecatedKt.IIXOooo(null, null, this);
        return IIXOooo2;
    }
}
