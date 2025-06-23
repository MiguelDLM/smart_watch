package oO0OX0;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class oIX0oI extends II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final II0xO0[] f31973II0xO0;

    public oIX0oI(II0xO0... iI0xO0Arr) {
        this.f31973II0xO0 = (II0xO0[]) org.apache.commons.lang3.oxoX.x0o(iI0xO0Arr);
    }

    @Override // oO0OX0.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (II0xO0 iI0xO0 : this.f31973II0xO0) {
            int II0xO02 = iI0xO0.II0xO0(charSequence, i, writer);
            if (II0xO02 != 0) {
                return II0xO02;
            }
        }
        return 0;
    }
}
