package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.DeprecationLevel;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
/* loaded from: classes6.dex */
public class OxxIIOOXO extends oI0IIXIo {
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder I0X0x0oIo(StringBuilder sb, int i, int i2, String value) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        StringBuilder replace = sb.replace(i, i2, value);
        IIX0o.oO(replace, "replace(...)");
        return replace;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder I0oOoX(StringBuilder sb, char[] value) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        sb.append(value);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine()", imports = {}))
    @OXOo.OOXIXo
    public static final Appendable IIX0o(@OXOo.OOXIXo Appendable appendable) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append(X0IIOO.f29523II0xO0);
        IIX0o.oO(append, "append(...)");
        return append;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder IO(StringBuilder sb, long j) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(j);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder Io(StringBuilder sb, StringBuilder sb2) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((CharSequence) sb2);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder IoOoX(StringBuilder sb, char c) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(c);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder O0xOxO(StringBuilder sb, int i) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(i);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder OI0(StringBuilder sb, StringBuffer stringBuffer) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(stringBuffer);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder OxI(StringBuilder sb, float f) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(f);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder X00IoxXI(StringBuilder sb, int i) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(i);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder X0IIOO(StringBuilder sb, long j) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(j);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder XI0IXoo(StringBuilder sb, StringBuffer stringBuffer) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(stringBuffer);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder XIxXXX0x0(StringBuilder sb, StringBuilder sb2) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((CharSequence) sb2);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder XOxIOxOx(StringBuilder sb, String str) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(str);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder XX(StringBuilder sb, boolean z) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(z);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @xx0o0O.XO
    public static final void XX0(StringBuilder sb, int i, char c) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.setCharAt(i, c);
    }

    public static /* synthetic */ void Xo0(StringBuilder sb, char[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder XoX(StringBuilder sb, int i) {
        IIX0o.x0xO0oo(sb, "<this>");
        StringBuilder deleteCharAt = sb.deleteCharAt(i);
        IIX0o.oO(deleteCharAt, "deleteCharAt(...)");
        return deleteCharAt;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder Xx000oIo(StringBuilder sb, float f) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(f);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder XxX0x0xxx(StringBuilder sb, CharSequence value, int i, int i2) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        sb.append(value, i, i2);
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder o0(StringBuilder sb, short s) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((int) s);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder o00(StringBuilder sb, double d) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(d);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder oOXoIIIo(StringBuilder sb, double d) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(d);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oX(StringBuilder sb, char[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder oo(StringBuilder sb, byte b) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((int) b);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine()", imports = {}))
    @OXOo.OOXIXo
    public static final StringBuilder oo0xXOI0I(@OXOo.OOXIXo StringBuilder sb) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(X0IIOO.f29523II0xO0);
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final Appendable ooXIXxIX(Appendable appendable, char c) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append(c);
        IIX0o.oO(append, "append(...)");
        return IIX0o(append);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder oxXx0IX(StringBuilder sb, int i, int i2) {
        IIX0o.x0xO0oo(sb, "<this>");
        StringBuilder delete = sb.delete(i, i2);
        IIX0o.oO(delete, "delete(...)");
        return delete;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static StringBuilder oxxXoxO(@OXOo.OOXIXo StringBuilder sb) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder x0o(StringBuilder sb, Object obj) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(obj);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final Appendable xI(Appendable appendable, CharSequence charSequence) {
        IIX0o.x0xO0oo(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        IIX0o.oO(append, "append(...)");
        return IIX0o(append);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @kotlin.XX(expression = "appendLine(value)", imports = {}))
    @xx0o0O.XO
    public static final StringBuilder xII(StringBuilder sb, CharSequence charSequence) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append(charSequence);
        IIX0o.oO(sb, "append(...)");
        return oo0xXOI0I(sb);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xXOx(StringBuilder sb, int i, char[] value, int i2, int i3) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        StringBuilder insert = sb.insert(i, value, i2, i3 - i2);
        IIX0o.oO(insert, "insert(...)");
        return insert;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xXxxox0I(StringBuilder sb, char[] value, int i, int i2) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        sb.append(value, i, i2 - i);
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xo0x(StringBuilder sb, int i, CharSequence value, int i2, int i3) {
        IIX0o.x0xO0oo(sb, "<this>");
        IIX0o.x0xO0oo(value, "value");
        StringBuilder insert = sb.insert(i, value, i2, i3);
        IIX0o.oO(insert, "insert(...)");
        return insert;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xoXoI(StringBuilder sb, byte b) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((int) b);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final StringBuilder xxX(StringBuilder sb, short s) {
        IIX0o.x0xO0oo(sb, "<this>");
        sb.append((int) s);
        IIX0o.oO(sb, "append(...)");
        sb.append('\n');
        IIX0o.oO(sb, "append(...)");
        return sb;
    }
}
