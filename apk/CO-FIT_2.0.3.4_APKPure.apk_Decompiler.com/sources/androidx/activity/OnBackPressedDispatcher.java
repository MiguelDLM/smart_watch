package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.xoIox;
import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,402:1\n1747#2,3:403\n533#2,6:406\n533#2,6:412\n533#2,6:418\n533#2,6:424\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n109#1:403,3\n221#1:406,6\n240#1:412,6\n257#1:418,6\n274#1:424,6\n*E\n"})
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    @oOoXoXO
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    /* access modifiers changed from: private */
    @oOoXoXO
    public OnBackPressedCallback inProgressCallback;
    @oOoXoXO
    private OnBackInvokedDispatcher invokedDispatcher;
    @oOoXoXO
    private OnBackInvokedCallback onBackInvokedCallback;
    /* access modifiers changed from: private */
    @OOXIXo
    public final xxIXOIIO<OnBackPressedCallback> onBackPressedCallbacks;
    @oOoXoXO
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    public static final class Api33Impl {
        @OOXIXo
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        /* access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(oIX0oI oix0oi) {
            oix0oi.invoke();
        }

        @OOXIXo
        public final OnBackInvokedCallback createOnBackInvokedCallback(@OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
            IIX0o.x0xO0oo(oix0oi, "onBackInvoked");
            return new Oxx0xo(oix0oi);
        }

        public final void registerOnBackInvokedCallback(@OOXIXo Object obj, int i, @OOXIXo Object obj2) {
            IIX0o.x0xO0oo(obj, "dispatcher");
            IIX0o.x0xO0oo(obj2, bn.f.L);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public final void unregisterOnBackInvokedCallback(@OOXIXo Object obj, @OOXIXo Object obj2) {
            IIX0o.x0xO0oo(obj, "dispatcher");
            IIX0o.x0xO0oo(obj2, bn.f.L);
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    @RequiresApi(34)
    public static final class Api34Impl {
        @OOXIXo
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @OOXIXo
        public final OnBackInvokedCallback createOnBackAnimationCallback(@OOXIXo Oox.oOoXoXO<? super BackEventCompat, oXIO0o0XI> oooxoxo, @OOXIXo Oox.oOoXoXO<? super BackEventCompat, oXIO0o0XI> oooxoxo2, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi2) {
            IIX0o.x0xO0oo(oooxoxo, "onBackStarted");
            IIX0o.x0xO0oo(oooxoxo2, "onBackProgressed");
            IIX0o.x0xO0oo(oix0oi, "onBackInvoked");
            IIX0o.x0xO0oo(oix0oi2, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(oooxoxo, oooxoxo2, oix0oi, oix0oi2);
        }
    }

    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        @oOoXoXO
        private Cancellable currentCancellable;
        @OOXIXo
        private final Lifecycle lifecycle;
        @OOXIXo
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(@OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, @OOXIXo Lifecycle lifecycle2, OnBackPressedCallback onBackPressedCallback2) {
            IIX0o.x0xO0oo(lifecycle2, RequestParameters.SUBRESOURCE_LIFECYCLE);
            IIX0o.x0xO0oo(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle2;
            this.onBackPressedCallback = onBackPressedCallback2;
            lifecycle2.addObserver(this);
        }

        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(lifecycleOwner, "source");
            IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    public final class OnBackPressedCancellable implements Cancellable {
        @OOXIXo
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(@OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback2) {
            IIX0o.x0xO0oo(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback2;
        }

        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (IIX0o.Oxx0IOOO(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            oIX0oI<oXIO0o0XI> enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release((oIX0oI<oXIO0o0XI>) null);
        }
    }

    @xoIox
    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (IIXOooo) null);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackCancelled() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
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

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.inProgressCallback;
        if (onBackPressedCallback2 == null) {
            xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackProgressed(backEventCompat);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackStarted(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.isEnabled()) {
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
        OnBackInvokedCallback onBackInvokedCallback2 = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback2 != null) {
            if (z && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = true;
            } else if (!z && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z = this.hasEnabledCallbacks;
        xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
        boolean z2 = false;
        if (!(xxixoiio instanceof Collection) || !xxixoiio.isEmpty()) {
            Iterator<T> it = xxixoiio.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((OnBackPressedCallback) it.next()).isEnabled()) {
                        z2 = true;
                        break;
                    }
                } else {
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
    public final void addCallback(@OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    @OOXIXo
    public final Cancellable addCancellableCallback$activity_release(@OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackProgressed(@OOXIXo BackEventCompat backEventCompat) {
        IIX0o.x0xO0oo(backEventCompat, "backEvent");
        onBackProgressed(backEventCompat);
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackStarted(@OOXIXo BackEventCompat backEventCompat) {
        IIX0o.x0xO0oo(backEventCompat, "backEvent");
        onBackStarted(backEventCompat);
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
            xxIXOIIO<OnBackPressedCallback> xxixoiio = this.onBackPressedCallbacks;
            ListIterator<OnBackPressedCallback> listIterator = xxixoiio.listIterator(xxixoiio.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallback = null;
                    break;
                }
                onBackPressedCallback = listIterator.previous();
                if (onBackPressedCallback.isEnabled()) {
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
    public final void setOnBackInvokedDispatcher(@OOXIXo OnBackInvokedDispatcher onBackInvokedDispatcher) {
        IIX0o.x0xO0oo(onBackInvokedDispatcher, "invoker");
        this.invokedDispatcher = onBackInvokedDispatcher;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(@oOoXoXO Runnable runnable, @oOoXoXO Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallback2;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new xxIXOIIO<>();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                onBackInvokedCallback2 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new Oox.oOoXoXO<BackEventCompat, oXIO0o0XI>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((BackEventCompat) obj);
                        return oXIO0o0XI.f19155oIX0oI;
                    }

                    public final void invoke(BackEventCompat backEventCompat) {
                        IIX0o.x0xO0oo(backEventCompat, "backEvent");
                        this.this$0.onBackStarted(backEventCompat);
                    }
                }, new Oox.oOoXoXO<BackEventCompat, oXIO0o0XI>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((BackEventCompat) obj);
                        return oXIO0o0XI.f19155oIX0oI;
                    }

                    public final void invoke(BackEventCompat backEventCompat) {
                        IIX0o.x0xO0oo(backEventCompat, "backEvent");
                        this.this$0.onBackProgressed(backEventCompat);
                    }
                }, new oIX0oI<oXIO0o0XI>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                }, new oIX0oI<oXIO0o0XI>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackCancelled();
                    }
                });
            } else {
                onBackInvokedCallback2 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new oIX0oI<oXIO0o0XI>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallback2;
        }
    }

    @MainThread
    public final void addCallback(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo OnBackPressedCallback onBackPressedCallback) {
        IIX0o.x0xO0oo(lifecycleOwner, "owner");
        IIX0o.x0xO0oo(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
            updateEnabledCallbacks();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
        }
    }

    @xoIox
    public OnBackPressedDispatcher(@oOoXoXO Runnable runnable) {
        this(runnable, (Consumer<Boolean>) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : runnable);
    }
}
