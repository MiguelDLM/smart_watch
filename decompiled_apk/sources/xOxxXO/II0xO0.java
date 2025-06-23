package xOxxXO;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

@xxIXOIIO(name = "TimingKt")
/* loaded from: classes6.dex */
public final class II0xO0 {
    public static final long II0xO0(@OOXIXo Oox.oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        block.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static final long oIX0oI(@OOXIXo Oox.oIX0oI<oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        long nanoTime = System.nanoTime();
        block.invoke();
        return System.nanoTime() - nanoTime;
    }
}
