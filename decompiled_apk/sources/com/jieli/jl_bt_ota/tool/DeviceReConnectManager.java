package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.ExoPlayer;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.constant.JL_Constant;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.ReConnectDevMsg;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.jl_bt_ota.util.ParseDataUtil;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class DeviceReConnectManager {
    public static long RECONNECT_TIMEOUT = 65000;
    private static final String h = "DeviceReConnectManager";
    private static final int i = 3000;
    private static final int j = 20000;
    private static final int k = 2;
    private static final int l = 30000;
    private static final int m = 2000;
    private static final int n = 37973;
    private static final int o = 37974;
    private static final int p = 37975;

    /* renamed from: a, reason: collision with root package name */
    private final Context f17746a;
    private final BluetoothOTAManager b;
    private volatile ReConnectDevMsg c;
    private long d = 0;
    private final Map<String, BleScanMessage> e = new HashMap();
    private final Handler f = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_bt_ota.tool.DeviceReConnectManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            switch (message.what) {
                case DeviceReConnectManager.n /* 37973 */:
                    DeviceReConnectManager.this.b();
                    return true;
                case DeviceReConnectManager.o /* 37974 */:
                    JL_Log.w(DeviceReConnectManager.h, "MSG_RECONNECT_DEVICE_TIMEOUT", "" + DeviceReConnectManager.this.c);
                    if (DeviceReConnectManager.this.c != null) {
                        DeviceReConnectManager.this.c.setState(0);
                        DeviceReConnectManager deviceReConnectManager = DeviceReConnectManager.this;
                        deviceReConnectManager.a(OTAError.buildError(ErrorCode.SUB_ERR_RECONNECT_TIMEOUT, deviceReConnectManager.c.toString()));
                        return true;
                    }
                    return true;
                case DeviceReConnectManager.p /* 37975 */:
                    JL_Log.w(DeviceReConnectManager.h, "MSG_CONNECT_DEVICE_TIMEOUT", "" + DeviceReConnectManager.this.c);
                    if (DeviceReConnectManager.this.c != null) {
                        DeviceReConnectManager.this.c.setState(0);
                        DeviceReConnectManager deviceReConnectManager2 = DeviceReConnectManager.this;
                        deviceReConnectManager2.a(deviceReConnectManager2.c.getAddress());
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
    });
    private final BtEventCallback g;

    public DeviceReConnectManager(@NonNull Context context, @NonNull BluetoothOTAManager bluetoothOTAManager) {
        BtEventCallback btEventCallback = new BtEventCallback() { // from class: com.jieli.jl_bt_ota.tool.DeviceReConnectManager.2
            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onAdapterStatus(boolean z, boolean z2) {
                if (!z && DeviceReConnectManager.this.isDeviceReconnecting()) {
                    JL_Log.d(DeviceReConnectManager.h, "onAdapterStatus", "bluetooth is off.");
                }
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onConnection(BluetoothDevice bluetoothDevice, int i2) {
                boolean z;
                byte[] bArr;
                if (bluetoothDevice != null && DeviceReConnectManager.this.isDeviceReconnecting() && i2 != 3) {
                    if (!DeviceReConnectManager.this.f.hasMessages(DeviceReConnectManager.p) && !DeviceReConnectManager.this.f()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    JL_Log.d(DeviceReConnectManager.h, "onConnection", "isConnecting: " + z + ", status = " + i2);
                    if (!z) {
                        return;
                    }
                    BleScanMessage bleScanMessage = (BleScanMessage) DeviceReConnectManager.this.e.get(bluetoothDevice.getAddress());
                    if (bleScanMessage != null) {
                        JL_Log.d(DeviceReConnectManager.h, "onConnection", "bleScanMessage: " + bleScanMessage);
                        bArr = bleScanMessage.getRawData();
                    } else {
                        bArr = null;
                    }
                    boolean a2 = DeviceReConnectManager.this.a(bluetoothDevice, bArr);
                    JL_Log.w(DeviceReConnectManager.h, "onConnection", CommonUtil.formatString("device : %s, status : %d, isReConnectDevice : %s", DeviceReConnectManager.this.b(bluetoothDevice), Integer.valueOf(i2), Boolean.valueOf(a2)));
                    if (!a2) {
                        return;
                    }
                    if (DeviceReConnectManager.this.c != null) {
                        DeviceReConnectManager.this.c.setState(0);
                    }
                    DeviceReConnectManager.this.f.removeMessages(DeviceReConnectManager.p);
                    if (i2 != 1 && i2 != 4) {
                        if (i2 == 2 || i2 == 0) {
                            JL_Log.i(DeviceReConnectManager.h, "onConnection", "connect device failed.");
                            DeviceReConnectManager.this.a(bluetoothDevice.getAddress());
                            return;
                        }
                        return;
                    }
                    JL_Log.d(DeviceReConnectManager.h, "onConnection", "reconnect device success.");
                    DeviceReConnectManager.this.stopReconnectTask();
                }
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
                byte[] bArr;
                if (bluetoothDevice != null && DeviceReConnectManager.this.isDeviceReconnecting()) {
                    if (bleScanMessage != null) {
                        DeviceReConnectManager.this.e.put(bluetoothDevice.getAddress(), bleScanMessage);
                        bArr = bleScanMessage.getRawData();
                    } else {
                        bArr = null;
                    }
                    boolean a2 = DeviceReConnectManager.this.a(bluetoothDevice, bArr);
                    JL_Log.d(DeviceReConnectManager.h, "onDiscovery", CommonUtil.formatString("isReConnectDevice : %s, device : %s", Boolean.valueOf(a2), DeviceReConnectManager.this.b(bluetoothDevice)));
                    if (a2) {
                        DeviceReConnectManager.this.a(bluetoothDevice);
                        DeviceReConnectManager.this.g();
                    }
                }
            }

            @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
            public void onDiscoveryStatus(boolean z, boolean z2) {
                JL_Log.d(DeviceReConnectManager.h, "onDiscoveryStatus", "bStart : " + z2);
                if (DeviceReConnectManager.this.isDeviceReconnecting() && !DeviceReConnectManager.this.f()) {
                    if (z2) {
                        if (DeviceReConnectManager.this.c != null && DeviceReConnectManager.this.c.getState() == 0) {
                            DeviceReConnectManager.this.c.setState(1);
                            return;
                        }
                        return;
                    }
                    JL_Log.d(DeviceReConnectManager.h, "onDiscoveryStatus", "ready start scan");
                    DeviceReConnectManager.this.f.removeMessages(DeviceReConnectManager.n);
                    DeviceReConnectManager.this.f.sendEmptyMessageDelayed(DeviceReConnectManager.n, 1000L);
                }
            }
        };
        this.g = btEventCallback;
        this.f17746a = context;
        this.b = bluetoothOTAManager;
        bluetoothOTAManager.registerBluetoothCallback(btEventCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        JL_Log.d(h, "stopScan", "---->");
        this.b.stopBLEScan();
        this.b.stopDeviceScan();
    }

    public String getReconnectAddress() {
        ReConnectDevMsg e = e();
        if (e == null) {
            return null;
        }
        return e.getAddress();
    }

    public boolean isDeviceReconnecting() {
        return this.f.hasMessages(o);
    }

    public boolean isWaitingForUpdate() {
        if (e() != null) {
            return true;
        }
        return false;
    }

    public void release() {
        setReConnectDevMsg(null);
        stopReconnectTask();
        this.b.unregisterBluetoothCallback(this.g);
        this.f.removeCallbacksAndMessages(null);
    }

    public void setReConnectDevMsg(ReConnectDevMsg reConnectDevMsg) {
        if (this.c != reConnectDevMsg) {
            this.c = reConnectDevMsg;
            this.e.clear();
            JL_Log.d(h, "setReConnectDevMsg", "" + reConnectDevMsg);
        }
    }

    public void setReconnectAddress(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            setReConnectDevMsg(null);
            return;
        }
        if (this.c == null) {
            setReConnectDevMsg(new ReConnectDevMsg(this.b.getBluetoothOption().getPriority(), str));
            return;
        }
        this.c.setAddress(str);
        JL_Log.d(h, "setReconnectAddress", "" + this.c);
    }

    public void setReconnectUseADV(boolean z) {
        if (this.c != null) {
            this.c.setUseADV(z);
        }
    }

    public void startReconnectTask() {
        if (!isDeviceReconnecting()) {
            String str = h;
            JL_Log.i(str, "startReconnectTask", "start....");
            a(c());
            JL_Log.i(str, "startReconnectTask", "timeout = " + RECONNECT_TIMEOUT);
            this.f.sendEmptyMessageDelayed(o, RECONNECT_TIMEOUT);
            this.f.sendEmptyMessage(n);
        }
    }

    public void stopReconnectTask() {
        boolean isDeviceReconnecting = isDeviceReconnecting();
        boolean isWaitingForUpdate = isWaitingForUpdate();
        JL_Log.i(h, "stopReconnectTask", "isReconnecting : " + isDeviceReconnecting + ", isWaitingForUpdate : " + isWaitingForUpdate);
        a(0L);
        setReConnectDevMsg(null);
        g();
        this.f.removeCallbacksAndMessages(null);
    }

    private long c() {
        return Calendar.getInstance().getTimeInMillis();
    }

    private long d() {
        long c = RECONNECT_TIMEOUT - (c() - this.d);
        if (c < 0) {
            return 0L;
        }
        return c;
    }

    private ReConnectDevMsg e() {
        if (this.c == null) {
            return null;
        }
        return this.c.cloneObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return e() != null && e().getState() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int startBLEScan;
        ReConnectDevMsg e = e();
        if (e == null) {
            JL_Log.w(h, "doReconnectTask", "reConnectDevMsg is null.");
            stopReconnectTask();
            return;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(h, "doReconnectTask", "Bluetooth is close.");
            this.f.removeMessages(n);
            this.f.sendEmptyMessageDelayed(n, 3000L);
            return;
        }
        if (e.getState() == 2) {
            JL_Log.w(h, "doReconnectTask", "Task is connecting. " + e);
            if (this.f.hasMessages(p)) {
                return;
            }
            this.f.sendEmptyMessageDelayed(p, 30000L);
            return;
        }
        boolean isConnectedDevice = this.b.isConnectedDevice();
        String str = h;
        JL_Log.i(str, "doReconnectTask", e + ", isDevConnected : " + isConnectedDevice);
        if (isConnectedDevice) {
            JL_Log.i(str, "doReconnectTask", "device is connected. " + e + ", device = " + this.b.getConnectedDevice());
            return;
        }
        BluetoothDevice b = b(e.getAddress());
        JL_Log.w(str, "doReconnectTask", "connectedDevice : " + b(b));
        if (b != null) {
            a(b);
            return;
        }
        if (e.isUseADV() && e.getWay() != 0) {
            e.setWay(0);
        }
        if (this.b.isScanning()) {
            int scanType = this.b.getScanType();
            boolean z = scanType == 2;
            if (!z) {
                z = (e.getWay() == 1 && scanType == 1) || (e.getWay() == 0 && scanType == 0);
            }
            JL_Log.i(str, "doReconnectTask", "isScanOk : " + z + ", scanType = " + scanType);
            if (z) {
                return;
            }
            g();
            SystemClock.sleep(100L);
        }
        long d = d();
        JL_Log.d(str, "doReconnectTask", "leftTime ： " + d + ", beginTaskTime : " + this.d);
        if (d < RECONNECT_TIMEOUT - 40000 && !e.isUseADV()) {
            int i2 = e.getWay() == 1 ? 0 : 2;
            long j2 = d - 3000;
            if (j2 > 0) {
                d = j2;
            }
            startBLEScan = this.b.startDeviceScan(d, i2);
            JL_Log.i(str, "doReconnectTask", "startDeviceScan : " + startBLEScan + ", way = " + i2 + ", timeout = " + d);
        } else {
            long min = Math.min(d, 20000L);
            if (e.getWay() == 1) {
                startBLEScan = this.b.startDeviceScan(min, 1);
                JL_Log.i(str, "doReconnectTask", "startDeviceScan : " + startBLEScan + ", scanTime = " + min);
            } else {
                startBLEScan = this.b.startBLEScan(min);
                JL_Log.i(str, "doReconnectTask", "startBLEScan : " + startBLEScan + ", scanTime = " + min);
            }
        }
        if (startBLEScan != 0) {
            this.f.removeMessages(n);
            this.f.sendEmptyMessageDelayed(n, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        ReConnectDevMsg e;
        if (bluetoothDevice == null || (e = e()) == null) {
            return false;
        }
        String address = e.getAddress();
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return false;
        }
        String str = h;
        JL_Log.d(str, "checkIsReconnectDevice", "device : " + b(bluetoothDevice));
        if (!e.isUseADV()) {
            return address.equals(bluetoothDevice.getAddress());
        }
        JL_Log.d(str, "checkIsReconnectDevice", "advertiseRawData : " + CHexConver.byte2HexStr(bArr));
        BleScanMessage parseOTAFlagFilterWithBroad = ParseDataUtil.parseOTAFlagFilterWithBroad(bArr, JL_Constant.OTA_IDENTIFY);
        if (parseOTAFlagFilterWithBroad == null) {
            return false;
        }
        JL_Log.d(str, "checkIsReconnectDevice", "" + parseOTAFlagFilterWithBroad);
        return address.equalsIgnoreCase(parseOTAFlagFilterWithBroad.getOldBleAddress());
    }

    private void a(long j2) {
        this.d = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice) {
        String str = h;
        JL_Log.d(str, "connectBtDevice", this.c + ", device : " + bluetoothDevice);
        if (this.c == null || this.c.getState() == 2) {
            return;
        }
        this.c.setState(2);
        long d = d();
        JL_Log.i(str, "connectBtDevice", "left time = " + d);
        if (d <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.f.removeMessages(o);
            this.f.sendEmptyMessageDelayed(o, 31000L);
            JL_Log.i(str, "connectBtDevice", "reset time >>> ");
        }
        this.f.removeMessages(p);
        this.f.sendEmptyMessageDelayed(p, 30000L);
        this.b.connectBluetoothDevice(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseError baseError) {
        if (baseError == null) {
            return;
        }
        if (this.b.isOTA()) {
            this.b.errorEventCallback(baseError);
        }
        stopReconnectTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        long d = d();
        String str2 = h;
        JL_Log.d(str2, "dealWithConnectFailed", "address : " + str + ", Left Time = " + d);
        if (d <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            JL_Log.i(str2, "dealWithConnectFailed", "time not enough.");
            a(OTAError.buildError(ErrorCode.SUB_ERR_RECONNECT_FAILED, str));
        } else {
            JL_Log.i(str2, "dealWithConnectFailed", "resume reconnect task.");
            this.f.removeMessages(n);
            this.f.sendEmptyMessage(n);
        }
    }

    private BluetoothDevice b(String str) {
        List<BluetoothDevice> systemConnectedBtDeviceList;
        if (BluetoothAdapter.checkBluetoothAddress(str) && (systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.f17746a)) != null && !systemConnectedBtDeviceList.isEmpty()) {
            for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
                if (str.equals(bluetoothDevice.getAddress())) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.f17746a, bluetoothDevice);
    }
}
