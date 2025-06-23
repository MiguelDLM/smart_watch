package com.jd.ad.sdk.jad_xi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_gp.jad_fs;
import com.jd.ad.sdk.jad_xi.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes10.dex */
public final class jad_sf {
    public static volatile jad_sf jad_dq;
    public final jad_cp jad_an;

    @GuardedBy("this")
    public final Set<jad_cp.jad_an> jad_bo = new HashSet();

    @GuardedBy("this")
    public boolean jad_cp;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_fs.jad_bo<ConnectivityManager> {
        public final /* synthetic */ Context jad_an;

        public jad_an(jad_sf jad_sfVar, Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_gp.jad_fs.jad_bo
        public ConnectivityManager get() {
            return (ConnectivityManager) this.jad_an.getSystemService("connectivity");
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements jad_cp.jad_an {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_cp.jad_an
        public void jad_an(boolean z) {
            ArrayList arrayList;
            synchronized (jad_sf.this) {
                arrayList = new ArrayList(jad_sf.this.jad_bo);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((jad_cp.jad_an) it.next()).jad_an(z);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_cp {
        void jad_an();

        boolean jad_bo();
    }

    @RequiresApi(24)
    /* loaded from: classes10.dex */
    public static final class jad_dq implements jad_cp {
        public boolean jad_an;
        public final jad_cp.jad_an jad_bo;
        public final jad_fs.jad_bo<ConnectivityManager> jad_cp;
        public final ConnectivityManager.NetworkCallback jad_dq = new jad_an();

        /* loaded from: classes10.dex */
        public class jad_an extends ConnectivityManager.NetworkCallback {
            public jad_an() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@NonNull Network network) {
                com.jd.ad.sdk.jad_gp.jad_ly.jad_bo().post(new jad_tg(this, true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NonNull Network network) {
                com.jd.ad.sdk.jad_gp.jad_ly.jad_bo().post(new jad_tg(this, false));
            }
        }

        public jad_dq(jad_fs.jad_bo<ConnectivityManager> jad_boVar, jad_cp.jad_an jad_anVar) {
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_sf.jad_cp
        public void jad_an() {
            this.jad_cp.get().unregisterNetworkCallback(this.jad_dq);
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_sf.jad_cp
        @SuppressLint({"MissingPermission"})
        public boolean jad_bo() {
            Network activeNetwork;
            activeNetwork = this.jad_cp.get().getActiveNetwork();
            this.jad_an = activeNetwork != null;
            try {
                this.jad_cp.get().registerDefaultNetworkCallback(this.jad_dq);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Logger.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_er implements jad_cp {
        public final Context jad_an;
        public final jad_cp.jad_an jad_bo;
        public final jad_fs.jad_bo<ConnectivityManager> jad_cp;
        public boolean jad_dq;
        public final BroadcastReceiver jad_er = new jad_an();

        /* loaded from: classes10.dex */
        public class jad_an extends BroadcastReceiver {
            public jad_an() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                jad_er jad_erVar = jad_er.this;
                boolean z = jad_erVar.jad_dq;
                jad_erVar.jad_dq = jad_erVar.jad_cp();
                if (z != jad_er.this.jad_dq) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("connectivity changed, isConnected: ");
                        jad_an.append(jad_er.this.jad_dq);
                        Logger.d("ConnectivityMonitor", jad_an.toString());
                    }
                    jad_er jad_erVar2 = jad_er.this;
                    jad_erVar2.jad_bo.jad_an(jad_erVar2.jad_dq);
                }
            }
        }

        public jad_er(Context context, jad_fs.jad_bo<ConnectivityManager> jad_boVar, jad_cp.jad_an jad_anVar) {
            this.jad_an = context.getApplicationContext();
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_sf.jad_cp
        public void jad_an() {
            this.jad_an.unregisterReceiver(this.jad_er);
        }

        @Override // com.jd.ad.sdk.jad_xi.jad_sf.jad_cp
        public boolean jad_bo() {
            this.jad_dq = jad_cp();
            try {
                this.jad_an.registerReceiver(this.jad_er, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
                return true;
            } catch (SecurityException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Logger.w("ConnectivityMonitor", "Failed to register", e);
                }
                return false;
            }
        }

        @SuppressLint({"MissingPermission"})
        public boolean jad_cp() {
            try {
                NetworkInfo activeNetworkInfo = this.jad_cp.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Logger.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }

    public jad_sf(@NonNull Context context) {
        jad_fs.jad_bo jad_an2 = com.jd.ad.sdk.jad_gp.jad_fs.jad_an(new jad_an(this, context));
        jad_bo jad_boVar = new jad_bo();
        this.jad_an = Build.VERSION.SDK_INT >= 24 ? new jad_dq(jad_an2, jad_boVar) : new jad_er(context, jad_an2, jad_boVar);
    }

    public static jad_sf jad_an(@NonNull Context context) {
        if (jad_dq == null) {
            synchronized (jad_sf.class) {
                try {
                    if (jad_dq == null) {
                        jad_dq = new jad_sf(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return jad_dq;
    }
}
