package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.core.app.TaskStackBuilder;
import com.huawei.openalliance.ad.constant.bn;
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

    public static final class PermissiveNavigatorProvider extends NavigatorProvider {
        @OOXIXo
        private final Navigator<NavDestination> mDestNavigator = new NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1();

        public PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        @OOXIXo
        public <T extends Navigator<? extends NavDestination>> T getNavigator(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "name");
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                T t = this.mDestNavigator;
                IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of androidx.navigation.NavDeepLinkBuilder.PermissiveNavigatorProvider.getNavigator");
                return t;
            }
        }
    }

    public NavDeepLinkBuilder(@OOXIXo Context context2) {
        Intent intent2;
        IIX0o.x0xO0oo(context2, bn.f.o);
        this.context = context2;
        Activity activity2 = (Activity) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(context2, NavDeepLinkBuilder$activity$1.INSTANCE), NavDeepLinkBuilder$activity$2.INSTANCE));
        this.activity = activity2;
        if (activity2 != null) {
            intent2 = new Intent(context2, activity2.getClass());
        } else {
            intent2 = context2.getPackageManager().getLaunchIntentForPackage(context2.getPackageName());
            if (intent2 == null) {
                intent2 = new Intent();
            }
        }
        intent2.addFlags(268468224);
        this.intent = intent2;
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
        ArrayList arrayList2 = new ArrayList();
        NavDestination navDestination = null;
        for (DeepLinkDestination next : this.destinations) {
            int destinationId = next.getDestinationId();
            Bundle arguments = next.getArguments();
            NavDestination findDestination = findDestination(destinationId);
            if (findDestination != null) {
                for (int valueOf : findDestination.buildDeepLinkIds(navDestination)) {
                    arrayList.add(Integer.valueOf(valueOf));
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
        for (DeepLinkDestination destinationId : this.destinations) {
            int destinationId2 = destinationId.getDestinationId();
            if (findDestination(destinationId2) == null) {
                String displayName = NavDestination.Companion.getDisplayName(this.context, destinationId2);
                throw new IllegalArgumentException("Navigation destination " + displayName + " cannot be found in the navigation graph " + this.graph);
            }
        }
    }

    @xoIox
    @OOXIXo
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
            i = 0;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
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
        for (DeepLinkDestination next : this.destinations) {
            int destinationId = (i * 31) + next.getDestinationId();
            Bundle arguments = next.getArguments();
            if (arguments != null) {
                for (String str2 : arguments.keySet()) {
                    Object obj2 = arguments.get(str2);
                    int i5 = destinationId * 31;
                    if (obj2 != null) {
                        i2 = obj2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    destinationId = i5 + i2;
                }
            }
        }
        PendingIntent pendingIntent = createTaskStackBuilder().getPendingIntent(i, 201326592);
        IIX0o.ooOOo0oXI(pendingIntent);
        return pendingIntent;
    }

    @OOXIXo
    public final TaskStackBuilder createTaskStackBuilder() {
        if (this.graph == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        } else if (!this.destinations.isEmpty()) {
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
        } else {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link");
        }
    }

    @OOXIXo
    public final NavDeepLinkBuilder setArguments(@oOoXoXO Bundle bundle) {
        this.globalArgs = bundle;
        this.intent.putExtra(NavController.KEY_DEEP_LINK_EXTRAS, bundle);
        return this;
    }

    @OOXIXo
    public final NavDeepLinkBuilder setComponentName(@OOXIXo Class<? extends Activity> cls) {
        IIX0o.x0xO0oo(cls, "activityClass");
        return setComponentName(new ComponentName(this.context, cls));
    }

    @xoIox
    @OOXIXo
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

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder addDestination(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "route");
        return addDestination$default(this, str, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final NavDeepLinkBuilder setComponentName(@OOXIXo ComponentName componentName) {
        IIX0o.x0xO0oo(componentName, "componentName");
        this.intent.setComponent(componentName);
        return this;
    }

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder setDestination(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "destRoute");
        return setDestination$default(this, str, (Bundle) null, 2, (Object) null);
    }

    @OOXIXo
    public final NavDeepLinkBuilder setGraph(@OOXIXo NavGraph navGraph) {
        IIX0o.x0xO0oo(navGraph, "navGraph");
        this.graph = navGraph;
        verifyAllDestinations();
        return this;
    }

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder addDestination(@IdRes int i, @oOoXoXO Bundle bundle) {
        this.destinations.add(new DeepLinkDestination(i, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder setDestination(@IdRes int i, @oOoXoXO Bundle bundle) {
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(i, bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder addDestination(@OOXIXo String str, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(str, "route");
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(str).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    @xoIox
    @OOXIXo
    public final NavDeepLinkBuilder setDestination(@OOXIXo String str, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(str, "destRoute");
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(str).hashCode(), bundle));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(@OOXIXo NavController navController) {
        this(navController.getContext());
        IIX0o.x0xO0oo(navController, "navController");
        this.graph = navController.getGraph();
    }
}
