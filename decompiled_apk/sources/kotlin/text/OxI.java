package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.IIX0;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,829:1\n1174#2,2:830\n1#3:832\n1726#4,3:833\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:830,2\n624#1:833,3\n*E\n"})
/* loaded from: classes6.dex */
public class OxI extends o00 {
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String I0xX0(@OXOo.OOXIXo char[] cArr) {
        IIX0o.x0xO0oo(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ String IIOIX(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return Xo(str, str2, str3, z);
    }

    @xx0o0O.XO
    public static final String IO0XoXxO(int[] codePoints, int i, int i2) {
        IIX0o.x0xO0oo(codePoints, "codePoints");
        return new String(codePoints, i, i2);
    }

    public static /* synthetic */ boolean IOOoXo0Ix(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return xIXIOX(str, str2, z);
    }

    @xx0o0O.XO
    public static final int IOoo(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.codePointBefore(i);
    }

    @xx0o0O.XO
    public static final String IoXIXo(StringBuilder stringBuilder) {
        IIX0o.x0xO0oo(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }

    @xx0o0O.XO
    public static final byte[] Ix0(String str, Charset charset) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        return bytes;
    }

    @OXOo.OOXIXo
    public static final List<String> IxIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Pattern regex, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        StringsKt__StringsKt.ox0(i);
        if (i == 0) {
            i = -1;
        }
        String[] split = regex.split(charSequence, i);
        IIX0o.oO(split, "split(...)");
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(split);
    }

    public static boolean IxX00(@OXOo.OOXIXo String str, @OXOo.OOXIXo String suffix, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (!z) {
            return str.endsWith(suffix);
        }
        return OOIXx0x(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ String O00(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return xxxI(bArr, i, i2, z);
    }

    @xx0o0O.XO
    public static final String O0IxXx(StringBuffer stringBuffer) {
        IIX0o.x0xO0oo(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    public static /* synthetic */ char[] O0OOX0IIx(String str, char[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        str.getChars(i2, i3, destination, i);
        return destination;
    }

    @kotlin.OOXIXo(message = "Use uppercase() instead.", replaceWith = @kotlin.XX(expression = "uppercase(locale)", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String O0x(String str, Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte[] O0xxXxI(@OXOo.OOXIXo String str, int i, int i2, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        kotlin.collections.II0xO0.Companion.oIX0oI(i, i2, str.length());
        if (!z) {
            String substring = str.substring(i, i2);
            IIX0o.oO(substring, "substring(...)");
            Charset charset = oxoX.f29581II0xO0;
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            IIX0o.oO(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder newEncoder = oxoX.f29581II0xO0.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer encode = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            IIX0o.ooOOo0oXI(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                IIX0o.ooOOo0oXI(array2);
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.II0XooXoX
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @kotlin.OOXIXo(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.XX(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String OIx00oxx(@OXOo.OOXIXo String str, @OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        if (str.length() > 0 && !Character.isLowerCase(str.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 1);
            IIX0o.oO(substring, "substring(...)");
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(locale);
            IIX0o.oO(lowerCase, "toLowerCase(...)");
            sb.append(lowerCase);
            String substring2 = str.substring(1);
            IIX0o.oO(substring2, "substring(...)");
            sb.append(substring2);
            return sb.toString();
        }
        return str;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String OIxOX(String str, Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @kotlin.OOXIXo(message = "Use lowercase() instead.", replaceWith = @kotlin.XX(expression = "lowercase(locale)", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String OIxx0I0(String str, Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @xx0o0O.XO
    public static final boolean OO0(String str, StringBuffer stringBuilder) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    public static boolean OOIXx0x(@OXOo.OOXIXo String str, int i, @OXOo.OOXIXo String other, int i2, int i3, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (!z) {
            return str.regionMatches(i, other, i2, i3);
        }
        return str.regionMatches(z, i, other, i2, i3);
    }

    @OXOo.OOXIXo
    public static Comparator<String> OOOI(@OXOo.OOXIXo kotlin.jvm.internal.oxxXoxO oxxxoxo) {
        IIX0o.x0xO0oo(oxxxoxo, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        IIX0o.oO(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    @xx0o0O.XO
    public static final int OOxOI(String str, char c, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.lastIndexOf(c, i);
    }

    public static /* synthetic */ String OX(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return Oxx(cArr, i, i2);
    }

    @xx0o0O.XO
    public static final int OXXoIoXI(String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.offsetByCodePoints(i, i2);
    }

    @kotlin.OOXIXo(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.XX(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @OXOo.OOXIXo
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String OooI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        if (str.length() > 0 && !Character.isLowerCase(str.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 1);
            IIX0o.oO(substring, "substring(...)");
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase();
            IIX0o.oO(lowerCase, "toLowerCase(...)");
            sb.append(lowerCase);
            String substring2 = str.substring(1);
            IIX0o.oO(substring2, "substring(...)");
            sb.append(substring2);
            return sb.toString();
        }
        return str;
    }

    public static /* synthetic */ Pattern OooO0XOx(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(str, "<this>");
        Pattern compile = Pattern.compile(str, i);
        IIX0o.oO(compile, "compile(...)");
        return compile;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String OxO(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String OxXXx0X(kotlin.jvm.internal.oxxXoxO oxxxoxo, Locale locale, String format, Object... args) {
        IIX0o.x0xO0oo(oxxxoxo, "<this>");
        IIX0o.x0xO0oo(format, "format");
        IIX0o.x0xO0oo(args, "args");
        String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        IIX0o.oO(format2, "format(...)");
        return format2;
    }

    @xx0o0O.XO
    public static final String Oxo00O(String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        String substring = str.substring(i, i2);
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String Oxx(@OXOo.OOXIXo char[] cArr, int i, int i2) {
        IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.collections.II0xO0.Companion.oIX0oI(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    @xx0o0O.XO
    public static final int X00xOoXI(String str, String str2, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(str2, "str");
        return str.indexOf(str2, i);
    }

    @xx0o0O.XO
    public static final String X0IOOI(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        String substring = str.substring(i);
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    public static boolean X0O0I0(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable OIxI0O2 = StringsKt__StringsKt.OIxI0O(charSequence);
            if (!(OIxI0O2 instanceof Collection) || !((Collection) OIxI0O2).isEmpty()) {
                Iterator it = OIxI0O2.iterator();
                while (it.hasNext()) {
                    if (!II0xO0.IXxxXO(charSequence.charAt(((oOXoIIIo) it).nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final String X0ooXIooI(@OXOo.OOXIXo String str, @OXOo.OOXIXo String oldValue, @OXOo.OOXIXo String newValue, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(oldValue, "oldValue");
        IIX0o.x0xO0oo(newValue, "newValue");
        int O0O0Io00X2 = StringsKt__StringsKt.O0O0Io00X(str, oldValue, 0, z, 2, null);
        if (O0O0Io00X2 >= 0) {
            return StringsKt__StringsKt.xOx(str, O0O0Io00X2, oldValue.length() + O0O0Io00X2, newValue).toString();
        }
        return str;
    }

    @xx0o0O.XO
    public static final String X0xII0I(char[] chars) {
        IIX0o.x0xO0oo(chars, "chars");
        return new String(chars);
    }

    @xx0o0O.XO
    public static final String X0xxXX0(char[] chars, int i, int i2) {
        IIX0o.x0xO0oo(chars, "chars");
        return new String(chars, i, i2);
    }

    @xx0o0O.XO
    public static final int XI(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.codePointAt(i);
    }

    @xx0o0O.XO
    public static final int XO00XOO(String str, String str2, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(str2, "str");
        return str.lastIndexOf(str2, i);
    }

    public static /* synthetic */ boolean XO0o(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return IxX00(str, str2, z);
    }

    public static boolean XOxoX(@OXOo.OOXIXo String str, @OXOo.OOXIXo String prefix, int i, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix, i);
        }
        return OOIXx0x(str, i, prefix, 0, prefix.length(), z);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.II0XooXoX
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @kotlin.OOXIXo(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.XX(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String XOxxooXI(@OXOo.OOXIXo String str, @OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    IIX0o.oO(substring, "substring(...)");
                    IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = substring.toUpperCase(locale);
                    IIX0o.oO(upperCase, "toUpperCase(...)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                IIX0o.oO(substring2, "substring(...)");
                sb.append(substring2);
                String sb2 = sb.toString();
                IIX0o.oO(sb2, "toString(...)");
                return sb2;
            }
            return str;
        }
        return str;
    }

    public static /* synthetic */ int XXXI(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oXX0IoI(str, str2, z);
    }

    @OXOo.OOXIXo
    public static final String Xo(@OXOo.OOXIXo String str, @OXOo.OOXIXo String oldValue, @OXOo.OOXIXo String newValue, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(oldValue, "oldValue");
        IIX0o.x0xO0oo(newValue, "newValue");
        int i = 0;
        int xIoXXXIXo2 = StringsKt__StringsKt.xIoXXXIXo(str, oldValue, 0, z);
        if (xIoXXXIXo2 < 0) {
            return str;
        }
        int length = oldValue.length();
        int OxxIIOOXO2 = X0.IIXOooo.OxxIIOOXO(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, xIoXXXIXo2);
                sb.append(newValue);
                i = xIoXXXIXo2 + length;
                if (xIoXXXIXo2 >= str.length()) {
                    break;
                }
                xIoXXXIXo2 = StringsKt__StringsKt.xIoXXXIXo(str, oldValue, xIoXXXIXo2 + OxxIIOOXO2, z);
            } while (xIoXXXIXo2 > 0);
            sb.append((CharSequence) str, i, str.length());
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    @xx0o0O.XO
    public static final boolean XoIxOXIXo(String str, CharSequence charSequence) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @OXOo.OOXIXo
    public static final String XoOxI0ox(@OXOo.OOXIXo String str, char c, char c2, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(str, c, 0, z, 2, null);
        if (XxIIOXIXx2 >= 0) {
            return StringsKt__StringsKt.xOx(str, XxIIOXIXx2, XxIIOXIXx2 + 1, String.valueOf(c2)).toString();
        }
        return str;
    }

    public static final boolean XooIO0oo0(@OXOo.OOXIXo CharSequence charSequence, int i, @OXOo.OOXIXo CharSequence other, int i2, int i3, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if ((charSequence instanceof String) && (other instanceof String)) {
            return OOIXx0x((String) charSequence, i, (String) other, i2, i3, z);
        }
        return StringsKt__StringsKt.o0xIoII(charSequence, i, other, i2, i3, z);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final char[] XxIo(@OXOo.OOXIXo String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        kotlin.collections.II0xO0.Companion.oIX0oI(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    @kotlin.OOXIXo(message = "Use uppercase() instead.", replaceWith = @kotlin.XX(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String XxXX(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        String upperCase = str.toUpperCase();
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @oxxXoxO(version = "1.5")
    public static boolean o0IXXIx(@OXOo.oOoXoXO CharSequence charSequence, @OXOo.oOoXoXO CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.IxI(charSequence, charSequence2);
        }
        return oXIoO(charSequence, charSequence2);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String o0Oo(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @xx0o0O.XO
    public static final int o0Xo(String str, char c, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.indexOf(c, i);
    }

    @xx0o0O.XO
    public static final String o0oxo0oI(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        String intern = str.intern();
        IIX0o.oO(intern, "intern(...)");
        return intern;
    }

    @xx0o0O.XO
    public static final int oIIxXoo(String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.codePointCount(i, i2);
    }

    public static /* synthetic */ String oX000x(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return XoOxI0ox(str, c, c2, z);
    }

    public static boolean oX0I0O(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, boolean z) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    @xx0o0O.XO
    public static final String oX0ooo0I0(String str, Object... args) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(args, "args");
        String format = String.format(str, Arrays.copyOf(args, args.length));
        IIX0o.oO(format, "format(...)");
        return format;
    }

    @oxxXoxO(version = "1.5")
    public static final boolean oXIoO(@OXOo.oOoXoXO CharSequence charSequence, @OXOo.oOoXoXO CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt__StringsKt.xIXOoI(charSequence, charSequence2);
    }

    public static /* synthetic */ String oXO0oOx0(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return xIx(str, c, c2, z);
    }

    public static final int oXX0IoI(@OXOo.OOXIXo String str, @OXOo.OOXIXo String other, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (z) {
            return str.compareToIgnoreCase(other);
        }
        return str.compareTo(other);
    }

    @kotlin.OOXIXo(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.XX(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @OXOo.OOXIXo
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String oXxOI0oIx(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        Locale locale = Locale.getDefault();
        IIX0o.oO(locale, "getDefault(...)");
        return XOxxooXI(str, locale);
    }

    public static /* synthetic */ boolean oXxx000(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        boolean z2;
        if ((i4 & 16) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return OOIXx0x(str, i, str2, i2, i3, z2);
    }

    @xx0o0O.XO
    public static final String oo00(kotlin.jvm.internal.oxxXoxO oxxxoxo, String format, Object... args) {
        IIX0o.x0xO0oo(oxxxoxo, "<this>");
        IIX0o.x0xO0oo(format, "format");
        IIX0o.x0xO0oo(args, "args");
        String format2 = String.format(format, Arrays.copyOf(args, args.length));
        IIX0o.oO(format2, "format(...)");
        return format2;
    }

    public static /* synthetic */ char[] oo0oIXo(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return XxIo(str, i, i2);
    }

    @xx0o0O.XO
    public static final char[] oxIO0IIo(String str, char[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        str.getChars(i2, i3, destination, i);
        return destination;
    }

    public static /* synthetic */ byte[] oxOXxoXII(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return O0xxXxI(str, i, i2, z);
    }

    @xx0o0O.XO
    public static final String x0(byte[] bytes, Charset charset) {
        IIX0o.x0xO0oo(bytes, "bytes");
        IIX0o.x0xO0oo(charset, "charset");
        return new String(bytes, charset);
    }

    public static /* synthetic */ boolean x00IOx(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oX0I0O(str, str2, z);
    }

    @xx0o0O.XO
    public static final String x0OxxIOxX(byte[] bytes, int i, int i2, Charset charset) {
        IIX0o.x0xO0oo(bytes, "bytes");
        IIX0o.x0xO0oo(charset, "charset");
        return new String(bytes, i, i2, charset);
    }

    public static /* synthetic */ List x0oxIIIX(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return IxIo(charSequence, pattern, i);
    }

    public static /* synthetic */ String xIOXX(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return X0ooXIooI(str, str2, str3, z);
    }

    public static boolean xIXIOX(@OXOo.OOXIXo String str, @OXOo.OOXIXo String prefix, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix);
        }
        return OOIXx0x(str, 0, prefix, 0, prefix.length(), z);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String xIXX(@OXOo.OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return new String(bArr, oxoX.f29581II0xO0);
    }

    @OXOo.OOXIXo
    public static final String xIx(@OXOo.OOXIXo String str, char c, char c2, boolean z) {
        IIX0o.x0xO0oo(str, "<this>");
        if (!z) {
            String replace = str.replace(c, c2);
            IIX0o.oO(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (I0Io.oo0xXOI0I(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ boolean xIx0XO(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z, int i4, Object obj) {
        boolean z2;
        if ((i4 & 16) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return XooIO0oo0(charSequence, i, charSequence2, i2, i3, z2);
    }

    @xx0o0O.XO
    public static final char[] xIxooxXX(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        char[] charArray = str.toCharArray();
        IIX0o.oO(charArray, "toCharArray(...)");
        return charArray;
    }

    @OXOo.OOXIXo
    public static String xOOxI(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return "";
            }
            if (i != 1) {
                int length = charSequence.length();
                if (length == 0) {
                    return "";
                }
                if (length != 1) {
                    StringBuilder sb = new StringBuilder(charSequence.length() * i);
                    oOXoIIIo it = new X0.oOoXoXO(1, i).iterator();
                    while (it.hasNext()) {
                        it.nextInt();
                        sb.append(charSequence);
                    }
                    String sb2 = sb.toString();
                    IIX0o.ooOOo0oXI(sb2);
                    return sb2;
                }
                char charAt = charSequence.charAt(0);
                char[] cArr = new char[i];
                for (int i2 = 0; i2 < i; i2++) {
                    cArr[i2] = charAt;
                }
                return new String(cArr);
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static byte[] xOOxIO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        byte[] bytes = str.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return bytes;
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String xX(String str, Locale locale, Object... args) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(args, "args");
        String format = String.format(locale, str, Arrays.copyOf(args, args.length));
        IIX0o.oO(format, "format(...)");
        return format;
    }

    @xx0o0O.XO
    public static final String xXoOI00O(byte[] bytes, int i, int i2) {
        IIX0o.x0xO0oo(bytes, "bytes");
        return new String(bytes, i, i2, oxoX.f29581II0xO0);
    }

    public static /* synthetic */ boolean xo(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return XOxoX(str, str2, i, z);
    }

    @kotlin.OOXIXo(message = "Use lowercase() instead.", replaceWith = @kotlin.XX(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final String xoX(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        String lowerCase = str.toLowerCase();
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static /* synthetic */ byte[] xox(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        return bytes;
    }

    @xx0o0O.XO
    public static final Pattern xx0(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        Pattern compile = Pattern.compile(str, i);
        IIX0o.oO(compile, "compile(...)");
        return compile;
    }

    @xx0o0O.XO
    public static final String xxOXOOoIX(byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        return new String(bytes, oxoX.f29581II0xO0);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String xxx00(String str, Locale locale) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final String xxxI(@OXOo.OOXIXo byte[] bArr, int i, int i2, boolean z) {
        IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.collections.II0xO0.Companion.oIX0oI(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, oxoX.f29581II0xO0);
        }
        CharsetDecoder newDecoder = oxoX.f29581II0xO0.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String charBuffer = newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        IIX0o.oO(charBuffer, "toString(...)");
        return charBuffer;
    }
}
