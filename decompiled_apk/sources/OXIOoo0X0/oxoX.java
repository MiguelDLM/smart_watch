package OXIOoo0X0;

import java.util.HashSet;

/* loaded from: classes13.dex */
public class oxoX extends OOXIXo<Integer> implements xoIox {
    @Override // OXIOoo0X0.xoIox
    public int[] II0xO0(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashSet<Integer> hashSet = new HashSet(XO());
        for (Integer num : hashSet) {
            if (num.intValue() >= strArr.length || num.intValue() < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exclusion index '");
                sb.append(num);
                sb.append("' is out of bounds. It must be between '0' and '");
                sb.append(strArr.length - 1);
                sb.append('\'');
                throw new IndexOutOfBoundsException(sb.toString());
            }
        }
        int[] iArr = new int[strArr.length - hashSet.size()];
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!hashSet.contains(Integer.valueOf(i2))) {
                iArr[i] = i2;
                i++;
            }
        }
        return iArr;
    }

    @Override // OXIOoo0X0.OOXIXo, OXIOoo0X0.xoIox
    public String oIX0oI() {
        return "undesired " + super.oIX0oI();
    }
}
