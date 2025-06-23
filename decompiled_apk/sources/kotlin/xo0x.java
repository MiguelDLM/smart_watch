package kotlin;

/* loaded from: classes6.dex */
public class xo0x extends oxXx0IX {
    @xx0o0O.XO
    public static final <R> R oOoXoXO(Object lock, Oox.oIX0oI<? extends R> block) {
        R invoke;
        kotlin.jvm.internal.IIX0o.x0xO0oo(lock, "lock");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th;
            }
        }
        kotlin.jvm.internal.xxX.I0Io(1);
        return invoke;
    }
}
