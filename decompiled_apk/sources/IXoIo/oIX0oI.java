package IXoIo;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes13.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Method f752I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Map<Class<?>, WeakReference<II0xO0[]>> f753II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static Method f755Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Method f756X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static Method f757XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Method f759oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final II0xO0[] f758oIX0oI = new II0xO0[0];

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Class<?> f754II0xO0 = oIX0oI();

    static {
        Method II0xO02 = II0xO0();
        f752I0Io = II0xO02;
        Method I0Io2 = I0Io("getPropertyDescriptors", II0xO02, false);
        f759oxoX = I0Io2;
        f756X0o0xo = I0Io("getWriteMethod", I0Io2, true);
        f757XO = I0Io("getReadMethod", I0Io2, true);
        f755Oxx0IOOO = I0Io("getName", I0Io2, true);
        f753II0XooXoX = new ConcurrentHashMap();
    }

    public static Method I0Io(String str, Method method, boolean z) {
        if (method == null) {
            return null;
        }
        try {
            Class<?> returnType = method.getReturnType();
            if (z) {
                returnType = returnType.getComponentType();
            }
            return returnType.getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Method II0xO0() {
        Class<?> cls = f754II0xO0;
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("getBeanInfo", Class.class, Class.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> oIX0oI() {
        try {
            try {
                return Class.forName("com.googlecode.openbeans.Introspector");
            } catch (Throwable unused) {
                return Class.forName("java.beans.Introspector");
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static II0xO0[] oxoX(Class<?> cls) {
        II0xO0[] iI0xO0Arr;
        Method method = f759oxoX;
        if (method == null) {
            return f758oIX0oI;
        }
        WeakReference<II0xO0[]> weakReference = f753II0XooXoX.get(cls);
        if (weakReference != null) {
            iI0xO0Arr = weakReference.get();
        } else {
            iI0xO0Arr = null;
        }
        if (iI0xO0Arr == null) {
            try {
                Object[] objArr = (Object[]) method.invoke(f752I0Io.invoke(null, cls, Object.class), null);
                iI0xO0Arr = new II0xO0[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    iI0xO0Arr[i] = new II0xO0(objArr[i]);
                }
            } catch (Exception unused) {
                iI0xO0Arr = f758oIX0oI;
            }
            f753II0XooXoX.put(cls, new WeakReference<>(iI0xO0Arr));
        }
        return iI0xO0Arr;
    }
}
