package kotlinx.coroutines.channels;

import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$toMap$2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$toMap$2(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$toMap$2> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return oOoXoXO.XoI0Ixx0(null, null, this);
    }
}
