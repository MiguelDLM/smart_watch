package oO0OX0;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public abstract class I0Io extends II0xO0 {
    @Override // oO0OX0.II0xO0
    public final int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        return XO(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }

    public abstract boolean XO(int i, Writer writer) throws IOException;
}
