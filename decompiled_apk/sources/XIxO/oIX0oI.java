package XIxO;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.util.List;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import xx0o0O.oOoXoXO;

/* loaded from: classes6.dex */
public class oIX0oI extends oOoXoXO {

    @XX({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    /* renamed from: XIxO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0059oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        @XO
        @OXOo.oOoXoXO
        public static final Integer f3823II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public static final C0059oIX0oI f3824oIX0oI = new C0059oIX0oI();

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                f3823II0xO0 = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f3823II0xO0 = num2;
        }
    }

    private final boolean X0o0xo(int i) {
        Integer num = C0059oIX0oI.f3823II0xO0;
        if (num != null && num.intValue() < i) {
            return false;
        }
        return true;
    }

    @Override // xx0o0O.oOoXoXO
    public void oIX0oI(@OOXIXo Throwable cause, @OOXIXo Throwable exception) {
        IIX0o.x0xO0oo(cause, "cause");
        IIX0o.x0xO0oo(exception, "exception");
        if (X0o0xo(19)) {
            cause.addSuppressed(exception);
        } else {
            super.oIX0oI(cause, exception);
        }
    }

    @Override // xx0o0O.oOoXoXO
    @OOXIXo
    public List<Throwable> oxoX(@OOXIXo Throwable exception) {
        IIX0o.x0xO0oo(exception, "exception");
        if (X0o0xo(19)) {
            Throwable[] suppressed = exception.getSuppressed();
            IIX0o.oO(suppressed, "getSuppressed(...)");
            return ooOOo0oXI.oI0IIXIo(suppressed);
        }
        return super.oxoX(exception);
    }
}
