package kotlin;

/* loaded from: classes6.dex */
public class oxXx0IX {
    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final <T> T I0Io(T t, Oox.oOoXoXO<? super T, oXIO0o0XI> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        block.invoke(t);
        return t;
    }

    @xx0o0O.XO
    public static final <T, R> R II0XooXoX(T t, Oox.oOoXoXO<? super T, ? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        return block.invoke(t);
    }

    @xx0o0O.XO
    public static final Void II0xO0(String reason) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(reason, "reason");
        throw new NotImplementedError("An operation is not implemented: " + reason);
    }

    @xx0o0O.XO
    public static final <T, R> R OOXIXo(T t, Oox.oOoXoXO<? super T, ? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        return block.invoke(t);
    }

    @xx0o0O.XO
    public static final <R> R Oxx0IOOO(Oox.oIX0oI<? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        return block.invoke();
    }

    @xx0o0O.XO
    public static final <T, R> R X0o0xo(T t, Oox.oOoXoXO<? super T, ? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        return block.invoke(t);
    }

    @xx0o0O.XO
    public static final void XO(int i, Oox.oOoXoXO<? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (int i2 = 0; i2 < i; i2++) {
            action.invoke(Integer.valueOf(i2));
        }
    }

    @xx0o0O.XO
    public static final Void oIX0oI() {
        throw new NotImplementedError(null, 1, null);
    }

    @xx0o0O.XO
    public static final <T> T oxoX(T t, Oox.oOoXoXO<? super T, oXIO0o0XI> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        block.invoke(t);
        return t;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final <T> T xoIox(T t, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (predicate.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final <T> T xxIXOIIO(T t, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (!predicate.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }
}
