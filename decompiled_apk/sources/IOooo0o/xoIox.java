package IOooo0o;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public abstract class xoIox extends II0xO0 {
    @Override // IOooo0o.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (i == 0) {
            Oxx0IOOO(charSequence, writer);
            return Character.codePointCount(charSequence, i, charSequence.length());
        }
        throw new IllegalArgumentException(XO() + ".translate(final CharSequence input, final int index, final Writer out) can not handle a non-zero index.");
    }

    public abstract void Oxx0IOOO(CharSequence charSequence, Writer writer) throws IOException;

    public final String XO() {
        Class<?> cls = getClass();
        if (cls.isAnonymousClass()) {
            return cls.getName();
        }
        return cls.getSimpleName();
    }
}
