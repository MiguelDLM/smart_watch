package OXIOoo0X0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes13.dex */
public class xxIXOIIO extends OOXIXo<String> implements xoIox {
    @Override // OXIOoo0X0.xoIox
    public int[] II0xO0(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] Oxx0xo2 = com.univocity.parsers.common.I0Io.Oxx0xo(strArr);
        List<String> XO2 = XO();
        com.univocity.parsers.common.I0Io.IXxxXO(XO2);
        String[] strArr2 = (String[]) XO2.toArray(new String[XO2.size()]);
        Object[] II0xO02 = com.univocity.parsers.common.I0Io.II0xO0(Oxx0xo2, strArr2);
        if (II0xO02.length > 0 && !XO2.containsAll(Arrays.asList(Oxx0xo2)) && II0xO02.length == strArr2.length) {
            return new int[0];
        }
        int length = strArr2.length;
        int[] iArr = new int[length];
        HashSet hashSet = new HashSet();
        int length2 = strArr2.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int I0Io2 = com.univocity.parsers.common.I0Io.I0Io(Oxx0xo2, strArr2[i]);
            if (I0Io2 != -1) {
                hashSet.add(Integer.valueOf(I0Io2));
            }
            iArr[i2] = I0Io2;
            i++;
            i2++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] == -1) {
                while (hashSet.contains(Integer.valueOf(i3))) {
                    i3++;
                }
                hashSet.add(Integer.valueOf(i3));
                iArr[i4] = i3;
            }
        }
        return iArr;
    }

    public int OOXIXo(String str) {
        return II0xO0(new String[]{str})[0];
    }
}
