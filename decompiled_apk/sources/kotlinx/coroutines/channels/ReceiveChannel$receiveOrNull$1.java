package kotlinx.coroutines.channels;

import com.garmin.fit.IXXIXx00I;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ReceiveChannel;

@IXIxx0.oxoX(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {IXXIXx00I.f11768x0OxxIOxX}, m = "receiveOrNull", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ReceiveChannel$receiveOrNull$1(kotlin.coroutines.I0Io<? super ReceiveChannel$receiveOrNull$1> i0Io) {
        super(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.xxIXOIIO(null, this);
    }
}
