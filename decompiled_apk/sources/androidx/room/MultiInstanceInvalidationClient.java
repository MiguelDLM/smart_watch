package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMultiInstanceInvalidationClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,130:1\n37#2,2:131\n*S KotlinDebug\n*F\n+ 1 MultiInstanceInvalidationClient.kt\nandroidx/room/MultiInstanceInvalidationClient\n*L\n95#1:131,2\n*E\n"})
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;

    @OXOo.OOXIXo
    private final IMultiInstanceInvalidationCallback callback;
    private int clientId;

    @OXOo.OOXIXo
    private final Executor executor;

    @OXOo.OOXIXo
    private final InvalidationTracker invalidationTracker;

    @OXOo.OOXIXo
    private final String name;
    public InvalidationTracker.Observer observer;

    @OXOo.OOXIXo
    private final Runnable removeObserverRunnable;

    @OXOo.oOoXoXO
    private IMultiInstanceInvalidationService service;

    @OXOo.OOXIXo
    private final ServiceConnection serviceConnection;

    @OXOo.OOXIXo
    private final Runnable setUpRunnable;

    @OXOo.OOXIXo
    private final AtomicBoolean stopped;

    public MultiInstanceInvalidationClient(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String name, @OXOo.OOXIXo Intent serviceIntent, @OXOo.OOXIXo InvalidationTracker invalidationTracker, @OXOo.OOXIXo Executor executor) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(serviceIntent, "serviceIntent");
        IIX0o.x0xO0oo(invalidationTracker, "invalidationTracker");
        IIX0o.x0xO0oo(executor, "executor");
        this.name = name;
        this.invalidationTracker = invalidationTracker;
        this.executor = executor;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.callback = new MultiInstanceInvalidationClient$callback$1(this);
        this.stopped = new AtomicBoolean(false);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(@OXOo.OOXIXo ComponentName name2, @OXOo.OOXIXo IBinder service) {
                IIX0o.x0xO0oo(name2, "name");
                IIX0o.x0xO0oo(service, "service");
                MultiInstanceInvalidationClient.this.setService(IMultiInstanceInvalidationService.Stub.asInterface(service));
                MultiInstanceInvalidationClient.this.getExecutor().execute(MultiInstanceInvalidationClient.this.getSetUpRunnable());
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(@OXOo.OOXIXo ComponentName name2) {
                IIX0o.x0xO0oo(name2, "name");
                MultiInstanceInvalidationClient.this.getExecutor().execute(MultiInstanceInvalidationClient.this.getRemoveObserverRunnable());
                MultiInstanceInvalidationClient.this.setService(null);
            }
        };
        this.serviceConnection = serviceConnection;
        this.setUpRunnable = new Runnable() { // from class: androidx.room.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                MultiInstanceInvalidationClient.setUpRunnable$lambda$1(MultiInstanceInvalidationClient.this);
            }
        };
        this.removeObserverRunnable = new Runnable() { // from class: androidx.room.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient.this);
            }
        };
        setObserver(new InvalidationTracker.Observer((String[]) invalidationTracker.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@OXOo.OOXIXo Set<String> tables) {
                IIX0o.x0xO0oo(tables, "tables");
                if (MultiInstanceInvalidationClient.this.getStopped().get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService service = MultiInstanceInvalidationClient.this.getService();
                    if (service != null) {
                        service.broadcastInvalidation(MultiInstanceInvalidationClient.this.getClientId(), (String[]) tables.toArray(new String[0]));
                    }
                } catch (RemoteException e) {
                    Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
                }
            }
        });
        applicationContext.bindService(serviceIntent, serviceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.invalidationTracker.removeObserver(this$0.getObserver());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this$0.service;
            if (iMultiInstanceInvalidationService != null) {
                this$0.clientId = iMultiInstanceInvalidationService.registerCallback(this$0.callback, this$0.name);
                this$0.invalidationTracker.addObserver(this$0.getObserver());
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
        }
    }

    @OXOo.OOXIXo
    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    @OXOo.OOXIXo
    public final Executor getExecutor() {
        return this.executor;
    }

    @OXOo.OOXIXo
    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @OXOo.OOXIXo
    public final String getName() {
        return this.name;
    }

    @OXOo.OOXIXo
    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer = this.observer;
        if (observer != null) {
            return observer;
        }
        IIX0o.XOxIOxOx("observer");
        return null;
    }

    @OXOo.OOXIXo
    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    @OXOo.oOoXoXO
    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    @OXOo.OOXIXo
    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    @OXOo.OOXIXo
    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    @OXOo.OOXIXo
    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int i) {
        this.clientId = i;
    }

    public final void setObserver(@OXOo.OOXIXo InvalidationTracker.Observer observer) {
        IIX0o.x0xO0oo(observer, "<set-?>");
        this.observer = observer;
    }

    public final void setService(@OXOo.oOoXoXO IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
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
