package xxxoo0XI;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.random.Random;

/* loaded from: classes6.dex */
public class I0Io extends XIxO.oIX0oI {

    @XX({"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        @XO
        @oOoXoXO
        public static final Integer f35577II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public static final oIX0oI f35578oIX0oI = new oIX0oI();

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
                f35577II0xO0 = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f35577II0xO0 = num2;
        }
    }

    @Override // xx0o0O.oOoXoXO
    @oOoXoXO
    public kotlin.text.OOXIXo I0Io(@OOXIXo MatchResult matchResult, @OOXIXo String name) {
        Matcher matcher;
        int start;
        int end;
        String group;
        IIX0o.x0xO0oo(matchResult, "matchResult");
        IIX0o.x0xO0oo(name, "name");
        if (matchResult instanceof Matcher) {
            matcher = (Matcher) matchResult;
        } else {
            matcher = null;
        }
        if (matcher != null) {
            start = matcher.start(name);
            end = matcher.end(name);
            X0.oOoXoXO oooxoxo = new X0.oOoXoXO(start, end - 1);
            if (oooxoxo.getStart().intValue() >= 0) {
                group = matcher.group(name);
                IIX0o.oO(group, "group(...)");
                return new kotlin.text.OOXIXo(group, oooxoxo);
            }
            return null;
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @Override // xx0o0O.oOoXoXO
    @OOXIXo
    public Random II0xO0() {
        if (X0o0xo(34)) {
            return new o0xOIoxo.oIX0oI();
        }
        return super.II0xO0();
    }

    public final boolean X0o0xo(int i) {
        Integer num = oIX0oI.f35577II0xO0;
        if (num != null && num.intValue() < i) {
            return false;
        }
        return true;
    }
}
