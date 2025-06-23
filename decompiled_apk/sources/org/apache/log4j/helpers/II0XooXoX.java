package org.apache.log4j.helpers;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static boolean f33231I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f33232II0xO0 = true;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f33233X0o0xo = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33234oIX0oI = "Caught Exception while in Loader.getResource. This may be innocuous.";

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f33235oxoX;

    static {
        int indexOf;
        String X0o0xo2 = oOoXoXO.X0o0xo("java.version", null);
        if (X0o0xo2 != null && (indexOf = X0o0xo2.indexOf(46)) != -1 && X0o0xo2.charAt(indexOf + 1) != '1') {
            f33232II0xO0 = false;
        }
        String X0o0xo3 = oOoXoXO.X0o0xo("log4j.ignoreTCL", null);
        if (X0o0xo3 != null) {
            f33231I0Io = oOoXoXO.xoIox(X0o0xo3, true);
        }
    }

    public static URL I0Io(String str, Class cls) {
        return II0xO0(str);
    }

    public static URL II0xO0(String str) {
        ClassLoader oxoX2;
        try {
            if (!f33232II0xO0 && (oxoX2 = oxoX()) != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Trying to find [");
                stringBuffer.append(str);
                stringBuffer.append("] using context classloader ");
                stringBuffer.append(oxoX2);
                stringBuffer.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                xxIXOIIO.oIX0oI(stringBuffer.toString());
                URL resource = oxoX2.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
            Class cls = f33235oxoX;
            if (cls == null) {
                cls = oIX0oI("org.apache.log4j.helpers.Loader");
                f33235oxoX = cls;
            }
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Trying to find [");
                stringBuffer2.append(str);
                stringBuffer2.append("] using ");
                stringBuffer2.append(classLoader);
                stringBuffer2.append(" class loader.");
                xxIXOIIO.oIX0oI(stringBuffer2.toString());
                URL resource2 = classLoader.getResource(str);
                if (resource2 != null) {
                    return resource2;
                }
            }
        } catch (Throwable th) {
            xxIXOIIO.II0XooXoX(f33234oIX0oI, th);
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Trying to find [");
        stringBuffer3.append(str);
        stringBuffer3.append("] using ClassLoader.getSystemResource().");
        xxIXOIIO.oIX0oI(stringBuffer3.toString());
        return ClassLoader.getSystemResource(str);
    }

    public static boolean X0o0xo() {
        return f33232II0xO0;
    }

    public static Class XO(String str) throws ClassNotFoundException {
        if (!f33232II0xO0 && !f33231I0Io) {
            try {
                return oxoX().loadClass(str);
            } catch (Throwable unused) {
                return Class.forName(str);
            }
        }
        return Class.forName(str);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static ClassLoader oxoX() throws IllegalAccessException, InvocationTargetException {
        try {
            Class cls = f33233X0o0xo;
            if (cls == null) {
                cls = oIX0oI("java.lang.Thread");
                f33233X0o0xo = cls;
            }
            return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
