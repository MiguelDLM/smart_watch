package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class ProcessLifecycleOwner implements LifecycleOwner {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    public static final long TIMEOUT_MS = 700;
    /* access modifiers changed from: private */
    @OOXIXo
    public static final ProcessLifecycleOwner newInstance = new ProcessLifecycleOwner();
    @OOXIXo
    private final Runnable delayedPauseRunnable = new xxIXOIIO(this);
    @oOoXoXO
    private Handler handler;
    /* access modifiers changed from: private */
    @OOXIXo
    public final ReportFragment.ActivityInitializationListener initializationListener = new ProcessLifecycleOwner$initializationListener$1(this);
    private boolean pauseSent = true;
    @OOXIXo
    private final LifecycleRegistry registry = new LifecycleRegistry(this);
    private int resumedCounter;
    private int startedCounter;
    private boolean stopSent = true;

    @RequiresApi(29)
    public static final class Api29Impl {
        @OOXIXo
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @DoNotInline
        @x0XOIxOo
        public static final void registerActivityLifecycleCallbacks(@OOXIXo Activity activity, @OOXIXo Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            IIX0o.x0xO0oo(activityLifecycleCallbacks, bn.f.L);
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getTIMEOUT_MS$lifecycle_process_release$annotations() {
        }

        @x0XOIxOo
        @OOXIXo
        public final LifecycleOwner get() {
            return ProcessLifecycleOwner.newInstance;
        }

        @x0XOIxOo
        public final void init$lifecycle_process_release(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, bn.f.o);
            ProcessLifecycleOwner.newInstance.attach$lifecycle_process_release(context);
        }

        private Companion() {
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* access modifiers changed from: private */
    public static final void delayedPauseRunnable$lambda$0(ProcessLifecycleOwner processLifecycleOwner) {
        IIX0o.x0xO0oo(processLifecycleOwner, "this$0");
        processLifecycleOwner.dispatchPauseIfNeeded$lifecycle_process_release();
        processLifecycleOwner.dispatchStopIfNeeded$lifecycle_process_release();
    }

    @x0XOIxOo
    @OOXIXo
    public static final LifecycleOwner get() {
        return Companion.get();
    }

    @x0XOIxOo
    public static final void init$lifecycle_process_release(@OOXIXo Context context) {
        Companion.init$lifecycle_process_release(context);
    }

    public final void activityPaused$lifecycle_process_release() {
        int i = this.resumedCounter - 1;
        this.resumedCounter = i;
        if (i == 0) {
            Handler handler2 = this.handler;
            IIX0o.ooOOo0oXI(handler2);
            handler2.postDelayed(this.delayedPauseRunnable, 700);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int i = this.resumedCounter + 1;
        this.resumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.pauseSent) {
            this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.pauseSent = false;
            return;
        }
        Handler handler2 = this.handler;
        IIX0o.ooOOo0oXI(handler2);
        handler2.removeCallbacks(this.delayedPauseRunnable);
    }

    public final void activityStarted$lifecycle_process_release() {
        int i = this.startedCounter + 1;
        this.startedCounter = i;
        if (i == 1 && this.stopSent) {
            this.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.stopSent = false;
        }
    }

    public final void activityStopped$lifecycle_process_release() {
        this.startedCounter--;
        dispatchStopIfNeeded$lifecycle_process_release();
    }

    public final void attach$lifecycle_process_release(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        this.handler = new Handler();
        this.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        IIX0o.x0XOIxOo(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new ProcessLifecycleOwner$attach$1(this));
    }

    public final void dispatchPauseIfNeeded$lifecycle_process_release() {
        if (this.resumedCounter == 0) {
            this.pauseSent = true;
            this.registry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void dispatchStopIfNeeded$lifecycle_process_release() {
        if (this.startedCounter == 0 && this.pauseSent) {
            this.registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.stopSent = true;
        }
    }

    @OOXIXo
    public Lifecycle getLifecycle() {
        return this.registry;
    }
}
