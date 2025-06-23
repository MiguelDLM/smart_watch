package OX00o0X;

import java.util.Comparator;

/* loaded from: classes6.dex */
public class x0xO0oo implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 != null && ((xoIox) obj).II0XooXoX() >= ((xoIox) obj2).II0XooXoX()) {
            return -1;
        }
        return 1;
    }
}
