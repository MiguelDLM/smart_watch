package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.impl.BleCharacteristicX;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.data.BleIntState;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes9.dex */
public class CharacteristicWrite extends BleBaseProcedure implements GBGattProcedureWrite, IEventListener<BleIntState> {
    private static final String m = "CharacteristicWrite";

    /* renamed from: a, reason: collision with root package name */
    private BleCharacteristicX f16161a;
    private BluetoothGattCharacteristic b;
    private a c;
    private byte[] d;
    private byte[] g;
    private int h;
    private int i;
    private int e = 2;
    private InputStream f = null;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (((Task) CharacteristicWrite.this).taskState != 2) {
                return;
            }
            if (i == 0) {
                CharacteristicWrite.this.a();
                return;
            }
            if (i == 5 || i == 8 || i == 137) {
                CharacteristicWrite.this.finishedWithError("Insufficient Authentication");
                return;
            }
            String str = "Error on writing characteristic <" + bluetoothGattCharacteristic.getUuid() + ">: " + BleGattX.gattStatusToString(i);
            ILogger iLogger = ((Task) CharacteristicWrite.this).logger;
            if (iLogger != null) {
                iLogger.e(CharacteristicWrite.m, str);
            }
            CharacteristicWrite.this.finishedWithError(i, str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (((Task) CharacteristicWrite.this).taskState == 2 && i2 != 2) {
                CharacteristicWrite.this.finishedWithError("Failed to write characteristic. The connection has been lost.");
            }
        }
    }

    private int b() throws Throwable {
        if (this.f != null) {
            int mtu = this.gattX.getMtu() - 3;
            byte[] bArr = this.g;
            if (bArr == null || bArr.length != mtu) {
                this.g = new byte[mtu];
            }
            int read = this.f.read(this.g);
            if (read > 0) {
                byte[] bArr2 = this.d;
                if (bArr2 == null || bArr2.length != read) {
                    this.d = new byte[read];
                }
                System.arraycopy(this.g, 0, this.d, 0, read);
                this.h += read;
                return read;
            }
        }
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        if (this.f16161a == null) {
            finishedWithError("Target characteristic is null.");
            return 0;
        }
        if (!this.gattX.isConnected()) {
            finishedWithError("Failed to write characteristic. The connection is not established.");
            return 0;
        }
        BluetoothGattCharacteristic gattCharacteristic = this.f16161a.getGattCharacteristic();
        this.b = gattCharacteristic;
        if (gattCharacteristic == null) {
            finishedWithError("Target characteristic is not discovered.");
            return 0;
        }
        if ((gattCharacteristic.getProperties() & 12) == 0) {
            finishedWithError("Target characteristic is not writable.");
            return 0;
        }
        this.k = false;
        this.h = 0;
        InputStream inputStream = this.f;
        if (inputStream != null) {
            try {
                this.i = inputStream.available();
                b();
            } catch (Throwable th) {
                this.i = 0;
                finishedWithError("Failed to load data stream: " + th.getMessage(), th);
                return 0;
            }
        }
        if (this.d == null) {
            finishedWithError("Value is null.");
            return 0;
        }
        a aVar = new a();
        this.c = aVar;
        this.gattX.register(aVar);
        if (!this.gattX.isConnected()) {
            finishedWithError("Failed to write characteristic. The connection is not established.");
            return 0;
        }
        this.b.setValue(this.d);
        this.b.setWriteType(this.e);
        if (!this.gattX.tryWriteCharacteristic(this.b)) {
            finishedWithError("Failed to write characteristic.");
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ErrorCode.MSP_ERROR_HTTP_BASE;
        }
        this.gattX.evtBondStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
        return ErrorCode.MSP_ERROR_HTTP_BASE;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        InputStream inputStream;
        BleGattX bleGattX = this.gattX;
        if (bleGattX != null) {
            bleGattX.evtBondStateChanged().clear(this);
            a aVar = this.c;
            if (aVar != null) {
                this.gattX.remove(aVar);
            }
        }
        if (this.j && (inputStream = this.f) != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                ILogger iLogger = this.logger;
                if (iLogger != null) {
                    iLogger.e(getName(), "Failed to close stream: " + e.getMessage(), e);
                }
            }
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, BleIntState bleIntState) {
        if (bleIntState.state == 12) {
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.v(m, "Retry to write characteristic after bonded");
            }
            if (this.gattX.tryWriteCharacteristic(this.f16161a.getGattCharacteristic())) {
                return;
            }
            finishedWithError("Failed to write characteristic after bonded.");
        }
    }

    public void setFlowCtrl(boolean z) {
        boolean z2;
        synchronized (this) {
            try {
                z2 = false;
                if (this.k != z) {
                    this.k = z;
                    if (!z && this.l) {
                        this.l = false;
                        z2 = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            getExecutor().execute(new Runnable() { // from class: com.goodix.ble.libble.v2.impl.procedure.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    CharacteristicWrite.this.a();
                }
            });
        }
    }

    public void setLargeValue(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        if (i < 0 && (i = i + bArr.length) < 0) {
            i = 0;
        }
        if (i2 < 0 || i2 > bArr.length) {
            i2 = bArr.length;
        }
        setValue(new ByteArrayInputStream(bArr, i, i2), true);
    }

    public void setTargetCharacteristic(BleCharacteristicX bleCharacteristicX) {
        this.f16161a = bleCharacteristicX;
    }

    public void setValue(InputStream inputStream, boolean z) {
        this.d = null;
        this.f = inputStream;
        this.j = z;
    }

    public void setWriteType(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.k) {
            synchronized (this) {
                try {
                    if (this.k) {
                        this.l = true;
                        return;
                    }
                } finally {
                }
            }
        }
        try {
            if (b() <= 0) {
                finishedWithDone();
                return;
            }
            this.b.setValue(this.d);
            if (!this.gattX.tryWriteCharacteristic(this.b)) {
                finishedWithError("Failed to write next segment of data stream.");
                return;
            }
            int i = this.i;
            if (i > 0) {
                publishProgress((this.h * 100) / i);
            }
            refreshTaskTimeout();
        } catch (Throwable th) {
            finishedWithError("Failed to read data stream: " + th.getMessage(), th);
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite
    public void setValue(byte[] bArr) {
        this.d = bArr;
        this.f = null;
    }
}
