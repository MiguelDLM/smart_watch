package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
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
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.serialization.RouteSerializerKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
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
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.IIXOooo;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.oO;
import kotlinx.coroutines.flow.xoIox;
import kotlinx.coroutines.flow.xoXoI;
import kotlinx.coroutines.flow.xxIXOIIO;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 Uri.kt\nandroidx/core/net/UriKt\n+ 8 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,2927:1\n537#1,10:3077\n179#2,2:2928\n1313#2,2:2938\n1313#2,2:2940\n179#2,2:3075\n1#3:2930\n146#4:2931\n533#5,6:2932\n1855#5,2:2942\n1855#5,2:2944\n1855#5,2:2946\n1855#5,2:2948\n1864#5,3:2950\n1774#5,4:2953\n1855#5:2957\n766#5:2958\n857#5,2:2959\n1856#5:2961\n766#5:2962\n857#5,2:2963\n766#5:2965\n857#5,2:2966\n1855#5,2:2968\n1855#5:2970\n1789#5,3:2971\n1856#5:2974\n819#5:2982\n847#5,2:2983\n1855#5:2985\n1856#5:2993\n1238#5,4:2996\n1855#5,2:3000\n1855#5,2:3002\n378#5,7:3004\n1549#5:3011\n1620#5,3:3012\n1855#5,2:3015\n1855#5,2:3017\n819#5:3019\n847#5,2:3020\n1855#5,2:3022\n1855#5,2:3024\n533#5,6:3026\n533#5,6:3032\n533#5,6:3038\n1855#5,2:3044\n1855#5,2:3046\n1864#5,3:3049\n1855#5,2:3055\n533#5,6:3057\n533#5,6:3063\n533#5,6:3069\n372#6,7:2975\n372#6,7:2986\n453#6:2994\n403#6:2995\n29#7:3048\n13404#8,3:3052\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController\n*L\n-1#1:3077,10\n86#1:2928,2\n724#1:2938,2\n745#1:2940,2\n2810#1:3075,2\n169#1:2931\n662#1:2932,6\n902#1:2942,2\n905#1:2944,2\n911#1:2946,2\n913#1:2948,2\n992#1:2950,3\n1054#1:2953,4\n1198#1:2957\n1200#1:2958\n1200#1:2959,2\n1198#1:2961\n1208#1:2962\n1208#1:2963,2\n1211#1:2965\n1211#1:2966,2\n1282#1:2968,2\n1296#1:2970\n1300#1:2971,3\n1296#1:2974\n1359#1:2982\n1359#1:2983,2\n1360#1:2985\n1360#1:2993\n1711#1:2996,4\n1991#1:3000,2\n2054#1:3002,2\n2064#1:3004,7\n2073#1:3011\n2073#1:3012,3\n2090#1:3015,2\n2100#1:3017,2\n2167#1:3019\n2167#1:3020,2\n2171#1:3022,2\n2215#1:3024,2\n2257#1:3026,6\n2289#1:3032,6\n2318#1:3038,6\n2332#1:3044,2\n2348#1:3046,2\n2563#1:3049,3\n2604#1:3055,2\n2704#1:3057,6\n2725#1:3063,6\n2751#1:3069,6\n1346#1:2975,7\n1362#1:2986,7\n1711#1:2994\n1711#1:2995\n2441#1:3048\n2601#1:3052,3\n*E\n"})
/* loaded from: classes.dex */
public class NavController {

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

    @OOXIXo
    private final xoIox<List<NavBackStackEntry>> _currentBackStack;

    @OOXIXo
    private final xxIXOIIO<NavBackStackEntry> _currentBackStackEntryFlow;

    @oOoXoXO
    private NavGraph _graph;

    @OOXIXo
    private NavigatorProvider _navigatorProvider;

    @OOXIXo
    private final xoIox<List<NavBackStackEntry>> _visibleEntries;

    @oOoXoXO
    private Activity activity;

    @oOoXoXO
    private Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> addToBackStackHandler;

    @OOXIXo
    private final kotlin.collections.xxIXOIIO<NavBackStackEntry> backQueue;

    @OOXIXo
    private final List<NavBackStackEntry> backStackEntriesToDispatch;

    @OOXIXo
    private final Map<Integer, String> backStackMap;

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
    private final IIXOooo<List<NavBackStackEntry>> currentBackStack;

    @OOXIXo
    private final X0o0xo<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;

    @OOXIXo
    private final Map<NavBackStackEntry, Boolean> entrySavedState;

    @OOXIXo
    private Lifecycle.State hostLifecycleState;

    @oOoXoXO
    private NavInflater inflater;

    @OOXIXo
    private final LifecycleObserver lifecycleObserver;

    @oOoXoXO
    private LifecycleOwner lifecycleOwner;

    @OOXIXo
    private final X0IIOO navInflater$delegate;

    @OOXIXo
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;

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

    @oOoXoXO
    private Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> popFromBackStackHandler;

    @oOoXoXO
    private NavControllerViewModel viewModel;

    @OOXIXo
    private final IIXOooo<List<NavBackStackEntry>> visibleEntries;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static boolean deepLinkSaveState = true;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @x0XOIxOo
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean z) {
            NavController.deepLinkSaveState = z;
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$NavControllerNavigatorState\n+ 2 NavigatorProvider.kt\nandroidx/navigation/NavigatorProviderKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2927:1\n146#2:2928\n146#2:2929\n2624#3,3:2930\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/NavController$NavControllerNavigatorState\n*L\n297#1:2928\n330#1:2929\n360#1:2930,3\n*E\n"})
    /* loaded from: classes.dex */
    public final class NavControllerNavigatorState extends NavigatorState {

        @OOXIXo
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(@OOXIXo NavController navController, Navigator<? extends NavDestination> navigator) {
            IIX0o.x0xO0oo(navigator, "navigator");
            this.this$0 = navController;
            this.navigator = navigator;
        }

        public final void addInternal(@OOXIXo NavBackStackEntry backStackEntry) {
            IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
            super.push(backStackEntry);
        }

        @Override // androidx.navigation.NavigatorState
        @OOXIXo
        public NavBackStackEntry createBackStackEntry(@OOXIXo NavDestination destination, @oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(destination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), destination, bundle, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, null, null, 96, null);
        }

        @OOXIXo
        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(@OOXIXo NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            IIX0o.x0xO0oo(entry, "entry");
            boolean Oxx0IOOO2 = IIX0o.Oxx0IOOO(this.this$0.entrySavedState.get(entry), Boolean.TRUE);
            super.markTransitionComplete(entry);
            this.this$0.entrySavedState.remove(entry);
            if (!this.this$0.backQueue.contains(entry)) {
                this.this$0.unlinkChildFromParent$navigation_runtime_release(entry);
                if (entry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                kotlin.collections.xxIXOIIO xxixoiio = this.this$0.backQueue;
                if (!(xxixoiio instanceof Collection) || !xxixoiio.isEmpty()) {
                    Iterator<E> it = xxixoiio.iterator();
                    while (it.hasNext()) {
                        if (IIX0o.Oxx0IOOO(((NavBackStackEntry) it.next()).getId(), entry.getId())) {
                            break;
                        }
                    }
                }
                if (!Oxx0IOOO2 && (navControllerViewModel = this.this$0.viewModel) != null) {
                    navControllerViewModel.clear(entry.getId());
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.I0Io(this.this$0.populateVisibleEntries$navigation_runtime_release());
                return;
            }
            if (!isNavigating()) {
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.I0Io(CollectionsKt___CollectionsKt.o0Xo0XII(this.this$0.backQueue));
                this.this$0._visibleEntries.I0Io(this.this$0.populateVisibleEntries$navigation_runtime_release());
            }
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(@OOXIXo final NavBackStackEntry popUpTo, final boolean z) {
            IIX0o.x0xO0oo(popUpTo, "popUpTo");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(popUpTo.getDestination().getNavigatorName());
            this.this$0.entrySavedState.put(popUpTo, Boolean.valueOf(z));
            if (IIX0o.Oxx0IOOO(navigator, this.navigator)) {
                Oox.oOoXoXO oooxoxo = this.this$0.popFromBackStackHandler;
                if (oooxoxo != null) {
                    oooxoxo.invoke(popUpTo);
                    super.pop(popUpTo, z);
                    return;
                } else {
                    this.this$0.popBackStackFromNavigator$navigation_runtime_release(popUpTo, new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // Oox.oIX0oI
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                            invoke2();
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            super/*androidx.navigation.NavigatorState*/.pop(popUpTo, z);
                        }
                    });
                    return;
                }
            }
            Object obj = this.this$0.navigatorState.get(navigator);
            IIX0o.ooOOo0oXI(obj);
            ((NavControllerNavigatorState) obj).pop(popUpTo, z);
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(@OOXIXo NavBackStackEntry popUpTo, boolean z) {
            IIX0o.x0xO0oo(popUpTo, "popUpTo");
            super.popWithTransition(popUpTo, z);
        }

        @Override // androidx.navigation.NavigatorState
        public void prepareForTransition(@OOXIXo NavBackStackEntry entry) {
            IIX0o.x0xO0oo(entry, "entry");
            super.prepareForTransition(entry);
            if (this.this$0.backQueue.contains(entry)) {
                entry.setMaxLifecycle(Lifecycle.State.STARTED);
                return;
            }
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }

        @Override // androidx.navigation.NavigatorState
        public void push(@OOXIXo NavBackStackEntry backStackEntry) {
            IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
            Navigator navigator = this.this$0._navigatorProvider.getNavigator(backStackEntry.getDestination().getNavigatorName());
            if (IIX0o.Oxx0IOOO(navigator, this.navigator)) {
                Oox.oOoXoXO oooxoxo = this.this$0.addToBackStackHandler;
                if (oooxoxo != null) {
                    oooxoxo.invoke(backStackEntry);
                    addInternal(backStackEntry);
                    return;
                }
                Log.i(NavController.TAG, "Ignoring add of destination " + backStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(backStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }
    }

    /* loaded from: classes.dex */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@OOXIXo NavController navController, @OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle);
    }

    public NavController(@OOXIXo Context context) {
        Object obj;
        IIX0o.x0xO0oo(context, "context");
        this.context = context;
        Iterator it = SequencesKt__SequencesKt.x0XOIxOo(context, new Oox.oOoXoXO<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // Oox.oOoXoXO
            public final Context invoke(Context it2) {
                IIX0o.x0xO0oo(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            } else {
                obj = null;
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
        this.lifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.oIX0oI
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.lifecycleObserver$lambda$2(NavController.this, lifecycleOwner, event);
            }
        };
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                NavController.this.popBackStack();
            }
        };
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NavInflater>() { // from class: androidx.navigation.NavController$navInflater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final NavInflater invoke() {
                NavInflater navInflater;
                navInflater = NavController.this.inflater;
                return navInflater == null ? new NavInflater(NavController.this.getContext(), NavController.this._navigatorProvider) : navInflater;
            }
        });
        xxIXOIIO<NavBackStackEntry> II0xO02 = oO.II0xO0(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._currentBackStackEntryFlow = II0xO02;
        this.currentBackStackEntryFlow = Oxx0IOOO.oOoXoXO(II0xO02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x024c, code lost:
    
        r0 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0254, code lost:
    
        if (r0.hasNext() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0256, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r30.navigatorState.get(r30._navigatorProvider.getNavigator(r1.getDestination().getNavigatorName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0270, code lost:
    
        if (r2 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0272, code lost:
    
        r2.addInternal(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x029b, code lost:
    
        throw new java.lang.IllegalStateException(("NavigatorBackStack for " + r31.getNavigatorName() + " should already be created").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x029c, code lost:
    
        r30.backQueue.addAll(r8);
        r30.backQueue.add(r11);
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.OIxOIX0II(r8, r11).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02b4, code lost:
    
        if (r0.hasNext() == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02b6, code lost:
    
        r1 = (androidx.navigation.NavBackStackEntry) r0.next();
        r2 = r1.getDestination().getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02c4, code lost:
    
        if (r2 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02c6, code lost:
    
        linkChildToParent(r1, getBackStackEntry(r2.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02d2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01e9, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x017c, code lost:
    
        r14 = ((androidx.navigation.NavBackStackEntry) r8.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0100, code lost:
    
        r14 = ((androidx.navigation.NavBackStackEntry) r8.first()).getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00d1, code lost:
    
        r10 = r32;
        r11 = r33;
        r12 = r34;
        r13 = r4;
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0099, code lost:
    
        r19 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0077, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00da, code lost:
    
        r10 = r32;
        r11 = r33;
        r13 = r4;
        r8 = r5;
        r19 = r14;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00ef, code lost:
    
        r10 = r32;
        r11 = r33;
        r8 = r5;
        r19 = r14;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r5 = new kotlin.collections.xxIXOIIO();
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if ((r31 instanceof androidx.navigation.NavGraph) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0);
        r4 = r0.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r4 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r0 = r15.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r0.hasPrevious() == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        r1 = r0.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1.getDestination(), r4) == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        r19 = r14;
        r1 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.Companion, r30.context, r4, r32, getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        r5.addFirst(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000c, code lost:
    
        if ((r14 instanceof androidx.navigation.FloatingWindow) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        if (r30.backQueue.last().getDestination() != r4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        r10 = r32;
        r11 = r33;
        r12 = r34;
        r13 = r4;
        r8 = r5;
        popEntryFromBackStack$default(r30, r30.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e3, code lost:
    
        if (r13 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
    
        if (r13 != r31) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e8, code lost:
    
        r5 = r8;
        r15 = r12;
        r0 = r13;
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fb, code lost:
    
        if (r8.isEmpty() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fd, code lost:
    
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010a, code lost:
    
        if (r14 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0114, code lost:
    
        if (findDestination(r14.getId(), r14) == r14) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0116, code lost:
    
        r14 = r14.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011a, code lost:
    
        if (r14 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011c, code lost:
    
        if (r10 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
    
        if (r32.isEmpty() != true) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0125, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0129, code lost:
    
        r1 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0135, code lost:
    
        if (r1.hasPrevious() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0137, code lost:
    
        r2 = r1.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0146, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r2.getDestination(), r14) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014b, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
    
        if (r2 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014f, code lost:
    
        r2 = androidx.navigation.NavBackStackEntry.Companion.create$default(androidx.navigation.NavBackStackEntry.Companion, r30.context, r14, r14.addInDefaultArgs(r0), getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x016f, code lost:
    
        r8.addFirst(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0149, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0128, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0177, code lost:
    
        if (r8.isEmpty() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if ((r30.backQueue.last().getDestination() instanceof androidx.navigation.FloatingWindow) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0179, code lost:
    
        r14 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018c, code lost:
    
        if (r30.backQueue.isEmpty() != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019c, code lost:
    
        if ((r30.backQueue.last().getDestination() instanceof androidx.navigation.NavGraph) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019e, code lost:
    
        r0 = r30.backQueue.last().getDestination();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(r0, "null cannot be cast to non-null type androidx.navigation.NavGraph");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01bd, code lost:
    
        if (((androidx.navigation.NavGraph) r0).getNodes().get(r14.getId()) != null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01bf, code lost:
    
        popEntryFromBackStack$default(r30, r30.backQueue.last(), false, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d2, code lost:
    
        r0 = r30.backQueue.Oxx0IOOO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01da, code lost:
    
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01dc, code lost:
    
        r0 = (androidx.navigation.NavBackStackEntry) r8.Oxx0IOOO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e2, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e4, code lost:
    
        r0 = r0.getDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f1, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r30._graph) != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f3, code lost:
    
        r0 = r12.listIterator(r34.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ff, code lost:
    
        if (r0.hasPrevious() == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (popBackStackInternal$default(r30, r30.backQueue.last().getDestination().getId(), true, false, 4, (java.lang.Object) null) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0201, code lost:
    
        r1 = r0.previous();
        r2 = r1.getDestination();
        r3 = r30._graph;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0215, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r2, r3) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0217, code lost:
    
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0219, code lost:
    
        r18 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x021b, code lost:
    
        if (r18 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x021d, code lost:
    
        r19 = androidx.navigation.NavBackStackEntry.Companion;
        r0 = r30.context;
        r1 = r30._graph;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1);
        r2 = r30._graph;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2);
        r18 = androidx.navigation.NavBackStackEntry.Companion.create$default(r19, r0, r1, r2.addInDefaultArgs(r10), getHostLifecycleState$navigation_runtime_release(), r30.viewModel, null, null, 96, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0247, code lost:
    
        r8.addFirst(r18);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void addEntryToBackStack(androidx.navigation.NavDestination r31, android.os.Bundle r32, androidx.navigation.NavBackStackEntry r33, java.util.List<androidx.navigation.NavBackStackEntry> r34) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.addEntryToBackStack(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i, null, NavOptionsBuilderKt.navOptions(new Oox.oOoXoXO<NavOptionsBuilder, oXIO0o0XI>() { // from class: androidx.navigation.NavController$clearBackStackInternal$restored$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptions) {
                IIX0o.x0xO0oo(navOptions, "$this$navOptions");
                navOptions.setRestoreState(true);
            }
        }), null);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal(i, true, false);
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, null, 6, null);
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

    @x0XOIxOo
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z) {
        Companion.enableDeepLinkSaveState(z);
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> list, NavDestination navDestination, boolean z, final boolean z2) {
        String str;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio = new kotlin.collections.xxIXOIIO<>();
        Iterator<? extends Navigator<?>> it = list.iterator();
        while (it.hasNext()) {
            Navigator<? extends NavDestination> navigator = (Navigator) it.next();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            popBackStackInternal(navigator, this.backQueue.last(), z2, new Oox.oOoXoXO<NavBackStackEntry, oXIO0o0XI>() { // from class: androidx.navigation.NavController$executePopOperations$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    IIX0o.x0xO0oo(entry, "entry");
                    Ref.BooleanRef.this.element = true;
                    booleanRef.element = true;
                    this.popEntryFromBackStack(entry, z2, xxixoiio);
                }
            });
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z2) {
            if (!z) {
                for (NavDestination navDestination2 : SequencesKt___SequencesKt.Ix0x(SequencesKt__SequencesKt.x0XOIxOo(navDestination, new Oox.oOoXoXO<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$executePopOperations$2
                    @Override // Oox.oOoXoXO
                    public final NavDestination invoke(NavDestination destination) {
                        IIX0o.x0xO0oo(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Oox.oOoXoXO<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$executePopOperations$3
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public final Boolean invoke(NavDestination destination) {
                        Map map;
                        IIX0o.x0xO0oo(destination, "destination");
                        map = NavController.this.backStackMap;
                        return Boolean.valueOf(!map.containsKey(Integer.valueOf(destination.getId())));
                    }
                })) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer valueOf = Integer.valueOf(navDestination2.getId());
                    NavBackStackEntryState Oxx0IOOO2 = xxixoiio.Oxx0IOOO();
                    if (Oxx0IOOO2 != null) {
                        str = Oxx0IOOO2.getId();
                    } else {
                        str = null;
                    }
                    map.put(valueOf, str);
                }
            }
            if (!xxixoiio.isEmpty()) {
                NavBackStackEntryState first = xxixoiio.first();
                Iterator it2 = SequencesKt___SequencesKt.Ix0x(SequencesKt__SequencesKt.x0XOIxOo(findDestination$default(this, first.getDestinationId(), null, 2, null), new Oox.oOoXoXO<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$executePopOperations$5
                    @Override // Oox.oOoXoXO
                    public final NavDestination invoke(NavDestination destination) {
                        IIX0o.x0xO0oo(destination, "destination");
                        NavGraph parent = destination.getParent();
                        if (parent == null || parent.getStartDestinationId() != destination.getId()) {
                            return null;
                        }
                        return destination.getParent();
                    }
                }), new Oox.oOoXoXO<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$executePopOperations$6
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public final Boolean invoke(NavDestination destination) {
                        Map map2;
                        IIX0o.x0xO0oo(destination, "destination");
                        map2 = NavController.this.backStackMap;
                        return Boolean.valueOf(!map2.containsKey(Integer.valueOf(destination.getId())));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    this.backStackMap.put(Integer.valueOf(((NavDestination) it2.next()).getId()), first.getId());
                }
                if (this.backStackMap.values().contains(first.getId())) {
                    this.backStackStates.put(first.getId(), xxixoiio);
                }
            }
        }
        updateOnBackPressedCallbackEnabled();
        return booleanRef.element;
    }

    private final boolean executeRestoreState(final List<NavBackStackEntry> list, final Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        String str;
        NavBackStackEntry navBackStackEntry;
        NavDestination destination;
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list2 = (List) CollectionsKt___CollectionsKt.xX0ox(arrayList);
            if (list2 != null && (navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.O0O0Io00X(list2)) != null && (destination = navBackStackEntry.getDestination()) != null) {
                str = destination.getNavigatorName();
            } else {
                str = null;
            }
            if (IIX0o.Oxx0IOOO(str, navBackStackEntry2.getDestination().getNavigatorName())) {
                list2.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt__CollectionsKt.XOxIOxOx(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List<NavBackStackEntry> list3 : arrayList) {
            Navigator<? extends NavDestination> navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt___CollectionsKt.O0OOX0IIx(list3)).getDestination().getNavigatorName());
            final Ref.IntRef intRef = new Ref.IntRef();
            navigateInternal(navigator, list3, navOptions, extras, new Oox.oOoXoXO<NavBackStackEntry, oXIO0o0XI>() { // from class: androidx.navigation.NavController$executeRestoreState$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavBackStackEntry navBackStackEntry3) {
                    invoke2(navBackStackEntry3);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    List<NavBackStackEntry> ooXIXxIX2;
                    IIX0o.x0xO0oo(entry, "entry");
                    Ref.BooleanRef.this.element = true;
                    int indexOf = list.indexOf(entry);
                    if (indexOf != -1) {
                        int i = indexOf + 1;
                        ooXIXxIX2 = list.subList(intRef.element, i);
                        intRef.element = i;
                    } else {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    this.addEntryToBackStack(entry.getDestination(), bundle, entry, ooXIXxIX2);
                }
            });
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
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), RouteSerializerKt.generateHashCode(OxxIIOOXO.Oxx0IOOO(IO.oxoX(t.getClass()))), true, null, 4, null);
        if (findDestinationComprehensive$default != null) {
            Map<String, NavArgument> arguments = findDestinationComprehensive$default.getArguments();
            LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(arguments.size()));
            Iterator<T> it = arguments.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
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
            Iterator<NavBackStackEntry> it = xxixoiio.iterator();
            while (it.hasNext()) {
                if (!(it.next().getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
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
        NavDestination graph;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry oOoXoXO2 = this.backQueue.oOoXoXO();
        if (oOoXoXO2 == null || (graph = oOoXoXO2.getDestination()) == null) {
            graph = getGraph();
        }
        if (xxixoiio != null) {
            for (NavBackStackEntryState navBackStackEntryState : xxixoiio) {
                NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, graph, navBackStackEntryState.getDestinationId(), true, null, 4, null);
                if (findDestinationComprehensive$default != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.context, findDestinationComprehensive$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                    graph = findDestinationComprehensive$default;
                } else {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + graph).toString());
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
            List oox000IX2 = SequencesKt___SequencesKt.oox000IX(SequencesKt___SequencesKt.X0xxXX0(NavGraph.Companion.childHierarchy((NavGraph) navDestination), new Oox.oOoXoXO<NavDestination, Integer>() { // from class: androidx.navigation.NavController$launchSingleTopInternal$childHierarchyId$1
                @Override // Oox.oOoXoXO
                public final Integer invoke(NavDestination it) {
                    IIX0o.x0xO0oo(it, "it");
                    return Integer.valueOf(it.getId());
                }
            }));
            if (this.backQueue.size() - i != oox000IX2.size()) {
                return false;
            }
            kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio2 = this.backQueue;
            List<NavBackStackEntry> subList = xxixoiio2.subList(i, xxixoiio2.size());
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(subList, 10));
            Iterator<T> it = subList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((NavBackStackEntry) it.next()).getDestination().getId()));
            }
            if (!IIX0o.Oxx0IOOO(arrayList, oox000IX2)) {
                return false;
            }
        } else if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || navDestination.getId() != destination.getId()) {
            return false;
        }
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio3 = new kotlin.collections.xxIXOIIO();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, "event");
        this$0.hostLifecycleState = event.getTargetState();
        if (this$0._graph != null) {
            Iterator it = CollectionsKt___CollectionsKt.o0Xo0XII(this$0.backQueue).iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
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
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate(str, navOptions, extras);
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> oooxoxo) {
        this.addToBackStackHandler = oooxoxo;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    public static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                oooxoxo = new Oox.oOoXoXO<NavBackStackEntry, oXIO0o0XI>() { // from class: androidx.navigation.NavController$navigateInternal$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavBackStackEntry it) {
                        IIX0o.x0xO0oo(it, "it");
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavBackStackEntry navBackStackEntry) {
                        invoke2(navBackStackEntry);
                        return oXIO0o0XI.f29392oIX0oI;
                    }
                };
            }
            navController.navigateInternal(navigator, list, navOptions, extras, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }

    @MainThread
    private final void onGraphCreated(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.navigatorStateToRestore;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String name = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                IIX0o.oO(name, "name");
                Navigator navigator = navigatorProvider.getNavigator(name);
                Bundle bundle3 = bundle2.getBundle(name);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                IIX0o.x0XOIxOo(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination$default = findDestination$default(this, navBackStackEntryState.getDestinationId(), null, 2, null);
                if (findDestination$default != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination$default, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    Navigator<? extends NavDestination> navigator2 = this._navigatorProvider.getNavigator(findDestination$default.getNavigatorName());
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
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection<Navigator<? extends NavDestination>> values = this._navigatorProvider.getNavigators().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : values) {
            if (!((Navigator) obj).isAttached()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator3 : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph != null && this.backQueue.isEmpty()) {
            if (!this.deepLinkHandled && (activity = this.activity) != null) {
                IIX0o.ooOOo0oXI(activity);
                if (handleDeepLink(activity.getIntent())) {
                    return;
                }
            }
            NavGraph navGraph = this._graph;
            IIX0o.ooOOo0oXI(navGraph);
            navigate(navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
            return;
        }
        dispatchOnDestinationChanged();
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack(str, z, z2);
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z, Oox.oOoXoXO<? super NavBackStackEntry, oXIO0o0XI> oooxoxo) {
        this.popFromBackStackHandler = oooxoxo;
        navigator.popBackStack(navBackStackEntry, z);
        this.popFromBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i & 4) != 0) {
            oooxoxo = new Oox.oOoXoXO<NavBackStackEntry, oXIO0o0XI>() { // from class: androidx.navigation.NavController$popBackStackInternal$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry it) {
                    IIX0o.x0xO0oo(it, "it");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavBackStackEntry navBackStackEntry2) {
                    invoke2(navBackStackEntry2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        navController.popBackStackInternal(navigator, navBackStackEntry, z, oooxoxo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry navBackStackEntry, boolean z, kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio) {
        NavControllerViewModel navControllerViewModel;
        IIXOooo<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
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

    /* JADX WARN: Multi-variable type inference failed */
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
        final String str = this.backStackMap.get(Integer.valueOf(i));
        OxI.XIXIX(this.backStackMap.values(), new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final Boolean invoke(String str2) {
                return Boolean.valueOf(IIX0o.Oxx0IOOO(str2, str));
            }
        });
        return executeRestoreState(instantiateBackStack((kotlin.collections.xxIXOIIO) XoX.OOXIXo(this.backStackStates).remove(str)), bundle, navOptions, extras);
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        Bundle bundle;
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity = this.activity;
        IIX0o.ooOOo0oXI(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        IIX0o.ooOOo0oXI(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        IIX0o.ooOOo0oXI(intArray);
        List<Integer> oXooI = ArraysKt___ArraysKt.oXooI(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int intValue = ((Number) OxI.xx0X0(oXooI)).intValue();
        if (parcelableArrayList != null) {
        }
        if (oXooI.isEmpty()) {
            return false;
        }
        NavDestination findDestinationComprehensive$default = findDestinationComprehensive$default(this, getGraph(), intValue, false, null, 4, null);
        if (findDestinationComprehensive$default instanceof NavGraph) {
            intValue = NavGraph.Companion.findStartDestination((NavGraph) findDestinationComprehensive$default).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || intValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(Xo0.oIX0oI(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle2 = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle2 != null) {
            bundleOf.putAll(bundle2);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object obj : oXooI) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            int intValue2 = ((Number) obj).intValue();
            if (parcelableArrayList != null) {
                bundle = (Bundle) parcelableArrayList.get(i);
            } else {
                bundle = null;
            }
            createDeepLink.addDestination(intValue2, bundle);
            i = i2;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.finish();
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
                Activity activity = this.activity;
                if (activity != null) {
                    IIX0o.ooOOo0oXI(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.activity;
                        IIX0o.ooOOo0oXI(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.activity;
                            IIX0o.ooOOo0oXI(activity3);
                            bundle2.putParcelable(KEY_DEEP_LINK_INTENT, activity3.getIntent());
                            NavGraph topGraph = getTopGraph(this.backQueue);
                            Activity activity4 = this.activity;
                            IIX0o.ooOOo0oXI(activity4);
                            Intent intent = activity4.getIntent();
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
                Activity activity5 = this.activity;
                if (activity5 != null) {
                    activity5.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (getDestinationCountOnBackStack() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto Le
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void addOnDestinationChangedListener(@OOXIXo OnDestinationChangedListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.onDestinationChangedListeners.add(listener);
        if (!this.backQueue.isEmpty()) {
            NavBackStackEntry last = this.backQueue.last();
            listener.onDestinationChanged(this, last.getDestination(), last.getArguments());
        }
    }

    @MainThread
    public final boolean clearBackStack(@OOXIXo String route) {
        IIX0o.x0xO0oo(route, "route");
        return clearBackStackInternal(route) && dispatchOnDestinationChanged();
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
            if (navDestination != null) {
                if (IIX0o.Oxx0IOOO(this._graph, navDestination) && navDestination.getParent() == null) {
                    return this._graph;
                }
            } else {
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
            NavGraph parent = navDestination.getParent();
            IIX0o.ooOOo0oXI(parent);
            navGraph = parent;
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
    public final IIXOooo<List<NavBackStackEntry>> getCurrentBackStack() {
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

    @OOXIXo
    @MainThread
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
        Object obj;
        Iterator it = CollectionsKt___CollectionsKt.OOoOoO0o(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt__SequencesKt.X0o0xo(it).iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (NavBackStackEntry) obj;
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
    public final IIXOooo<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleDeepLink(@OXOo.oOoXoXO android.content.Intent r20) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.handleDeepLink(android.content.Intent):boolean");
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> void navigate(@OOXIXo T route) {
        IIX0o.x0xO0oo(route, "route");
        navigate$default(this, route, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    @MainThread
    public boolean navigateUp() {
        Bundle bundle;
        Intent intent;
        if (getDestinationCountOnBackStack() == 1) {
            Activity activity = this.activity;
            int[] iArr = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            if (bundle != null) {
                iArr = bundle.getIntArray(KEY_DEEP_LINK_IDS);
            }
            if (iArr != null) {
                return tryRelaunchUpToExplicitStack();
            }
            return tryRelaunchUpToGeneratedStack();
        }
        return popBackStack();
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> boolean popBackStack(@OOXIXo T route, boolean z) {
        IIX0o.x0xO0oo(route, "route");
        return popBackStack$default(this, (Object) route, z, false, 4, (Object) null);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(@OOXIXo NavBackStackEntry popUpTo, @OOXIXo Oox.oIX0oI<oXIO0o0XI> onComplete) {
        IIX0o.x0xO0oo(popUpTo, "popUpTo");
        IIX0o.x0xO0oo(onComplete, "onComplete");
        int indexOf = this.backQueue.indexOf(popUpTo);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    @OOXIXo
    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getTransitionsInProgress().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            OxI.XIo0oOXIx(arrayList, arrayList2);
        }
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ArrayList arrayList3 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : xxixoiio) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(navBackStackEntry2);
            }
        }
        OxI.XIo0oOXIx(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).getDestination() instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    public void removeOnDestinationChangedListener(@OOXIXo OnDestinationChangedListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.onDestinationChangedListeners.remove(listener);
    }

    @CallSuper
    public void restoreState(@oOoXoXO Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] intArray = bundle.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_BACK_STACK_IDS);
        if (intArray != null && stringArrayList != null) {
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
            for (String id : stringArrayList2) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + id);
                if (parcelableArray != null) {
                    Map<String, kotlin.collections.xxIXOIIO<NavBackStackEntryState>> map = this.backStackStates;
                    IIX0o.oO(id, "id");
                    kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio = new kotlin.collections.xxIXOIIO<>(parcelableArray.length);
                    Iterator oIX0oI2 = II0XooXoX.oIX0oI(parcelableArray);
                    while (oIX0oI2.hasNext()) {
                        Parcelable parcelable = (Parcelable) oIX0oI2.next();
                        IIX0o.x0XOIxOo(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        xxixoiio.add((NavBackStackEntryState) parcelable);
                    }
                    map.put(id, xxixoiio);
                }
            }
        }
        this.deepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    @oOoXoXO
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this._navigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
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
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i2 = 0;
            for (Map.Entry<Integer, String> entry2 : this.backStackMap.entrySet()) {
                int intValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i2] = intValue;
                arrayList2.add(value);
                i2++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, kotlin.collections.xxIXOIIO<NavBackStackEntryState>> entry3 : this.backStackStates.entrySet()) {
                String key2 = entry3.getKey();
                kotlin.collections.xxIXOIIO<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i3 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    parcelableArr2[i3] = navBackStackEntryState;
                    i3 = i4;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + key2, parcelableArr2);
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
    public void setGraph(@OOXIXo NavGraph graph) {
        IIX0o.x0xO0oo(graph, "graph");
        setGraph(graph, (Bundle) null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(@OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLifecycleOwner(@OOXIXo LifecycleOwner owner) {
        Lifecycle lifecycle;
        IIX0o.x0xO0oo(owner, "owner");
        if (IIX0o.Oxx0IOOO(owner, this.lifecycleOwner)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this.lifecycleObserver);
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
    public void setOnBackPressedDispatcher(@OOXIXo OnBackPressedDispatcher dispatcher) {
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        if (IIX0o.Oxx0IOOO(dispatcher, this.onBackPressedDispatcher)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            this.onBackPressedCallback.remove();
            this.onBackPressedDispatcher = dispatcher;
            dispatcher.addCallback(lifecycleOwner, this.onBackPressedCallback);
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            lifecycle.removeObserver(this.lifecycleObserver);
            lifecycle.addObserver(this.lifecycleObserver);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewModelStore(@OOXIXo ViewModelStore viewModelStore) {
        IIX0o.x0xO0oo(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.viewModel;
        NavControllerViewModel.Companion companion = NavControllerViewModel.Companion;
        if (IIX0o.Oxx0IOOO(navControllerViewModel, companion.getInstance(viewModelStore))) {
            return;
        }
        if (this.backQueue.isEmpty()) {
            this.viewModel = companion.getInstance(viewModelStore);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    @oOoXoXO
    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(@OOXIXo NavBackStackEntry child) {
        IIX0o.x0xO0oo(child, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(child);
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
        IIXOooo<Set<NavBackStackEntry>> transitionsInProgress;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.backQueue);
        if (o0Xo0XII.isEmpty()) {
            return;
        }
        NavDestination destination = ((NavBackStackEntry) CollectionsKt___CollectionsKt.O0O0Io00X(o0Xo0XII)).getDestination();
        ArrayList arrayList = new ArrayList();
        if (destination instanceof FloatingWindow) {
            Iterator it = CollectionsKt___CollectionsKt.OOoOoO0o(o0Xo0XII).iterator();
            while (it.hasNext()) {
                NavDestination destination2 = ((NavBackStackEntry) it.next()).getDestination();
                arrayList.add(destination2);
                if (!(destination2 instanceof FloatingWindow) && !(destination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt___CollectionsKt.OOoOoO0o(o0Xo0XII)) {
            Lifecycle.State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination3 = navBackStackEntry.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider().getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                    if (navControllerNavigatorState != null && (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) != null && (value = transitionsInProgress.getValue()) != null) {
                        bool = Boolean.valueOf(value.contains(navBackStackEntry));
                    } else {
                        bool = null;
                    }
                    if (!IIX0o.Oxx0IOOO(bool, Boolean.TRUE) && ((atomicInteger = this.parentToChildCount.get(navBackStackEntry)) == null || atomicInteger.get() != 0)) {
                        hashMap.put(navBackStackEntry, state);
                    } else {
                        hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                    }
                }
                NavDestination navDestination = (NavDestination) CollectionsKt___CollectionsKt.XxXX(arrayList);
                if (navDestination != null && navDestination.getId() == destination3.getId()) {
                    OxI.Ox0O(arrayList);
                }
                destination = destination.getParent();
            } else if (!arrayList.isEmpty() && destination3.getId() == ((NavDestination) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).getId()) {
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
            } else {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : o0Xo0XII) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.setMaxLifecycle(state3);
            } else {
                navBackStackEntry2.updateState();
            }
        }
    }

    public static /* synthetic */ void navigate$default(NavController navController, Object obj, NavOptions navOptions, Navigator.Extras extras, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            navOptions = null;
        }
        if ((i & 4) != 0) {
            extras = null;
        }
        navController.navigate((NavController) obj, navOptions, extras);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
            oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
            int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null));
            if (findDestinationComprehensive$default(navController, navController.getGraph(), generateHashCode, true, null, 4, null) != null) {
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
    public final <T> void navigate(@OOXIXo T route, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(route, "route");
        navigate$default(this, route, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final boolean popBackStack(@OOXIXo String route, boolean z) {
        IIX0o.x0xO0oo(route, "route");
        return popBackStack$default(this, route, z, false, 4, (Object) null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int i) {
        setGraph(getNavInflater().inflate(i), (Bundle) null);
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStackInternal(i, z, z2);
    }

    @MainThread
    public final boolean clearBackStack(@IdRes int i) {
        return clearBackStackInternal(i) && dispatchOnDestinationChanged();
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String route) {
        IIX0o.x0xO0oo(route, "route");
        navigate$default(this, route, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
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
        Iterator it = CollectionsKt___CollectionsKt.OOoOoO0o(this.backQueue).iterator();
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
        if (navDestination == null) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(this.context, i) + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, navDestination, z, z2);
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController navController, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStackInternal((NavController) obj, z, z2);
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String route, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(route, "route");
        navigate$default(this, route, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@OOXIXo NavGraph graph, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(graph, "graph");
        if (!this.backQueue.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        }
        if (!IIX0o.Oxx0IOOO(this._graph, graph)) {
            NavGraph navGraph = this._graph;
            if (navGraph != null) {
                for (Integer id : new ArrayList(this.backStackMap.keySet())) {
                    IIX0o.oO(id, "id");
                    clearBackStackInternal(id.intValue());
                }
                popBackStackInternal$default(this, navGraph.getId(), true, false, 4, (Object) null);
            }
            this._graph = graph;
            onGraphCreated(bundle);
            return;
        }
        int size = graph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavDestination valueAt = graph.getNodes().valueAt(i);
            NavGraph navGraph2 = this._graph;
            IIX0o.ooOOo0oXI(navGraph2);
            int keyAt = navGraph2.getNodes().keyAt(i);
            NavGraph navGraph3 = this._graph;
            IIX0o.ooOOo0oXI(navGraph3);
            navGraph3.getNodes().replace(keyAt, valueAt);
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            List<NavDestination> IXO2 = O0xOxO.IXO(SequencesKt___SequencesKt.oox000IX(NavDestination.Companion.getHierarchy(navBackStackEntry.getDestination())));
            NavDestination navDestination = this._graph;
            IIX0o.ooOOo0oXI(navDestination);
            for (NavDestination navDestination2 : IXO2) {
                if (!IIX0o.Oxx0IOOO(navDestination2, this._graph) || !IIX0o.Oxx0IOOO(navDestination, graph)) {
                    if (navDestination instanceof NavGraph) {
                        navDestination = ((NavGraph) navDestination).findNode(navDestination2.getId());
                        IIX0o.ooOOo0oXI(navDestination);
                    }
                }
            }
            navBackStackEntry.setDestination(navDestination);
        }
    }

    @MainThread
    public final /* synthetic */ <T> boolean clearBackStack() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return clearBackStack(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null)));
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
    public final <T> boolean clearBackStack(@OOXIXo T route) {
        IIX0o.x0xO0oo(route, "route");
        return clearBackStackInternal(generateRouteFilled(route)) && dispatchOnDestinationChanged();
    }

    @MainThread
    public void navigate(@IdRes int i, @oOoXoXO Bundle bundle) {
        navigate(i, bundle, (NavOptions) null);
    }

    @MainThread
    public boolean popBackStack(@IdRes int i, boolean z, boolean z2) {
        return popBackStackInternal(i, z, z2) && dispatchOnDestinationChanged();
    }

    private final boolean restoreStateInternal(String str) {
        NavBackStackEntryState Oxx0IOOO2;
        int hashCode = NavDestination.Companion.createRoute(str).hashCode();
        if (this.backStackMap.containsKey(Integer.valueOf(hashCode))) {
            return restoreStateInternal(hashCode, null, null, null);
        }
        NavDestination findDestination = findDestination(str);
        if (findDestination != null) {
            final String str2 = this.backStackMap.get(Integer.valueOf(findDestination.getId()));
            OxI.XIXIX(this.backStackMap.values(), new Oox.oOoXoXO<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public final Boolean invoke(String str3) {
                    return Boolean.valueOf(IIX0o.Oxx0IOOO(str3, str2));
                }
            });
            kotlin.collections.xxIXOIIO<NavBackStackEntryState> xxixoiio = (kotlin.collections.xxIXOIIO) XoX.OOXIXo(this.backStackStates).remove(str2);
            NavDestination.DeepLinkMatch matchRoute = findDestination.matchRoute(str);
            IIX0o.ooOOo0oXI(matchRoute);
            if (matchRoute.hasMatchingArgs((xxixoiio == null || (Oxx0IOOO2 = xxixoiio.Oxx0IOOO()) == null) ? null : Oxx0IOOO2.getArgs())) {
                return executeRestoreState(instantiateBackStack(xxixoiio), null, null, null);
            }
            return false;
        }
        throw new IllegalStateException(("Restore State failed: route " + str + " cannot be found from the current destination " + getCurrentDestination()).toString());
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@OOXIXo String route) {
        IIX0o.x0xO0oo(route, "route");
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        IIX0o.ooOOo0oXI(navGraph);
        if (!IIX0o.Oxx0IOOO(navGraph.getRoute(), route)) {
            NavGraph navGraph2 = this._graph;
            IIX0o.ooOOo0oXI(navGraph2);
            if (navGraph2.matchRoute(route) == null) {
                return getTopGraph(this.backQueue).findNode(route);
            }
        }
        return this._graph;
    }

    @MainThread
    public void navigate(@IdRes int i, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Navigator.Extras) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigate(@androidx.annotation.IdRes int r12, @OXOo.oOoXoXO android.os.Bundle r13, @OXOo.oOoXoXO androidx.navigation.NavOptions r14, @OXOo.oOoXoXO androidx.navigation.Navigator.Extras r15) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(int, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    @XO0OX.xoIox
    @MainThread
    public final boolean popBackStack(@OOXIXo String route, boolean z, boolean z2) {
        IIX0o.x0xO0oo(route, "route");
        return popBackStackInternal(route, z, z2) && dispatchOnDestinationChanged();
    }

    @MainThread
    private final boolean clearBackStackInternal(String str) {
        Iterator<T> it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(str);
        Iterator<T> it2 = this.navigatorState.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).setNavigating(false);
        }
        return restoreStateInternal && popBackStackInternal(str, true, false);
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return navController.popBackStack((NavController) obj, z, z2);
    }

    @XO0OX.xoIox
    @MainThread
    public final /* synthetic */ <T> boolean popBackStack(boolean z, boolean z2) {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null));
        if (findDestinationComprehensive$default(this, getGraph(), generateHashCode, true, null, 4, null) != null) {
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
    public final NavBackStackEntry getBackStackEntry(@OOXIXo String route) {
        NavBackStackEntry navBackStackEntry;
        IIX0o.x0xO0oo(route, "route");
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.getDestination().hasRoute(route, navBackStackEntry2.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    private final <T> boolean popBackStackInternal(T t, boolean z, boolean z2) {
        return popBackStackInternal(generateRouteFilled(t), z, z2);
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> boolean popBackStack(@OOXIXo T route, boolean z, boolean z2) {
        IIX0o.x0xO0oo(route, "route");
        return popBackStackInternal((NavController) route, z, z2) && dispatchOnDestinationChanged();
    }

    private final boolean popBackStackInternal(String str, boolean z, boolean z2) {
        NavBackStackEntry navBackStackEntry;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        kotlin.collections.xxIXOIIO<NavBackStackEntry> xxixoiio = this.backQueue;
        ListIterator<NavBackStackEntry> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            boolean hasRoute = navBackStackEntry2.getDestination().hasRoute(str, navBackStackEntry2.getArguments());
            if (z || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()));
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        NavDestination destination = navBackStackEntry3 != null ? navBackStackEntry3.getDestination() : null;
        if (destination == null) {
            Log.i(TAG, "Ignoring popBackStack to route " + str + " as it was not found on the current back stack");
            return false;
        }
        return executePopOperations(arrayList, destination, z, z2);
    }

    @XO0OX.xoIox
    @MainThread
    public final /* synthetic */ <T> boolean popBackStack(boolean z) {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null));
        if (findDestinationComprehensive$default(this, getGraph(), generateHashCode, true, null, 4, null) != null) {
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

    public final /* synthetic */ <T> NavBackStackEntry getBackStackEntry() {
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        NavBackStackEntry navBackStackEntry = null;
        int generateHashCode = RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null));
        if (findDestinationComprehensive$default(this, getGraph(), generateHashCode, true, null, 4, null) != null) {
            List<NavBackStackEntry> value = getCurrentBackStack().getValue();
            ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator.previous();
                if (previous.getDestination().getId() == generateHashCode) {
                    navBackStackEntry = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2 != null) {
                return navBackStackEntry2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No destination with route ");
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(IO.oxoX(Object.class).xoXoI());
            sb.append(" is on the NavController's back stack. The current destination is ");
            sb.append(getCurrentDestination());
            throw new IllegalArgumentException(sb.toString().toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Destination with route ");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb2.append(IO.oxoX(Object.class).xoXoI());
        sb2.append(" cannot be found in navigation graph ");
        sb2.append(getGraph());
        throw new IllegalArgumentException(sb2.toString().toString());
    }

    @OOXIXo
    public final <T> NavBackStackEntry getBackStackEntry(@OOXIXo T route) {
        IIX0o.x0xO0oo(route, "route");
        return getBackStackEntry(generateRouteFilled(route));
    }

    @MainThread
    public void navigate(@OOXIXo Uri deepLink) {
        IIX0o.x0xO0oo(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null));
    }

    @MainThread
    public void navigate(@OOXIXo Uri deepLink, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@OOXIXo Uri deepLink, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(deepLink, "deepLink");
        navigate(new NavDeepLinkRequest(deepLink, null, null), navOptions, extras);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest request) {
        IIX0o.x0xO0oo(request, "request");
        navigate(request, (NavOptions) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest request, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(request, "request");
        navigate(request, navOptions, (Navigator.Extras) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDeepLinkRequest request, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(request, "request");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchDeepLinkComprehensive = topGraph.matchDeepLinkComprehensive(request, true, true, topGraph);
            if (matchDeepLinkComprehensive != null) {
                Bundle addInDefaultArgs = matchDeepLinkComprehensive.getDestination().addInDefaultArgs(matchDeepLinkComprehensive.getMatchingArgs());
                if (addInDefaultArgs == null) {
                    addInDefaultArgs = new Bundle();
                }
                NavDestination destination = matchDeepLinkComprehensive.getDestination();
                Intent intent = new Intent();
                intent.setDataAndType(request.getUri(), request.getMimeType());
                intent.setAction(request.getAction());
                addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
                navigate(destination, addInDefaultArgs, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches request " + request + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + request + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x012a A[LOOP:1: B:20:0x0124->B:22:0x012a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db  */
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void navigate(final androidx.navigation.NavDestination r22, android.os.Bundle r23, androidx.navigation.NavOptions r24, androidx.navigation.Navigator.Extras r25) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections directions) {
        IIX0o.x0xO0oo(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null);
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections directions, @oOoXoXO NavOptions navOptions) {
        IIX0o.x0xO0oo(directions, "directions");
        navigate(directions.getActionId(), directions.getArguments(), navOptions);
    }

    @MainThread
    public void navigate(@OOXIXo NavDirections directions, @OOXIXo Navigator.Extras navigatorExtras) {
        IIX0o.x0xO0oo(directions, "directions");
        IIX0o.x0xO0oo(navigatorExtras, "navigatorExtras");
        navigate(directions.getActionId(), directions.getArguments(), (NavOptions) null, navigatorExtras);
    }

    @MainThread
    public final void navigate(@OOXIXo String route, @OOXIXo Oox.oOoXoXO<? super NavOptionsBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final void navigate(@OOXIXo String route, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(route, "route");
        if (this._graph != null) {
            NavGraph topGraph = getTopGraph(this.backQueue);
            NavDestination.DeepLinkMatch matchRouteComprehensive = topGraph.matchRouteComprehensive(route, true, true, topGraph);
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
                intent.setDataAndType(parse, null);
                intent.setAction(null);
                addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
                navigate(destination2, addInDefaultArgs, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this._graph);
        }
        throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
    }

    @MainThread
    public final <T> void navigate(@OOXIXo T route, @OOXIXo Oox.oOoXoXO<? super NavOptionsBuilder, oXIO0o0XI> builder) {
        IIX0o.x0xO0oo(route, "route");
        IIX0o.x0xO0oo(builder, "builder");
        navigate$default(this, route, NavOptionsBuilderKt.navOptions(builder), (Navigator.Extras) null, 4, (Object) null);
    }

    @XO0OX.xoIox
    @MainThread
    public final <T> void navigate(@OOXIXo T route, @oOoXoXO NavOptions navOptions, @oOoXoXO Navigator.Extras extras) {
        IIX0o.x0xO0oo(route, "route");
        navigate(generateRouteFilled(route), navOptions, extras);
    }
}
