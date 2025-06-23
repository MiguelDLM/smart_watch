package IOooo0o;

/* loaded from: classes6.dex */
public class XO extends OOXIXo {
    public XO(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    public static XO oO(int i, int i2) {
        return new XO(i, i2, false);
    }

    public static XO oOoXoXO(int i) {
        return oO(0, i);
    }

    public static XO ooOOo0oXI(int i) {
        return oO(i, Integer.MAX_VALUE);
    }

    public static XO x0XOIxOo(int i, int i2) {
        return new XO(i, i2, true);
    }

    @Override // IOooo0o.OOXIXo
    public String OOXIXo(int i) {
        char[] chars = Character.toChars(i);
        return "\\u" + II0xO0.oIX0oI(chars[0]) + "\\u" + II0xO0.oIX0oI(chars[1]);
    }
}
