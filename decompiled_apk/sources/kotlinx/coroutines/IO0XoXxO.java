package kotlinx.coroutines;

@kotlin.jvm.internal.XX({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: classes6.dex */
public final class IO0XoXxO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IO0XoXxO f29694oIX0oI = new IO0XoXxO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ThreadLocal<x0xO> f29693II0xO0 = kotlinx.coroutines.internal.oxXx0IX.II0xO0(new kotlinx.coroutines.internal.x0o("ThreadLocalEventLoop"));

    public final void I0Io() {
        f29693II0xO0.set(null);
    }

    @OXOo.OOXIXo
    public final x0xO II0xO0() {
        ThreadLocal<x0xO> threadLocal = f29693II0xO0;
        x0xO x0xo = threadLocal.get();
        if (x0xo == null) {
            x0xO oIX0oI2 = Ioxxx.oIX0oI();
            threadLocal.set(oIX0oI2);
            return oIX0oI2;
        }
        return x0xo;
    }

    @OXOo.oOoXoXO
    public final x0xO oIX0oI() {
        return f29693II0xO0.get();
    }

    public final void oxoX(@OXOo.OOXIXo x0xO x0xo) {
        f29693II0xO0.set(x0xo);
    }
}
