package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public abstract class I0<Array> {
    public static /* synthetic */ void I0Io(I0 i0, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = i0.oxoX() + 1;
            }
            i0.II0xO0(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract void II0xO0(int i);

    public abstract Array oIX0oI();

    public abstract int oxoX();
}
