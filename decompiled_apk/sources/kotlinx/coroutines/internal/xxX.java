package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.o0oIxOo;

@kotlin.jvm.internal.XX({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: classes6.dex */
public final class xxX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final boolean f30324II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30325oIX0oI = "kotlinx.coroutines.fast.service.loader";

    public static /* synthetic */ void I0Io() {
    }

    public static /* synthetic */ XxX0x0xxx II0xO0(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return oIX0oI(th, str);
    }

    @OXOo.OOXIXo
    public static final Void X0o0xo() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @OXOo.OOXIXo
    @OX00O0xII
    public static final o0oIxOo XO(@OXOo.OOXIXo XI0IXoo xI0IXoo, @OXOo.OOXIXo List<? extends XI0IXoo> list) {
        try {
            return xI0IXoo.I0Io(list);
        } catch (Throwable th) {
            return oIX0oI(th, xI0IXoo.II0xO0());
        }
    }

    public static final XxX0x0xxx oIX0oI(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        X0o0xo();
        throw new KotlinNothingValueException();
    }

    @OX00O0xII
    public static final boolean oxoX(@OXOo.OOXIXo o0oIxOo o0oixoo) {
        return o0oixoo.IIXOooo() instanceof XxX0x0xxx;
    }
}
