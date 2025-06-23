package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.Navigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nNavDeepLinkBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavDeepLinkBuilder.kt\nandroidx/navigation/NavDeepLinkBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,398:1\n1#2:399\n*E\n"})
/* loaded from: classes.dex */
public final class NavDeepLinkBuilder {

    @oOoXoXO
    private final Activity activity;

    @OOXIXo
    private final Context context;

    @OOXIXo
    private final List<DeepLinkDestination> destinations;

    @oOoXoXO
    private Bundle globalArgs;

    @oOoXoXO
    private NavGraph graph;

    @OOXIXo
    private final Intent intent;

    /* loaded from: classes.dex */
    public static final class DeepLinkDestination {

        @oOoXoXO
        private final Bundle arguments;
        private final int destinationId;

        public DeepLinkDestination(int i, @oOoXoXO Bundle bundle) {
            this.destinationId = i;
            this.arguments = bundle;
        }

        @oOoXoXO
        public final Bundle getArguments() {
            return this.arguments;
        }

        public final int getDestinationId() {
            return this.destinationId;
        }
    }

    /* loaded from: classes.dex */
    public static final class PermissiveNavigatorProvider extends NavigatorProvider {

        @OOXIXo
        private final Navigator<NavDestination> mDestNavigator = new Navigator<NavDestination>() { // from class: androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1
            @Override // androidx.navigation.Navigator
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            @Override // androidx.navigation.Navigator
            public NavDestination navigate(NavDestination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
                IIX0o.x0xO0oo(destination, "destination");
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.Navigator
            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        };

        public PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        @Override // androidx.navigation.NavigatorProvider
        @OOXIXo
        public <T extends Navigator<? extends NavDestination>> T getNavigator(@OOXIXo String name) {
            IIX0o.x0xO0oo(name, "name");
            try {
                return (T) super.getNavigator(name);
            } catch (IllegalStateException unused) {
                Navigator<NavDestination> navigator = this.mDestNavigator;
                IIX0o.x0XOIxOo(navigator, "null cannot be cast to non-null type T of androidx.navigation.NavDeepLinkBuilder.PermissiveNavigatorProvider.getNavigator");
                return navigator;
            }
        }
    }

    public NavDeepLinkBuilder(@OOXIXo Context context) {
        Intent launchIntentForPackage;
        IIX0o.x0xO0oo(context, "context");
        this.context = context;
        Activity activity = (Activity) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(context, new Oox.oOoXoXO<Context, Context>() { // from class: androidx.navigation.NavDeepLinkBuilder$activity$1
            @Override // Oox.oOoXoXO
            public final Context invoke(Context it) {
                IIX0o.x0xO0oo(it, "it");
                ContextWrapper contextWrapper = it instanceof ContextWrapper ? (ContextWrapper) it : null;
                if (contextWrapper != null) {
                    return contextWrapper.getBaseContext();
                }
                return null;
            }
        }), new Oox.oOoXoXO<Context, Activity>() { // from class: androidx.navigation.NavDeepLinkBuilder$activity$2
            @Override // Oox.oOoXoXO
            public final Activity invoke(Context it) {
                IIX0o.x0xO0oo(it, "it");
                if (it instanceof Activity) {
                    return (Activity) it;
                }
                return null;
            }
        }));
        this.activity = activity;
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.intent = launchIntentForPackage;
        this.destinations = new ArrayList();
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.addDestination(i, bundle);
    }

    private final void fillInIntent() {
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        NavDestination navDestination = null;
        for (DeepLinkDestination deepLinkDestination : this.destinations) {
            int destinationId = deepLinkDestination.getDestinationId();
            Bundle arguments = deepLinkDestination.getArguments();
            NavDestination findDestination = findDestination(destinationId);
            if (findDestination != null) {
                for (int i : findDestination.buildDeepLinkIds(navDestination)) {
                    arrayList.add(Integer.valueOf(i));
                    arrayList2.add(arguments);
                }
                navDestination = findDestination;
            } else {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.Companion.getDisplayName(this.context, destinationId) + " cannot be found in the navigation graph " + this.graph);
            }
        }
        this.intent.putExtra(NavController.KEY_DEEP_LINK_IDS, CollectionsKt___CollectionsKt.o0Oox0xox(arrayList));
        this.intent.putParcelableArrayListExtra(NavController.KEY_DEEP_LINK_ARGS, arrayList2);
    }

    private final NavDestination findDestination(@IdRes int i) {
        xxIXOIIO xxixoiio = new xxIXOIIO();
        NavGraph navGraph = this.graph;
        IIX0o.ooOOo0oXI(navGraph);
        xxixoiio.add(navGraph);
        while (!xxixoiio.isEmpty()) {
            NavDestination navDestination = (NavDestination) xxixoiio.removeFirst();
            if (navDestination.getId() == i) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    xxixoiio.add(it.next());
                }
            }
        }
        return null;
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.setDestination(i, bundle);
    }

    private final void verifyAllDestinations() {
        Iterator<DeepLinkDestination> it = this.destinations.iterator();
        while (it.hasNext()) {
            int destinationId = it.next().getDestinationId();
            if (findDestination(destinationId) == null) {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.Companion.getDisplayName(this.context, destinationId) + " cannot be found in the navigation graph " + this.graph);
            }
        }
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder addDestination(@IdRes int i) {
        return addDestination$default(this, i, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final PendingIntent createPendingIntent() {
        int i;
        int i2;
        int i3;
        Bundle bundle = this.globalArgs;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            i = 0;
            while (it.hasNext()) {
                Object obj = bundle.get(it.next());
                int i4 = i * 31;
                if (obj != null) {
                    i3 = obj.hashCode();
                } else {
                    i3 = 0;
                }
                i = i4 + i3;
            }
        } else {
            i = 0;
        }
        for (DeepLinkDestination deepLinkDestination : this.destinations) {
            i = (i * 31) + deepLinkDestination.getDestinationId();
            Bundle arguments = deepLinkDestination.getArguments();
            if (arguments != null) {
                Iterator<String> it2 = arguments.keySet().iterator();
                while (it2.hasNext()) {
                    Object obj2 = arguments.get(it2.next());
                    int i5 = i * 31;
                    if (obj2 != null) {
                        i2 = obj2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    i = i5 + i2;
                }
            }
        }
        PendingIntent pendingIntent = createTaskStackBuilder().getPendingIntent(i, 201326592);
        IIX0o.ooOOo0oXI(pendingIntent);
        return pendingIntent;
    }

    @OOXIXo
    public final TaskStackBuilder createTaskStackBuilder() {
        if (this.graph != null) {
            if (!this.destinations.isEmpty()) {
                fillInIntent();
                TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(new Intent(this.intent));
                IIX0o.oO(addNextIntentWithParentStack, "create(context).addNextI…rentStack(Intent(intent))");
                int intentCount = addNextIntentWithParentStack.getIntentCount();
                for (int i = 0; i < intentCount; i++) {
                    Intent editIntentAt = addNextIntentWithParentStack.editIntentAt(i);
                    if (editIntentAt != null) {
                        editIntentAt.putExtra(NavController.KEY_DEEP_LINK_INTENT, this.intent);
                    }
                }
                return addNextIntentWithParentStack;
            }
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link");
        }
        throw new IllegalStateException("You must call setGraph() before constructing the deep link");
    }

    @OOXIXo
    public final NavDeepLinkBuilder setArguments(@oOoXoXO Bundle bundle) {
        this.globalArgs = bundle;
        this.intent.putExtra(NavController.KEY_DEEP_LINK_EXTRAS, bundle);
        return this;
    }

    @OOXIXo
    public final NavDeepLinkBuilder setComponentName(@OOXIXo Class<? extends Activity> activityClass) {
        IIX0o.x0xO0oo(activityClass, "activityClass");
        return setComponentName(new ComponentName(this.context, activityClass));
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder setDestination(@IdRes int i) {
        return setDestination$default(this, i, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final NavDeepLinkBuilder setGraph(@NavigationRes int i) {
        return setGraph(new NavInflater(this.context, new PermissiveNavigatorProvider()).inflate(i));
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.addDestination(str, bundle);
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.setDestination(str, bundle);
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder addDestination(@OOXIXo String route) {
        IIX0o.x0xO0oo(route, "route");
        return addDestination$default(this, route, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final NavDeepLinkBuilder setComponentName(@OOXIXo ComponentName componentName) {
        IIX0o.x0xO0oo(componentName, "componentName");
        this.intent.setComponent(componentName);
        return this;
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder setDestination(@OOXIXo String destRoute) {
        IIX0o.x0xO0oo(destRoute, "destRoute");
        return setDestination$default(this, destRoute, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final NavDeepLinkBuilder setGraph(@OOXIXo NavGraph navGraph) {
        IIX0o.x0xO0oo(navGraph, "navGraph");
        this.graph = navGraph;
        verifyAllDestinations();
        return this;
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder addDestination(@IdRes int i, @oOoXoXO Bundle bundle) {
        this.destinations.add(new DeepLinkDestination(i, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder setDestination(@IdRes int i, @oOoXoXO Bundle bundle) {
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(i, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder addDestination(@OOXIXo String route, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(route, "route");
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(route).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @OOXIXo
    @xoIox
    public final NavDeepLinkBuilder setDestination(@OOXIXo String destRoute, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(destRoute, "destRoute");
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(destRoute).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(@OOXIXo NavController navController) {
        this(navController.getContext());
        IIX0o.x0xO0oo(navController, "navController");
        this.graph = navController.getGraph();
    }
}
