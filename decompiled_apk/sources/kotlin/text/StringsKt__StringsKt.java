package kotlin.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.X00IoxXI;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.commons.lang3.xXOx;

@XX({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n79#1,22:1487\n113#1,5:1509\n130#1,5:1514\n79#1,22:1519\n107#1:1541\n79#1,22:1542\n113#1,5:1564\n124#1:1569\n113#1,5:1570\n130#1,5:1575\n141#1:1580\n130#1,5:1581\n79#1,22:1586\n113#1,5:1608\n130#1,5:1613\n12554#2,2:1618\n12554#2,2:1620\n288#3,2:1622\n288#3,2:1624\n1549#3:1627\n1620#3,3:1628\n1549#3:1631\n1620#3,3:1632\n1#4:1626\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n107#1:1487,22\n124#1:1509,5\n141#1:1514,5\n146#1:1519,22\n151#1:1541\n151#1:1542,22\n156#1:1564,5\n161#1:1569\n161#1:1570,5\n166#1:1575,5\n171#1:1580\n171#1:1581,5\n176#1:1586,22\n187#1:1608,5\n198#1:1613,5\n940#1:1618,2\n964#1:1620,2\n1003#1:1622,2\n1009#1:1624,2\n1309#1:1627\n1309#1:1628,3\n1334#1:1631\n1334#1:1632,3\n*E\n"})
/* loaded from: classes6.dex */
public class StringsKt__StringsKt extends OxI {

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.collections.IXxxXO {

        /* renamed from: Oo */
        public final /* synthetic */ CharSequence f29517Oo;

        /* renamed from: XO */
        public int f29518XO;

        public oIX0oI(CharSequence charSequence) {
            this.f29517Oo = charSequence;
        }

        @Override // kotlin.collections.IXxxXO
        public char II0xO0() {
            CharSequence charSequence = this.f29517Oo;
            int i = this.f29518XO;
            this.f29518XO = i + 1;
            return charSequence.charAt(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29518XO < this.f29517Oo.length()) {
                return true;
            }
            return false;
        }
    }

    public static /* synthetic */ String I00O(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return x0oox0(charSequence, charSequence2, z);
    }

    @xx0o0O.XO
    public static final String I0O00OI(CharSequence charSequence, int i, int i2) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return charSequence.subSequence(i, i2).toString();
    }

    @OXOo.OOXIXo
    public static String I0OO(@OXOo.OOXIXo String str, int i, char c) {
        IIX0o.x0xO0oo(str, "<this>");
        return X0(str, i, c).toString();
    }

    @xx0o0O.XO
    public static final String I0XIOxO(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Xx0oX(str).toString();
    }

    @OXOo.OOXIXo
    public static final CharSequence II0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        int i;
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean booleanValue = predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else {
                if (!booleanValue) {
                    break;
                }
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static /* synthetic */ String II0OOXOx(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return Xx0(str, c, str2, str3);
    }

    public static final int IIIxO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Collection<String> strings, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(strings, "strings");
        Pair<Integer, String> XIOOI2 = XIOOI(charSequence, strings, i, z, true);
        if (XIOOI2 != null) {
            return XIOOI2.getFirst().intValue();
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final String IIXOxIxOo(@OXOo.OOXIXo String str, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    @OXOo.OOXIXo
    public static final String IIoX0OoI(@OXOo.OOXIXo String str, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence suffix) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (str.length() >= prefix.length() + suffix.length() && Oo0IXI0(str, prefix, false, 2, null) && Ix0x(str, suffix, false, 2, null)) {
            String substring = str.substring(prefix.length(), str.length() - suffix.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    @OXOo.OOXIXo
    public static final String IO0xX(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int O0O0Io00X2 = O0O0Io00X(str, delimiter, 0, false, 6, null);
        if (O0O0Io00X2 != -1) {
            return xOx(str, 0, O0O0Io00X2, replacement).toString();
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static final CharSequence IOI(@OXOo.OOXIXo CharSequence charSequence, int i, int i2) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i2 >= i) {
            if (i2 == i) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            IIX0o.oO(sb, "append(...)");
            sb.append(charSequence, i2, charSequence.length());
            IIX0o.oO(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    @OXOo.OOXIXo
    public static final CharSequence IOOXOOOOo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence delimiter) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        return XXx0OXXXo(charSequence, delimiter, delimiter);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI IOXOxOII(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return XoOOx0IX(charSequence, cArr, i, z, i2);
    }

    public static /* synthetic */ String IOo0(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return IO0xX(str, str2, str3, str4);
    }

    @xx0o0O.XO
    public static final String IOooo0o(String str, int i, int i2, CharSequence replacement) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        return xOx(str, i, i2, replacement).toString();
    }

    public static /* synthetic */ boolean IXI(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return IoxX(charSequence, c, z);
    }

    public static final boolean IXIIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence prefix, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (!z && (charSequence instanceof String) && (prefix instanceof String)) {
            return OxI.xo((String) charSequence, (String) prefix, i, false, 4, null);
        }
        return o0xIoII(charSequence, i, prefix, 0, prefix.length(), z);
    }

    @OXOo.OOXIXo
    public static final kotlin.collections.IXxxXO IXIxx0(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return new oIX0oI(charSequence);
    }

    public static int IXX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int IXXIXx00I(@OXOo.OOXIXo CharSequence charSequence, char c, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return xxXXXxIxo(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ String IXo(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        IIX0o.x0xO0oo(charSequence, "<this>");
        return charSequence.subSequence(i, i2).toString();
    }

    @OXOo.OOXIXo
    public static final String IXoIo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence other, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        int i = 0;
        while (i < min && I0Io.oo0xXOI0I(charSequence.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (x00X0xoXO(charSequence, i2) || x00X0xoXO(other, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    @xx0o0O.XO
    public static final boolean IXxOIOO(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <C extends CharSequence & R, R> R IoX(C c, Oox.oIX0oI<? extends R> defaultValue) {
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (c.length() == 0) {
            return defaultValue.invoke();
        }
        return c;
    }

    @xx0o0O.XO
    public static final String IoXO0XoX(String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        return IOI(str, i, i2).toString();
    }

    @OXOo.OOXIXo
    public static String IoxOx(@OXOo.OOXIXo String str, @OXOo.OOXIXo CharSequence delimiter) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        return IIoX0OoI(str, delimiter, delimiter);
    }

    public static final boolean IoxX(@OXOo.OOXIXo CharSequence charSequence, char c, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() <= 0 || !I0Io.oo0xXOI0I(charSequence.charAt(0), c, z)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean Ix0x(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oXoXxOo(charSequence, charSequence2, z);
    }

    public static final boolean IxI(@OXOo.oOoXoXO CharSequence charSequence, @OXOo.oOoXoXO CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return OxI.oX0I0O((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!I0Io.oo0xXOI0I(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String IxO0Oxo(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = TokenParser.SP;
        }
        return I0OO(str, i, c);
    }

    @OXOo.OOXIXo
    public static final String IxOIO(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int O0O0Io00X2 = O0O0Io00X(str, delimiter, 0, false, 6, null);
        if (O0O0Io00X2 != -1) {
            String substring = str.substring(0, O0O0Io00X2);
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static final String IxOXOxO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<String> O0IoXXOx(@OXOo.OOXIXo final CharSequence charSequence, @OXOo.OOXIXo String[] delimiters, boolean z, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(delimiters, "delimiters");
        return SequencesKt___SequencesKt.X0xxXX0(oXxOXOX(charSequence, delimiters, 0, z, i, 2, null), new Oox.oOoXoXO<X0.oOoXoXO, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo X0.oOoXoXO it) {
                IIX0o.x0xO0oo(it, "it");
                return StringsKt__StringsKt.IxOXOxO(charSequence, it);
            }
        });
    }

    public static /* synthetic */ int O0O0Io00X(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return xIoXXXIXo(charSequence, str, i, z);
    }

    @OXOo.OOXIXo
    public static String O0OoXI(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XIxO2 = XIxO(str, c, 0, false, 6, null);
        if (XIxO2 != -1) {
            String substring = str.substring(XIxO2 + 1, str.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ Pair O0o0(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IXX(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return ox0I(charSequence, collection, i, z);
    }

    @OXOo.OOXIXo
    public static final CharSequence O0o000XOX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i = length - 1;
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i >= 0) {
                length = i;
            } else {
                return "";
            }
        }
    }

    @xx0o0O.XO
    public static final boolean O0xO0(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final List<String> OI0IXox(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return SequencesKt___SequencesKt.oox000IX(Oox(charSequence));
    }

    public static /* synthetic */ List OIII0O(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.split(charSequence, i);
    }

    public static final int OIIXOxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Collection<String> strings, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(strings, "strings");
        Pair<Integer, String> XIOOI2 = XIOOI(charSequence, strings, i, z, false);
        if (XIOOI2 != null) {
            return XIOOI2.getFirst().intValue();
        }
        return -1;
    }

    public static final boolean OIoxIx(@OXOo.OOXIXo CharSequence charSequence, char c, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() > 0 && I0Io.oo0xXOI0I(charSequence.charAt(IXX(charSequence)), c, z)) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final String OIx0xoOo(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int O0O0Io00X2 = O0O0Io00X(str, delimiter, 0, false, 6, null);
        if (O0O0Io00X2 != -1) {
            return xOx(str, O0O0Io00X2 + delimiter.length(), str.length(), replacement).toString();
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO OIxI0O(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return new X0.oOoXoXO(0, charSequence.length() - 1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "replaceFirstCharWithChar")
    @X00IoxXI
    @xx0o0O.XO
    public static final String OIxOIX0II(String str, Oox.oOoXoXO<? super Character, Character> transform) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        if (str.length() > 0) {
            char charValue = transform.invoke(Character.valueOf(str.charAt(0))).charValue();
            String substring = str.substring(1);
            IIX0o.oO(substring, "substring(...)");
            return charValue + substring;
        }
        return str;
    }

    @OXOo.OOXIXo
    public static final CharSequence OOOox(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(range, "range");
        return IOI(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI OOoOoO0o(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return O0IoXXOx(charSequence, strArr, z, i);
    }

    @OXOo.oOoXoXO
    public static final Pair<Integer, String> OOxOOxIO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Collection<String> strings, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(strings, "strings");
        return XIOOI(charSequence, strings, i, z, false);
    }

    @xx0o0O.XO
    public static final String OX00o0X(String str, X0.oOoXoXO range, CharSequence replacement) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(replacement, "replacement");
        return xI0OXooO(str, range, replacement).toString();
    }

    public static /* synthetic */ String OXIOoo0X0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return IXoIo(charSequence, charSequence2, z);
    }

    @OXOo.OOXIXo
    public static final CharSequence OXOo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ boolean OXooXo(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return OIoxIx(charSequence, c, z);
    }

    @OXOo.OOXIXo
    public static final String OXxx0OO(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int xxxoo0XI2 = xxxoo0XI(str, delimiter, 0, false, 6, null);
        if (xxxoo0XI2 != -1) {
            return xOx(str, xxxoo0XI2 + delimiter.length(), str.length(), replacement).toString();
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ boolean Oo0IXI0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oxO(charSequence, charSequence2, z);
    }

    @OXOo.OOXIXo
    public static final String Oo0xX(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int xxxoo0XI2 = xxxoo0XI(str, delimiter, 0, false, 6, null);
        if (xxxoo0XI2 != -1) {
            String substring = str.substring(0, xxxoo0XI2);
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static String OoI0OO(@OXOo.OOXIXo String str, @OXOo.OOXIXo CharSequence prefix) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (Oo0IXI0(str, prefix, false, 2, null)) {
            String substring = str.substring(prefix.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static final int OoIXo(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        X0.xoIox xoxXI2;
        if (!z2) {
            xoxXI2 = new X0.oOoXoXO(X0.IIXOooo.OxxIIOOXO(i, 0), X0.IIXOooo.XI0IXoo(i2, charSequence.length()));
        } else {
            xoxXI2 = X0.IIXOooo.xoxXI(X0.IIXOooo.XI0IXoo(i, IXX(charSequence)), X0.IIXOooo.OxxIIOOXO(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int oxoX2 = xoxXI2.oxoX();
            int X0o0xo2 = xoxXI2.X0o0xo();
            int XO2 = xoxXI2.XO();
            if ((XO2 > 0 && oxoX2 <= X0o0xo2) || (XO2 < 0 && X0o0xo2 <= oxoX2)) {
                while (!OxI.OOIXx0x((String) charSequence2, 0, (String) charSequence, oxoX2, charSequence2.length(), z)) {
                    if (oxoX2 != X0o0xo2) {
                        oxoX2 += XO2;
                    } else {
                        return -1;
                    }
                }
                return oxoX2;
            }
            return -1;
        }
        int oxoX3 = xoxXI2.oxoX();
        int X0o0xo3 = xoxXI2.X0o0xo();
        int XO3 = xoxXI2.XO();
        if ((XO3 > 0 && oxoX3 <= X0o0xo3) || (XO3 < 0 && X0o0xo3 <= oxoX3)) {
            while (!o0xIoII(charSequence2, 0, charSequence, oxoX3, charSequence2.length(), z)) {
                if (oxoX3 != X0o0xo3) {
                    oxoX3 += XO3;
                } else {
                    return -1;
                }
            }
            return oxoX3;
        }
        return -1;
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI OoOoXO0(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.splitToSequence(charSequence, i);
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<String> Oox(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return OOoOoO0o(charSequence, new String[]{"\r\n", "\n", xXOx.f32950X0o0xo}, false, 0, 6, null);
    }

    @xx0o0O.XO
    public static final List<String> OoxOxII(CharSequence charSequence, Regex regex, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ String OoxxX(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return IxOIO(str, str2, str3);
    }

    public static /* synthetic */ String Ox(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return xx0O(str, c, str2);
    }

    @OXOo.OOXIXo
    public static final String Ox00XOXoo(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int xxxoo0XI2 = xxxoo0XI(str, delimiter, 0, false, 6, null);
        if (xxxoo0XI2 != -1) {
            return xOx(str, 0, xxxoo0XI2, replacement).toString();
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI Ox0XO(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return oIX0o(charSequence, cArr, z, i);
    }

    @OXOo.OOXIXo
    public static String OxIxx0(@OXOo.OOXIXo String str, @OXOo.OOXIXo CharSequence suffix) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (Ix0x(str, suffix, false, 2, null)) {
            String substring = str.substring(0, str.length() - suffix.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    @OXOo.OOXIXo
    public static final List<String> Oxxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo String[] delimiters, boolean z, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return XXooOOI(charSequence, str, z, i);
            }
        }
        Iterable Xx000oIo2 = SequencesKt___SequencesKt.Xx000oIo(oXxOXOX(charSequence, delimiters, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(Xx000oIo2, 10));
        Iterator it = Xx000oIo2.iterator();
        while (it.hasNext()) {
            arrayList.add(IxOXOxO(charSequence, (X0.oOoXoXO) it.next()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final CharSequence X0(@OXOo.OOXIXo CharSequence charSequence, int i, char c) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            oOXoIIIo it = new X0.oOoXoXO(1, i - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    @xx0o0O.XO
    public static final boolean X00IxOx(CharSequence charSequence, Regex regex) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.matches(charSequence);
    }

    public static /* synthetic */ String X0OXX(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return OXxx0OO(str, str2, str3, str4);
    }

    @OXOo.OOXIXo
    public static final CharSequence X0oX(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char... chars) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt___ArraysKt.xoxXoXO(chars, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ int X0x(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IXX(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return IIIxO(charSequence, collection, i, z);
    }

    public static /* synthetic */ int X0xOO(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        boolean z3;
        if ((i3 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        return OoIXo(charSequence, charSequence2, i, i2, z, z3);
    }

    public static final Pair<Integer, String> XIOOI(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        X0.xoIox xoxXI2;
        Object obj;
        Object obj2;
        int xxxoo0XI2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt___CollectionsKt.XO0(collection);
            if (!z2) {
                xxxoo0XI2 = O0O0Io00X(charSequence, str, i, false, 4, null);
            } else {
                xxxoo0XI2 = xxxoo0XI(charSequence, str, i, false, 4, null);
            }
            if (xxxoo0XI2 < 0) {
                return null;
            }
            return Xo0.oIX0oI(Integer.valueOf(xxxoo0XI2), str);
        }
        if (!z2) {
            xoxXI2 = new X0.oOoXoXO(X0.IIXOooo.OxxIIOOXO(i, 0), charSequence.length());
        } else {
            xoxXI2 = X0.IIXOooo.xoxXI(X0.IIXOooo.XI0IXoo(i, IXX(charSequence)), 0);
        }
        if (charSequence instanceof String) {
            int oxoX2 = xoxXI2.oxoX();
            int X0o0xo2 = xoxXI2.X0o0xo();
            int XO2 = xoxXI2.XO();
            if ((XO2 > 0 && oxoX2 <= X0o0xo2) || (XO2 < 0 && X0o0xo2 <= oxoX2)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            if (OxI.OOIXx0x(str2, 0, (String) charSequence, oxoX2, str2.length(), z)) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return Xo0.oIX0oI(Integer.valueOf(oxoX2), str3);
                    }
                    if (oxoX2 == X0o0xo2) {
                        break;
                    }
                    oxoX2 += XO2;
                }
            }
        } else {
            int oxoX3 = xoxXI2.oxoX();
            int X0o0xo3 = xoxXI2.X0o0xo();
            int XO3 = xoxXI2.XO();
            if ((XO3 > 0 && oxoX3 <= X0o0xo3) || (XO3 < 0 && X0o0xo3 <= oxoX3)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            String str4 = (String) obj;
                            if (o0xIoII(str4, 0, charSequence, oxoX3, str4.length(), z)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return Xo0.oIX0oI(Integer.valueOf(oxoX3), str5);
                    }
                    if (oxoX3 == X0o0xo3) {
                        break;
                    }
                    oxoX3 += XO3;
                }
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static String XIo(@OXOo.OOXIXo String str, @OXOo.OOXIXo char... chars) {
        CharSequence charSequence;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!ArraysKt___ArraysKt.xoxXoXO(chars, str.charAt(i))) {
                    charSequence = str.subSequence(i, str.length());
                    break;
                }
                i++;
            } else {
                charSequence = "";
                break;
            }
        }
        return charSequence.toString();
    }

    public static /* synthetic */ int XIxO(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IXX(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return IXXIXx00I(charSequence, c, i, z);
    }

    @kotlin.OOXIXo(message = "Use parameters named startIndex and endIndex.", replaceWith = @kotlin.XX(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @xx0o0O.XO
    public static final CharSequence XO0(String str, int i, int i2) {
        IIX0o.x0xO0oo(str, "<this>");
        return str.subSequence(i, i2);
    }

    public static /* synthetic */ int XO0OX(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IXX(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return xxXXXxIxo(charSequence, cArr, i, z);
    }

    public static /* synthetic */ String XOOO0O(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return XxIOX(str, c, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <C extends CharSequence & R, R> R XOo0(C c, Oox.oIX0oI<? extends R> defaultValue) {
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (OxI.X0O0I0(c)) {
            return defaultValue.invoke();
        }
        return c;
    }

    public static /* synthetic */ boolean XOx(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return IXIIo(charSequence, charSequence2, i, z);
    }

    @OXOo.OOXIXo
    public static final CharSequence XXIoX0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence prefix) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (Oo0IXI0(charSequence, prefix, false, 2, null)) {
            return charSequence.subSequence(prefix.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static /* synthetic */ String XXO0(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return oxOIoIx(str, c, str2, str3);
    }

    public static /* synthetic */ List XXoO0oX(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return Oxxo(charSequence, strArr, z, i);
    }

    public static final List<String> XXooOOI(CharSequence charSequence, String str, boolean z, int i) {
        boolean z2;
        ox0(i);
        int i2 = 0;
        int xIoXXXIXo2 = xIoXXXIXo(charSequence, str, 0, z);
        if (xIoXXXIXo2 != -1 && i != 1) {
            if (i > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i3 = 10;
            if (z2) {
                i3 = X0.IIXOooo.XI0IXoo(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, xIoXXXIXo2).toString());
                i2 = str.length() + xIoXXXIXo2;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                xIoXXXIXo2 = xIoXXXIXo(charSequence, str, i2, z);
            } while (xIoXXXIXo2 != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        return kotlin.collections.oI0IIXIo.OOXIXo(charSequence.toString());
    }

    @OXOo.OOXIXo
    public static final CharSequence XXx0OXXXo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence suffix) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (charSequence.length() >= prefix.length() + suffix.length() && Oo0IXI0(charSequence, prefix, false, 2, null) && Ix0x(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @oxxXoxO(version = "1.5")
    public static final boolean XoIoOXOIx(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        if (IIX0o.Oxx0IOOO(str, "true")) {
            return true;
        }
        if (IIX0o.Oxx0IOOO(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    @xx0o0O.XO
    public static final String XoOOOXox(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return oIoIXxIO(str).toString();
    }

    public static final kotlin.sequences.ooOOo0oXI<X0.oOoXoXO> XoOOx0IX(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        ox0(i2);
        return new XO(charSequence, i, i2, new Oox.x0xO0oo<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @OXOo.oOoXoXO
            public final Pair<Integer, Integer> invoke(@OXOo.OOXIXo CharSequence $receiver, int i3) {
                IIX0o.x0xO0oo($receiver, "$this$$receiver");
                int oI0X02 = StringsKt__StringsKt.oI0X0($receiver, cArr, i3, z);
                if (oI0X02 < 0) {
                    return null;
                }
                return Xo0.oIX0oI(Integer.valueOf(oI0X02), 1);
            }
        });
    }

    public static /* synthetic */ String Xx(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return xoxo(str, c, str2, str3);
    }

    @OXOo.OOXIXo
    public static final String Xx0(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XxIIOXIXx2 = XxIIOXIXx(str, c, 0, false, 6, null);
        if (XxIIOXIXx2 != -1) {
            return xOx(str, 0, XxIIOXIXx2, replacement).toString();
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static final CharSequence Xx0oX(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!II0xO0.IXxxXO(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static /* synthetic */ int XxI(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return oI0X0(charSequence, cArr, i, z);
    }

    public static /* synthetic */ int XxIIOXIXx(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return oI0(charSequence, c, i, z);
    }

    @OXOo.OOXIXo
    public static final String XxIOX(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XIxO2 = XIxO(str, c, 0, false, 6, null);
        if (XIxO2 != -1) {
            return xOx(str, 0, XIxO2, replacement).toString();
        }
        return missingDelimiterValue;
    }

    @xx0o0O.XO
    public static final String XxOOoxOO(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return oIxXXOI(str).toString();
    }

    public static /* synthetic */ List Xxx0oXX(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return xXIX0Xo(charSequence, cArr, z, i);
    }

    public static /* synthetic */ boolean o00xOoIO(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ooO0oXxI(charSequence, charSequence2, z);
    }

    @xx0o0O.XO
    public static final boolean o0OO0(CharSequence charSequence, Regex regex) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "replaceFirstCharWithCharSequence")
    @X00IoxXI
    @xx0o0O.XO
    public static final String o0oIxXOx(String str, Oox.oOoXoXO<? super Character, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) transform.invoke(Character.valueOf(str.charAt(0))));
            String substring = str.substring(1);
            IIX0o.oO(substring, "substring(...)");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    @xx0o0O.XO
    public static final String o0xIIX0(CharSequence charSequence, Regex regex, String replacement) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        IIX0o.x0xO0oo(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    public static final boolean o0xIoII(@OXOo.OOXIXo CharSequence charSequence, int i, @OXOo.OOXIXo CharSequence other, int i2, int i3, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!I0Io.oo0xXOI0I(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String o0xOIoxo(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = TokenParser.SP;
        }
        return oOIx(str, i, c);
    }

    public static final int oI0(@OXOo.OOXIXo CharSequence charSequence, char c, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return oI0X0(charSequence, new char[]{c}, i, z);
    }

    @xx0o0O.XO
    public static final String oI00o(CharSequence charSequence, Regex regex, String replacement) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        IIX0o.x0xO0oo(replacement, "replacement");
        return regex.replace(charSequence, replacement);
    }

    public static final int oI0X0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char[] chars, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.X0OOoXIOX(chars), i);
        }
        oOXoIIIo it = new X0.oOoXoXO(X0.IIXOooo.OxxIIOOXO(i, 0), IXX(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            for (char c : chars) {
                if (I0Io.oo0xXOI0I(c, charAt, z)) {
                    return nextInt;
                }
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final CharSequence oII(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<String> oIX0o(@OXOo.OOXIXo final CharSequence charSequence, @OXOo.OOXIXo char[] delimiters, boolean z, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(delimiters, "delimiters");
        return SequencesKt___SequencesKt.X0xxXX0(IOXOxOII(charSequence, delimiters, 0, z, i, 2, null), new Oox.oOoXoXO<X0.oOoXoXO, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo X0.oOoXoXO it) {
                IIX0o.x0xO0oo(it, "it");
                return StringsKt__StringsKt.IxOXOxO(charSequence, it);
            }
        });
    }

    public static /* synthetic */ int oIXoXx0(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return OIIXOxo(charSequence, collection, i, z);
    }

    @OXOo.OOXIXo
    public static CharSequence oIoIXxIO(@OXOo.OOXIXo CharSequence charSequence) {
        int i;
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean IXxxXO2 = II0xO0.IXxxXO(charSequence.charAt(i));
            if (!z) {
                if (!IXxxXO2) {
                    z = true;
                } else {
                    i2++;
                }
            } else {
                if (!IXxxXO2) {
                    break;
                }
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @OXOo.OOXIXo
    public static final String oIoxI0xx(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int xxxoo0XI2 = xxxoo0XI(str, delimiter, 0, false, 6, null);
        if (xxxoo0XI2 != -1) {
            String substring = str.substring(xxxoo0XI2 + delimiter.length(), str.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String oIxOXo(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return O0OoXI(str, c, str2);
    }

    @OXOo.OOXIXo
    public static final CharSequence oIxXXOI(@OXOo.OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!II0xO0.IXxxXO(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @OXOo.OOXIXo
    public static final String oIxxIo(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XxIIOXIXx2 = XxIIOXIXx(str, c, 0, false, 6, null);
        if (XxIIOXIXx2 != -1) {
            String substring = str.substring(0, XxIIOXIXx2);
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String oO0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return xXXxoI(str, str2, str3);
    }

    public static final boolean oO0IXx(@OXOo.OOXIXo CharSequence charSequence, char c, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (XxIIOXIXx(charSequence, c, 0, z, 2, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String oO0OX0(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return Ox00XOXoo(str, str2, str3, str4);
    }

    @xx0o0O.XO
    public static final String oOIXoIXXI(CharSequence charSequence, Regex regex, Oox.oOoXoXO<? super x0XOIxOo, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        IIX0o.x0xO0oo(transform, "transform");
        return regex.replace(charSequence, transform);
    }

    @OXOo.OOXIXo
    public static final String oOIx(@OXOo.OOXIXo String str, int i, char c) {
        IIX0o.x0xO0oo(str, "<this>");
        return xOoIIIoXI(str, i, c).toString();
    }

    public static /* synthetic */ String oOxxXI(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return Oo0xX(str, str2, str3);
    }

    @OXOo.OOXIXo
    public static final String oX0O(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XIxO2 = XIxO(str, c, 0, false, 6, null);
        if (XIxO2 != -1) {
            String substring = str.substring(0, XIxO2);
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    @xx0o0O.XO
    public static final String oXIoIo(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final boolean oXoXxOo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence suffix, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (!z && (charSequence instanceof String) && (suffix instanceof String)) {
            return OxI.XO0o((String) charSequence, (String) suffix, false, 2, null);
        }
        return o0xIoII(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI oXxOXOX(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return xx00oOoI(charSequence, strArr, i, z, i2);
    }

    public static boolean ooO0oXxI(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence other, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        if (other instanceof String) {
            if (O0O0Io00X(charSequence, (String) other, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (X0xOO(charSequence, other, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ Pair oox000IX(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return OOxOOxIO(charSequence, collection, i, z);
    }

    public static final void ox0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    @OXOo.oOoXoXO
    public static final Pair<Integer, String> ox0I(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo Collection<String> strings, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(strings, "strings");
        return XIOOI(charSequence, strings, i, z, true);
    }

    public static final boolean oxO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence prefix, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(prefix, "prefix");
        if (!z && (charSequence instanceof String) && (prefix instanceof String)) {
            return OxI.IOOoXo0Ix((String) charSequence, (String) prefix, false, 2, null);
        }
        return o0xIoII(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    @OXOo.OOXIXo
    public static final String oxOIoIx(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XxIIOXIXx2 = XxIIOXIXx(str, c, 0, false, 6, null);
        if (XxIIOXIXx2 != -1) {
            return xOx(str, XxIIOXIXx2 + 1, str.length(), replacement).toString();
        }
        return missingDelimiterValue;
    }

    @OXOo.OOXIXo
    public static final CharSequence oxXIOXO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char... chars) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt___ArraysKt.xoxXoXO(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static final boolean x00X0xoXO(@OXOo.OOXIXo CharSequence charSequence, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (!new X0.oOoXoXO(0, charSequence.length() - 2).xxIXOIIO(i) || !Character.isHighSurrogate(charSequence.charAt(i)) || !Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final CharSequence x0Io0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char... chars) {
        int i;
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean xoxXoXO = ArraysKt___ArraysKt.xoxXoXO(chars, charSequence.charAt(i));
            if (!z) {
                if (!xoxXoXO) {
                    z = true;
                } else {
                    i2++;
                }
            } else {
                if (!xoxXoXO) {
                    break;
                }
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @OXOo.OOXIXo
    public static final String x0OI(@OXOo.OOXIXo String str, @OXOo.OOXIXo char... chars) {
        CharSequence charSequence;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt___ArraysKt.xoxXoXO(chars, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @OXOo.OOXIXo
    public static final String x0oox0(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence other, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(other, "other");
        int length = charSequence.length();
        int min = Math.min(length, other.length());
        int i = 0;
        while (i < min && I0Io.oo0xXOI0I(charSequence.charAt((length - i) - 1), other.charAt((r1 - i) - 1), z)) {
            i++;
        }
        if (x00X0xoXO(charSequence, (length - i) - 1) || x00X0xoXO(other, (r1 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ String x0xOIoO(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return OIx0xoOo(str, str2, str3, str4);
    }

    @OXOo.OOXIXo
    public static final CharSequence xI0OXooO(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo X0.oOoXoXO range, @OXOo.OOXIXo CharSequence replacement) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(range, "range");
        IIX0o.x0xO0oo(replacement, "replacement");
        return xOx(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    @OXOo.OOXIXo
    public static final String xI0Ooxx0x(@OXOo.OOXIXo String str, @OXOo.OOXIXo char... chars) {
        int i;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean xoxXoXO = ArraysKt___ArraysKt.xoxXoXO(chars, str.charAt(i));
            if (!z) {
                if (!xoxXoXO) {
                    z = true;
                } else {
                    i2++;
                }
            } else {
                if (!xoxXoXO) {
                    break;
                }
                length--;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    @OXOo.OOXIXo
    public static final String xIIoO(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!predicate.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static final boolean xIXOoI(@OXOo.oOoXoXO CharSequence charSequence, @OXOo.oOoXoXO CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return IIX0o.Oxx0IOOO(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final CharSequence xIXoO0Xx(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo CharSequence suffix) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(suffix, "suffix");
        if (Ix0x(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(0, charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final int xIoXXXIXo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo String string, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        return X0xOO(charSequence, string, i, charSequence.length(), z, false, 16, null);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final kotlin.sequences.ooOOo0oXI<String> xOI0(CharSequence charSequence, Regex regex, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(regex, "regex");
        return regex.splitToSequence(charSequence, i);
    }

    public static /* synthetic */ String xOIO(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return oIoxI0xx(str, str2, str3);
    }

    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final Boolean xOIx00(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        if (IIX0o.Oxx0IOOO(str, "true")) {
            return Boolean.TRUE;
        }
        if (IIX0o.Oxx0IOOO(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final CharSequence xOoIIIoXI(@OXOo.OOXIXo CharSequence charSequence, int i, char c) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (i >= 0) {
            if (i <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            oOXoIIIo it = new X0.oOoXoXO(1, i - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c);
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
    }

    @OXOo.OOXIXo
    public static final CharSequence xOx(@OXOo.OOXIXo CharSequence charSequence, int i, int i2, @OXOo.OOXIXo CharSequence replacement) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            IIX0o.oO(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i2, charSequence.length());
            IIX0o.oO(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static /* synthetic */ CharSequence xOxOoo(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = TokenParser.SP;
        }
        return xOoIIIoXI(charSequence, i, c);
    }

    public static /* synthetic */ CharSequence xOxxXO(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = TokenParser.SP;
        }
        return X0(charSequence, i, c);
    }

    @xx0o0O.XO
    public static final boolean xX0ox(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        return !OxI.X0O0I0(charSequence);
    }

    @OXOo.OOXIXo
    public static final List<String> xXIX0Xo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char[] delimiters, boolean z, int i) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return XXooOOI(charSequence, String.valueOf(delimiters[0]), z, i);
        }
        Iterable Xx000oIo2 = SequencesKt___SequencesKt.Xx000oIo(IOXOxOII(charSequence, delimiters, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(Xx000oIo2, 10));
        Iterator it = Xx000oIo2.iterator();
        while (it.hasNext()) {
            arrayList.add(IxOXOxO(charSequence, (X0.oOoXoXO) it.next()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String xXO0oXX(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!predicate.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                    charSequence = str.subSequence(i, str.length());
                    break;
                }
                i++;
            } else {
                charSequence = "";
                break;
            }
        }
        return charSequence.toString();
    }

    @OXOo.OOXIXo
    public static final String xXXxoI(@OXOo.OOXIXo String str, @OXOo.OOXIXo String delimiter, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(delimiter, "delimiter");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int O0O0Io00X2 = O0O0Io00X(str, delimiter, 0, false, 6, null);
        if (O0O0Io00X2 != -1) {
            String substring = str.substring(O0O0Io00X2 + delimiter.length(), str.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ boolean xXo(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oO0IXx(charSequence, c, z);
    }

    @xx0o0O.XO
    public static final boolean xoIXOxX(CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        if (charSequence.length() > 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    public static final boolean xooxxX(CharSequence charSequence) {
        if (charSequence != null && !OxI.X0O0I0(charSequence)) {
            return false;
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final String xoxo(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String replacement, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(replacement, "replacement");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XIxO2 = XIxO(str, c, 0, false, 6, null);
        if (XIxO2 != -1) {
            return xOx(str, XIxO2 + 1, str.length(), replacement).toString();
        }
        return missingDelimiterValue;
    }

    @xx0o0O.XO
    public static final String xx(String str, X0.oOoXoXO range) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(range, "range");
        return OOOox(str, range).toString();
    }

    public static final kotlin.sequences.ooOOo0oXI<X0.oOoXoXO> xx00oOoI(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        ox0(i2);
        final List oI0IIXIo2 = kotlin.collections.ooOOo0oXI.oI0IIXIo(strArr);
        return new XO(charSequence, i, i2, new Oox.x0xO0oo<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @OXOo.oOoXoXO
            public final Pair<Integer, Integer> invoke(@OXOo.OOXIXo CharSequence $receiver, int i3) {
                Pair XIOOI2;
                IIX0o.x0xO0oo($receiver, "$this$$receiver");
                XIOOI2 = StringsKt__StringsKt.XIOOI($receiver, oI0IIXIo2, i3, z, false);
                if (XIOOI2 != null) {
                    return Xo0.oIX0oI(XIOOI2.getFirst(), Integer.valueOf(((String) XIOOI2.getSecond()).length()));
                }
                return null;
            }
        });
    }

    @OXOo.OOXIXo
    public static final String xx0O(@OXOo.OOXIXo String str, char c, @OXOo.OOXIXo String missingDelimiterValue) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(missingDelimiterValue, "missingDelimiterValue");
        int XxIIOXIXx2 = XxIIOXIXx(str, c, 0, false, 6, null);
        if (XxIIOXIXx2 != -1) {
            String substring = str.substring(XxIIOXIXx2 + 1, str.length());
            IIX0o.oO(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static final int xx0o0O(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo String string, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i);
        }
        return OoIXo(charSequence, string, i, 0, z, true);
    }

    @OXOo.OOXIXo
    public static final String xxOoXO(@OXOo.OOXIXo String str, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        int i;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean booleanValue = predicate.invoke(Character.valueOf(str.charAt(i))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else {
                if (!booleanValue) {
                    break;
                }
                length--;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static final int xxXXXxIxo(@OXOo.OOXIXo CharSequence charSequence, @OXOo.OOXIXo char[] chars, int i, boolean z) {
        IIX0o.x0xO0oo(charSequence, "<this>");
        IIX0o.x0xO0oo(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.X0OOoXIOX(chars), i);
        }
        for (int XI0IXoo2 = X0.IIXOooo.XI0IXoo(i, IXX(charSequence)); -1 < XI0IXoo2; XI0IXoo2--) {
            char charAt = charSequence.charAt(XI0IXoo2);
            for (char c : chars) {
                if (I0Io.oo0xXOI0I(c, charAt, z)) {
                    return XI0IXoo2;
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ String xxoXO(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return oX0O(str, c, str2);
    }

    public static /* synthetic */ String xxx(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return oIxxIo(str, c, str2);
    }

    public static /* synthetic */ int xxxoo0XI(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IXX(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return xx0o0O(charSequence, str, i, z);
    }
}
