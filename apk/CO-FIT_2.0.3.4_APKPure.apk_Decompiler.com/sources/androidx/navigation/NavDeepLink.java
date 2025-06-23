package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.serialization.RouteSerializerKt;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlin.text.OxI;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1360#2:762\n1446#2,5:763\n1559#2:768\n1590#2,4:769\n1559#2:773\n1590#2,4:774\n1855#2,2:780\n1855#2:782\n1559#2:783\n1590#2,4:784\n1856#2:788\n215#3,2:778\n1#4:789\n*S KotlinDebug\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink\n*L\n86#1:762\n86#1:763,5\n232#1:768\n232#1:769,4\n249#1:773\n249#1:774,4\n310#1:780,2\n319#1:782\n331#1:783\n331#1:784,4\n319#1:788\n271#1:778,2\n*E\n"})
public final class NavDeepLink {
    @OOXIXo
    private static final Companion Companion = new Companion((IIXOooo) null);
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    @oOoXoXO
    private final String action;
    @OOXIXo
    private final X0IIOO fragArgs$delegate;
    @OOXIXo
    private final X0IIOO fragArgsAndRegex$delegate;
    @OOXIXo
    private final X0IIOO fragPattern$delegate;
    @OOXIXo
    private final X0IIOO fragRegex$delegate;
    private boolean isExactDeepLink;
    @OOXIXo
    private final X0IIOO isParameterizedQuery$delegate;
    private boolean isSingleQueryParamValueOnly;
    @oOoXoXO
    private final String mimeType;
    @OOXIXo
    private final X0IIOO mimeTypePattern$delegate;
    /* access modifiers changed from: private */
    @oOoXoXO
    public String mimeTypeRegex;
    @OOXIXo
    private final List<String> pathArgs;
    @OOXIXo
    private final X0IIOO pathPattern$delegate;
    /* access modifiers changed from: private */
    @oOoXoXO
    public String pathRegex;
    @OOXIXo
    private final X0IIOO queryArgsMap$delegate;
    @oOoXoXO
    private final String uriPattern;

    @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1#2:762\n*E\n"})
    public static final class Builder {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @oOoXoXO
        private String action;
        @oOoXoXO
        private String mimeType;
        @oOoXoXO
        private String uriPattern;

        @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$Builder$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1#2:762\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            public static /* synthetic */ Builder fromUriPattern$default(Companion companion, String str, Map map, int i, Object obj) {
                if ((i & 2) != 0) {
                    map = o0.O0xOxO();
                }
                IIX0o.x0xO0oo(str, "basePath");
                IIX0o.x0xO0oo(map, "typeMap");
                Builder builder = new Builder();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                builder.setUriPattern(str, IO.oxoX(Object.class), map);
                return builder;
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromAction(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, "action");
                if (str.length() > 0) {
                    Builder builder = new Builder();
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromMimeType(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
                Builder builder = new Builder();
                builder.setMimeType(str);
                return builder;
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromUriPattern(@OOXIXo String str) {
                IIX0o.x0xO0oo(str, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(str);
                return builder;
            }

            private Companion() {
            }

            @x0XOIxOo
            public final /* synthetic */ <T> Builder fromUriPattern(String str, Map<Oxx0xo, NavType<?>> map) {
                IIX0o.x0xO0oo(str, "basePath");
                IIX0o.x0xO0oo(map, "typeMap");
                Builder builder = new Builder();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                builder.setUriPattern(str, IO.oxoX(Object.class), map);
                return builder;
            }
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromAction(@OOXIXo String str) {
            return Companion.fromAction(str);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromMimeType(@OOXIXo String str) {
            return Companion.fromMimeType(str);
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder fromUriPattern(@OOXIXo String str) {
            return Companion.fromUriPattern(str);
        }

        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = o0.O0xOxO();
            }
            IIX0o.x0xO0oo(str, "basePath");
            IIX0o.x0xO0oo(map, "typeMap");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return builder.setUriPattern(str, IO.oxoX(Object.class), map);
        }

        @OOXIXo
        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        @OOXIXo
        public final Builder setAction(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "action");
            if (str.length() > 0) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @OOXIXo
        public final Builder setMimeType(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
            this.mimeType = str;
            return this;
        }

        @OOXIXo
        public final Builder setUriPattern(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "uriPattern");
            this.uriPattern = str;
            return this;
        }

        public final /* synthetic */ <T> Builder setUriPattern(String str, Map<Oxx0xo, NavType<?>> map) {
            IIX0o.x0xO0oo(str, "basePath");
            IIX0o.x0xO0oo(map, "typeMap");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return setUriPattern(str, IO.oxoX(Object.class), map);
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <T> Builder setUriPattern(@OOXIXo String str, @OOXIXo oxoX<T> oxox, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> map) {
            IIX0o.x0xO0oo(str, "basePath");
            IIX0o.x0xO0oo(oxox, "route");
            IIX0o.x0xO0oo(map, "typeMap");
            this.uriPattern = RouteSerializerKt.generateRoutePattern(OxxIIOOXO.Oxx0IOOO(oxox), map, str);
            return this;
        }

        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String str, oxoX oxox, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = o0.O0xOxO();
            }
            return builder.setUriPattern(str, oxox, map);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$MimeType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,761:1\n731#2,9:762\n*S KotlinDebug\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$MimeType\n*L\n448#1:762,9\n*E\n"})
    public static final class MimeType implements Comparable<MimeType> {
        @OOXIXo
        private String subType;
        @OOXIXo
        private String type;

        public MimeType(@OOXIXo String str) {
            List list;
            IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
            List<String> split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt___CollectionsKt.O0o000XOX(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
            this.type = (String) list.get(0);
            this.subType = (String) list.get(1);
        }

        @OOXIXo
        public final String getSubType() {
            return this.subType;
        }

        @OOXIXo
        public final String getType() {
            return this.type;
        }

        public final void setSubType(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.subType = str;
        }

        public final void setType(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.type = str;
        }

        public int compareTo(@OOXIXo MimeType mimeType) {
            IIX0o.x0xO0oo(mimeType, "other");
            int i = IIX0o.Oxx0IOOO(this.type, mimeType.type) ? 2 : 0;
            return IIX0o.Oxx0IOOO(this.subType, mimeType.subType) ? i + 1 : i;
        }
    }

    public static final class ParamQuery {
        @OOXIXo
        private final List<String> arguments = new ArrayList();
        @oOoXoXO
        private String paramRegex;

        public final void addArgumentName(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "name");
            this.arguments.add(str);
        }

        @OOXIXo
        public final String getArgumentName(int i) {
            return this.arguments.get(i);
        }

        @OOXIXo
        public final List<String> getArguments() {
            return this.arguments;
        }

        @oOoXoXO
        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(@oOoXoXO String str) {
            this.paramRegex = str;
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    public NavDeepLink(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        this.pathArgs = new ArrayList();
        this.pathPattern$delegate = XIxXXX0x0.oIX0oI(new NavDeepLink$pathPattern$2(this));
        this.isParameterizedQuery$delegate = XIxXXX0x0.oIX0oI(new NavDeepLink$isParameterizedQuery$2(this));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new NavDeepLink$queryArgsMap$2(this));
        this.fragArgsAndRegex$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new NavDeepLink$fragArgsAndRegex$2(this));
        this.fragArgs$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new NavDeepLink$fragArgs$2(this));
        this.fragRegex$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new NavDeepLink$fragRegex$2(this));
        this.fragPattern$delegate = XIxXXX0x0.oIX0oI(new NavDeepLink$fragPattern$2(this));
        this.mimeTypePattern$delegate = XIxXXX0x0.oIX0oI(new NavDeepLink$mimeTypePattern$2(this));
        parsePath();
        parseMime();
    }

    private final void buildRegex(String str, List<String> list, StringBuilder sb) {
        Matcher matcher = FILL_IN_PATTERN.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            IIX0o.x0XOIxOo(group, "null cannot be cast to non-null type kotlin.String");
            list.add(group);
            if (matcher.start() > i) {
                String substring = str.substring(i, matcher.start());
                IIX0o.oO(substring, "substring(...)");
                sb.append(Pattern.quote(substring));
            }
            sb.append("([^/]*?|)");
            i = matcher.end();
        }
        if (i < str.length()) {
            String substring2 = str.substring(i);
            IIX0o.oO(substring2, "substring(...)");
            sb.append(Pattern.quote(substring2));
        }
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Pair<List<String>, String> getFragArgsAndRegex() {
        return (Pair) this.fragArgsAndRegex$delegate.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex$delegate.getValue();
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> map) {
        Iterable iterable = this.pathArgs;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            String str = (String) next;
            String decode = Uri.decode(matcher.group(i2));
            NavArgument navArgument = map.get(str);
            try {
                IIX0o.oO(decode, "value");
                parseArgument(bundle, str, decode, navArgument);
                arrayList.add(oXIO0o0XI.f19155oIX0oI);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri uri, Bundle bundle, Map<String, NavArgument> map) {
        String query;
        for (Map.Entry next : getQueryArgsMap().entrySet()) {
            ParamQuery paramQuery = (ParamQuery) next.getValue();
            List<String> queryParameters = uri.getQueryParameters((String) next.getKey());
            if (this.isSingleQueryParamValueOnly && (query = uri.getQuery()) != null && !IIX0o.Oxx0IOOO(query, uri.toString())) {
                queryParameters = oI0IIXIo.OOXIXo(query);
            }
            IIX0o.oO(queryParameters, "inputParams");
            if (!parseInputParams(queryParameters, paramQuery, bundle, map)) {
                return false;
            }
        }
        return true;
    }

    private final void getMatchingUriFragment(String str, Bundle bundle, Map<String, NavArgument> map) {
        Matcher matcher;
        Pattern fragPattern = getFragPattern();
        if (fragPattern != null) {
            matcher = fragPattern.matcher(String.valueOf(str));
        } else {
            matcher = null;
        }
        if (matcher != null && matcher.matches()) {
            Iterable fragArgs = getFragArgs();
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(fragArgs, 10));
            int i = 0;
            for (Object next : fragArgs) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                String str2 = (String) next;
                String decode = Uri.decode(matcher.group(i2));
                NavArgument navArgument = map.get(str2);
                try {
                    IIX0o.oO(decode, "value");
                    parseArgument(bundle, str2, decode, navArgument);
                    arrayList.add(oXIO0o0XI.f19155oIX0oI);
                    i = i2;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern$delegate.getValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap$delegate.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery$delegate.getValue()).booleanValue();
    }

    private final boolean matchAction(String str) {
        boolean z;
        boolean z2;
        if (str == null) {
            z = true;
        } else {
            z = false;
        }
        String str2 = this.action;
        if (str2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2 && (str == null || IIX0o.Oxx0IOOO(str2, str))) {
            return true;
        }
        return false;
    }

    private final boolean matchMimeType(String str) {
        boolean z;
        boolean z2;
        if (str == null) {
            z = true;
        } else {
            z = false;
        }
        if (this.mimeType != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (str == null) {
                return true;
            }
            Pattern mimeTypePattern = getMimeTypePattern();
            IIX0o.ooOOo0oXI(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private final boolean matchUri(Uri uri) {
        boolean z;
        boolean z2;
        if (uri == null) {
            z = true;
        } else {
            z = false;
        }
        if (getPathPattern() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (uri == null) {
                return true;
            }
            Pattern pathPattern = getPathPattern();
            IIX0o.ooOOo0oXI(pathPattern);
            if (pathPattern.matcher(uri.toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    private final void parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.getType().parseAndPut(bundle, str, str2);
        } else {
            bundle.putString(str, str2);
        }
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (!bundle.containsKey(str)) {
            return true;
        }
        if (navArgument == null) {
            return false;
        }
        NavType<Object> type = navArgument.getType();
        type.parseAndPut(bundle, str, str2, type.get(bundle, str));
        return false;
    }

    /* access modifiers changed from: private */
    public final Pair<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb = new StringBuilder();
        IIX0o.ooOOo0oXI(fragment);
        buildRegex(fragment, arrayList, sb);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "fragRegex.toString()");
        return Xo0.oIX0oI(arrayList, sb2);
    }

    private final boolean parseInputParams(List<String> list, ParamQuery paramQuery, Bundle bundle, Map<String, NavArgument> map) {
        Matcher matcher;
        Object obj;
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        Iterator it = paramQuery.getArguments().iterator();
        while (true) {
            NavType<Object> navType = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            NavArgument navArgument = map.get(str);
            if (navArgument != null) {
                navType = navArgument.getType();
            }
            if ((navType instanceof CollectionNavType) && !navArgument.isDefaultValuePresent()) {
                navType.put(bundleOf, str, ((CollectionNavType) navType).emptyCollection());
            }
        }
        for (String str2 : list) {
            String paramRegex = paramQuery.getParamRegex();
            if (paramRegex != null) {
                matcher = Pattern.compile(paramRegex, 32).matcher(str2);
            } else {
                matcher = null;
            }
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            Iterable arguments = paramQuery.getArguments();
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arguments, 10));
            int i = 0;
            for (Object next : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                String str3 = (String) next;
                String group = matcher.group(i2);
                if (group == null) {
                    group = "";
                } else {
                    IIX0o.oO(group, "argMatcher.group(index + 1) ?: \"\"");
                }
                NavArgument navArgument2 = map.get(str3);
                try {
                    if (!bundleOf.containsKey(str3)) {
                        parseArgument(bundleOf, str3, group, navArgument2);
                        obj = oXIO0o0XI.f19155oIX0oI;
                    } else {
                        obj = Boolean.valueOf(parseArgumentForRepeatedParam(bundleOf, str3, group, navArgument2));
                    }
                } catch (IllegalArgumentException unused) {
                    obj = oXIO0o0XI.f19155oIX0oI;
                }
                arrayList.add(obj);
                i = i2;
            }
        }
        bundle.putAll(bundleOf);
        return true;
    }

    private final void parseMime() {
        if (this.mimeType != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
                MimeType mimeType2 = new MimeType(this.mimeType);
                this.mimeTypeRegex = OxI.IIOIX("^(" + mimeType2.getType() + "|[*]+)/(" + mimeType2.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
                return;
            }
            throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
        }
    }

    private final void parsePath() {
        if (this.uriPattern != null) {
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
                sb.append("http[s]?://");
            }
            Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
            matcher.find();
            boolean z = false;
            String substring = this.uriPattern.substring(0, matcher.start());
            IIX0o.oO(substring, "substring(...)");
            buildRegex(substring, this.pathArgs, sb);
            if (!StringsKt__StringsKt.o00xOoIO(sb, ".*", false, 2, (Object) null) && !StringsKt__StringsKt.o00xOoIO(sb, "([^/]+?)", false, 2, (Object) null)) {
                z = true;
            }
            this.isExactDeepLink = z;
            sb.append("($|(\\?(.)*)|(\\#(.)*))");
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "uriRegex.toString()");
            this.pathRegex = OxI.IIOIX(sb2, ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isParameterizedQuery()) {
            return linkedHashMap;
        }
        Uri parse = Uri.parse(this.uriPattern);
        for (String next : parse.getQueryParameterNames()) {
            StringBuilder sb = new StringBuilder();
            List<String> queryParameters = parse.getQueryParameters(next);
            if (queryParameters.size() <= 1) {
                IIX0o.oO(queryParameters, "queryParams");
                String str = (String) CollectionsKt___CollectionsKt.XxXX(queryParameters);
                if (str == null) {
                    this.isSingleQueryParamValueOnly = true;
                    str = next;
                }
                Matcher matcher = FILL_IN_PATTERN.matcher(str);
                ParamQuery paramQuery = new ParamQuery();
                int i = 0;
                while (matcher.find()) {
                    String group = matcher.group(1);
                    IIX0o.x0XOIxOo(group, "null cannot be cast to non-null type kotlin.String");
                    paramQuery.addArgumentName(group);
                    IIX0o.oO(str, "queryParam");
                    String substring = str.substring(i, matcher.start());
                    IIX0o.oO(substring, "substring(...)");
                    sb.append(Pattern.quote(substring));
                    sb.append("(.+?)?");
                    i = matcher.end();
                }
                if (i < str.length()) {
                    IIX0o.oO(str, "queryParam");
                    String substring2 = str.substring(i);
                    IIX0o.oO(substring2, "substring(...)");
                    sb.append(Pattern.quote(substring2));
                }
                String sb2 = sb.toString();
                IIX0o.oO(sb2, "argRegex.toString()");
                paramQuery.setParamRegex(OxI.IIOIX(sb2, ".*", "\\E.*\\Q", false, 4, (Object) null));
                IIX0o.oO(next, "paramName");
                linkedHashMap.put(next, paramQuery);
            } else {
                throw new IllegalArgumentException(("Query parameter " + next + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
        }
        return linkedHashMap;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(@oOoXoXO Uri uri) {
        if (uri == null || this.uriPattern == null) {
            return 0;
        }
        List<String> pathSegments = uri.getPathSegments();
        List<String> pathSegments2 = Uri.parse(this.uriPattern).getPathSegments();
        IIX0o.oO(pathSegments, "requestedPathSegments");
        IIX0o.oO(pathSegments2, "uriPathSegments");
        return CollectionsKt___CollectionsKt.XOo0(pathSegments, pathSegments2).size();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        if (!IIX0o.Oxx0IOOO(this.uriPattern, navDeepLink.uriPattern) || !IIX0o.Oxx0IOOO(this.action, navDeepLink.action) || !IIX0o.Oxx0IOOO(this.mimeType, navDeepLink.mimeType)) {
            return false;
        }
        return true;
    }

    @oOoXoXO
    public final String getAction() {
        return this.action;
    }

    @OOXIXo
    public final List<String> getArgumentsNames$navigation_common_release() {
        Collection collection = this.pathArgs;
        ArrayList arrayList = new ArrayList();
        for (ParamQuery arguments : getQueryArgsMap().values()) {
            kotlin.collections.OxI.XIo0oOXIx(arrayList, arguments.getArguments());
        }
        return CollectionsKt___CollectionsKt.o0xIIX0(CollectionsKt___CollectionsKt.o0xIIX0(collection, arrayList), getFragArgs());
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle getMatchingArguments(@OOXIXo Uri uri, @OOXIXo Map<String, NavArgument> map) {
        Matcher matcher;
        IIX0o.x0xO0oo(uri, SDKConstants.PARAM_DEEP_LINK);
        IIX0o.x0xO0oo(map, "arguments");
        Pattern pathPattern = getPathPattern();
        if (pathPattern != null) {
            matcher = pathPattern.matcher(uri.toString());
        } else {
            matcher = null;
        }
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, map)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(uri, bundle, map)) {
            return null;
        }
        getMatchingUriFragment(uri.getFragment(), bundle, map);
        if (!NavArgumentKt.missingRequiredArguments(map, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle)).isEmpty()) {
            return null;
        }
        return bundle;
    }

    @OOXIXo
    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(@oOoXoXO Uri uri, @OOXIXo Map<String, NavArgument> map) {
        Matcher matcher;
        IIX0o.x0xO0oo(map, "arguments");
        Bundle bundle = new Bundle();
        if (uri == null) {
            return bundle;
        }
        Pattern pathPattern = getPathPattern();
        if (pathPattern != null) {
            matcher = pathPattern.matcher(uri.toString());
        } else {
            matcher = null;
        }
        if (matcher == null || !matcher.matches()) {
            return bundle;
        }
        getMatchingPathArguments(matcher, bundle, map);
        if (isParameterizedQuery()) {
            getMatchingQueryArguments(uri, bundle, map);
        }
        return bundle;
    }

    @oOoXoXO
    public final String getMimeType() {
        return this.mimeType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMimeTypeMatchRating(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, TTDownloadField.TT_MIME_TYPE);
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            IIX0o.ooOOo0oXI(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(str));
            }
        }
        return -1;
    }

    @oOoXoXO
    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        int i;
        int i2;
        String str = this.uriPattern;
        int i3 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        String str2 = this.action;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        String str3 = this.mimeType;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i5 + i3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(@OOXIXo Uri uri) {
        IIX0o.x0xO0oo(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public final void setExactDeepLink$navigation_common_release(boolean z) {
        this.isExactDeepLink = z;
    }

    public final boolean matches$navigation_common_release(@OOXIXo NavDeepLinkRequest navDeepLinkRequest) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "deepLinkRequest");
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLink(@OOXIXo String str) {
        this(str, (String) null, (String) null);
        IIX0o.x0xO0oo(str, "uri");
    }
}
