package IO0xX;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.oxoX;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f467I0Io = " [wrapped] ";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String[] f468II0xO0 = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f469oIX0oI = -1;

    public static Throwable I0Io(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable) method.invoke(th, null);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return null;
    }

    public static String[] II0XooXoX(Throwable th) {
        List<String> list;
        if (th == null) {
            return oxoX.f32758OxxIIOOXO;
        }
        Throwable[] oO2 = oO(th);
        int length = oO2.length;
        ArrayList arrayList = new ArrayList();
        int i = length - 1;
        List<String> xxIXOIIO2 = xxIXOIIO(oO2[i]);
        while (true) {
            int i2 = length - 1;
            if (i2 >= 0) {
                if (i2 != 0) {
                    list = xxIXOIIO(oO2[length - 2]);
                    OxI(xxIXOIIO2, list);
                } else {
                    list = xxIXOIIO2;
                }
                if (i2 == i) {
                    arrayList.add(oO2[i2].toString());
                } else {
                    arrayList.add(f467I0Io + oO2[i2].toString());
                }
                arrayList.addAll(xxIXOIIO2);
                xxIXOIIO2 = list;
                length = i2;
            } else {
                return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
            }
        }
    }

    @Deprecated
    public static Throwable II0xO0(Throwable th, String[] strArr) {
        Throwable I0Io2;
        if (th == null) {
            return null;
        }
        if (strArr == null) {
            Throwable cause = th.getCause();
            if (cause != null) {
                return cause;
            }
            strArr = f468II0xO0;
        }
        for (String str : strArr) {
            if (str != null && (I0Io2 = I0Io(th, str)) != null) {
                return I0Io2;
            }
        }
        return null;
    }

    public static <R> R IIX0o(Throwable th) {
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new UndeclaredThrowableException(th);
        }
        throw ((RuntimeException) th);
    }

    public static void IIXOooo(Throwable th) {
        xoXoI(th, System.err);
    }

    public static int IXxxXO(Throwable th, Class<? extends Throwable> cls) {
        return Oo(th, cls, 0, false);
    }

    public static <R> R O0xOxO(Throwable th) {
        return (R) xXxxox0I(th);
    }

    public static String[] OOXIXo(Throwable th) {
        if (th == null) {
            return oxoX.f32758OxxIIOOXO;
        }
        return xoIox(oOoXoXO(th));
    }

    public static int Oo(Throwable th, Class<? extends Throwable> cls, int i, boolean z) {
        if (th != null && cls != null) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] oO2 = oO(th);
            if (i >= oO2.length) {
                return -1;
            }
            if (z) {
                while (i < oO2.length) {
                    if (cls.isAssignableFrom(oO2[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < oO2.length) {
                    if (cls.equals(oO2[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    public static void OxI(List<String> list, List<String> list2) {
        if (list != null && list2 != null) {
            int size = list.size() - 1;
            for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
                if (list.get(size).equals(list2.get(size2))) {
                    list.remove(size);
                }
                size--;
            }
            return;
        }
        throw new IllegalArgumentException("The List must not be null");
    }

    public static String Oxx0IOOO(Throwable th) {
        Throwable XO2 = XO(th);
        if (XO2 != null) {
            th = XO2;
        }
        return X0o0xo(th);
    }

    public static int Oxx0xo(Throwable th, Class<? extends Throwable> cls, int i) {
        return Oo(th, cls, i, false);
    }

    public static int OxxIIOOXO(Throwable th, Class<? extends Throwable> cls, int i) {
        return Oo(th, cls, i, true);
    }

    public static <T extends Throwable> T X0IIOO(Throwable th, Class<T> cls, int i, boolean z) {
        if (th != null && cls != null) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] oO2 = oO(th);
            if (i >= oO2.length) {
                return null;
            }
            if (z) {
                while (i < oO2.length) {
                    if (cls.isAssignableFrom(oO2[i].getClass())) {
                        return cls.cast(oO2[i]);
                    }
                    i++;
                }
            } else {
                while (i < oO2.length) {
                    if (cls.equals(oO2[i].getClass())) {
                        return cls.cast(oO2[i]);
                    }
                    i++;
                }
            }
        }
        return null;
    }

    public static String X0o0xo(Throwable th) {
        if (th == null) {
            return "";
        }
        return ClassUtils.ooXIXxIX(th, null) + ": " + xXOx.oo0xXOI0I(th.getMessage());
    }

    public static <T extends Throwable> T XI0IXoo(Throwable th, Class<T> cls) {
        return (T) X0IIOO(th, cls, 0, false);
    }

    public static <T extends Throwable> T XIxXXX0x0(Throwable th, Class<T> cls, int i) {
        return (T) X0IIOO(th, cls, i, false);
    }

    public static Throwable XO(Throwable th) {
        List<Throwable> x0XOIxOo2 = x0XOIxOo(th);
        if (x0XOIxOo2.isEmpty()) {
            return null;
        }
        return x0XOIxOo2.get(x0XOIxOo2.size() - 1);
    }

    public static <T extends Throwable> T XxX0x0xxx(Throwable th, Class<T> cls, int i) {
        return (T) X0IIOO(th, cls, i, true);
    }

    public static void o00(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Objects.requireNonNull(printWriter, "printWriter");
        for (String str : II0XooXoX(th)) {
            printWriter.println(str);
        }
        printWriter.flush();
    }

    public static int oI0IIXIo(Throwable th, Class<? extends Throwable> cls) {
        return Oo(th, cls, 0, true);
    }

    @Deprecated
    public static Throwable oIX0oI(Throwable th) {
        return II0xO0(th, null);
    }

    public static Throwable[] oO(Throwable th) {
        return (Throwable[]) x0XOIxOo(th).toArray(oxoX.f32752IIXOooo);
    }

    public static String oOoXoXO(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int ooOOo0oXI(Throwable th) {
        return x0XOIxOo(th).size();
    }

    @Deprecated
    public static String[] oxoX() {
        return (String[]) oxoX.x0o(f468II0xO0);
    }

    public static List<Throwable> x0XOIxOo(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        return arrayList;
    }

    public static boolean x0xO0oo(Throwable th, Class<? extends Throwable> cls) {
        if (th instanceof UndeclaredThrowableException) {
            th = th.getCause();
        }
        return cls.isInstance(th);
    }

    public static String[] xoIox(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, System.lineSeparator());
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
    }

    public static void xoXoI(Throwable th, PrintStream printStream) {
        if (th == null) {
            return;
        }
        Objects.requireNonNull(printStream, "printStream");
        for (String str : II0XooXoX(th)) {
            printStream.println(str);
        }
        printStream.flush();
    }

    public static List<String> xxIXOIIO(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(oOoXoXO(th), System.lineSeparator());
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    public static <T extends Throwable> T xxX(Throwable th, Class<T> cls) {
        return (T) X0IIOO(th, cls, 0, true);
    }

    public static <R, T extends Throwable> R xXxxox0I(Throwable th) throws Throwable {
        throw th;
    }
}
