package O0;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes10.dex */
public class oI0IIXIo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f1114OOXIXo = -2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f1115oOoXoXO = -3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f1116ooOOo0oXI = -5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f1117x0XOIxOo = -6;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f1118xoIox = -1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f1123X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Reader f1124XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f1125oIX0oI = Integer.MIN_VALUE;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f1121II0xO0 = Integer.MIN_VALUE;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f1119I0Io = "";

    /* renamed from: oxoX, reason: collision with root package name */
    public final StringBuffer f1126oxoX = new StringBuffer();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final int[] f1122Oxx0IOOO = new int[256];

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f1120II0XooXoX = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public char f1127xxIXOIIO = 0;

    public oI0IIXIo(Reader reader) throws IOException {
        char c = 0;
        this.f1124XO = reader;
        while (true) {
            int[] iArr = this.f1122Oxx0IOOO;
            if (c < iArr.length) {
                if (('A' <= c && c <= 'Z') || (('a' <= c && c <= 'z') || c == '-')) {
                    iArr[c] = -3;
                } else if ('0' <= c && c <= '9') {
                    iArr[c] = -2;
                } else if (c >= 0 && c <= ' ') {
                    iArr[c] = -5;
                } else {
                    iArr[c] = c;
                }
                c = (char) (c + 1);
            } else {
                oIX0oI();
                return;
            }
        }
    }

    public void I0Io() {
        this.f1120II0XooXoX = true;
    }

    public void II0xO0(char c) {
        this.f1122Oxx0IOOO[c] = c;
    }

    public int oIX0oI() throws IOException {
        int read;
        int i;
        char c;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        if (this.f1120II0XooXoX) {
            this.f1120II0XooXoX = false;
            return this.f1125oIX0oI;
        }
        this.f1125oIX0oI = this.f1123X0o0xo;
        do {
            boolean z3 = false;
            do {
                read = this.f1124XO.read();
                if (read == -1) {
                    if (this.f1127xxIXOIIO == 0) {
                        i = -1;
                    } else {
                        throw new IOException("Unterminated quote");
                    }
                } else {
                    i = this.f1122Oxx0IOOO[read];
                }
                c = this.f1127xxIXOIIO;
                if (c == 0 && i == -5) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z3 && !z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } while (z);
            if (i == 39 || i == 34) {
                if (c == 0) {
                    this.f1127xxIXOIIO = (char) i;
                } else if (c == i) {
                    this.f1127xxIXOIIO = (char) 0;
                }
            }
            char c2 = this.f1127xxIXOIIO;
            if (c2 != 0) {
                i = c2;
            }
            if (!z3 && (((i3 = this.f1125oIX0oI) < -1 || i3 == 39 || i3 == 34) && i3 == i)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int i4 = this.f1125oIX0oI;
                if (i4 != -3) {
                    if (i4 != -2) {
                        if (i4 == 34 || i4 == 39) {
                            this.f1119I0Io = this.f1126oxoX.toString().substring(1, this.f1126oxoX.length() - 1);
                            this.f1126oxoX.setLength(0);
                        }
                    } else {
                        this.f1121II0xO0 = Integer.parseInt(this.f1126oxoX.toString());
                        this.f1126oxoX.setLength(0);
                    }
                } else {
                    this.f1119I0Io = this.f1126oxoX.toString();
                    this.f1126oxoX.setLength(0);
                }
                if (i != -5) {
                    if (i == -6) {
                        i2 = read;
                    } else {
                        i2 = i;
                    }
                    this.f1123X0o0xo = i2;
                }
            }
            if (i == -3 || i == -2 || i == 34 || i == 39) {
                this.f1126oxoX.append((char) read);
            }
        } while (!z2);
        return this.f1125oIX0oI;
    }

    public void oxoX(char c, char c2) {
        while (c <= c2) {
            this.f1122Oxx0IOOO[c] = -3;
            c = (char) (c + 1);
        }
    }

    public String toString() {
        int i = this.f1125oIX0oI;
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                    if (i != 34) {
                        if (i != 39) {
                            return "'" + ((char) this.f1125oIX0oI) + "'";
                        }
                        return "'" + this.f1119I0Io + "'";
                    }
                } else {
                    return "(EOF)";
                }
            } else {
                return Integer.toString(this.f1121II0xO0);
            }
        }
        return "\"" + this.f1119I0Io + "\"";
    }
}
