package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class IXxxXO {
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Appendable I0Io(Appendable appendable) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append('\n');
        IIX0o.oO(append, "append(...)");
        return append;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void II0xO0(@OXOo.OOXIXo Appendable appendable, T t, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        boolean z;
        IIX0o.x0xO0oo(appendable, "<this>");
        if (oooxoxo != null) {
            appendable.append(oooxoxo.invoke(t));
            return;
        }
        if (t == 0) {
            z = true;
        } else {
            z = t instanceof CharSequence;
        }
        if (z) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Appendable X0o0xo(Appendable appendable, CharSequence charSequence) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        IIX0o.oO(append, "append(...)");
        Appendable append2 = append.append('\n');
        IIX0o.oO(append2, "append(...)");
        return append2;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T extends Appendable> T XO(@OXOo.OOXIXo T t, @OXOo.OOXIXo CharSequence value, int i, int i2) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(value, "value");
        T t2 = (T) t.append(value, i, i2);
        IIX0o.x0XOIxOo(t2, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t2;
    }

    @OXOo.OOXIXo
    public static final <T extends Appendable> T oIX0oI(@OXOo.OOXIXo T t, @OXOo.OOXIXo CharSequence... value) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(value, "value");
        for (CharSequence charSequence : value) {
            t.append(charSequence);
        }
        return t;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Appendable oxoX(Appendable appendable, char c) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append(c);
        IIX0o.oO(append, "append(...)");
        Appendable append2 = append.append('\n');
        IIX0o.oO(append2, "append(...)");
        return append2;
    }
}
