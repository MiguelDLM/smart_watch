package com.baidu.navisdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class BNBluetoothReceiver extends BroadcastReceiver {
    private static String b = b.h;

    /* renamed from: a, reason: collision with root package name */
    private c f6673a;

    public void a(c cVar) {
        this.f6673a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        c cVar;
        String action = intent.getAction();
        LogUtil.e(b, "onReceive action = " + action);
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            if (intExtra != 0) {
                if (intExtra != 1) {
                    if (intExtra == 2) {
                        LogUtil.e(b, "BluetoothProfile is STATE_CONNECTED");
                        c cVar2 = this.f6673a;
                        if (cVar2 != null) {
                            cVar2.a(true, a(intent));
                            return;
                        }
                        return;
                    }
                    return;
                }
                LogUtil.e(b, "BluetoothProfile is STATE_CONNECTING");
                return;
            }
            LogUtil.e(b, "BluetoothProfile is STATE_DISCONNECTED");
            c cVar3 = this.f6673a;
            if (cVar3 != null) {
                cVar3.a(true);
                return;
            }
            return;
        }
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
            LogUtil.e(b, "BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED: remote state = " + intExtra2);
            if (intExtra2 != 0) {
                if (intExtra2 != 1) {
                    if (intExtra2 == 2) {
                        LogUtil.e(b, "BluetoothAdapter is STATE_CONNECTED");
                        c cVar4 = this.f6673a;
                        if (cVar4 != null) {
                            cVar4.a(false, a(intent));
                            return;
                        }
                        return;
                    }
                    return;
                }
                LogUtil.e(b, "BluetoothAdapter is STATE_CONNECTING");
                return;
            }
            LogUtil.e(b, "BluetoothAdapter is STATE_DISCONNECTED");
            c cVar5 = this.f6673a;
            if (cVar5 != null) {
                cVar5.a(false);
                return;
            }
            return;
        }
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10)) {
                case 10:
                    LogUtil.e(b, "BluetoothAdapter is STATE_OFF");
                    c cVar6 = this.f6673a;
                    if (cVar6 != null) {
                        cVar6.a();
                        return;
                    }
                    return;
                case 11:
                    LogUtil.e(b, "BluetoothAdapter is STATE_TURNING_ON");
                    return;
                case 12:
                    LogUtil.e(b, "BluetoothAdapter is STATE_ON");
                    c cVar7 = this.f6673a;
                    if (cVar7 != null) {
                        cVar7.b();
                        return;
                    }
                    return;
                case 13:
                    LogUtil.e(b, "BluetoothAdapter is STATE_TURNING_OFF");
                    return;
                default:
                    return;
            }
        }
        if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(action)) {
            int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            LogUtil.e(b, "BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED BluetoothProfile.EXTRA_STATE state = " + intExtra3);
            switch (intExtra3) {
                case 10:
                    LogUtil.e(b, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_DISCONNECTED");
                    c cVar8 = this.f6673a;
                    if (cVar8 != null) {
                        cVar8.c();
                        return;
                    }
                    return;
                case 11:
                    LogUtil.e(b, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTING");
                    return;
                case 12:
                    LogUtil.e(b, "BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED is BluetoothHeadset.STATE_AUDIO_CONNECTED");
                    return;
                default:
                    return;
            }
        }
        if ("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED".equals(action) && (extras = intent.getExtras()) != null) {
            Log.e(b, "onReceive bundle = " + extras);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) extras.getParcelable("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && (cVar = this.f6673a) != null) {
                cVar.a(bluetoothDevice.getName());
            }
        }
    }

    private String a(Intent intent) {
        BluetoothDevice bluetoothDevice;
        return (intent == null || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) ? "" : bluetoothDevice.getName();
    }
}
