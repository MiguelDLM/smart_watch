package org.apache.log4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.Level;

/* loaded from: classes6.dex */
public class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f33275I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static char f33276II0xO0 = '}';

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static /* synthetic */ Class f33277Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f33278X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public static /* synthetic */ Class f33279XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f33280oIX0oI = "${";

    /* renamed from: oxoX, reason: collision with root package name */
    public static int f33281oxoX = 1;

    public static String I0Io(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i += 2;
                charAt = str.charAt(i2);
                if (charAt == 'n') {
                    charAt = '\n';
                } else if (charAt == 'r') {
                    charAt = '\r';
                } else if (charAt == 't') {
                    charAt = '\t';
                } else if (charAt == 'f') {
                    charAt = '\f';
                } else if (charAt == '\b') {
                    charAt = '\b';
                } else if (charAt == '\"') {
                    charAt = '\"';
                } else if (charAt == '\'') {
                    charAt = '\'';
                } else if (charAt == '\\') {
                    charAt = '\\';
                }
            } else {
                i = i2;
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static void II0XooXoX(URL url, String str, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        org.apache.log4j.spi.II0xO0 iIXOooo;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Preferred configurator class: ");
            stringBuffer.append(str);
            xxIXOIIO.oIX0oI(stringBuffer.toString());
            Class cls = f33277Oxx0IOOO;
            if (cls == null) {
                cls = oIX0oI("org.apache.log4j.spi.Configurator");
                f33277Oxx0IOOO = cls;
            }
            iIXOooo = (org.apache.log4j.spi.II0xO0) XO(str, cls, null);
            if (iIXOooo == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not instantiate configurator [");
                stringBuffer2.append(str);
                stringBuffer2.append("].");
                xxIXOIIO.I0Io(stringBuffer2.toString());
                return;
            }
        } else {
            iIXOooo = new IIXOooo();
        }
        iIXOooo.oIX0oI(url, xxixoiio);
    }

    public static String[] II0xO0(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static long OOXIXo(String str, long j) {
        long j2;
        if (str == null) {
            return j;
        }
        String upperCase = str.trim().toUpperCase();
        int indexOf = upperCase.indexOf("KB");
        if (indexOf != -1) {
            upperCase = upperCase.substring(0, indexOf);
            j2 = 1024;
        } else {
            int indexOf2 = upperCase.indexOf("MB");
            if (indexOf2 != -1) {
                upperCase = upperCase.substring(0, indexOf2);
                j2 = 1048576;
            } else {
                int indexOf3 = upperCase.indexOf("GB");
                if (indexOf3 != -1) {
                    upperCase = upperCase.substring(0, indexOf3);
                    j2 = 1073741824;
                } else {
                    j2 = 1;
                }
            }
        }
        if (upperCase != null) {
            try {
                return Long.valueOf(upperCase).longValue() * j2;
            } catch (NumberFormatException e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(upperCase);
                stringBuffer.append("] is not in proper int form.");
                xxIXOIIO.I0Io(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                stringBuffer2.append(str);
                stringBuffer2.append("] not in expected format.");
                xxIXOIIO.oxoX(stringBuffer2.toString(), e);
            }
        }
        return j;
    }

    public static Object Oxx0IOOO(Properties properties, String str, Class cls, Object obj) {
        String oxoX2 = oxoX(str, properties);
        if (oxoX2 == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find value for key ");
            stringBuffer.append(str);
            xxIXOIIO.I0Io(stringBuffer.toString());
            return obj;
        }
        return XO(oxoX2.trim(), cls, obj);
    }

    public static String X0o0xo(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (Throwable unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Was not allowed to read system property \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            xxIXOIIO.oIX0oI(stringBuffer.toString());
            return str2;
        }
    }

    public static Object XO(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class<?> XO2 = II0XooXoX.XO(str);
                if (!cls.isAssignableFrom(XO2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("A \"");
                    stringBuffer.append(str);
                    stringBuffer.append("\" object is not assignable to a \"");
                    stringBuffer.append(cls.getName());
                    stringBuffer.append("\" variable.");
                    xxIXOIIO.I0Io(stringBuffer.toString());
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("The class \"");
                    stringBuffer2.append(cls.getName());
                    stringBuffer2.append("\" was loaded by ");
                    xxIXOIIO.I0Io(stringBuffer2.toString());
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("[");
                    stringBuffer3.append(cls.getClassLoader());
                    stringBuffer3.append("] whereas object of type ");
                    xxIXOIIO.I0Io(stringBuffer3.toString());
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("\"");
                    stringBuffer4.append(XO2.getName());
                    stringBuffer4.append("\" was loaded by [");
                    stringBuffer4.append(XO2.getClassLoader());
                    stringBuffer4.append("].");
                    xxIXOIIO.I0Io(stringBuffer4.toString());
                    return obj;
                }
                return XO2.newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Could not instantiate class [");
                stringBuffer5.append(str);
                stringBuffer5.append("].");
                xxIXOIIO.oxoX(stringBuffer5.toString(), e);
            }
        }
        return obj;
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static int oOoXoXO(String str, int i) {
        if (str != null) {
            String trim = str.trim();
            try {
                return Integer.valueOf(trim).intValue();
            } catch (NumberFormatException e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(trim);
                stringBuffer.append("] is not in proper int form.");
                xxIXOIIO.I0Io(stringBuffer.toString());
                e.printStackTrace();
            }
        }
        return i;
    }

    public static Level ooOOo0oXI(String str, Level level) {
        if (str == null) {
            return level;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(35);
        if (indexOf == -1) {
            if (X0o0xo.f33252II0XooXoX.equalsIgnoreCase(trim)) {
                return null;
            }
            return Level.toLevel(trim, level);
        }
        String substring = trim.substring(indexOf + 1);
        String substring2 = trim.substring(0, indexOf);
        if (X0o0xo.f33252II0XooXoX.equalsIgnoreCase(substring2)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("toLevel:class=[");
        stringBuffer.append(substring);
        stringBuffer.append("]");
        stringBuffer.append(":pri=[");
        stringBuffer.append(substring2);
        stringBuffer.append("]");
        xxIXOIIO.oIX0oI(stringBuffer.toString());
        try {
            Class XO2 = II0XooXoX.XO(substring);
            Class<?> cls = f33278X0o0xo;
            if (cls == null) {
                cls = oIX0oI("java.lang.String");
                f33278X0o0xo = cls;
            }
            Class<?> cls2 = f33279XO;
            if (cls2 == null) {
                cls2 = oIX0oI("org.apache.log4j.Level");
                f33279XO = cls2;
            }
            return (Level) XO2.getMethod("toLevel", cls, cls2).invoke(null, substring2, level);
        } catch (ClassCastException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("class [");
            stringBuffer2.append(substring);
            stringBuffer2.append("] is not a subclass of org.apache.log4j.Level");
            xxIXOIIO.II0XooXoX(stringBuffer2.toString(), e);
            return level;
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("custom level class [");
            stringBuffer3.append(substring);
            stringBuffer3.append("] not found.");
            xxIXOIIO.Oxx0IOOO(stringBuffer3.toString());
            return level;
        } catch (IllegalAccessException e2) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("class [");
            stringBuffer4.append(substring);
            stringBuffer4.append("] cannot be instantiated due to access restrictions");
            xxIXOIIO.II0XooXoX(stringBuffer4.toString(), e2);
            return level;
        } catch (NoSuchMethodException e3) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("custom level class [");
            stringBuffer5.append(substring);
            stringBuffer5.append("]");
            stringBuffer5.append(" does not have a constructor which takes one string parameter");
            xxIXOIIO.II0XooXoX(stringBuffer5.toString(), e3);
            return level;
        } catch (InvocationTargetException e4) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("custom level class [");
            stringBuffer6.append(substring);
            stringBuffer6.append("]");
            stringBuffer6.append(" could not be instantiated");
            xxIXOIIO.II0XooXoX(stringBuffer6.toString(), e4);
            return level;
        } catch (Exception e5) {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("class [");
            stringBuffer7.append(substring);
            stringBuffer7.append("], level [");
            stringBuffer7.append(substring2);
            stringBuffer7.append("] conversion failed.");
            xxIXOIIO.II0XooXoX(stringBuffer7.toString(), e5);
            return level;
        }
    }

    public static String oxoX(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return xxIXOIIO(property, properties);
        } catch (IllegalArgumentException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Bad option value [");
            stringBuffer.append(property);
            stringBuffer.append("].");
            xxIXOIIO.oxoX(stringBuffer.toString(), e);
            return property;
        }
    }

    public static boolean xoIox(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if ("true".equalsIgnoreCase(trim)) {
            return true;
        }
        if ("false".equalsIgnoreCase(trim)) {
            return false;
        }
        return z;
    }

    public static String xxIXOIIO(String str, Properties properties) throws IllegalArgumentException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(f33280oIX0oI, i);
            if (indexOf == -1) {
                if (i == 0) {
                    return str;
                }
                stringBuffer.append(str.substring(i, str.length()));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i, indexOf));
            int indexOf2 = str.indexOf(f33276II0xO0, indexOf);
            if (indexOf2 != -1) {
                String substring = str.substring(indexOf + f33275I0Io, indexOf2);
                String X0o0xo2 = X0o0xo(substring, null);
                if (X0o0xo2 == null && properties != null) {
                    X0o0xo2 = properties.getProperty(substring);
                }
                if (X0o0xo2 != null) {
                    stringBuffer.append(xxIXOIIO(X0o0xo2, properties));
                }
                i = indexOf2 + f33281oxoX;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append('\"');
                stringBuffer2.append(str);
                stringBuffer2.append("\" has no closing brace. Opening brace at position ");
                stringBuffer2.append(indexOf);
                stringBuffer2.append('.');
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
        }
    }
}
