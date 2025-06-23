package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMultiInstanceInvalidationClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,130:1\n37#2,2:131\n*S KotlinDebug\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n*L\n95#1:131,2\n*E\n"})
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    @OOXIXo
    private final IMultiInstanceInvalidationCallback callback = new MultiInstanceInvalidationClient$callback$1(this);
    private int clientId;
    @OOXIXo
    private final Executor executor;
    @OOXIXo
    private final InvalidationTracker invalidationTracker;
    @OOXIXo
    private final String name;
    public InvalidationTracker.Observer observer;
    @OOXIXo
    private final Runnable removeObserverRunnable;
    @oOoXoXO
    private IMultiInstanceInvalidationService service;
    @OOXIXo
    private final ServiceConnection serviceConnection;
    @OOXIXo
    private final Runnable setUpRunnable;
    @OOXIXo
    private final AtomicBoolean stopped = new AtomicBoolean(false);

    public MultiInstanceInvalidationClient(@OOXIXo Context context, @OOXIXo String str, @OOXIXo Intent intent, @OOXIXo InvalidationTracker invalidationTracker2, @OOXIXo Executor executor2) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(intent, "serviceIntent");
        IIX0o.x0xO0oo(invalidationTracker2, "invalidationTracker");
        IIX0o.x0xO0oo(executor2, "executor");
        this.name = str;
        this.invalidationTracker = invalidationTracker2;
        this.executor = executor2;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        MultiInstanceInvalidationClient$serviceConnection$1 multiInstanceInvalidationClient$serviceConnection$1 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.serviceConnection = multiInstanceInvalidationClient$serviceConnection$1;
        this.setUpRunnable = new oxoX(this);
        this.removeObserverRunnable = new X0o0xo(this);
        setObserver(new InvalidationTracker.Observer(this, (String[]) invalidationTracker2.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0])) {
            final /* synthetic */ MultiInstanceInvalidationClient this$0;

            {
                this.this$0 = r1;
            }

            public boolean isRemote$room_runtime_release() {
                return true;
            }

            public void onInvalidated(@OOXIXo Set<String> set) {
                IIX0o.x0xO0oo(set, "tables");
                if (!this.this$0.getStopped().get()) {
                    try {
                        IMultiInstanceInvalidationService service = this.this$0.getService();
                        if (service != null) {
                            service.broadcastInvalidation(this.this$0.getClientId(), (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e) {
                        Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
                    }
                }
            }
        });
        applicationContext.bindService(intent, multiInstanceInvalidationClient$serviceConnection$1, 1);
    }

    /* access modifiers changed from: private */
    public static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        IIX0o.x0xO0oo(multiInstanceInvalidationClient, "this$0");
        multiInstanceInvalidationClient.invalidationTracker.removeObserver(multiInstanceInvalidationClient.getObserver());
    }

    /* access modifiers changed from: private */
    public static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        IIX0o.x0xO0oo(multiInstanceInvalidationClient, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.service;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.clientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.callback, multiInstanceInvalidationClient.name);
                multiInstanceInvalidationClient.invalidationTracker.addObserver(multiInstanceInvalidationClient.getObserver());
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
        }
    }

    @OOXIXo
    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    @OOXIXo
    public final Executor getExecutor() {
        return this.executor;
    }

    @OOXIXo
    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer2 = this.observer;
        if (observer2 != null) {
            return observer2;
        }
        IIX0o.XOxIOxOx("observer");
        return null;
    }

    @OOXIXo
    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    @oOoXoXO
    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    @OOXIXo
    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    @OOXIXo
    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    @OOXIXo
    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int i) {
        this.clientId = i;
    }

    public final void setObserver(@OOXIXo InvalidationTracker.Observer observer2) {
        IIX0o.x0xO0oo(observer2, "<set-?>");
        this.observer = observer2;
    }

    public final void setService(@oOoXoXO IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.service = iMultiInstanceInvalidationService;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(getObserver());
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.service;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.callback, this.clientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
