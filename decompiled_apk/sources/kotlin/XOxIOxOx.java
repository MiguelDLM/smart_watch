package kotlin;

@kotlin.jvm.internal.XX({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
/* loaded from: classes6.dex */
public class XOxIOxOx extends x0o {
    @xx0o0O.XO
    public static final void I0Io(boolean z) {
        if (z) {
        } else {
            throw new IllegalStateException("Check failed.");
        }
    }

    @xx0o0O.XO
    public static final void II0XooXoX(boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @xx0o0O.XO
    public static final <T> T OOXIXo(T t, Oox.oIX0oI<? extends Object> lazyMessage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }

    @xx0o0O.XO
    public static final Void Oxx0IOOO(Object message) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @xx0o0O.XO
    public static final <T> T X0o0xo(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @xx0o0O.XO
    public static final <T> T XO(T t, Oox.oIX0oI<? extends Object> lazyMessage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(lazyMessage.invoke().toString());
    }

    @xx0o0O.XO
    public static final void oxoX(boolean z, Oox.oIX0oI<? extends Object> lazyMessage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lazyMessage, "lazyMessage");
        if (z) {
        } else {
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }
    }

    @xx0o0O.XO
    public static final <T> T xoIox(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @xx0o0O.XO
    public static final void xxIXOIIO(boolean z, Oox.oIX0oI<? extends Object> lazyMessage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lazyMessage, "lazyMessage");
        if (z) {
        } else {
            throw new IllegalArgumentException(lazyMessage.invoke().toString());
        }
    }
}
