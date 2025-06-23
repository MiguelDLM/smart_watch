package x0oox0;

/* loaded from: classes13.dex */
public abstract class Oxx0IOOO implements XO {
    public abstract void II0xO0(char c, char c2);

    @Override // x0oox0.XO
    public void oIX0oI(char[] cArr, int i) {
        char c;
        char c2 = 0;
        char c3 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            c = cArr[i2];
            if (c != '\n' && c != '\r') {
                if (c3 != 0) {
                    break;
                }
            } else if (c3 != 0) {
                break;
            } else {
                c3 = c;
            }
        }
        c = 0;
        if (c3 != 0) {
            if (c3 == '\n') {
                c3 = '\n';
            } else {
                if (c == '\n') {
                    c2 = '\n';
                }
                c3 = '\r';
            }
        } else {
            c2 = c;
        }
        II0xO0(c3, c2);
    }
}
