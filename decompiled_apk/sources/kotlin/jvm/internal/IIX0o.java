package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes6.dex */
public class IIX0o {

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    /* loaded from: classes6.dex */
    public static class oIX0oI {
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean I0Io(Double d, double d2) {
        if (d != null && d.doubleValue() == d2) {
            return true;
        }
        return false;
    }

    public static void II0XooXoX(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) X0IIOO(new IllegalStateException(str + " must not be null")));
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean II0xO0(float f, Float f2) {
        if (f2 != null && f == f2.floatValue()) {
            return true;
        }
        return false;
    }

    public static void IIX0o(String str) {
        throw ((IllegalArgumentException) X0IIOO(new IllegalArgumentException(str)));
    }

    public static String IIXOooo(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = IIX0o.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void IO() {
        xII("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void IXxxXO(Object obj, String str) {
        if (obj != null) {
        } else {
            throw ((IllegalStateException) X0IIOO(new IllegalStateException(str)));
        }
    }

    public static void IoOoX() {
        throw ((KotlinNullPointerException) X0IIOO(new KotlinNullPointerException()));
    }

    public static void O0xOxO(int i, String str, String str2) {
        xII(str2);
    }

    public static void OOXIXo(String str) throws ClassNotFoundException {
        String replace = str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) X0IIOO(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e)));
        }
    }

    public static void Oo(Object obj, String str) {
        if (obj == null) {
            Xx000oIo(str);
        }
    }

    public static void OxI(int i, String str) {
        IO();
    }

    public static boolean Oxx0IOOO(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static void Oxx0xo(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) X0IIOO(new IllegalStateException("Method specified as non-null returned null: " + str + FileUtils.FILE_EXTENSION_SEPARATOR + str2)));
    }

    public static int OxxIIOOXO(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static void X00IoxXI(String str) {
        throw ((NullPointerException) X0IIOO(new NullPointerException(IIXOooo(str))));
    }

    public static <T extends Throwable> T X0IIOO(T t) {
        return (T) XI0IXoo(t, IIX0o.class.getName());
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean X0o0xo(Float f, float f2) {
        if (f != null && f.floatValue() == f2) {
            return true;
        }
        return false;
    }

    public static <T extends Throwable> T XI0IXoo(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static String XIxXXX0x0(String str, Object obj) {
        return str + obj;
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean XO(Float f, Float f2) {
        if (f == null) {
            if (f2 != null) {
                return false;
            }
        } else if (f2 == null || f.floatValue() != f2.floatValue()) {
            return false;
        }
        return true;
    }

    public static void XOxIOxOx(String str) {
        x0o("lateinit property " + str + " has not been initialized");
    }

    public static void Xx000oIo(String str) {
        throw ((IllegalArgumentException) X0IIOO(new IllegalArgumentException(IIXOooo(str))));
    }

    public static void XxX0x0xxx(String str) {
        throw ((AssertionError) X0IIOO(new AssertionError(str)));
    }

    public static void o00(String str) {
        xII(str);
    }

    public static int oI0IIXIo(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean oIX0oI(double d, Double d2) {
        if (d2 != null && d == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    public static void oO(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) X0IIOO(new NullPointerException(str + " must not be null")));
    }

    public static void oOXoIIIo(String str) {
        throw ((KotlinNullPointerException) X0IIOO(new KotlinNullPointerException(str)));
    }

    public static void oOoXoXO(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) X0IIOO(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e)));
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void oo(String str) {
        throw ((NullPointerException) X0IIOO(new NullPointerException(str)));
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void oo0xXOI0I() {
        throw ((NullPointerException) X0IIOO(new NullPointerException()));
    }

    public static void ooOOo0oXI(Object obj) {
        if (obj == null) {
            oo0xXOI0I();
        }
    }

    public static void ooXIXxIX() {
        throw ((IllegalStateException) X0IIOO(new IllegalStateException()));
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static boolean oxoX(Double d, Double d2) {
        if (d == null) {
            if (d2 != null) {
                return false;
            }
        } else if (d2 == null || d.doubleValue() != d2.doubleValue()) {
            return false;
        }
        return true;
    }

    public static void x0XOIxOo(Object obj, String str) {
        if (obj == null) {
            oo(str);
        }
    }

    public static void x0o(String str) {
        throw ((UninitializedPropertyAccessException) X0IIOO(new UninitializedPropertyAccessException(str)));
    }

    public static void x0xO0oo(Object obj, String str) {
        if (obj == null) {
            X00IoxXI(str);
        }
    }

    public static void xI(String str) {
        throw ((IllegalStateException) X0IIOO(new IllegalStateException(str)));
    }

    public static void xII(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void xXxxox0I() {
        throw ((IllegalArgumentException) X0IIOO(new IllegalArgumentException()));
    }

    public static void xoIox(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) X0IIOO(new IllegalStateException("Field specified as non-null is null: " + str + FileUtils.FILE_EXTENSION_SEPARATOR + str2)));
    }

    public static void xoXoI() {
        IO();
    }

    public static void xxIXOIIO(Object obj, String str) {
        if (obj != null) {
        } else {
            throw ((IllegalStateException) X0IIOO(new IllegalStateException(str)));
        }
    }

    public static void xxX() {
        throw ((AssertionError) X0IIOO(new AssertionError()));
    }
}
