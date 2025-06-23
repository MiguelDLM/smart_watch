package com.baidu.navisdk.bluetooth;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.baidu.navisdk.bluetooth.BNBluetoothAudio;
import com.baidu.navisdk.util.common.LogUtil;
import com.realsil.sdk.core.bluetooth.impl.BluetoothProfileImpl;
import java.util.List;

/* loaded from: classes7.dex */
public class b implements c {
    private static b g = null;
    public static String h = "BNBluetooth";
    private BNBluetoothReceiver b;
    private c c;
    private BNBluetoothAudio d;
    private String f;
    private int e = -1;

    /* renamed from: a, reason: collision with root package name */
    private BluetoothAdapter f6674a = BluetoothAdapter.getDefaultAdapter();

    /* loaded from: classes7.dex */
    public class a implements BluetoothProfile.ServiceListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0174b f6675a;

        public a(InterfaceC0174b interfaceC0174b) {
            this.f6675a = interfaceC0174b;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            LogUtil.e(b.h, "onServiceConnected");
            try {
                List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                if (connectedDevices != null && connectedDevices.size() > 0) {
                    LogUtil.e(b.h, "connected devices not null");
                    if (connectedDevices.size() > 1 && Build.VERSION.SDK_INT >= 28) {
                        if (bluetoothProfile instanceof BluetoothA2dp) {
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) Class.forName(BluetoothProfileImpl.CLASS_NAME_BLUETOOTH_A2DP).getMethod("getActiveDevice", null).invoke((BluetoothA2dp) bluetoothProfile, null);
                            b.this.f = bluetoothDevice.getName();
                        }
                    } else {
                        b.this.f = connectedDevices.get(0).getName();
                    }
                    this.f6675a.a(b.this.f);
                    return;
                }
                this.f6675a.onFail();
            } catch (Exception unused) {
                this.f6675a.onFail();
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            LogUtil.e(b.h, "onServiceDisconnected");
            this.f6675a.onFail();
        }
    }

    /* renamed from: com.baidu.navisdk.bluetooth.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0174b {
        void a(String str);

        void onFail();
    }

    private b() {
    }

    public static b i() {
        if (g == null) {
            synchronized (b.class) {
                try {
                    if (g == null) {
                        g = new b();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    private void j() {
        BNBluetoothReceiver bNBluetoothReceiver = new BNBluetoothReceiver();
        this.b = bNBluetoothReceiver;
        bNBluetoothReceiver.a(this);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED");
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            if (a2 != null) {
                a2.registerReceiver(this.b, intentFilter);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
    }

    private void k() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null) {
            a2.unregisterReceiver(this.b);
        }
        this.b = null;
        this.c = null;
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void b() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }

    public String d() {
        String str = this.f;
        if (str == null) {
            return "";
        }
        return str;
    }

    public void e() {
        this.d = new BNBluetoothAudio(com.baidu.navisdk.framework.a.c().a());
        j();
    }

    public boolean f() {
        BluetoothAdapter bluetoothAdapter = this.f6674a;
        if (bluetoothAdapter == null) {
            return false;
        }
        try {
            int profileConnectionState = bluetoothAdapter.getProfileConnectionState(2);
            int profileConnectionState2 = this.f6674a.getProfileConnectionState(1);
            int profileConnectionState3 = this.f6674a.getProfileConnectionState(3);
            if (profileConnectionState == 2) {
                this.e = 2;
            } else if (profileConnectionState2 == 2) {
                this.e = 1;
            } else if (profileConnectionState3 == 2) {
                this.e = 3;
            } else {
                this.e = -1;
            }
            if (this.e != -1) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(h, "bluetooth is connected, type:" + this.e);
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void g() {
        try {
            k();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
    }

    public void h() {
        BNBluetoothAudio bNBluetoothAudio = this.d;
        if (bNBluetoothAudio != null) {
            bNBluetoothAudio.b();
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void a(boolean z, String str) {
        c cVar = this.c;
        if (cVar != null) {
            this.f = str;
            cVar.a(z, str);
        }
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void a(boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void a() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.baidu.navisdk.bluetooth.c
    public void a(String str) {
        c cVar = this.c;
        if (cVar != null) {
            this.f = str;
            cVar.a(str);
        }
    }

    public void a(int i) {
        a(i, (BNBluetoothAudio.g) null);
    }

    public void a(int i, BNBluetoothAudio.g gVar) {
        if (!f()) {
            if (gVar != null) {
                gVar.a(i);
            }
        } else {
            BNBluetoothAudio bNBluetoothAudio = this.d;
            if (bNBluetoothAudio != null) {
                bNBluetoothAudio.a(i, gVar);
            }
        }
    }

    public void a(Context context, InterfaceC0174b interfaceC0174b) {
        BluetoothAdapter bluetoothAdapter = this.f6674a;
        if (bluetoothAdapter != null && this.e != -1) {
            bluetoothAdapter.getProfileProxy(context, new a(interfaceC0174b), this.e);
        } else {
            interfaceC0174b.onFail();
        }
    }
}
