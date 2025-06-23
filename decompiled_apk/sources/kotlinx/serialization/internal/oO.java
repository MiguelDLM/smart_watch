package kotlinx.serialization.internal;

import java.util.List;

/* loaded from: classes6.dex */
public final class oO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final boolean f30728oIX0oI;

    static {
        boolean z;
        try {
            Class.forName("java.lang.ClassValue");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        f30728oIX0oI = z;
    }

    @OXOo.OOXIXo
    public static final <T> XX0xXo<T> II0xO0(@OXOo.OOXIXo Oox.x0xO0oo<? super kotlin.reflect.oxoX<Object>, ? super List<? extends kotlin.reflect.Oxx0xo>, ? extends kotlinx.serialization.Oxx0IOOO<T>> factory) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(factory, "factory");
        if (f30728oIX0oI) {
            return new ClassValueParametrizedCache(factory);
        }
        return new OxI(factory);
    }

    @OXOo.OOXIXo
    public static final <T> O0X<T> oIX0oI(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.reflect.oxoX<?>, ? extends kotlinx.serialization.Oxx0IOOO<T>> factory) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(factory, "factory");
        if (f30728oIX0oI) {
            return new ClassValueCache(factory);
        }
        return new o00(factory);
    }
}
