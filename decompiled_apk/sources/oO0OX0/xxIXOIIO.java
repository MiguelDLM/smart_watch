package oO0OX0;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class xxIXOIIO extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f31984I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f31985II0xO0;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f31986oxoX;

    public xxIXOIIO() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static xxIXOIIO II0XooXoX(int i) {
        return xoIox(i, Integer.MAX_VALUE);
    }

    public static xxIXOIIO Oxx0IOOO(int i) {
        return xoIox(0, i);
    }

    public static xxIXOIIO xoIox(int i, int i2) {
        return new xxIXOIIO(i, i2, false);
    }

    public static xxIXOIIO xxIXOIIO(int i, int i2) {
        return new xxIXOIIO(i, i2, true);
    }

    public String OOXIXo(int i) {
        return "\\u" + II0xO0.oIX0oI(i);
    }

    @Override // oO0OX0.I0Io
    public boolean XO(int i, Writer writer) throws IOException {
        if (this.f31986oxoX) {
            if (i < this.f31985II0xO0 || i > this.f31984I0Io) {
                return false;
            }
        } else if (i >= this.f31985II0xO0 && i <= this.f31984I0Io) {
            return false;
        }
        if (i > 65535) {
            writer.write(OOXIXo(i));
            return true;
        }
        writer.write("\\u");
        char[] cArr = II0xO0.f31965oIX0oI;
        writer.write(cArr[(i >> 12) & 15]);
        writer.write(cArr[(i >> 8) & 15]);
        writer.write(cArr[(i >> 4) & 15]);
        writer.write(cArr[i & 15]);
        return true;
    }

    public xxIXOIIO(int i, int i2, boolean z) {
        this.f31985II0xO0 = i;
        this.f31984I0Io = i2;
        this.f31986oxoX = z;
    }
}
