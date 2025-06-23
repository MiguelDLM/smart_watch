package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.ooOOo0oXI;
import kotlin.text.OxI;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraph\n+ 2 TypedArray.kt\nandroidx/core/content/res/TypedArrayKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 6 SparseArray.kt\nandroidx/collection/SparseArrayKt\n*L\n1#1,677:1\n232#2,3:678\n1603#3,9:681\n1855#3:690\n1856#3:692\n1612#3:693\n1603#3,9:694\n1855#3:703\n1856#3:705\n1612#3:706\n1#4:691\n1#4:704\n1#4:707\n179#5,2:708\n1224#5,2:711\n22#6:710\n62#6,4:713\n*S KotlinDebug\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraph\n*L\n61#1:678,3\n84#1:681,9\n84#1:690\n84#1:692\n84#1:693\n129#1:694,9\n129#1:703\n129#1:705\n129#1:706\n84#1:691\n129#1:704\n322#1:708,2\n561#1:711,2\n559#1:710\n566#1:713,4\n*E\n"})
/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, OI0IXox.oIX0oI {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;

    @oOoXoXO
    private String startDestIdName;

    @oOoXoXO
    private String startDestinationRoute;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final ooOOo0oXI<NavDestination> childHierarchy(@OOXIXo NavGraph navGraph) {
            IIX0o.x0xO0oo(navGraph, "<this>");
            return SequencesKt__SequencesKt.x0XOIxOo(navGraph, new Oox.oOoXoXO<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$childHierarchy$1
                @Override // Oox.oOoXoXO
                public final NavDestination invoke(NavDestination it) {
                    IIX0o.x0xO0oo(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.findNode(navGraph2.getStartDestinationId());
                }
            });
        }

        @x0XOIxOo
        @OOXIXo
        public final NavDestination findStartDestination(@OOXIXo NavGraph navGraph) {
            IIX0o.x0xO0oo(navGraph, "<this>");
            return (NavDestination) SequencesKt___SequencesKt.xxOXOOoIX(childHierarchy(navGraph));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(@OOXIXo Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        IIX0o.x0xO0oo(navGraphNavigator, "navGraphNavigator");
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$default(NavGraph navGraph, int i, NavDestination navDestination, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                navDestination2 = null;
            }
            return navGraph.findNodeComprehensive(i, navDestination, z, navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNodeComprehensive");
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavDestination findStartDestination(@OOXIXo NavGraph navGraph) {
        return Companion.findStartDestination(navGraph);
    }

    private final void setStartDestinationId(int i) {
        if (i != getId()) {
            if (this.startDestinationRoute != null) {
                setStartDestinationRoute(null);
            }
            this.startDestId = i;
            this.startDestIdName = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    private final void setStartDestinationRoute(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else if (!IIX0o.Oxx0IOOO(str, getRoute())) {
            if (!OxI.X0O0I0(str)) {
                hashCode = NavDestination.Companion.createRoute(str).hashCode();
            } else {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
        } else {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
        }
        this.startDestId = hashCode;
        this.startDestinationRoute = str;
    }

    public final void addAll(@OOXIXo NavGraph other) {
        IIX0o.x0xO0oo(other, "other");
        Iterator<NavDestination> it = other.iterator();
        while (it.hasNext()) {
            NavDestination next = it.next();
            it.remove();
            addDestination(next);
        }
    }

    public final void addDestination(@OOXIXo NavDestination node) {
        IIX0o.x0xO0oo(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (getRoute() != null && IIX0o.Oxx0IOOO(route, getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (id != getId()) {
            NavDestination navDestination = this.nodes.get(id);
            if (navDestination == node) {
                return;
            }
            if (node.getParent() == null) {
                if (navDestination != null) {
                    navDestination.setParent(null);
                }
                node.setParent(this);
                this.nodes.put(node.getId(), node);
                return;
            }
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
    }

    public final void addDestinations(@OOXIXo Collection<? extends NavDestination> nodes) {
        IIX0o.x0xO0oo(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavGraph) && super.equals(obj)) {
            NavGraph navGraph = (NavGraph) obj;
            if (this.nodes.size() == navGraph.nodes.size() && getStartDestinationId() == navGraph.getStartDestinationId()) {
                for (NavDestination navDestination : SequencesKt__SequencesKt.X0o0xo(SparseArrayKt.valueIterator(this.nodes))) {
                    if (!IIX0o.Oxx0IOOO(navDestination, navGraph.nodes.get(navDestination.getId()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @oOoXoXO
    public final NavDestination findNode(@IdRes int i) {
        return findNodeComprehensive$default(this, i, this, false, null, 8, null);
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNodeComprehensive(@IdRes int i, @oOoXoXO NavDestination navDestination, boolean z, @oOoXoXO NavDestination navDestination2) {
        NavDestination navDestination3;
        NavDestination navDestination4 = this.nodes.get(i);
        if (navDestination2 != null) {
            if (IIX0o.Oxx0IOOO(navDestination4, navDestination2) && IIX0o.Oxx0IOOO(navDestination4.getParent(), navDestination2.getParent())) {
                return navDestination4;
            }
            navDestination4 = null;
        } else if (navDestination4 != null) {
            return navDestination4;
        }
        if (z) {
            Iterator it = SequencesKt__SequencesKt.X0o0xo(SparseArrayKt.valueIterator(this.nodes)).iterator();
            while (true) {
                if (it.hasNext()) {
                    NavDestination navDestination5 = (NavDestination) it.next();
                    if ((navDestination5 instanceof NavGraph) && !IIX0o.Oxx0IOOO(navDestination5, navDestination)) {
                        navDestination3 = ((NavGraph) navDestination5).findNodeComprehensive(i, this, true, navDestination2);
                    } else {
                        navDestination3 = null;
                    }
                    if (navDestination3 != null) {
                        navDestination4 = navDestination3;
                        break;
                    }
                } else {
                    navDestination4 = null;
                    break;
                }
            }
        }
        if (navDestination4 == null) {
            if (getParent() == null || IIX0o.Oxx0IOOO(getParent(), navDestination)) {
                return null;
            }
            NavGraph parent = getParent();
            IIX0o.ooOOo0oXI(parent);
            return parent.findNodeComprehensive(i, this, z, navDestination2);
        }
        return navDestination4;
    }

    @Override // androidx.navigation.NavDestination
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        if (getId() != 0) {
            return super.getDisplayName();
        }
        return "the root navigation";
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        IIX0o.ooOOo0oXI(str2);
        return str2;
    }

    @kotlin.OOXIXo(message = "Use getStartDestinationId instead.", replaceWith = @kotlin.XX(expression = "startDestinationId", imports = {}))
    @IdRes
    public final int getStartDestination() {
        return getStartDestinationId();
    }

    @IdRes
    public final int getStartDestinationId() {
        return this.startDestId;
    }

    @oOoXoXO
    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int startDestinationId = getStartDestinationId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            startDestinationId = (((startDestinationId * 31) + sparseArrayCompat.keyAt(i)) * 31) + sparseArrayCompat.valueAt(i).hashCode();
        }
        return startDestinationId;
    }

    @Override // java.lang.Iterable
    @OOXIXo
    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    @Override // androidx.navigation.NavDestination
    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDestination.DeepLinkMatch matchDeepLink(@OOXIXo NavDeepLinkRequest navDeepLinkRequest) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive(navDeepLinkRequest, true, false, this);
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(@OOXIXo NavDeepLinkRequest navDeepLinkRequest, boolean z, boolean z2, @OOXIXo NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch deepLinkMatch2;
        IIX0o.x0xO0oo(navDeepLinkRequest, "navDeepLinkRequest");
        IIX0o.x0xO0oo(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavDestination.DeepLinkMatch deepLinkMatch3 = null;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                if (!IIX0o.Oxx0IOOO(navDestination, lastVisited)) {
                    deepLinkMatch2 = navDestination.matchDeepLink(navDeepLinkRequest);
                } else {
                    deepLinkMatch2 = null;
                }
                if (deepLinkMatch2 != null) {
                    arrayList.add(deepLinkMatch2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.o0xOIoxo(arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && z2 && !IIX0o.Oxx0IOOO(parent, lastVisited)) {
            deepLinkMatch3 = parent.matchDeepLinkComprehensive(navDeepLinkRequest, z, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.o0xOIoxo(CollectionsKt__CollectionsKt.xII(matchDeepLink, deepLinkMatch, deepLinkMatch3));
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination.DeepLinkMatch matchRouteComprehensive(@OOXIXo String route, boolean z, boolean z2, @OOXIXo NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch matchRoute;
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchRoute2 = matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                if (IIX0o.Oxx0IOOO(navDestination, lastVisited)) {
                    matchRoute = null;
                } else if (navDestination instanceof NavGraph) {
                    matchRoute = ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this);
                } else {
                    matchRoute = navDestination.matchRoute(route);
                }
                if (matchRoute != null) {
                    arrayList.add(matchRoute);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.o0xOIoxo(arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && z2 && !IIX0o.Oxx0IOOO(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchRouteComprehensive(route, z, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt___CollectionsKt.o0xOIoxo(CollectionsKt__CollectionsKt.xII(matchRoute2, deepLinkMatch, deepLinkMatch2));
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(@OOXIXo Context context, @OOXIXo AttributeSet attrs) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        super.onInflate(context, attrs);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.NavGraphNavigator);
        IIX0o.oO(obtainAttributes, "context.resources.obtain…leable.NavGraphNavigator)");
        setStartDestinationId(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.Companion.getDisplayName(context, this.startDestId);
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        obtainAttributes.recycle();
    }

    public final void remove(@OOXIXo NavDestination node) {
        IIX0o.x0xO0oo(node, "node");
        int indexOfKey = this.nodes.indexOfKey(node.getId());
        if (indexOfKey >= 0) {
            this.nodes.valueAt(indexOfKey).setParent(null);
            this.nodes.removeAt(indexOfKey);
        }
    }

    public final void setStartDestination(int i) {
        setStartDestinationId(i);
    }

    @Override // androidx.navigation.NavDestination
    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination findNode = findNode(this.startDestinationRoute);
        if (findNode == null) {
            findNode = findNode(getStartDestinationId());
        }
        sb.append(" startDestination=");
        if (findNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append(HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "sb.toString()");
        return sb2;
    }

    @oOoXoXO
    public final NavDestination findNode(@oOoXoXO String str) {
        if (str == null || OxI.X0O0I0(str)) {
            return null;
        }
        return findNode(str, true);
    }

    public final void setStartDestination(@OOXIXo String startDestRoute) {
        IIX0o.x0xO0oo(startDestRoute, "startDestRoute");
        setStartDestinationRoute(startDestRoute);
    }

    public final void addDestinations(@OOXIXo NavDestination... nodes) {
        IIX0o.x0xO0oo(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            addDestination(navDestination);
        }
    }

    public final /* synthetic */ <T> NavDestination findNode() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> void setStartDestination() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        setStartDestination(OxxIIOOXO.xxIXOIIO(null), new Oox.oOoXoXO<NavDestination, String>() { // from class: androidx.navigation.NavGraph$setStartDestination$1
            @Override // Oox.oOoXoXO
            public final String invoke(NavDestination startDestination) {
                IIX0o.x0xO0oo(startDestination, "startDestination");
                String route = startDestination.getRoute();
                IIX0o.ooOOo0oXI(route);
                return route;
            }
        });
    }

    @oOoXoXO
    public final <T> NavDestination findNode(@oOoXoXO T t) {
        if (t != null) {
            return findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(IO.oxoX(t.getClass()))));
        }
        return null;
    }

    public final <T> void setStartDestination(@OOXIXo final T startDestRoute) {
        IIX0o.x0xO0oo(startDestRoute, "startDestRoute");
        setStartDestination(OxxIIOOXO.Oxx0IOOO(IO.oxoX(startDestRoute.getClass())), new Oox.oOoXoXO<NavDestination, String>() { // from class: androidx.navigation.NavGraph$setStartDestination$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final String invoke(NavDestination startDestination) {
                IIX0o.x0xO0oo(startDestination, "startDestination");
                Map<String, NavArgument> arguments = startDestination.getArguments();
                LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(arguments.size()));
                Iterator<T> it = arguments.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
                }
                return RouteSerializerKt.generateRouteWithArgs(startDestRoute, linkedHashMap);
            }
        });
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNode(@OOXIXo String route, boolean z) {
        Object obj;
        IIX0o.x0xO0oo(route, "route");
        Iterator it = SequencesKt__SequencesKt.X0o0xo(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            NavDestination navDestination = (NavDestination) obj;
            if (OxI.x00IOx(navDestination.getRoute(), route, false, 2, null) || navDestination.matchRoute(route) != null) {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) obj;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        IIX0o.ooOOo0oXI(parent);
        return parent.findNode(route);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T> void setStartDestination(@OOXIXo Oxx0IOOO<T> serializer, @OOXIXo Oox.oOoXoXO<? super NavDestination, String> parseRoute) {
        IIX0o.x0xO0oo(serializer, "serializer");
        IIX0o.x0xO0oo(parseRoute, "parseRoute");
        int generateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination findNode = findNode(generateHashCode);
        if (findNode != null) {
            setStartDestinationRoute(parseRoute.invoke(findNode));
            this.startDestId = generateHashCode;
        } else {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.oIX0oI().xxIXOIIO() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
    }
}
