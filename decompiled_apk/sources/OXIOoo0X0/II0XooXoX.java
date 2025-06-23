package OXIOoo0X0;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public class II0XooXoX extends OOXIXo<Integer> implements xoIox {
    @Override // OXIOoo0X0.xoIox
    public int[] II0xO0(String[] strArr) {
        List<Integer> XO2 = XO();
        int[] iArr = new int[XO2.size()];
        Iterator<Integer> it = XO2.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }
}
