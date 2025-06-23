package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.X00IoxXI;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1239#2,14:109\n1521#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
/* loaded from: classes6.dex */
public class O0xOxO extends StringsKt__StringsKt {
    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character IxoOxx(CharSequence charSequence, Comparator comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return StringsKt___StringsKt.I0o(charSequence, comparator);
    }

    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character OoOoxX0xo(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) > 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(charAt);
    }

    @OXOo.OOXIXo
    public static final SortedSet<Character> Xox0o(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return (SortedSet) StringsKt___StringsKt.OIIoIo(charSequence, new TreeSet());
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character XxI0(CharSequence charSequence, Comparator comparator) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return StringsKt___StringsKt.I00oX(charSequence, comparator);
    }

    @xx0o0O.XO
    public static final char o0Oox0xox(CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return charSequence.charAt(i);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character o0Xo0XII(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return StringsKt___StringsKt.XI0(charSequence);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character oOo0o(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return StringsKt___StringsKt.XOX0XxOxI(charSequence);
    }

    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character oo00Io(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int IXX2 = StringsKt__StringsKt.IXX(charSequence);
        if (IXX2 == 0) {
            return Character.valueOf(charAt);
        }
        R invoke = selector.invoke(Character.valueOf(charAt));
        oOXoIIIo it = new X0.oOoXoXO(1, IXX2).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) < 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(charAt);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @xx0o0O.XO
    public static final BigDecimal oxOII(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @xx0o0O.XO
    public static final BigInteger xxXooOI(CharSequence charSequence, Oox.oOoXoXO<? super Character, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charSequence.charAt(i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }
}
