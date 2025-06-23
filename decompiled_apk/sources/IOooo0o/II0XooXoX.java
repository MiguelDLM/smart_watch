package IOooo0o;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.Range;

/* loaded from: classes6.dex */
public class II0XooXoX extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Range<Integer> f624I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f625II0xO0;

    public II0XooXoX(int i, int i2, boolean z) {
        this.f624I0Io = Range.between(Integer.valueOf(i), Integer.valueOf(i2));
        this.f625II0xO0 = z;
    }

    public static II0XooXoX II0XooXoX(int i) {
        return xoIox(i, Integer.MAX_VALUE);
    }

    public static II0XooXoX Oxx0IOOO(int i) {
        return xoIox(0, i);
    }

    public static II0XooXoX xoIox(int i, int i2) {
        return new II0XooXoX(i, i2, false);
    }

    public static II0XooXoX xxIXOIIO(int i, int i2) {
        return new II0XooXoX(i, i2, true);
    }

    @Override // IOooo0o.I0Io
    public boolean XO(int i, Writer writer) throws IOException {
        if (this.f625II0xO0 != this.f624I0Io.contains(Integer.valueOf(i))) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }

    public II0XooXoX() {
        this(0, Integer.MAX_VALUE, true);
    }
}
