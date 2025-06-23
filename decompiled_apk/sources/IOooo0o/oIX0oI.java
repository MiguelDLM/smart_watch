package IOooo0o;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class oIX0oI extends II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<II0xO0> f644II0xO0 = new ArrayList();

    public oIX0oI(II0xO0... iI0xO0Arr) {
        if (iI0xO0Arr != null) {
            for (II0xO0 iI0xO0 : iI0xO0Arr) {
                if (iI0xO0 != null) {
                    this.f644II0xO0.add(iI0xO0);
                }
            }
        }
    }

    @Override // IOooo0o.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        Iterator<II0xO0> it = this.f644II0xO0.iterator();
        while (it.hasNext()) {
            int II0xO02 = it.next().II0xO0(charSequence, i, writer);
            if (II0xO02 != 0) {
                return II0xO02;
            }
        }
        return 0;
    }
}
