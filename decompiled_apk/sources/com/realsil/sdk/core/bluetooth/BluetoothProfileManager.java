package com.realsil.sdk.core.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.impl.BluetoothA2dpSinkImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothHeadsetImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothInputDeviceImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothProfileImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class BluetoothProfileManager {
    public static final String CLASS_NAME_BLUETOOTH_HID_HOST = "android.bluetooth.BluetoothHidHost";
    public static final int INDICATOR_A2DP = 1;
    public static final int INDICATOR_A2DP_SINK = 2;
    public static final int INDICATOR_FULL = 255;
    public static final int INDICATOR_HEADSET = 4;
    public static final int INDICATOR_HID = 8;
    public static BluetoothProfileManager m;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19480a;
    public boolean b;
    public Context c;
    public List<BluetoothProfileCallback> d;
    public BluetoothAdapter e;
    public BluetoothHealth h;
    public BluetoothHeadset f = null;
    public BluetoothA2dp g = null;
    public BluetoothProfile i = null;
    public BluetoothProfile j = null;
    public ProfileBroadcastReceiver k = null;
    public a l = new a();

    /* loaded from: classes11.dex */
    public class ProfileBroadcastReceiver extends BroadcastReceiver {
        public ProfileBroadcastReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v13, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v18, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v22, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v27, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v32, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v37, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v4, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v41, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v46, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v51, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r13v9, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public final void onReceive(Context context, Intent intent) {
            char c;
            String action = intent.getAction();
            action.getClass();
            switch (action.hashCode()) {
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1021360715:
                    if (action.equals(BluetoothInputDeviceImpl.ACTION_CONNECTION_STATE_CHANGED)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -855499628:
                    if (action.equals("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1244161670:
                    if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1772843706:
                    if (action.equals("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT")) {
                        c = 5;
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
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice == null) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    ZLogger.d(String.format(Locale.US, "%s: action=%s, state: %d->%d", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), action, Integer.valueOf(intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                    ?? r13 = BluetoothProfileManager.this.d;
                    if (r13 != 0 && r13.size() > 0) {
                        Iterator it = BluetoothProfileManager.this.d.iterator();
                        while (it.hasNext()) {
                            ((BluetoothProfileCallback) it.next()).onHfpAudioStateChanged(bluetoothDevice, intExtra);
                        }
                        return;
                    }
                    ZLogger.v(BluetoothProfileManager.this.b, "no callback registered");
                    return;
                case 1:
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice2 == null) {
                        return;
                    }
                    ZLogger.d(String.format(Locale.US, "%s: action=%s, state: %d->%d", BluetoothHelper.formatAddress(bluetoothDevice2.getAddress(), true), action, Integer.valueOf(intExtra3), Integer.valueOf(intExtra2)));
                    ?? r132 = BluetoothProfileManager.this.d;
                    if (r132 != 0 && r132.size() > 0) {
                        Iterator it2 = BluetoothProfileManager.this.d.iterator();
                        while (it2.hasNext()) {
                            ((BluetoothProfileCallback) it2.next()).onHidStateChanged(bluetoothDevice2, intExtra2);
                        }
                        return;
                    }
                    ZLogger.v(BluetoothProfileManager.this.b, "no callback registered");
                    return;
                case 2:
                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra5 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice3 == null) {
                        return;
                    }
                    ZLogger.d(String.format(Locale.US, "%s: action=%s, state: %d->%d", BluetoothHelper.formatAddress(bluetoothDevice3.getAddress(), true), action, Integer.valueOf(intExtra5), Integer.valueOf(intExtra4)));
                    ?? r133 = BluetoothProfileManager.this.d;
                    if (r133 != 0 && r133.size() > 0) {
                        Iterator it3 = BluetoothProfileManager.this.d.iterator();
                        while (it3.hasNext()) {
                            ((BluetoothProfileCallback) it3.next()).onA2dpPlayingStateChanged(bluetoothDevice3, intExtra4);
                        }
                        return;
                    }
                    ZLogger.v(BluetoothProfileManager.this.b, "no callback registered");
                    return;
                case 3:
                    BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra6 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra7 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice4 == null) {
                        return;
                    }
                    ZLogger.d(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, BluetoothHelper.formatAddress(bluetoothDevice4.getAddress(), true), Integer.valueOf(intExtra7), Integer.valueOf(intExtra6)));
                    ?? r134 = BluetoothProfileManager.this.d;
                    if (r134 != 0 && r134.size() > 0) {
                        Iterator it4 = BluetoothProfileManager.this.d.iterator();
                        while (it4.hasNext()) {
                            ((BluetoothProfileCallback) it4.next()).onHfpConnectionStateChanged(bluetoothDevice4, intExtra6);
                        }
                        return;
                    }
                    ZLogger.v(BluetoothProfileManager.this.b, "no callback registered");
                    return;
                case 4:
                    BluetoothDevice bluetoothDevice5 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra8 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra9 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice5 == null) {
                        return;
                    }
                    ZLogger.d(String.format(Locale.US, "%s: action=%s, state: %d->%d", BluetoothHelper.formatAddress(bluetoothDevice5.getAddress(), true), action, Integer.valueOf(intExtra9), Integer.valueOf(intExtra8)));
                    ?? r135 = BluetoothProfileManager.this.d;
                    if (r135 != 0 && r135.size() > 0) {
                        Iterator it5 = BluetoothProfileManager.this.d.iterator();
                        while (it5.hasNext()) {
                            ((BluetoothProfileCallback) it5.next()).onA2dpStateChanged(bluetoothDevice5, intExtra8);
                        }
                        return;
                    }
                    ZLogger.v(BluetoothProfileManager.this.b, "no callback registered");
                    return;
                case 5:
                    BluetoothProfileManager bluetoothProfileManager = BluetoothProfileManager.this;
                    bluetoothProfileManager.getClass();
                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice6 == null) {
                        ZLogger.v("onVendorSpecificHeadsetEvent() remote device is null");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD");
                    if (stringExtra == null) {
                        ZLogger.v("onVendorSpecificHeadsetEvent() command is null");
                        return;
                    }
                    int intExtra10 = intent.getIntExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE", -1);
                    if (intExtra10 == 0 && intExtra10 == 1 && intExtra10 == 2 && intExtra10 == 3 && intExtra10 == 4) {
                        Object[] objArr = (Object[]) intent.getExtras().get("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS");
                        ?? r0 = bluetoothProfileManager.d;
                        if (r0 != 0 && r0.size() > 0) {
                            Iterator it6 = bluetoothProfileManager.d.iterator();
                            while (it6.hasNext()) {
                                ((BluetoothProfileCallback) it6.next()).onVendorSpecificHeadsetEvent(bluetoothDevice6, stringExtra, intExtra10, objArr);
                            }
                            return;
                        }
                        ZLogger.v(bluetoothProfileManager.b, "no callback registered");
                        return;
                    }
                    ZLogger.v("onVendorSpecificHeadsetEvent() unknown command");
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a implements BluetoothProfile.ServiceListener {
        public a() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            ZLogger.d(String.format("%s(%s) profile connected", BluetoothHelper.parseProfile(i), bluetoothProfile.getClass().getName()));
            if (i != 11) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                BluetoothProfileManager.this.i = bluetoothProfile;
                                return;
                            }
                            return;
                        }
                        BluetoothProfileManager.this.h = (BluetoothHealth) bluetoothProfile;
                        return;
                    }
                    BluetoothProfileManager.this.g = (BluetoothA2dp) bluetoothProfile;
                    return;
                }
                BluetoothProfileManager.this.f = (BluetoothHeadset) bluetoothProfile;
                return;
            }
            BluetoothProfileManager.this.j = bluetoothProfile;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int i) {
            ZLogger.d(BluetoothHelper.parseProfile(i) + " profile disconnected");
            if (i == 1) {
                BluetoothProfileManager.this.f = null;
                return;
            }
            if (i == 2) {
                BluetoothProfileManager.this.g = null;
                return;
            }
            if (i == 3) {
                BluetoothProfileManager.this.h = null;
            } else if (i == 4) {
                BluetoothProfileManager.this.i = null;
            } else if (i == 11) {
                BluetoothProfileManager.this.j = null;
            }
        }
    }

    public BluetoothProfileManager(Context context) {
        this.f19480a = false;
        this.b = false;
        this.c = context.getApplicationContext();
        this.f19480a = RtkCore.DEBUG;
        this.b = RtkCore.VDBG;
        a();
    }

    public static BluetoothProfileManager getInstance() {
        return m;
    }

    public static void initial(Context context) {
        if (m == null) {
            synchronized (BluetoothProfileManager.class) {
                try {
                    if (m == null) {
                        m = new BluetoothProfileManager(context);
                    }
                } finally {
                }
            }
        }
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
        registerProfiles();
        this.k = new ProfileBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT");
        intentFilter.addAction(BluetoothInputDeviceImpl.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothA2dpSinkImpl.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothA2dpSinkImpl.ACTION_PLAYING_STATE_CHANGED);
        this.c.registerReceiver(this.k, intentFilter);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void addManagerCallback(BluetoothProfileCallback bluetoothProfileCallback) {
        if (bluetoothProfileCallback == null) {
            return;
        }
        if (this.d == null) {
            this.d = new CopyOnWriteArrayList();
        }
        if (!this.d.contains(bluetoothProfileCallback)) {
            this.d.add(bluetoothProfileCallback);
        }
        boolean z = this.b;
        StringBuilder a2 = com.realsil.sdk.core.a.a.a("mManagerCallbacks.size=");
        a2.append(this.d.size());
        ZLogger.v(z, a2.toString());
    }

    public void close() {
        if (this.f19480a) {
            ZLogger.v("close()");
        }
        Context context = this.c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.k);
            } catch (Exception e) {
                ZLogger.e(e.toString());
            }
        }
    }

    public void closeProfileProxy(int i) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            try {
                ZLogger.v(String.format(Locale.US, "profile=%d", Integer.valueOf(i)));
                if (i != 11) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    this.e.closeProfileProxy(i, this.i);
                                }
                            } else {
                                this.e.closeProfileProxy(i, this.h);
                            }
                        } else {
                            this.e.closeProfileProxy(i, this.g);
                        }
                    } else {
                        this.e.closeProfileProxy(i, this.f);
                    }
                } else {
                    this.e.closeProfileProxy(i, this.j);
                }
                return;
            } catch (Exception e) {
                ZLogger.e(e.toString());
                return;
            }
        }
        ZLogger.w("BT not enabled");
    }

    public boolean connectA2dpSink(byte[] bArr) {
        return connectA2dpSource(BluetoothHelper.convertMac(bArr));
    }

    public boolean connectA2dpSource(byte[] bArr) {
        return connectA2dpSource(BluetoothHelper.convertMac(bArr));
    }

    public boolean connectHfpAg(byte[] bArr) {
        return connectHfpAg(BluetoothHelper.convertMac(bArr));
    }

    public boolean connectHid(BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothProfileImpl.connectProfile(this.i, CLASS_NAME_BLUETOOTH_HID_HOST, bluetoothDevice);
        }
        return BluetoothProfileImpl.connectProfile(this.i, BluetoothInputDeviceImpl.CLASS_NAME, bluetoothDevice);
    }

    public boolean connectProfile(int i, BluetoothDevice bluetoothDevice) {
        if (i != 4) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothProfileImpl.connectProfile(this.i, CLASS_NAME_BLUETOOTH_HID_HOST, bluetoothDevice);
        }
        return BluetoothProfileImpl.connectProfile(this.i, BluetoothInputDeviceImpl.CLASS_NAME, bluetoothDevice);
    }

    public boolean disConnectHid(BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothProfileImpl.disconnect(this.i, CLASS_NAME_BLUETOOTH_HID_HOST, bluetoothDevice);
        }
        return BluetoothProfileImpl.disconnect(this.i, BluetoothInputDeviceImpl.CLASS_NAME, bluetoothDevice);
    }

    public boolean disconnectA2dpSink(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("device is null");
            return false;
        }
        BluetoothProfile bluetoothProfile = this.j;
        if (bluetoothProfile == null) {
            ZLogger.w("A2DP Sink not initialized");
            getProfileProxy(11);
            return false;
        }
        if (bluetoothProfile.getConnectionState(bluetoothDevice) != 2) {
            ZLogger.w("A2DP Sink already disconnected");
            return false;
        }
        return BluetoothProfileImpl.disconnect(this.j, BluetoothA2dpSinkImpl.CLASS_NAME, bluetoothDevice);
    }

    public boolean disconnectA2dpSource(byte[] bArr) {
        return disconnectA2dpSource(BluetoothHelper.convertMac(bArr));
    }

    public boolean disconnectHfp(byte[] bArr) {
        return disconnectHfp(BluetoothHelper.convertMac(bArr));
    }

    public boolean disconnectProfile(int i, BluetoothDevice bluetoothDevice) {
        if (i != 4) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothProfileImpl.disconnect(this.i, CLASS_NAME_BLUETOOTH_HID_HOST, bluetoothDevice);
        }
        return BluetoothProfileImpl.disconnect(this.i, BluetoothInputDeviceImpl.CLASS_NAME, bluetoothDevice);
    }

    public List<BluetoothDevice> getConnectedDevices(int i) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 11) {
                            BluetoothProfile bluetoothProfile = this.j;
                            if (bluetoothProfile != null) {
                                return BluetoothProfileImpl.getConnectedDevices(bluetoothProfile, BluetoothA2dpSinkImpl.CLASS_NAME);
                            }
                            ZLogger.d("A2DP_SINK profile not connected");
                            getProfileProxy(11);
                        }
                    } else {
                        BluetoothProfile bluetoothProfile2 = this.i;
                        if (bluetoothProfile2 != null) {
                            if (Build.VERSION.SDK_INT >= 28) {
                                return BluetoothProfileImpl.getConnectedDevices(bluetoothProfile2, CLASS_NAME_BLUETOOTH_HID_HOST);
                            }
                            return BluetoothProfileImpl.getConnectedDevices(bluetoothProfile2, BluetoothInputDeviceImpl.CLASS_NAME);
                        }
                        ZLogger.d("HID_HOST profile not connected");
                        getProfileProxy(4);
                    }
                } else {
                    BluetoothA2dp bluetoothA2dp = this.g;
                    if (bluetoothA2dp != null) {
                        return bluetoothA2dp.getConnectedDevices();
                    }
                    ZLogger.d("A2DP profile not connected");
                    getProfileProxy(2);
                }
            } else {
                BluetoothHeadset bluetoothHeadset = this.f;
                if (bluetoothHeadset != null) {
                    return bluetoothHeadset.getConnectedDevices();
                }
                ZLogger.d("HEADSET profile not connected");
                getProfileProxy(1);
            }
            return new ArrayList();
        }
        ZLogger.w("BT not enabled");
        return new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getConnectionState(int r5, android.bluetooth.BluetoothDevice r6) {
        /*
            r4 = this;
            android.bluetooth.BluetoothAdapter r0 = r4.e
            if (r0 == 0) goto L70
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto Lb
            goto L70
        Lb:
            r0 = 11
            r1 = 4
            r2 = 2
            r3 = 1
            if (r5 == r3) goto L19
            if (r5 == r2) goto L2a
            if (r5 == r1) goto L3b
            if (r5 == r0) goto L5b
            goto L6e
        L19:
            android.bluetooth.BluetoothHeadset r5 = r4.f
            if (r5 == 0) goto L22
            int r5 = r5.getConnectionState(r6)
            return r5
        L22:
            java.lang.String r5 = "HEADSET profile not connected"
            com.realsil.sdk.core.logger.ZLogger.d(r5)
            r4.getProfileProxy(r3)
        L2a:
            android.bluetooth.BluetoothA2dp r5 = r4.g
            if (r5 == 0) goto L33
            int r5 = r5.getConnectionState(r6)
            return r5
        L33:
            java.lang.String r5 = "A2DP profile not connected"
            com.realsil.sdk.core.logger.ZLogger.d(r5)
            r4.getProfileProxy(r2)
        L3b:
            android.bluetooth.BluetoothProfile r5 = r4.i
            if (r5 == 0) goto L53
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L4c
            java.lang.String r0 = "android.bluetooth.BluetoothHidHost"
            int r5 = com.realsil.sdk.core.bluetooth.impl.BluetoothProfileImpl.getConnectionState(r5, r0, r6)
            return r5
        L4c:
            java.lang.String r0 = "android.bluetooth.BluetoothInputDevice"
            int r5 = com.realsil.sdk.core.bluetooth.impl.BluetoothProfileImpl.getConnectionState(r5, r0, r6)
            return r5
        L53:
            java.lang.String r5 = "HID_HOST profile not connected"
            com.realsil.sdk.core.logger.ZLogger.d(r5)
            r4.getProfileProxy(r1)
        L5b:
            android.bluetooth.BluetoothProfile r5 = r4.j
            if (r5 == 0) goto L66
            java.lang.String r0 = "android.bluetooth.BluetoothA2dpSink"
            int r5 = com.realsil.sdk.core.bluetooth.impl.BluetoothProfileImpl.getConnectionState(r5, r0, r6)
            return r5
        L66:
            java.lang.String r5 = "A2DP_SINK profile not connected"
            com.realsil.sdk.core.logger.ZLogger.d(r5)
            r4.getProfileProxy(r0)
        L6e:
            r5 = 0
            return r5
        L70:
            java.lang.String r5 = "BT not enabled"
            com.realsil.sdk.core.logger.ZLogger.d(r5)
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getConnectionState(int, android.bluetooth.BluetoothDevice):int");
    }

    public BluetoothProfile getProfile(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 11) {
                        return null;
                    }
                    return this.j;
                }
                return this.i;
            }
            return this.g;
        }
        return this.f;
    }

    public boolean getProfileProxy(int i) {
        try {
            if (this.e.getProfileProxy(this.c, this.l, i)) {
                if (this.b) {
                    ZLogger.v(String.format(Locale.US, "getProfileProxy %d success", Integer.valueOf(i)));
                }
                return true;
            }
            ZLogger.w(String.format(Locale.US, "getProfileProxy %d failed", Integer.valueOf(i)));
            return false;
        } catch (Exception e) {
            ZLogger.w(String.format(Locale.US, "getProfileProxy %d exception: %s", Integer.valueOf(i), e.toString()));
            return false;
        }
    }

    public int getProfileState(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            if (bluetoothProfile == null) {
                ZLogger.d("profile is not supported");
                return -1;
            }
            return bluetoothProfile.getConnectionState(bluetoothDevice);
        }
        ZLogger.w("BT not enabled");
        return -1;
    }

    public boolean isConnectionFeatureSupported(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    if (!BluetoothProfileImpl.isConnectMethodSupported(this.i, CLASS_NAME_BLUETOOTH_HID_HOST) || !BluetoothProfileImpl.isDisConnectMethodSupported(this.i, CLASS_NAME_BLUETOOTH_HID_HOST)) {
                        return false;
                    }
                    return true;
                }
                if (!BluetoothProfileImpl.isConnectMethodSupported(this.i, BluetoothInputDeviceImpl.CLASS_NAME) || !BluetoothProfileImpl.isDisConnectMethodSupported(this.i, BluetoothInputDeviceImpl.CLASS_NAME)) {
                    return false;
                }
                return true;
            }
            if (!BluetoothProfileImpl.isConnectMethodSupported(this.g, BluetoothProfileImpl.CLASS_NAME_BLUETOOTH_A2DP) || !BluetoothProfileImpl.isDisConnectMethodSupported(this.g, BluetoothProfileImpl.CLASS_NAME_BLUETOOTH_A2DP)) {
                return false;
            }
            return true;
        }
        if (!BluetoothProfileImpl.isConnectMethodSupported(this.f, BluetoothHeadsetImpl.CLASS_NAME) || !BluetoothProfileImpl.isDisConnectMethodSupported(this.f, BluetoothHeadsetImpl.CLASS_NAME)) {
            return false;
        }
        return true;
    }

    public boolean isDeviceConnected(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.d("no activeBluetoothDevice exist");
            return false;
        }
        int connectionState = getInstance().getConnectionState(1, bluetoothDevice);
        int connectionState2 = getInstance().getConnectionState(2, bluetoothDevice);
        boolean isConnected = BluetoothDeviceImpl.isConnected(bluetoothDevice);
        ZLogger.v(String.format(Locale.US, "%s, connected=%b, hfpState= %d,a2dpState= %d", BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true), Boolean.valueOf(isConnected), Integer.valueOf(connectionState), Integer.valueOf(connectionState2)));
        if (isConnected || 2 == connectionState || 2 == connectionState2) {
            return true;
        }
        return false;
    }

    public boolean isProfileSupported(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 11 || this.j == null) {
                        return false;
                    }
                    return true;
                }
                if (this.i == null) {
                    return false;
                }
                return true;
            }
            if (this.g == null) {
                return false;
            }
            return true;
        }
        if (this.f == null) {
            return false;
        }
        return true;
    }

    public void registerProfiles() {
        if (this.e == null) {
            ZLogger.w("mBluetoothAdapter == null");
            return;
        }
        this.k = new ProfileBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        getProfileProxy(2);
        getProfileProxy(1);
        getProfileProxy(4);
        getProfileProxy(11);
        this.c.registerReceiver(this.k, intentFilter);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.realsil.sdk.core.bluetooth.BluetoothProfileCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void removeManagerCallback(BluetoothProfileCallback bluetoothProfileCallback) {
        ?? r0 = this.d;
        if (r0 != 0) {
            r0.remove(bluetoothProfileCallback);
        }
    }

    public boolean startScoUsingVirtualVoiceCall(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("can't find remote device.");
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f;
        if (bluetoothHeadset == null) {
            ZLogger.w("BluetoothHeadset service is not connected");
            getProfileProxy(1);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothHeadsetImpl.startScoUsingVirtualVoiceCall(bluetoothHeadset);
        }
        return BluetoothHeadsetImpl.startScoUsingVirtualVoiceCall(bluetoothHeadset, bluetoothDevice);
    }

    public boolean stopScoUsingVirtualVoiceCall(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("can't find remote device.");
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f;
        if (bluetoothHeadset == null) {
            ZLogger.w("BluetoothHeadset service is not connected");
            getProfileProxy(1);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return BluetoothHeadsetImpl.stopScoUsingVirtualVoiceCall(bluetoothHeadset);
        }
        return BluetoothHeadsetImpl.stopScoUsingVirtualVoiceCall(bluetoothHeadset, bluetoothDevice);
    }

    public boolean connectA2dpSink(String str) {
        return connectA2dpSink(a(str));
    }

    public boolean connectA2dpSource(String str) {
        return connectA2dpSource(a(str));
    }

    public boolean connectHfpAg(String str) {
        BluetoothDevice remoteDevice = this.e.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f;
        if (bluetoothHeadset == null) {
            ZLogger.w("BluetoothHeadset service is not connected");
            getProfileProxy(1);
            return false;
        }
        if (bluetoothHeadset.getConnectionState(remoteDevice) == 2) {
            ZLogger.w("BluetoothHeadset profile is already connected");
            return true;
        }
        return BluetoothProfileImpl.connectProfile(this.f, remoteDevice);
    }

    public boolean disconnectA2dpSource(String str) {
        return disconnectA2dpSource(a(str));
    }

    public boolean disconnectHfp(String str) {
        BluetoothDevice remoteDevice = this.e.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f;
        if (bluetoothHeadset == null) {
            ZLogger.w("BluetoothHeadset service is not connected");
            getProfileProxy(1);
            return false;
        }
        if (bluetoothHeadset.getConnectionState(remoteDevice) != 2) {
            ZLogger.w("BluetoothHeadset profile is not connected");
            return false;
        }
        return BluetoothProfileImpl.disconnect(this.f, remoteDevice);
    }

    public boolean connectA2dpSink(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("can't find remote device.");
            return false;
        }
        BluetoothProfile bluetoothProfile = this.j;
        if (bluetoothProfile == null) {
            ZLogger.w("A2DP Sink not initialized");
            getProfileProxy(11);
            return false;
        }
        if (bluetoothProfile.getConnectionState(bluetoothDevice) == 2) {
            ZLogger.w("A2DP Sink already connected");
            return true;
        }
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return BluetoothProfileImpl.connectProfile(this.j, BluetoothA2dpSinkImpl.CLASS_NAME, bluetoothDevice);
        }
        ZLogger.d("BT not enabled");
        return false;
    }

    public boolean connectA2dpSource(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("can't find remote device.");
            return false;
        }
        BluetoothA2dp bluetoothA2dp = this.g;
        if (bluetoothA2dp == null) {
            ZLogger.w("A2DP not initialized");
            getProfileProxy(2);
            return false;
        }
        if (bluetoothA2dp.getConnectionState(bluetoothDevice) == 2) {
            ZLogger.w("a2dp already connected");
            return true;
        }
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            if (!BluetoothProfileImpl.setPriority(this.g, bluetoothDevice, 100)) {
                ZLogger.v(this.f19480a, "setPriority failed");
            }
            return BluetoothProfileImpl.connectProfile(this.g, bluetoothDevice);
        }
        ZLogger.w("BT not enabled");
        return false;
    }

    public boolean disconnectA2dpSource(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            ZLogger.w("device is null");
            return false;
        }
        BluetoothA2dp bluetoothA2dp = this.g;
        if (bluetoothA2dp == null) {
            ZLogger.w("A2DP not initialized");
            getProfileProxy(2);
            return false;
        }
        if (bluetoothA2dp.getConnectionState(bluetoothDevice) != 2) {
            ZLogger.w("A2DP already disconnected");
            return false;
        }
        if (!BluetoothProfileImpl.setPriority(this.g, bluetoothDevice, 100)) {
            ZLogger.v(this.f19480a, "setPriority failed");
        }
        return BluetoothProfileImpl.disconnect(this.g, bluetoothDevice);
    }

    public final BluetoothDevice a(String str) {
        BluetoothAdapter bluetoothAdapter = this.e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return this.e.getRemoteDevice(str);
        }
        ZLogger.w("BT not enabled");
        return null;
    }
}
