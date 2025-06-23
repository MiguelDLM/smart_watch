package Ox00XOXoo;

/* loaded from: classes6.dex */
public class I0Io {
    public static int oIX0oI(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return -1;
        }
        if (cls.equals(cls2)) {
            return 0;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        int OxI2 = org.apache.commons.lang3.XO.OxI(cls2.equals(superclass));
        if (OxI2 == 1) {
            return OxI2;
        }
        int oIX0oI2 = OxI2 + oIX0oI(superclass, cls2);
        if (oIX0oI2 <= 0) {
            return -1;
        }
        return oIX0oI2 + 1;
    }
}
