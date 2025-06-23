package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.IIX0o;

public class LifecycleService extends Service implements LifecycleOwner {
    @OOXIXo
    private final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    @OOXIXo
    public Lifecycle getLifecycle() {
        return this.dispatcher.getLifecycle();
    }

    @CallSuper
    @oOoXoXO
    public IBinder onBind(@OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        this.dispatcher.onServicePreSuperOnBind();
        return null;
    }

    @CallSuper
    public void onCreate() {
        this.dispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @CallSuper
    public void onDestroy() {
        this.dispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @kotlin.OOXIXo(message = "Deprecated in Java")
    @CallSuper
    public void onStart(@oOoXoXO Intent intent, int i) {
        this.dispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i);
    }

    @CallSuper
    public int onStartCommand(@oOoXoXO Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
