package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class IIXOooo extends OxxIIOOXO {
    @OXOo.OOXIXo
    public static final StringBuilder I0oOIX(@OXOo.OOXIXo StringBuilder sb, @OXOo.OOXIXo Object... value) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder IoOoo(StringBuilder sb, char c) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(c);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder Ioxxx(StringBuilder sb, char[] value) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        sb.append(value);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @XX(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder O0Xx(StringBuilder sb, char[] str, int i, int i2) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(str, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder OO(StringBuilder sb) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder OO0x0xX(StringBuilder sb, String str) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(str);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder XIo0oOXIx(StringBuilder sb, boolean z) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(z);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    public static final String XX0xXo(Oox.oOoXoXO<? super StringBuilder, oXIO0o0XI> builderAction) {
        IIX0o.x0xO0oo(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @XX(expression = "append(value = obj)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder XoI0Ixx0(StringBuilder sb, Object obj) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(obj);
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder x0xO(StringBuilder sb, Object obj) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(obj);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xoIxX(StringBuilder sb, CharSequence charSequence) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(charSequence);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final StringBuilder xoxXI(@OXOo.OOXIXo StringBuilder sb, @OXOo.OOXIXo String... value) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final String xxIO(int i, Oox.oOoXoXO<? super StringBuilder, oXIO0o0XI> builderAction) {
        IIX0o.x0xO0oo(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i);
        builderAction.invoke(sb);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }
}
