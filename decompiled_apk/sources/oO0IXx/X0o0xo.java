package oO0IXx;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.univocity.parsers.common.DataProcessingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes13.dex */
public abstract class X0o0xo<T> extends com.univocity.parsers.common.II0XooXoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final Class<T> f31891II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public x0OOI.II0xO0[] f31892OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public Object[] f31893oO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final Set<x0OOI.II0xO0> f31898xxIXOIIO = new LinkedHashSet();

    /* renamed from: xoIox, reason: collision with root package name */
    public int f31897xoIox = -1;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f31894oOoXoXO = false;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f31895ooOOo0oXI = false;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String[] f31896x0XOIxOo = null;

    public X0o0xo(Class<T> cls) {
        this.f31891II0XooXoX = cls;
    }

    public static String XIxXXX0x0(Field field) {
        return "field '" + field.getName() + "' (" + field.getType().getName() + HexStringBuilder.COMMENT_END_CHAR;
    }

    public boolean IIX0o() {
        return this.f31895ooOOo0oXI;
    }

    public void IO() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashSet<x0OOI.II0xO0> hashSet = new HashSet();
        HashSet<x0OOI.II0xO0> hashSet2 = new HashSet();
        for (x0OOI.II0xO0 iI0xO0 : this.f31898xxIXOIIO) {
            String oxoX2 = iI0xO0.oxoX();
            int Oxx0IOOO2 = iI0xO0.Oxx0IOOO();
            if (Oxx0IOOO2 != -1) {
                if (hashMap2.containsKey(Integer.valueOf(Oxx0IOOO2))) {
                    hashSet2.add(iI0xO0);
                    hashSet2.add(hashMap2.get(Integer.valueOf(Oxx0IOOO2)));
                } else {
                    hashMap2.put(Integer.valueOf(Oxx0IOOO2), iI0xO0);
                }
            } else if (hashMap.containsKey(oxoX2)) {
                hashSet.add(iI0xO0);
                hashSet.add(hashMap.get(oxoX2));
            } else {
                hashMap.put(oxoX2, iI0xO0);
            }
        }
        if (hashSet2.size() <= 0 && hashSet.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("Conflicting field mappings defined in annotated class: " + xxX().getName());
        for (x0OOI.II0xO0 iI0xO02 : hashSet2) {
            sb.append("\n\tIndex: '");
            sb.append(iI0xO02.Oxx0IOOO());
            sb.append("' of  ");
            sb.append(XIxXXX0x0(iI0xO02.I0Io()));
        }
        for (x0OOI.II0xO0 iI0xO03 : hashSet) {
            sb.append("\n\tName: '");
            sb.append(iI0xO03.oxoX());
            sb.append("' of ");
            sb.append(XIxXXX0x0(iI0xO03.I0Io()));
        }
        throw new DataProcessingException(sb.toString());
    }

    public boolean IoOoX(x0OOI.II0xO0 iI0xO0) {
        return true;
    }

    public final void O0xOxO(xXo.Oxx0IOOO oxx0IOOO, x0OOI.II0xO0 iI0xO0) {
        if (oxx0IOOO == null) {
            return;
        }
        if (iI0xO0.xxIXOIIO()) {
            oIX0oI(oxx0IOOO).oxoX(Integer.valueOf(iI0xO0.Oxx0IOOO()));
        } else {
            oxoX(oxx0IOOO).oxoX(iI0xO0.oxoX());
        }
    }

    public final void X00IoxXI(Field field, x0OOI.II0xO0 iI0xO0) {
        xXo.Oxx0IOOO oxx0IOOO = null;
        for (Annotation annotation : field.getAnnotations()) {
            try {
                xXo.Oxx0IOOO xoIox2 = x0OOI.oIX0oI.xoIox(field, annotation);
                if (xoIox2 != null) {
                    O0xOxO(xoIox2, iI0xO0);
                    oxx0IOOO = xoIox2;
                }
            } catch (Throwable th) {
                throw new DataProcessingException("Error processing annotation '" + (annotation.annotationType().getSimpleName() + "' of field '" + field.getName() + "' in " + this.f31891II0XooXoX.getName()) + ". " + th.getMessage(), th);
            }
        }
        if (((OIxOX.II0XooXoX) field.getAnnotation(OIxOX.II0XooXoX.class)).applyDefaultConversion()) {
            xXo.Oxx0IOOO oOoXoXO2 = x0OOI.oIX0oI.oOoXoXO(field);
            if (X0IIOO(oxx0IOOO, oOoXoXO2)) {
                O0xOxO(oOoXoXO2, iI0xO0);
            }
        }
    }

    public final boolean X0IIOO(xXo.Oxx0IOOO oxx0IOOO, xXo.Oxx0IOOO oxx0IOOO2) {
        if (oxx0IOOO2 == null) {
            return false;
        }
        if (oxx0IOOO == null) {
            return true;
        }
        if (oxx0IOOO.getClass() == oxx0IOOO2.getClass()) {
            return false;
        }
        Method XxX0x0xxx2 = XxX0x0xxx(oxx0IOOO, "execute");
        Method XxX0x0xxx3 = XxX0x0xxx(oxx0IOOO, "revert");
        Method XxX0x0xxx4 = XxX0x0xxx(oxx0IOOO2, "execute");
        Method XxX0x0xxx5 = XxX0x0xxx(oxx0IOOO2, "revert");
        if (XxX0x0xxx2.getReturnType() == XxX0x0xxx4.getReturnType() && XxX0x0xxx3.getReturnType() == XxX0x0xxx5.getReturnType()) {
            return false;
        }
        return true;
    }

    public T XI0IXoo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        Object[] Oxx0xo2 = super.Oxx0xo(strArr, oOVar);
        if (Oxx0xo2 == null) {
            return null;
        }
        try {
            T newInstance = this.f31891II0XooXoX.newInstance();
            oo0xXOI0I(newInstance, Oxx0xo2, oOVar);
            return newInstance;
        } catch (Throwable th) {
            throw new DataProcessingException("Unable to instantiate class '" + this.f31891II0XooXoX.getName() + '\'', strArr, th);
        }
    }

    public void Xx000oIo(boolean z) {
        this.f31895ooOOo0oXI = z;
    }

    public final Method XxX0x0xxx(xXo.Oxx0IOOO oxx0IOOO, String str) {
        Method method = null;
        for (Method method2 : oxx0IOOO.getClass().getMethods()) {
            if (method2.getName().equals(str) && !method2.isSynthetic() && !method2.isBridge() && (method2.getModifiers() & 1) == 1 && method2.getParameterTypes().length == 1 && method2.getReturnType() != Void.class) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new DataProcessingException("Unable to convert values for class '" + this.f31891II0XooXoX + "'. Multiple '" + str + "' methods defined in conversion " + oxx0IOOO.getClass() + '.');
                }
            }
        }
        if (method != null) {
            return method;
        }
        throw new DataProcessingException("Unable to convert values for class '" + this.f31891II0XooXoX + "'. Cannot find method '" + str + "' in conversion " + oxx0IOOO.getClass() + '.');
    }

    public final Object[] oOXoIIIo(T t, String[] strArr, int[] iArr) {
        if (t == null) {
            return null;
        }
        if (this.f31893oO == null) {
            if (strArr != null) {
                this.f31893oO = new Object[strArr.length];
            } else if (iArr != null) {
                int i = 0;
                for (int i2 : iArr) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        i = i3;
                    }
                }
                if (i < iArr.length) {
                    i = iArr.length;
                }
                this.f31893oO = new Object[i];
            } else {
                HashSet hashSet = new HashSet();
                int i4 = -1;
                for (x0OOI.II0xO0 iI0xO0 : this.f31898xxIXOIIO) {
                    if (i4 < iI0xO0.Oxx0IOOO() + 1) {
                        i4 = iI0xO0.Oxx0IOOO() + 1;
                    }
                    hashSet.add(Integer.valueOf(iI0xO0.Oxx0IOOO()));
                }
                if (i4 < this.f31898xxIXOIIO.size()) {
                    i4 = this.f31898xxIXOIIO.size();
                }
                this.f31893oO = new Object[i4];
                if (this.f31896x0XOIxOo == null) {
                    this.f31896x0XOIxOo = new String[i4];
                    Iterator<x0OOI.II0xO0> it = this.f31898xxIXOIIO.iterator();
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (!hashSet.contains(Integer.valueOf(i5))) {
                            String str = null;
                            while (it.hasNext() && (str = it.next().oxoX()) == null) {
                            }
                            this.f31896x0XOIxOo[i5] = str;
                        }
                    }
                }
            }
        }
        String[] strArr2 = this.f31896x0XOIxOo;
        if (strArr2 != null) {
            strArr = strArr2;
        }
        try {
            xI(t, this.f31893oO, strArr, iArr, false);
            if (!super.OxI(true, this.f31893oO, strArr, iArr)) {
                return null;
            }
            return this.f31893oO;
        } catch (DataProcessingException e) {
            e.markAsNonFatal();
            if (!this.f31891II0XooXoX.isAssignableFrom(t.getClass())) {
                xoXoI(e, new Object[]{t}, -1);
            } else {
                xoXoI(e, this.f31893oO, -1);
            }
            return null;
        }
    }

    public void oo(Field field, IXoIo.II0xO0 iI0xO0) {
        if (((OIxOX.II0XooXoX) field.getAnnotation(OIxOX.II0XooXoX.class)) != null) {
            x0OOI.II0xO0 iI0xO02 = new x0OOI.II0xO0(this.f31891II0XooXoX, field, iI0xO0);
            if (IoOoX(iI0xO02)) {
                this.f31898xxIXOIIO.add(iI0xO02);
                X00IoxXI(field, iI0xO02);
            }
        }
    }

    public void oo0xXOI0I(T t, Object[] objArr, com.univocity.parsers.common.oO oOVar) {
        int length;
        if (objArr.length > this.f31897xoIox) {
            this.f31897xoIox = objArr.length;
            ooXIXxIX(oOVar, objArr, oOVar.X0o0xo(), oOVar.x0XOIxOo(), oOVar.oOoXoXO());
        }
        int length2 = objArr.length;
        x0OOI.II0xO0[] iI0xO0Arr = this.f31892OOXIXo;
        if (length2 < iI0xO0Arr.length) {
            length = objArr.length;
        } else {
            length = iI0xO0Arr.length;
        }
        for (int i = 0; i < length; i++) {
            x0OOI.II0xO0 iI0xO0 = this.f31892OOXIXo[i];
            if (iI0xO0 != null) {
                iI0xO0.oOoXoXO(t, objArr[i]);
            }
        }
    }

    public final void ooXIXxIX(com.univocity.parsers.common.oO oOVar, Object[] objArr, String[] strArr, int[] iArr, boolean z) {
        int length;
        if (strArr == null) {
            strArr = com.univocity.parsers.common.I0Io.f27012oIX0oI;
        }
        if (strArr.length > objArr.length) {
            length = strArr.length;
        } else {
            length = objArr.length;
        }
        Iterator<x0OOI.II0xO0> it = this.f31898xxIXOIIO.iterator();
        while (it.hasNext()) {
            int Oxx0IOOO2 = it.next().Oxx0IOOO();
            if (length < Oxx0IOOO2) {
                length = Oxx0IOOO2;
            }
        }
        int i = length + 1;
        x0OOI.II0xO0[] iI0xO0Arr = new x0OOI.II0xO0[i];
        TreeSet treeSet = new TreeSet();
        for (x0OOI.II0xO0 iI0xO0 : this.f31898xxIXOIIO) {
            if (iI0xO0.II0XooXoX()) {
                int I0Io2 = com.univocity.parsers.common.I0Io.I0Io(strArr, iI0xO0.oxoX());
                if (I0Io2 == -1) {
                    treeSet.add(iI0xO0.oxoX());
                } else {
                    iI0xO0Arr[I0Io2] = iI0xO0;
                }
            } else if (iI0xO0.Oxx0IOOO() < i) {
                iI0xO0Arr[iI0xO0.Oxx0IOOO()] = iI0xO0;
            }
        }
        if (oOVar != null && !treeSet.isEmpty()) {
            if (strArr.length != 0) {
                if (this.f31895ooOOo0oXI) {
                    throw new DataProcessingException("Could not find fields " + treeSet.toString() + "' in input. Names found: " + Arrays.toString(strArr));
                }
            } else {
                throw new DataProcessingException("Could not find fields " + treeSet.toString() + " in input. Please enable header extraction in the parser settings in order to match field names.");
            }
        }
        if (iArr != null) {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 < iArr.length) {
                        if (iArr[i3] == i2) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        iI0xO0Arr[i2] = null;
                        break;
                    }
                }
            }
            if (z) {
                x0OOI.II0xO0[] iI0xO0Arr2 = new x0OOI.II0xO0[iArr.length];
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        iI0xO0Arr2[i4] = iI0xO0Arr[iArr[i4]];
                    }
                }
                iI0xO0Arr = iI0xO0Arr2;
            }
        }
        this.f31892OOXIXo = iI0xO0Arr;
    }

    public final void xI(T t, Object[] objArr, String[] strArr, int[] iArr, boolean z) {
        int length;
        if (objArr.length > this.f31897xoIox) {
            ooXIXxIX(null, objArr, strArr, iArr, z);
        }
        int length2 = objArr.length;
        x0OOI.II0xO0[] iI0xO0Arr = this.f31892OOXIXo;
        if (length2 < iI0xO0Arr.length) {
            length = objArr.length;
        } else {
            length = iI0xO0Arr.length;
        }
        for (int i = 0; i < length; i++) {
            x0OOI.II0xO0 iI0xO0 = this.f31892OOXIXo[i];
            if (iI0xO0 != null) {
                objArr[i] = iI0xO0.xoIox(t);
            }
        }
    }

    public final void xXxxox0I() {
        if (!this.f31894oOoXoXO) {
            this.f31894oOoXoXO = true;
            for (Map.Entry<Field, IXoIo.II0xO0> entry : x0OOI.oIX0oI.Oxx0IOOO(this.f31891II0XooXoX).entrySet()) {
                oo(entry.getKey(), entry.getValue());
            }
            this.f31892OOXIXo = null;
            this.f31897xoIox = -1;
            IO();
        }
    }

    public Class<T> xxX() {
        return this.f31891II0XooXoX;
    }
}
