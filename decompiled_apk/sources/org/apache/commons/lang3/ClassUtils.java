package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.x;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.mutable.MutableObject;

/* loaded from: classes6.dex */
public class ClassUtils {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final char f32466I0Io = '$';

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Map<String, String> f32467II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f32469Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<String, Class<?>> f32470X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f32471XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final char f32472oIX0oI = '.';

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Map<String, String> f32474xxIXOIIO;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32468II0xO0 = String.valueOf('.');

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32473oxoX = String.valueOf('$');

    /* loaded from: classes6.dex */
    public static class II0xO0 implements Iterator<Class<?>> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Set f32475IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Iterator f32476Oo;

        /* renamed from: XO, reason: collision with root package name */
        public Iterator f32477XO = Collections.emptySet().iterator();

        public II0xO0(Iterator it, Set set) {
            this.f32476Oo = it;
            this.f32475IXxxXO = set;
        }

        public final void II0xO0(Set<Class<?>> set, Class<?> cls) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (!this.f32475IXxxXO.contains(cls2)) {
                    set.add(cls2);
                }
                II0xO0(set, cls2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f32477XO.hasNext() && !this.f32476Oo.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Class<?> next() {
            if (this.f32477XO.hasNext()) {
                Class<?> cls = (Class) this.f32477XO.next();
                this.f32475IXxxXO.add(cls);
                return cls;
            }
            Class<?> cls2 = (Class) this.f32476Oo.next();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            II0xO0(linkedHashSet, cls2);
            this.f32477XO = linkedHashSet.iterator();
            return cls2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI implements Iterator<Class<?>> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MutableObject f32478XO;

        public oIX0oI(MutableObject mutableObject) {
            this.f32478XO = mutableObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f32478XO.getValue2() != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Class<?> next() {
            Class<?> cls = (Class) this.f32478XO.getValue2();
            this.f32478XO.setValue(cls.getSuperclass());
            return cls;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f32470X0o0xo = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(TypedValues.Custom.S_BOOLEAN, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put("byte", cls2);
        Class cls3 = Character.TYPE;
        hashMap.put("char", cls3);
        Class cls4 = Short.TYPE;
        hashMap.put("short", cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, cls5);
        Class cls6 = Long.TYPE;
        hashMap.put("long", cls6);
        Class cls7 = Double.TYPE;
        hashMap.put("double", cls7);
        Class cls8 = Float.TYPE;
        hashMap.put(TypedValues.Custom.S_FLOAT, cls8);
        Class cls9 = Void.TYPE;
        hashMap.put("void", cls9);
        HashMap hashMap2 = new HashMap();
        f32471XO = hashMap2;
        hashMap2.put(cls, Boolean.class);
        hashMap2.put(cls2, Byte.class);
        hashMap2.put(cls3, Character.class);
        hashMap2.put(cls4, Short.class);
        hashMap2.put(cls5, Integer.class);
        hashMap2.put(cls6, Long.class);
        hashMap2.put(cls7, Double.class);
        hashMap2.put(cls8, Float.class);
        hashMap2.put(cls9, cls9);
        f32469Oxx0IOOO = new HashMap();
        for (Map.Entry entry : hashMap2.entrySet()) {
            Class<?> cls10 = (Class) entry.getKey();
            Class<?> cls11 = (Class) entry.getValue();
            if (!cls10.equals(cls11)) {
                f32469Oxx0IOOO.put(cls11, cls10);
            }
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, com.vtrump.vtble.Oxx0IOOO.f27277xI);
        hashMap3.put(TypedValues.Custom.S_BOOLEAN, "Z");
        hashMap3.put(TypedValues.Custom.S_FLOAT, "F");
        hashMap3.put("long", ContentClassification.AD_CONTENT_CLASSIFICATION_J);
        hashMap3.put("short", ExifInterface.LATITUDE_SOUTH);
        hashMap3.put("byte", "B");
        hashMap3.put("double", "D");
        hashMap3.put("char", "C");
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            hashMap4.put(entry2.getValue(), entry2.getKey());
        }
        f32467II0XooXoX = Collections.unmodifiableMap(hashMap3);
        f32474xxIXOIIO = Collections.unmodifiableMap(hashMap4);
    }

    public static List<Class<?>> I0Io(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Class.forName(it.next()));
            } catch (Exception unused) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static Class<?>[] I0X0x0oIo(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = XX0(clsArr[i]);
        }
        return clsArr2;
    }

    public static /* synthetic */ Iterator I0oOoX(Iterable iterable) {
        return new II0xO0(iterable.iterator(), new HashSet());
    }

    public static void II0XooXoX(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    II0XooXoX(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static String IIX0o(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return xI(cls.getName());
    }

    public static String IIXOooo(Object obj, String str) {
        if (obj != null) {
            return obj.getClass().getName();
        }
        return str;
    }

    public static boolean IO(Class<?> cls, Class<?> cls2) {
        return xII(cls, cls2, true);
    }

    public static Class<?> IXxxXO(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return x0xO0oo(contextClassLoader, str, z);
    }

    public static boolean Io(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (!cls.isPrimitive() && !o0(cls)) {
            return false;
        }
        return true;
    }

    public static String IoOoX(Object obj) {
        return oOXoIIIo(obj, "");
    }

    public static String O0xOxO(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return XI0IXoo(cls.getName());
    }

    public static boolean OI0(Class<?> cls) {
        if (cls != null && cls.getEnclosingClass() != null) {
            return true;
        }
        return false;
    }

    public static String OOXIXo(Class<?> cls, String str) {
        if (cls == null) {
            return str;
        }
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        return str;
    }

    public static Class<?> Oo(String str) throws ClassNotFoundException {
        return IXxxXO(str, true);
    }

    public static String OxI(String str) {
        return XI0IXoo(x0XOIxOo(str));
    }

    public static List<Class<?>> Oxx0IOOO(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        II0XooXoX(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static String Oxx0xo(Class<?> cls) {
        return oI0IIXIo(cls, "");
    }

    public static String OxxIIOOXO(Object obj) {
        return IIXOooo(obj, "");
    }

    public static Iterable<Class<?>> X00IoxXI(final Class<?> cls, Interfaces interfaces) {
        final Iterable<Class<?>> iterable = new Iterable() { // from class: org.apache.commons.lang3.x0XOIxOo
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                Iterator XX2;
                XX2 = ClassUtils.XX(cls);
                return XX2;
            }
        };
        if (interfaces != Interfaces.INCLUDE) {
            return iterable;
        }
        return new Iterable() { // from class: org.apache.commons.lang3.oO
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                Iterator I0oOoX2;
                I0oOoX2 = ClassUtils.I0oOoX(iterable);
                return I0oOoX2;
            }
        };
    }

    public static String X0IIOO(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        return O0xOxO(obj.getClass());
    }

    public static String X0o0xo(Class<?> cls, int i) {
        if (cls == null) {
            return "";
        }
        return XO(cls.getName(), i);
    }

    public static String XI0IXoo(String str) {
        if (xXOx.XIXIX(str)) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
            str = str.substring(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static Method XIxXXX0x0(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.addAll(Oxx0IOOO(cls));
        arrayList.addAll(xxIXOIIO(cls));
        for (Class cls2 : arrayList) {
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + str + " " + oxoX.xXO0oXX(clsArr));
    }

    public static String XO(String str, int i) {
        char c;
        if (i > 0) {
            if (str == null) {
                return "";
            }
            if (str.length() <= i) {
                return str;
            }
            char[] charArray = str.toCharArray();
            int i2 = 0;
            int i3 = 0;
            while (i2 < charArray.length) {
                int i4 = i3;
                while (i2 < charArray.length && (c = charArray[i2]) != '.') {
                    i2++;
                    charArray[i4] = c;
                    i4++;
                }
                int i5 = i3 + 1;
                if (!xXOx(i4, i2, charArray.length, i) && i5 <= i4) {
                    i4 = i5;
                }
                if (i2 < charArray.length) {
                    i3 = i4 + 1;
                    charArray[i4] = charArray[i2];
                    i2++;
                } else {
                    i3 = i4;
                }
            }
            return new String(charArray, 0, i3);
        }
        throw new IllegalArgumentException("len must be > 0");
    }

    public static boolean XOxIOxOx(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!oxoX.oxOXxoXII(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = oxoX.f32756Oxx0IOOO;
        }
        if (clsArr2 == null) {
            clsArr2 = oxoX.f32756Oxx0IOOO;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!xII(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ Iterator XX(Class cls) {
        return new oIX0oI(new MutableObject(cls));
    }

    public static Class<?> XX0(Class<?> cls) {
        return f32469Oxx0IOOO.get(cls);
    }

    public static Class<?>[] XoX(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = oxxXoxO(clsArr[i]);
        }
        return clsArr2;
    }

    public static Iterable<Class<?>> Xx000oIo(Class<?> cls) {
        return X00IoxXI(cls, Interfaces.EXCLUDE);
    }

    public static String XxX0x0xxx(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        return xXxxox0I(obj.getClass().getName());
    }

    public static boolean o0(Class<?> cls) {
        return f32469Oxx0IOOO.containsKey(cls);
    }

    public static String o00(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        return OxI(obj.getClass().getName());
    }

    public static String oI0IIXIo(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getName();
        }
        return str;
    }

    public static Class<?> oO(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return x0xO0oo(classLoader, str, true);
    }

    public static String oOXoIIIo(Object obj, String str) {
        if (obj != null) {
            return obj.getClass().getSimpleName();
        }
        return str;
    }

    public static String oOoXoXO(Object obj) {
        return ooOOo0oXI(obj, "");
    }

    public static String oo(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getSimpleName();
        }
        return str;
    }

    public static String oo0xXOI0I(Class<?> cls) {
        return oo(cls, "");
    }

    public static String ooOOo0oXI(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        return str;
    }

    public static String ooXIXxIX(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        return IIX0o(obj.getClass());
    }

    public static String oxXx0IX(String str) {
        String IoOoX2 = xXOx.IoOoX(str);
        xoIxX.xo0x(IoOoX2, "className must not be null.", new Object[0]);
        if (IoOoX2.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            StringBuilder sb = new StringBuilder();
            while (IoOoX2.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                IoOoX2 = IoOoX2.substring(0, IoOoX2.length() - 2);
                sb.append("[");
            }
            String str2 = f32467II0XooXoX.get(IoOoX2);
            if (str2 != null) {
                sb.append(str2);
            } else {
                sb.append("L");
                sb.append(IoOoX2);
                sb.append(x.aL);
            }
            return sb.toString();
        }
        return IoOoX2;
    }

    public static List<String> oxoX(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<?> cls : list) {
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    public static Class<?> oxxXoxO(Class<?> cls) {
        if (cls != null && cls.isPrimitive()) {
            return f32471XO.get(cls);
        }
        return cls;
    }

    public static String x0XOIxOo(String str) {
        int length;
        String IoOoX2 = xXOx.IoOoX(str);
        if (IoOoX2 == null) {
            return null;
        }
        int i = 0;
        while (IoOoX2.startsWith("[")) {
            i++;
            IoOoX2 = IoOoX2.substring(1);
        }
        if (i < 1) {
            return IoOoX2;
        }
        if (IoOoX2.startsWith("L")) {
            if (IoOoX2.endsWith(x.aL)) {
                length = IoOoX2.length() - 1;
            } else {
                length = IoOoX2.length();
            }
            IoOoX2 = IoOoX2.substring(1, length);
        } else if (!IoOoX2.isEmpty()) {
            IoOoX2 = f32474xxIXOIIO.get(IoOoX2.substring(0, 1));
        }
        StringBuilder sb = new StringBuilder(IoOoX2);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public static boolean x0o(Class<?>[] clsArr, Class<?>... clsArr2) {
        return XOxIOxOx(clsArr, clsArr2, true);
    }

    public static Class<?> x0xO0oo(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        try {
            Map<String, Class<?>> map = f32470X0o0xo;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return Class.forName(oxXx0IX(str), z, classLoader);
        } catch (ClassNotFoundException e) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return x0xO0oo(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z);
                } catch (ClassNotFoundException unused) {
                    throw e;
                }
            }
            throw e;
        }
    }

    public static String xI(String str) {
        if (xXOx.XIXIX(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map<String, String> map = f32474xxIXOIIO;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            i = lastIndexOf + 1;
        }
        int indexOf = str.indexOf(36, i);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', '.');
        }
        return substring + ((Object) sb);
    }

    public static boolean xII(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = oxxXoxO(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = XX0(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            Class cls3 = Integer.TYPE;
            if (cls3.equals(cls)) {
                if (!Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                    return false;
                }
                return true;
            }
            Class cls4 = Long.TYPE;
            if (cls4.equals(cls)) {
                if (!Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                    return false;
                }
                return true;
            }
            if (Boolean.TYPE.equals(cls)) {
                return false;
            }
            Class cls5 = Double.TYPE;
            if (cls5.equals(cls)) {
                return false;
            }
            Class cls6 = Float.TYPE;
            if (cls6.equals(cls)) {
                return cls5.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                if (!cls3.equals(cls2) && !cls4.equals(cls2) && !cls6.equals(cls2) && !cls5.equals(cls2)) {
                    return false;
                }
                return true;
            }
            Class cls7 = Short.TYPE;
            if (cls7.equals(cls)) {
                if (!cls3.equals(cls2) && !cls4.equals(cls2) && !cls6.equals(cls2) && !cls5.equals(cls2)) {
                    return false;
                }
                return true;
            }
            if (!Byte.TYPE.equals(cls)) {
                return false;
            }
            if (!cls7.equals(cls2) && !cls3.equals(cls2) && !cls4.equals(cls2) && !cls6.equals(cls2) && !cls5.equals(cls2)) {
                return false;
            }
            return true;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static boolean xXOx(int i, int i2, int i3, int i4) {
        return i2 >= i3 || (i + i3) - i2 <= i4;
    }

    public static String xXxxox0I(String str) {
        return xI(x0XOIxOo(str));
    }

    public static Class<?>[] xo0x(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return oxoX.f32756Oxx0IOOO;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static String xoIox(Class<?> cls) {
        return OOXIXo(cls, "");
    }

    public static String xoXoI(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return OxI(cls.getName());
    }

    public static List<Class<?>> xxIXOIIO(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static String xxX(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return xXxxox0I(cls.getName());
    }
}
