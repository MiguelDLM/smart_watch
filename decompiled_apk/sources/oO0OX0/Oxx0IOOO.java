package oO0OX0;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class Oxx0IOOO extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f31966I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f31967II0xO0;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f31968oxoX;

    public Oxx0IOOO(int i, int i2, boolean z) {
        this.f31967II0xO0 = i;
        this.f31966I0Io = i2;
        this.f31968oxoX = z;
    }

    public static Oxx0IOOO II0XooXoX(int i) {
        return xoIox(i, Integer.MAX_VALUE);
    }

    public static Oxx0IOOO Oxx0IOOO(int i) {
        return xoIox(0, i);
    }

    public static Oxx0IOOO xoIox(int i, int i2) {
        return new Oxx0IOOO(i, i2, false);
    }

    public static Oxx0IOOO xxIXOIIO(int i, int i2) {
        return new Oxx0IOOO(i, i2, true);
    }

    @Override // oO0OX0.I0Io
    public boolean XO(int i, Writer writer) throws IOException {
        if (this.f31968oxoX) {
            if (i < this.f31967II0xO0 || i > this.f31966I0Io) {
                return false;
            }
        } else if (i >= this.f31967II0xO0 && i <= this.f31966I0Io) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }

    public Oxx0IOOO() {
        this(0, Integer.MAX_VALUE, true);
    }
}
