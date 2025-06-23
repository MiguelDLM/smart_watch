package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.Xx000oIo;
import kotlinx.coroutines.channels.oI0IIXIo;

/* loaded from: classes6.dex */
public final class x0xO0oo<E> extends II0XooXoX<E> implements IXxxXO<E> {
    public x0xO0oo(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO) {
        super(coroutineContext, oxx0IOOO, true, true);
    }

    @Override // kotlinx.coroutines.oIX0oI
    /* renamed from: OIx00oxx, reason: merged with bridge method [inline-methods] */
    public void XoIxOXIXo(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        oI0IIXIo.oIX0oI.oIX0oI(OooI(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.IXxxXO
    public /* bridge */ /* synthetic */ oI0IIXIo getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.oIX0oI, kotlinx.coroutines.JobSupport, kotlinx.coroutines.oXIO0o0XI
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.oIX0oI
    public void o0IXXIx(@OXOo.OOXIXo Throwable th, boolean z) {
        if (!OooI().x0o(th) && !z) {
            Xx000oIo.II0xO0(getContext(), th);
        }
    }
}
