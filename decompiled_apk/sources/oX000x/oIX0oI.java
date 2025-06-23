package oX000x;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public ConnectivityManager f32070I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public List<I0Io> f32071II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @TargetApi(21)
    public ConnectivityManager.NetworkCallback f32072Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f32073X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final BroadcastReceiver f32074XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f32075oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f32076oxoX;

    /* loaded from: classes13.dex */
    public interface I0Io {
        void oIX0oI(int i);
    }

    /* loaded from: classes13.dex */
    public class II0xO0 extends ConnectivityManager.NetworkCallback {
        public II0xO0() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    oIX0oI.this.f32073X0o0xo = 1;
                } else if (networkCapabilities.hasTransport(0)) {
                    oIX0oI.this.oxoX();
                } else if (networkCapabilities.hasTransport(3)) {
                    oIX0oI.this.f32073X0o0xo = 9;
                }
            }
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + oIX0oI.this.f32073X0o0xo + ", prevType = " + oIX0oI.this.f32076oxoX);
            }
            oIX0oI oix0oi = oIX0oI.this;
            if (oix0oi.f32076oxoX != oix0oi.f32073X0o0xo) {
                oix0oi.I0Io();
                oIX0oI oix0oi2 = oIX0oI.this;
                oix0oi2.f32076oxoX = oix0oi2.f32073X0o0xo;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "onLost: currentType = " + oIX0oI.this.f32073X0o0xo + ", prev = " + oIX0oI.this.f32076oxoX + ", network = " + network);
            }
            oIX0oI.this.oxoX();
            oIX0oI oix0oi = oIX0oI.this;
            if (oix0oi.f32076oxoX != oix0oi.f32073X0o0xo) {
                oix0oi.I0Io();
                oIX0oI oix0oi2 = oIX0oI.this;
                oix0oi2.f32076oxoX = oix0oi2.f32073X0o0xo;
            }
        }
    }

    /* renamed from: oX000x.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1128oIX0oI extends BroadcastReceiver {
        public C1128oIX0oI() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "onReceive: action = " + action);
            }
            if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                oIX0oI.this.oxoX();
                oIX0oI oix0oi = oIX0oI.this;
                if (oix0oi.f32076oxoX != oix0oi.f32073X0o0xo) {
                    oix0oi.I0Io();
                    oIX0oI oix0oi2 = oIX0oI.this;
                    oix0oi2.f32076oxoX = oix0oi2.f32073X0o0xo;
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oIX0oI f32079oIX0oI = new oIX0oI(0);
    }

    public /* synthetic */ oIX0oI(byte b) {
        this();
    }

    public synchronized void I0Io() {
        try {
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "notifyNetworkStateChanged: mPrevNetworkType = " + this.f32076oxoX + ", mCurrentNetworkType = " + this.f32073X0o0xo);
            }
            Iterator<I0Io> it = this.f32071II0xO0.iterator();
            while (it.hasNext()) {
                it.next().oIX0oI(this.f32073X0o0xo);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean II0xO0() {
        if (this.f32073X0o0xo != -1) {
            return true;
        }
        return false;
    }

    public final void X0o0xo() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkRequest build = new NetworkRequest.Builder().build();
                if (this.f32072Oxx0IOOO == null) {
                    this.f32072Oxx0IOOO = new II0xO0();
                }
                this.f32070I0Io.registerNetworkCallback(build, this.f32072Oxx0IOOO);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f32075oIX0oI.registerReceiver(this.f32074XO, intentFilter);
        } catch (Throwable th) {
            XOxoX.oIX0oI.II0xO0("NetworkStateObserver", "registerNetworkState exception.", th);
        }
    }

    public synchronized void oIX0oI(I0Io i0Io) {
        try {
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "addNetworkChangeListener: listener = " + i0Io);
            }
            this.f32071II0xO0.add(i0Io);
            i0Io.oIX0oI(this.f32073X0o0xo);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void oxoX() {
        NetworkInfo networkInfo;
        try {
            networkInfo = this.f32070I0Io.getActiveNetworkInfo();
        } catch (Exception e) {
            XOxoX.oIX0oI.II0xO0("NetworkStateObserver", "getActiveNetworkType exception.", e);
            networkInfo = null;
        }
        if (networkInfo == null) {
            this.f32073X0o0xo = -1;
            if (XOxoX.oIX0oI.f3985oIX0oI) {
                XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "getActiveNetworkType with null network info.");
                return;
            }
            return;
        }
        if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
            this.f32073X0o0xo = 1;
        } else if (networkInfo.getType() == 0 && networkInfo.isConnected()) {
            this.f32073X0o0xo = 0;
        } else if (networkInfo.getType() == 9 && networkInfo.isConnected()) {
            this.f32073X0o0xo = 9;
        } else {
            this.f32073X0o0xo = -1;
        }
        if (XOxoX.oIX0oI.f3985oIX0oI) {
            XOxoX.oIX0oI.oIX0oI("NetworkStateObserver", "getActiveNetworkType: mPrevNetworkType = " + this.f32076oxoX + ", mCurrentNetworkType = " + this.f32073X0o0xo + ", networkInfo = " + networkInfo);
        }
    }

    public oIX0oI() {
        this.f32076oxoX = -1;
        this.f32073X0o0xo = -1;
        this.f32074XO = new C1128oIX0oI();
        this.f32075oIX0oI = xIx.I0Io.I0Io().X0o0xo();
        this.f32071II0xO0 = new LinkedList();
        try {
            this.f32070I0Io = (ConnectivityManager) this.f32075oIX0oI.getSystemService("connectivity");
        } catch (Exception e) {
            XOxoX.oIX0oI.II0xO0("NetworkStateObserver", "get ConnectivityManager exception", e);
        }
        X0o0xo();
        oxoX();
    }
}
