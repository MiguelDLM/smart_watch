package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import XxI.I0Io;
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
import androidx.navigation.common.R;
import androidx.navigation.serialization.RouteSerializerKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.huawei.openalliance.ad.constant.bn;
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
import kotlin.collections.I0oOoX;
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
public class NavDestination {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final Map<String, Class<?>> classes = new LinkedHashMap();
    /* access modifiers changed from: private */
    @OOXIXo
    public Map<String, NavArgument> _arguments;
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

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @I0Io(AnnotationRetention.BINARY)
    @oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

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
            if (str == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + str;
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String getDisplayName(@OOXIXo Context context, int i) {
            String str;
            IIX0o.x0xO0oo(context, bn.f.o);
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                str = context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                str = String.valueOf(i);
            }
            IIX0o.oO(str, "try {\n                  …tring()\n                }");
            return str;
        }

        @OOXIXo
        public final ooOOo0oXI<NavDestination> getHierarchy(@OOXIXo NavDestination navDestination) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            return SequencesKt__SequencesKt.x0XOIxOo(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        @x0XOIxOo
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, IO.oxoX(Object.class));
        }

        @x0XOIxOo
        @OOXIXo
        public final <C> Class<? extends C> parseClassFromName(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Class<? extends C> cls) {
            String str2;
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "name");
            IIX0o.x0xO0oo(cls, "expectedClassType");
            if (str.charAt(0) == '.') {
                str2 = context.getPackageName() + str;
            } else {
                str2 = str;
            }
            Class<?> cls2 = (Class) NavDestination.classes.get(str2);
            if (cls2 == null) {
                try {
                    cls2 = Class.forName(str2, true, context.getClassLoader());
                    NavDestination.classes.put(str, cls2);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            IIX0o.ooOOo0oXI(cls2);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            throw new IllegalArgumentException((str2 + " must be a subclass of " + cls).toString());
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @OOXIXo
        public final <C> Class<? extends C> parseClassFromNameInternal(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Class<? extends C> cls) {
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(str, "name");
            IIX0o.x0xO0oo(cls, "expectedClassType");
            return NavDestination.parseClassFromName(context, str, cls);
        }

        private Companion() {
        }

        @x0XOIxOo
        public final <T> boolean hasRoute(@OOXIXo NavDestination navDestination, @OOXIXo kotlin.reflect.oxoX<T> oxox) {
            IIX0o.x0xO0oo(navDestination, "<this>");
            IIX0o.x0xO0oo(oxox, "route");
            return RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(oxox)) == navDestination.getId();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @XX({"SMAP\nNavDestination.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination$DeepLinkMatch\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,862:1\n1855#2,2:863\n*S KotlinDebug\n*F\n+ 1 NavDestination.kt\nandroidx/navigation/NavDestination$DeepLinkMatch\n*L\n128#1:863,2\n*E\n"})
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        @OOXIXo
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        @oOoXoXO
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(@OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle, boolean z, int i, boolean z2, int i2) {
            IIX0o.x0xO0oo(navDestination, "destination");
            this.destination = navDestination;
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
            for (String str : keySet) {
                if (!bundle.containsKey(str)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.destination._arguments.get(str);
                Object obj2 = null;
                if (navArgument != null) {
                    navType = navArgument.getType();
                } else {
                    navType = null;
                }
                if (navType != null) {
                    Bundle bundle3 = this.matchingArgs;
                    IIX0o.oO(str, "key");
                    obj = navType.get(bundle3, str);
                } else {
                    obj = null;
                }
                if (navType != null) {
                    IIX0o.oO(str, "key");
                    obj2 = navType.get(bundle, str);
                }
                if (navType != null && !navType.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }

        public int compareTo(@OOXIXo DeepLinkMatch deepLinkMatch) {
            IIX0o.x0xO0oo(deepLinkMatch, "other");
            boolean z = this.isExactDeepLink;
            if (z && !deepLinkMatch.isExactDeepLink) {
                return 1;
            }
            if (!z && deepLinkMatch.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - deepLinkMatch.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && deepLinkMatch.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = deepLinkMatch.matchingArgs;
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
            if (z2 && !deepLinkMatch.hasMatchingAction) {
                return 1;
            }
            if (z2 || !deepLinkMatch.hasMatchingAction) {
                return this.mimeTypeMatchLevel - deepLinkMatch.mimeTypeMatchLevel;
            }
            return -1;
        }
    }

    public NavDestination(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "navigatorName");
        this.navigatorName = str;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>(0, 1, (IIXOooo) null);
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
        return NavArgumentKt.missingRequiredArguments(map, new NavDestination$hasRequiredArguments$missingRequiredArguments$1(navDeepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, map))).isEmpty();
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @OOXIXo
    public static final <C> Class<? extends C> parseClassFromNameInternal(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Class<? extends C> cls) {
        return Companion.parseClassFromNameInternal(context, str, cls);
    }

    public final void addArgument(@OOXIXo String str, @OOXIXo NavArgument navArgument) {
        IIX0o.x0xO0oo(str, "argumentName");
        IIX0o.x0xO0oo(navArgument, "argument");
        this._arguments.put(str, navArgument);
    }

    public final void addDeepLink(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(str).build());
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle addInDefaultArgs(@oOoXoXO Bundle bundle) {
        if (bundle == null && this._arguments.isEmpty()) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._arguments.entrySet()) {
            ((NavArgument) next.getValue()).putDefaultValue((String) next.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry next2 : this._arguments.entrySet()) {
                String str = (String) next2.getKey();
                NavArgument navArgument = (NavArgument) next2.getValue();
                if (!navArgument.isDefaultValueUnknown$navigation_common_release() && !navArgument.verify(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + navArgument.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    @xoIox
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, (NavDestination) null, 1, (Object) null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) obj;
        boolean Oxx0IOOO2 = IIX0o.Oxx0IOOO(this.deepLinks, navDestination.deepLinks);
        if (this.actions.size() == navDestination.actions.size()) {
            Iterator it = SequencesKt__SequencesKt.X0o0xo(SparseArrayKt.keyIterator(this.actions)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                int intValue = ((Number) it.next()).intValue();
                if (!IIX0o.Oxx0IOOO(this.actions.get(intValue), navDestination.actions.get(intValue))) {
                    break;
                }
            }
        } else {
            z = false;
        }
        if (this._arguments.size() == navDestination._arguments.size()) {
            Iterator<Map.Entry<String, NavArgument>> it2 = I0oOoX.XIXIxO(this._arguments).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = true;
                    break;
                }
                Map.Entry next = it2.next();
                if (navDestination._arguments.containsKey(next.getKey())) {
                    if (!IIX0o.Oxx0IOOO(navDestination._arguments.get(next.getKey()), next.getValue())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z2 = false;
        if (this.id != navDestination.id || !IIX0o.Oxx0IOOO(this.route, navDestination.route) || !Oxx0IOOO2 || !z || !z2) {
            return false;
        }
        return true;
    }

    @oOoXoXO
    public final String fillInLabel(@OOXIXo Context context, @oOoXoXO Bundle bundle) {
        NavType<Object> navType;
        NavArgument navArgument;
        IIX0o.x0xO0oo(context, bn.f.o);
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (bundle == null || !bundle.containsKey(group)) {
                throw new IllegalArgumentException("Could not find \"" + group + "\" in " + bundle + " to fill label \"" + charSequence + '\"');
            }
            matcher.appendReplacement(stringBuffer, "");
            if (group == null || (navArgument = this._arguments.get(group)) == null) {
                navType = null;
            } else {
                navType = navArgument.getType();
            }
            NavType<Integer> navType2 = NavType.ReferenceType;
            if (IIX0o.Oxx0IOOO(navType, navType2)) {
                IIX0o.oO(group, "argName");
                Integer num = navType2.get(bundle, group);
                IIX0o.x0XOIxOo(num, "null cannot be cast to non-null type kotlin.Int");
                String string = context.getString(num.intValue());
                IIX0o.oO(string, "context.getString(\n     …                        )");
                stringBuffer.append(string);
            } else {
                IIX0o.ooOOo0oXI(navType);
                IIX0o.oO(group, "argName");
                stringBuffer.append(String.valueOf(navType.get(bundle, group)));
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
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(i);
        }
        return null;
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

    public boolean hasDeepLink(@OOXIXo Uri uri) {
        IIX0o.x0xO0oo(uri, SDKConstants.PARAM_DEEP_LINK);
        return hasDeepLink(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        Set<String> keySet;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.id * 31;
        String str = this.route;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i10 = i9 + i;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i11 = i2 * 31;
            String uriPattern = navDeepLink.getUriPattern();
            if (uriPattern != null) {
                i6 = uriPattern.hashCode();
            } else {
                i6 = 0;
            }
            int i12 = (i11 + i6) * 31;
            String action = navDeepLink.getAction();
            if (action != null) {
                i7 = action.hashCode();
            } else {
                i7 = 0;
            }
            int i13 = (i12 + i7) * 31;
            String mimeType = navDeepLink.getMimeType();
            if (mimeType != null) {
                i8 = mimeType.hashCode();
            } else {
                i8 = 0;
            }
            i10 = i13 + i8;
        }
        Iterator<T> valueIterator = SparseArrayKt.valueIterator(this.actions);
        while (valueIterator.hasNext()) {
            NavAction navAction = (NavAction) valueIterator.next();
            int destinationId = ((i2 * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            if (navOptions != null) {
                i4 = navOptions.hashCode();
            } else {
                i4 = 0;
            }
            i2 = destinationId + i4;
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (!(defaultArguments == null || (keySet = defaultArguments.keySet()) == null)) {
                IIX0o.oO(keySet, "keySet()");
                for (String str2 : keySet) {
                    int i14 = i2 * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    IIX0o.ooOOo0oXI(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    if (obj != null) {
                        i5 = obj.hashCode();
                    } else {
                        i5 = 0;
                    }
                    i2 = i14 + i5;
                }
            }
        }
        for (String str3 : this._arguments.keySet()) {
            int hashCode = ((i2 * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = this._arguments.get(str3);
            if (navArgument != null) {
                i3 = navArgument.hashCode();
            } else {
                i3 = 0;
            }
            i2 = hashCode + i3;
        }
        return i2;
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
        for (NavDeepLink next : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            if (uri != null) {
                bundle = next.getMatchingArguments(uri, this._arguments);
            } else {
                bundle = null;
            }
            int calculateMatchingPathSegments$navigation_common_release = next.calculateMatchingPathSegments$navigation_common_release(uri);
            String action = navDeepLinkRequest.getAction();
            if (action == null || !IIX0o.Oxx0IOOO(action, next.getAction())) {
                z = false;
            } else {
                z = true;
            }
            String mimeType = navDeepLinkRequest.getMimeType();
            if (mimeType != null) {
                i = next.getMimeTypeMatchRating(mimeType);
            } else {
                i = -1;
            }
            if (bundle != null || ((z || i > -1) && hasRequiredArguments(next, uri, this._arguments))) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, bundle, next.isExactDeepLink(), calculateMatchingPathSegments$navigation_common_release, z, i);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DeepLinkMatch matchRoute(@OOXIXo String str) {
        NavDeepLink value;
        IIX0o.x0xO0oo(str, "route");
        X0IIOO<NavDeepLink> x0iioo = this.routeDeepLink;
        if (x0iioo == null || (value = x0iioo.getValue()) == null) {
            return null;
        }
        Uri parse = Uri.parse(Companion.createRoute(str));
        IIX0o.II0XooXoX(parse, "Uri.parse(this)");
        Bundle matchingArguments = value.getMatchingArguments(parse, this._arguments);
        if (matchingArguments == null) {
            return null;
        }
        return new DeepLinkMatch(this, matchingArguments, value.isExactDeepLink(), value.calculateMatchingPathSegments$navigation_common_release(parse), false, -1);
    }

    @CallSuper
    public void onInflate(@OOXIXo Context context, @OOXIXo AttributeSet attributeSet) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(attributeSet, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        IIX0o.oO(obtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(obtainAttributes.getString(R.styleable.Navigator_route));
        int i = R.styleable.Navigator_android_id;
        if (obtainAttributes.hasValue(i)) {
            setId(obtainAttributes.getResourceId(i, 0));
            this.idName = Companion.getDisplayName(context, this.id);
        }
        this.label = obtainAttributes.getText(R.styleable.Navigator_android_label);
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        obtainAttributes.recycle();
    }

    public final void putAction(@IdRes int i, @IdRes int i2) {
        putAction(i, new NavAction(i2, (NavOptions) null, (Bundle) null, 6, (IIXOooo) null));
    }

    public final void removeAction(@IdRes int i) {
        this.actions.remove(i);
    }

    public final void removeArgument(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "argumentName");
        this._arguments.remove(str);
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
            String createRoute = Companion.createRoute(str);
            List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new NavDestination$route$missingRequiredArguments$1(new NavDeepLink.Builder().setUriPattern(createRoute).build()));
            if (missingRequiredArguments.isEmpty()) {
                this.routeDeepLink = XIxXXX0x0.oIX0oI(new NavDestination$route$3(createRoute));
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
        sb.append(oIX0oI.I0Io.f17332II0xO0);
        String str = this.idName;
        if (str == null) {
            sb.append(HexStringBuilder.DEFAULT_PREFIX);
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(oIX0oI.I0Io.f17331I0Io);
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

    public final void addDeepLink(@OOXIXo NavDeepLink navDeepLink) {
        IIX0o.x0xO0oo(navDeepLink, "navDeepLink");
        List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new NavDestination$addDeepLink$missingRequiredArguments$1(navDeepLink));
        if (missingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + missingRequiredArguments).toString());
    }

    @xoIox
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds(@oOoXoXO NavDestination navDestination) {
        xxIXOIIO xxixoiio = new xxIXOIIO();
        NavGraph navGraph = this;
        while (true) {
            IIX0o.ooOOo0oXI(navGraph);
            NavGraph navGraph2 = navGraph.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph3 = navDestination.parent;
                IIX0o.ooOOo0oXI(navGraph3);
                if (navGraph3.findNode(navGraph.id) == navGraph) {
                    xxixoiio.addFirst(navGraph);
                    break;
                }
            }
            if (navGraph2 == null || navGraph2.getStartDestinationId() != navGraph.id) {
                xxixoiio.addFirst(navGraph);
            }
            if (IIX0o.Oxx0IOOO(navGraph2, navDestination) || navGraph2 == null) {
                break;
            }
            navGraph = navGraph2;
        }
        Iterable<NavDestination> oOo0o = CollectionsKt___CollectionsKt.oOo0o(xxixoiio);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(oOo0o, 10));
        for (NavDestination navDestination2 : oOo0o) {
            arrayList.add(Integer.valueOf(navDestination2.id));
        }
        return CollectionsKt___CollectionsKt.o0Oox0xox(arrayList);
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public boolean hasDeepLink(@OOXIXo NavDeepLinkRequest navDeepLinkRequest) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "deepLinkRequest");
        return matchDeepLink(navDeepLinkRequest) != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasRoute(@OOXIXo String str, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(str, "route");
        if (IIX0o.Oxx0IOOO(this.route, str)) {
            return true;
        }
        DeepLinkMatch matchRoute = matchRoute(str);
        if (!IIX0o.Oxx0IOOO(this, matchRoute != null ? matchRoute.getDestination() : null)) {
            return false;
        }
        return matchRoute.hasMatchingArgs(bundle);
    }

    public final void putAction(@IdRes int i, @OOXIXo NavAction navAction) {
        IIX0o.x0xO0oo(navAction, "action");
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i != 0) {
            this.actions.put(i, navAction);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDestination(@OOXIXo Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass()));
        IIX0o.x0xO0oo(navigator, "navigator");
    }
}
