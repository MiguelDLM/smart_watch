package com.realsil.sdk.core.bluetooth;

import XXO0.oIX0oI;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.impl.BluetoothAdapterImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class RtkBluetoothManager {
    public static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
    public static final int INDICATOR_ACL = 2;
    public static final int INDICATOR_BOND = 4;
    public static final int INDICATOR_BT = 1;
    public static final int INDICATOR_FULL = 255;
    public static RtkBluetoothManager k;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19483a;
    public boolean b;
    public Context c;
    public List<RtkBluetoothManagerCallback> d;
    public BluetoothAdapter e;
    public BluetoothBroadcastReceiver f = null;
    public Object g = new Object();
    public Object h = new Object();
    public boolean i = false;
    public final a j = new a();

    /* loaded from: classes11.dex */
    public class BluetoothBroadcastReceiver extends BroadcastReceiver {
        public BluetoothBroadcastReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Type inference failed for: r9v14, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public final void onReceive(Context context, Intent intent) {
            char c;
            String action = intent.getAction();
            action.getClass();
            switch (action.hashCode()) {
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -301431627:
                    if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -223687943:
                    if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1546533238:
                    if (action.equals(BluetoothAdapterImpl.ACTION_BLE_ACL_CONNECTED)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1652078734:
                    if (action.equals(BluetoothAdapterImpl.ACTION_BLE_ACL_DISCONNECTED)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1821585647:
                    if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2116862345:
                    if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    RtkBluetoothManager rtkBluetoothManager = RtkBluetoothManager.this;
                    rtkBluetoothManager.getClass();
                    String action2 = intent.getAction();
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    ZLogger.d(String.format(Locale.US, "action=%s, state: %d->%d", action2, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                    switch (intExtra) {
                        case 10:
                            if (rtkBluetoothManager.f19483a) {
                                ZLogger.v("ACTION_STATE_CHANGED: STATE_OFF");
                            }
                            synchronized (rtkBluetoothManager.h) {
                                rtkBluetoothManager.h.notifyAll();
                                break;
                            }
                        case 11:
                            if (rtkBluetoothManager.f19483a) {
                                ZLogger.v("ACTION_STATE_CHANGED: STATE_TURNING_ON");
                                break;
                            }
                            break;
                        case 12:
                            if (rtkBluetoothManager.f19483a) {
                                ZLogger.v("ACTION_STATE_CHANGED: STATE_ON");
                            }
                            synchronized (rtkBluetoothManager.g) {
                                rtkBluetoothManager.g.notifyAll();
                            }
                            break;
                        case 13:
                            if (rtkBluetoothManager.f19483a) {
                                ZLogger.v("ACTION_STATE_CHANGED: STATE_TURNING_OFF");
                                break;
                            }
                            break;
                        default:
                            if (rtkBluetoothManager.f19483a) {
                                ZLogger.v("ACTION_STATE_CHANGED: " + intExtra);
                                break;
                            }
                            break;
                    }
                    ?? r9 = rtkBluetoothManager.d;
                    if (r9 != 0) {
                        Iterator it = r9.iterator();
                        while (it.hasNext()) {
                            ((RtkBluetoothManagerCallback) it.next()).onBluetoothStateChanged(intExtra);
                        }
                        return;
                    }
                    return;
                case 1:
                    RtkBluetoothManager.e(RtkBluetoothManager.this, intent);
                    return;
                case 2:
                    RtkBluetoothManager.c(RtkBluetoothManager.this, intent);
                    return;
                case 3:
                    RtkBluetoothManager.a(RtkBluetoothManager.this, intent);
                    return;
                case 4:
                    RtkBluetoothManager.b(RtkBluetoothManager.this, intent);
                    return;
                case 5:
                    RtkBluetoothManager.f(RtkBluetoothManager.this, intent);
                    return;
                case 6:
                    RtkBluetoothManager.d(RtkBluetoothManager.this, intent);
                    return;
                default:
                    ZLogger.d("action:" + action);
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ZLogger.d("scan delay time reached");
            RtkBluetoothManager.this.b();
        }
    }

    public RtkBluetoothManager(Context context) {
        this.f19483a = false;
        this.b = false;
        this.c = context.getApplicationContext();
        this.f19483a = RtkCore.DEBUG;
        this.b = RtkCore.VDBG;
        a();
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void a(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            return;
        }
        if (rtkBluetoothManager.f19483a) {
            ZLogger.d(String.format(Locale.US, "%s: action=%s", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction()));
        }
        ?? r6 = rtkBluetoothManager.d;
        if (r6 != 0) {
            Iterator it = r6.iterator();
            while (it.hasNext()) {
                ((RtkBluetoothManagerCallback) it.next()).onBleAclConnectionStateChanged(bluetoothDevice, true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void b(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            return;
        }
        if (rtkBluetoothManager.f19483a) {
            ZLogger.d(String.format(Locale.US, "%s: action=%s", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction()));
        }
        ?? r6 = rtkBluetoothManager.d;
        if (r6 != 0) {
            Iterator it = r6.iterator();
            while (it.hasNext()) {
                ((RtkBluetoothManagerCallback) it.next()).onBleAclConnectionStateChanged(bluetoothDevice, false);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void c(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
            if (rtkBluetoothManager.f19483a) {
                ZLogger.d(String.format(Locale.US, "%s: action=%s", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction()));
                ZLogger.v("android.bluetooth.device.extra.PAIRING_VARIANT>> " + BluetoothDeviceImpl.pairingVariantToString(intExtra) + " (" + intExtra + oIX0oI.I0Io.f4095I0Io);
            }
            ?? r7 = rtkBluetoothManager.d;
            if (r7 != 0) {
                Iterator it = r7.iterator();
                while (it.hasNext()) {
                    ((RtkBluetoothManagerCallback) it.next()).onPairingRequestNotify(bluetoothDevice, intExtra);
                }
            }
            if (bluetoothDevice.getBondState() == 12) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("device already bonded: ");
                a2.append(BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true));
                ZLogger.d(a2.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void d(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        int intExtra3 = intent.getIntExtra(EXTRA_REASON, -1);
        if (bluetoothDevice != null) {
            ZLogger.d(String.format(Locale.US, "%s: action=%s, bondState:%d->%d, reason=%d", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction(), Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3)));
            ?? r10 = rtkBluetoothManager.d;
            if (r10 != 0) {
                Iterator it = r10.iterator();
                while (it.hasNext()) {
                    ((RtkBluetoothManagerCallback) it.next()).onBondStateChanged(bluetoothDevice, intExtra2);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void e(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            if (rtkBluetoothManager.f19483a) {
                ZLogger.d(String.format(Locale.US, "%s: action=%s", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction()));
            }
            ?? r6 = rtkBluetoothManager.d;
            if (r6 != 0) {
                Iterator it = r6.iterator();
                while (it.hasNext()) {
                    ((RtkBluetoothManagerCallback) it.next()).onAclConnectionStateChanged(bluetoothDevice, true);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void f(RtkBluetoothManager rtkBluetoothManager, Intent intent) {
        rtkBluetoothManager.getClass();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            if (rtkBluetoothManager.f19483a) {
                ZLogger.d(String.format(Locale.US, "%s: action=%s", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), intent.getAction()));
            }
            ?? r6 = rtkBluetoothManager.d;
            if (r6 != 0) {
                Iterator it = r6.iterator();
                while (it.hasNext()) {
                    ((RtkBluetoothManagerCallback) it.next()).onAclConnectionStateChanged(bluetoothDevice, false);
                }
            }
        }
    }

    public static RtkBluetoothManager getInstance() {
        return k;
    }

    public static void initial(Context context) {
        if (k == null) {
            synchronized (RtkBluetoothManager.class) {
                try {
                    if (k == null) {
                        k = new RtkBluetoothManager(context);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void addManagerCallback(RtkBluetoothManagerCallback rtkBluetoothManagerCallback) {
        if (this.d == null) {
            this.d = new CopyOnWriteArrayList();
        }
        if (!this.d.contains(rtkBluetoothManagerCallback)) {
            this.d.add(rtkBluetoothManagerCallback);
        }
    }

    public void close() {
        ZLogger.v(this.f19483a, "close()");
        Context context = this.c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f);
            } catch (Exception e) {
                ZLogger.e(e.toString());
            }
        }
    }

    public boolean createBond(byte[] bArr) {
        return createBond(BluetoothHelper.convertMac(bArr));
    }

    public boolean isBleEnabled() {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isBleSupported() {
        return this.c.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    @TargetApi(19)
    public boolean pair(byte[] bArr) {
        if (this.e == null) {
            return false;
        }
        byte[] bArr2 = {bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]};
        if (this.f19483a) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("createBondMac=");
            a2.append(BluetoothHelper.formatAddress(bArr, true));
            ZLogger.d(a2.toString());
        }
        BluetoothDevice remoteDevice = this.e.getRemoteDevice(bArr2);
        int bondState = remoteDevice.getBondState();
        if (this.b) {
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("attempt to createBond, state=");
            a3.append(Integer.toString(bondState));
            ZLogger.d(a3.toString());
        }
        return remoteDevice.createBond();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void removeManagerCallback(RtkBluetoothManagerCallback rtkBluetoothManagerCallback) {
        ?? r0 = this.d;
        if (r0 != 0) {
            r0.remove(rtkBluetoothManagerCallback);
        }
    }

    public boolean reset() {
        b();
        unBondAllDevices();
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter == null) {
            ZLogger.w("BT is not initialized");
            return false;
        }
        if (bluetoothAdapter.isEnabled()) {
            this.i = true;
            if (this.b) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("isNeedAutoEnableBt=");
                a2.append(this.i);
                ZLogger.v(a2.toString());
            }
        }
        return false;
    }

    public void setInterruptPairRequest(boolean z) {
    }

    public boolean startDiscovery(int i) {
        return startDiscovery(i, null);
    }

    public boolean unBondAllDevices() {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            Set<BluetoothDevice> bondedDevices = this.e.getBondedDevices();
            if (bondedDevices != null && bondedDevices.size() > 0) {
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    int i = 0;
                    while (true) {
                        if (i >= 10) {
                            break;
                        }
                        int bondState = bluetoothDevice.getBondState();
                        if (bondState == 10) {
                            boolean z = this.f19483a;
                            StringBuilder a2 = com.realsil.sdk.core.a.a.a("already unbond: ");
                            a2.append(bluetoothDevice.getName());
                            ZLogger.d(z, a2.toString());
                            break;
                        }
                        if (bondState == 11) {
                            boolean cancelBondProcess = BluetoothDeviceImpl.cancelBondProcess(bluetoothDevice);
                            if (this.f19483a) {
                                ZLogger.v(String.format(Locale.US, "cancelBondProcess(%d): %s, ret=%b", Integer.valueOf(i), BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), Boolean.valueOf(cancelBondProcess)));
                            }
                            if (cancelBondProcess) {
                                break;
                            }
                            i++;
                        } else {
                            if (bondState == 12) {
                                boolean removeBond = BluetoothDeviceImpl.removeBond(bluetoothDevice);
                                if (this.f19483a) {
                                    ZLogger.v(String.format(Locale.US, "removeBond(%d): %s, ret=%b", Integer.valueOf(i), BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), Boolean.valueOf(removeBond)));
                                }
                                if (removeBond) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                            i++;
                        }
                    }
                }
                return true;
            }
            ZLogger.d("no bond device exist");
            return true;
        }
        ZLogger.w("bluetooth is not enabled");
        return false;
    }

    public boolean unBondDevice(byte[] bArr) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            String convertMac = BluetoothHelper.convertMac(bArr);
            Set<BluetoothDevice> bondedDevices = this.e.getBondedDevices();
            if (bondedDevices != null && bondedDevices.size() > 0) {
                Iterator<BluetoothDevice> it = bondedDevices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BluetoothDevice next = it.next();
                    if (convertMac.compareToIgnoreCase(next.getAddress()) == 0) {
                        while (true) {
                            int bondState = next.getBondState();
                            if (bondState == 10) {
                                break;
                            }
                            if (bondState == 11) {
                                BluetoothDeviceImpl.cancelBondProcess(next);
                            }
                            if (this.f19483a) {
                                StringBuilder a2 = com.realsil.sdk.core.a.a.a("unBondDevice: ");
                                a2.append(BluetoothHelper.formatAddress(convertMac, true));
                                ZLogger.d(a2.toString());
                            }
                            boolean removeBond = BluetoothDeviceImpl.removeBond(next);
                            if (this.f19483a) {
                                ZLogger.d("removeBond finished:" + removeBond);
                            }
                        }
                    }
                }
            }
            return true;
        }
        if (this.f19483a) {
            ZLogger.d("bluetooth is not enabled");
            return false;
        }
        return false;
    }

    public boolean createBond(String str) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            if (this.f19483a) {
                ZLogger.d("bluetooth is not enabled");
            }
            return false;
        }
        if (str == null) {
            if (this.f19483a) {
                ZLogger.d("mac cannot be null");
            }
            return false;
        }
        if (this.f19483a) {
            ZLogger.d("createBondMac=" + str);
        }
        BluetoothDevice remoteDevice = this.e.getRemoteDevice(str);
        int bondState = remoteDevice.getBondState();
        if (bondState == 12) {
            ZLogger.d("device already bonded: " + bondState);
            return true;
        }
        if (this.f19483a) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("attempt to createBond, state=");
            a2.append(Integer.toString(bondState));
            ZLogger.d(a2.toString());
        }
        return BluetoothDeviceImpl.createBond(remoteDevice);
    }

    public boolean startDiscovery(int i, String str) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            if (this.e.isDiscovering()) {
                this.e.cancelDiscovery();
            }
            if (this.f19483a) {
                ZLogger.d("address=" + str + " , timeout=" + i);
            }
            this.e.startDiscovery();
            return true;
        }
        ZLogger.w("bluetooth is not supported or disabled");
        return false;
    }

    public final boolean a() {
        Context context = this.c;
        if (context == null) {
            ZLogger.w("not intialized");
            return false;
        }
        if (this.e == null) {
            BluetoothAdapter a2 = com.realsil.sdk.core.b.a.a(context);
            this.e = a2;
            if (a2 == null) {
                ZLogger.w("Unable to obtain a BluetoothAdapter.");
                return false;
            }
        }
        if (this.e == null) {
            ZLogger.w("mBluetoothAdapter == null");
            return true;
        }
        this.f = new BluetoothBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction(BluetoothAdapterImpl.ACTION_BLE_ACL_CONNECTED);
        intentFilter.addAction(BluetoothAdapterImpl.ACTION_BLE_ACL_DISCONNECTED);
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        this.c.registerReceiver(this.f, intentFilter);
        return true;
    }

    public final boolean b() {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            ZLogger.w("bluetooth is not supported or disabled");
        }
        if (!this.e.isDiscovering()) {
            return true;
        }
        if (this.f19483a) {
            ZLogger.d("stopInquiry()");
        }
        return this.e.cancelDiscovery();
    }
}
