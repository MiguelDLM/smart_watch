package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.serialization.RouteSerializerKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.O0xOxO;
import kotlin.collections.OI0;
import kotlin.collections.OxI;
import kotlin.jvm.internal.II0XooXoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.oXIO0o0XI;
import kotlin.reflect.Oxx0xo;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.oO;
import kotlinx.coroutines.flow.xoIox;
import kotlinx.coroutines.flow.xoXoI;
import kotlinx.coroutines.flow.xxIXOIIO;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 Uri.kt\nandroidx/core/net/UriKt\n+ 8 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,2927:1\n537#1,10:3077\n179#2,2:2928\n1313#2,2:2938\n1313#2,2:2940\n179#2,2:3075\n1#3:2930\n146#4:2931\n533#5,6:2932\n1855#5,2:2942\n1855#5,2:2944\n1855#5,2:2946\n1855#5,2:2948\n1864#5,3:2950\n1774#5,4:2953\n1855#5:2957\n766#5:2958\n857#5,2:2959\n1856#5:2961\n766#5:2962\n857#5,2:2963\n766#5:2965\n857#5,2:2966\n1855#5,2:2968\n1855#5:2970\n1789#5,3:2971\n1856#5:2974\n819#5:2982\n847#5,2:2983\n1855#5:2985\n1856#5:2993\n1238#5,4:2996\n1855#5,2:3000\n1855#5,2:3002\n378#5,7:3004\n1549#5:3011\n1620#5,3:3012\n1855#5,2:3015\n1855#5,2:3017\n819#5:3019\n847#5,2:3020\n1855#5,2:3022\n1855#5,2:3024\n533#5,6:3026\n533#5,6:3032\n533#5,6:3038\n1855#5,2:3044\n1855#5,2:3046\n1864#5,3:3049\n1855#5,2:3055\n533#5,6:3057\n533#5,6:3063\n533#5,6:3069\n372#6,7:2975\n372#6,7:2986\n453#6:2994\n403#6:2995\n29#7:3048\n13404#8,3:3052\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController\n*L\n-1#1:3077,10\n86#1:2928,2\n724#1:2938,2\n745#1:2940,2\n2810#1:3075,2\n169#1:2931\n662#1:2932,6\n902#1:2942,2\n905#1:2944,2\n911#1:2946,2\n913#1:2948,2\n992#1:2950,3\n1054#1:2953,4\n1198#1:2957\n1200#1:2958\n1200#1:2959,2\n1198#1:2961\n1208#1:2962\n1208#1:2963,2\n1211#1:2965\n1211#1:2966,2\n1282#1:2968,2\n1296#1:2970\n1300#1:2971,3\n1296#1:2974\n1359#1:2982\n1359#1:2983,2\n1360#1:2985\n1360#1:2993\n1711#1:2996,4\n1991#1:3000,2\n2054#1:3002,2\n2064#1:3004,7\n2073#1:3011\n2073#1:3012,3\n2090#1:3015,2\n2100#1:3017,2\n2167#1:3019\n2167#1:3020,2\n2171#1:3022,2\n2215#1:3024,2\n2257#1:3026,6\n2289#1:3032,6\n2318#1:3038,6\n2332#1:3044,2\n2348#1:3046,2\n2563#1:3049,3\n2604#1:3055,2\n2704#1:3057,6\n2725#1:3063,6\n2751#1:3069,6\n1346#1:2975,7\n1362#1:2986,7\n1711#1:2994\n1711#1:2995\n2441#1:3048\n2601#1:3052,3\n*E\n"})
public class NavController {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    @OOXIXo
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    @OOXIXo
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    @OOXIXo
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    @OOXIXo
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    @OOXIXo
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    @OOXIXo
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    @OOXIXo
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    @OOXIXo
    private static final String TAG = "NavController";
    /* access modifiers changed from: private */
    public static boolean deepLinkSaveState = true;
    /* access modifiers changed from: private */
    @OOXIXo
    public final xoIox<List<NavBackStackEntry>> _currentBackStack;
    @OOXIXo
    private final xxIXOIIO<NavBackStackEntry> _currentBackStackEntryFlow;
    @oOoXoXO
    private NavGraph _graph;
    /* access modifiers changed from: private */
    @OOXIXo
    public NavigatorProvider _navigatorProvider;
    /* access modifiers changed from: private */
    @OOXIXo
    public final xoIox<List<NavBackStackEntry>> _visibleEntries;
    @oOoXoXO
    private Activity activity;
    /* access modifiers changed from: private */
    @oOoXoXO
    public Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> addToBackStackHandler;
    /* access modifiers changed from: private */
    @OOXIXo
    public final kotlin.collections.xxIXOIIO<NavBackStackEntry> backQueue;
    @OOXIXo
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<Integer, String> backStackMap;
    @OOXIXo
    private final Map<String, kotlin.collections.xxIXOIIO<NavBackStackEntryState>> backStackStates;
    @oOoXoXO
    private Parcelable[] backStackToRestore;
    @OOXIXo
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    @OOXIXo
    private final Context context;
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final kotlinx.coroutines.flow.IIXOooo<List<NavBackStackEntry>> currentBackStack;
    @OOXIXo
    private final X0o0xo<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<NavBackStackEntry, Boolean> entrySavedState;
    @OOXIXo
    private Lifecycle.State hostLifecycleState;
    /* access modifiers changed from: private */
    @oOoXoXO
    public NavInflater inflater;
    @OOXIXo
    private final LifecycleObserver lifecycleObserver;
    @oOoXoXO
    private LifecycleOwner lifecycleOwner;
    @OOXIXo
    private final X0IIOO navInflater$delegate;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    @oOoXoXO
    private Bundle navigatorStateToRestore;
    @OOXIXo
    private final OnBackPressedCallback onBackPressedCallback;
    @oOoXoXO
    private OnBackPressedDispatcher onBackPressedDispatcher;
    @OOXIXo
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    @OOXIXo
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    /* access modifiers changed from: private */
    @oOoXoXO
    public Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> popFromBackStackHandler;
    /* access modifiers changed from: private */
    @oOoXoXO
    public NavControllerViewModel viewModel;
    @OOXIXo
    private final kotlinx.coroutines.flow.IIXOooo<List<NavBackStackEntry>> visibleEntries;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @NavDeepLinkSaveStateControl
        @x0XOIxOo
        public final void enableDeepLinkSaveState(boolean z) {
            NavController.deepLinkSaveState = z;
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$NavControllerNavigatorState\n+ 2 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2927:1\n146#2:2928\n146#2:2929\n2624#3,3:2930\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$NavControllerNavigatorState\n*L\n297#1:2928\n330#1:2929\n360#1:2930,3\n*E\n"})
    public final class NavControllerNavigatorState extends NavigatorState {
        @OOXIXo
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(@OOXIXo NavController navController, Navigator<? extends NavDestination> navigator2) {
            IIX0o.x0xO0oo(navigator2, "navigator");
            this.this$0 = navController;
            this.navigator = navigator2;
        }

        public final void addInternal(@OOXIXo NavBackStackEntry navBackStackEntry) {
            IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
            super.push(navBackStackEntry);
        }

        @OOXIXo
        public NavBackStackEntry createBackStackEntry(@OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(navDestination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), navDestination, bundle, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, (String) null, (Bundle) null, 96, (Object) null);
        }

        @OOXIXo
        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        public void markTransitionComplete(@OOXIXo NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel access$getViewModel$p;
            IIX0o.x0xO0oo(navBackStackEntry, "entry");
            boolean Oxx0IOOO2 = IIX0o.Oxx0IOOO(this.this$0.entrySavedState.get(navBackStackEntry), Boolean.TRUE);
            super.markTransitionComplete(navBackStackEntry);
            this.this$0.entrySavedState.remove(navBackStackEntry);
            if (!this.this$0.backQueue.contains(navBackStackEntry)) {
                this.this$0.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                kotlin.collections.xxIXOIIO access$getBackQueue$p = this.this$0.backQueue;
                if (!(access$getBackQueue$p instanceof Collection) || !access$getBackQueue$p.isEmpty()) {
                    Iterator it = access$getBackQueue$p.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (IIX0o.Oxx0IOOO(((NavBackStackEntry) it.next()).getId(), navBackStackEntry.getId())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                    this.this$0._visibleEntries.I0Io(this.this$0.populateVisibleEntries$navigation_runtime_release());
                }
                if (!Oxx0IOOO2 && (access$getViewModel$p = this.this$0.viewModel) != null) {
                    access$getViewModel$p.clear(navBackStackEntry.getId());
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.I0Io(this.this$0.populateVisibleEntries$navigation_runtime_release());
            } else if (!isNavigating()) {
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.I0Io(CollectionsKt___CollectionsKt.o0Xo0XII(this.this$0.backQueue));
                this.this$0._visibleEntries.I0Io(this.this$0.populateVisibleEntries$navigation_runtime_release());
            }
        }

        public void pop(@OOXIXo NavBackStackEntry navBackStackEntry, boolean z) {
            IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            this.this$0.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
            if (IIX0o.Oxx0IOOO(navigator2, this.navigator)) {
                Oox.oOoXoXO access$getPopFromBackStackHandler$p = this.this$0.popFromBackStackHandler;
                if (access$getPopFromBackStackHandler$p != null) {
                    access$getPopFromBackStackHandler$p.invoke(navBackStackEntry);
                    super.pop(navBackStackEntry, z);
                    return;
                }
                this.this$0.popBackStackFromNavigator$navigation_runtime_release(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z));
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            IIX0o.ooOOo0oXI(obj);
            ((NavControllerNavigatorState) obj).pop(navBackStackEntry, z);
        }

        public void popWithTransition(@OOXIXo NavBackStackEntry navBackStackEntry, boolean z) {
            IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
            super.popWithTransition(navBackStackEntry, z);
        }

        public void prepareForTransition(@OOXIXo NavBackStackEntry navBackStackEntry) {
            IIX0o.x0xO0oo(navBackStackEntry, "entry");
            super.prepareForTransition(navBackStackEntry);
            if (this.this$0.backQueue.contains(navBackStackEntry)) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                return;
            }
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }

        public void push(@OOXIXo NavBackStackEntry navBackStackEntry) {
            IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (IIX0o.Oxx0IOOO(navigator2, this.navigator)) {
                Oox.oOoXoXO access$getAddToBackStackHandler$p = this.this$0.addToBackStackHandler;
                if (access$getAddToBackStackHandler$p != null) {
                    access$getAddToBackStackHandler$p.invoke(navBackStackEntry);
                    addInternal(navBackStackEntry);
                    return;
                }
                Log.i(NavController.TAG, "Ignoring add of destination " + navBackStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
    }

    public interface OnDestinationChangedListener {
        void onDestinationChanged(@OOXIXo NavController navController, @OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle);
    }

    public NavController(@OOXIXo Context context2) {
        Object obj;
        IIX0o.x0xO0oo(context2, bn.f.o);
        this.context = context2;
        Iterator it = SequencesKt__SequencesKt.x0XOIxOo(context2, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.activity = (Activity) obj;
        this.backQueue = new kotlin.collections.xxIXOIIO<>();
        xoIox<List<NavBackStackEntry>> oIX0oI2 = xoXoI.oIX0oI(CollectionsKt__CollectionsKt.ooXIXxIX());
        this._currentBackStack = oIX0oI2;
        this.currentBackStack = Oxx0IOOO.ooOOo0oXI(oIX0oI2);
        xoIox<List<NavBackStackEntry>> oIX0oI3 = xoXoI.oIX0oI(CollectionsKt__CollectionsKt.ooXIXxIX());
        this._visibleEntries = oIX0oI3;
        this.visibleEntries = Oxx0IOOO.ooOOo0oXI(oIX0oI3);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new oIX0oI(this);
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = XIxXXX0x0.oIX0oI(new NavController$navInflater$2(this));
        xxIXOIIO<NavBackStackEntry> II0xO02 = oO.II0xO0(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this._currentBackStackEntryFlow = II0xO02;
        this.currentBackStackEntryFlow = Oxx0IOOO.oOoXoXO(II0xO02);
    }

    /* access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        NavDestination navDestination2;
        List<NavBackStackEntry> list2;
        NavBackStackEntry navBackStackEntry2;
        Bundle bundle2;
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio;
        NavDestination navDestination3;
        NavDestination navDestination4;
        NavDestination navDestination5;
        Bundle bundle3;
        NavBackStackEntry navBackStackEntry3;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntry4;
        NavDestination navDestination6 = navDestination;
        List<NavBackStackEntry> list3 = list;
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof FloatingWindow)) {
            while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof FloatingWindow)) {
                if (!popBackStackInternal$default(this, this.backQueue.last().getDestination().getId(), true, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        kotlin.collections.xxIXOIIO xxixoiio2 = new kotlin.collections.xxIXOIIO();
        NavBackStackEntry navBackStackEntry5 = null;
        if (navDestination6 instanceof NavGraph) {
            NavGraph navGraph2 = destination;
            while (true) {
                IIX0o.ooOOo0oXI(navGraph2);
                NavGraph parent = navGraph2.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list3.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntry4 = null;
                            break;
                        }
                        navBackStackEntry4 = listIterator.previous();
                        if (IIX0o.Oxx0IOOO(navBackStackEntry4.getDestination(), parent)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry6 = navBackStackEntry4;
                    if (navBackStackEntry6 == null) {
                        navDestination2 = destination;
                        navBackStackEntry6 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, parent, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                    } else {
                        navDestination2 = destination;
                    }
                    xxixoiio2.addFirst(navBackStackEntry6);
                    if (this.backQueue.isEmpty() || this.backQueue.last().getDestination() != parent) {
                        bundle2 = bundle;
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        navGraph = parent;
                        xxixoiio = xxixoiio2;
                    } else {
                        bundle2 = bundle;
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        navGraph = parent;
                        xxixoiio = xxixoiio2;
                        popEntryFromBackStack$default(this, this.backQueue.last(), false, (kotlin.collections.xxIXOIIO) null, 6, (Object) null);
                    }
                } else {
                    bundle2 = bundle;
                    navBackStackEntry2 = navBackStackEntry;
                    navGraph = parent;
                    xxixoiio = xxixoiio2;
                    navDestination2 = destination;
                    list2 = list3;
                }
                if (navGraph == null || navGraph == navDestination6) {
                    break;
                }
                xxixoiio2 = xxixoiio;
                list3 = list2;
                navGraph2 = navGraph;
                destination = navDestination2;
            }
        } else {
            bundle2 = bundle;
            navBackStackEntry2 = navBackStackEntry;
            xxixoiio = xxixoiio2;
            navDestination2 = destination;
            list2 = list3;
        }
        if (xxixoiio.isEmpty()) {
            navDestination3 = navDestination2;
        } else {
            navDestination3 = ((NavBackStackEntry) xxixoiio.first()).getDestination();
        }
        while (navDestination3 != null && findDestination(navDestination3.getId(), navDestination3) != navDestination3) {
            navDestination3 = navDestination3.getParent();
            if (navDestination3 != null) {
                if (bundle2 == null || !bundle.isEmpty()) {
                    bundle3 = bundle2;
                } else {
                    bundle3 = null;
                }
                ListIterator<NavBackStackEntry> listIterator2 = list2.listIterator(list.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntry3 = null;
                        break;
                    }
                    navBackStackEntry3 = listIterator2.previous();
                    if (IIX0o.Oxx0IOOO(navBackStackEntry3.getDestination(), navDestination3)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry7 = navBackStackEntry3;
                if (navBackStackEntry7 == null) {
                    navBackStackEntry7 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, navDestination3, navDestination3.addInDefaultArgs(bundle3), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                }
                xxixoiio.addFirst(navBackStackEntry7);
            }
        }
        if (xxixoiio.isEmpty()) {
            navDestination4 = navDestination2;
        } else {
            navDestination4 = ((NavBackStackEntry) xxixoiio.first()).getDestination();
        }
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            NavDestination destination2 = this.backQueue.last().getDestination();
            IIX0o.x0XOIxOo(destination2, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) destination2).getNodes().get(navDestination4.getId()) != null) {
                break;
            }
            popEntryFromBackStack$default(this, this.backQueue.last(), false, (kotlin.collections.xxIXOIIO) null, 6, (Object) null);
        }
        NavBackStackEntry Oxx0IOOO2 = this.backQueue.Oxx0IOOO();
        if (Oxx0IOOO2 == null) {
            Oxx0IOOO2 = (NavBackStackEntry) xxixoiio.Oxx0IOOO();
        }
        if (Oxx0IOOO2 != null) {
            navDestination5 = Oxx0IOOO2.getDestination();
        } else {
            navDestination5 = null;
        }
        if (!IIX0o.Oxx0IOOO(navDestination5, this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list2.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator3.previous();
                NavDestination destination3 = previous.getDestination();
                NavGraph navGraph3 = this._graph;
                IIX0o.ooOOo0oXI(navGraph3);
                if (IIX0o.Oxx0IOOO(destination3, navGraph3)) {
                    navBackStackEntry5 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry8 = navBackStackEntry5;
            if (navBackStackEntry8 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.Companion;
                Context context2 = this.context;
                NavGraph navGraph4 = this._graph;
                IIX0o.ooOOo0oXI(navGraph4);
                NavGraph navGraph5 = this._graph;
                IIX0o.ooOOo0oXI(navGraph5);
                navBackStackEntry8 = NavBackStackEntry.Companion.create$default(companion, context2, navGraph4, navGraph5.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
            }
            xxixoiio.addFirst(navBackStackEntry8);
        }
        for (NavBackStackEntry navBackStackEntry9 : xxixoiio) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry9.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.addInternal(navBackStackEntry9);
            } else {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.getNavigatorName() + " should already be created").toString());
            }
        }
        this.backQueue.addAll(xxixoiio);
        this.backQueue.add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry10 : CollectionsKt___CollectionsKt.OIxOIX0II(xxixoiio, navBackStackEntry2)) {
            NavGraph parent2 = navBackStackEntry10.getDestination().getParent();
            if (parent2 != null) {
                linkChildToParent(navBackStackEntry10, getBackStackEntry(parent2.getId()));
            }
        }
    }

    public static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                list = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    @MainThread
    private final boolean clearBackStackInternal(@IdRes int i) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i, (Bundle) null, NavOptionsBuilderKt.navOptions(NavController$clearBackStackInternal$restored$1.INSTANCE), (Navigator.Extras) null);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(i, true, false)) {
            return false;
        }
        return true;
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, (kotlin.collections.xxIXOIIO) null, 6, (Object) null);
        }
        NavBackStackEntry oOoXoXO2 = this.backQueue.oOoXoXO();
        if (oOoXoXO2 != null) {
            this.backStackEntriesToDispatch.add(oOoXoXO2);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : o0Xo0XII) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.I0Io(navBackStackEntry);
            }
            this._currentBackStack.I0Io(CollectionsKt___CollectionsKt.o0Xo0XII(this.backQueue));
            this._visibleEntries.I0Io(populateVisibleEntries$navigation_runtime_release());
        }
        if (oOoXoXO2 != null) {
            return true;
        }
        return false;
    }

    @NavDeepLinkSaveStateControl
    @x0XOIxOo
    public static final void enableDeepLinkSaveState(boolean z) {
        Companion.enableDeepLinkSaveState(z);
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> list, NavDestination navDestination, boolean z, boolean z2) {
        String str;
        boolean z3 = z2;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        kotlin.collections.xxIXOIIO xxixoiio = new kotlin.collections.xxIXOIIO();
        for (Navigator popBackStackInternal : list) {
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            popBackStackInternal(popBackStackInternal, this.backQueue.last(), z3, new NavController$executePopOperations$1(booleanRef2, booleanRef, this, z2, xxixoiio));
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z3) {
            if (!z) {
                for (NavDestination id : SequencesKt___SequencesKt.Ix0x(SequencesKt__SequencesKt.x0XOIxOo(navDestination, NavController$executePopOperations$2.INSTANCE), new NavController$executePopOperations$3(this))) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer valueOf = Integer.valueOf(id.getId());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) xxixoiio.Oxx0IOOO();
                    if (navBackStackEntryState != null) {
                        str = navBackStackEntryState.getId();
                    } else {
                        str = null;
                    }
                    map.put(valueOf, str);
                }
            }
            if (!xxixoiio.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) xxixoiio.first();
                for (NavDestination id2 : SequencesKt___SequencesKt.Ix0x(SequencesKt__SequencesKt.x0XOIxOo(findDestination$default(this, navBackStackEntryState2.getDestinationId(), (NavDestination) null, 2, (Object) null), NavController$executePopOperations$5.INSTANCE), new NavController$executePopOperations$6(this))) {
                    this.backStackMap.put(Integer.valueOf(id2.getId()), navBackStackEntryState2.getId());
                }
                if (this.backStackMap.values().contains(navBackStackEntryState2.getId())) {
                    this.backStackStates.put(navBackStackEntryState2.getId(), xxixoiio);
                }
            }
        }
        updateOnBackPressedCallbackEnabled();
        return booleanRef.element;
    }

    private final boolean executeRestoreState(List<NavBackStackEntry> list, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        String str;
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List> arrayList = new ArrayList<>();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList<>();
        for (Object next : list) {
            if (!(((NavBackStackEntry) next).getDestination() instanceof NavGraph)) {
                arrayList2.add(next);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list2 = (List) CollectionsKt___CollectionsKt.xX0ox(arrayList);
            if (list2 == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.O0O0Io00X(list2)) == null || (destination = navBackStackEntry.getDestination()) == null) {
                str = null;
            } else {
                str = destination.getNavigatorName();
            }
            if (IIX0o.Oxx0IOOO(str, navBackStackEntry2.getDestination().getNavigatorName())) {
                list2.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt__CollectionsKt.XOxIOxOx(navBackStackEntry2));
            }
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List list3 : arrayList) {
            navigateInternal(this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt___CollectionsKt.O0OOX0IIx(list3)).getDestination().getNavigatorName()), list3, navOptions, extras, new NavController$executeRestoreState$3(booleanRef, list, new Ref.IntRef(), this, bundle));
        }
        return booleanRef.element;
    }

    public static /* synthetic */ NavDestination findDestination$default(NavController navController, int i, NavDestination navDestination, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                navDestination = null;
            }
            return navController.findDestination(i, navDestination);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestination");
    }

    public static /* synthetic */ NavDestination findDestinationComprehensive$default(NavController navController, NavDestination navDestination, int i, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                navDestination2 = null;
            }
            return navController.findDestinationComprehensive(navDestination, i, z, navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestinationComprehensive");
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = iArr.length;
        int i = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i >= length) {
                return null;
            }
            int i2 = iArr[i];
            if (i == 0) {
                NavGraph navGraph3 = this._graph;
                IIX0o.ooOOo0oXI(navGraph3);
                if (navGraph3.getId() == i2) {
                    navDestination = this._graph;
                }
            } else {
                IIX0o.ooOOo0oXI(navGraph2);
                navDestination = navGraph2.findNode(i2);
            }
            if (navDestination == null) {
                return NavDestination.Companion.getDisplayName(this.context, i2);
            }
            if (i != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    IIX0o.ooOOo0oXI(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    private final <T> String generateRouteFilled(T t) {
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(IO.oxoX(t.getClass()))), true, (NavDestination) null, 4, (Object) null);
        if (findDestinationComprehensive$default != null) {
            Map<String, NavArgument> arguments = findDestinationComprehensive$default.getArguments();
            LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(arguments.size()));
            for (Map.Entry entry : arguments.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
            }
            return RouteSerializerKt.generateRouteWithArgs(t, linkedHashMap);
        }
        throw new IllegalArgumentException(("Destination with route " + IO.oxoX(t.getClass()).xoXoI() + " cannot be found in navigation graph " + this._graph).toString());
    }

    private final int getDestinationCountOnBackStack() {
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        int i = 0;
        if (!(xxixoiio instanceof Collection) || !xxixoiio.isEmpty()) {
            for (NavBackStackEntry destination : xxixoiio) {
                if (!(destination.getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
                    CollectionsKt__CollectionsKt.oxxXoxO();
                }
            }
        }
        return i;
    }

    private final NavGraph getTopGraph(kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio) {
        NavDestination navDestination;
        NavBackStackEntry oOoXoXO2 = xxixoiio.oOoXoXO();
        if (oOoXoXO2 == null || (navDestination = oOoXoXO2.getDestination()) == null) {
            navDestination = this._graph;
            IIX0o.ooOOo0oXI(navDestination);
        }
        if (navDestination instanceof NavGraph) {
            return (NavGraph) navDestination;
        }
        NavGraph parent = navDestination.getParent();
        IIX0o.ooOOo0oXI(parent);
        return parent;
    }

    private final List<NavBackStackEntry> instantiateBackStack(kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio) {
        NavDestination navDestination;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry oOoXoXO2 = this.backQueue.oOoXoXO();
        if (oOoXoXO2 == null || (navDestination = oOoXoXO2.getDestination()) == null) {
            navDestination = getGraph();
        }
        if (xxixoiio != null) {
            for (NavBackStackEntryState navBackStackEntryState : xxixoiio) {
                NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, navDestination, navBackStackEntryState.getDestinationId(), true, (NavDestination) null, 4, (Object) null);
                if (findDestinationComprehensive$default != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.context, findDestinationComprehensive$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                    navDestination = findDestinationComprehensive$default;
                } else {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException(("Restore State failed: destination " + displayName + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        return arrayList;
    }

    private final boolean launchSingleTopInternal(NavDestination navDestination, Bundle bundle) {
        int i;
        NavDestination destination;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().getDestination() == navDestination) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            return false;
        }
        if (navDestination instanceof NavGraph) {
            List<R> oox000IX2 = SequencesKt___SequencesKt.oox000IX(SequencesKt___SequencesKt.X0xxXX0(NavGraph.Companion.childHierarchy((NavGraph) navDestination), NavController$launchSingleTopInternal$childHierarchyId$1.INSTANCE));
            if (this.backQueue.size() - i != oox000IX2.size()) {
                return false;
            }
            kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio2 = this.backQueue;
            Iterable<NavBackStackEntry> subList = xxixoiio2.subList(i, xxixoiio2.size());
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(subList, 10));
            for (NavBackStackEntry destination2 : subList) {
                arrayList.add(Integer.valueOf(destination2.getDestination().getId()));
            }
            if (!IIX0o.Oxx0IOOO(arrayList, oox000IX2)) {
                return false;
            }
        } else if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || navDestination.getId() != destination.getId()) {
            return false;
        }
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio3 = new kotlin.collections.xxIXOIIO<>();
        while (CollectionsKt__CollectionsKt.oo0xXOI0I(this.backQueue) >= i) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) OxI.xx0X0(this.backQueue);
            unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
            xxixoiio3.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.getDestination().addInDefaultArgs(bundle)));
        }
        for (NavBackStackEntry navBackStackEntry2 : xxixoiio3) {
            NavGraph parent = navBackStackEntry2.getDestination().getParent();
            if (parent != null) {
                linkChildToParent(navBackStackEntry2, getBackStackEntry(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : xxixoiio3) {
            this._navigatorProvider.getNavigator(navBackStackEntry3.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry3);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController navController, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        IIX0o.x0xO0oo(navController, "this$0");
        IIX0o.x0xO0oo(lifecycleOwner2, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        navController.hostLifecycleState = event.getTargetState();
        if (navController._graph != null) {
            for (T handleLifecycleEvent : CollectionsKt___CollectionsKt.o0Xo0XII(navController.backQueue)) {
                handleLifecycleEvent.handleLifecycleEvent(event);
            }
        }
    }

    private final void linkChildToParent(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        if (this.parentToChildCount.get(navBackStackEntry2) == null) {
            this.parentToChildCount.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntry2);
        IIX0o.ooOOo0oXI(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                navOptions = null;
            }
            if ((i & 4) != 0) {
                extras = null;
            }
            navController.navigate(str, navOptions, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> oooxoxo) {
        this.addToBackStackHandler = oooxoxo;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    public static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                oooxoxo = NavController$navigateInternal$1.INSTANCE;
            }
            navController.navigateInternal(navigator, list, navOptions, extras, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }

    @MainThread
    private final void onGraphCreated(Bundle bundle) {
        Activity activity2;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.navigatorStateToRestore;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                IIX0o.oO(next, "name");
                Navigator navigator = navigatorProvider.getNavigator(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i = 0;
            while (i < length) {
                Parcelable parcelable = parcelableArr[i];
                IIX0o.x0XOIxOo(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination$default = findDestination$default(this, navBackStackEntryState.getDestinationId(), (NavDestination) null, 2, (Object) null);
                if (findDestination$default != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    Navigator navigator2 = this._navigatorProvider.getNavigator(findDestination$default.getNavigatorName());
                    Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                    NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                    if (navControllerNavigatorState == null) {
                        navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                        map.put(navigator2, navControllerNavigatorState);
                    }
                    this.backQueue.add(instantiate);
                    navControllerNavigatorState.addInternal(instantiate);
                    NavGraph parent = instantiate.getDestination().getParent();
                    if (parent != null) {
                        linkChildToParent(instantiate, getBackStackEntry(parent.getId()));
                    }
                    i++;
                } else {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + displayName + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        ArrayList<Navigator> arrayList = new ArrayList<>();
        for (Object next2 : this._navigatorProvider.getNavigators().values()) {
            if (!((Navigator) next2).isAttached()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !this.backQueue.isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity2 = this.activity) != null) {
            IIX0o.ooOOo0oXI(activity2);
            if (handleDeepLink(activity2.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this._graph;
        IIX0o.ooOOo0oXI(navGraph);
        navigate((NavDestination) navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStack(str, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z, Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> oooxoxo) {
        this.popFromBackStackHandler = oooxoxo;
        navigator.popBackStack(navBackStackEntry, z);
        this.popFromBackStackHandler = null;
    }

    public static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                oooxoxo = NavController$popBackStackInternal$1.INSTANCE;
            }
            navController.popBackStackInternal(navigator, navBackStackEntry, z, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    /* access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry navBackStackEntry, boolean z, kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio) {
        NavControllerViewModel navControllerViewModel;
        kotlinx.coroutines.flow.IIXOooo<Set<NavBackStackEntry>> transitionsInProgress;
        Set value;
        NavBackStackEntry last = this.backQueue.last();
        if (IIX0o.Oxx0IOOO(last, navBackStackEntry)) {
            OxI.xx0X0(this.backQueue);
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider().getNavigator(last.getDestination().getNavigatorName()));
            boolean z2 = true;
            if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) && !this.parentToChildCount.containsKey(last)) {
                z2 = false;
            }
            Lifecycle.State currentState = last.getLifecycle().getCurrentState();
            Lifecycle.State state = Lifecycle.State.CREATED;
            if (currentState.isAtLeast(state)) {
                if (z) {
                    last.setMaxLifecycle(state);
                    xxixoiio.addFirst(new NavBackStackEntryState(last));
                }
                if (!z2) {
                    last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                    unlinkChildFromParent$navigation_runtime_release(last);
                } else {
                    last.setMaxLifecycle(state);
                }
            }
            if (!z && !z2 && (navControllerViewModel = this.viewModel) != null) {
                navControllerViewModel.clear(last.getId());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + HexStringBuilder.COMMENT_END_CHAR).toString());
    }

    public static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z, kotlin.collections.xxIXOIIO xxixoiio, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                xxixoiio = new kotlin.collections.xxIXOIIO();
            }
            navController.popEntryFromBackStack(navBackStackEntry, z, xxixoiio);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    private final boolean restoreStateInternal(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(i))) {
            return false;
        }
        String str = this.backStackMap.get(Integer.valueOf(i));
        OxI.XIXIX(this.backStackMap.values(), new NavController$restoreStateInternal$1(str));
        return executeRestoreState(instantiateBackStack((kotlin.collections.xxIXOIIO) XoX.OOXIXo(this.backStackStates).remove(str)), bundle, navOptions, extras);
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        Bundle bundle;
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity2 = this.activity;
        IIX0o.ooOOo0oXI(activity2);
        Intent intent = activity2.getIntent();
        Bundle extras = intent.getExtras();
        IIX0o.ooOOo0oXI(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        IIX0o.ooOOo0oXI(intArray);
        List<Integer> oXooI = ArraysKt___ArraysKt.oXooI(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int intValue = ((Number) OxI.xx0X0(oXooI)).intValue();
        if (parcelableArrayList != null) {
            Bundle bundle2 = (Bundle) OxI.xx0X0(parcelableArrayList);
        }
        if (oXooI.isEmpty()) {
            return false;
        }
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), intValue, false, (NavDestination) null, 4, (Object) null);
        if (findDestinationComprehensive$default instanceof NavGraph) {
            intValue = NavGraph.Companion.findStartDestination((NavGraph) findDestinationComprehensive$default).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || intValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(Xo0.oIX0oI(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle3 = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle3 != null) {
            bundleOf.putAll(bundle3);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object next : oXooI) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            int intValue2 = ((Number) next).intValue();
            if (parcelableArrayList != null) {
                bundle = (Bundle) parcelableArrayList.get(i);
            } else {
                bundle = null;
            }
            createDeepLink.addDestination(intValue2, bundle);
            i = i2;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity3 = this.activity;
        if (activity3 != null) {
            activity3.finish();
        }
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        Bundle bundle;
        NavDestination currentDestination = getCurrentDestination();
        IIX0o.ooOOo0oXI(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestinationId() != id) {
                Bundle bundle2 = new Bundle();
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    IIX0o.ooOOo0oXI(activity2);
                    if (activity2.getIntent() != null) {
                        Activity activity3 = this.activity;
                        IIX0o.ooOOo0oXI(activity3);
                        if (activity3.getIntent().getData() != null) {
                            Activity activity4 = this.activity;
                            IIX0o.ooOOo0oXI(activity4);
                            bundle2.putParcelable(KEY_DEEP_LINK_INTENT, activity4.getIntent());
                            NavGraph topGraph = getTopGraph(this.backQueue);
                            Activity activity5 = this.activity;
                            IIX0o.ooOOo0oXI(activity5);
                            Intent intent = activity5.getIntent();
                            IIX0o.oO(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(new NavDeepLinkRequest(intent), true, true, topGraph);
                            if (matchDeepLinkComprehensive != null) {
                                bundle = matchDeepLinkComprehensive.getMatchingArgs();
                            } else {
                                bundle = null;
                            }
                            if (bundle != null) {
                                bundle2.putAll(matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle2).createTaskStackBuilder().startActivities();
                Activity activity6 = this.activity;
                if (activity6 != null) {
                    activity6.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (getDestinationCountOnBackStack() > 1) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto L_0x000e
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void addOnDestinationChangedListener(@OOXIXo OnDestinationChangedListener onDestinationChangedListener) {
        IIX0o.x0xO0oo(onDestinationChangedListener, "listener");
        this.onDestinationChangedListeners.add(onDestinationChangedListener);
        if (!this.backQueue.isEmpty()) {
            NavBackStackEntry last = this.backQueue.last();
            onDestinationChangedListener.onDestinationChanged(this, last.getDestination(), last.getArguments());
        }
    }

    @MainThread
    public final boolean clearBackStack(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "route");
        return clearBackStackInternal(str) && dispatchOnDestinationChanged();
    }

    @OOXIXo
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void enableOnBackPressed(boolean z) {
        this.enableOnBackPressedCallback = z;
        updateOnBackPressedCallbackEnabled();
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@IdRes int i, @oOoXoXO NavDestination navDestination) {
        NavDestination navDestination2;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        IIX0o.ooOOo0oXI(navGraph);
        if (navGraph.getId() == i) {
            if (navDestination == null) {
                return this._graph;
            }
            if (IIX0o.Oxx0IOOO(this._graph, navDestination) && navDestination.getParent() == null) {
                return this._graph;
            }
        }
        NavBackStackEntry oOoXoXO2 = this.backQueue.oOoXoXO();
        if (oOoXoXO2 == null || (navDestination2 = oOoXoXO2.getDestination()) == null) {
            navDestination2 = this._graph;
            IIX0o.ooOOo0oXI(navDestination2);
        }
        return findDestinationComprehensive(navDestination2, i, false, navDestination);
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestinationComprehensive(@OOXIXo NavDestination navDestination, @IdRes int i, boolean z, @oOoXoXO NavDestination navDestination2) {
        NavGraph navGraph;
        IIX0o.x0xO0oo(navDestination, "<this>");
        if (navDestination.getId() == i && (navDestination2 == null || (IIX0o.Oxx0IOOO(navDestination, navDestination2) && IIX0o.Oxx0IOOO(navDestination.getParent(), navDestination2.getParent())))) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            IIX0o.ooOOo0oXI(navGraph);
        }
        return navGraph.findNodeComprehensive(i, navGraph, z, navDestination2);
    }

    @OOXIXo
    public NavBackStackEntry getBackStackEntry(@IdRes int i) {
        NavBackStackEntry navBackStackEntry;
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.getDestination().getId() == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + i + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final kotlinx.coroutines.flow.IIXOooo<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.currentBackStack;
    }

    @oOoXoXO
    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.backQueue.oOoXoXO();
    }

    @OOXIXo
    public final X0o0xo<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    @oOoXoXO
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @MainThread
    @OOXIXo
    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph != null) {
            IIX0o.x0XOIxOo(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @OOXIXo
    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    @OOXIXo
    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    @OOXIXo
    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    @oOoXoXO
    public NavBackStackEntry getPreviousBackStackEntry() {
        T t;
        Iterator<T> it = CollectionsKt___CollectionsKt.OOoOoO0o(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator<T> it2 = SequencesKt__SequencesKt.X0o0xo(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (!(((NavBackStackEntry) t).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) t;
    }

    @OOXIXo
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i) {
        if (this.viewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException(("No NavGraph with ID " + i + " is on the NavController's back stack").toString());
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
    }

    @OOXIXo
    public final kotlinx.coroutines.flow.IIXOooo<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f2 A[RETURN] */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleDeepLink(@OXOo.oOoXoXO android.content.Intent r20) {
        /*
            r19 = this;
            r7 = r19
            r1 = r20
            r8 = 0
            if (r1 != 0) goto L_0x0008
            return r8
        L_0x0008:
            android.os.Bundle r2 = r20.getExtras()
            java.lang.String r3 = "NavController"
            r9 = 0
            if (r2 == 0) goto L_0x002d
            java.lang.String r0 = "android-support-nav:controller:deepLinkIds"
            int[] r0 = r2.getIntArray(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x002e
        L_0x0018:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleDeepLink() could not extract deepLink from "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4, r0)
        L_0x002d:
            r0 = r9
        L_0x002e:
            if (r2 == 0) goto L_0x0037
            java.lang.String r4 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r4 = r2.getParcelableArrayList(r4)
            goto L_0x0038
        L_0x0037:
            r4 = r9
        L_0x0038:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            if (r2 == 0) goto L_0x0046
            java.lang.String r6 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r2 = r2.getBundle(r6)
            goto L_0x0047
        L_0x0046:
            r2 = r9
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r5.putAll(r2)
        L_0x004c:
            r10 = 1
            if (r0 == 0) goto L_0x0052
            int r2 = r0.length
            if (r2 != 0) goto L_0x007a
        L_0x0052:
            kotlin.collections.xxIXOIIO<androidx.navigation.NavBackStackEntry> r2 = r7.backQueue
            androidx.navigation.NavGraph r2 = r7.getTopGraph(r2)
            androidx.navigation.NavDeepLinkRequest r6 = new androidx.navigation.NavDeepLinkRequest
            r6.<init>(r1)
            androidx.navigation.NavDestination$DeepLinkMatch r2 = r2.matchDeepLinkComprehensive(r6, r10, r10, r2)
            if (r2 == 0) goto L_0x007a
            androidx.navigation.NavDestination r0 = r2.getDestination()
            int[] r4 = androidx.navigation.NavDestination.buildDeepLinkIds$default(r0, r9, r10, r9)
            android.os.Bundle r2 = r2.getMatchingArgs()
            android.os.Bundle r0 = r0.addInDefaultArgs(r2)
            if (r0 == 0) goto L_0x0078
            r5.putAll(r0)
        L_0x0078:
            r0 = r4
            r4 = r9
        L_0x007a:
            if (r0 == 0) goto L_0x01f2
            int r2 = r0.length
            if (r2 != 0) goto L_0x0081
            goto L_0x01f2
        L_0x0081:
            java.lang.String r2 = r7.findInvalidDestinationDisplayNameInDeepLink(r0)
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Could not find destination "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r2 = " in the navigation graph, ignoring the deep link from "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r3, r0)
            return r8
        L_0x00a4:
            java.lang.String r2 = "android-support-nav:controller:deepLinkIntent"
            r5.putParcelable(r2, r1)
            int r2 = r0.length
            android.os.Bundle[] r11 = new android.os.Bundle[r2]
            r3 = 0
        L_0x00ad:
            if (r3 >= r2) goto L_0x00c9
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r6.putAll(r5)
            if (r4 == 0) goto L_0x00c4
            java.lang.Object r12 = r4.get(r3)
            android.os.Bundle r12 = (android.os.Bundle) r12
            if (r12 == 0) goto L_0x00c4
            r6.putAll(r12)
        L_0x00c4:
            r11[r3] = r6
            int r3 = r3 + 1
            goto L_0x00ad
        L_0x00c9:
            int r2 = r20.getFlags()
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r2
            if (r3 == 0) goto L_0x00f8
            r4 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r4
            if (r2 != 0) goto L_0x00f8
            r1.addFlags(r4)
            android.content.Context r0 = r7.context
            androidx.core.app.TaskStackBuilder r0 = androidx.core.app.TaskStackBuilder.create(r0)
            androidx.core.app.TaskStackBuilder r0 = r0.addNextIntentWithParentStack(r1)
            java.lang.String r1 = "create(context).addNextI…ntWithParentStack(intent)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            r0.startActivities()
            android.app.Activity r0 = r7.activity
            if (r0 == 0) goto L_0x00f7
            r0.finish()
            r0.overridePendingTransition(r8, r8)
        L_0x00f7:
            return r10
        L_0x00f8:
            java.lang.String r12 = "Deep Linking failed: destination "
            if (r3 == 0) goto L_0x0160
            kotlin.collections.xxIXOIIO<androidx.navigation.NavBackStackEntry> r1 = r7.backQueue
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0116
            androidx.navigation.NavGraph r1 = r7._graph
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            int r2 = r1.getId()
            r5 = 4
            r6 = 0
            r3 = 1
            r4 = 0
            r1 = r19
            popBackStackInternal$default((androidx.navigation.NavController) r1, (int) r2, (boolean) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
        L_0x0116:
            int r1 = r0.length
            if (r8 >= r1) goto L_0x015d
            r1 = r0[r8]
            int r2 = r8 + 1
            r3 = r11[r8]
            r4 = 2
            androidx.navigation.NavDestination r4 = findDestination$default(r7, r1, r9, r4, r9)
            if (r4 == 0) goto L_0x0134
            androidx.navigation.NavController$handleDeepLink$2 r1 = new androidx.navigation.NavController$handleDeepLink$2
            r1.<init>(r4, r7)
            androidx.navigation.NavOptions r1 = androidx.navigation.NavOptionsBuilderKt.navOptions(r1)
            r7.navigate((androidx.navigation.NavDestination) r4, (android.os.Bundle) r3, (androidx.navigation.NavOptions) r1, (androidx.navigation.Navigator.Extras) r9)
            r8 = r2
            goto L_0x0116
        L_0x0134:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r7.context
            java.lang.String r0 = r0.getDisplayName(r2, r1)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = " cannot be found from the current destination "
            r2.append(r0)
            androidx.navigation.NavDestination r0 = r19.getCurrentDestination()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x015d:
            r7.deepLinkHandled = r10
            return r10
        L_0x0160:
            androidx.navigation.NavGraph r1 = r7._graph
            int r2 = r0.length
            r3 = 0
        L_0x0164:
            if (r3 >= r2) goto L_0x01ef
            r4 = r0[r3]
            r5 = r11[r3]
            if (r3 != 0) goto L_0x016f
            androidx.navigation.NavGraph r6 = r7._graph
            goto L_0x0176
        L_0x016f:
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            androidx.navigation.NavDestination r6 = r1.findNode((int) r4)
        L_0x0176:
            if (r6 == 0) goto L_0x01ca
            int r4 = r0.length
            int r4 = r4 - r10
            if (r3 == r4) goto L_0x019f
            boolean r4 = r6 instanceof androidx.navigation.NavGraph
            if (r4 == 0) goto L_0x01c7
            androidx.navigation.NavGraph r6 = (androidx.navigation.NavGraph) r6
        L_0x0182:
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r6)
            int r1 = r6.getStartDestinationId()
            androidx.navigation.NavDestination r1 = r6.findNode((int) r1)
            boolean r1 = r1 instanceof androidx.navigation.NavGraph
            if (r1 == 0) goto L_0x019d
            int r1 = r6.getStartDestinationId()
            androidx.navigation.NavDestination r1 = r6.findNode((int) r1)
            r6 = r1
            androidx.navigation.NavGraph r6 = (androidx.navigation.NavGraph) r6
            goto L_0x0182
        L_0x019d:
            r1 = r6
            goto L_0x01c7
        L_0x019f:
            androidx.navigation.NavOptions$Builder r13 = new androidx.navigation.NavOptions$Builder
            r13.<init>()
            androidx.navigation.NavGraph r4 = r7._graph
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r4)
            int r14 = r4.getId()
            r17 = 4
            r18 = 0
            r15 = 1
            r16 = 0
            androidx.navigation.NavOptions$Builder r4 = androidx.navigation.NavOptions.Builder.setPopUpTo$default((androidx.navigation.NavOptions.Builder) r13, (int) r14, (boolean) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            androidx.navigation.NavOptions$Builder r4 = r4.setEnterAnim(r8)
            androidx.navigation.NavOptions$Builder r4 = r4.setExitAnim(r8)
            androidx.navigation.NavOptions r4 = r4.build()
            r7.navigate((androidx.navigation.NavDestination) r6, (android.os.Bundle) r5, (androidx.navigation.NavOptions) r4, (androidx.navigation.Navigator.Extras) r9)
        L_0x01c7:
            int r3 = r3 + 1
            goto L_0x0164
        L_0x01ca:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r7.context
            java.lang.String r0 = r0.getDisplayName(r2, r4)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r0)
            java.lang.String r0 = " cannot be found in graph "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01ef:
            r7.deepLinkHandled = r10
            return r10
        L_0x01f2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.handleDeepLink(android.content.Intent):boolean");
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> void navigate(@OOXIXo T t) {
        IIX0o.x0xO0oo(t, "route");
        navigate$default(this, (Object) t, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    @MainThread
    public boolean navigateUp() {
        Bundle bundle;
        Intent intent;
        if (getDestinationCountOnBackStack() != 1) {
            return popBackStack();
        }
        Activity activity2 = this.activity;
        int[] iArr = null;
        if (activity2 == null || (intent = activity2.getIntent()) == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            iArr = bundle.getIntArray(KEY_DEEP_LINK_IDS);
        }
        if (iArr != null) {
            return tryRelaunchUpToExplicitStack();
        }
        return tryRelaunchUpToGeneratedStack();
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> boolean popBackStack(@OOXIXo T t, boolean z) {
        IIX0o.x0xO0oo(t, "route");
        return popBackStack$default(this, (Object) t, z, false, 4, (Object) null);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(@OOXIXo NavBackStackEntry navBackStackEntry, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
        IIX0o.x0xO0oo(oix0oi, "onComplete");
        int indexOf = this.backQueue.indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, navBackStackEntry, false, (kotlin.collections.xxIXOIIO) null, 6, (Object) null);
        oix0oi.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    @OOXIXo
    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        for (NavControllerNavigatorState transitionsInProgress : this.navigatorState.values()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object next : transitionsInProgress.getTransitionsInProgress().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(next);
                }
            }
            OxI.XIo0oOXIx(arrayList, arrayList2);
        }
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : xxixoiio) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(next2);
            }
        }
        OxI.XIo0oOXIx(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).getDestination() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(@OOXIXo OnDestinationChangedListener onDestinationChangedListener) {
        IIX0o.x0xO0oo(onDestinationChangedListener, "listener");
        this.onDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@oOoXoXO Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.context.getClassLoader());
            this.navigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
            this.backStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
            this.backStackStates.clear();
            int[] intArray = bundle.getIntArray(KEY_BACK_STACK_DEST_IDS);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_BACK_STACK_IDS);
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    this.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i2));
                    i++;
                    i2++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str);
                    if (parcelableArray != null) {
                        Map<String, kotlin.collections.xxIXOIIO<NavBackStackEntryState>> map = this.backStackStates;
                        IIX0o.oO(str, "id");
                        kotlin.collections.xxIXOIIO xxixoiio = new kotlin.collections.xxIXOIIO(parcelableArray.length);
                        Iterator oIX0oI2 = II0XooXoX.oIX0oI(parcelableArray);
                        while (oIX0oI2.hasNext()) {
                            Parcelable parcelable = (Parcelable) oIX0oI2.next();
                            IIX0o.x0XOIxOo(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                            xxixoiio.add((NavBackStackEntryState) parcelable);
                        }
                        map.put(str, xxixoiio);
                    }
                }
            }
            this.deepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
        }
    }

    @CallSuper
    @oOoXoXO
    public Bundle saveState() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._navigatorProvider.getNavigators().entrySet()) {
            String str = (String) next.getKey();
            Bundle onSaveState = ((Navigator) next.getValue()).onSaveState();
            if (onSaveState != null) {
                arrayList.add(str);
                bundle2.putBundle(str, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.size()];
            Iterator<NavBackStackEntry> it = this.backQueue.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState(it.next());
                i++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (Map.Entry next2 : this.backStackMap.entrySet()) {
                iArr[i2] = ((Number) next2.getKey()).intValue();
                arrayList2.add((String) next2.getValue());
                i2++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry next3 : this.backStackStates.entrySet()) {
                String str2 = (String) next3.getKey();
                kotlin.collections.xxIXOIIO xxixoiio = (kotlin.collections.xxIXOIIO) next3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[xxixoiio.size()];
                int i3 = 0;
                for (Object next4 : xxixoiio) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    parcelableArr2[i3] = (NavBackStackEntryState) next4;
                    i3 = i4;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    @MainThread
    public void setGraph(@OOXIXo NavGraph navGraph) {
        IIX0o.x0xO0oo(navGraph, "graph");
        setGraph(navGraph, (Bundle) null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(@OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLifecycleOwner(@OOXIXo LifecycleOwner lifecycleOwner2) {
        Lifecycle lifecycle;
        IIX0o.x0xO0oo(lifecycleOwner2, "owner");
        if (!IIX0o.Oxx0IOOO(lifecycleOwner2, this.lifecycleOwner)) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            if (!(lifecycleOwner3 == null || (lifecycle = lifecycleOwner3.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.lifecycleObserver);
            }
            this.lifecycleOwner = lifecycleOwner2;
            lifecycleOwner2.getLifecycle().addObserver(this.lifecycleObserver);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@OOXIXo NavigatorProvider navigatorProvider) {
        IIX0o.x0xO0oo(navigatorProvider, "navigatorProvider");
        if (this.backQueue.isEmpty()) {
            this._navigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnBackPressedDispatcher(@OOXIXo OnBackPressedDispatcher onBackPressedDispatcher2) {
        IIX0o.x0xO0oo(onBackPressedDispatcher2, "dispatcher");
        if (!IIX0o.Oxx0IOOO(onBackPressedDispatcher2, this.onBackPressedDispatcher)) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (lifecycleOwner2 != null) {
                this.onBackPressedCallback.remove();
                this.onBackPressedDispatcher = onBackPressedDispatcher2;
                onBackPressedDispatcher2.addCallback(lifecycleOwner2, this.onBackPressedCallback);
                Lifecycle lifecycle = lifecycleOwner2.getLifecycle();
                lifecycle.removeObserver(this.lifecycleObserver);
                lifecycle.addObserver(this.lifecycleObserver);
                return;
            }
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewModelStore(@OOXIXo ViewModelStore viewModelStore) {
        IIX0o.x0xO0oo(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.Companion;
        if (!IIX0o.Oxx0IOOO(navControllerViewModel, companion.getInstance(viewModelStore))) {
            if (this.backQueue.isEmpty()) {
                this.viewModel = companion.getInstance(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
    }

    @oOoXoXO
    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        NavBackStackEntry remove = this.childToParentEntries.remove(navBackStackEntry);
        Integer num = null;
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(remove);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        Boolean bool;
        AtomicInteger atomicInteger;
        kotlinx.coroutines.flow.IIXOooo<Set<NavBackStackEntry>> transitionsInProgress;
        Set value;
        List<T> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.backQueue);
        if (!o0Xo0XII.isEmpty()) {
            NavDestination destination = ((NavBackStackEntry) CollectionsKt___CollectionsKt.O0O0Io00X(o0Xo0XII)).getDestination();
            ArrayList arrayList = new ArrayList();
            if (destination instanceof FloatingWindow) {
                for (NavBackStackEntry destination2 : CollectionsKt___CollectionsKt.OOoOoO0o(o0Xo0XII)) {
                    NavDestination destination3 = destination2.getDestination();
                    arrayList.add(destination3);
                    if (!(destination3 instanceof FloatingWindow) && !(destination3 instanceof NavGraph)) {
                        break;
                    }
                }
            }
            HashMap hashMap = new HashMap();
            for (NavBackStackEntry navBackStackEntry : CollectionsKt___CollectionsKt.OOoOoO0o(o0Xo0XII)) {
                Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
                NavDestination destination4 = navBackStackEntry.getDestination();
                if (destination != null && destination4.getId() == destination.getId()) {
                    Lifecycle.State state = Lifecycle.State.RESUMED;
                    if (maxLifecycle != state) {
                        NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                        if (navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null) {
                            bool = null;
                        } else {
                            bool = Boolean.valueOf(value.contains(navBackStackEntry));
                        }
                        if (IIX0o.Oxx0IOOO(bool, Boolean.TRUE) || ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                            hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                        } else {
                            hashMap.put(navBackStackEntry, state);
                        }
                    }
                    NavDestination navDestination = (NavDestination) CollectionsKt___CollectionsKt.XxXX(arrayList);
                    if (navDestination != null && navDestination.getId() == destination4.getId()) {
                        OxI.Ox0O(arrayList);
                    }
                    destination = destination.getParent();
                } else if (arrayList.isEmpty() || destination4.getId() != ((NavDestination) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).getId()) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
                } else {
                    NavDestination navDestination2 = (NavDestination) OxI.Ox0O(arrayList);
                    if (maxLifecycle == Lifecycle.State.RESUMED) {
                        navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                    } else {
                        Lifecycle.State state2 = Lifecycle.State.STARTED;
                        if (maxLifecycle != state2) {
                            hashMap.put(navBackStackEntry, state2);
                        }
                    }
                    NavGraph parent = navDestination2.getParent();
                    if (parent != null && !arrayList.contains(parent)) {
                        arrayList.add(parent);
                    }
                }
            }
            for (T t : o0Xo0XII) {
                Lifecycle.State state3 = (Lifecycle.State) hashMap.get(t);
                if (state3 != null) {
                    t.setMaxLifecycle(state3);
                } else {
                    t.updateState();
                }
            }
        }
    }

    public static /* synthetic */ void navigate$default(NavController navController, Object obj, NavOptions navOptions, Navigator.Extras extras, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                navOptions = null;
            }
            if ((i & 4) != 0) {
                extras = null;
            }
            navController.navigate(obj, navOptions, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
            oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
            int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null));
            if (findDestinationComprehensive$default(navController, navController.getGraph(), generateHashCode, true, (NavDestination) null, 4, (Object) null) != null) {
                return navController.popBackStack(generateHashCode, z, z2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Destination with route ");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(IO.oxoX(Object.class).xoXoI());
            sb.append(" cannot be found in navigation graph ");
            sb.append(navController.getGraph());
            throw new IllegalArgumentException(sb.toString().toString());
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> void navigate(@OOXIXo T t, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(t, "route");
        navigate$default(this, (Object) t, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final boolean popBackStack(@OOXIXo String str, boolean z) {
        IIX0o.x0xO0oo(str, "route");
        return popBackStack$default(this, str, z, false, 4, (Object) null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int i) {
        setGraph(getNavInflater().inflate(i), (Bundle) null);
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStackInternal(i, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    @MainThread
    public final boolean clearBackStack(@IdRes int i) {
        return clearBackStackInternal(i) && dispatchOnDestinationChanged();
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "route");
        navigate$default(this, str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    @MainThread
    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        IIX0o.ooOOo0oXI(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int i, @oOoXoXO Bundle bundle) {
        setGraph(getNavInflater().inflate(i), bundle);
    }

    @MainThread
    private final boolean popBackStackInternal(@IdRes int i, boolean z, boolean z2) {
        NavDestination navDestination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = CollectionsKt___CollectionsKt.OOoOoO0o(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination.getNavigatorName());
            if (z || navDestination.getId() != i) {
                arrayList.add(navigator);
            }
            if (navDestination.getId() == i) {
                break;
            }
        }
        if (navDestination != null) {
            return executePopOperations(arrayList, navDestination, z, z2);
        }
        String displayName = NavDestination.Companion.getDisplayName(this.context, i);
        Log.i(TAG, "Ignoring popBackStack to destination " + displayName + " as it was not found on the current back stack");
        return false;
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController navController, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStackInternal(obj, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String str, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(str, "route");
        navigate$default(this, str, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@OOXIXo NavGraph navGraph, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(navGraph, "graph");
        if (!this.backQueue.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        } else if (!IIX0o.Oxx0IOOO(this._graph, navGraph)) {
            NavGraph navGraph2 = this._graph;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    IIX0o.oO(num, "id");
                    clearBackStackInternal(num.intValue());
                }
                popBackStackInternal$default(this, navGraph2.getId(), true, false, 4, (Object) null);
            }
            this._graph = navGraph;
            onGraphCreated(bundle);
        } else {
            int size = navGraph.getNodes().size();
            for (int i = 0; i < size; i++) {
                NavGraph navGraph3 = this._graph;
                IIX0o.ooOOo0oXI(navGraph3);
                int keyAt = navGraph3.getNodes().keyAt(i);
                NavGraph navGraph4 = this._graph;
                IIX0o.ooOOo0oXI(navGraph4);
                navGraph4.getNodes().replace(keyAt, navGraph.getNodes().valueAt(i));
            }
            for (NavBackStackEntry navBackStackEntry : this.backQueue) {
                NavDestination navDestination = this._graph;
                IIX0o.ooOOo0oXI(navDestination);
                for (T t : O0xOxO.IXO(SequencesKt___SequencesKt.oox000IX(NavDestination.Companion.getHierarchy(navBackStackEntry.getDestination())))) {
                    if ((!IIX0o.Oxx0IOOO(t, this._graph) || !IIX0o.Oxx0IOOO(navDestination, navGraph)) && (navDestination instanceof NavGraph)) {
                        navDestination = ((NavGraph) navDestination).findNode(t.getId());
                        IIX0o.ooOOo0oXI(navDestination);
                    }
                }
                navBackStackEntry.setDestination(navDestination);
            }
        }
    }

    @MainThread
    public final /* synthetic */ <T> boolean clearBackStack() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return clearBackStack(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null)));
    }

    @MainThread
    public void navigate(@IdRes int i) {
        navigate(i, (Bundle) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int i, boolean z) {
        return popBackStack(i, z, false);
    }

    @MainThread
    public final <T> boolean clearBackStack(@OOXIXo T t) {
        IIX0o.x0xO0oo(t, "route");
        return clearBackStackInternal(generateRouteFilled(t)) && dispatchOnDestinationChanged();
    }

    @MainThread
    public void navigate(@IdRes int i, @oOoXoXO Bundle bundle) {
        navigate(i, bundle, (NavOptions) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int i, boolean z, boolean z2) {
        return popBackStackInternal(i, z, z2) && dispatchOnDestinationChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0057, code lost:
        r0 = (androidx.navigation.NavBackStackEntryState) r1.Oxx0IOOO();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean restoreStateInternal(java.lang.String r6) {
        /*
            r5 = this;
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            java.lang.String r0 = r0.createRoute(r6)
            int r0 = r0.hashCode()
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r5.backStackMap
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            r2 = 0
            if (r1 == 0) goto L_0x001c
            boolean r6 = r5.restoreStateInternal(r0, r2, r2, r2)
            goto L_0x0075
        L_0x001c:
            androidx.navigation.NavDestination r0 = r5.findDestination(r6)
            if (r0 == 0) goto L_0x0076
            int r1 = r0.getId()
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r5.backStackMap
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r5.backStackMap
            java.util.Collection r3 = r3.values()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            androidx.navigation.NavController$restoreStateInternal$3 r4 = new androidx.navigation.NavController$restoreStateInternal$3
            r4.<init>(r1)
            kotlin.collections.OxI.XIXIX(r3, r4)
            java.util.Map<java.lang.String, kotlin.collections.xxIXOIIO<androidx.navigation.NavBackStackEntryState>> r3 = r5.backStackStates
            java.util.Map r3 = kotlin.jvm.internal.XoX.OOXIXo(r3)
            java.lang.Object r1 = r3.remove(r1)
            kotlin.collections.xxIXOIIO r1 = (kotlin.collections.xxIXOIIO) r1
            androidx.navigation.NavDestination$DeepLinkMatch r6 = r0.matchRoute(r6)
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r6)
            if (r1 == 0) goto L_0x0064
            java.lang.Object r0 = r1.Oxx0IOOO()
            androidx.navigation.NavBackStackEntryState r0 = (androidx.navigation.NavBackStackEntryState) r0
            if (r0 == 0) goto L_0x0064
            android.os.Bundle r0 = r0.getArgs()
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            boolean r6 = r6.hasMatchingArgs(r0)
            if (r6 != 0) goto L_0x006d
            r6 = 0
            return r6
        L_0x006d:
            java.util.List r6 = r5.instantiateBackStack(r1)
            boolean r6 = r5.executeRestoreState(r6, r2, r2, r2)
        L_0x0075:
            return r6
        L_0x0076:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Restore State failed: route "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " cannot be found from the current destination "
            r0.append(r6)
            androidx.navigation.NavDestination r6 = r5.getCurrentDestination()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.restoreStateInternal(java.lang.String):boolean");
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        IIX0o.ooOOo0oXI(navGraph);
        if (!IIX0o.Oxx0IOOO(navGraph.getRoute(), str)) {
            NavGraph navGraph2 = this._graph;
            IIX0o.ooOOo0oXI(navGraph2);
            if (navGraph2.matchRoute(str) == null) {
                return getTopGraph(this.backQueue).findNode(str);
            }
        }
        return this._graph;
    }

    @MainThread
    public void navigate(@IdRes int i, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Navigator.Extras) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void navigate(@androidx.annotation.IdRes int r12, @OXOo.oOoXoXO android.os.Bundle r13, @OXOo.oOoXoXO androidx.navigation.NavOptions r14, @OXOo.oOoXoXO androidx.navigation.Navigator.Extras r15) {
        /*
            r11 = this;
            kotlin.collections.xxIXOIIO<androidx.navigation.NavBackStackEntry> r0 = r11.backQueue
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000b
            androidx.navigation.NavGraph r0 = r11._graph
            goto L_0x0017
        L_0x000b:
            kotlin.collections.xxIXOIIO<androidx.navigation.NavBackStackEntry> r0 = r11.backQueue
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            androidx.navigation.NavDestination r0 = r0.getDestination()
        L_0x0017:
            if (r0 == 0) goto L_0x0115
            androidx.navigation.NavAction r1 = r0.getAction(r12)
            r2 = 0
            if (r1 == 0) goto L_0x003b
            if (r14 != 0) goto L_0x0026
            androidx.navigation.NavOptions r14 = r1.getNavOptions()
        L_0x0026:
            int r3 = r1.getDestinationId()
            android.os.Bundle r4 = r1.getDefaultArguments()
            if (r4 == 0) goto L_0x0039
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putAll(r4)
            goto L_0x003d
        L_0x0039:
            r5 = r2
            goto L_0x003d
        L_0x003b:
            r3 = r12
            goto L_0x0039
        L_0x003d:
            if (r13 == 0) goto L_0x0049
            if (r5 != 0) goto L_0x0046
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
        L_0x0046:
            r5.putAll(r13)
        L_0x0049:
            if (r3 != 0) goto L_0x00a8
            if (r14 == 0) goto L_0x00a8
            int r13 = r14.getPopUpToId()
            r4 = -1
            if (r13 != r4) goto L_0x0060
            java.lang.String r13 = r14.getPopUpToRoute()
            if (r13 != 0) goto L_0x0060
            kotlin.reflect.oxoX r13 = r14.getPopUpToRouteClass()
            if (r13 == 0) goto L_0x00a8
        L_0x0060:
            java.lang.String r12 = r14.getPopUpToRoute()
            if (r12 == 0) goto L_0x0079
            java.lang.String r6 = r14.getPopUpToRoute()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r6)
            boolean r7 = r14.isPopUpToInclusive()
            r9 = 4
            r10 = 0
            r8 = 0
            r5 = r11
            popBackStack$default((androidx.navigation.NavController) r5, (java.lang.String) r6, (boolean) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)
            goto L_0x00a7
        L_0x0079:
            kotlin.reflect.oxoX r12 = r14.getPopUpToRouteClass()
            if (r12 == 0) goto L_0x0096
            kotlin.reflect.oxoX r12 = r14.getPopUpToRouteClass()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r12)
            kotlinx.serialization.Oxx0IOOO r12 = kotlinx.serialization.OxxIIOOXO.Oxx0IOOO(r12)
            int r12 = androidx.navigation.serialization.RouteSerializerKt.generateHashCode(r12)
            boolean r13 = r14.isPopUpToInclusive()
            r11.popBackStack((int) r12, (boolean) r13)
            goto L_0x00a7
        L_0x0096:
            int r12 = r14.getPopUpToId()
            if (r12 == r4) goto L_0x00a7
            int r12 = r14.getPopUpToId()
            boolean r13 = r14.isPopUpToInclusive()
            r11.popBackStack((int) r12, (boolean) r13)
        L_0x00a7:
            return
        L_0x00a8:
            if (r3 == 0) goto L_0x010d
            r13 = 2
            androidx.navigation.NavDestination r13 = findDestination$default(r11, r3, r2, r13, r2)
            if (r13 != 0) goto L_0x0109
            androidx.navigation.NavDestination$Companion r13 = androidx.navigation.NavDestination.Companion
            android.content.Context r14 = r11.context
            java.lang.String r14 = r13.getDisplayName(r14, r3)
            java.lang.String r15 = " cannot be found from the current destination "
            if (r1 != 0) goto L_0x00da
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "Navigation action/destination "
            r13.append(r1)
            r13.append(r14)
            r13.append(r15)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x00da:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Navigation destination "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r14 = " referenced from action "
            r1.append(r14)
            android.content.Context r14 = r11.context
            java.lang.String r12 = r13.getDisplayName(r14, r12)
            r1.append(r12)
            r1.append(r15)
            r1.append(r0)
            java.lang.String r12 = r1.toString()
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        L_0x0109:
            r11.navigate((androidx.navigation.NavDestination) r13, (android.os.Bundle) r5, (androidx.navigation.NavOptions) r14, (androidx.navigation.Navigator.Extras) r15)
            return
        L_0x010d:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo"
            r12.<init>(r13)
            throw r12
        L_0x0115:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "No current destination found. Ensure a navigation graph has been set for NavController "
            r13.append(r14)
            r13.append(r11)
            r14 = 46
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(int, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    @XO0OX.xoIox
    @MainThread
    public final boolean popBackStack(@OOXIXo String str, boolean z, boolean z2) {
        IIX0o.x0xO0oo(str, "route");
        return popBackStackInternal(str, z, z2) && dispatchOnDestinationChanged();
    }

    @MainThread
    private final boolean clearBackStackInternal(String str) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(str);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(str, true, false)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStack(obj, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    @XO0OX.xoIox
    @MainThread
    public final /* synthetic */ <T> boolean popBackStack(boolean z, boolean z2) {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null));
        if (findDestinationComprehensive$default(this, getGraph(), generateHashCode, true, (NavDestination) null, 4, (Object) null) != null) {
            return popBackStack(generateHashCode, z, z2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Destination with route ");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(IO.oxoX(Object.class).xoXoI());
        sb.append(" cannot be found in navigation graph ");
        sb.append(getGraph());
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @OOXIXo
    public final NavBackStackEntry getBackStackEntry(@OOXIXo String str) {
        NavBackStackEntry navBackStackEntry;
        IIX0o.x0xO0oo(str, "route");
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.getDestination().hasRoute(str, navBackStackEntry2.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    private final <T> boolean popBackStackInternal(T t, boolean z, boolean z2) {
        return popBackStackInternal(generateRouteFilled(t), z, z2);
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> boolean popBackStack(@OOXIXo T t, boolean z, boolean z2) {
        IIX0o.x0xO0oo(t, "route");
        return popBackStackInternal(t, z, z2) && dispatchOnDestinationChanged();
    }

    private final boolean popBackStackInternal(String str, boolean z, boolean z2) {
        NavDestination navDestination;
        NavBackStackEntry navBackStackEntry;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            navDestination = null;
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            boolean hasRoute = navBackStackEntry2.getDestination().hasRoute(str, navBackStackEntry2.getArguments());
            if (z || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
                continue;
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            navDestination = navBackStackEntry3.getDestination();
        }
        if (navDestination != null) {
            return executePopOperations(arrayList, navDestination, z, z2);
        }
        Log.i(TAG, "Ignoring popBackStack to route " + str + " as it was not found on the current back stack");
        return false;
    }

    @XO0OX.xoIox
    @MainThread
    public final /* synthetic */ <T> boolean popBackStack(boolean z) {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null));
        if (findDestinationComprehensive$default(this, getGraph(), generateHashCode, true, (NavDestination) null, 4, (Object) null) != null) {
            return popBackStack(generateHashCode, z, false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Destination with route ");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(IO.oxoX(Object.class).xoXoI());
        sb.append(" cannot be found in navigation graph ");
        sb.append(getGraph());
        throw new IllegalArgumentException(sb.toString().toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> androidx.navigation.NavBackStackEntry getBackStackEntry() {
        /*
            r10 = this;
            r0 = 6
            java.lang.String r1 = "T"
            kotlin.jvm.internal.IIX0o.OxI(r0, r1)
            java.lang.String r0 = "kotlinx.serialization.serializer.simple"
            kotlin.jvm.internal.oOXoIIIo.x0XOIxOo(r0)
            r0 = 0
            kotlinx.serialization.Oxx0IOOO r2 = kotlinx.serialization.OxxIIOOXO.xxIXOIIO(r0)
            int r2 = androidx.navigation.serialization.RouteSerializerKt.generateHashCode(r2)
            androidx.navigation.NavGraph r4 = r10.getGraph()
            r8 = 4
            r9 = 0
            r6 = 1
            r7 = 0
            r3 = r10
            r5 = r2
            androidx.navigation.NavDestination r3 = findDestinationComprehensive$default(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r5 = 4
            if (r3 == 0) goto L_0x0088
            kotlinx.coroutines.flow.IIXOooo r3 = r10.getCurrentBackStack()
            java.lang.Object r3 = r3.getValue()
            java.util.List r3 = (java.util.List) r3
            int r6 = r3.size()
            java.util.ListIterator r3 = r3.listIterator(r6)
        L_0x0039:
            boolean r6 = r3.hasPrevious()
            if (r6 == 0) goto L_0x0051
            java.lang.Object r6 = r3.previous()
            r7 = r6
            androidx.navigation.NavBackStackEntry r7 = (androidx.navigation.NavBackStackEntry) r7
            androidx.navigation.NavDestination r7 = r7.getDestination()
            int r7 = r7.getId()
            if (r7 != r2) goto L_0x0039
            r0 = r6
        L_0x0051:
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            if (r0 == 0) goto L_0x0056
            return r0
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "No destination with route "
            r0.append(r2)
            kotlin.jvm.internal.IIX0o.OxI(r5, r1)
            kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r4)
            java.lang.String r1 = r1.xoXoI()
            r0.append(r1)
            java.lang.String r1 = " is on the NavController's back stack. The current destination is "
            r0.append(r1)
            androidx.navigation.NavDestination r1 = r10.getCurrentDestination()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0088:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Destination with route "
            r0.append(r2)
            kotlin.jvm.internal.IIX0o.OxI(r5, r1)
            kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r4)
            java.lang.String r1 = r1.xoXoI()
            r0.append(r1)
            java.lang.String r1 = " cannot be found in navigation graph "
            r0.append(r1)
            androidx.navigation.NavGraph r1 = r10.getGraph()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.getBackStackEntry():androidx.navigation.NavBackStackEntry");
    }

    @OOXIXo
    public final <T> NavBackStackEntry getBackStackEntry(@OOXIXo T t) {
        IIX0o.x0xO0oo(t, "route");
        return getBackStackEntry(generateRouteFilled(t));
    }

    @MainThread
    public void navigate(@OOXIXo Uri uri) {
        IIX0o.x0xO0oo(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    @MainThread
    public void navigate(@OOXIXo Uri uri, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@OOXIXo Uri uri, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, extras);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest navDeepLinkRequest) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest navDeepLinkRequest, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest navDeepLinkRequest, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(navDeepLinkRequest, "request");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(navDeepLinkRequest, true, true, topGraph);
            if (matchDeepLinkComprehensive != null) {
                Bundle addInDefaultArgs = matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
                if (addInDefaultArgs == null) {
                    addInDefaultArgs = new Bundle();
                }
                NavDestination destination = matchDeepLinkComprehensive.getDestination();
                Intent intent = new Intent();
                intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
                intent.setAction(navDeepLinkRequest.getAction());
                addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
                navigate(destination, addInDefaultArgs, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + navDeepLinkRequest + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012a A[LOOP:1: B:38:0x0124->B:40:0x012a, LOOP_END] */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigate(androidx.navigation.NavDestination r22, android.os.Bundle r23, androidx.navigation.NavOptions r24, androidx.navigation.Navigator.Extras r25) {
        /*
            r21 = this;
            r6 = r21
            r3 = r24
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r2)
            goto L_0x0010
        L_0x0021:
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r8 = 0
            if (r3 == 0) goto L_0x0098
            java.lang.String r0 = r24.getPopUpToRoute()
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = r24.getPopUpToRoute()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            boolean r1 = r24.isPopUpToInclusive()
            boolean r4 = r24.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal((java.lang.String) r0, (boolean) r1, (boolean) r4)
        L_0x0042:
            r9 = r0
            goto L_0x0099
        L_0x0044:
            kotlin.reflect.oxoX r0 = r24.getPopUpToRouteClass()
            if (r0 == 0) goto L_0x0066
            kotlin.reflect.oxoX r0 = r24.getPopUpToRouteClass()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            kotlinx.serialization.Oxx0IOOO r0 = kotlinx.serialization.OxxIIOOXO.Oxx0IOOO(r0)
            int r0 = androidx.navigation.serialization.RouteSerializerKt.generateHashCode(r0)
            boolean r1 = r24.isPopUpToInclusive()
            boolean r4 = r24.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal((int) r0, (boolean) r1, (boolean) r4)
            goto L_0x0042
        L_0x0066:
            java.lang.Object r0 = r24.getPopUpToRouteObject()
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r24.getPopUpToRouteObject()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            boolean r1 = r24.isPopUpToInclusive()
            boolean r4 = r24.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal(r0, (boolean) r1, (boolean) r4)
            goto L_0x0042
        L_0x0080:
            int r0 = r24.getPopUpToId()
            r1 = -1
            if (r0 == r1) goto L_0x0098
            int r0 = r24.getPopUpToId()
            boolean r1 = r24.isPopUpToInclusive()
            boolean r4 = r24.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal((int) r0, (boolean) r1, (boolean) r4)
            goto L_0x0042
        L_0x0098:
            r9 = 0
        L_0x0099:
            android.os.Bundle r0 = r22.addInDefaultArgs(r23)
            if (r3 == 0) goto L_0x00c4
            boolean r1 = r24.shouldRestoreState()
            if (r1 != r2) goto L_0x00c4
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r6.backStackMap
            int r4 = r22.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x00c4
            int r1 = r22.getId()
            r4 = r25
            boolean r0 = r6.restoreStateInternal(r1, r0, r3, r4)
            r7.element = r0
            r20 = 0
            goto L_0x0115
        L_0x00c4:
            r4 = r25
            if (r3 == 0) goto L_0x00d7
            boolean r1 = r24.shouldLaunchSingleTop()
            if (r1 != r2) goto L_0x00d7
            boolean r1 = r21.launchSingleTopInternal(r22, r23)
            if (r1 == 0) goto L_0x00d7
            r20 = 1
            goto L_0x00d9
        L_0x00d7:
            r20 = 0
        L_0x00d9:
            if (r20 != 0) goto L_0x0115
            androidx.navigation.NavBackStackEntry$Companion r10 = androidx.navigation.NavBackStackEntry.Companion
            android.content.Context r11 = r6.context
            androidx.lifecycle.Lifecycle$State r14 = r21.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r15 = r6.viewModel
            r18 = 96
            r19 = 0
            r16 = 0
            r17 = 0
            r12 = r22
            r13 = r0
            androidx.navigation.NavBackStackEntry r1 = androidx.navigation.NavBackStackEntry.Companion.create$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            androidx.navigation.NavigatorProvider r2 = r6._navigatorProvider
            java.lang.String r5 = r22.getNavigatorName()
            androidx.navigation.Navigator r2 = r2.getNavigator((java.lang.String) r5)
            java.util.List r5 = kotlin.collections.oI0IIXIo.OOXIXo(r1)
            androidx.navigation.NavController$navigate$5 r10 = new androidx.navigation.NavController$navigate$5
            r1 = r22
            r10.<init>(r7, r6, r1, r0)
            r0 = r21
            r1 = r2
            r2 = r5
            r3 = r24
            r4 = r25
            r5 = r10
            r0.navigateInternal(r1, r2, r3, r4, r5)
        L_0x0115:
            r21.updateOnBackPressedCallbackEnabled()
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0124:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0134
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r8)
            goto L_0x0124
        L_0x0134:
            if (r9 != 0) goto L_0x0141
            boolean r0 = r7.element
            if (r0 != 0) goto L_0x0141
            if (r20 == 0) goto L_0x013d
            goto L_0x0141
        L_0x013d:
            r21.updateBackStackLifecycle$navigation_runtime_release()
            goto L_0x0144
        L_0x0141:
            r21.dispatchOnDestinationChanged()
        L_0x0144:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections navDirections) {
        IIX0o.x0xO0oo(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections navDirections, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections navDirections, @OOXIXo Navigator.Extras extras) {
        IIX0o.x0xO0oo(navDirections, "directions");
        IIX0o.x0xO0oo(extras, "navigatorExtras");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    @MainThread
    public final void navigate(@OOXIXo String str, @OOXIXo Oox.oOoXoXO<? super NavOptionsBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(str, "route");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        navigate$default(this, str, NavOptionsBuilderKt.navOptions(oooxoxo), (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String str, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(str, "route");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchRouteComprehensive = topGraph.matchRouteComprehensive(str, true, true, topGraph);
            if (matchRouteComprehensive != null) {
                NavDestination destination = matchRouteComprehensive.getDestination();
                Bundle addInDefaultArgs = destination.addInDefaultArgs(matchRouteComprehensive.getMatchingArgs());
                if (addInDefaultArgs == null) {
                    addInDefaultArgs = new Bundle();
                }
                NavDestination destination2 = matchRouteComprehensive.getDestination();
                Intent intent = new Intent();
                Uri parse = Uri.parse(NavDestination.Companion.createRoute(destination.getRoute()));
                IIX0o.II0XooXoX(parse, "Uri.parse(this)");
                intent.setDataAndType(parse, (String) null);
                intent.setAction((String) null);
                addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
                navigate(destination2, addInDefaultArgs, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches route " + str + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + str + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    @MainThread
    public final <T> void navigate(@OOXIXo T t, @OOXIXo Oox.oOoXoXO<? super NavOptionsBuilder, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(t, "route");
        IIX0o.x0xO0oo(oooxoxo, "builder");
        navigate$default(this, (Object) t, NavOptionsBuilderKt.navOptions(oooxoxo), (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> void navigate(@OOXIXo T t, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(t, "route");
        navigate(generateRouteFilled(t), navOptions, extras);
    }
}
