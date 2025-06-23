package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
/* loaded from: classes6.dex */
public class StringsKt__IndentKt extends IXxxXO {
    public static final int II0XooXoX(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!II0xO0.IXxxXO(str.charAt(i))) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return str.length();
        }
        return i;
    }

    public static /* synthetic */ String IXxxXO(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return Oo(str, str2);
    }

    public static final String OOXIXo(List<String> list, int i, Oox.oOoXoXO<? super String, String> oooxoxo, Oox.oOoXoXO<? super String, String> oooxoxo2) {
        String invoke;
        int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            String str = (String) obj;
            if ((i2 == 0 || i2 == oo0xXOI0I2) && OxI.X0O0I0(str)) {
                str = null;
            } else {
                String invoke2 = oooxoxo2.invoke(str);
                if (invoke2 != null && (invoke = oooxoxo.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.oI0(arrayList, new StringBuilder(i), "\n", null, null, 0, null, null, 124, null)).toString();
        IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    @xx0o0O.Oxx0IOOO
    public static final String Oo(@OXOo.OOXIXo String str, @OXOo.OOXIXo String marginPrefix) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(marginPrefix, "marginPrefix");
        return x0XOIxOo(str, "", marginPrefix);
    }

    public static final Oox.oOoXoXO<String, String> Oxx0IOOO(final String str) {
        if (str.length() == 0) {
            return new Oox.oOoXoXO<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final String invoke(@OXOo.OOXIXo String line) {
                    IIX0o.x0xO0oo(line, "line");
                    return line;
                }
            };
        }
        return new Oox.oOoXoXO<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo String line) {
                IIX0o.x0xO0oo(line, "line");
                return str + line;
            }
        };
    }

    public static /* synthetic */ String oO(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return x0XOIxOo(str, str2, str3);
    }

    @OXOo.OOXIXo
    public static final String oOoXoXO(@OXOo.OOXIXo String str, @OXOo.OOXIXo String newIndent) {
        int i;
        String invoke;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(newIndent, "newIndent");
        List<String> OI0IXox2 = StringsKt__StringsKt.OI0IXox(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : OI0IXox2) {
            if (!OxI.X0O0I0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(II0XooXoX((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.IOOXOOOOo(arrayList2);
        int i2 = 0;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        int length = str.length() + (newIndent.length() * OI0IXox2.size());
        Oox.oOoXoXO<String, String> Oxx0IOOO2 = Oxx0IOOO(newIndent);
        int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(OI0IXox2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : OI0IXox2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            String str2 = (String) obj2;
            if ((i2 == 0 || i2 == oo0xXOI0I2) && OxI.X0O0I0(str2)) {
                str2 = null;
            } else {
                String x0Ix0O = StringsKt___StringsKt.x0Ix0O(str2, i);
                if (x0Ix0O != null && (invoke = Oxx0IOOO2.invoke(x0Ix0O)) != null) {
                    str2 = invoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.oI0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String ooOOo0oXI(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return oOoXoXO(str, str2);
    }

    @OXOo.OOXIXo
    public static final String x0XOIxOo(@OXOo.OOXIXo String str, @OXOo.OOXIXo String newIndent, @OXOo.OOXIXo String marginPrefix) {
        int i;
        String invoke;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(newIndent, "newIndent");
        IIX0o.x0xO0oo(marginPrefix, "marginPrefix");
        if (!OxI.X0O0I0(marginPrefix)) {
            List<String> OI0IXox2 = StringsKt__StringsKt.OI0IXox(str);
            int length = str.length() + (newIndent.length() * OI0IXox2.size());
            Oox.oOoXoXO<String, String> Oxx0IOOO2 = Oxx0IOOO(newIndent);
            int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(OI0IXox2);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : OI0IXox2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                String str2 = (String) obj;
                String str3 = null;
                if ((i2 == 0 || i2 == oo0xXOI0I2) && OxI.X0O0I0(str2)) {
                    str2 = null;
                } else {
                    int length2 = str2.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            if (!II0xO0.IXxxXO(str2.charAt(i4))) {
                                i = i4;
                                break;
                            }
                            i4++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        int i5 = i;
                        if (OxI.xo(str2, marginPrefix, i, false, 4, null)) {
                            int length3 = i5 + marginPrefix.length();
                            IIX0o.x0XOIxOo(str2, "null cannot be cast to non-null type java.lang.String");
                            str3 = str2.substring(length3);
                            IIX0o.oO(str3, "substring(...)");
                        }
                    }
                    if (str3 != null && (invoke = Oxx0IOOO2.invoke(str3)) != null) {
                        str2 = invoke;
                    }
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i2 = i3;
            }
            String sb = ((StringBuilder) CollectionsKt___CollectionsKt.oI0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            IIX0o.oO(sb, "toString(...)");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    @OXOo.OOXIXo
    @xx0o0O.Oxx0IOOO
    public static String x0xO0oo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return oOoXoXO(str, "");
    }

    public static /* synthetic */ String xoIox(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = OIII0O.OOXIXo.f1567xI;
        }
        return xxIXOIIO(str, str2);
    }

    @OXOo.OOXIXo
    public static final String xxIXOIIO(@OXOo.OOXIXo String str, @OXOo.OOXIXo final String indent) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(indent, "indent");
        return SequencesKt___SequencesKt.IoXIXo(SequencesKt___SequencesKt.X0xxXX0(StringsKt__StringsKt.Oox(str), new Oox.oOoXoXO<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$prependIndent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final String invoke(@OXOo.OOXIXo String it) {
                IIX0o.x0xO0oo(it, "it");
                if (OxI.X0O0I0(it)) {
                    return it.length() < indent.length() ? indent : it;
                }
                return indent + it;
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }
}
