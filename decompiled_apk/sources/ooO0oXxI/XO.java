package ooO0oXxI;

import OXIOoo0X0.OOXIXo;
import com.univocity.parsers.common.oO;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import xXo.Oxx0IOOO;

/* loaded from: classes13.dex */
public class XO implements X0o0xo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ooO0oXxI.oIX0oI[] f32293X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oO f32295oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Map<Class, Oxx0IOOO> f32292II0xO0 = new HashMap();

    /* renamed from: I0Io, reason: collision with root package name */
    public Map<Class, Map<Annotation, Oxx0IOOO>> f32291I0Io = new HashMap();

    /* renamed from: oxoX, reason: collision with root package name */
    public Map<Integer, Annotation> f32296oxoX = new HashMap();

    /* renamed from: XO, reason: collision with root package name */
    public OXIOoo0X0.XO f32294XO = null;

    /* loaded from: classes13.dex */
    public static class II0xO0 implements OIxOX.oxoX {

        /* renamed from: oO, reason: collision with root package name */
        public final /* synthetic */ String f32297oO;

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public final /* synthetic */ String[] f32298x0xO0oo;

        public II0xO0(String str, String[] strArr) {
            this.f32297oO = str;
            this.f32298x0xO0oo = strArr;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return OIxOX.oxoX.class;
        }

        @Override // OIxOX.oxoX
        public String[] formats() {
            return new String[]{this.f32297oO};
        }

        @Override // OIxOX.oxoX
        public String[] options() {
            return this.f32298x0xO0oo;
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI implements OIxOX.oIX0oI {

        /* renamed from: oO, reason: collision with root package name */
        public final /* synthetic */ String[] f32299oO;

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public final /* synthetic */ String[] f32300x0xO0oo;

        public oIX0oI(String[] strArr, String[] strArr2) {
            this.f32299oO = strArr;
            this.f32300x0xO0oo = strArr2;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return OIxOX.oIX0oI.class;
        }

        @Override // OIxOX.oIX0oI
        public String[] falseStrings() {
            String[] strArr = this.f32300x0xO0oo;
            if (strArr == null) {
                return com.univocity.parsers.common.I0Io.f27012oIX0oI;
            }
            return strArr;
        }

        @Override // OIxOX.oIX0oI
        public String[] trueStrings() {
            String[] strArr = this.f32299oO;
            if (strArr == null) {
                return com.univocity.parsers.common.I0Io.f27012oIX0oI;
            }
            return strArr;
        }
    }

    public XO(oO oOVar) {
        this.f32295oIX0oI = oOVar;
    }

    public static Annotation I0oOoX(String str, String... strArr) {
        return new II0xO0(str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object OxI(ooO0oXxI.oIX0oI oix0oi, String[] strArr, Oxx0IOOO[] oxx0IOOOArr) {
        String str = strArr[oix0oi.f32303oIX0oI];
        int i = 0;
        String str2 = str;
        while (i < oxx0IOOOArr.length) {
            Object II0xO02 = oxx0IOOOArr[i].II0xO0(str2);
            i++;
            str2 = II0xO02;
        }
        return str2;
    }

    public static Annotation OxxIIOOXO(String[] strArr, String[] strArr2) {
        return new oIX0oI(strArr, strArr2);
    }

    @Override // ooO0oXxI.X0o0xo
    public int I0Io(Enum<?> r1) {
        return XI0IXoo(r1).f32303oIX0oI;
    }

    @Override // ooO0oXxI.X0o0xo
    public Class<?> II0XooXoX(Enum<?> r1) {
        return XI0IXoo(r1).f32302II0xO0;
    }

    @Override // ooO0oXxI.X0o0xo
    public int II0xO0(String str) {
        return XIxXXX0x0(str).f32303oIX0oI;
    }

    public <T> T IIX0o(String[] strArr, Enum<?> r8, Class<T> cls, T t, String str, String... strArr2) {
        if (str == null) {
            return (T) xXxxox0I(strArr, r8, cls, t);
        }
        return (T) IIXOooo(o0(r8), strArr, cls, t, oI0IIXIo(cls, str, strArr2));
    }

    public final <T> T IIXOooo(ooO0oXxI.oIX0oI oix0oi, String[] strArr, Class<T> cls, T t, Annotation annotation) {
        Oxx0IOOO oxx0IOOO;
        String str = strArr[oix0oi.f32303oIX0oI];
        T t2 = str;
        if (str == null) {
            if (t == null) {
                t2 = (T) oix0oi.f32301I0Io;
            } else {
                t2 = t;
            }
        }
        if (annotation == null) {
            OI0(strArr, oix0oi);
            t2 = (T) oix0oi.oIX0oI(t2);
            if (t2 == null) {
                if (t == null) {
                    t = (T) oix0oi.f32301I0Io;
                }
                t2 = t;
            }
        }
        if (cls != null) {
            if (t2 != null && cls.isAssignableFrom(t2.getClass())) {
                return (T) t2;
            }
            if (cls != String.class) {
                if (annotation == null) {
                    oxx0IOOO = this.f32292II0xO0.get(cls);
                    if (oxx0IOOO == null) {
                        oxx0IOOO = x0OOI.oIX0oI.OOXIXo(cls, null);
                        this.f32292II0xO0.put(cls, oxx0IOOO);
                    }
                } else {
                    Map<Annotation, Oxx0IOOO> map = this.f32291I0Io.get(cls);
                    if (map == null) {
                        map = new HashMap<>();
                        this.f32291I0Io.put(cls, map);
                    }
                    Oxx0IOOO oxx0IOOO2 = map.get(annotation);
                    if (oxx0IOOO2 == null) {
                        oxx0IOOO2 = x0OOI.oIX0oI.II0XooXoX(cls, annotation);
                        map.put(annotation, oxx0IOOO2);
                    }
                    oxx0IOOO = oxx0IOOO2;
                }
                t2 = (T) oxx0IOOO.II0xO0(t2);
            }
        }
        if (cls == null) {
            return (T) t2;
        }
        try {
            return cls.cast(t2);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("Cannot cast value '" + t2 + "' of type " + t2.getClass().toString() + " to " + cls.getName());
        }
    }

    public <T> T IO(String[] strArr, String str, T t, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) o00(XX(str), strArr, t, oxx0IOOOArr);
    }

    @Override // ooO0oXxI.X0o0xo
    public void IXxxXO(Class<?> cls, int... iArr) {
        for (int i : iArr) {
            X0IIOO(i).f32302II0xO0 = cls;
        }
    }

    public ooO0oXxI.oIX0oI Io(int i) {
        return X0IIOO(i);
    }

    public <T> T IoOoX(String[] strArr, int i, T t, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) o00(Io(i), strArr, t, oxx0IOOOArr);
    }

    public final OXIOoo0X0.XO O0xOxO() {
        if (this.f32294XO == null) {
            this.f32294XO = new OXIOoo0X0.XO();
        }
        return this.f32294XO;
    }

    public final void OI0(String[] strArr, ooO0oXxI.oIX0oI oix0oi) {
        if (this.f32294XO != null) {
            String[] X0o0xo2 = X0o0xo();
            if (X0o0xo2 != null) {
                strArr = X0o0xo2;
            }
            this.f32294XO.Oxx0IOOO(false, strArr);
            oix0oi.I0Io(this.f32294XO.XO(oix0oi.f32303oIX0oI, oix0oi.f32302II0xO0));
        }
    }

    @Override // ooO0oXxI.X0o0xo
    public void OOXIXo(Class<?> cls, String... strArr) {
        for (String str : strArr) {
            XIxXXX0x0(str).f32302II0xO0 = cls;
        }
    }

    @Override // ooO0oXxI.X0o0xo
    public <T> void Oo(T t, Enum<?>... enumArr) {
        for (Enum<?> r0 : enumArr) {
            XI0IXoo(r0).f32301I0Io = t;
        }
    }

    @Override // ooO0oXxI.X0o0xo
    public Class<?> Oxx0IOOO(int i) {
        return X0IIOO(i).f32302II0xO0;
    }

    @Override // ooO0oXxI.X0o0xo
    public <T extends Enum<T>> OOXIXo<T> Oxx0xo(Class<T> cls, Oxx0IOOO... oxx0IOOOArr) {
        return (OOXIXo<T>) O0xOxO().I0Io(oxx0IOOOArr);
    }

    public <T> T X00IoxXI(String[] strArr, String str, Class<T> cls, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) xoXoI(XX(str), strArr, cls, oxx0IOOOArr);
    }

    public ooO0oXxI.oIX0oI X0IIOO(int i) {
        int i2;
        int i3;
        ooO0oXxI.oIX0oI[] oix0oiArr = this.f32293X0o0xo;
        if (oix0oiArr == null || oix0oiArr.length < i) {
            if (oix0oiArr != null) {
                i3 = oix0oiArr.length;
                this.f32293X0o0xo = (ooO0oXxI.oIX0oI[]) Arrays.copyOf(oix0oiArr, i);
                i2 = i;
            } else {
                String[] X0o0xo2 = this.f32295oIX0oI.X0o0xo();
                if (X0o0xo2 != null && i < X0o0xo2.length) {
                    i2 = X0o0xo2.length;
                } else {
                    i2 = i;
                }
                int[] x0XOIxOo2 = this.f32295oIX0oI.x0XOIxOo();
                if (x0XOIxOo2 != null) {
                    for (int i4 : x0XOIxOo2) {
                        if (i2 < i4) {
                            i2 = i4;
                        }
                    }
                }
                this.f32293X0o0xo = new ooO0oXxI.oIX0oI[i2];
                i3 = 0;
            }
            while (i3 < i2) {
                this.f32293X0o0xo[i3] = new ooO0oXxI.oIX0oI(i3);
                i3++;
            }
        }
        return this.f32293X0o0xo[i];
    }

    @Override // ooO0oXxI.X0o0xo
    public String[] X0o0xo() {
        return this.f32295oIX0oI.X0o0xo();
    }

    public final ooO0oXxI.oIX0oI XI0IXoo(Enum<?> r2) {
        String[] X0o0xo2 = this.f32295oIX0oI.X0o0xo();
        if (X0o0xo2 != null && X0o0xo2.length != 0) {
            return X0IIOO(this.f32295oIX0oI.I0Io(r2));
        }
        throw new IllegalStateException("No headers parsed from input nor provided in the user settings. Only index-based operations are available.");
    }

    public final ooO0oXxI.oIX0oI XIxXXX0x0(String str) {
        int II0xO02 = this.f32295oIX0oI.II0xO0(str);
        if (II0xO02 != -1) {
            return X0IIOO(II0xO02);
        }
        oo0xXOI0I();
        throw new IllegalArgumentException("Header name '" + str + "' not found. Available columns are: " + Arrays.asList(X0o0xo()));
    }

    @Override // ooO0oXxI.X0o0xo
    public Object XO(int i) {
        return X0IIOO(i).f32301I0Io;
    }

    public String XOxIOxOx(String[] strArr, String str) {
        int i = XX(str).f32303oIX0oI;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public ooO0oXxI.oIX0oI XX(String str) {
        return XIxXXX0x0(str);
    }

    public <T> T Xx000oIo(String[] strArr, Enum<?> r2, T t, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) o00(o0(r2), strArr, t, oxx0IOOOArr);
    }

    public <T> T XxX0x0xxx(String[] strArr, int i, Class<T> cls, T t, String str, String... strArr2) {
        if (str == null) {
            return (T) xxX(strArr, i, cls, t);
        }
        return (T) IIXOooo(Io(i), strArr, cls, t, oI0IIXIo(cls, str, strArr2));
    }

    public ooO0oXxI.oIX0oI o0(Enum<?> r1) {
        return XI0IXoo(r1);
    }

    public final Object o00(ooO0oXxI.oIX0oI oix0oi, String[] strArr, Object obj, Oxx0IOOO[] oxx0IOOOArr) {
        Object OxI2 = OxI(oix0oi, strArr, oxx0IOOOArr);
        if (OxI2 != null) {
            return OxI2;
        }
        return obj;
    }

    public <T> Annotation oI0IIXIo(Class<T> cls, String str, String... strArr) {
        String[] strArr2;
        Annotation OxxIIOOXO2;
        Integer valueOf = Integer.valueOf((cls.hashCode() * 31) + String.valueOf(str).hashCode() + (Arrays.toString(strArr).hashCode() * 31));
        Annotation annotation = this.f32296oxoX.get(valueOf);
        if (annotation == null) {
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                OxxIIOOXO2 = I0oOoX(str, strArr);
            } else {
                if (str == null) {
                    strArr2 = null;
                } else {
                    strArr2 = new String[]{str};
                }
                OxxIIOOXO2 = OxxIIOOXO(strArr2, strArr);
            }
            annotation = OxxIIOOXO2;
            this.f32296oxoX.put(valueOf, annotation);
        }
        return annotation;
    }

    @Override // ooO0oXxI.X0o0xo
    public OOXIXo<Integer> oIX0oI(Oxx0IOOO... oxx0IOOOArr) {
        return O0xOxO().oxoX(oxx0IOOOArr);
    }

    @Override // ooO0oXxI.X0o0xo
    public <T> void oO(T t, int... iArr) {
        for (int i : iArr) {
            X0IIOO(i).f32301I0Io = t;
        }
    }

    public <T> T oOXoIIIo(String[] strArr, Enum<?> r2, Class<T> cls, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) xoXoI(o0(r2), strArr, cls, oxx0IOOOArr);
    }

    @Override // ooO0oXxI.X0o0xo
    public Class<?> oOoXoXO(String str) {
        return XIxXXX0x0(str).f32302II0xO0;
    }

    public <T> T oo(String[] strArr, int i, Class<T> cls, Oxx0IOOO[] oxx0IOOOArr) {
        return (T) xoXoI(Io(i), strArr, cls, oxx0IOOOArr);
    }

    public final String[] oo0xXOI0I() {
        String[] X0o0xo2 = this.f32295oIX0oI.X0o0xo();
        if (X0o0xo2 != null && X0o0xo2.length != 0) {
            return X0o0xo2;
        }
        throw new IllegalStateException("No headers parsed from input nor provided in the user settings. Only index-based operations are available.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ooO0oXxI.X0o0xo
    public void ooOOo0oXI(Class<?> cls, Enum... enumArr) {
        for (Enum r0 : enumArr) {
            XI0IXoo(r0).f32302II0xO0 = cls;
        }
    }

    public <T> T ooXIXxIX(String[] strArr, String str, Class<T> cls, T t) {
        return (T) IIXOooo(XX(str), strArr, cls, t, null);
    }

    @Override // ooO0oXxI.X0o0xo
    public OOXIXo<String> oxoX(Oxx0IOOO... oxx0IOOOArr) {
        return O0xOxO().X0o0xo(oxx0IOOOArr);
    }

    @Override // ooO0oXxI.X0o0xo
    public <T> void x0XOIxOo(T t, String... strArr) {
        for (String str : strArr) {
            XIxXXX0x0(str).f32301I0Io = t;
        }
    }

    public String x0o(String[] strArr, Enum<?> r2) {
        return strArr[o0(r2).f32303oIX0oI];
    }

    @Override // ooO0oXxI.X0o0xo
    public Object x0xO0oo(Enum<?> r1) {
        return XI0IXoo(r1).f32301I0Io;
    }

    public <T> T xI(String[] strArr, String str, Class<T> cls, T t, String str2, String... strArr2) {
        if (str2 == null) {
            return (T) ooXIXxIX(strArr, str, cls, t);
        }
        return (T) IIXOooo(XX(str), strArr, cls, t, oI0IIXIo(cls, str2, strArr2));
    }

    public String xII(String[] strArr, int i) {
        return strArr[Io(i).f32303oIX0oI];
    }

    public <T> T xXxxox0I(String[] strArr, Enum<?> r8, Class<T> cls, T t) {
        return (T) IIXOooo(o0(r8), strArr, cls, t, null);
    }

    @Override // ooO0oXxI.X0o0xo
    public Object xoIox(String str) {
        return XIxXXX0x0(str).f32301I0Io;
    }

    public final <T> T xoXoI(ooO0oXxI.oIX0oI oix0oi, String[] strArr, Class<T> cls, Oxx0IOOO[] oxx0IOOOArr) {
        return cls.cast(OxI(oix0oi, strArr, oxx0IOOOArr));
    }

    @Override // ooO0oXxI.X0o0xo
    public boolean xxIXOIIO(String str) {
        if (str == null || this.f32295oIX0oI.II0xO0(str) == -1) {
            return false;
        }
        return true;
    }

    public <T> T xxX(String[] strArr, int i, Class<T> cls, T t) {
        return (T) IIXOooo(Io(i), strArr, cls, t, null);
    }
}
