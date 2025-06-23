package oX0O;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public final class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static Method f32091I0Io = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static Class<?> f32092II0XooXoX = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static Class<?> f32093II0xO0 = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static Method f32094Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Class<?> f32095X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public static Method f32096XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32097oIX0oI = "SkinCompatUtils";

    /* renamed from: oxoX, reason: collision with root package name */
    public static Method f32098oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public static Method f32099xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static Method f32100xxIXOIIO;

    static {
        try {
            f32095X0o0xo = Class.forName("android.support.v4.graphics.drawable.WrappedDrawable");
        } catch (ClassNotFoundException unused) {
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(f32097oIX0oI, "hasV4WrappedDrawable = false");
            }
        }
        try {
            f32093II0xO0 = Class.forName("android.support.v4.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException unused2) {
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(f32097oIX0oI, "hasV4DrawableWrapper = false");
            }
        }
        try {
            f32092II0XooXoX = Class.forName("android.support.v7.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException unused3) {
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(f32097oIX0oI, "hasV7DrawableWrapper = false");
            }
        }
    }

    public static Drawable I0Io(Drawable drawable) {
        Class<?> cls = f32092II0XooXoX;
        if (cls != null) {
            if (f32100xxIXOIIO == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", null);
                    f32100xxIXOIIO = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV7DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32100xxIXOIIO;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, null);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV7DrawableWrapperWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
        return drawable;
    }

    public static boolean II0XooXoX(Drawable drawable) {
        Class<?> cls = f32095X0o0xo;
        if (cls != null && cls.isAssignableFrom(drawable.getClass())) {
            return true;
        }
        return false;
    }

    public static Drawable II0xO0(Drawable drawable) {
        Class<?> cls = f32095X0o0xo;
        if (cls != null) {
            if (f32096XO == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", null);
                    f32096XO = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32096XO;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, null);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV4WrappedDrawableWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
        return drawable;
    }

    public static void OOXIXo(Drawable drawable, Drawable drawable2) {
        Class<?> cls = f32095X0o0xo;
        if (cls != null) {
            if (f32094Oxx0IOOO == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f32094Oxx0IOOO = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32094Oxx0IOOO;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV4WrappedDrawableWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
    }

    public static boolean Oxx0IOOO(Drawable drawable) {
        Class<?> cls = f32093II0xO0;
        if (cls != null && cls.isAssignableFrom(drawable.getClass())) {
            return true;
        }
        return false;
    }

    public static boolean X0o0xo() {
        if (f32095X0o0xo != null) {
            return true;
        }
        return false;
    }

    public static boolean XO() {
        if (f32092II0XooXoX != null) {
            return true;
        }
        return false;
    }

    public static Drawable oIX0oI(Drawable drawable) {
        Class<?> cls = f32093II0xO0;
        if (cls != null) {
            if (f32091I0Io == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", null);
                    f32091I0Io = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32091I0Io;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, null);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "getV4DrawableWrapperWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
        return drawable;
    }

    public static void oOoXoXO(Drawable drawable, Drawable drawable2) {
        Class<?> cls = f32092II0XooXoX;
        if (cls != null) {
            if (f32099xoIox == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f32099xoIox = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV7DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32099xoIox;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV7DrawableWrapperWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
    }

    public static boolean oxoX() {
        if (f32093II0xO0 != null) {
            return true;
        }
        return false;
    }

    public static void xoIox(Drawable drawable, Drawable drawable2) {
        Class<?> cls = f32093II0xO0;
        if (cls != null) {
            if (f32098oxoX == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f32098oxoX = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f32098oxoX;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e) {
                    if (xoIox.f32102oIX0oI) {
                        xoIox.II0xO0(f32097oIX0oI, "setV4DrawableWrapperWrappedDrawable invoke error: " + e);
                    }
                }
            }
        }
    }

    public static boolean xxIXOIIO(Drawable drawable) {
        Class<?> cls = f32092II0XooXoX;
        if (cls != null && cls.isAssignableFrom(drawable.getClass())) {
            return true;
        }
        return false;
    }
}
