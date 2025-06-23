package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class NetworkMonitor {
    private static volatile boolean aqa = false;
    private final List<a> aqb;
    private boolean aqc;
    private final BroadcastReceiver aqd;

    /* loaded from: classes11.dex */
    public enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        Holder() {
        }

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: classes11.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: classes11.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    public /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.aqb.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    private synchronized void bc(Context context) {
        if (!aqa && context != null) {
            try {
                context.getApplicationContext().registerReceiver(this.aqd, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                aqa = true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.aqb = new CopyOnWriteArrayList();
        this.aqc = false;
        this.aqd = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if (ContextCompat.checkSelfPermission(context, g.b) != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        return;
                    }
                    if (1 == activeNetworkInfo.getType()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                    } else if (activeNetworkInfo.getType() == 0) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                    } else {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, @NonNull a aVar) {
        bc(context);
        if (this.aqb.contains(aVar)) {
            return;
        }
        this.aqb.add(aVar);
    }

    public final void a(a aVar) {
        this.aqb.remove(aVar);
    }
}
