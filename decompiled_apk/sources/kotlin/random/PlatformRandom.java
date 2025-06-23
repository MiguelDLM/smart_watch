package kotlin.random;

import OXOo.OOXIXo;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
final class PlatformRandom extends kotlin.random.oIX0oI implements Serializable {

    @OOXIXo
    private static final oIX0oI Companion = new oIX0oI(null);
    private static final long serialVersionUID = 0;

    @OOXIXo
    private final java.util.Random impl;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public PlatformRandom(@OOXIXo java.util.Random impl) {
        IIX0o.x0xO0oo(impl, "impl");
        this.impl = impl;
    }

    @Override // kotlin.random.oIX0oI
    @OOXIXo
    public java.util.Random getImpl() {
        return this.impl;
    }
}
