package IXIxx0;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    @oOoXoXO
    public static oIX0oI f725I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final Oxx0IOOO f727oIX0oI = new Oxx0IOOO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f726II0xO0 = new oIX0oI(null, null, null);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @XO0OX.XO
        @oOoXoXO
        public final Method f728I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @XO0OX.XO
        @oOoXoXO
        public final Method f729II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @XO0OX.XO
        @oOoXoXO
        public final Method f730oIX0oI;

        public oIX0oI(@oOoXoXO Method method, @oOoXoXO Method method2, @oOoXoXO Method method3) {
            this.f730oIX0oI = method;
            this.f729II0xO0 = method2;
            this.f728I0Io = method3;
        }
    }

    @oOoXoXO
    public final String II0xO0(@OOXIXo BaseContinuationImpl continuation) {
        Object obj;
        Object obj2;
        Object obj3;
        IIX0o.x0xO0oo(continuation, "continuation");
        oIX0oI oix0oi = f725I0Io;
        if (oix0oi == null) {
            oix0oi = oIX0oI(continuation);
        }
        if (oix0oi == f726II0xO0) {
            return null;
        }
        Method method = oix0oi.f730oIX0oI;
        if (method != null) {
            obj = method.invoke(continuation.getClass(), null);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = oix0oi.f729II0xO0;
        if (method2 != null) {
            obj2 = method2.invoke(obj, null);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = oix0oi.f728I0Io;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, null);
        } else {
            obj3 = null;
        }
        if (!(obj3 instanceof String)) {
            return null;
        }
        return (String) obj3;
    }

    public final oIX0oI oIX0oI(BaseContinuationImpl baseContinuationImpl) {
        try {
            oIX0oI oix0oi = new oIX0oI(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f725I0Io = oix0oi;
            return oix0oi;
        } catch (Exception unused) {
            oIX0oI oix0oi2 = f726II0xO0;
            f725I0Io = oix0oi2;
            return oix0oi2;
        }
    }
}
