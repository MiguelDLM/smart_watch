package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import XxI.oxoX;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDeepLink;
import androidx.navigation.serialization.RouteSerializerKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.collections.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.ooOOo0oXI;
import kotlin.text.OxI;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavDestination.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination\n+ 2 TypedArray.kt\nandroidx/core/content/res/TypedArrayKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Uri.kt\nandroidx/core/net/UriKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 7 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,862:1\n232#2,3:863\n1#3:866\n29#4:867\n1549#5:868\n1620#5,3:869\n1855#5,2:876\n1855#5,2:879\n1855#5,2:882\n1224#6,2:872\n1224#6,2:874\n32#7:878\n33#7:881\n*S KotlinDebug\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination\n*L\n188#1:863,3\n380#1:867\n482#1:868\n482#1:869,3\n725#1:876,2\n733#1:879,2\n737#1:882,2\n706#1:872,2\n710#1:874,2\n730#1:878\n730#1:881\n*E\n"})
/* loaded from: classes.dex */
public class NavDestination {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Map<String, Class<?>> classes = new LinkedHashMap();

    @OOXIXo
    private Map<String, NavArgument> _arguments;

    @OOXIXo
    private final SparseArrayCompat<NavAction> actions;

    @OOXIXo
    private final List<NavDeepLink> deepLinks;
    private int id;

    @oOoXoXO
    private String idName;

    @oOoXoXO
    private CharSequence label;

    @OOXIXo
    private final String navigatorName;

    @oOoXoXO
    private NavGraph parent;

    @oOoXoXO
    private String route;

    @oOoXoXO
    private X0IIOO<NavDeepLink> routeDeepLink;

    @oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @XxI.I0Io(AnnotationRetention.BINARY)
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ClassType {
        Class<?> value();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String createRoute(@oOoXoXO String str) {
            if (str != null) {
                return "android-app://androidx.navigation/" + str;
            }
            return "";
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String getDisplayName(@OOXIXo Context context, int i) {
            String valueOf;
            IIX0o.x0xO0oo(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                valueOf = context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                valueOf = String.valueOf(i);
            }
            IIX0o.oO(valueOf, "try {\n                  …tring()\n                }");
            return valueOf;
        }

        @OOXIXo
        public final ooOOo0oXI<NavDestination> getHierarchy(@OOXIXo NavDestination navDestination) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            return SequencesKt__SequencesKt.x0XOIxOo(navDestination, new Oox.oOoXoXO<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // Oox.oOoXoXO
                public final NavDestination invoke(NavDestination it) {
                    IIX0o.x0xO0oo(it, "it");
                    return it.getParent();
                }
            });
        }

        @x0XOIxOo
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, IO.oxoX(Object.class));
        }

        @x0XOIxOo
        @OOXIXo
        public final <C> Class<? extends C> parseClassFromName(@OOXIXo Context context, @OOXIXo String name, @OOXIXo Class<? extends C> expectedClassType) {
            String str;
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(expectedClassType, "expectedClassType");
            if (name.charAt(0) == '.') {
                str = context.getPackageName() + name;
            } else {
                str = name;
            }
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            IIX0o.ooOOo0oXI(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <C> Class<? extends C> parseClassFromNameInternal(@OOXIXo Context context, @OOXIXo String name, @OOXIXo Class<? extends C> expectedClassType) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(name, "name");
            IIX0o.x0xO0oo(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        private Companion() {
        }

        @x0XOIxOo
        public final <T> boolean hasRoute(@OOXIXo NavDestination navDestination, @OOXIXo kotlin.reflect.oxoX<T> route) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            IIX0o.x0xO0oo(route, "route");
            return RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(route)) == navDestination.getId();
        }
    }

    @XX({"SMAP\nNavDestination.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination$DeepLinkMatch\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,862:1\n1855#2,2:863\n*S KotlinDebug\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination$DeepLinkMatch\n*L\n128#1:863,2\n*E\n"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        @OOXIXo
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;

        @oOoXoXO
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(@OOXIXo NavDestination destination, @oOoXoXO Bundle bundle, boolean z, int i, boolean z2, int i2) {
            IIX0o.x0xO0oo(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        @OOXIXo
        public final NavDestination getDestination() {
            return this.destination;
        }

        @oOoXoXO
        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        public final boolean hasMatchingArgs(@oOoXoXO Bundle bundle) {
            Bundle bundle2;
            NavType<Object> navType;
            Object obj;
            if (bundle == null || (bundle2 = this.matchingArgs) == null) {
                return false;
            }
            Set<String> keySet = bundle2.keySet();
            IIX0o.oO(keySet, "matchingArgs.keySet()");
            for (String key : keySet) {
                if (!bundle.containsKey(key)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.destination._arguments.get(key);
                Object obj2 = null;
                if (navArgument != null) {
                    navType = navArgument.getType();
                } else {
                    navType = null;
                }
                if (navType != null) {
                    Bundle bundle3 = this.matchingArgs;
                    IIX0o.oO(key, "key");
                    obj = navType.get(bundle3, key);
                } else {
                    obj = null;
                }
                if (navType != null) {
                    IIX0o.oO(key, "key");
                    obj2 = navType.get(bundle, key);
                }
                if (navType != null && !navType.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(@OOXIXo DeepLinkMatch other) {
            IIX0o.x0xO0oo(other, "other");
            boolean z = this.isExactDeepLink;
            if (z && !other.isExactDeepLink) {
                return 1;
            }
            if (!z && other.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.matchingArgs;
                IIX0o.ooOOo0oXI(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.hasMatchingAction;
            if (z2 && !other.hasMatchingAction) {
                return 1;
            }
            if (z2 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }
    }

    public NavDestination(@OOXIXo String navigatorName) {
        IIX0o.x0xO0oo(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>(0, 1, null);
        this._arguments = new LinkedHashMap();
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                navDestination2 = null;
            }
            return navDestination.buildDeepLinkIds(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    @x0XOIxOo
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String getDisplayName(@OOXIXo Context context, int i) {
        return Companion.getDisplayName(context, i);
    }

    @OOXIXo
    public static final ooOOo0oXI<NavDestination> getHierarchy(@OOXIXo NavDestination navDestination) {
        return Companion.getHierarchy(navDestination);
    }

    private final boolean hasRequiredArguments(NavDeepLink navDeepLink, Uri uri, Map<String, NavArgument> map) {
        final Bundle matchingPathAndQueryArgs$navigation_common_release = navDeepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, map);
        return NavArgumentKt.missingRequiredArguments(map, new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavDestination$hasRequiredArguments$missingRequiredArguments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final Boolean invoke(String key) {
                IIX0o.x0xO0oo(key, "key");
                return Boolean.valueOf(!matchingPathAndQueryArgs$navigation_common_release.containsKey(key));
            }
        }).isEmpty();
    }

    @x0XOIxOo
    public static final <T> boolean hasRoute(@OOXIXo NavDestination navDestination, @OOXIXo kotlin.reflect.oxoX<T> oxox) {
        return Companion.hasRoute(navDestination, oxox);
    }

    @x0XOIxOo
    @OOXIXo
    public static final <C> Class<? extends C> parseClassFromName(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Class<? extends C> cls) {
        return Companion.parseClassFromName(context, str, cls);
    }

    @x0XOIxOo
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <C> Class<? extends C> parseClassFromNameInternal(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Class<? extends C> cls) {
        return Companion.parseClassFromNameInternal(context, str, cls);
    }

    public final void addArgument(@OOXIXo String argumentName, @OOXIXo NavArgument argument) {
        IIX0o.x0xO0oo(argumentName, "argumentName");
        IIX0o.x0xO0oo(argument, "argument");
        this._arguments.put(argumentName, argument);
    }

    public final void addDeepLink(@OOXIXo String uriPattern) {
        IIX0o.x0xO0oo(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle addInDefaultArgs(@oOoXoXO Bundle bundle) {
        if (bundle == null && this._arguments.isEmpty()) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this._arguments.entrySet()) {
            entry.getValue().putDefaultValue(entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry<String, NavArgument> entry2 : this._arguments.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.isDefaultValueUnknown$navigation_common_release() && !value.verify(key, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + key + "' in argument bundle. " + value.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    @OOXIXo
    @xoIox
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(@OXOo.oOoXoXO java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            return r0
        L4:
            r1 = 0
            if (r9 == 0) goto Lba
            boolean r2 = r9 instanceof androidx.navigation.NavDestination
            if (r2 != 0) goto Ld
            goto Lba
        Ld:
            java.util.List<androidx.navigation.NavDeepLink> r2 = r8.deepLinks
            androidx.navigation.NavDestination r9 = (androidx.navigation.NavDestination) r9
            java.util.List<androidx.navigation.NavDeepLink> r3 = r9.deepLinks
            boolean r2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r2, r3)
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r3 = r8.actions
            int r3 = r3.size()
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r4 = r9.actions
            int r4 = r4.size()
            if (r3 != r4) goto L58
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r3 = r8.actions
            kotlin.collections.oOXoIIIo r3 = androidx.collection.SparseArrayKt.keyIterator(r3)
            kotlin.sequences.ooOOo0oXI r3 = kotlin.sequences.SequencesKt__SequencesKt.X0o0xo(r3)
            java.util.Iterator r3 = r3.iterator()
        L33:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L56
            java.lang.Object r4 = r3.next()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r5 = r8.actions
            java.lang.Object r5 = r5.get(r4)
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r6 = r9.actions
            java.lang.Object r4 = r6.get(r4)
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r5, r4)
            if (r4 != 0) goto L33
            goto L58
        L56:
            r3 = 1
            goto L59
        L58:
            r3 = 0
        L59:
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r4 = r8._arguments
            int r4 = r4.size()
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r5 = r9._arguments
            int r5 = r5.size()
            if (r4 != r5) goto La0
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r4 = r8._arguments
            kotlin.sequences.ooOOo0oXI r4 = kotlin.collections.I0oOoX.XIXIxO(r4)
            java.util.Iterator r4 = r4.iterator()
        L71:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L9e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r6 = r9._arguments
            java.lang.Object r7 = r5.getKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto La0
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r6 = r9._arguments
            java.lang.Object r7 = r5.getKey()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Object r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r6, r5)
            if (r5 == 0) goto La0
            goto L71
        L9e:
            r4 = 1
            goto La1
        La0:
            r4 = 0
        La1:
            int r5 = r8.id
            int r6 = r9.id
            if (r5 != r6) goto Lb8
            java.lang.String r5 = r8.route
            java.lang.String r9 = r9.route
            boolean r9 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r5, r9)
            if (r9 == 0) goto Lb8
            if (r2 == 0) goto Lb8
            if (r3 == 0) goto Lb8
            if (r4 == 0) goto Lb8
            goto Lb9
        Lb8:
            r0 = 0
        Lb9:
            return r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.equals(java.lang.Object):boolean");
    }

    @oOoXoXO
    public final String fillInLabel(@OOXIXo Context context, @oOoXoXO Bundle bundle) {
        NavType<Object> navType;
        NavArgument navArgument;
        IIX0o.x0xO0oo(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String argName = matcher.group(1);
            if (bundle != null && bundle.containsKey(argName)) {
                matcher.appendReplacement(stringBuffer, "");
                if (argName != null && (navArgument = this._arguments.get(argName)) != null) {
                    navType = navArgument.getType();
                } else {
                    navType = null;
                }
                NavType<Integer> navType2 = NavType.ReferenceType;
                if (IIX0o.Oxx0IOOO(navType, navType2)) {
                    IIX0o.oO(argName, "argName");
                    Integer num = navType2.get(bundle, argName);
                    IIX0o.x0XOIxOo(num, "null cannot be cast to non-null type kotlin.Int");
                    String string = context.getString(num.intValue());
                    IIX0o.oO(string, "context.getString(\n     …                        )");
                    stringBuffer.append(string);
                } else {
                    IIX0o.ooOOo0oXI(navType);
                    IIX0o.oO(argName, "argName");
                    stringBuffer.append(String.valueOf(navType.get(bundle, argName)));
                }
            } else {
                throw new IllegalArgumentException("Could not find \"" + argName + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"');
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @oOoXoXO
    public final NavAction getAction(@IdRes int i) {
        NavAction navAction;
        if (this.actions.getIsEmpty()) {
            navAction = null;
        } else {
            navAction = this.actions.get(i);
        }
        if (navAction == null) {
            NavGraph navGraph = this.parent;
            if (navGraph == null) {
                return null;
            }
            return navGraph.getAction(i);
        }
        return navAction;
    }

    @OOXIXo
    public final Map<String, NavArgument> getArguments() {
        return o0.OX00O0xII(this._arguments);
    }

    @IdRes
    public final int getId() {
        return this.id;
    }

    @oOoXoXO
    public final CharSequence getLabel() {
        return this.label;
    }

    @OOXIXo
    public final String getNavigatorName() {
        return this.navigatorName;
    }

    @oOoXoXO
    public final NavGraph getParent() {
        return this.parent;
    }

    @oOoXoXO
    public final String getRoute() {
        return this.route;
    }

    public boolean hasDeepLink(@OOXIXo Uri deepLink) {
        IIX0o.x0xO0oo(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        Set<String> keySet;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.id * 31;
        String str = this.route;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i9 = i8 + i;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i10 = i9 * 31;
            String uriPattern = navDeepLink.getUriPattern();
            if (uriPattern != null) {
                i5 = uriPattern.hashCode();
            } else {
                i5 = 0;
            }
            int i11 = (i10 + i5) * 31;
            String action = navDeepLink.getAction();
            if (action != null) {
                i6 = action.hashCode();
            } else {
                i6 = 0;
            }
            int i12 = (i11 + i6) * 31;
            String mimeType = navDeepLink.getMimeType();
            if (mimeType != null) {
                i7 = mimeType.hashCode();
            } else {
                i7 = 0;
            }
            i9 = i12 + i7;
        }
        Iterator valueIterator = SparseArrayKt.valueIterator(this.actions);
        while (valueIterator.hasNext()) {
            NavAction navAction = (NavAction) valueIterator.next();
            int destinationId = ((i9 * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            if (navOptions != null) {
                i3 = navOptions.hashCode();
            } else {
                i3 = 0;
            }
            i9 = destinationId + i3;
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null && (keySet = defaultArguments.keySet()) != null) {
                IIX0o.oO(keySet, "keySet()");
                for (String str2 : keySet) {
                    int i13 = i9 * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    IIX0o.ooOOo0oXI(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    if (obj != null) {
                        i4 = obj.hashCode();
                    } else {
                        i4 = 0;
                    }
                    i9 = i13 + i4;
                }
            }
        }
        for (String str3 : this._arguments.keySet()) {
            int hashCode = ((i9 * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = this._arguments.get(str3);
            if (navArgument != null) {
                i2 = navArgument.hashCode();
            } else {
                i2 = 0;
            }
            i9 = hashCode + i2;
        }
        return i9;
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeepLinkMatch matchDeepLink(@OOXIXo NavDeepLinkRequest navDeepLinkRequest) {
        Bundle bundle;
        boolean z;
        int i;
        IIX0o.x0xO0oo(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            if (uri != null) {
                bundle = navDeepLink.getMatchingArguments(uri, this._arguments);
            } else {
                bundle = null;
            }
            int calculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
            String action = navDeepLinkRequest.getAction();
            if (action != null && IIX0o.Oxx0IOOO(action, navDeepLink.getAction())) {
                z = true;
            } else {
                z = false;
            }
            String mimeType = navDeepLinkRequest.getMimeType();
            if (mimeType != null) {
                i = navDeepLink.getMimeTypeMatchRating(mimeType);
            } else {
                i = -1;
            }
            if (bundle == null) {
                if (z || i > -1) {
                    if (hasRequiredArguments(navDeepLink, uri, this._arguments)) {
                    }
                }
            }
            DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, bundle, navDeepLink.isExactDeepLink(), calculateMatchingPathSegments$navigation_common_release, z, i);
            if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                deepLinkMatch = deepLinkMatch2;
            }
        }
        return deepLinkMatch;
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DeepLinkMatch matchRoute(@OOXIXo String route) {
        NavDeepLink value;
        IIX0o.x0xO0oo(route, "route");
        X0IIOO<NavDeepLink> x0iioo = this.routeDeepLink;
        if (x0iioo == null || (value = x0iioo.getValue()) == null) {
            return null;
        }
        Uri parse = Uri.parse(Companion.createRoute(route));
        IIX0o.II0XooXoX(parse, "Uri.parse(this)");
        Bundle matchingArguments = value.getMatchingArguments(parse, this._arguments);
        if (matchingArguments == null) {
            return null;
        }
        return new DeepLinkMatch(this, matchingArguments, value.isExactDeepLink(), value.calculateMatchingPathSegments$navigation_common_release(parse), false, -1);
    }

    @CallSuper
    public void onInflate(@OOXIXo Context context, @OOXIXo AttributeSet attrs) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        IIX0o.oO(obtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(obtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        int i = androidx.navigation.common.R.styleable.Navigator_android_id;
        if (obtainAttributes.hasValue(i)) {
            setId(obtainAttributes.getResourceId(i, 0));
            this.idName = Companion.getDisplayName(context, this.id);
        }
        this.label = obtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        obtainAttributes.recycle();
    }

    public final void putAction(@IdRes int i, @IdRes int i2) {
        putAction(i, new NavAction(i2, null, null, 6, null));
    }

    public final void removeAction(@IdRes int i) {
        this.actions.remove(i);
    }

    public final void removeArgument(@OOXIXo String argumentName) {
        IIX0o.x0xO0oo(argumentName, "argumentName");
        this._arguments.remove(argumentName);
    }

    public final void setId(@IdRes int i) {
        this.id = i;
        this.idName = null;
    }

    public final void setLabel(@oOoXoXO CharSequence charSequence) {
        this.label = charSequence;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setParent(@oOoXoXO NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final void setRoute(@oOoXoXO String str) {
        if (str == null) {
            setId(0);
        } else if (!OxI.X0O0I0(str)) {
            final String createRoute = Companion.createRoute(str);
            final NavDeepLink build = new NavDeepLink.Builder().setUriPattern(createRoute).build();
            List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavDestination$route$missingRequiredArguments$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public final Boolean invoke(String key) {
                    IIX0o.x0xO0oo(key, "key");
                    return Boolean.valueOf(!NavDeepLink.this.getArgumentsNames$navigation_common_release().contains(key));
                }
            });
            if (missingRequiredArguments.isEmpty()) {
                this.routeDeepLink = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NavDeepLink>() { // from class: androidx.navigation.NavDestination$route$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    public final NavDeepLink invoke() {
                        return new NavDeepLink.Builder().setUriPattern(createRoute).build();
                    }
                });
                setId(createRoute.hashCode());
            } else {
                throw new IllegalArgumentException(("Cannot set route \"" + str + "\" for destination " + this + ". Following required arguments are missing: " + missingRequiredArguments).toString());
            }
        } else {
            throw new IllegalArgumentException("Cannot have an empty route");
        }
        this.route = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean supportsActions() {
        return true;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(oIX0oI.I0Io.f4096II0xO0);
        String str = this.idName;
        if (str == null) {
            sb.append(HexStringBuilder.DEFAULT_PREFIX);
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(oIX0oI.I0Io.f4095I0Io);
        String str2 = this.route;
        if (str2 != null && !OxI.X0O0I0(str2)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    public final void addDeepLink(@OOXIXo final NavDeepLink navDeepLink) {
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavDestination$addDeepLink$missingRequiredArguments$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final Boolean invoke(String key) {
                IIX0o.x0xO0oo(key, "key");
                return Boolean.valueOf(!NavDeepLink.this.getArgumentsNames$navigation_common_release().contains(key));
            }
        });
        if (missingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + missingRequiredArguments).toString());
    }

    @OOXIXo
    @xoIox
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds(@oOoXoXO NavDestination navDestination) {
        xxIXOIIO xxixoiio = new xxIXOIIO();
        NavDestination navDestination2 = this;
        while (true) {
            IIX0o.ooOOo0oXI(navDestination2);
            NavGraph navGraph = navDestination2.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph2 = navDestination.parent;
                IIX0o.ooOOo0oXI(navGraph2);
                if (navGraph2.findNode(navDestination2.id) == navDestination2) {
                    xxixoiio.addFirst(navDestination2);
                    break;
                }
            }
            if (navGraph == null || navGraph.getStartDestinationId() != navDestination2.id) {
                xxixoiio.addFirst(navDestination2);
            }
            if (IIX0o.Oxx0IOOO(navGraph, navDestination) || navGraph == null) {
                break;
            }
            navDestination2 = navGraph;
        }
        List oOo0o = CollectionsKt___CollectionsKt.oOo0o(xxixoiio);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(oOo0o, 10));
        Iterator it = oOo0o.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).id));
        }
        return CollectionsKt___CollectionsKt.o0Oox0xox(arrayList);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public boolean hasDeepLink(@OOXIXo NavDeepLinkRequest deepLinkRequest) {
        IIX0o.x0xO0oo(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasRoute(@OOXIXo String route, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(route, "route");
        if (IIX0o.Oxx0IOOO(this.route, route)) {
            return true;
        }
        DeepLinkMatch matchRoute = matchRoute(route);
        if (IIX0o.Oxx0IOOO(this, matchRoute != null ? matchRoute.getDestination() : null)) {
            return matchRoute.hasMatchingArgs(bundle);
        }
        return false;
    }

    public final void putAction(@IdRes int i, @OOXIXo NavAction action) {
        IIX0o.x0xO0oo(action, "action");
        if (supportsActions()) {
            if (i != 0) {
                this.actions.put(i, action);
                return;
            }
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
        throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(@OOXIXo Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass()));
        IIX0o.x0xO0oo(navigator, "navigator");
    }
}
