package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.OnUserLeaveHintProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, OnUserLeaveHintProvider, MenuHost, FullyDrawnReporterOwner {
    @OOXIXo
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    @OOXIXo
    private static final Companion Companion = new Companion((IIXOooo) null);
    @oOoXoXO
    private ViewModelStore _viewModelStore;
    @OOXIXo
    private final ActivityResultRegistry activityResultRegistry;
    @LayoutRes
    private int contentLayoutId;
    @OOXIXo
    private final ContextAwareHelper contextAwareHelper;
    @OOXIXo
    private final X0IIOO defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    @OOXIXo
    private final X0IIOO fullyDrawnReporter$delegate;
    @OOXIXo
    private final MenuHostHelper menuHostHelper;
    @OOXIXo
    private final AtomicInteger nextLocalRequestCode;
    @OOXIXo
    private final X0IIOO onBackPressedDispatcher$delegate;
    @OOXIXo
    private final CopyOnWriteArrayList<Consumer<Configuration>> onConfigurationChangedListeners;
    @OOXIXo
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> onMultiWindowModeChangedListeners;
    @OOXIXo
    private final CopyOnWriteArrayList<Consumer<Intent>> onNewIntentListeners;
    @OOXIXo
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> onPictureInPictureModeChangedListeners;
    @OOXIXo
    private final CopyOnWriteArrayList<Consumer<Integer>> onTrimMemoryListeners;
    @OOXIXo
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    /* access modifiers changed from: private */
    @OOXIXo
    public final ReportFullyDrawnExecutor reportFullyDrawnExecutor;
    @OOXIXo
    private final SavedStateRegistryController savedStateRegistryController;

    @RequiresApi(33)
    public static final class Api33Impl {
        @OOXIXo
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @OOXIXo
        public final OnBackInvokedDispatcher getOnBackInvokedDispatcher(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            IIX0o.oO(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public static final class NonConfigurationInstances {
        @oOoXoXO
        private Object custom;
        @oOoXoXO
        private ViewModelStore viewModelStore;

        @oOoXoXO
        public final Object getCustom() {
            return this.custom;
        }

        @oOoXoXO
        public final ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }

        public final void setCustom(@oOoXoXO Object obj) {
            this.custom = obj;
        }

        public final void setViewModelStore(@oOoXoXO ViewModelStore viewModelStore2) {
            this.viewModelStore = viewModelStore2;
        }
    }

    public interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(@OOXIXo View view);
    }

    public final class ReportFullyDrawnExecutorImpl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        @oOoXoXO
        private Runnable currentRunnable;
        private final long endWatchTimeMillis = (SystemClock.uptimeMillis() + ((long) 10000));
        private boolean onDrawScheduled;

        public ReportFullyDrawnExecutorImpl() {
        }

        /* access modifiers changed from: private */
        public static final void execute$lambda$0(ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl) {
            Runnable runnable = reportFullyDrawnExecutorImpl.currentRunnable;
            if (runnable != null) {
                IIX0o.ooOOo0oXI(runnable);
                runnable.run();
                reportFullyDrawnExecutorImpl.currentRunnable = null;
            }
        }

        public void activityDestroyed() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void execute(@OOXIXo Runnable runnable) {
            IIX0o.x0xO0oo(runnable, "runnable");
            this.currentRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            IIX0o.oO(decorView, "window.decorView");
            if (!this.onDrawScheduled) {
                decorView.postOnAnimation(new Oxx0IOOO(this));
            } else if (IIX0o.Oxx0IOOO(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @oOoXoXO
        public final Runnable getCurrentRunnable() {
            return this.currentRunnable;
        }

        public final long getEndWatchTimeMillis() {
            return this.endWatchTimeMillis;
        }

        public final boolean getOnDrawScheduled() {
            return this.onDrawScheduled;
        }

        public void onDraw() {
            Runnable runnable = this.currentRunnable;
            if (runnable != null) {
                runnable.run();
                this.currentRunnable = null;
                if (ComponentActivity.this.getFullyDrawnReporter().isFullyDrawnReported()) {
                    this.onDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                this.onDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public final void setCurrentRunnable(@oOoXoXO Runnable runnable) {
            this.currentRunnable = runnable;
        }

        public final void setOnDrawScheduled(boolean z) {
            this.onDrawScheduled = z;
        }

        public void viewCreated(@OOXIXo View view) {
            IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
            if (!this.onDrawScheduled) {
                this.onDrawScheduled = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }
    }

    public ComponentActivity() {
        this.contextAwareHelper = new ContextAwareHelper();
        this.menuHostHelper = new MenuHostHelper(new oIX0oI(this));
        SavedStateRegistryController create = SavedStateRegistryController.Companion.create(this);
        this.savedStateRegistryController = create;
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        this.fullyDrawnReporter$delegate = XIxXXX0x0.oIX0oI(new ComponentActivity$fullyDrawnReporter$2(this));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new ComponentActivity$activityResultRegistry$1(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() != null) {
            getLifecycle().addObserver(new II0xO0(this));
            getLifecycle().addObserver(new I0Io(this));
            getLifecycle().addObserver(new LifecycleEventObserver(this) {
                final /* synthetic */ ComponentActivity this$0;

                {
                    this.this$0 = r1;
                }

                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    IIX0o.x0xO0oo(lifecycleOwner, "source");
                    IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
                    this.this$0.ensureViewModelStore();
                    this.this$0.getLifecycle().removeObserver(this);
                }
            });
            create.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            if (Build.VERSION.SDK_INT <= 23) {
                getLifecycle().addObserver(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new oxoX(this));
            addOnContextAvailableListener(new X0o0xo(this));
            this.defaultViewModelProviderFactory$delegate = XIxXXX0x0.oIX0oI(new ComponentActivity$defaultViewModelProviderFactory$2(this));
            this.onBackPressedDispatcher$delegate = XIxXXX0x0.oIX0oI(new ComponentActivity$onBackPressedDispatcher$2(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Window window;
        View peekDecorView;
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_STOP && (window = componentActivity.getWindow()) != null && (peekDecorView = window.peekDecorView()) != null) {
            peekDecorView.cancelPendingInputEvents();
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            componentActivity.contextAwareHelper.clearAvailableContext();
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.getViewModelStore().clear();
            }
            componentActivity.reportFullyDrawnExecutor.activityDestroyed();
        }
    }

    /* access modifiers changed from: private */
    public static final Bundle _init_$lambda$4(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        componentActivity.activityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$5(ComponentActivity componentActivity, Context context) {
        IIX0o.x0xO0oo(context, "it");
        Bundle consumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (consumeRestoredStateForKey != null) {
            componentActivity.activityResultRegistry.onRestoreInstanceState(consumeRestoredStateForKey);
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(33)
    public final void addObserverForBackInvoker(OnBackPressedDispatcher onBackPressedDispatcher) {
        getLifecycle().addObserver(new XO(onBackPressedDispatcher, this));
    }

    /* access modifiers changed from: private */
    public static final void addObserverForBackInvoker$lambda$7(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            onBackPressedDispatcher.setOnBackInvokedDispatcher(Api33Impl.INSTANCE.getOnBackInvokedDispatcher(componentActivity));
        }
    }

    private final ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorImpl();
    }

    /* access modifiers changed from: private */
    public final void ensureViewModelStore() {
        if (this._viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this._viewModelStore = nonConfigurationInstances.getViewModelStore();
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new ViewModelStore();
            }
        }
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private static /* synthetic */ void getSavedStateRegistryController$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void menuHostHelper$lambda$0(ComponentActivity componentActivity) {
        componentActivity.invalidateMenu();
    }

    public void addContentView(@oOoXoXO View view, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor2 = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        reportFullyDrawnExecutor2.viewCreated(decorView);
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(@OOXIXo MenuProvider menuProvider) {
        IIX0o.x0xO0oo(menuProvider, "provider");
        this.menuHostHelper.addMenuProvider(menuProvider);
    }

    public final void addOnConfigurationChangedListener(@OOXIXo Consumer<Configuration> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener) {
        IIX0o.x0xO0oo(onContextAvailableListener, "listener");
        this.contextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    public final void addOnMultiWindowModeChangedListener(@OOXIXo Consumer<MultiWindowModeChangedInfo> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(@OOXIXo Consumer<Intent> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(@OOXIXo Consumer<PictureInPictureModeChangedInfo> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(@OOXIXo Consumer<Integer> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onTrimMemoryListeners.add(consumer);
    }

    public final void addOnUserLeaveHintListener(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "listener");
        this.onUserLeaveHintListeners.add(runnable);
    }

    @OOXIXo
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @CallSuper
    @OOXIXo
    public CreationExtras getDefaultViewModelCreationExtras() {
        Bundle bundle = null;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) null, 1, (IIXOooo) null);
        if (getApplication() != null) {
            CreationExtras.Key<Application> key = ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;
            Application application = getApplication();
            IIX0o.oO(application, MimeTypes.BASE_TYPE_APPLICATION);
            mutableCreationExtras.set(key, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, bundle);
        }
        return mutableCreationExtras;
    }

    @OOXIXo
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return (ViewModelProvider.Factory) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    @OOXIXo
    public FullyDrawnReporter getFullyDrawnReporter() {
        return (FullyDrawnReporter) this.fullyDrawnReporter$delegate.getValue();
    }

    @kotlin.OOXIXo(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    @oOoXoXO
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.getCustom();
        }
        return null;
    }

    @OOXIXo
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @OOXIXo
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @OOXIXo
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @OOXIXo
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            ViewModelStore viewModelStore = this._viewModelStore;
            IIX0o.ooOOo0oXI(viewModelStore);
            return viewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        ViewTreeLifecycleOwner.set(decorView, this);
        View decorView2 = getWindow().getDecorView();
        IIX0o.oO(decorView2, "window.decorView");
        ViewTreeViewModelStoreOwner.set(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        IIX0o.oO(decorView3, "window.decorView");
        ViewTreeSavedStateRegistryOwner.set(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        IIX0o.oO(decorView4, "window.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(decorView4, this);
        View decorView5 = getWindow().getDecorView();
        IIX0o.oO(decorView5, "window.decorView");
        ViewTreeFullyDrawnReporterOwner.set(decorView5, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    @CallSuper
    public void onActivityResult(int i, int i2, @oOoXoXO Intent intent) {
        if (!this.activityResultRegistry.dispatchResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    @CallSuper
    @MainThread
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @CallSuper
    public void onConfigurationChanged(@OOXIXo Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    public void onCreate(@oOoXoXO Bundle bundle) {
        this.savedStateRegistryController.performRestore(bundle);
        this.contextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
        int i = this.contentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    public boolean onCreatePanelMenu(int i, @OOXIXo Menu menu) {
        IIX0o.x0xO0oo(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        this.menuHostHelper.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i, @OOXIXo MenuItem menuItem) {
        IIX0o.x0xO0oo(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.menuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Deprecated in android.app.Activity")
    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        if (!this.dispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z));
            }
        }
    }

    @CallSuper
    public void onNewIntent(@OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i, @OOXIXo Menu menu) {
        IIX0o.x0xO0oo(menu, "menu");
        this.menuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(i, menu);
    }

    @kotlin.OOXIXo(message = "Deprecated in android.app.Activity")
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        if (!this.dispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z));
            }
        }
    }

    public boolean onPreparePanel(int i, @oOoXoXO View view, @OOXIXo Menu menu) {
        IIX0o.x0xO0oo(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        this.menuHostHelper.onPrepareMenu(menu);
        return true;
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)} passing\n      in a {@link RequestMultiplePermissions} object for the {@link ActivityResultContract} and\n      handling the result in the {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    @CallSuper
    public void onRequestPermissionsResult(int i, @OOXIXo String[] strArr, @OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(strArr, "permissions");
        IIX0o.x0xO0oo(iArr, "grantResults");
        if (!this.activityResultRegistry.dispatchResult(i, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @kotlin.OOXIXo(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    @oOoXoXO
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @oOoXoXO
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.getViewModelStore();
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.setCustom(onRetainCustomNonConfigurationInstance);
        nonConfigurationInstances2.setViewModelStore(viewModelStore);
        return nonConfigurationInstances2;
    }

    @CallSuper
    public void onSaveInstanceState(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "outState");
        if (getLifecycle() instanceof LifecycleRegistry) {
            Lifecycle lifecycle = getLifecycle();
            IIX0o.x0XOIxOo(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.performSave(bundle);
    }

    @CallSuper
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<Consumer<Integer>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    @CallSuper
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    @oOoXoXO
    public Context peekAvailableContext() {
        return this.contextAwareHelper.peekAvailableContext();
    }

    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultRegistry activityResultRegistry2, @OOXIXo ActivityResultCallback<O> activityResultCallback) {
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(activityResultRegistry2, "registry");
        IIX0o.x0xO0oo(activityResultCallback, bn.f.L);
        return activityResultRegistry2.register("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(@OOXIXo MenuProvider menuProvider) {
        IIX0o.x0xO0oo(menuProvider, "provider");
        this.menuHostHelper.removeMenuProvider(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(@OOXIXo Consumer<Configuration> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener) {
        IIX0o.x0xO0oo(onContextAvailableListener, "listener");
        this.contextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    public final void removeOnMultiWindowModeChangedListener(@OOXIXo Consumer<MultiWindowModeChangedInfo> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(@OOXIXo Consumer<Intent> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(@OOXIXo Consumer<PictureInPictureModeChangedInfo> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(@OOXIXo Consumer<Integer> consumer) {
        IIX0o.x0xO0oo(consumer, "listener");
        this.onTrimMemoryListeners.remove(consumer);
    }

    public final void removeOnUserLeaveHintListener(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "listener");
        this.onUserLeaveHintListeners.remove(runnable);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            getFullyDrawnReporter().fullyDrawnReported();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public void setContentView(@LayoutRes int i) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor2 = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        reportFullyDrawnExecutor2.viewCreated(decorView);
        super.setContentView(i);
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(@OOXIXo Intent intent, int i) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        super.startActivityForResult(intent, i);
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(@OOXIXo IntentSender intentSender, int i, @oOoXoXO Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        IIX0o.x0xO0oo(intentSender, SDKConstants.PARAM_INTENT);
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void addMenuProvider(@OOXIXo MenuProvider menuProvider, @OOXIXo LifecycleOwner lifecycleOwner) {
        IIX0o.x0xO0oo(menuProvider, "provider");
        IIX0o.x0xO0oo(lifecycleOwner, "owner");
        this.menuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(@OOXIXo Intent intent, int i, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        super.startActivityForResult(intent, i, bundle);
    }

    @kotlin.OOXIXo(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(@OOXIXo IntentSender intentSender, int i, @oOoXoXO Intent intent, int i2, int i3, int i4, @oOoXoXO Bundle bundle) throws IntentSender.SendIntentException {
        IIX0o.x0xO0oo(intentSender, SDKConstants.PARAM_INTENT);
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@OOXIXo MenuProvider menuProvider, @OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(menuProvider, "provider");
        IIX0o.x0xO0oo(lifecycleOwner, "owner");
        IIX0o.x0xO0oo(state, "state");
        this.menuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultCallback<O> activityResultCallback) {
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(activityResultCallback, bn.f.L);
        return registerForActivityResult(activityResultContract, this.activityResultRegistry, activityResultCallback);
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onMultiWindowModeChanged(boolean z, @OOXIXo Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @RequiresApi(api = 26)
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z, @OOXIXo Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public void setContentView(@oOoXoXO View view) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor2 = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        reportFullyDrawnExecutor2.viewCreated(decorView);
        super.setContentView(view);
    }

    public void setContentView(@oOoXoXO View view, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor2 = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        reportFullyDrawnExecutor2.viewCreated(decorView);
        super.setContentView(view, layoutParams);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i) {
        this();
        this.contentLayoutId = i;
    }
}
