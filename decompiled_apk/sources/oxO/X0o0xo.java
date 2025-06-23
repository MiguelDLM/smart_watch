package oxO;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f33546I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f33547II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static /* synthetic */ Class f33548Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f33549X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public static /* synthetic */ Class f33550XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33551oIX0oI = "org.eclipse.paho.client.mqttv3.internal.nls.logcat";

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f33552oxoX;

    static {
        Class<X0o0xo> cls = f33549X0o0xo;
        if (cls == null) {
            cls = X0o0xo.class;
            f33549X0o0xo = cls;
        }
        f33547II0xO0 = cls.getName();
        f33546I0Io = null;
        Class<I0Io> cls2 = f33550XO;
        if (cls2 == null) {
            cls2 = I0Io.class;
            f33550XO = cls2;
        }
        f33552oxoX = cls2.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 5 */
    public static String I0Io(String str) {
        try {
            Class<?> cls = Class.forName("java.util.logging.LogManager");
            Object invoke = cls.getMethod("getLogManager", null).invoke(null, null);
            Class<String> cls2 = f33548Oxx0IOOO;
            if (cls2 == null) {
                cls2 = String.class;
                f33548Oxx0IOOO = cls2;
            }
            return (String) cls.getMethod("getProperty", cls2).invoke(invoke, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static oxoX II0xO0(String str, ResourceBundle resourceBundle, String str2, String str3) {
        try {
            oxoX oxox = (oxoX) Class.forName(str).newInstance();
            oxox.Oo(resourceBundle, str2, str3);
            return oxox;
        } catch (ClassNotFoundException | ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }

    public static oxoX oIX0oI(String str, String str2) {
        String str3 = f33546I0Io;
        if (str3 == null) {
            str3 = f33552oxoX;
        }
        oxoX II0xO02 = II0xO0(str3, ResourceBundle.getBundle(str), str2, null);
        if (II0xO02 != null) {
            return II0xO02;
        }
        throw new MissingResourceException("Error locating the logging class", f33547II0xO0, str2);
    }

    public static void oxoX(String str) {
        f33546I0Io = str;
    }
}
