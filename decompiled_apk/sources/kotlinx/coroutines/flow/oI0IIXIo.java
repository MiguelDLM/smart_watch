package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.Oxx0xo;

/* loaded from: classes6.dex */
public final class oI0IIXIo {
    public static /* synthetic */ Oxx0xo II0xO0(Oxx0xo.oIX0oI oix0oi, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = kotlin.time.oxoX.f29647Oo.XX();
        }
        if ((i & 2) != 0) {
            j2 = kotlin.time.oxoX.f29647Oo.Oo();
        }
        return oIX0oI(oix0oi, j, j2);
    }

    @OXOo.OOXIXo
    public static final Oxx0xo oIX0oI(@OXOo.OOXIXo Oxx0xo.oIX0oI oix0oi, long j, long j2) {
        return new StartedWhileSubscribed(kotlin.time.oxoX.oOXoIIIo(j), kotlin.time.oxoX.oOXoIIIo(j2));
    }
}
