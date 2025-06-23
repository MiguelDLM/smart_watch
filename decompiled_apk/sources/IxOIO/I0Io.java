package IxOIO;

/* loaded from: classes6.dex */
public final class I0Io {
    public static int oIX0oI(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & 16777215) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
