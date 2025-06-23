package kotlinx.coroutines.channels;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", MapBundleKey.MapObjKey.OBJ_SL_INDEX, "count"}, s = {"L$0", "I$0", "I$1"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$elementAt$1(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$elementAt$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        oOoXoXO2 = ChannelsKt__DeprecatedKt.oOoXoXO(null, 0, this);
        return oOoXoXO2;
    }
}
