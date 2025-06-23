package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class PlatformServiceClient implements ServiceConnection {

    @OXOo.OOXIXo
    private final String applicationId;

    @OXOo.OOXIXo
    private final Context context;

    @OXOo.OOXIXo
    private final Handler handler;

    @OXOo.oOoXoXO
    private CompletedListener listener;

    @OXOo.oOoXoXO
    private final String nonce;
    private final int protocolVersion;
    private final int replyMessage;
    private final int requestMessage;
    private boolean running;

    @OXOo.oOoXoXO
    private Messenger sender;

    /* loaded from: classes8.dex */
    public interface CompletedListener {
        void completed(@OXOo.oOoXoXO Bundle bundle);
    }

    public PlatformServiceClient(@OXOo.OOXIXo Context context, int i, int i2, int i3, @OXOo.OOXIXo String applicationId, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context;
        this.requestMessage = i;
        this.replyMessage = i2;
        this.applicationId = applicationId;
        this.protocolVersion = i3;
        this.nonce = str;
        this.handler = new Handler() { // from class: com.facebook.internal.PlatformServiceClient.1
            @Override // android.os.Handler
            public void handleMessage(@OXOo.OOXIXo Message message) {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    IIX0o.x0xO0oo(message, "message");
                    PlatformServiceClient.this.handleMessage(message);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        };
    }

    private final void callback(Bundle bundle) {
        if (!this.running) {
            return;
        }
        this.running = false;
        CompletedListener completedListener = this.listener;
        if (completedListener != null) {
            completedListener.completed(bundle);
        }
    }

    private final void sendMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
        String str = this.nonce;
        if (str != null) {
            bundle.putString(NativeProtocol.EXTRA_NONCE, str);
        }
        populateRequestBundle(bundle);
        Message obtain = Message.obtain((Handler) null, this.requestMessage);
        obtain.arg1 = this.protocolVersion;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            Messenger messenger = this.sender;
            if (messenger != null) {
                messenger.send(obtain);
            }
        } catch (RemoteException unused) {
            callback(null);
        }
    }

    public final void cancel() {
        this.running = false;
    }

    @OXOo.OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @OXOo.oOoXoXO
    public final String getNonce() {
        return this.nonce;
    }

    public final void handleMessage(@OXOo.OOXIXo Message message) {
        IIX0o.x0xO0oo(message, "message");
        if (message.what == this.replyMessage) {
            Bundle data = message.getData();
            if (data.getString(NativeProtocol.STATUS_ERROR_TYPE) != null) {
                callback(null);
            } else {
                callback(data);
            }
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@OXOo.OOXIXo ComponentName name, @OXOo.OOXIXo IBinder service) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(service, "service");
        this.sender = new Messenger(service);
        sendMessage();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@OXOo.OOXIXo ComponentName name) {
        IIX0o.x0xO0oo(name, "name");
        this.sender = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        callback(null);
    }

    public abstract void populateRequestBundle(@OXOo.OOXIXo Bundle bundle);

    public final void setCompletedListener(@OXOo.oOoXoXO CompletedListener completedListener) {
        this.listener = completedListener;
    }

    public final boolean start() {
        synchronized (this) {
            boolean z = false;
            if (this.running) {
                return false;
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion) == -1) {
                return false;
            }
            Intent createPlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(getContext());
            if (createPlatformServiceIntent != null) {
                z = true;
                this.running = true;
                getContext().bindService(createPlatformServiceIntent, this, 1);
            }
            return z;
        }
    }
}
