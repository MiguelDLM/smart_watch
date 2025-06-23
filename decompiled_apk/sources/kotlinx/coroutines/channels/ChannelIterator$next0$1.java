package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {589}, m = "next", n = {"$this"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ChannelIterator$next0$1(kotlin.coroutines.I0Io<? super ChannelIterator$next0$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.oIX0oI(null, this);
    }
}
