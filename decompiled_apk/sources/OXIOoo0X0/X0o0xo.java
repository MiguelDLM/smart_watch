package OXIOoo0X0;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes13.dex */
public class X0o0xo extends OOXIXo<String> implements xoIox {
    @Override // OXIOoo0X0.xoIox
    public int[] II0xO0(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] Oxx0xo2 = com.univocity.parsers.common.I0Io.Oxx0xo(strArr);
        HashSet hashSet = new HashSet(XO());
        com.univocity.parsers.common.I0Io.IXxxXO(hashSet);
        Object[] oIX0oI2 = com.univocity.parsers.common.I0Io.oIX0oI(Oxx0xo2, hashSet);
        if (oIX0oI2.length <= 0) {
            int[] iArr = new int[Oxx0xo2.length - hashSet.size()];
            int i = 0;
            for (int i2 = 0; i2 < Oxx0xo2.length; i2++) {
                if (!hashSet.contains(Oxx0xo2[i2])) {
                    iArr[i] = i2;
                    i++;
                }
            }
            return iArr;
        }
        throw new IllegalStateException("Unknown field names: " + Arrays.toString(oIX0oI2));
    }

    @Override // OXIOoo0X0.OOXIXo, OXIOoo0X0.xoIox
    public String oIX0oI() {
        return "undesired " + super.oIX0oI();
    }
}
