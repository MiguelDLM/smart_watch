package oO0OX0;

@Deprecated
/* loaded from: classes6.dex */
public class X0o0xo extends xxIXOIIO {
    public X0o0xo(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    public static X0o0xo oO(int i, int i2) {
        return new X0o0xo(i, i2, false);
    }

    public static X0o0xo oOoXoXO(int i) {
        return oO(0, i);
    }

    public static X0o0xo ooOOo0oXI(int i) {
        return oO(i, Integer.MAX_VALUE);
    }

    public static X0o0xo x0XOIxOo(int i, int i2) {
        return new X0o0xo(i, i2, true);
    }

    @Override // oO0OX0.xxIXOIIO
    public String OOXIXo(int i) {
        char[] chars = Character.toChars(i);
        return "\\u" + II0xO0.oIX0oI(chars[0]) + "\\u" + II0xO0.oIX0oI(chars[1]);
    }
}
