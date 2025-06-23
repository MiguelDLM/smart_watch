package kotlin.random;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import xx0o0O.XO;
import xx0o0O.ooOOo0oXI;

/* loaded from: classes6.dex */
public final class I0Io {
    @XO
    public static final Random I0Io() {
        return ooOOo0oXI.f35291oIX0oI.II0xO0();
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final Random II0xO0(@OOXIXo java.util.Random random) {
        KotlinRandom kotlinRandom;
        Random impl;
        IIX0o.x0xO0oo(random, "<this>");
        if (random instanceof KotlinRandom) {
            kotlinRandom = (KotlinRandom) random;
        } else {
            kotlinRandom = null;
        }
        if (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) {
            return new PlatformRandom(random);
        }
        return impl;
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final java.util.Random oIX0oI(@OOXIXo Random random) {
        oIX0oI oix0oi;
        java.util.Random impl;
        IIX0o.x0xO0oo(random, "<this>");
        if (random instanceof oIX0oI) {
            oix0oi = (oIX0oI) random;
        } else {
            oix0oi = null;
        }
        if (oix0oi == null || (impl = oix0oi.getImpl()) == null) {
            return new KotlinRandom(random);
        }
        return impl;
    }

    public static final double oxoX(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }
}
