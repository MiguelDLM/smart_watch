package xx0o0O;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.random.Random;

@XX({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
/* loaded from: classes6.dex */
public class oOoXoXO {

    @XX({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public static final Method f35288I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public static final Method f35289II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final oIX0oI f35290oIX0oI = new oIX0oI();

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            IIX0o.ooOOo0oXI(methods);
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 < length) {
                    method2 = methods[i2];
                    if (IIX0o.Oxx0IOOO(method2.getName(), "addSuppressed")) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        IIX0o.oO(parameterTypes, "getParameterTypes(...)");
                        if (IIX0o.Oxx0IOOO(ArraysKt___ArraysKt.OI0oXX(parameterTypes), Throwable.class)) {
                            break;
                        }
                    }
                    i2++;
                } else {
                    method2 = null;
                    break;
                }
            }
            f35289II0xO0 = method2;
            int length2 = methods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = methods[i];
                if (IIX0o.Oxx0IOOO(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            f35288I0Io = method;
        }
    }

    @OXOo.oOoXoXO
    public kotlin.text.OOXIXo I0Io(@OXOo.OOXIXo MatchResult matchResult, @OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(matchResult, "matchResult");
        IIX0o.x0xO0oo(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @OXOo.OOXIXo
    public Random II0xO0() {
        return new kotlin.random.II0xO0();
    }

    public void oIX0oI(@OXOo.OOXIXo Throwable cause, @OXOo.OOXIXo Throwable exception) {
        IIX0o.x0xO0oo(cause, "cause");
        IIX0o.x0xO0oo(exception, "exception");
        Method method = oIX0oI.f35289II0xO0;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @OXOo.OOXIXo
    public List<Throwable> oxoX(@OXOo.OOXIXo Throwable exception) {
        Object invoke;
        List<Throwable> oI0IIXIo2;
        IIX0o.x0xO0oo(exception, "exception");
        Method method = oIX0oI.f35288I0Io;
        if (method == null || (invoke = method.invoke(exception, null)) == null || (oI0IIXIo2 = kotlin.collections.ooOOo0oXI.oI0IIXIo((Throwable[]) invoke)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return oI0IIXIo2;
    }
}
