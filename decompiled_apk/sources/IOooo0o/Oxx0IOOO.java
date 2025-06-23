package IOooo0o;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final BitSet f630I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<String, String> f631II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f632X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f633oxoX;

    public Oxx0IOOO(Map<CharSequence, CharSequence> map) {
        if (map != null) {
            this.f631II0xO0 = new HashMap();
            this.f630I0Io = new BitSet();
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            for (Map.Entry<CharSequence, CharSequence> entry : map.entrySet()) {
                this.f631II0xO0.put(entry.getKey().toString(), entry.getValue().toString());
                this.f630I0Io.set(entry.getKey().charAt(0));
                int length = entry.getKey().length();
                i = length < i ? length : i;
                if (length > i2) {
                    i2 = length;
                }
            }
            this.f633oxoX = i;
            this.f632X0o0xo = i2;
            return;
        }
        throw new InvalidParameterException("lookupMap cannot be null");
    }

    @Override // IOooo0o.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (this.f630I0Io.get(charSequence.charAt(i))) {
            int i2 = this.f632X0o0xo;
            if (i + i2 > charSequence.length()) {
                i2 = charSequence.length() - i;
            }
            while (i2 >= this.f633oxoX) {
                String str = this.f631II0xO0.get(charSequence.subSequence(i, i + i2).toString());
                if (str != null) {
                    writer.write(str);
                    return i2;
                }
                i2--;
            }
            return 0;
        }
        return 0;
    }
}
