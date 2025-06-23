package IOooo0o;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public class OOXIXo extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f627I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f628II0xO0;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f629oxoX;

    public OOXIXo() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static OOXIXo II0XooXoX(int i) {
        return xoIox(i, Integer.MAX_VALUE);
    }

    public static OOXIXo Oxx0IOOO(int i) {
        return xoIox(0, i);
    }

    public static OOXIXo xoIox(int i, int i2) {
        return new OOXIXo(i, i2, false);
    }

    public static OOXIXo xxIXOIIO(int i, int i2) {
        return new OOXIXo(i, i2, true);
    }

    public String OOXIXo(int i) {
        return "\\u" + II0xO0.oIX0oI(i);
    }

    @Override // IOooo0o.I0Io
    public boolean XO(int i, Writer writer) throws IOException {
        if (this.f629oxoX) {
            if (i < this.f628II0xO0 || i > this.f627I0Io) {
                return false;
            }
        } else if (i >= this.f628II0xO0 && i <= this.f627I0Io) {
            return false;
        }
        if (i > 65535) {
            writer.write(OOXIXo(i));
            return true;
        }
        writer.write("\\u");
        char[] cArr = II0xO0.f626oIX0oI;
        writer.write(cArr[(i >> 12) & 15]);
        writer.write(cArr[(i >> 8) & 15]);
        writer.write(cArr[(i >> 4) & 15]);
        writer.write(cArr[i & 15]);
        return true;
    }

    public OOXIXo(int i, int i2, boolean z) {
        this.f628II0xO0 = i;
        this.f627I0Io = i2;
        this.f629oxoX = z;
    }
}
