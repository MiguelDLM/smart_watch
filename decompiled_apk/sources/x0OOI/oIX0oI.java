package x0OOI;

import OIxOX.II0XooXoX;
import OIxOX.X0o0xo;
import OIxOX.XO;
import OIxOX.oxoX;
import OIxOX.xoIox;
import OIxOX.xxIXOIIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.I0Io;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import xXo.OOXIXo;
import xXo.Oxx0IOOO;

/* loaded from: classes13.dex */
public class oIX0oI {
    public static boolean I0Io(Class<?> cls) {
        return II0xO0(true, cls);
    }

    public static Oxx0IOOO II0XooXoX(Class cls, Annotation annotation) {
        return xxIXOIIO(cls, null, annotation);
    }

    public static boolean II0xO0(boolean z, Class<?> cls) {
        boolean z2 = false;
        for (Field field : cls.getDeclaredFields()) {
            II0XooXoX iI0XooXoX = (II0XooXoX) field.getAnnotation(II0XooXoX.class);
            if (iI0XooXoX != null) {
                if ((iI0XooXoX.index() != -1 && z) || (iI0XooXoX.index() == -1 && !z)) {
                    return false;
                }
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011a  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.math.BigInteger] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Character] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Byte] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Short] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xXo.Oxx0IOOO OOXIXo(java.lang.Class r5, OIxOX.II0XooXoX r6) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x0OOI.oIX0oI.OOXIXo(java.lang.Class, OIxOX.II0XooXoX):xXo.Oxx0IOOO");
    }

    public static void Oo(Object obj, IXoIo.II0xO0 iI0xO0, String str) {
        Object valueOf;
        Method oxoX2 = iI0xO0.oxoX();
        if (oxoX2 != null) {
            Class<?> cls = oxoX2.getParameterTypes()[0];
            if (cls == String.class) {
                valueOf = str;
            } else if (cls != Integer.class && cls != Integer.TYPE) {
                if (cls != Character.class && cls != Character.TYPE) {
                    if (cls == Currency.class) {
                        valueOf = Currency.getInstance(str);
                    } else if (cls == Boolean.class) {
                        valueOf = Boolean.valueOf(str);
                    } else if (cls == TimeZone.class) {
                        valueOf = TimeZone.getTimeZone(str);
                    } else if (cls == DateFormatSymbols.class) {
                        valueOf = DateFormatSymbols.getInstance(new Locale(str));
                    } else {
                        valueOf = null;
                    }
                } else {
                    valueOf = Character.valueOf(str.charAt(0));
                }
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(str));
            }
            if (valueOf != null) {
                try {
                    oxoX2.invoke(obj, valueOf);
                    return;
                } catch (Throwable th) {
                    throw new DataProcessingException("Error setting property '" + iI0xO0.oIX0oI() + "' of formatter '" + obj.getClass() + ", with '" + valueOf + "' (converted from '" + str + "')", th);
                }
            }
            throw new DataProcessingException("Cannot set property '" + iI0xO0.oIX0oI() + "' of formatter '" + obj.getClass() + ". Cannot convert '" + str + "' to instance of " + cls);
        }
        throw new DataProcessingException("Cannot set property '" + iI0xO0.oIX0oI() + "' of formatter '" + obj.getClass() + "' to " + str + ". No setter defined");
    }

    public static Map<Field, IXoIo.II0xO0> Oxx0IOOO(Class<?> cls) {
        HashMap hashMap = new HashMap();
        try {
            for (IXoIo.II0xO0 iI0xO0 : IXoIo.oIX0oI.oxoX(cls)) {
                String oIX0oI2 = iI0xO0.oIX0oI();
                if (oIX0oI2 != null) {
                    hashMap.put(oIX0oI2, iI0xO0);
                }
            }
        } catch (Exception unused) {
        }
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        do {
            for (Field field : cls.getDeclaredFields()) {
                if (!hashSet.contains(field.getName())) {
                    hashSet.add(field.getName());
                    linkedHashMap.put(field, hashMap.get(field.getName()));
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                break;
            }
        } while (cls != Object.class);
        return linkedHashMap;
    }

    public static String[] X0o0xo(Class<?> cls) {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            II0XooXoX iI0XooXoX = (II0XooXoX) field.getAnnotation(II0XooXoX.class);
            if (iI0XooXoX != null) {
                if (iI0XooXoX.field().isEmpty()) {
                    str = field.getName();
                } else {
                    str = iI0XooXoX.field();
                }
                if (iI0XooXoX.index() != -1 && arrayList2.contains(Integer.valueOf(iI0XooXoX.index()))) {
                    throw new IllegalArgumentException("Duplicate field index found in attribute '" + field.getName() + "' of class " + cls.getName());
                }
                arrayList2.add(Integer.valueOf(iI0XooXoX.index()));
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList2.iterator();
        int i = -1;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            i++;
            if (intValue != -1 && intValue != i) {
                if (intValue >= arrayList.size()) {
                    return I0Io.f27012oIX0oI;
                }
                Collections.swap(arrayList, intValue, i);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static X0o0xo XO(Class<?> cls) {
        do {
            X0o0xo x0o0xo = (X0o0xo) cls.getAnnotation(X0o0xo.class);
            if (x0o0xo != null) {
                return x0o0xo;
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                X0o0xo XO2 = XO(cls2);
                if (XO2 != null) {
                    return XO2;
                }
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return null;
    }

    public static boolean oIX0oI(Class<?> cls) {
        return II0xO0(false, cls);
    }

    public static String oO(II0XooXoX iI0XooXoX) {
        if (iI0XooXoX == null) {
            return null;
        }
        return x0XOIxOo(iI0XooXoX.defaultNullWrite());
    }

    public static Oxx0IOOO oOoXoXO(Field field) {
        return OOXIXo(field.getType(), (II0XooXoX) field.getAnnotation(II0XooXoX.class));
    }

    public static String ooOOo0oXI(II0XooXoX iI0XooXoX) {
        if (iI0XooXoX == null) {
            return null;
        }
        return x0XOIxOo(iI0XooXoX.defaultNullRead());
    }

    public static void oxoX(Object obj, String[] strArr) {
        DataProcessingException dataProcessingException;
        if (strArr.length == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            if (str != null) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                } else {
                    throw new DataProcessingException("Illegal format setting '" + str + "' among: " + Arrays.toString(strArr));
                }
            } else {
                throw new DataProcessingException("Illegal format among: " + Arrays.toString(strArr));
            }
        }
        try {
            for (IXoIo.II0xO0 iI0xO0 : IXoIo.oIX0oI.oxoX(obj.getClass())) {
                String str2 = (String) hashMap.remove(iI0xO0.oIX0oI());
                if (str2 != null) {
                    Oo(obj, iI0xO0, str2);
                }
                if ("decimalFormatSymbols".equals(iI0xO0.oIX0oI())) {
                    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                    try {
                        boolean z = false;
                        for (IXoIo.II0xO0 iI0xO02 : IXoIo.oIX0oI.oxoX(decimalFormatSymbols.getClass())) {
                            String str3 = (String) hashMap.remove(iI0xO02.oIX0oI());
                            if (str3 != null) {
                                Oo(decimalFormatSymbols, iI0xO02, str3);
                                z = true;
                            }
                        }
                        if (z) {
                            Method oxoX2 = iI0xO0.oxoX();
                            if (oxoX2 != null) {
                                oxoX2.invoke(obj, decimalFormatSymbols);
                            } else {
                                throw new IllegalStateException("No write method defined for property " + iI0xO0.oIX0oI());
                            }
                        } else {
                            continue;
                        }
                    } finally {
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (hashMap.isEmpty()) {
            return;
        }
        throw new DataProcessingException("Cannot find properties in formatter of type '" + obj.getClass() + "': " + hashMap);
    }

    public static String x0XOIxOo(String str) {
        if ("null".equals(str)) {
            return null;
        }
        if ("'null'".equals(str)) {
            return "null";
        }
        return str;
    }

    public static Integer[] x0xO0oo(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            II0XooXoX iI0XooXoX = (II0XooXoX) field.getAnnotation(II0XooXoX.class);
            if (iI0XooXoX != null && iI0XooXoX.index() != -1) {
                if (!arrayList.contains(Integer.valueOf(iI0XooXoX.index()))) {
                    arrayList.add(Integer.valueOf(iI0XooXoX.index()));
                } else {
                    throw new IllegalArgumentException("Duplicate field index '" + iI0XooXoX.index() + "' found in attribute '" + field.getName() + "' of class " + cls.getName());
                }
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    public static Oxx0IOOO xoIox(Field field, Annotation annotation) {
        return xxIXOIIO(field.getType(), field, annotation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v24, types: [xXo.xxIXOIIO] */
    /* JADX WARN: Type inference failed for: r3v25, types: [xXo.oI0IIXIo] */
    /* JADX WARN: Type inference failed for: r3v27, types: [xXo.ooOOo0oXI] */
    public static Oxx0IOOO xxIXOIIO(Class cls, Field field, Annotation annotation) {
        II0XooXoX iI0XooXoX;
        Date date;
        xXo.X0o0xo x0o0xo;
        Calendar calendar;
        Boolean bool = null;
        if (field == null) {
            iI0XooXoX = null;
        } else {
            try {
                try {
                    iI0XooXoX = (II0XooXoX) field.getAnnotation(II0XooXoX.class);
                } catch (DataProcessingException e) {
                    throw e;
                }
            } catch (Throwable th) {
                if (field == null) {
                    throw new DataProcessingException("Unexpected error identifying conversions to apply over type " + cls, th);
                }
                throw new DataProcessingException("Unexpected error identifying conversions to apply over field " + field.getName() + " of class " + field.getDeclaringClass().getName(), th);
            }
        }
        Class<? extends Annotation> annotationType = annotation.annotationType();
        String ooOOo0oXI2 = ooOOo0oXI(iI0XooXoX);
        String oO2 = oO(iI0XooXoX);
        if (annotationType == OIxOX.Oxx0IOOO.class) {
            return xXo.II0XooXoX.ooXIXxIX(((OIxOX.Oxx0IOOO) annotation).nulls());
        }
        if (annotationType == OIxOX.I0Io.class) {
            if (cls.isEnum()) {
                OIxOX.I0Io i0Io = (OIxOX.I0Io) annotation;
                String trim = i0Io.customElement().trim();
                return new OOXIXo(cls, ooOOo0oXI2 != null ? Enum.valueOf(cls, ooOOo0oXI2) : null, oO2, trim.isEmpty() ? null : trim, i0Io.selectors());
            }
            if (field == null) {
                throw new IllegalStateException("Invalid " + OIxOX.I0Io.class.getName() + " instance for converting class " + cls.getName() + ". Not an enum type.");
            }
            throw new IllegalStateException("Invalid " + OIxOX.I0Io.class.getName() + " annotation on attribute " + field.getName() + " of type " + field.getType().getName() + ". Attribute must be an enum type.");
        }
        if (annotationType == xoIox.class) {
            int length = ((xoIox) annotation).length();
            if (length == -1) {
                return xXo.II0XooXoX.oo();
            }
            return xXo.II0XooXoX.IoOoX(length);
        }
        if (annotationType == XO.class) {
            return xXo.II0XooXoX.IIX0o();
        }
        if (annotationType == OIxOX.OOXIXo.class) {
            return xXo.II0XooXoX.oo0xXOI0I();
        }
        if (annotationType == xxIXOIIO.class) {
            xxIXOIIO xxixoiio = (xxIXOIIO) annotation;
            return xXo.II0XooXoX.XO(xxixoiio.expression(), xxixoiio.replacement());
        }
        if (annotationType == OIxOX.oIX0oI.class) {
            Class cls2 = Boolean.TYPE;
            if (cls == cls2 || cls == Boolean.class) {
                OIxOX.oIX0oI oix0oi = (OIxOX.oIX0oI) annotation;
                String[] falseStrings = oix0oi.falseStrings();
                String[] trueStrings = oix0oi.trueStrings();
                if (ooOOo0oXI2 != null) {
                    bool = Boolean.valueOf(ooOOo0oXI2);
                }
                if (bool == null && cls == cls2) {
                    bool = Boolean.FALSE;
                }
                return xXo.II0XooXoX.oOoXoXO(bool, oO2, trueStrings, falseStrings);
            }
            if (field == null) {
                throw new DataProcessingException("Invalid  usage of " + OIxOX.oIX0oI.class.getName() + ". Got type " + cls.getName() + " instead of boolean.");
            }
            throw new DataProcessingException("Invalid annotation: Field " + field.getName() + " has type " + cls.getName() + " instead of boolean.");
        }
        if (annotationType == oxoX.class) {
            oxoX oxox = (oxoX) annotation;
            String[] formats = oxox.formats();
            if (cls == BigDecimal.class) {
                x0o0xo = xXo.II0XooXoX.oIX0oI(ooOOo0oXI2 == null ? null : new BigDecimal(ooOOo0oXI2), oO2, formats);
            } else if (Number.class.isAssignableFrom(cls)) {
                ?? X0o0xo2 = xXo.II0XooXoX.X0o0xo(formats);
                X0o0xo2.Oo(cls);
                x0o0xo = X0o0xo2;
            } else {
                if (ooOOo0oXI2 == null) {
                    date = null;
                } else if ("now".equalsIgnoreCase(ooOOo0oXI2)) {
                    date = new Date();
                } else if (formats.length != 0) {
                    date = new SimpleDateFormat(formats[0]).parse(ooOOo0oXI2);
                } else {
                    throw new DataProcessingException("No format defined");
                }
                if (Date.class == cls) {
                    x0o0xo = xXo.II0XooXoX.IIXOooo(date, oO2, formats);
                } else if (Calendar.class == cls) {
                    if (date != null) {
                        calendar = Calendar.getInstance();
                        calendar.setTime(date);
                    } else {
                        calendar = null;
                    }
                    x0o0xo = xXo.II0XooXoX.x0xO0oo(calendar, oO2, formats);
                } else {
                    x0o0xo = null;
                }
            }
            if (x0o0xo != null) {
                String[] options = oxox.options();
                if (options.length > 0) {
                    for (SimpleDateFormat simpleDateFormat : x0o0xo.I0Io()) {
                        oxoX(simpleDateFormat, options);
                    }
                }
                return x0o0xo;
            }
        } else if (annotationType == OIxOX.II0xO0.class) {
            OIxOX.II0xO0 iI0xO0 = (OIxOX.II0xO0) annotation;
            String[] args = iI0xO0.args();
            Class<? extends Oxx0IOOO> conversionClass = iI0xO0.conversionClass();
            if (Oxx0IOOO.class.isAssignableFrom(conversionClass)) {
                try {
                    return conversionClass.getConstructor(String[].class).newInstance(args);
                } catch (NoSuchMethodException e2) {
                    throw new DataProcessingException("Could not find a public constructor with a String[] parameter in custom conversion class '" + conversionClass.getSimpleName() + "' (" + conversionClass.getName() + HexStringBuilder.COMMENT_END_CHAR, e2);
                } catch (Exception e3) {
                    throw new DataProcessingException("Unexpected error instantiating custom conversion class '" + conversionClass.getSimpleName() + "' (" + conversionClass.getName() + HexStringBuilder.COMMENT_END_CHAR, e3);
                }
            }
            throw new DataProcessingException("Not a valid conversion class: '" + conversionClass.getSimpleName() + "' (" + conversionClass.getName() + HexStringBuilder.COMMENT_END_CHAR);
        }
        return null;
    }
}
