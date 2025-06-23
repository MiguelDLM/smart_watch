package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,402:1\n1747#2,3:403\n533#2,6:406\n533#2,6:412\n533#2,6:418\n533#2,6:424\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n109#1:403,3\n221#1:406,6\n240#1:412,6\n257#1:418,6\n274#1:424,6\n*E\n"})
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;

    @OXOo.oOoXoXO
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;

    @OXOo.oOoXoXO
    private OnBackPressedCallback inProgressCallback;

    @OXOo.oOoXoXO
    private OnBackInvokedDispatcher invokedDispatcher;

    @OXOo.oOoXoXO
    private OnBackInvokedCallback onBackInvokedCallback;

    @OXOo.OOXIXo
    private final kotlin.collections.xxIXOIIO<OnBackPressedCallback> onBackPressedCallbacks;

    @OXOo.oOoXoXO
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    /* loaded from: classes.dex */
    public static final class Api33Impl {

        @OXOo.OOXIXo
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @OXOo.OOXIXo
        public final OnBackInvokedCallback createOnBackInvokedCallback(@OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> onBackInvoked) {
            IIX0o.x0xO0oo(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.Oxx0xo
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    Oox.oIX0oI.this.invoke();
                }
            };
        }

        public final void registerOnBackInvokedCallback(@OXOo.OOXIXo Object dispatcher, int i, @OXOo.OOXIXo Object callback) {
            IIX0o.x0xO0oo(dispatcher, "dispatcher");
            IIX0o.x0xO0oo(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(@OXOo.OOXIXo Object dispatcher, @OXOo.OOXIXo Object callback) {
            IIX0o.x0xO0oo(dispatcher, "dispatcher");
            IIX0o.x0xO0oo(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    @RequiresApi(34)
    /* loaded from: classes.dex */
    public static final class Api34Impl {

        @OXOo.OOXIXo
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @OXOo.OOXIXo
        public final OnBackInvokedCallback createOnBackAnimationCallback(@OXOo.OOXIXo final Oox.oOoXoXO<? super BackEventCompat, oXIO0o0XI> onBackStarted, @OXOo.OOXIXo final Oox.oOoXoXO<? super BackEventCompat, oXIO0o0XI> onBackProgressed, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> onBackInvoked, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> onBackCancelled) {
            IIX0o.x0xO0oo(onBackStarted, "onBackStarted");
            IIX0o.x0xO0oo(onBackProgressed, "onBackProgressed");
            IIX0o.x0xO0oo(onBackInvoked, "onBackInvoked");
            IIX0o.x0xO0oo(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                @Override // android.window.OnBackAnimationCallback
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                @Override // android.window.OnBackInvokedCallback
                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                @Override // android.window.OnBackAnimationCallback
                public void onBackProgressed(BackEvent backEvent) {
                    IIX0o.x0xO0oo(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                @Override // android.window.OnBackAnimationCallback
                public void onBackStarted(BackEvent backEvent) {
                    IIX0o.x0xO0oo(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        @OXOo.oOoXoXO
        private Cancellable currentCancellable;

        @OXOo.OOXIXo
        private final Lifecycle lifecycle;

        @OXOo.OOXIXo
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(@OXOo.OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, @OXOo.OOXIXo Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            IIX0o.x0xO0oo(lifecycle, "lifecycle");
            IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class OnBackPressedCancellable implements Cancellable {

        @OXOo.OOXIXo
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(@OXOo.OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (IIX0o.Oxx0IOOO(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            Oox.oIX0oI<oXIO0o0XI> enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xoIox
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void onBackCancelled() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            kotlin.collections.xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (onBackPressedCallback.isEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = null;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            kotlin.collections.xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (onBackPressedCallback.isEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = null;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackProgressed(backEventCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void onBackStarted(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        kotlin.collections.xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
                    break;
                }
            } else {
                onBackPressedCallback = null;
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = onBackPressedCallback2;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackStarted(backEventCompat);
        }
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = true;
            } else if (!z && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z = this.hasEnabledCallbacks;
        kotlin.collections.xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
        boolean z2 = false;
        if (!(xxixoiio instanceof Collection) || !xxixoiio.isEmpty()) {
            Iterator<OnBackPressedCallback> it = xxixoiio.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().isEnabled()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z2;
        if (z2 != z) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(z2);
            }
        }
    }

    @MainThread
    public final void addCallback(@OXOo.OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @OXOo.OOXIXo
    @MainThread
    public final Cancellable addCancellableCallback$activity_release(@OXOo.OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(@OXOo.OOXIXo BackEventCompat backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(@OXOo.OOXIXo BackEventCompat backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @MainThread
    public final void onBackPressed() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            kotlin.collections.xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (onBackPressedCallback.isEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = null;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(@OXOo.OOXIXo OnBackInvokedDispatcher invoker) {
        IIX0o.x0xO0oo(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(@OXOo.oOoXoXO Runnable runnable, @OXOo.oOoXoXO Consumer<Boolean> consumer) {
        OnBackInvokedCallback createOnBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new kotlin.collections.xxIXOIIO<>();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                createOnBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new Oox.oOoXoXO<BackEventCompat, oXIO0o0XI>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BackEventCompat backEventCompat) {
                        invoke2(backEventCompat);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BackEventCompat backEvent) {
                        IIX0o.x0xO0oo(backEvent, "backEvent");
                        OnBackPressedDispatcher.this.onBackStarted(backEvent);
                    }
                }, new Oox.oOoXoXO<BackEventCompat, oXIO0o0XI>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BackEventCompat backEventCompat) {
                        invoke2(backEventCompat);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BackEventCompat backEvent) {
                        IIX0o.x0xO0oo(backEvent, "backEvent");
                        OnBackPressedDispatcher.this.onBackProgressed(backEvent);
                    }
                }, new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.activity.OnBackPressedDispatcher.3
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
                        OnBackPressedDispatcher.this.onBackPressed();
                    }
                }, new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.activity.OnBackPressedDispatcher.4
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
                        OnBackPressedDispatcher.this.onBackCancelled();
                    }
                });
            } else {
                createOnBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.activity.OnBackPressedDispatcher.5
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
                        OnBackPressedDispatcher.this.onBackPressed();
                    }
                });
            }
            this.onBackInvokedCallback = createOnBackInvokedCallback;
        }
    }

    @MainThread
    public final void addCallback(@OXOo.OOXIXo LifecycleOwner owner, @OXOo.OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(owner, "owner");
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
    }

    @XO0OX.xoIox
    public OnBackPressedDispatcher(@OXOo.oOoXoXO Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : runnable);
    }
}
