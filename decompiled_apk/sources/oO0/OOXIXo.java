package oO0;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes6.dex */
public class OOXIXo<K, V> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f31842IIXOooo = 4;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static Object[] f31843O0xOxO = null;

    /* renamed from: OxI, reason: collision with root package name */
    public static int f31844OxI = 0;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final boolean f31845Oxx0xo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final boolean f31846OxxIIOOXO = true;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static int f31847X0IIOO = 0;

    /* renamed from: o00, reason: collision with root package name */
    public static Object[] f31848o00 = null;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f31849oI0IIXIo = "ArrayMap";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f31850xoXoI = 10;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f31851IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Object[] f31852Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int[] f31853XO;

    public OOXIXo() {
        this.f31853XO = xxIXOIIO.f31871oIX0oI;
        this.f31852Oo = xxIXOIIO.f31869I0Io;
        this.f31851IXxxXO = 0;
    }

    public static int II0xO0(int[] iArr, int i, int i2) {
        try {
            return xxIXOIIO.oIX0oI(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void X0o0xo(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (II0XooXoX.class) {
                try {
                    if (f31847X0IIOO < 10) {
                        objArr[0] = f31843O0xOxO;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f31843O0xOxO = objArr;
                        f31847X0IIOO++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (II0XooXoX.class) {
                try {
                    if (f31844OxI < 10) {
                        objArr[0] = f31848o00;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f31848o00 = objArr;
                        f31844OxI++;
                    }
                } finally {
                }
            }
        }
    }

    public int II0XooXoX() {
        int i = this.f31851IXxxXO;
        if (i == 0) {
            return -1;
        }
        int II0xO02 = II0xO0(this.f31853XO, i, 0);
        if (II0xO02 < 0) {
            return II0xO02;
        }
        if (this.f31852Oo[II0xO02 << 1] == null) {
            return II0xO02;
        }
        int i2 = II0xO02 + 1;
        while (i2 < i && this.f31853XO[i2] == 0) {
            if (this.f31852Oo[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = II0xO02 - 1; i3 >= 0 && this.f31853XO[i3] == 0; i3--) {
            if (this.f31852Oo[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public void OOXIXo(OOXIXo<? extends K, ? extends V> oOXIXo) {
        int i = oOXIXo.f31851IXxxXO;
        oxoX(this.f31851IXxxXO + i);
        if (this.f31851IXxxXO == 0) {
            if (i > 0) {
                System.arraycopy(oOXIXo.f31853XO, 0, this.f31853XO, 0, i);
                System.arraycopy(oOXIXo.f31852Oo, 0, this.f31852Oo, 0, i << 1);
                this.f31851IXxxXO = i;
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            put(oOXIXo.xoIox(i2), oOXIXo.x0XOIxOo(i2));
        }
    }

    public int Oxx0IOOO(Object obj) {
        if (obj == null) {
            return II0XooXoX();
        }
        return XO(obj, obj.hashCode());
    }

    public int XO(Object obj, int i) {
        int i2 = this.f31851IXxxXO;
        if (i2 == 0) {
            return -1;
        }
        int II0xO02 = II0xO0(this.f31853XO, i2, i);
        if (II0xO02 < 0) {
            return II0xO02;
        }
        if (obj.equals(this.f31852Oo[II0xO02 << 1])) {
            return II0xO02;
        }
        int i3 = II0xO02 + 1;
        while (i3 < i2 && this.f31853XO[i3] == i) {
            if (obj.equals(this.f31852Oo[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = II0xO02 - 1; i4 >= 0 && this.f31853XO[i4] == i; i4--) {
            if (obj.equals(this.f31852Oo[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public void clear() {
        int i = this.f31851IXxxXO;
        if (i > 0) {
            int[] iArr = this.f31853XO;
            Object[] objArr = this.f31852Oo;
            this.f31853XO = xxIXOIIO.f31871oIX0oI;
            this.f31852Oo = xxIXOIIO.f31869I0Io;
            this.f31851IXxxXO = 0;
            X0o0xo(iArr, objArr, i);
        }
        if (this.f31851IXxxXO <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        if (Oxx0IOOO(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (xxIXOIIO(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OOXIXo) {
            OOXIXo oOXIXo = (OOXIXo) obj;
            if (size() != oOXIXo.size()) {
                return false;
            }
            for (int i = 0; i < this.f31851IXxxXO; i++) {
                try {
                    K xoIox2 = xoIox(i);
                    V x0XOIxOo2 = x0XOIxOo(i);
                    Object obj2 = oOXIXo.get(xoIox2);
                    if (x0XOIxOo2 == null) {
                        if (obj2 != null || !oOXIXo.containsKey(xoIox2)) {
                            return false;
                        }
                    } else if (!x0XOIxOo2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f31851IXxxXO; i2++) {
                try {
                    K xoIox3 = xoIox(i2);
                    V x0XOIxOo3 = x0XOIxOo(i2);
                    Object obj3 = map.get(xoIox3);
                    if (x0XOIxOo3 == null) {
                        if (obj3 != null || !map.containsKey(xoIox3)) {
                            return false;
                        }
                    } else if (!x0XOIxOo3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int Oxx0IOOO2 = Oxx0IOOO(obj);
        if (Oxx0IOOO2 >= 0) {
            return (V) this.f31852Oo[(Oxx0IOOO2 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.f31853XO;
        Object[] objArr = this.f31852Oo;
        int i = this.f31851IXxxXO;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            int i5 = iArr[i3];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i4 += hashCode ^ i5;
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        if (this.f31851IXxxXO <= 0) {
            return true;
        }
        return false;
    }

    public final void oIX0oI(int i) {
        if (i == 8) {
            synchronized (II0XooXoX.class) {
                try {
                    Object[] objArr = f31843O0xOxO;
                    if (objArr != null) {
                        this.f31852Oo = objArr;
                        f31843O0xOxO = (Object[]) objArr[0];
                        this.f31853XO = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f31847X0IIOO--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (II0XooXoX.class) {
                try {
                    Object[] objArr2 = f31848o00;
                    if (objArr2 != null) {
                        this.f31852Oo = objArr2;
                        f31848o00 = (Object[]) objArr2[0];
                        this.f31853XO = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f31844OxI--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f31853XO = new int[i];
        this.f31852Oo = new Object[i << 1];
    }

    public V oOoXoXO(int i) {
        Object[] objArr = this.f31852Oo;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.f31851IXxxXO;
        int i4 = 0;
        if (i3 <= 1) {
            X0o0xo(this.f31853XO, objArr, i3);
            this.f31853XO = xxIXOIIO.f31871oIX0oI;
            this.f31852Oo = xxIXOIIO.f31869I0Io;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f31853XO;
            int i6 = 8;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                oIX0oI(i6);
                if (i3 == this.f31851IXxxXO) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.f31853XO, 0, i);
                        System.arraycopy(objArr, 0, this.f31852Oo, 0, i2);
                    }
                    if (i < i5) {
                        int i7 = i + 1;
                        int i8 = i5 - i;
                        System.arraycopy(iArr, i7, this.f31853XO, i, i8);
                        System.arraycopy(objArr, i7 << 1, this.f31852Oo, i2, i8 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, iArr, i, i10);
                    Object[] objArr2 = this.f31852Oo;
                    System.arraycopy(objArr2, i9 << 1, objArr2, i2, i10 << 1);
                }
                Object[] objArr3 = this.f31852Oo;
                int i11 = i5 << 1;
                objArr3[i11] = null;
                objArr3[i11 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 == this.f31851IXxxXO) {
            this.f31851IXxxXO = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V ooOOo0oXI(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f31852Oo;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public void oxoX(int i) {
        int i2 = this.f31851IXxxXO;
        int[] iArr = this.f31853XO;
        if (iArr.length < i) {
            Object[] objArr = this.f31852Oo;
            oIX0oI(i);
            if (this.f31851IXxxXO > 0) {
                System.arraycopy(iArr, 0, this.f31853XO, 0, i2);
                System.arraycopy(objArr, 0, this.f31852Oo, 0, i2 << 1);
            }
            X0o0xo(iArr, objArr, i2);
        }
        if (this.f31851IXxxXO == i2) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public V put(K k, V v) {
        int i;
        int XO2;
        int i2 = this.f31851IXxxXO;
        if (k == null) {
            XO2 = II0XooXoX();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            XO2 = XO(k, hashCode);
        }
        if (XO2 >= 0) {
            int i3 = (XO2 << 1) + 1;
            Object[] objArr = this.f31852Oo;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~XO2;
        int[] iArr = this.f31853XO;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.f31852Oo;
            oIX0oI(i5);
            if (i2 == this.f31851IXxxXO) {
                int[] iArr2 = this.f31853XO;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f31852Oo, 0, objArr2.length);
                }
                X0o0xo(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.f31853XO;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f31852Oo;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f31851IXxxXO - i4) << 1);
        }
        int i7 = this.f31851IXxxXO;
        if (i2 == i7) {
            int[] iArr4 = this.f31853XO;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f31852Oo;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f31851IXxxXO = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int Oxx0IOOO2 = Oxx0IOOO(obj);
        if (Oxx0IOOO2 >= 0) {
            return oOoXoXO(Oxx0IOOO2);
        }
        return null;
    }

    public int size() {
        return this.f31851IXxxXO;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f31851IXxxXO * 28);
        sb.append('{');
        for (int i = 0; i < this.f31851IXxxXO; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K xoIox2 = xoIox(i);
            if (xoIox2 != this) {
                sb.append(xoIox2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V x0XOIxOo2 = x0XOIxOo(i);
            if (x0XOIxOo2 != this) {
                sb.append(x0XOIxOo2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V x0XOIxOo(int i) {
        return (V) this.f31852Oo[(i << 1) + 1];
    }

    public K xoIox(int i) {
        return (K) this.f31852Oo[i << 1];
    }

    public int xxIXOIIO(Object obj) {
        int i = this.f31851IXxxXO * 2;
        Object[] objArr = this.f31852Oo;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public OOXIXo(int i) {
        if (i == 0) {
            this.f31853XO = xxIXOIIO.f31871oIX0oI;
            this.f31852Oo = xxIXOIIO.f31869I0Io;
        } else {
            oIX0oI(i);
        }
        this.f31851IXxxXO = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OOXIXo(OOXIXo<K, V> oOXIXo) {
        this();
        if (oOXIXo != 0) {
            OOXIXo(oOXIXo);
        }
    }
}
