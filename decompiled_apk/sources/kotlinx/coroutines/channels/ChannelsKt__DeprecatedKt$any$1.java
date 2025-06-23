package kotlinx.coroutines.channels;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Languages;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = Languages.ANY, n = {"$this$consume$iv"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$any$1(kotlin.coroutines.I0Io<? super ChannelsKt__DeprecatedKt$any$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oIX0oI2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        oIX0oI2 = ChannelsKt__DeprecatedKt.oIX0oI(null, this);
        return oIX0oI2;
    }
}
