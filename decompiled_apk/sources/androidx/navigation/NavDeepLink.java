package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDeepLink;
import androidx.navigation.serialization.RouteSerializerKt;
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
/* loaded from: classes.dex */
public final class NavDeepLink {

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

    @oOoXoXO
    private String mimeTypeRegex;

    @OOXIXo
    private final List<String> pathArgs;

    @OOXIXo
    private final X0IIOO pathPattern$delegate;

    @oOoXoXO
    private String pathRegex;

    @OOXIXo
    private final X0IIOO queryArgsMap$delegate;

    @oOoXoXO
    private final String uriPattern;

    @OOXIXo
    private static final Companion Companion = new Companion(null);
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");

    @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1#2:762\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @oOoXoXO
        private String action;

        @oOoXoXO
        private String mimeType;

        @oOoXoXO
        private String uriPattern;

        @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$Builder$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,761:1\n1#2:762\n*E\n"})
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Builder fromUriPattern$default(Companion companion, String basePath, Map typeMap, int i, Object obj) {
                if ((i & 2) != 0) {
                    typeMap = o0.O0xOxO();
                }
                IIX0o.x0xO0oo(basePath, "basePath");
                IIX0o.x0xO0oo(typeMap, "typeMap");
                Builder builder = new Builder();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                builder.setUriPattern(basePath, IO.oxoX(Object.class), typeMap);
                return builder;
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromAction(@OOXIXo String action) {
                IIX0o.x0xO0oo(action, "action");
                if (action.length() > 0) {
                    Builder builder = new Builder();
                    builder.setAction(action);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromMimeType(@OOXIXo String mimeType) {
                IIX0o.x0xO0oo(mimeType, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(mimeType);
                return builder;
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder fromUriPattern(@OOXIXo String uriPattern) {
                IIX0o.x0xO0oo(uriPattern, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(uriPattern);
                return builder;
            }

            private Companion() {
            }

            @x0XOIxOo
            public final /* synthetic */ <T> Builder fromUriPattern(String basePath, Map<Oxx0xo, NavType<?>> typeMap) {
                IIX0o.x0xO0oo(basePath, "basePath");
                IIX0o.x0xO0oo(typeMap, "typeMap");
                Builder builder = new Builder();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                builder.setUriPattern(basePath, IO.oxoX(Object.class), typeMap);
                return builder;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder() {
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

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String basePath, Map typeMap, int i, Object obj) {
            if ((i & 2) != 0) {
                typeMap = o0.O0xOxO();
            }
            IIX0o.x0xO0oo(basePath, "basePath");
            IIX0o.x0xO0oo(typeMap, "typeMap");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return builder.setUriPattern(basePath, IO.oxoX(Object.class), typeMap);
        }

        @OOXIXo
        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        @OOXIXo
        public final Builder setAction(@OOXIXo String action) {
            IIX0o.x0xO0oo(action, "action");
            if (action.length() > 0) {
                this.action = action;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @OOXIXo
        public final Builder setMimeType(@OOXIXo String mimeType) {
            IIX0o.x0xO0oo(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        @OOXIXo
        public final Builder setUriPattern(@OOXIXo String uriPattern) {
            IIX0o.x0xO0oo(uriPattern, "uriPattern");
            this.uriPattern = uriPattern;
            return this;
        }

        public final /* synthetic */ <T> Builder setUriPattern(String basePath, Map<Oxx0xo, NavType<?>> typeMap) {
            IIX0o.x0xO0oo(basePath, "basePath");
            IIX0o.x0xO0oo(typeMap, "typeMap");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return setUriPattern(basePath, IO.oxoX(Object.class), typeMap);
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <T> Builder setUriPattern(@OOXIXo String basePath, @OOXIXo oxoX<T> route, @OOXIXo Map<Oxx0xo, ? extends NavType<?>> typeMap) {
            IIX0o.x0xO0oo(basePath, "basePath");
            IIX0o.x0xO0oo(route, "route");
            IIX0o.x0xO0oo(typeMap, "typeMap");
            this.uriPattern = RouteSerializerKt.generateRoutePattern(OxxIIOOXO.Oxx0IOOO(route), typeMap, basePath);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setUriPattern$default(Builder builder, String str, oxoX oxox, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = o0.O0xOxO();
            }
            return builder.setUriPattern(str, oxox, map);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nNavDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$MimeType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,761:1\n731#2,9:762\n*S KotlinDebug\n*F\n+ 1 NavDeepLink.kt\nandroidx/navigation/NavDeepLink$MimeType\n*L\n448#1:762,9\n*E\n"})
    /* loaded from: classes.dex */
    public static final class MimeType implements Comparable<MimeType> {

        @OOXIXo
        private String subType;

        @OOXIXo
        private String type;

        public MimeType(@OOXIXo String mimeType) {
            List ooXIXxIX2;
            IIX0o.x0xO0oo(mimeType, "mimeType");
            List<String> split = new Regex("/").split(mimeType, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        ooXIXxIX2 = CollectionsKt___CollectionsKt.O0o000XOX(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            this.type = (String) ooXIXxIX2.get(0);
            this.subType = (String) ooXIXxIX2.get(1);
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

        @Override // java.lang.Comparable
        public int compareTo(@OOXIXo MimeType other) {
            IIX0o.x0xO0oo(other, "other");
            int i = IIX0o.Oxx0IOOO(this.type, other.type) ? 2 : 0;
            return IIX0o.Oxx0IOOO(this.subType, other.subType) ? i + 1 : i;
        }
    }

    /* loaded from: classes.dex */
    public static final class ParamQuery {

        @OOXIXo
        private final List<String> arguments = new ArrayList();

        @oOoXoXO
        private String paramRegex;

        public final void addArgumentName(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            this.arguments.add(name);
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
        this.pathPattern$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Pattern>() { // from class: androidx.navigation.NavDeepLink$pathPattern$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final Pattern invoke() {
                String str4;
                str4 = NavDeepLink.this.pathRegex;
                if (str4 != null) {
                    return Pattern.compile(str4, 2);
                }
                return null;
            }
        });
        this.isParameterizedQuery$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Boolean>() { // from class: androidx.navigation.NavDeepLink$isParameterizedQuery$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Boolean invoke() {
                return Boolean.valueOf((NavDeepLink.this.getUriPattern() == null || Uri.parse(NavDeepLink.this.getUriPattern()).getQuery() == null) ? false : true);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<Map<String, ParamQuery>>() { // from class: androidx.navigation.NavDeepLink$queryArgsMap$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final Map<String, NavDeepLink.ParamQuery> invoke() {
                Map<String, NavDeepLink.ParamQuery> parseQuery;
                parseQuery = NavDeepLink.this.parseQuery();
                return parseQuery;
            }
        });
        this.fragArgsAndRegex$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<Pair<? extends List<String>, ? extends String>>() { // from class: androidx.navigation.NavDeepLink$fragArgsAndRegex$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final Pair<? extends List<String>, ? extends String> invoke() {
                Pair<? extends List<String>, ? extends String> parseFragment;
                parseFragment = NavDeepLink.this.parseFragment();
                return parseFragment;
            }
        });
        this.fragArgs$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<List<String>>() { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final List<String> invoke() {
                Pair fragArgsAndRegex;
                List<String> list;
                fragArgsAndRegex = NavDeepLink.this.getFragArgsAndRegex();
                return (fragArgsAndRegex == null || (list = (List) fragArgsAndRegex.getFirst()) == null) ? new ArrayList() : list;
            }
        });
        this.fragRegex$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<String>() { // from class: androidx.navigation.NavDeepLink$fragRegex$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final String invoke() {
                Pair fragArgsAndRegex;
                fragArgsAndRegex = NavDeepLink.this.getFragArgsAndRegex();
                if (fragArgsAndRegex != null) {
                    return (String) fragArgsAndRegex.getSecond();
                }
                return null;
            }
        });
        this.fragPattern$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Pattern>() { // from class: androidx.navigation.NavDeepLink$fragPattern$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final Pattern invoke() {
                String fragRegex;
                fragRegex = NavDeepLink.this.getFragRegex();
                if (fragRegex != null) {
                    return Pattern.compile(fragRegex, 2);
                }
                return null;
            }
        });
        this.mimeTypePattern$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final Pattern invoke() {
                String str4;
                str4 = NavDeepLink.this.mimeTypeRegex;
                if (str4 != null) {
                    return Pattern.compile(str4);
                }
                return null;
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> getFragArgsAndRegex() {
        return (Pair) this.fragArgsAndRegex$delegate.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex$delegate.getValue();
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> map) {
        List<String> list = this.pathArgs;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            String str = (String) obj;
            String value = Uri.decode(matcher.group(i2));
            NavArgument navArgument = map.get(str);
            try {
                IIX0o.oO(value, "value");
                parseArgument(bundle, str, value, navArgument);
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean getMatchingQueryArguments(Uri uri, Bundle bundle, Map<String, NavArgument> map) {
        String query;
        for (Map.Entry<String, ParamQuery> entry : getQueryArgsMap().entrySet()) {
            String key = entry.getKey();
            ParamQuery value = entry.getValue();
            List<String> inputParams = uri.getQueryParameters(key);
            if (this.isSingleQueryParamValueOnly && (query = uri.getQuery()) != null && !IIX0o.Oxx0IOOO(query, uri.toString())) {
                inputParams = oI0IIXIo.OOXIXo(query);
            }
            IIX0o.oO(inputParams, "inputParams");
            if (!parseInputParams(inputParams, value, bundle, map)) {
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
        if (matcher == null || !matcher.matches()) {
            return;
        }
        List<String> fragArgs = getFragArgs();
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(fragArgs, 10));
        int i = 0;
        for (Object obj : fragArgs) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            String str2 = (String) obj;
            String value = Uri.decode(matcher.group(i2));
            NavArgument navArgument = map.get(str2);
            try {
                IIX0o.oO(value, "value");
                parseArgument(bundle, str2, value, navArgument);
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
                i = i2;
            } catch (IllegalArgumentException unused) {
                return;
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
        if (navArgument != null) {
            NavType<Object> type = navArgument.getType();
            type.parseAndPut(bundle, str, str2, type.get(bundle, str));
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str != null && Uri.parse(str).getFragment() != null) {
            ArrayList arrayList = new ArrayList();
            String fragment = Uri.parse(this.uriPattern).getFragment();
            StringBuilder sb = new StringBuilder();
            IIX0o.ooOOo0oXI(fragment);
            buildRegex(fragment, arrayList, sb);
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "fragRegex.toString()");
            return Xo0.oIX0oI(arrayList, sb2);
        }
        return null;
    }

    private final boolean parseInputParams(List<String> list, ParamQuery paramQuery, Bundle bundle, Map<String, NavArgument> map) {
        Matcher matcher;
        Object obj;
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        Iterator<T> it = paramQuery.getArguments().iterator();
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
            List<String> arguments = paramQuery.getArguments();
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arguments, 10));
            int i = 0;
            for (Object obj2 : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                String str3 = (String) obj2;
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
                        obj = oXIO0o0XI.f29392oIX0oI;
                    } else {
                        obj = Boolean.valueOf(parseArgumentForRepeatedParam(bundleOf, str3, group, navArgument2));
                    }
                } catch (IllegalArgumentException unused) {
                    obj = oXIO0o0XI.f29392oIX0oI;
                }
                arrayList.add(obj);
                i = i2;
            }
        }
        bundle.putAll(bundleOf);
        return true;
    }

    private final void parseMime() {
        if (this.mimeType == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            MimeType mimeType = new MimeType(this.mimeType);
            this.mimeTypeRegex = OxI.IIOIX("^(" + mimeType.getType() + "|[*]+)/(" + mimeType.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
            return;
        }
        throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
    }

    private final void parsePath() {
        if (this.uriPattern == null) {
            return;
        }
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
        if (!StringsKt__StringsKt.o00xOoIO(sb, ".*", false, 2, null) && !StringsKt__StringsKt.o00xOoIO(sb, "([^/]+?)", false, 2, null)) {
            z = true;
        }
        this.isExactDeepLink = z;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "uriRegex.toString()");
        this.pathRegex = OxI.IIOIX(sb2, ".*", "\\E.*\\Q", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!isParameterizedQuery()) {
            return linkedHashMap;
        }
        Uri parse = Uri.parse(this.uriPattern);
        for (String paramName : parse.getQueryParameterNames()) {
            StringBuilder sb = new StringBuilder();
            List<String> queryParams = parse.getQueryParameters(paramName);
            if (queryParams.size() <= 1) {
                IIX0o.oO(queryParams, "queryParams");
                String queryParam = (String) CollectionsKt___CollectionsKt.XxXX(queryParams);
                if (queryParam == null) {
                    this.isSingleQueryParamValueOnly = true;
                    queryParam = paramName;
                }
                Matcher matcher = FILL_IN_PATTERN.matcher(queryParam);
                ParamQuery paramQuery = new ParamQuery();
                int i = 0;
                while (matcher.find()) {
                    String group = matcher.group(1);
                    IIX0o.x0XOIxOo(group, "null cannot be cast to non-null type kotlin.String");
                    paramQuery.addArgumentName(group);
                    IIX0o.oO(queryParam, "queryParam");
                    String substring = queryParam.substring(i, matcher.start());
                    IIX0o.oO(substring, "substring(...)");
                    sb.append(Pattern.quote(substring));
                    sb.append("(.+?)?");
                    i = matcher.end();
                }
                if (i < queryParam.length()) {
                    IIX0o.oO(queryParam, "queryParam");
                    String substring2 = queryParam.substring(i);
                    IIX0o.oO(substring2, "substring(...)");
                    sb.append(Pattern.quote(substring2));
                }
                String sb2 = sb.toString();
                IIX0o.oO(sb2, "argRegex.toString()");
                paramQuery.setParamRegex(OxI.IIOIX(sb2, ".*", "\\E.*\\Q", false, 4, null));
                IIX0o.oO(paramName, "paramName");
                linkedHashMap.put(paramName, paramQuery);
            } else {
                throw new IllegalArgumentException(("Query parameter " + paramName + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
        }
        return linkedHashMap;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(@oOoXoXO Uri uri) {
        if (uri != null && this.uriPattern != null) {
            List<String> requestedPathSegments = uri.getPathSegments();
            List<String> uriPathSegments = Uri.parse(this.uriPattern).getPathSegments();
            IIX0o.oO(requestedPathSegments, "requestedPathSegments");
            IIX0o.oO(uriPathSegments, "uriPathSegments");
            return CollectionsKt___CollectionsKt.XOo0(requestedPathSegments, uriPathSegments).size();
        }
        return 0;
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
        List<String> list = this.pathArgs;
        Collection<ParamQuery> values = getQueryArgsMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            kotlin.collections.OxI.XIo0oOXIx(arrayList, ((ParamQuery) it.next()).getArguments());
        }
        return CollectionsKt___CollectionsKt.o0xIIX0(CollectionsKt___CollectionsKt.o0xIIX0(list, arrayList), getFragArgs());
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle getMatchingArguments(@OOXIXo Uri deepLink, @OOXIXo Map<String, NavArgument> arguments) {
        Matcher matcher;
        IIX0o.x0xO0oo(deepLink, "deepLink");
        IIX0o.x0xO0oo(arguments, "arguments");
        Pattern pathPattern = getPathPattern();
        if (pathPattern != null) {
            matcher = pathPattern.matcher(deepLink.toString());
        } else {
            matcher = null;
        }
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        final Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, arguments)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(deepLink, bundle, arguments)) {
            return null;
        }
        getMatchingUriFragment(deepLink.getFragment(), bundle, arguments);
        if (!NavArgumentKt.missingRequiredArguments(arguments, new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavDeepLink$getMatchingArguments$missingRequiredArguments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final Boolean invoke(String argName) {
                IIX0o.x0xO0oo(argName, "argName");
                return Boolean.valueOf(!bundle.containsKey(argName));
            }
        }).isEmpty()) {
            return null;
        }
        return bundle;
    }

    @OOXIXo
    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(@oOoXoXO Uri uri, @OOXIXo Map<String, NavArgument> arguments) {
        Matcher matcher;
        IIX0o.x0xO0oo(arguments, "arguments");
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
        if (matcher == null) {
            return bundle;
        }
        if (!matcher.matches()) {
            return bundle;
        }
        getMatchingPathArguments(matcher, bundle, arguments);
        if (isParameterizedQuery()) {
            getMatchingQueryArguments(uri, bundle, arguments);
        }
        return bundle;
    }

    @oOoXoXO
    public final String getMimeType() {
        return this.mimeType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMimeTypeMatchRating(@OOXIXo String mimeType) {
        IIX0o.x0xO0oo(mimeType, "mimeType");
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            IIX0o.ooOOo0oXI(mimeTypePattern);
            if (mimeTypePattern.matcher(mimeType).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(mimeType));
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
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, null, null));
    }

    public final void setExactDeepLink$navigation_common_release(boolean z) {
        this.isExactDeepLink = z;
    }

    public final boolean matches$navigation_common_release(@OOXIXo NavDeepLinkRequest deepLinkRequest) {
        IIX0o.x0xO0oo(deepLinkRequest, "deepLinkRequest");
        if (matchUri(deepLinkRequest.getUri()) && matchAction(deepLinkRequest.getAction())) {
            return matchMimeType(deepLinkRequest.getMimeType());
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLink(@OOXIXo String uri) {
        this(uri, null, null);
        IIX0o.x0xO0oo(uri, "uri");
    }
}
