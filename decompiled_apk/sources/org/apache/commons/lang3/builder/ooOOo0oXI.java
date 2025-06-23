package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class ooOOo0oXI extends x0XOIxOo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f32660IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f32661OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public Class<?> f32662o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f32663oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public String[] f32664xoXoI;

    public ooOOo0oXI(Object obj) {
        super(I0oOIX(obj));
        this.f32663oI0IIXIo = false;
        this.f32661OxxIIOOXO = false;
        this.f32662o00 = null;
    }

    public static String I0(Object obj, ToStringStyle toStringStyle, boolean z) {
        return xoO0xx0(obj, toStringStyle, z, false, null);
    }

    public static Object I0oOIX(Object obj) {
        return xoIxX.xo0x(obj, "The Object passed in should not be null.", new Object[0]);
    }

    public static String IIxOXoOo0(Object obj, ToStringStyle toStringStyle) {
        return xoO0xx0(obj, toStringStyle, false, false, null);
    }

    public static String OOXIxO0(Object obj) {
        return xoO0xx0(obj, null, false, false, null);
    }

    public static <T> String OX00O0xII(T t, ToStringStyle toStringStyle, boolean z, boolean z2, boolean z3, Class<? super T> cls) {
        return new ooOOo0oXI(t, toStringStyle, null, cls, z, z2, z3).toString();
    }

    public static String[] XI0oooXX(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj.toString());
            }
        }
        return (String[]) arrayList.toArray(org.apache.commons.lang3.oxoX.f32758OxxIIOOXO);
    }

    public static String ooOx(Object obj, ToStringStyle toStringStyle, boolean z, boolean z2) {
        return xoO0xx0(obj, toStringStyle, z, z2, null);
    }

    public static String[] ox(Collection<String> collection) {
        if (collection == null) {
            return org.apache.commons.lang3.oxoX.f32758OxxIIOOXO;
        }
        return XI0oooXX(collection.toArray());
    }

    public static String xOOOX(Object obj, String... strArr) {
        return new ooOOo0oXI(obj).XX0xXo(strArr).toString();
    }

    public static String xX0IIXIx0(Object obj, Collection<String> collection) {
        return xOOOX(obj, ox(collection));
    }

    public static <T> String xoO0xx0(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        return new ooOOo0oXI(t, toStringStyle, null, cls, z, z2).toString();
    }

    public Object IoOoo(Field field) throws IllegalAccessException {
        return field.get(XoX());
    }

    public void Ioxxx(boolean z) {
        this.f32663oI0IIXIo = z;
    }

    public void O00XxXI(Class<?> cls) {
        Object XoX2;
        if (cls != null && (XoX2 = XoX()) != null && !cls.isInstance(XoX2)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.f32662o00 = cls;
    }

    public void O0Xx(Class<?> cls) {
        Comparator comparing;
        if (cls.isArray()) {
            XIo0oOXIx(XoX());
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        comparing = Comparator.comparing(new II0XooXoX());
        Arrays.sort(declaredFields, comparing);
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (XoI0Ixx0(field)) {
                try {
                    Object IoOoo2 = IoOoo(field);
                    if (!this.f32660IIXOooo || IoOoo2 != null) {
                        oO(name, IoOoo2, !field.isAnnotationPresent(x0xO0oo.class));
                    }
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e.getMessage());
                }
            }
        }
    }

    public Class<?> OO() {
        return this.f32662o00;
    }

    public boolean OO0x0xX() {
        return this.f32660IIXOooo;
    }

    public ooOOo0oXI XIo0oOXIx(Object obj) {
        xo0x().reflectionAppendArrayDetail(oxXx0IX(), null, obj);
        return this;
    }

    public ooOOo0oXI XX0xXo(String... strArr) {
        if (strArr == null) {
            this.f32664xoXoI = null;
        } else {
            String[] XI0oooXX2 = XI0oooXX(strArr);
            this.f32664xoXoI = XI0oooXX2;
            Arrays.sort(XI0oooXX2);
        }
        return this;
    }

    public boolean XoI0Ixx0(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !x0xO()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !xoIxX()) {
            return false;
        }
        String[] strArr = this.f32664xoXoI;
        if (strArr != null && Arrays.binarySearch(strArr, field.getName()) >= 0) {
            return false;
        }
        return !field.isAnnotationPresent(oO.class);
    }

    public void o0xxxXXxX(boolean z) {
        this.f32660IIXOooo = z;
    }

    @Override // org.apache.commons.lang3.builder.x0XOIxOo
    public String toString() {
        if (XoX() == null) {
            return xo0x().getNullText();
        }
        Class<?> cls = XoX().getClass();
        O0Xx(cls);
        while (cls.getSuperclass() != null && cls != OO()) {
            cls = cls.getSuperclass();
            O0Xx(cls);
        }
        return super.toString();
    }

    public boolean x0xO() {
        return this.f32661OxxIIOOXO;
    }

    public boolean xoIxX() {
        return this.f32663oI0IIXIo;
    }

    public String[] xoxXI() {
        return (String[]) this.f32664xoXoI.clone();
    }

    public void xxIO(boolean z) {
        this.f32661OxxIIOOXO = z;
    }

    public ooOOo0oXI(Object obj, ToStringStyle toStringStyle) {
        super(I0oOIX(obj), toStringStyle);
        this.f32663oI0IIXIo = false;
        this.f32661OxxIIOOXO = false;
        this.f32662o00 = null;
    }

    public ooOOo0oXI(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(I0oOIX(obj), toStringStyle, stringBuffer);
        this.f32663oI0IIXIo = false;
        this.f32661OxxIIOOXO = false;
        this.f32662o00 = null;
    }

    public <T> ooOOo0oXI(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(I0oOIX(t), toStringStyle, stringBuffer);
        this.f32663oI0IIXIo = false;
        this.f32661OxxIIOOXO = false;
        this.f32662o00 = null;
        O00XxXI(cls);
        xxIO(z);
        Ioxxx(z2);
    }

    public <T> ooOOo0oXI(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2, boolean z3) {
        super(I0oOIX(t), toStringStyle, stringBuffer);
        this.f32663oI0IIXIo = false;
        this.f32661OxxIIOOXO = false;
        this.f32662o00 = null;
        O00XxXI(cls);
        xxIO(z);
        Ioxxx(z2);
        o0xxxXXxX(z3);
    }
}
