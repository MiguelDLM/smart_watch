package kotlin.text;

import java.util.Set;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class oI0IIXIo extends Oxx0xo {
    @xx0o0O.XO
    public static final Regex IIXOooo(String str, RegexOption option) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(option, "option");
        return new Regex(str, option);
    }

    @xx0o0O.XO
    public static final Regex OxxIIOOXO(String str, Set<? extends RegexOption> options) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(options, "options");
        return new Regex(str, options);
    }

    @xx0o0O.XO
    public static final Regex oI0IIXIo(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return new Regex(str);
    }
}
