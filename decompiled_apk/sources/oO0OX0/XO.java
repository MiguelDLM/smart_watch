package oO0OX0;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

@Deprecated
/* loaded from: classes6.dex */
public class XO extends II0xO0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f31971X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f31972oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final HashMap<String, String> f31970II0xO0 = new HashMap<>();

    /* renamed from: I0Io, reason: collision with root package name */
    public final HashSet<Character> f31969I0Io = new HashSet<>();

    public XO(CharSequence[]... charSequenceArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        if (charSequenceArr != null) {
            int i3 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f31970II0xO0.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.f31969I0Io.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i = length < i ? length : i;
                if (length > i3) {
                    i3 = length;
                }
            }
            i2 = i3;
        }
        this.f31972oxoX = i;
        this.f31971X0o0xo = i2;
    }

    @Override // oO0OX0.II0xO0
    public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (this.f31969I0Io.contains(Character.valueOf(charSequence.charAt(i)))) {
            int i2 = this.f31971X0o0xo;
            if (i + i2 > charSequence.length()) {
                i2 = charSequence.length() - i;
            }
            while (i2 >= this.f31972oxoX) {
                String str = this.f31970II0xO0.get(charSequence.subSequence(i, i + i2).toString());
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
