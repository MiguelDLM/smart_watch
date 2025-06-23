package com.realsil.sdk.dfu.l;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.l.c;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public abstract class e extends d {
    public UUID O;
    public BluetoothGattService P;
    public BluetoothGattCharacteristic Q;
    public BluetoothGattCharacteristic R;
    public BluetoothGattCharacteristic S;
    public UUID T;
    public UUID U;
    public UUID V;
    public BluetoothGattService W;
    public BluetoothGattCharacteristic X;
    public BluetoothGattCharacteristic Y;
    public BluetoothGattCharacteristic Z;

    public e(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.O = o.c;
        this.T = o.e;
        this.U = o.f;
        this.V = o.g;
    }

    public int a(String str, BluetoothGattCallback bluetoothGattCallback) {
        BluetoothGatt connectGatt;
        BluetoothDevice b = b(str);
        if (b == null) {
            return 264;
        }
        setConnectionState(256);
        this.mErrorState = 0;
        this.isConnectedCallbackCome = false;
        if (this.DBG) {
            ZLogger.v(String.format("Connecting to device:%s, isConnectedCallbackCome=%b", BluetoothHelper.formatAddress(str, true), Boolean.valueOf(this.isConnectedCallbackCome)));
        }
        GlobalGatt globalGatt = this.G;
        if (globalGatt != null) {
            globalGatt.unRegisterCallback(str, bluetoothGattCallback);
            this.G.connect(str, bluetoothGattCallback);
            connectGatt = this.G.getBluetoothGatt(str);
            this.H = connectGatt;
        } else {
            connectGatt = b.connectGatt(this.mContext, false, bluetoothGattCallback);
            this.H = connectGatt;
        }
        synchronized (this.mConnectionLock) {
            try {
                if (this.VDBG) {
                    ZLogger.v(String.format("isConnectedCallbackCome=%b, mErrorState=0x%04X", Boolean.valueOf(this.isConnectedCallbackCome), Integer.valueOf(this.mErrorState)));
                }
                if (!this.isConnectedCallbackCome && this.mErrorState == 0) {
                    if (this.DBG) {
                        ZLogger.d("wait for connect gatt for " + getDfuConfig().getConnectionTimeout() + " ms");
                    }
                    try {
                        this.mConnectionLock.wait(getDfuConfig().getConnectionTimeout());
                    } catch (InterruptedException e) {
                        ZLogger.d("connect interrupted : " + e.toString());
                        this.mErrorState = 259;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.mErrorState == 0) {
            if (!this.isConnectedCallbackCome) {
                ZLogger.w("wait for connect, but can not connect with no callback");
                this.mErrorState = 260;
            } else if (connectGatt == null || this.mConnectionState != 515) {
                ZLogger.w("connect with some error, please check. mConnectionState=" + this.mConnectionState);
                this.mErrorState = 264;
            }
        }
        if (this.mErrorState == 0 && this.VDBG) {
            ZLogger.v("connected the device which going to upgrade");
        }
        return this.mErrorState;
    }

    public void c(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.T);
        this.W = service;
        if (service == null) {
            ZLogger.w("DFU_SERVICE not found:" + this.T);
            return;
        }
        if (this.DBG) {
            ZLogger.d("find DFU_SERVICE: " + this.T.toString());
        }
        BluetoothGattCharacteristic characteristic = this.W.getCharacteristic(this.V);
        this.X = characteristic;
        if (characteristic == null) {
            ZLogger.d("not found DFU_CONTROL_POINT_UUID: " + this.V.toString());
            return;
        }
        if (this.DBG) {
            ZLogger.d("find DFU_CONTROL_POINT_UUID: " + this.V.toString());
        }
        this.X.setWriteType(2);
        ZLogger.d(BluetoothGattImpl.parseProperty2(this.X.getProperties()));
        BluetoothGattCharacteristic characteristic2 = this.W.getCharacteristic(this.U);
        this.Y = characteristic2;
        if (characteristic2 == null) {
            ZLogger.w("not found DFU_DATA_UUID: " + this.U.toString());
            return;
        }
        if (this.DBG) {
            ZLogger.d("find DFU_DATA_UUID: " + this.U.toString());
        }
        this.Y.setWriteType(1);
        ZLogger.d(BluetoothGattImpl.parseProperty2(this.Y.getProperties()));
    }

    public int d(BluetoothGatt bluetoothGatt) {
        UUID uuid = g.f19557a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            if (this.DBG) {
                ZLogger.d("DEVICE_INFORMATION_SERVICE not found:" + uuid);
                return 262;
            }
            return 262;
        }
        if (this.VDBG) {
            ZLogger.v("find DEVICE_INFORMATION_SERVICE: " + uuid.toString());
        }
        UUID uuid2 = g.e;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.Z = characteristic;
        if (characteristic == null) {
            ZLogger.d("DIS_PNP_ID_CHARACTERISTIC not found:" + uuid2);
            return 263;
        }
        if (this.DBG) {
            ZLogger.d("find DIS_PNP_ID_CHARACTERISTIC: " + uuid2.toString());
            return 0;
        }
        return 0;
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.O);
        this.P = service;
        if (service == null) {
            ZLogger.w("OTA_SERVICE not found: " + this.O.toString());
            return false;
        }
        if (this.DBG) {
            ZLogger.d("find OTA_SERVICE: " + this.O.toString());
        }
        BluetoothGattService bluetoothGattService = this.P;
        UUID uuid = com.realsil.sdk.dfu.q.h.f19594a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.Q = characteristic;
        if (characteristic == null) {
            ZLogger.d("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found: " + uuid);
        } else {
            if (this.VDBG) {
                ZLogger.v("find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
                ZLogger.v(BluetoothGattImpl.parseProperty2(this.Q.getProperties()));
            }
            this.Q.setWriteType(1);
        }
        BluetoothGattService bluetoothGattService2 = this.P;
        UUID uuid2 = com.realsil.sdk.dfu.q.h.b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.S = characteristic2;
        if (characteristic2 == null) {
            ZLogger.d("OTA_MAC_ADDR_CHARACTERISTIC_UUID not found:" + uuid2);
        } else if (this.VDBG) {
            ZLogger.v("find OTA_MAC_ADDR_CHARACTERISTIC_UUID = " + uuid2);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.Q.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.P;
        UUID uuid3 = com.realsil.sdk.dfu.q.h.g;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.R = characteristic3;
        if (characteristic3 == null) {
            ZLogger.d("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found:" + uuid3);
        } else if (this.VDBG) {
            ZLogger.v("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID: " + uuid3);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.R.getProperties()));
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.l.d, com.realsil.sdk.dfu.j.b, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        u();
        this.initialized = true;
    }

    public int t() throws DfuException {
        if (this.W != null) {
            if (this.X != null) {
                if (this.Y != null) {
                    if (this.VDBG) {
                        ZLogger.v("find DFU_CONTROL_POINT_UUID: " + this.V.toString());
                        ZLogger.v("find DFU_DATA_UUID: " + this.U.toString());
                        return 0;
                    }
                    return 0;
                }
                ZLogger.w("not found DFU_DATA_UUID :" + this.U.toString());
                throw new OtaException("load dfu service failed", 263);
            }
            ZLogger.w("not found DFU_CONTROL_POINT_UUID : " + this.V.toString());
            throw new OtaException("load dfu service failed", 263);
        }
        ZLogger.w("DFU_SERVICE not found:" + this.T.toString());
        throw new OtaException("load dfu service failed", 262);
    }

    public void u() {
        try {
            this.O = UUID.fromString(getDfuConfig().getOtaServiceUuid());
            this.T = UUID.fromString(getDfuConfig().getDfuServiceUuid());
            this.U = UUID.fromString(getDfuConfig().getDfuDataUuid());
            this.V = UUID.fromString(getDfuConfig().getDfuControlPointUuid());
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void v() throws DfuException {
        a(this.H, this.X, true);
    }

    public boolean w() throws DfuException {
        if (!a()) {
            a(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        }
        if (getOtaDeviceInfo().isAesEncryptEnabled() && !b()) {
            b(4113);
            return false;
        }
        notifyStateChanged(521);
        ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        if (this.VDBG) {
            ZLogger.v(getDfuProgressInfo().toString());
        }
        v();
        if (Build.VERSION.SDK_INT >= 23) {
            a(this.H, 256);
        }
        r();
        return true;
    }

    public void a(byte b) throws DfuException {
        if (!this.mAborted) {
            byte[] bArr = new byte[8];
            ConnectionParameters connectionParameters = getDfuConfig().getConnectionParameters();
            if (connectionParameters != null) {
                bArr[0] = (byte) (connectionParameters.getMinInterval() & 255);
                bArr[1] = (byte) ((connectionParameters.getMinInterval() >> 8) & 255);
                bArr[2] = (byte) (connectionParameters.getMaxInterval() & 255);
                bArr[3] = (byte) ((connectionParameters.getMaxInterval() >> 8) & 255);
                bArr[4] = (byte) (connectionParameters.getLatency() & 255);
                bArr[5] = (byte) ((connectionParameters.getLatency() >> 8) & 255);
                bArr[6] = (byte) (connectionParameters.getTimeout() & 255);
                bArr[7] = (byte) ((connectionParameters.getTimeout() >> 8) & 255);
            }
            c a2 = new c.b().a(b).a(bArr).a();
            a(this.X, a2.a(), false);
            ZLogger.d(this.DBG, a2.toString());
            try {
                ZLogger.v(this.VDBG, "... waiting updateConnectionParameters response");
                q();
                return;
            } catch (DfuException e) {
                ZLogger.w("ignore connection parameters update exception: " + e.getMessage());
                this.mErrorState = 0;
                return;
            }
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean a(BaseBinInputStream baseBinInputStream, int i, int i2) {
        ZLogger.v(this.DBG, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(baseBinInputStream.remainSizeInBytes()), Integer.valueOf(i), Integer.valueOf(i2)));
        return baseBinInputStream.remainSizeInBytes() + i > i2;
    }

    public boolean a(byte[] bArr) throws DfuException {
        boolean z;
        if (!this.mAborted) {
            if (this.Q == null) {
                return false;
            }
            notifyStateChanged(518);
            ZLogger.d(this.DBG, "<< enable device to enter OTA mode");
            try {
                z = a(this.Q, bArr, false);
            } catch (DfuException e) {
                boolean z2 = e.getErrCode() != 267;
                ZLogger.d("<< enter ota mode failed, ignore it: " + e.getMessage());
                this.mErrorState = 0;
                z = z2;
            }
            sleepInner(1000L);
            if (z && getDfuConfig().isWaitDisconnectWhenEnterOtaMode()) {
                waitUntilDisconnected();
            }
            a(this.H);
            return z;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }
}
