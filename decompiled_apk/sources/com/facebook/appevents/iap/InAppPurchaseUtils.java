package com.facebook.appevents.iap;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class InAppPurchaseUtils {

    @OOXIXo
    public static final InAppPurchaseUtils INSTANCE = new InAppPurchaseUtils();

    private InAppPurchaseUtils() {
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Class<?> getClass(@OOXIXo String className) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseUtils.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(className, "className");
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseUtils.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Class<?> getClassFromContext$facebook_core_release(@OOXIXo Context context, @OOXIXo String className) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseUtils.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(className, "className");
            try {
                return context.getClassLoader().loadClass(className);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseUtils.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Method getDeclaredMethod$facebook_core_release(@OOXIXo Class<?> clazz, @OOXIXo String methodName, @OOXIXo Class<?>... args) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseUtils.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(clazz, "clazz");
            IIX0o.x0xO0oo(methodName, "methodName");
            IIX0o.x0xO0oo(args, "args");
            try {
                return clazz.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(args, args.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseUtils.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Method getMethod(@OOXIXo Class<?> clazz, @OOXIXo String methodName, @OOXIXo Class<?>... args) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseUtils.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(clazz, "clazz");
            IIX0o.x0xO0oo(methodName, "methodName");
            IIX0o.x0xO0oo(args, "args");
            try {
                return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(args, args.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseUtils.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Object invokeMethod(@OOXIXo Class<?> clazz, @OOXIXo Method method, @oOoXoXO Object obj, @OOXIXo Object... args) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseUtils.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(clazz, "clazz");
            IIX0o.x0xO0oo(method, "method");
            IIX0o.x0xO0oo(args, "args");
            if (obj != null) {
                obj = clazz.cast(obj);
            }
            try {
                return method.invoke(obj, Arrays.copyOf(args, args.length));
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseUtils.class);
            return null;
        }
    }
}
