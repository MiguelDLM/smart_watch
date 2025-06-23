package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {

    @OXOo.OOXIXo
    private final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @OXOo.OOXIXo
    public Lifecycle getLifecycle() {
        return this.dispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @OXOo.oOoXoXO
    @CallSuper
    public IBinder onBind(@OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, "intent");
        this.dispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.dispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.dispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @kotlin.OOXIXo(message = "Deprecated in Java")
    @CallSuper
    public void onStart(@OXOo.oOoXoXO Intent intent, int i) {
        this.dispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@OXOo.oOoXoXO Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
