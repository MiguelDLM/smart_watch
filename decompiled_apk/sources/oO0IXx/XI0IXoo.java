package oO0IXx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class XI0IXoo extends IIX0o {

    /* renamed from: I0Io, reason: collision with root package name */
    public II0xO0 f31899I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final String f31900II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final int f31901Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public II0xO0 f31902X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Class[] f31903XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public II0xO0[] f31904oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Comparator f31905xxIXOIIO;

    /* loaded from: classes13.dex */
    public class oIX0oI implements Comparator<Object> {
        public oIX0oI() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj != null && obj.equals(obj2)) {
                return 0;
            }
            return 1;
        }
    }

    public XI0IXoo() {
        this(0);
    }

    @Override // oO0IXx.IIX0o
    public String[] I0Io(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int i = this.f31901Oxx0IOOO;
            if (i < objArr.length) {
                return IXxxXO(objArr[i]);
            }
            return null;
        }
        return IXxxXO(obj);
    }

    @Override // oO0IXx.IIX0o
    public xXxxox0I<?> II0XooXoX(Object obj) {
        II0xO0 Oxx0xo2 = Oxx0xo(obj);
        this.f31902X0o0xo = Oxx0xo2;
        if (Oxx0xo2 != null) {
            return Oxx0xo2.f31908oIX0oI;
        }
        return null;
    }

    @Override // oO0IXx.IIX0o
    public String[] II0xO0() {
        II0xO0 iI0xO0 = this.f31902X0o0xo;
        if (iI0xO0 != null) {
            return iI0xO0.f31907II0xO0;
        }
        return null;
    }

    public final int IIXOooo(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException("Column index must be positive");
    }

    public final String[] IXxxXO(Object obj) {
        for (int i = 0; i < this.f31904oxoX.length; i++) {
            II0xO0 Oxx0xo2 = Oxx0xo(obj);
            if (Oxx0xo2 != null) {
                return Oxx0xo2.f31907II0xO0;
            }
        }
        return null;
    }

    public void O0xOxO(xXxxox0I<Object[]> xxxxox0i, String... strArr) {
        this.f31899I0Io = new II0xO0(xxxxox0i, strArr, null, null);
    }

    public <T> void OOXIXo(Class<T> cls, int... iArr) {
        xxIXOIIO(new II0xO0(null, iArr, cls));
    }

    public int Oo() {
        return this.f31901Oxx0IOOO;
    }

    public void OxI(xXxxox0I<Object[]> xxxxox0i, int... iArr) {
        this.f31899I0Io = new II0xO0(xxxxox0i, null, iArr, null);
    }

    public final II0xO0 Oxx0xo(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            int i = this.f31901Oxx0IOOO;
            if (length < i) {
                return this.f31899I0Io;
            }
            obj = objArr[i];
        }
        int i2 = 0;
        while (true) {
            II0xO0[] iI0xO0Arr = this.f31904oxoX;
            if (i2 < iI0xO0Arr.length) {
                II0xO0 iI0xO0 = iI0xO0Arr[i2];
                Class cls = this.f31903XO[i2];
                if (cls != null) {
                    if (cls.isAssignableFrom(obj.getClass())) {
                        return iI0xO0;
                    }
                } else if (this.f31905xxIXOIIO.compare(obj, iI0xO0.f31909oxoX) == 0) {
                    return iI0xO0;
                }
                i2++;
            } else {
                return this.f31899I0Io;
            }
        }
    }

    public final String OxxIIOOXO(String str) {
        if (str != null && str.trim().length() != 0) {
            return str;
        }
        throw new IllegalArgumentException("Header name cannot be blank");
    }

    @Override // oO0IXx.IIX0o
    public int[] X0o0xo() {
        II0xO0 iI0xO0 = this.f31902X0o0xo;
        if (iI0xO0 != null) {
            return iI0xO0.f31906I0Io;
        }
        return null;
    }

    public void o00(Comparator<?> comparator) {
        if (comparator != null) {
            this.f31905xxIXOIIO = comparator;
            return;
        }
        throw new IllegalArgumentException("Comparator must not be null");
    }

    public final List<Object> oI0IIXIo() {
        ArrayList arrayList = new ArrayList(this.f31904oxoX.length);
        for (II0xO0 iI0xO0 : this.f31904oxoX) {
            arrayList.add(iI0xO0.f31909oxoX);
        }
        return arrayList;
    }

    @Override // oO0IXx.IIX0o
    public String oIX0oI() {
        return "Expecting one of values: " + oI0IIXIo() + " at column index " + Oo();
    }

    public void oO(Object obj, xXxxox0I<Object[]> xxxxox0i, int... iArr) {
        xxIXOIIO(new II0xO0(xxxxox0i, null, iArr, obj));
    }

    public <T> void ooOOo0oXI(Class<T> cls, String... strArr) {
        xxIXOIIO(new II0xO0(strArr, null, cls));
    }

    @Override // oO0IXx.IIX0o
    public String[] oxoX(Map map, Map map2) {
        Object obj = null;
        if (map2 != null && !map2.isEmpty()) {
            Object obj2 = this.f31900II0XooXoX;
            if (map != null) {
                if (obj2 != null) {
                    Object obj3 = map.get(obj2);
                    if (obj3 != null) {
                        obj = obj3.toString();
                    }
                } else {
                    int i = this.f31901Oxx0IOOO;
                    if (i != -1) {
                        Object xoXoI2 = xoXoI(map, i);
                        if (xoXoI2 != null) {
                            obj = xoXoI2.toString();
                        }
                    }
                }
                obj2 = obj;
            }
            obj = obj2 != null ? map2.get(obj2) : xoXoI(map2, this.f31901Oxx0IOOO);
        }
        return IXxxXO(obj);
    }

    public void x0XOIxOo(Object obj, xXxxox0I<Object[]> xxxxox0i) {
        xxIXOIIO(new II0xO0(xxxxox0i, null, null, obj));
    }

    public void x0xO0oo(Object obj, xXxxox0I<Object[]> xxxxox0i, String... strArr) {
        xxIXOIIO(new II0xO0(xxxxox0i, strArr, null, obj));
    }

    public <T> void xoIox(Class<T> cls) {
        xxIXOIIO(new II0xO0(null, null, cls));
    }

    public final <V> V xoXoI(Map<?, V> map, int i) {
        for (Map.Entry<?, V> entry : map.entrySet()) {
            if (i == 0) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final void xxIXOIIO(II0xO0 iI0xO0) {
        II0xO0[] iI0xO0Arr = this.f31904oxoX;
        II0xO0[] iI0xO0Arr2 = (II0xO0[]) Arrays.copyOf(iI0xO0Arr, iI0xO0Arr.length + 1);
        this.f31904oxoX = iI0xO0Arr2;
        iI0xO0Arr2[iI0xO0Arr2.length - 1] = iI0xO0;
        Class[] clsArr = this.f31903XO;
        this.f31903XO = (Class[]) Arrays.copyOf(clsArr, clsArr.length + 1);
        Object obj = iI0xO0.f31909oxoX;
        if (obj != null && obj.getClass() == Class.class) {
            this.f31903XO[r0.length - 1] = (Class) iI0xO0.f31909oxoX;
        }
    }

    public XI0IXoo(int i) {
        this.f31904oxoX = new II0xO0[0];
        this.f31903XO = new Class[0];
        this.f31905xxIXOIIO = new oIX0oI();
        this.f31901Oxx0IOOO = IIXOooo(i);
        this.f31900II0XooXoX = null;
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final int[] f31906I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String[] f31907II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final xXxxox0I<Object[]> f31908oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final Object f31909oxoX;

        public II0xO0(xXxxox0I<Object[]> xxxxox0i, String[] strArr, int[] iArr, Object obj) {
            this.f31908oIX0oI = xxxxox0i;
            this.f31907II0xO0 = (strArr == null || strArr.length == 0) ? null : strArr;
            this.f31906I0Io = (iArr == null || iArr.length == 0) ? null : iArr;
            this.f31909oxoX = obj;
        }

        public II0xO0(String[] strArr, int[] iArr, Class<?> cls) {
            this.f31908oIX0oI = new II0XooXoX(cls);
            if (strArr == null && iArr == null) {
                strArr = x0OOI.oIX0oI.X0o0xo(cls);
                iArr = com.univocity.parsers.common.I0Io.xoXoI(Arrays.asList(x0OOI.oIX0oI.x0xO0oo(cls)));
            }
            this.f31907II0xO0 = (strArr == null || strArr.length == 0) ? null : strArr;
            this.f31906I0Io = (iArr == null || iArr.length == 0) ? null : iArr;
            this.f31909oxoX = cls;
        }
    }

    public XI0IXoo(String str) {
        this.f31904oxoX = new II0xO0[0];
        this.f31903XO = new Class[0];
        this.f31905xxIXOIIO = new oIX0oI();
        this.f31900II0XooXoX = OxxIIOOXO(str);
        this.f31901Oxx0IOOO = 0;
    }

    public XI0IXoo(String str, int i) {
        this.f31904oxoX = new II0xO0[0];
        this.f31903XO = new Class[0];
        this.f31905xxIXOIIO = new oIX0oI();
        this.f31901Oxx0IOOO = IIXOooo(i);
        this.f31900II0XooXoX = OxxIIOOXO(str);
    }
}
