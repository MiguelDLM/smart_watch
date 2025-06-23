package com.realsil.sdk.core.bluetooth.connection;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Locale;

/* loaded from: classes11.dex */
public class BluetoothClient {
    public static final int STATE_BONDING = 5;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;
    public static final int STATE_LISTEN = 4;
    public static final int STATE_NONE = 0;

    @Keep
    public BluetoothAdapter mBluetoothAdapter;

    @Keep
    public BluetoothManager mBluetoothManager;

    @Keep
    public BluetoothClientCallback mCallback;

    @Keep
    public Context mContext;

    @Keep
    public boolean DBG = false;

    @Keep
    public boolean VDBG = false;

    @Keep
    public BluetoothDevice mDevice = null;

    @Keep
    public int mBondState = 10;

    /* renamed from: a, reason: collision with root package name */
    public int f19486a = 0;

    public final BluetoothDevice a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            ZLogger.w("mBluetoothAdapter == null");
            return null;
        }
        try {
            return bluetoothAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }

    public synchronized void destroy() {
        try {
            if (this.DBG) {
                ZLogger.d("destroy()");
            }
            this.mCallback = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void dispatchDataReceived(byte[] bArr) {
        BluetoothClientCallback bluetoothClientCallback = this.mCallback;
        if (bluetoothClientCallback != null) {
            bluetoothClientCallback.onDataReceive(this, bArr);
        }
    }

    public void dispatchError(int i) {
        BluetoothClientCallback bluetoothClientCallback = this.mCallback;
        if (bluetoothClientCallback != null) {
            bluetoothClientCallback.onError(i);
        }
    }

    public int getConnectionState() {
        return this.f19486a;
    }

    public Context getContext() {
        return this.mContext;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public boolean isConnected() {
        return false;
    }

    public synchronized void updateConnectionState(int i) {
        try {
            int i2 = this.f19486a;
            if (i != i2) {
                ZLogger.v(String.format(Locale.US, "connection sate changed: %d -> %d", Integer.valueOf(i2), Integer.valueOf(i)));
            }
            this.f19486a = i;
            BluetoothClientCallback bluetoothClientCallback = this.mCallback;
            if (bluetoothClientCallback != null) {
                bluetoothClientCallback.onConnectionStateChanged(this, true, i);
            } else {
                ZLogger.v("no channel callback");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isConnected(BluetoothDevice bluetoothDevice) {
        BluetoothDevice bluetoothDevice2 = this.mDevice;
        if (bluetoothDevice2 == null || !bluetoothDevice2.equals(bluetoothDevice)) {
            return false;
        }
        return isConnected();
    }
}
