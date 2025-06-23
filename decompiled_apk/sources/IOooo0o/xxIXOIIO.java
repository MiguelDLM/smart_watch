package IOooo0o;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes6.dex */
public class xxIXOIIO extends II0xO0 {
    @Override // IOooo0o.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        int length = (charSequence.length() - i) - 1;
        StringBuilder sb = new StringBuilder();
        if (charSequence.charAt(i) == '\\' && length > 0) {
            int i2 = i + 1;
            if (XO(charSequence.charAt(i2))) {
                int i3 = i + 2;
                int i4 = i + 3;
                sb.append(charSequence.charAt(i2));
                if (length > 1 && XO(charSequence.charAt(i3))) {
                    sb.append(charSequence.charAt(i3));
                    if (length > 2 && Oxx0IOOO(charSequence.charAt(i2)) && XO(charSequence.charAt(i4))) {
                        sb.append(charSequence.charAt(i4));
                    }
                }
                writer.write(Integer.parseInt(sb.toString(), 8));
                return sb.length() + 1;
            }
            return 0;
        }
        return 0;
    }

    public final boolean Oxx0IOOO(char c) {
        if (c >= '0' && c <= '3') {
            return true;
        }
        return false;
    }

    public final boolean XO(char c) {
        if (c >= '0' && c <= '7') {
            return true;
        }
        return false;
    }
}
