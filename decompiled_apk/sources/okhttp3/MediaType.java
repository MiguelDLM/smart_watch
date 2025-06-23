package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

/* loaded from: classes6.dex */
public final class MediaType {

    @OOXIXo
    private static final String QUOTED = "\"([^\"]*)\"";

    @OOXIXo
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    @OOXIXo
    private final String mediaType;

    @OOXIXo
    private final String[] parameterNamesAndValues;

    @OOXIXo
    private final String subtype;

    @OOXIXo
    private final String type;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @XX({"SMAP\nMediaType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,181:1\n1#2:182\n37#3,2:183\n*S KotlinDebug\n*F\n+ 1 MediaType.kt\nokhttp3/MediaType$Companion\n*L\n148#1:183,2\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        @OOXIXo
        @xxIXOIIO(name = "-deprecated_get")
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m377deprecated_get(@OOXIXo String mediaType) {
            IIX0o.x0xO0oo(mediaType, "mediaType");
            return get(mediaType);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.XX(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        @xxIXOIIO(name = "-deprecated_parse")
        @oOoXoXO
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m378deprecated_parse(@OOXIXo String mediaType) {
            IIX0o.x0xO0oo(mediaType, "mediaType");
            return parse(mediaType);
        }

        @x0XOIxOo
        @OOXIXo
        @xxIXOIIO(name = "get")
        public final MediaType get(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                IIX0o.oO(group, "typeSubtype.group(1)");
                Locale US = Locale.US;
                IIX0o.oO(US, "US");
                String lowerCase = group.toLowerCase(US);
                IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                IIX0o.oO(group2, "typeSubtype.group(2)");
                IIX0o.oO(US, "US");
                String lowerCase2 = group2.toLowerCase(US);
                IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = MediaType.PARAMETER.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (OxI.IOOoXo0Ix(group4, "'", false, 2, null) && OxI.XO0o(group4, "'", false, 2, null) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                                IIX0o.oO(group4, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Parameter is not formatted correctly: \"");
                        String substring = str.substring(end);
                        IIX0o.oO(substring, "this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        sb.append("\" for: \"");
                        sb.append(str);
                        sb.append('\"');
                        throw new IllegalArgumentException(sb.toString().toString());
                    }
                }
                return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]), null);
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        @x0XOIxOo
        @xxIXOIIO(name = "parse")
        @oOoXoXO
        public final MediaType parse(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, IIXOooo iIXOooo) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @x0XOIxOo
    @OOXIXo
    @xxIXOIIO(name = "get")
    public static final MediaType get(@OOXIXo String str) {
        return Companion.get(str);
    }

    @x0XOIxOo
    @xxIXOIIO(name = "parse")
    @oOoXoXO
    public static final MediaType parse(@OOXIXo String str) {
        return Companion.parse(str);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "subtype", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_subtype")
    /* renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m375deprecated_subtype() {
        return this.subtype;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "type", imports = {}))
    @OOXIXo
    @xxIXOIIO(name = "-deprecated_type")
    /* renamed from: -deprecated_type, reason: not valid java name */
    public final String m376deprecated_type() {
        return this.type;
    }

    @oOoXoXO
    @xoIox
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof MediaType) && IIX0o.Oxx0IOOO(((MediaType) obj).mediaType, this.mediaType)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @oOoXoXO
    public final String parameter(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        int i = 0;
        int I0Io2 = xx0o0O.x0XOIxOo.I0Io(0, this.parameterNamesAndValues.length - 1, 2);
        if (I0Io2 >= 0) {
            while (!OxI.oX0I0O(this.parameterNamesAndValues[i], name, true)) {
                if (i != I0Io2) {
                    i += 2;
                } else {
                    return null;
                }
            }
            return this.parameterNamesAndValues[i + 1];
        }
        return null;
    }

    @OOXIXo
    @xxIXOIIO(name = "subtype")
    public final String subtype() {
        return this.subtype;
    }

    @OOXIXo
    public String toString() {
        return this.mediaType;
    }

    @OOXIXo
    @xxIXOIIO(name = "type")
    public final String type() {
        return this.type;
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    @oOoXoXO
    @xoIox
    public final Charset charset(@oOoXoXO Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
